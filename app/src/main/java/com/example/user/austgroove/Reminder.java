package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Reminder extends AppCompatActivity {

    FloatingActionButton fab_item_re;
    TextView timeT,dateT,nameT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        fab_item_re=findViewById(R.id.fab_item_r);
        timeT=findViewById(R.id.time);
        dateT=findViewById(R.id.date);
        nameT=findViewById(R.id.name);

        fab_item_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),addReminder.class);
                startActivity(intent);
            }
        });

        SharedPreferences time = getSharedPreferences("Reminder",Context.MODE_PRIVATE);
        String timeR = time.getString("Time","hi");
        timeT.setText(timeR.trim());

        SharedPreferences date = getSharedPreferences("Reminder",Context.MODE_PRIVATE);
        String dateR = date.getString("date","hi");
        dateT.setText(dateR.trim());

        SharedPreferences name = getSharedPreferences("Reminder",Context.MODE_PRIVATE);
        String nameR = name.getString("name","hi");
        nameT.setText(nameR.trim());



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }



}
