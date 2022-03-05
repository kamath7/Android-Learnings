package com.example.kamathinc.mynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditNoteActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editText = findViewById(R.id.editText);

        Intent intent = getIntent();

        int noteId = intent.getIntExtra("noteId",-1);
        if(noteId != -1 ){
            editText.setText(MainActivity.notes.get(noteId));
        }
    }
}
