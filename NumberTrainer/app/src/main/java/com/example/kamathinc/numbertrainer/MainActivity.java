package com.example.kamathinc.numbertrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView problemText;
    ArrayList<Integer> answers = new ArrayList<Integer>();

    public void gameStart(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.goButton);
        problemText = findViewById(R.id.problemText);

        Random random = new Random();

        int a = random.nextInt(26);
        int b = random.nextInt(26);

        problemText.setText(Integer.toString(a) + "+" + Integer.toString(b));
    }
}
