package com.example.kamathinc.androidwearcounter;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    private int count = 0;

    public void addOne(View view){

        count +=1;
        mTextView.setText(Integer.toString(count));
    }

    public void resetCount(View view){
        count = 0;
        mTextView.setText(Integer.toString(count));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }
}
