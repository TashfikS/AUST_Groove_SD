package com.example.user.austgroove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudyMaterialHome extends AppCompatActivity implements View.OnClickListener{
    private Button button11,button12,button21,button22,button31,button32,button41,button42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material_home);

        button11 = findViewById(R.id.material1_1ID);
        button12 = findViewById(R.id.material1_2ID);
        button21 = findViewById(R.id.material2_1ID);
        button22 = findViewById(R.id.material2_2ID);
        button31 = findViewById(R.id.material3_1ID);
        button32 = findViewById(R.id.material3_2ID);
        button41 = findViewById(R.id.material4_1ID);
        button42 = findViewById(R.id.material4_2ID);


        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button41.setOnClickListener(this);
        button42.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.material1_1ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","1.1");
            startActivity(intent);
        }

        if (v.getId()==R.id.material1_2ID){


            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","1.2");
            startActivity(intent);
        }

        if (v.getId()==R.id.material2_1ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","2.1");
            startActivity(intent);


        }

        if (v.getId()==R.id.material2_2ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","2.2");
            startActivity(intent);


        }

        if (v.getId()==R.id.material3_1ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","3.1");
            startActivity(intent);


        }

        if (v.getId()==R.id.material3_2ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","3.2");
            startActivity(intent);


        }

        if (v.getId()==R.id.material4_1ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","4.1");
            startActivity(intent);


        }

        if (v.getId()==R.id.material4_2ID){

            Intent intent = new Intent(StudyMaterialHome.this,StudyMaterialDisplay.class);
            intent.putExtra("semester","4.2");
            startActivity(intent);


        }

    }
}
