package com.example.kamathinc.multiplescreenslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//
//    public void goScreen(View view){
//        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//        intent.putExtra("age", 25); //to share infor
//        startActivity(intent);
//    }

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayList<String> dishes = new ArrayList<String>();

        dishes.add("Palak Paneer");
        dishes.add("Pulav");
        dishes.add("Gobi Manchurian");
        dishes.add("Rasmalai");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , dishes);
        listView.setAdapter(arrayAdapter);

        

    }
}
