package com.example.kamathinc.menuandalert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    public  void setLanguage(String language){
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.kamathinc.menuandaler", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("language",language).apply();
        textView.setText("Language set to "+language);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Preferred Language")
                .setMessage("Which Language?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("English");
                        Toast.makeText(MainActivity.this, "You are!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hindi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("Hindi");
                    }
                })
                .show();
    }
}
