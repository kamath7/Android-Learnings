package com.example.kamathinc.listviewsbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.myListView);
        ArrayList<String> myFamilyMembers = new ArrayList<String>();

        myFamilyMembers.add("Ronaldo");
        myFamilyMembers.add("Rooney");
        myFamilyMembers.add("Roy Keane");
        myFamilyMembers.add("Nemanja Vidic");
    

    }
}
