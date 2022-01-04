package com.example.kamathinc.getmetheprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void currencyConverter(View view){

        EditText currencyText = (EditText) findViewById(R.id.currecyText);
        double convertedToRupees = Double.parseDouble(currencyText.getText().toString()) * 74.57;
        Toast.makeText(getApplicationContext(),"You get INR "+ (double)Math.round(convertedToRupees) , Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
