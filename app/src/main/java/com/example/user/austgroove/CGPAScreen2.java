package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CGPAScreen2 extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layout;
    private EditText nameeditext,idedittext,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10;
    private Button submitbutton,clearbutton;
    private double CGPA;
    private int TotalMarks = 0;
    private double TotalGrade = 0.0;
    SharedPreferences sharedPreferences;
    private String Semester,nameString,IDString,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpascreen2);

        layout  = findViewById(R.id.CGPAScreen2_layoutID);
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
        }

        nameeditext = findViewById(R.id.cg2nameID);
        idedittext = findViewById(R.id.cg2ID);
        sub1 = findViewById(R.id.Sub1ID);
        sub2 = findViewById(R.id.Sub2ID);
        sub3 = findViewById(R.id.Sub3ID);
        sub4 = findViewById(R.id.Sub4ID);
        sub5 = findViewById(R.id.Sub5ID);
        sub6 = findViewById(R.id.Sub6ID);
        sub7 = findViewById(R.id.Sub7ID);
        sub8 = findViewById(R.id.Sub8ID);
        sub9 = findViewById(R.id.Sub9ID);
        sub10 = findViewById(R.id.Sub10ID);
        submitbutton = findViewById(R.id.cg2submitbuttonID);
        clearbutton = findViewById(R.id.cg2clearbuttonID);

        submitbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);

        Semester = getIntent().getStringExtra("semester");

        if (Semester.equals("2.2")){
            setTitle("CGPA Calculator 2.2");
            sub1.setHint("MATH2203 - Mathematics IV");
            sub2.setHint("CSE2201 - Numerical Methods");
            sub3.setHint("CSE2207 - Algorithms");
            sub4.setHint("CSE2209 - DEPT");
            sub5.setHint("CSE2213 - Computer Architecture");
            sub6.setHint("CSE2200 - Software Development III");
            sub7.setHint("CSE2202 - Numerical Methods Lab");
            sub8.setHint("CSE2208 -  Algorithm Lab");
            sub9.setHint("CSE2210 - DEPT Lab");
            sub10.setHint("CSE2214 - Assembly Language Programming");

        }

        if (Semester.equals("4.1")){

            setTitle("CGPA Calculator 4.1");
            sub1.setHint("CSE4101 - Computer Networks");
            sub2.setHint("CSE4107 - Artificial Intelligence");
            sub3.setHint("CSE4125 - Distributed Database System");
            sub4.setHint("CSE4129 - Formal Languages & Compilers");
            sub5.setHint("IPE4111 - Industrial Management");
            sub6.setHint("CSE4100 - Project & Thesis I");
            sub7.setHint("CSE4102 - Computer Networks Lab");
            sub8.setHint("CSE4108 -  Artificial Intelligence Lab");
            sub9.setHint("CSE4126 - Distributed Database System Lab");
            sub10.setHint("CSE4130 - Formal Languages & Compilers Lab");


        }

        if (Semester.equals("4.2")){

            setTitle("CGPA Calculator 4.2");
            sub1.setHint("CSE4203 - Computer Graphics");
            sub2.setHint("CSE42.. - Option I");
            sub3.setHint("CSE42.. - Option II");
            sub4.setHint("CSE42.. - Option III");
            sub5.setHint("CSE42.. - Option IV");
            sub6.setHint("CSE4250 - Project & Thesis II");
            sub7.setHint("CSE4204 - Computer Graphics Lab");
            sub8.setHint("CSE42.. -  Option I Lab");
            sub9.setHint("CSE42.. - Option II Lab");
            sub10.setHint("CSE42.. - Option III Lab");


        }
    }
    private double getCGPA(String SUB1,double credit1,String SUB2,double credit2,String SUB3,double credit3,
                           String SUB4,double credit4,String SUB5,double credit5,String SUB6,double credit6,
                           String SUB7,double credit7,String SUB8,double credit8,String SUB9,double credit9,String SUB10,double credit10) {
        TotalGrade = (getGradePoint(SUB1)*credit1) + (getGradePoint(SUB2)*credit2) + (getGradePoint(SUB3)*credit3) +
                (getGradePoint(SUB4)*credit4) + (getGradePoint(SUB5)*credit5) + (getGradePoint(SUB6)*credit6) +
                (getGradePoint(SUB7)*credit7) + (getGradePoint(SUB8)*credit8) + (getGradePoint(SUB9)*credit9) + (getGradePoint(SUB10)*credit10);
        double TotalCredit = credit1+credit2+credit3+credit4+credit5+credit6+credit7+credit8+credit9+credit10;


        return (TotalGrade/TotalCredit);
    }

    private double getGradePoint(String sub) {

        //int mark = Integer.parseInt(sub);
        int mark = Integer.valueOf(sub);
        TotalMarks+=mark;
        if (mark>=0 && mark<40)
            return 0;
        if (mark>=40 && mark<45)
            return 2;
        if (mark>=45 && mark<50)
            return 2.25;
        if (mark>=50 && mark<55)
            return 2.5;
        if (mark>=55 && mark<60)
            return 2.75;
        if (mark>=60 && mark<65)
            return 3;
        if (mark>=65 && mark<70)
            return 3.25;
        if (mark>=70 && mark<75)
            return 3.5;
        if (mark>=75 && mark<80)
            return 3.75;
        if (mark>=80)
            return 4;

        return 0;
    }

    @Override
    public void onClick(View v) {
        nameString = nameeditext.getText().toString();
        IDString = idedittext.getText().toString();
        subject1 = sub1.getText().toString();
        subject2 = sub2.getText().toString();
        subject3 = sub3.getText().toString();
        subject4 = sub4.getText().toString();
        subject5 = sub5.getText().toString();
        subject6 = sub6.getText().toString();
        subject7 = sub7.getText().toString();
        subject8 = sub8.getText().toString();
        subject9 = sub9.getText().toString();
        subject10 = sub10.getText().toString();

        if (v.getId() == R.id.cg2submitbuttonID) {
            if (CheckEmpty()) {
                Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
            }
            else
            {

                if (Semester.equals("2.2")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,0.75,subject7,0.75,subject8,1.5,subject9,0.75,subject10,1.5);

                    ShowResult();
                }

                if (Semester.equals("4.1")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,3,subject7,1.5,subject8,0.75,subject9,0.75,subject10,0.75);

                    ShowResult();
                }

                if (Semester.equals("4.2")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,3,subject7,0.75,subject8,0.75,subject9,0.75,subject10,0.75);

                    ShowResult();
                }


            }

        }

        if (v.getId() == R.id.cg2clearbuttonID){

            nameeditext.setText("");
            idedittext.setText("");
            sub1.setText("");
            sub2.setText("");
            sub3.setText("");
            sub4.setText("");
            sub5.setText("");
            sub6.setText("");
            sub7.setText("");
            sub8.setText("");
            sub9.setText("");
            sub10.setText("");
        }

    }

    private void ShowResult() {
        Intent intent = new Intent(CGPAScreen2.this,CGPAResultShow.class);
        Initialize();
        this.finish();
        startActivity(intent);
    }

    private boolean CheckEmpty() {
        if (nameString.isEmpty() || IDString.isEmpty() || subject1.isEmpty() || subject2.isEmpty()
                || subject3.isEmpty() || subject4.isEmpty() || subject5.isEmpty() || subject6.isEmpty()
                || subject7.isEmpty() || subject8.isEmpty() || subject9.isEmpty() || subject10.isEmpty()){
            return true;
        }
        else {
            return false;
        }

    }

    private void Initialize(){
        CGPAResultShow.StudentInfo(Semester,nameString,IDString);
        CGPAResultShow.SetSubjectName(sub1.getHint().toString(),sub2.getHint().toString(),
                sub3.getHint().toString(),sub4.getHint().toString(),sub5.getHint().toString(),
                sub6.getHint().toString(),sub7.getHint().toString(),sub8.getHint().toString(),
                sub9.getHint().toString(),sub10.getHint().toString());

        CGPAResultShow.SetMarks(subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10);
        CGPAResultShow.ShowResult(TotalMarks,TotalGrade,CGPA);
    }
}
