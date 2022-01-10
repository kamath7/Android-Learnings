package com.example.kamathinc.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //to keep track of players. 0 - yellow 1  - red
    int activePlayer = 0 ;
    int[]gameState = {2,2,2,2,2,2,2,2,2}; //why 2? - means the square is untapped yet
    int[][]winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn (View view){

        ImageView counter = (ImageView) view;
//        Log.i("Info","Counter "+counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = activePlayer;

        counter.setTranslationY(-1500);

    if(activePlayer == 0 ){
        counter.setImageResource(R.drawable.yellow);
        activePlayer = 1;

    }else{
        counter.setImageResource(R.drawable.red);
        activePlayer = 0;
    }
        counter.animate().translationYBy(1500).rotation(2600).setDuration(300);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
