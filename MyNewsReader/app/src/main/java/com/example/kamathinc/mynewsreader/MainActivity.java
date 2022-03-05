package com.example.kamathinc.mynewsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> newsTitles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, newsTitles);

        listView.setAdapter(arrayAdapter);

    }
}
