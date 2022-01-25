package com.example.kamathinc.averygoodtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    SeekBar timerSeekBar;
    Boolean activeTimer = false;
    Button timerButton;
    CountDownTimer countDownTimer;


    public void resetTimer() {
        timerTextView.setText("0:39");
        timerSeekBar.setProgress(39);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        timerButton.setText("GO");
        activeTimer = false;
    }

    public void buttonClicked(View view) {

        if (activeTimer) {
            resetTimer();
        } else {
            activeTimer = true;
            timerSeekBar.setEnabled(false);
            timerButton.setText("STOP");
            //max timer is user put time *  1000 .meaning 10 mins and interval of 1 second

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start();
                    resetTimer();

                }
            }.start();
        }

    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - (minutes * 60);
        String secondsStr = Integer.toString(seconds);

        if (seconds <= 9) {
            secondsStr = "0" + secondsStr;
        }
        timerTextView.setText(Integer.toString(minutes) + ":" + secondsStr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.timerTextView);
        timerButton = findViewById(R.id.timerButton);


        int max = 600; //max 10 mins. 10 * 60

        timerSeekBar.setMax(max);
        timerSeekBar.setProgress(39);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
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
