package com.example.kamathinc.animationsbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean isPeterAlive = false;

    public void doAFade(View view) {
        Log.i("INFO", "Image view was tapped!");

        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView1 = findViewById(R.id.imageView1);


//        if (isPeterAlive == false){
//
//            imageView.animate().alpha(0).setDuration(2000);
//            imageView1.animate().alpha(1).setDuration(2000);
//            isPeterAlive = true;
//        }else{
//            //Fade out effect
//            imageView1.animate().alpha(0).setDuration(2000);
//            imageView.animate().alpha(1).setDuration(2000);
//            isPeterAlive = false;
//
//        }
//        imageView.animate().translationXBy(-1000).setDuration(2000);
//        imageView.animate().rotation(180).alpha(0).setDuration(1000);

//        imageView.animate().scaleX((float)0.5).scaleY((float)0.5).setDuration(1000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().translationXBy(-1000);
        imageView.animate().translationXBy(1000).rotation(3600).setDuration(3000);
    }
}
