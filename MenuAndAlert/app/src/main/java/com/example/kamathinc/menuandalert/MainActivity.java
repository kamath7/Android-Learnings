package com.example.kamathinc.menuandalert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        
        switch (item.getItemId()) {
            case R.id.hindi:
                setLanguage("Hindi");
                return true;
            case R.id.english:
                setLanguage("English");
                return true;
            default:
                return false;
        }


    }

    public void setLanguage(String language) {
        sharedPreferences.edit().putString("language", language).apply();
        textView.setText("Language set to " + language);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.example.kamathinc.menuandaler", Context.MODE_PRIVATE);
        textView = findViewById(R.id.textView);

        String language = sharedPreferences.getString("language", "error!");

        if (language.equals("error!")) {
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
        } else {
            textView.setText(language);
        }


    }
}
