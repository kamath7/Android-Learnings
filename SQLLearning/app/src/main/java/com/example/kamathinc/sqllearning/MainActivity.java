package com.example.kamathinc.sqllearning;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDb = this.openOrCreateDatabase("Books",MODE_PRIVATE, null);

        myDb.execSQL("CREATE TABLE IF NOT EXISTS books (name VARCHAR, author VARCHAR)");
        myDb.execSQL("INSERT INTO books (name,author) VALUES ('And Then There Were None', 'Agatha Christie')");
        myDb.execSQL("INSERT INTO books (name,author) VALUES ('Master of the game', 'Sidney Sheldon')");

    }
}
