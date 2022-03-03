package com.example.kamathinc.favoriteplaces;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static ArrayList<String> favPlaces;
    static ArrayList<LatLng> locations;
    static ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.kamathinc.favoriteplaces", Context.MODE_PRIVATE);

        ArrayList<String> latitudes = new ArrayList<>();
        ArrayList<String> longitudes = new ArrayList<>();

       try{

           favPlaces = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("places", ObjectSerializer.serialize(new ArrayList<String>())));
           latitudes = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("Latitudes", ObjectSerializer.serialize(new ArrayList<String>())));
           longitudes = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("Longitudes", ObjectSerializer.serialize(new ArrayList<String>())));

       }catch(Exception e){
           e.printStackTrace();
       }

        listView = findViewById(R.id.listView);

        favPlaces = new ArrayList<String>();
        locations = new ArrayList<LatLng>();

        favPlaces.add("Enter place");
        locations.add(new LatLng(12, 73));
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, favPlaces);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("placeId", position);

                startActivity(intent);
            }
        });

    }
}
