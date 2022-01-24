package com.example.kamathinc.multiplicationtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar tablesSeekBar = findViewById(R.id.tablesSeekBar);
        ListView tablesListView = findViewById(R.id.tablesListView);

        tablesSeekBar.setMax(20); //max tables is now 20. i.e. seekbar can hit max of 20
        tablesSeekBar.setProgress(7);

        tablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                
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
