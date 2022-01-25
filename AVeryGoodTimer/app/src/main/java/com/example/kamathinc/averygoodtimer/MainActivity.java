package com.example.kamathinc.averygoodtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timerSeekBar = findViewById(R.id.timerSeekBar);
        final TextView timerTextView = findViewById(R.id.timerTextView);

        int max = 600; //max 10 mins. 10 * 60

        timerSeekBar.setMax(max);
        timerSeekBar.setProgress(39);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int minutes = i / 60 ;
                int seconds = i - (minutes * 60);
                String secondsStr = Integer.toString(seconds);

                if (secondsStr.equals("0") ){
                    secondsStr = "00";
                }
                timerTextView.setText(Integer.toString(minutes)+ ":"+ secondsStr);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
