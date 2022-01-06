package com.example.kamathinc.guessmenumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int randomNum = (int) (Math.random() * (10-1+1))+1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void guessNumber(View view){

        EditText myGuessedNumber = (EditText) findViewById(R.id.guessedNumber);
        int guessNumberInInteger = Integer.parseInt(myGuessedNumber.getText().toString());

        if (randomNum > guessNumberInInteger){
            Toast.makeText(getApplicationContext(), "Guess Higher!", Toast.LENGTH_SHORT).show();

        }else if(randomNum < guessNumberInInteger){
            Toast.makeText(getApplicationContext(), "Guess Lower!", Toast.LENGTH_SHORT).show();

        }else if (randomNum == guessNumberInInteger){
            Toast.makeText(getApplicationContext(), "Guessed it right! Number has now been reset", Toast.LENGTH_SHORT).show();
            randomNum = (int) (Math.random() * (10-1+1))+1;
        }
    }
}
