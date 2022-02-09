package com.example.kamathinc.celebguesser;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> celebURLs = new ArrayList<String>();
    ArrayList<String> celebNames = new ArrayList<String>();

    

    public class Downloader extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {

            StringBuilder stringBuilder = new StringBuilder();
            URL url;
            HttpURLConnection  urlConnection = null;

            try{
                url = new URL(urls[0]);
                urlConnection =  (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                while(data != -1){
                    char curr = (char)data;
                    stringBuilder.append(curr);
                    data = inputStreamReader.read();
                }
            return stringBuilder.toString();

            }catch(Exception e){

                e.printStackTrace();

            }

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Downloader downloader = new Downloader();
        String result = null;
        try{

            result = downloader.execute("https://www.imdb.com/list/ls052283250").get();

            String[] spltResult = result.split("<div class=\"article listo\">");

            Pattern p = Pattern.compile("src=\"(.*?).jpg\"");
            Matcher m = p.matcher(result);
            while(m.find()){
                celebURLs.add(m.group(1)+".jpg");
            }
            Log.i("Some URL", "Message - "+celebURLs);
            p=Pattern.compile("<img alt=\"(.*?)\"");
            m=p.matcher(result);
            while(m.find()){
                celebNames.add(m.group(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

// Use https://www.imdb.com/list/ls052283250/