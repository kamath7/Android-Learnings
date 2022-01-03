package com.example.kamathinc.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickFunction(View view){
        System.out.println("I am being generated! Button is being clicked successfully!");
        Log.i("Info:","I am being generated! Button is being clicked successfully!");
        Toast.makeText(getApplicationContext(),"You're clicking this successfully!",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
