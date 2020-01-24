package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CGPAScreen1 extends AppCompatActivity implements View.OnClickListener{

    String[] Semester_names;
    private CardView sub10CardView;
    private Spinner spinner;
    private LinearLayout layout0,layout1,layout2,layout3,layout4,layout5,layout6,layout7,layout8,layout9,layout10;
    SharedPreferences sharedPreferences;
    private EditText nameeditext,idedittext,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10;
    private TextView sub1TV,sub2TV,sub3TV,sub4TV,sub5TV,sub6TV,sub7TV,sub8TV,sub9TV,sub10TV,semester;
    private Button submitbutton,clearbutton,Showbutton;
    private double CGPA;
    private int TotalMarks = 0;
    private double TotalGrade = 0.0;
    private String SelectedSemester,Semester,nameString,IDString,subject10,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpascreen1);

        layout0 = findViewById(R.id.cg_layout0);
        layout1 = findViewById(R.id.cg_layout1);
        layout2 = findViewById(R.id.cg_layout2);
        layout3 = findViewById(R.id.cg_layout3);
        layout4 = findViewById(R.id.cg_layout4);
        layout5 = findViewById(R.id.cg_layout5);
        layout6 = findViewById(R.id.cg_layout6);
        layout7 = findViewById(R.id.cg_layout7);
        layout8 = findViewById(R.id.cg_layout8);
        layout9 = findViewById(R.id.cg_layout9);
        layout10 = findViewById(R.id.cg_layout10);


        sub1 = findViewById(R.id.sub1ID);
        sub2 = findViewById(R.id.sub2ID);
        sub3 = findViewById(R.id.sub3ID);
        sub4 = findViewById(R.id.sub4ID);
        sub5 = findViewById(R.id.sub5ID);
        sub6 = findViewById(R.id.sub6ID);
        sub7 = findViewById(R.id.sub7ID);
        sub8 = findViewById(R.id.sub8ID);
        sub9 = findViewById(R.id.sub9ID);
        sub10 = findViewById(R.id.sub10ID);
        sub1TV = findViewById(R.id.sub1TVID);
        sub2TV = findViewById(R.id.sub2TVID);
        sub3TV = findViewById(R.id.sub3TVID);
        sub4TV = findViewById(R.id.sub4TVID);
        sub5TV = findViewById(R.id.sub5TVID);
        sub6TV = findViewById(R.id.sub6TVID);
        sub7TV = findViewById(R.id.sub7TVID);
        sub8TV = findViewById(R.id.sub8TVID);
        sub9TV = findViewById(R.id.sub9TVID);
        sub10TV = findViewById(R.id.sub10TVID);
        spinner = findViewById(R.id.CGPA_spinnerID);
        semester = findViewById(R.id.cg_semesterID);
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){

            DarkMode();
        }


        //nameeditext = findViewById(R.id.cgnameID);
        //idedittext = findViewById(R.id.cgID);

        sub10CardView = findViewById(R.id.sub10CardViewID);
        submitbutton = findViewById(R.id.cgsubmitbuttonID);
        clearbutton = findViewById(R.id.cgclearbuttonID);
        Semester_names = getResources().getStringArray(R.array.Semester);

        //Showbutton = findViewById(R.id.CGPAShowbuttonID);

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this,R.layout.layout_spinner_view,R.id.spinnerTVID,Semester_names);
        spinner.setAdapter(adapter);

        //Default set
        spinner.setSelection(getPosition(sharedPreferences.getString("userSemester","")));
        SelectedSemester = spinner.getSelectedItem().toString();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SetSemester(getSemester(position));
                SelectedSemester = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        submitbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);
        //Showbutton.setOnClickListener(this);

        //Semester = getIntent().getStringExtra("semester");



    }

    private void DarkMode() {
        layout0.setBackgroundColor(Color.DKGRAY);
        layout1.setBackgroundColor(Color.DKGRAY);
        layout2.setBackgroundColor(Color.DKGRAY);
        layout3.setBackgroundColor(Color.DKGRAY);
        layout4.setBackgroundColor(Color.DKGRAY);
        layout5.setBackgroundColor(Color.DKGRAY);
        layout6.setBackgroundColor(Color.DKGRAY);
        layout7.setBackgroundColor(Color.DKGRAY);
        layout8.setBackgroundColor(Color.DKGRAY);
        layout9.setBackgroundColor(Color.DKGRAY);
        layout10.setBackgroundColor(Color.DKGRAY);

        sub1.setTextColor(Color.WHITE);
        sub2.setTextColor(Color.WHITE);
        sub3.setTextColor(Color.WHITE);
        sub4.setTextColor(Color.WHITE);
        sub5.setTextColor(Color.WHITE);
        sub6.setTextColor(Color.WHITE);
        sub7.setTextColor(Color.WHITE);
        sub8.setTextColor(Color.WHITE);
        sub9.setTextColor(Color.WHITE);
        sub10.setTextColor(Color.WHITE);

        sub1TV.setTextColor(Color.WHITE);
        sub2TV.setTextColor(Color.WHITE);
        sub3TV.setTextColor(Color.WHITE);
        sub4TV.setTextColor(Color.WHITE);
        sub5TV.setTextColor(Color.WHITE);
        sub6TV.setTextColor(Color.WHITE);
        sub7TV.setTextColor(Color.WHITE);
        sub8TV.setTextColor(Color.WHITE);
        sub9TV.setTextColor(Color.WHITE);
        sub10TV.setTextColor(Color.WHITE);
        semester.setTextColor(Color.WHITE);


    }

    private double getCGPA(String SUB1,double credit1,String SUB2,double credit2,String SUB3,double credit3,
                           String SUB4,double credit4,String SUB5,double credit5,String SUB6,double credit6,
                           String SUB7,double credit7,String SUB8,double credit8,String SUB9,double credit9) {
        TotalGrade = (getGradePoint(SUB1)*credit1) + (getGradePoint(SUB2)*credit2) + (getGradePoint(SUB3)*credit3) +
                (getGradePoint(SUB4)*credit4) + (getGradePoint(SUB5)*credit5) + (getGradePoint(SUB6)*credit6) +
                (getGradePoint(SUB7)*credit7) + (getGradePoint(SUB8)*credit8) + (getGradePoint(SUB9)*credit9);
        double TotalCredit = credit1+credit2+credit3+credit4+credit5+credit6+credit7+credit8+credit9;


        return (TotalGrade/TotalCredit);
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
        //nameString = nameeditext.getText().toString();
        //IDString = idedittext.getText().toString();
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
        if (v.getId() == R.id.cgsubmitbuttonID){
            if(CheckEmpty()){
                Toast.makeText(getApplicationContext(),"Please fill all fields",Toast.LENGTH_LONG).show();
            }
            else {
                if (SelectedSemester.equals("1.1")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,0.75,subject8,1.5,subject9,1.5);

                    ShowResult();
                }

                if (SelectedSemester.equals("1.2")){

                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,1.5,subject8,1.5,subject9,0.75);

                    ShowResult();
                }
                if (SelectedSemester.equals("2.1")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,0.75,subject7,1.5,subject8,1.5,subject9,1.5);
                    ShowResult();
                }

                if (SelectedSemester.equals("3.1")){

                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,0.75,subject8,0.75,subject9,0.75);

                    ShowResult();
                }

                if (SelectedSemester.equals("3.2")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,0.75,subject8,0.75,subject9,0.75);

                    ShowResult();
                }

                if (SelectedSemester.equals("2.2")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,0.75,subject7,0.75,subject8,1.5,subject9,0.75,subject10,1.5);

                    ShowResult();
                }

                if (SelectedSemester.equals("4.1")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,3,subject7,1.5,subject8,0.75,subject9,0.75,subject10,0.75);

                    ShowResult();
                }

                if (SelectedSemester.equals("4.2")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,3,subject7,0.75,subject8,0.75,subject9,0.75,subject10,0.75);

                    ShowResult();
                }

            }


        }
        if (v.getId() == R.id.cgclearbuttonID){

            //nameeditext.setText("");
            //idedittext.setText("");
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
//        if (v.getId() == R.id.CGPAShowbuttonID){
//            SelectedSemester = spinner.getSelectedItem().toString();
//            Toast.makeText(getApplicationContext(),SelectedSemester,Toast.LENGTH_SHORT).show();
//            SetSemester(SelectedSemester);
//
//        }

    }

    private void ShowResult() {
        Intent intent = new Intent(CGPAScreen1.this,CGPAResultShow.class);
        Initialize();
        this.finish();
        startActivity(intent);
    }

    private boolean CheckEmpty() {
        if (subject1.isEmpty() || subject2.isEmpty() || subject3.isEmpty() || subject4.isEmpty() || subject5.isEmpty() || subject6.isEmpty()
                || subject7.isEmpty() || subject8.isEmpty() || subject9.isEmpty() || (sub10CardView.getVisibility() == View.VISIBLE && subject10.isEmpty())){
            return true;
        }
        else {
            return false;
        }

    }

    private void Initialize(){
        CGPAResultShow.StudentInfo(Semester,"No Name","No ID");
        CGPAResultShow.SetSubjectName(sub1TV.getText().toString(),sub2TV.getText().toString(),
                sub3TV.getText().toString(),sub4TV.getText().toString(),sub5TV.getText().toString(),
                sub6TV.getText().toString(),sub7TV.getText().toString(),sub8TV.getText().toString(),
                sub9TV.getText().toString(),sub10TV.getText().toString());

        CGPAResultShow.SetMarks(subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10);
        CGPAResultShow.ShowResult(TotalMarks,TotalGrade,CGPA);
    }

    private void SetSemester(String Semester)
    {
        if (Semester.equals("1.1")){
            setTitle("CGPA Calculator 1.1");
            sub1TV.setText("CSE1101 - C Program");
            sub2TV.setText("MATH1115 - Mathematics I");
            sub3TV.setText("PHY1115 - Physics");
            sub4TV.setText("CHEM1115 - Chemistry");
            sub5TV.setText("HUM1107 - Critical Thinking");
            sub6TV.setText("CSE1102 - C Program Lab");
            sub7TV.setText("PHY1116 - Physics Lab");
            sub8TV.setText("CSE1108 - Introduction Computer Lab");
            sub9TV.setText("HUM1108 - Critical Thinking Lab");
            sub10CardView.setVisibility(View.GONE);

        }

        if (Semester.equals("1.2")){

            setTitle("CGPA Calculator 1.2");
            sub1TV.setText("CSE1205 - JAVA");
            sub2TV.setText("MATH1219 - Mathematics II");
            sub3TV.setText("EEE1241 - Basic Electrical Engineering");
            sub4TV.setText("ME1211 - Mechanical Engineering");
            sub5TV.setText("CSE1203 - Discrete Mathematics");
            sub6TV.setText("CSE1200 - Software Development I");
            sub7TV.setText("CSE1206 - JAVA Lab");
            sub8TV.setText("EEE1242 - EEE Lab");
            sub9TV.setText("ME1214 - Mechanical Engieering Lab");
            sub10CardView.setVisibility(View.GONE);


        }

        if (Semester.equals("2.1")){

            setTitle("CGPA Calculator 2.1");
            sub1TV.setText("MATH2101 - Mathematics III");
            sub2TV.setText("EEE2141 - Electrical Devices & Circuit");
            sub3TV.setText("CSE2103 - Data Structures");
            sub4TV.setText("CSE2105 - Digital Logic Design");
            sub5TV.setText("HUM2109 - Society,Ethics & Technology");
            sub6TV.setText("CSE2100 - Software Development II");
            sub7TV.setText("CSE2104 - Data Structures Lab");
            sub8TV.setText("EEE2142 - EEE Lab");
            sub9TV.setText("CSE2106 - Digital Logic Design Lab");
            sub10CardView.setVisibility(View.GONE);


        }

        if (Semester.equals("3.1")){

            setTitle("CGPA Calculator 3.1");
            sub1TV.setText("CSE3103 - Database");
            sub2TV.setText("CSE3107 - Microprocessors");
            sub3TV.setText("CSE3109 - Digital System Design");
            sub4TV.setText("CSE3101 - Mathematical Analysis for CS");
            sub5TV.setText("HUM3115 - Economics & Accounting");
            sub6TV.setText("CSE3104 - Database Lab");
            sub7TV.setText("CSE3100 - Software Development IV");
            sub8TV.setText("CSE3108 - Microprocessors Lab");
            sub9TV.setText("CSE3110 - Digital System Design Lab");
            sub10CardView.setVisibility(View.GONE);

        }

        if (Semester.equals("3.2")){

            setTitle("CGPA Calculator 3.2");
            sub1TV.setText("CSE3211 - Data Communication");
            sub2TV.setText("CSE3213 - Operating System");
            sub3TV.setText("CSE3215 - Microcontroller Based System");
            sub4TV.setText("CSE3223 - Information System Design");
            sub5TV.setText("HUM3207 -Industrial Law & Safety Management");
            sub6TV.setText("CSE3214 - Operating System Lab");
            sub7TV.setText("CSE3200 - Software Development V");
            sub8TV.setText("CSE3216 - Microcontroller Based System Lab");
            sub9TV.setText("CSE3224 - Information System Design Lab");
            sub10CardView.setVisibility(View.GONE);
        }

        if (Semester.equals("2.2")){
            setTitle("CGPA Calculator 2.2");
            sub1TV.setText("MATH2203 - Mathematics IV");
            sub2TV.setText("CSE2201 - Numerical Methods");
            sub3TV.setText("CSE2207 - Algorithms");
            sub4TV.setText("CSE2209 - DEPT");
            sub5TV.setText("CSE2213 - Computer Architecture");
            sub6TV.setText("CSE2200 - Software Development III");
            sub7TV.setText("CSE2202 - Numerical Methods Lab");
            sub8TV.setText("CSE2208 -  Algorithm Lab");
            sub9TV.setText("CSE2210 - DEPT Lab");
            sub10CardView.setVisibility(View.VISIBLE);
            sub10TV.setText("CSE2214 - Assembly Language Programming");

        }

        if (Semester.equals("4.1")){

            setTitle("CGPA Calculator 4.1");
            sub1TV.setText("CSE4101 - Computer Networks");
            sub2TV.setText("CSE4107 - Artificial Intelligence");
            sub3TV.setText("CSE4125 - Distributed Database System");
            sub4TV.setText("CSE4129 - Formal Languages & Compilers");
            sub5TV.setText("IPE4111 - Industrial Management");
            sub6TV.setText("CSE4100 - Project & Thesis I");
            sub7TV.setText("CSE4102 - Computer Networks Lab");
            sub8TV.setText("CSE4108 -  Artificial Intelligence Lab");
            sub9TV.setText("CSE4126 - Distributed Database System Lab");
            sub10CardView.setVisibility(View.VISIBLE);
            sub10TV.setText("CSE4130 - Formal Languages & Compilers Lab");


        }

        if (Semester.equals("4.2")) {

            setTitle("CGPA Calculator 4.2");
            sub1TV.setText("CSE4203 - Computer Graphics");
            sub2TV.setText("CSE42.. - Option I");
            sub3TV.setText("CSE42.. - Option II");
            sub4TV.setText("CSE42.. - Option III");
            sub5TV.setText("CSE42.. - Option IV");
            sub6TV.setText("CSE4250 - Project & Thesis II");
            sub7TV.setText("CSE4204 - Computer Graphics Lab");
            sub8TV.setText("CSE42.. -  Option I Lab");
            sub9TV.setText("CSE42.. - Option II Lab");
            sub10CardView.setVisibility(View.VISIBLE);
            sub10TV.setText("CSE42.. - Option III Lab");
        }
    }

    private String getSemester(int position)
    {
        if(position==0) return "1.1";
        if(position==1) return "1.2";
        if(position==2) return "2.1";
        if(position==3) return "2.2";
        if(position==4) return "3.1";
        if(position==5) return "3.2";
        if(position==6) return "4.1";
        if(position==7) return "4.2";
        return null;
    }

    private int getPosition(String semester)
    {
        if (semester.equals("1.1")) return 0;
        if (semester.equals("1.2")) return 1;
        if (semester.equals("2.1")) return 2;
        if (semester.equals("2.2")) return 3;
        if (semester.equals("3.1")) return 4;
        if (semester.equals("3.2")) return 5;
        if (semester.equals("4.1")) return 6;
        if (semester.equals("4.2")) return 7;
        return -1;
    }
}
