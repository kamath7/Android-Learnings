package com.example.kamathinc.multiplescreenslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public void goBack(View view){
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);
        //alternate

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();//getting the intent
        int age = intent.getIntExtra("age",69);
        Toast.makeText(getApplicationContext(), Integer.toString(age), Toast.LENGTH_SHORT).show();
    }
}
