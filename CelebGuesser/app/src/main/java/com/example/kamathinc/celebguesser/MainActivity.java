package com.example.kamathinc.celebguesser;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class Downloader extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try{
                url = new URL(urls[0]);
                urlConnection =  (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                while(data != -1){
                    char curr = (char)data;
                    result += curr;
                    data = inputStreamReader.read();
                }
            return result;

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

            result = downloader.execute("https://www.imdb.com/list/ls052283250/").get();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

// Use https://www.imdb.com/list/ls052283250/