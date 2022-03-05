package com.example.kamathinc.mynewsreader;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> newsTitles = new ArrayList<String>();
    ArrayList<String> newUrls = new ArrayList<String>();

    ArrayAdapter arrayAdapter;

    SQLiteDatabase articleStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleStorage = this.openOrCreateDatabase("Articles", Context.MODE_PRIVATE, null);
        articleStorage.execSQL("CREATE TABLE IF NOT EXISTS articles (id INTEGER PRIMARY KEY, articleId INTEGER, articleTitle VARCHAR, articleURL VARCHAR) ");




        DownloadTask downloadTask = new DownloadTask();
        try{
//            downloadTask.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
        }catch(Exception e){
            e.printStackTrace();
        }
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, newsTitles);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NewsReadActivity.class);
                intent.putExtra("url",newUrls.get(position));
                startActivity(intent);
            }
        });
        updateListView();


    }

    public void updateListView(){

        Cursor c = articleStorage.rawQuery("SELECT * FROM articles", null);

        int urlIndex = c.getColumnIndex("articleURL");
        int titleIndex = c.getColumnIndex("articleTitle");

        if(c.moveToFirst()){
            newsTitles.clear();
            newUrls.clear();

            do{
                newsTitles.add(c.getString(titleIndex));
                newUrls.add(c.getString(urlIndex));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();

        }
    }


    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection httpURLConnection = null;

            try{
                url = new URL(urls[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while(data != -1){
                    char current = (char)data;
                    result += current;
                    data = inputStreamReader.read();
                }

                JSONArray jsonArray = new JSONArray(result);
                int articleLimit = 5;

                if (jsonArray.length() < 5 ){
                    articleLimit = jsonArray.length();
                }
                articleStorage.execSQL("DELETE FROM articles"); //clearing
                for (int  i =0 ; i < articleLimit;  i++){
                    String articleId = jsonArray.getString(i);
                    url = new URL("https://hacker-news.firebaseio.com/v0/item/"+articleId+".json?print=pretty");
//                    Log.i("URL for Check", url.toString());
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    inputStream = httpURLConnection.getInputStream();
                    inputStreamReader = new InputStreamReader(inputStream);

                    data = inputStreamReader.read();
                    String articleInfo = "";
                    while(data != -1){
                        char current = (char)data;
                        articleInfo += current;
                        data = inputStreamReader.read();
                    }

//                    Log.i("Article Info", articleInfo);
                    JSONObject jsonObject = new JSONObject(articleInfo);


                        if (!jsonObject.isNull("title") && !jsonObject.isNull("url")) {
                            String articleTitle = jsonObject.getString("title");
                            String articleUrl = jsonObject.getString("url");
//Below is performance degrading. Using url instead
//                            url = new URL(articleUrl);
//                            httpURLConnection = (HttpURLConnection) url.openConnection();
//                            inputStream = httpURLConnection.getInputStream();
//                            inputStreamReader = new InputStreamReader(inputStream);
//                            data = inputStreamReader.read();
//
//                            String articleContent = "";
//                            while(data != -1){
//                                char current = (char)data;
//                                articleContent += current;
//                                data = inputStreamReader.read();
//                            }
////                            Log.i("HTML Contnet", articleContent);
////                        Log.i("Title and URL", articleTitle+" "+articleUrl);

                          String sqlQuery = "INSERT INTO articles (articleId, articleTitle, articleURL) VALUES(?,?,?)";
                            SQLiteStatement statement = articleStorage.compileStatement(sqlQuery);
                            statement.bindString(1, articleId);
                            statement.bindString(2, articleTitle);
                            statement.bindString(3, articleUrl);
                            statement.execute();
                    }
                }

//                Log.i("URL Content", result );
                return result;
            }catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            updateListView();
        }
    }
}
