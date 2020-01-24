package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class CGPAResultShow extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout layout12,layout,layout0,layout1,layout2,layout3,layout4,layout5,layout6,layout7,layout8,layout9,layout10,layout11;
    SharedPreferences sharedPreferences;
    private static double resultshow;
    private static String Semester,Name,ID,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,mark1,mark2,mark3,mark4,mark5,mark6
            ,mark7,mark8,mark9,mark10;
    private static int totalmark;
    private static double totalGrade;
    private Button savebutton,sharebutton;
    private CardView sub10CardView;
    private TextView cgpashowTV,TotalMarksTV;
    private TextView s1MarkView,s2MarkView,s3MarkView,s4MarkView,s5MarkView,s6MarkView,s7MarkView,s8MarkView,s9MarkView,s10MarkView;
    private TextView s1GradeView,s2GradeView,s3GradeView,s4GradeView,s5GradeView,s6GradeView,s7GradeView,s8GradeView,s9GradeView,s10GradeView;
    private TextView nameview,idview,s1view,s2view,s3view,s4view,s5view,s6view,s7view,s8view,s9view,s10view,gpaview,marksview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgparesult_show);

        layout  = findViewById(R.id.CGPAShow_layoutID);
        layout0 = findViewById(R.id.cglayout0ID);
        layout1 = findViewById(R.id.cglayout1ID);
        layout2 = findViewById(R.id.cglayout2ID);
        layout3 = findViewById(R.id.cglayout3ID);
        layout4 = findViewById(R.id.cglayout4ID);
        layout5 = findViewById(R.id.cglayout5ID);
        layout6 = findViewById(R.id.cglayout6ID);
        layout7 = findViewById(R.id.cglayout7ID);
        layout8 = findViewById(R.id.cglayout8ID);
        layout9 = findViewById(R.id.cglayout9ID);
        layout10 = findViewById(R.id.cglayout10ID);
        layout11 = findViewById(R.id.cglayout11ID);
        layout12 = findViewById(R.id.cglayout12ID);


        s1GradeView = findViewById(R.id.rssub1GradeTVID);
        s2GradeView = findViewById(R.id.rssub2GradeTVID);
        s3GradeView = findViewById(R.id.rssub3GradeTVID);
        s4GradeView = findViewById(R.id.rssub4GradeTVID);
        s5GradeView = findViewById(R.id.rssub5GradeTVID);
        s6GradeView = findViewById(R.id.rssub6GradeTVID);
        s7GradeView = findViewById(R.id.rssub7GradeTVID);
        s8GradeView = findViewById(R.id.rssub8GradeTVID);
        s9GradeView = findViewById(R.id.rssub9GradeTVID);
        s10GradeView = findViewById(R.id.rssub10GradeTVID);

        s1MarkView = findViewById(R.id.rssub1MarkTVID);
        s2MarkView = findViewById(R.id.rssub2MarkTVID);
        s3MarkView = findViewById(R.id.rssub3MarkTVID);
        s4MarkView = findViewById(R.id.rssub4MarkTVID);
        s5MarkView = findViewById(R.id.rssub5MarkTVID);
        s6MarkView = findViewById(R.id.rssub6MarkTVID);
        s7MarkView = findViewById(R.id.rssub7MarkTVID);
        s8MarkView = findViewById(R.id.rssub8MarkTVID);
        s9MarkView = findViewById(R.id.rssub9MarkTVID);
        s10MarkView = findViewById(R.id.rssub10MarkTVID);

        s1view = findViewById(R.id.rssub1ID);
        s2view = findViewById(R.id.rssub2ID);
        s3view = findViewById(R.id.rssub3ID);
        s4view = findViewById(R.id.rssub4ID);
        s5view = findViewById(R.id.rssub5ID);
        s6view = findViewById(R.id.rssub6ID);
        s7view = findViewById(R.id.rssub7ID);
        s8view = findViewById(R.id.rssub8ID);
        s9view = findViewById(R.id.rssub9ID);
        s10view = findViewById(R.id.rssub10ID);
        gpaview = findViewById(R.id.rsGPAid);
        marksview = findViewById(R.id.rstotalmarksid);
        savebutton = findViewById(R.id.rssaveID);
        sharebutton = findViewById(R.id.rsshareID);
        sub10CardView = findViewById(R.id.CGPA_Show_sub10CardViewID);
        cgpashowTV = findViewById(R.id.cgpaShowTVID);
        TotalMarksTV = findViewById(R.id.cgpaShowTotalMarksID);
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            //layout.setBackgroundColor(Color.DKGRAY);
            DarkMode();
        }




        s1view.setText(sub1);
        s2view.setText(sub2);
        s3view.setText(sub3);
        s4view.setText(sub4);
        s5view.setText(sub5);
        s6view.setText(sub6);
        s7view.setText(sub7);
        s8view.setText(sub8);
        s9view.setText(sub9);

        s1MarkView.setText("Mark : "+mark1);
        s2MarkView.setText("Mark : "+mark2);
        s3MarkView.setText("Mark : "+mark3);
        s4MarkView.setText("Mark : "+mark4);
        s5MarkView.setText("Mark : "+mark5);
        s6MarkView.setText("Mark : "+mark6);
        s7MarkView.setText("Mark : "+mark7);
        s8MarkView.setText("Mark : "+mark8);
        s9MarkView.setText("Mark : "+mark9);


        s1GradeView.setText("Grade : "+getGrade(mark1));
        s2GradeView.setText("Grade : "+getGrade(mark2));
        s3GradeView.setText("Grade : "+getGrade(mark3));
        s4GradeView.setText("Grade : "+getGrade(mark4));
        s5GradeView.setText("Grade : "+getGrade(mark5));
        s6GradeView.setText("Grade : "+getGrade(mark6));
        s7GradeView.setText("Grade : "+getGrade(mark7));
        s8GradeView.setText("Grade : "+getGrade(mark8));
        s9GradeView.setText("Grade : "+getGrade(mark9));

        if (!(sub10.equals("")) && !(mark10.equals(""))){
            sub10CardView.setVisibility(View.VISIBLE);
            s10view.setText(sub10);
            s10MarkView.setText("Mark : "+mark10);
            s10GradeView.setText("Grade : "+getGrade(mark10));
            //if (mark10.equals(""))
                //sub10CardView.setVisibility(View.GONE);
        }

        //gpaview.setText(""+resultshow);
        gpaview.setText(String.format("%.4f", resultshow));
        marksview.setText(""+totalmark);




        savebutton.setOnClickListener(this);
        sharebutton.setOnClickListener(this);
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
        layout11.setBackgroundColor(Color.DKGRAY);
        layout12.setBackgroundColor(Color.DKGRAY);

        s1view.setTextColor(Color.WHITE);
        s2view.setTextColor(Color.WHITE);
        s3view.setTextColor(Color.WHITE);
        s4view.setTextColor(Color.WHITE);
        s5view.setTextColor(Color.WHITE);
        s6view.setTextColor(Color.WHITE);
        s7view.setTextColor(Color.WHITE);
        s8view.setTextColor(Color.WHITE);
        s9view.setTextColor(Color.WHITE);
        s10view.setTextColor(Color.WHITE);

        s1MarkView.setTextColor(Color.WHITE);
        s2MarkView.setTextColor(Color.WHITE);
        s3MarkView.setTextColor(Color.WHITE);
        s4MarkView.setTextColor(Color.WHITE);
        s5MarkView.setTextColor(Color.WHITE);
        s6MarkView.setTextColor(Color.WHITE);
        s7MarkView.setTextColor(Color.WHITE);
        s8MarkView.setTextColor(Color.WHITE);
        s9MarkView.setTextColor(Color.WHITE);
        s10MarkView.setTextColor(Color.WHITE);

        s1GradeView.setTextColor(Color.WHITE);
        s2GradeView.setTextColor(Color.WHITE);
        s3GradeView.setTextColor(Color.WHITE);
        s4GradeView.setTextColor(Color.WHITE);
        s5GradeView.setTextColor(Color.WHITE);
        s6GradeView.setTextColor(Color.WHITE);
        s7GradeView.setTextColor(Color.WHITE);
        s8GradeView.setTextColor(Color.WHITE);
        s9GradeView.setTextColor(Color.WHITE);
        s10GradeView.setTextColor(Color.WHITE);

        gpaview.setTextColor(Color.WHITE);
        cgpashowTV.setTextColor(Color.WHITE);
        marksview.setTextColor(Color.WHITE);
        TotalMarksTV.setTextColor(Color.WHITE);

        savebutton.setTextColor(Color.WHITE);
        sharebutton.setTextColor(Color.WHITE);

    }

    public static void ShowResult(int Totalmarks,double totalgrade,double result){
        totalmark = Totalmarks;
        resultshow = result;
        totalGrade = totalgrade;

    }
    public static void SetSubjectName(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10){


        sub1 = s1;
        sub2 = s2;
        sub3 = s3;
        sub4 = s4;
        sub5 = s5;
        sub6 = s6;
        sub7 = s7;
        sub8 = s8;
        sub9 = s9;
        sub10 = s10;
    }

    public static void SetMarks(String m1,String m2,String m3,String m4,String m5,String m6,String m7,String m8,String m9,String m10){

        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
        mark4 = m4;
        mark5 = m5;
        mark6 = m6;
        mark7 = m7;
        mark8 = m8;
        mark9 = m9;
        mark10 = m10;
    }

    public static void StudentInfo(String semester,String name,String id){
        Semester = semester;
        Name = name;
        ID = id;

    }

    public String getGrade(String marks)
    {
        if(marks.equals(""))
            return "N/A";
        else{
            int mark = Integer.valueOf(marks);

            if (mark>=0 && mark<40)
                return "F";
            if (mark>=40 && mark<45)
                return "D";
            if (mark>=45 && mark<50)
                return "C";
            if (mark>=50 && mark<55)
                return "C+";
            if (mark>=55 && mark<60)
                return "B-";
            if (mark>=60 && mark<65)
                return "B";
            if (mark>=65 && mark<70)
                return "B+";
            if (mark>=70 && mark<75)
                return "A-";
            if (mark>=75 && mark<80)
                return "A";
            if (mark>=80)
                return "A+";

        }
        return "N/A";
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rssaveID){
            /*markSheetDatabase = new MarkSheetDatabase(this);
            SQLiteDatabase sqLiteDatabase = markSheetDatabase.getWritableDatabase();

            if (sub10.equals("") && mark10.equals("")){
                try {
                    long rowId = markSheetDatabase.insertData("MarkSheet_"+Semester,Name,ID,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,mark1,mark2,
                            mark3,mark4,mark5,mark6,mark7,mark8,mark9,resultshow,totalmark);

                    if(rowId>=0)
                        Toast.makeText(this,"Marks Saved Successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CGPAResultShow.this,Home.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Exceeption : "+e,Toast.LENGTH_LONG).show();
                }

            }
            else {
                long rowId = markSheetDatabase.insertData("MarkSheet_"+Semester,Name,ID,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,mark1,mark2,
                        mark3,mark4,mark5,mark6,mark7,mark8,mark9,mark10,resultshow,totalmark);

                if(rowId>=0)
                    Toast.makeText(this,"Marks Saved Successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CGPAResultShow.this,Home.class);
                startActivity(intent);
                finish();
            }*/

            //File directory = new File("CGPA Results");
            String FileName = Name + "_" + ID+".txt";
            try {
                Formatter cgpaFile = new Formatter(FileName);
                cgpaFile.format("%s : %s\r\n",sub1,mark1);
                cgpaFile.format("%s : %s\r\n",sub2,mark2);
                cgpaFile.format("%s : %s\r\n",sub3,mark3);
                cgpaFile.format("%s : %s\r\n",sub4,mark4);
                cgpaFile.format("%s : %s\r\n",sub5,mark5);
                cgpaFile.format("%s : %s\r\n",sub6,mark6);
                cgpaFile.format("%s : %s\r\n",sub7,mark7);
                cgpaFile.format("%s : %s\r\n",sub8,mark8);
                cgpaFile.format("%s : %s\r\n",sub9,mark9);
                if (!sub10.isEmpty() && !mark10.isEmpty())
                    cgpaFile.format("%s : %s\r\n",sub9,mark9);
                cgpaFile.format("%s : %.4f\r\n","GPA",resultshow);
                cgpaFile.format("%s : %d\r\n","Total Marks",totalmark);
                cgpaFile.close();

            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(),"File Not Found",Toast.LENGTH_LONG).show();
            }


        }

        if (v.getId() == R.id.rsshareID){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            //intent.putExtra(Intent.EXTRA_EMAIL,new String[] {""});

            intent.putExtra(Intent.EXTRA_SUBJECT,"Mark Sheet");
            intent.putExtra(Intent.EXTRA_TEXT,"Name :  "+Name+"\nID :  "+ID+"\n"+sub1+" :  "+mark1+"\n"+sub2+" : "+
                    mark2+"\n"+sub3+" :  "+mark3+"\n"+sub4+" :  "+mark4+"\n"+sub5+" :  "+mark5+"\n"+sub6+" :  "+mark6+"\n"+
                    sub7+" :  "+mark7+"\n"+sub8+" :  "+mark8+"\n"+sub9+" :  "+mark9+"\n"+sub10+"    "+mark10+"\n\nGPA :  "+resultshow+"\nTotal Marks :  "+totalmark);

            startActivity(Intent.createChooser(intent," Share with "));

        }

    }
}
