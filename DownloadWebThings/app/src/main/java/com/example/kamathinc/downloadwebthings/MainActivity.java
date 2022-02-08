package com.example.kamathinc.downloadwebthings;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public class Downloader extends AsyncTask<String,Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return "Done!";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Downloader downloader = new Downloader();
        downloader.execute("http://zappycode.com");
    }
}
