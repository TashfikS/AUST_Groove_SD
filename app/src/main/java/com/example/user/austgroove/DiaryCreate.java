package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DiaryCreate extends AppCompatActivity implements View.OnClickListener{

    DiaryDatabase toDoListDatabase;
    private LinearLayout layout;
    SharedPreferences sharedPreferences;
    private EditText subjectEditText,DescriptionEditText;
    private Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_create);

        layout = findViewById(R.id.DiaryCreate_layoutID);
        //Check if DarkMode is activated previously by a user or not
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
            //savebutton.setBackground(Color.DKGRAY);
        }

        toDoListDatabase = new DiaryDatabase(this);
        SQLiteDatabase sqLiteDatabase = toDoListDatabase.getWritableDatabase();

        subjectEditText = findViewById(R.id.subjectEditTextID);
        DescriptionEditText = findViewById(R.id.DescriptionID);
        savebutton = findViewById(R.id.todolistsaveID);

        savebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String subject = subjectEditText.getText().toString();
        String description = DescriptionEditText.getText().toString();
        if (v.getId() == R.id.todolistsaveID){

            if (subject.isEmpty() || description.isEmpty()){
                Toast.makeText(getApplicationContext(),"Please fill up subject and description field",Toast.LENGTH_LONG).show();
            }else {

                long row = toDoListDatabase.saveData(subject,description);
                if (row > -1){
                    Toast.makeText(getApplicationContext(),"Data Saved successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DiaryCreate.this,Diary.class);
                    startActivity(intent);
                    this.finish();
                }

            }

        }
    }
}
