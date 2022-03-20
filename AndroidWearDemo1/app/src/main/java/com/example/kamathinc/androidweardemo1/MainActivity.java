package com.example.kamathinc.androidweardemo1;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    public void whichOri(View view){
        if(getResources().getConfiguration(). isScreenRound()){
//            Log.i("Android Wear info", "You are now using a round screen");
            Toast.makeText(getApplicationContext(), "You are using a round screen", Toast.LENGTH_SHORT).show();
        }else{
//            Log.i("Android Wear info","You are now using a screen other than round");
            Toast.makeText(getApplicationContext(), "You are using a screen other than round", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);


        if(getResources().getConfiguration(). isScreenRound()){
            Log.i("Android Wear info", "You are now using a round screen");
            Toast.makeText(getApplicationContext(), "You are using a round screen", Toast.LENGTH_SHORT).show();
        }else{
            Log.i("Android Wear info","You are now using a screen other than round");
            Toast.makeText(getApplicationContext(), "You are using a screen other than round", Toast.LENGTH_SHORT).show();
        }

        //Voice input

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, 0);

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            for (String result: results){
                Log.i("VOICE_LOG", result);
            }
        }
    }
}
