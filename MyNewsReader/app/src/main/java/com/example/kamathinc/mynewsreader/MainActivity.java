package com.example.kamathinc.mynewsreader;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> newsTitles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, newsTitles);

        listView.setAdapter(arrayAdapter);

        DownloadTask downloadTask = new DownloadTask();
        try{
            downloadTask.execute("https://hacker-news.firebaseio.com/v0/askstories.json?print=pretty");
        }catch(Exception e){
            e.printStackTrace();
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
                int articleLimit = 17;

                if (jsonArray.length() < 17 ){
                    articleLimit = jsonArray.length();
                }

                for (int  i =0 ; i < articleLimit;  i++){
                    String articleId = jsonArray.getString(i);
                    url = new URL("https://hacker-news.firebaseio.com/v0/item/"+articleId+".json?print=pretty");
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

                    Log.i("Article Info", articleInfo);
                }

//                Log.i("URL Content", result );
                return result;
            }catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }
}
