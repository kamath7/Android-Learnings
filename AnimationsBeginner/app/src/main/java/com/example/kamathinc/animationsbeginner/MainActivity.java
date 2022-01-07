package com.example.kamathinc.animationsbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public void doAFade(View view){
        Log.i("INFO","Image view was tapped!");
        ImageView imageView = findViewById(R.id.imageView);
//        imageView.animate().alpha(0).setDuration(2000); //Fade out effect
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
