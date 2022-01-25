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

        int correctAnswerIndex = random.nextInt(4);

        for (int i = 0 ; i < 4 ; i ++){
            //Why 4? Because 4 answers
            if ( i == correctAnswerIndex){
                answers.add(a+b);
            }else{
                int wrongAnswer = random.nextInt(26);
                while(wrongAnswer == a+b){
                    wrongAnswer = random.nextInt(26);
                }
                answers.add(wrongAnswer);
            }

        }
    }
}
