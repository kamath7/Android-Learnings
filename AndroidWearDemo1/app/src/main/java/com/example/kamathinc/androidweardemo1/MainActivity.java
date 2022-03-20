package com.example.kamathinc.androidweardemo1;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.support.annotation.RequiresApi;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
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

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel notificationChannel = new NotificationChannel("default", "test",NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(notificationChannel);

        Intent intent1 = new Intent(this, MainActivity.class );
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification.Builder builder = new Notification.Builder(this, "default").setContentTitle("HellO!").setContentText("Is this a great text").setSmallIcon(android.R.drawable.arrow_down_float).setContentIntent(pendingIntent);
        // Enables Always-on
        notificationManager.notify(0, builder.build());
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
