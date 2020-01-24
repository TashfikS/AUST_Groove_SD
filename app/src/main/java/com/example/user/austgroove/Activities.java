package com.example.user.austgroove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activities extends AppCompatActivity implements View.OnClickListener{
    private Button Academic,ClassRoutine,StudyMaterial,Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        Academic = findViewById(R.id.buttonAcademicID);
        ClassRoutine = findViewById(R.id.buttonClassRoutineID);
        StudyMaterial = findViewById(R.id.buttonStudyMaterialID);
        Result = findViewById(R.id.buttonResultID);

        Academic.setOnClickListener(this);
        ClassRoutine.setOnClickListener(this);
        StudyMaterial.setOnClickListener(this);
        Result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAcademicID:
                Intent academicintent = new Intent(Activities.this,AcademicCalender.class);
                startActivity(academicintent);
                                        break;

            case R.id.buttonClassRoutineID:
                Intent ClassRoutineintent = new Intent(Activities.this,ClassRoutine.class);
                startActivity(ClassRoutineintent);
                                        break;

            case R.id.buttonStudyMaterialID:
                Intent StudyMaterialintent = new Intent(Activities.this,StudyMaterialHome.class);
                startActivity(StudyMaterialintent);
                                        break;

            case R.id.buttonResultID:
                Intent Resultintent = new Intent(Activities.this,Result.class);
                startActivity(Resultintent);
                                        break;
        }

    }
}
