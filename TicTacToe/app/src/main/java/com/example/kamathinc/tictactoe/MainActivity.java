package com.example.kamathinc.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //to keep track of players. 0 - yellow 1  - red
    int activePlayer = 0;
    boolean gameActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2}; //why 2? - means the square is untapped yet
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}}; //winning positions possible

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
//        Log.i("Info","Counter "+counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {


            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(2600).setDuration(300);
            for (int[] winningPosition : winningPositions) {
                if ((gameState[winningPosition[0]] == gameState[winningPosition[1]]) && (gameState[winningPosition[1]] == gameState[winningPosition[2]]) && (gameState[winningPosition[0]] != 2)) {
                    gameActive = false;
                    String winner = " ";
                    if (activePlayer == 1) {
                        winner = "Yellow!";
                    } else {
                        winner = "Red";
                    }
//                    Toast.makeText(this, "Winner is " + winner, Toast.LENGTH_SHORT).show();

                    Button playAgain = findViewById(R.id.playAgainButton);
                    TextView winnerText = findViewById(R.id.winnerText);

                    winnerText.setText("Winner is " + winner);
                    playAgain.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view) {
        Button playAgain = findViewById(R.id.playAgainButton);
        TextView winnerText = findViewById(R.id.winnerText);
        playAgain.setVisibility(View.INVISIBLE);
        winnerText.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        //Below code loops through all the grid layout and remove the image source
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        activePlayer = 0;
        gameActive = true;
        for (int j = 0; j < gameState.length; j++) {
            gameState[j] = 2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
