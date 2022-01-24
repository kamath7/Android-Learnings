package com.example.kamathinc.timersbeginner;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000){
            //duration of 10 secs with runs every second
          public void onTick(long timeTillDone){
            Log.i("Seconds left", String.valueOf(timeTillDone/1000));
          }
          public void onFinish(){
              Log.i("Done!", "Countdown completed");
          }
        }.start();

//        final Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Something ran","Second passed");
//                handler.postDelayed(this, 1000); //will be run after every second
//            }
//        };
//        handler.post(run);

    }
}
