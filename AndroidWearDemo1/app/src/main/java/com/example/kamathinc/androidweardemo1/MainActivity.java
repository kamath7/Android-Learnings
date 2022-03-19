package com.example.kamathinc.androidweardemo1;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);


        if(getResources().getConfiguration().isScreenRound()){
            Log.i("Android Wear info", "You are now using a round screen");
        }else{
            Log.i("Android Wear info","You are now using a screen other than round");
        }
        // Enables Always-on
        setAmbientEnabled();
    }
}
