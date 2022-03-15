package com.example.kamathinc.bluetoothbasics;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    Button searchBtn;

    BluetoothAdapter bluetoothAdapter;

    public void searchBT(View view){

        textView.setText("Searching ...");
        searchBtn.setEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.statusTextView);
        searchBtn = findViewById(R.id.searchButton);

    }
}
