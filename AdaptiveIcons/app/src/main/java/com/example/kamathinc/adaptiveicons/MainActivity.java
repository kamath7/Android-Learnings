package com.example.kamathinc.adaptiveicons;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    public void goPip (View view){
        enterPictureInPictureMode();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Autofill

        String[] friends ={"Rhea","Amanda","Rithu"};

        AutoCompleteTextView autocompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friends);
        autocompleteTextView.setAdapter(arrayAdapter);
        autocompleteTextView.setThreshold(1);//how many characters before suggestions
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        Button button = findViewById(R.id.button);
        if(isInPictureInPictureMode){
            //PIP mode
            button.setVisibility(View.INVISIBLE);
            getSupportActionBar().hide();

        }else{
            button.setVisibility(View.VISIBLE);
            getSupportActionBar().show();
        }
    }
}
