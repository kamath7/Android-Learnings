package com.example.kamathinc.favoriteplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView llstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llstView = findViewById(R.id.listView);

        ArrayList<String> favPlaces = new ArrayList<String>();
        
    }
}
