package com.example.kamathinc.whatnumberi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {
        int number;

        public boolean checkTriangular() {

            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber += x;

            }

            if (triangularNumber == number) {
                return true;
            }
            return false;
        }

        public boolean checkSquare(){
            if (Math.ceil((double) Math.sqrt(number)) == Math.floor((double) Math.sqrt(number)) ){
                return true;
            }
            return false;
        }
    }
    public void numberChecker(View view){
        EditText myText = (EditText)findViewById(R.id.myNumber);

        int myNum = Integer.parseInt(myText.getText().toString());

        Number someNumber = new Number();
        someNumber.number = myNum;
        if(someNumber.checkTriangular() && someNumber.checkTriangular()){
            Toast.makeText(getApplicationContext(),"Number is a triangular and a square number", Toast.LENGTH_SHORT).show();
        }
        else if (someNumber.checkSquare()){
            Toast.makeText(getApplicationContext(),"Number is a square number", Toast.LENGTH_SHORT).show();
        }else if (someNumber.checkTriangular()){
            Toast.makeText(getApplicationContext(),"Number is a triangular number", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(),"Number is a neither triangular nor a square number", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
