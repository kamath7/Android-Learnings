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
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView problemText;
    TextView resultText;
    TextView scoreText;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int correctAnswerIndex;
    int score = 0 ;
    int questionCount = 0;

    public void gameStart(View view) {
        startButton.setVisibility(View.INVISIBLE);
    }

    public void answerGen(View view){
        if (Integer.toString(correctAnswerIndex).equals(view.getTag().toString())){
            resultText.setText("Correct! 😎");
            score++;
        }else{
            resultText.setText("Incorrect! 😤");
        }
        questionCount++;

        scoreText.setText(Integer.toString(score)+"/"+Integer.toString(questionCount));
    }

    public void newQuestion(){
        Random random = new Random();

        int a = random.nextInt(26);
        int b = random.nextInt(26);

        problemText.setText(Integer.toString(a) + "+" + Integer.toString(b));

        correctAnswerIndex = random.nextInt(4);

        for (int i = 0; i < 4; i++) {
            //Why 4? Because 4 answers
            if (i == correctAnswerIndex) {
                answers.add(a + b);
            } else {
                int wrongAnswer = random.nextInt(69);
                while (wrongAnswer == a + b) {
                    wrongAnswer = random.nextInt(69);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.goButton);
        problemText = findViewById(R.id.problemText);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        resultText = findViewById(R.id.resultText);
        scoreText = findViewById(R.id.scoreText);

        newQuestion();
    }
}
