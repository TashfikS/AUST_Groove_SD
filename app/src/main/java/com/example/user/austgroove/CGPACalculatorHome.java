package com.example.user.austgroove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CGPACalculatorHome extends AppCompatActivity implements View.OnClickListener {
    private Button cgbutton11,cgbutton12,cgbutton21,cgbutton22,cgbutton31,cgbutton32,cgbutton41,cgbutton42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpacalculator_home);


        cgbutton11 = findViewById(R.id.cgpa1_1ID);
        cgbutton12 = findViewById(R.id.cgpa1_2ID);
        cgbutton21 = findViewById(R.id.cgpa2_1ID);
        cgbutton22 = findViewById(R.id.cgpa2_2ID);
        cgbutton31 = findViewById(R.id.cgpa3_1ID);
        cgbutton32 = findViewById(R.id.cgpa3_2ID);
        cgbutton41 = findViewById(R.id.cgpa4_1ID);
        cgbutton42 = findViewById(R.id.cgpa4_2ID);

        cgbutton11.setOnClickListener(this);
        cgbutton12.setOnClickListener(this);
        cgbutton21.setOnClickListener(this);
        cgbutton22.setOnClickListener(this);
        cgbutton31.setOnClickListener(this);
        cgbutton32.setOnClickListener(this);
        cgbutton41.setOnClickListener(this);
        cgbutton42.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cgpa1_1ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen1.class);
            intent.putExtra("semester","1.1");
            startActivity(intent);
        }

        if (v.getId() == R.id.cgpa1_2ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen1.class);
            intent.putExtra("semester","1.2");
            startActivity(intent);

        }

        if (v.getId() == R.id.cgpa2_1ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen1.class);
            intent.putExtra("semester","2.1");
            startActivity(intent);

        }

        if (v.getId() == R.id.cgpa2_2ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen2.class);
            intent.putExtra("semester","2.2");
            startActivity(intent);

        }

        if (v.getId() == R.id.cgpa3_1ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen1.class);
            intent.putExtra("semester","3.1");
            startActivity(intent);

        }

        if (v.getId() == R.id.cgpa3_2ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen1.class);
            intent.putExtra("semester","3.2");
            startActivity(intent);

        }

        if (v.getId() == R.id.cgpa4_1ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen2.class);
            intent.putExtra("semester","4.1");
            startActivity(intent);

        }

        if (v.getId() == R.id.cgpa4_2ID){

            Intent intent = new Intent(CGPACalculatorHome.this,CGPAScreen2.class);
            intent.putExtra("semester","4.2");
            startActivity(intent);

        }

    }
}
