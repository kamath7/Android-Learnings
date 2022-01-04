package com.example.kamathinc.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickFunction(View view) {

        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText passwordText = (EditText) findViewById(R.id.password);

        Log.i("Info:", "I am being generated! Button is being clicked successfully!");
//        Toast.makeText(getApplicationContext(), "You're clicking this successfully!", Toast.LENGTH_SHORT).show();
        Log.i("Values","You entered the following details - username: "+usernameText.getText().toString()+" password:"+passwordText.getText().toString());
        Toast.makeText(getApplicationContext(), "You entered "+usernameText.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    public void imageChange (View view){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.image2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
