package com.example.kamathinc.sqllearning;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase myDb = this.openOrCreateDatabase("Books",MODE_PRIVATE, null);

            myDb.execSQL("CREATE TABLE IF NOT EXISTS books (name VARCHAR, author VARCHAR)");
            myDb.execSQL("INSERT INTO books (name,author) VALUES ('And Then There Were None', 'Agatha Christie')");
            myDb.execSQL("INSERT INTO books (name,author) VALUES ('Master of the game', 'Sidney Sheldon')");

            Cursor cursor = myDb.rawQuery("SELECT * FROM books",null);

            int nameIndex = cursor.getColumnIndex("name");
            int authorIndex = cursor.getColumnIndex("author");

            cursor.moveToFirst();

            while (cursor !=null){

                Log.i("SQL Query-Name", cursor.getString(nameIndex));
                Log.i("SQL Query-Author", cursor.getString(authorIndex));

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("movies", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS movies (name VARCHAR, releaseYear INT (4))");

            sqLiteDatabase.execSQL("INSERT INTO movies (name, releaseYear) VALUES ('Avengers', 2012) ");
            sqLiteDatabase.execSQL("INSERT INTO movies (name, releaseYear) VALUES ('Mission Impossible 2', 2002) ");

            Cursor newCursor = sqLiteDatabase.rawQuery("SELECT * FROM movies",null);

            int movieNameIndex = newCursor.getColumnIndex("name");
            int movieYearIndex = newCursor.getColumnIndex("releaseYear");

            newCursor.moveToFirst();

            while(newCursor!= null){
                Log.i("SQL Query Movie ", newCursor.getString(movieNameIndex));
                Log.i("SQL Query release year", newCursor.getString(movieYearIndex));
                newCursor.moveToNext();
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("awesomeusers", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS awesomeusers (name VARCHAR, age INT (3), id INTEGER  PRIMARY KEY )");

            sqLiteDatabase.execSQL("INSERT INTO awesomeusers (name, age,id) VALUES ('Shwetha', 28,1) ");
            sqLiteDatabase.execSQL("INSERT INTO awesomeusers (name, age,id) VALUES ('Shreya', 18,2) ");
            sqLiteDatabase.execSQL("INSERT INTO awesomeusers (name, age,id) VALUES ('Maya', 20,3) ");

            sqLiteDatabase.execSQL("DELETE FROM user WHERE name = 'Maya' ");
            Cursor newCursor = sqLiteDatabase.rawQuery("SELECT * FROM awesomeusers",null);

            int movieNameIndex = newCursor.getColumnIndex("name");
            int movieYearIndex = newCursor.getColumnIndex("age");
            int idIndex = newCursor.getColumnIndex("id");

            newCursor.moveToFirst();

            while(newCursor!= null){
                Log.i("SQL Query Movie ", newCursor.getString(movieNameIndex));
                Log.i("SQL Query release year", newCursor.getString(movieYearIndex));
                Log.i("SQL Query id", newCursor.getString(idIndex));
                newCursor.moveToNext();
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
