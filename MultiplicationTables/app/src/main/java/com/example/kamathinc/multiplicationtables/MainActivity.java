package com.example.kamathinc.multiplicationtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tablesListView;

    public void generateTable(int tableNumber) {
        ArrayList<String> tableContent = new ArrayList<String>();

        for (int iter = 1; iter <= 10; iter++) {
            tableContent.add(Integer.toString(iter * tableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, tableContent);
        tablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar tablesSeekBar = findViewById(R.id.tablesSeekBar);
        tablesListView = findViewById(R.id.tablesListView);

        int max = 20;
        int startingPosition = 7;

        tablesSeekBar.setMax(max); //max tables is now 20. i.e. seekbar can hit max of 20
        tablesSeekBar.setProgress(startingPosition);

        generateTable(startingPosition);
        tablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tablesNumber;

                //Setting the number
                if (i < min) {
                    tablesNumber = min;
                    tablesSeekBar.setProgress(min);
                } else {
                    tablesNumber = i;
                }

                Log.i("Seekbar Value: ", Integer.toString(tablesNumber));


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


