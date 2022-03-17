package com.example.kamathinc.adaptiveicons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

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
}
