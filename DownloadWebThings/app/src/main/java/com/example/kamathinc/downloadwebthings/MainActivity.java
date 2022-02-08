package com.example.kamathinc.downloadwebthings;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public class Downloader extends AsyncTask<String,Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.i("URL : ",strings[0]);
            return "Done!";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Downloader downloader = new Downloader();
        String result = null;
        try{
            result =  downloader.execute("http://zappycode.com").get();

        }
        catch(Exception e){
            Log.i("Error", "Error "+e.getStackTrace() );
        }

        Log.i("Result - ", result);
    }
}
