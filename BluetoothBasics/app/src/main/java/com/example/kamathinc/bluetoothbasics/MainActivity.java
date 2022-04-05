package com.example.kamathinc.bluetoothbasics;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    Button searchBtn;

    ArrayList<String> deviceList = new ArrayList<>() ;
    ArrayList<String> deviceAddress = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
//            Log.i("BLUETOOTH_ACTION", action);

            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                textView.setText("Finished");
                searchBtn.setEnabled(true);
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String name = bluetoothDevice.getName();
                String address = bluetoothDevice.getAddress();
                String rssi = Integer.toString(intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE));
                //to avoid repetition

                if(!deviceAddress.contains(address)){
                    deviceAddress.add(address);
                    String deviceString = "";
//                Log.i("BLUETOOTH_ACTION", "Device name: "+name +" Device Address: "+address+" RSSI: "+rssi);
                    if(name == null || name.equals("")){

                        deviceString = address+" | RSSI - "+rssi+"dBm";
                    }else{
                        deviceString = name+" | RSSI - "+rssi+"dBm";
                    }
                    deviceList.add(deviceString);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        }
    };
    BluetoothAdapter bluetoothAdapter;

    public void searchBT(View view) {
        textView.setText("Searching ...");
        searchBtn.setEnabled(false);
        deviceList.clear();
        deviceAddress.clear();
        bluetoothAdapter.startDiscovery();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.statusTextView);
        searchBtn = findViewById(R.id.searchButton);

        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, deviceList);
        listView.setAdapter(arrayAdapter);


        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(broadcastReceiver, intentFilter);

    }
}
