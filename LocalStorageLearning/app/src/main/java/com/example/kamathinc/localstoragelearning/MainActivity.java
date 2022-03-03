package com.example.kamathinc.localstoragelearning;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.kamathinc.localstoragelearning", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("userName", "kamath7"); //ading a new element
    }
}
