package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Button activity,noticeBoard,iums,Reminder,cgpa,diary;
    SharedPreferences.Editor editor;
    private TextView userEmail2,TV1,TV2,TV3,TV4,TV5,TV6;
    private RelativeLayout layout1,layout2,layout3,layout4,layout5,layout6,layout8;
    private LinearLayout layout7;
    private ImageView profileIV;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DarkMode();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userEmail2 = findViewById(R.id.userEmailID);

        // Set user information in the navigation bar
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.contains("userEmail")){
            String UserEmail = sharedPreferences.getString("userEmail","info@austgroove.com");
            //userEmail2.setText(UserEmail);
        }



        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Finding Button element
        activity = findViewById(R.id.buttonActivityID);
        noticeBoard = findViewById(R.id.buttonNoticeBoardID);
        iums = findViewById(R.id.buttoniumsID);
        Reminder = findViewById(R.id.buttonReminderID);
        cgpa = findViewById(R.id.buttoncgpaID);
        diary = findViewById(R.id.buttonDiaryID);
        profileIV = findViewById(R.id.nav_profileID);

        activity.setOnClickListener(this);
        noticeBoard.setOnClickListener(this);
        iums.setOnClickListener(this);
        Reminder.setOnClickListener(this);
        cgpa.setOnClickListener(this);
        diary.setOnClickListener(this);
        //profileIV.setOnClickListener(this);

    }

    private void DarkMode() {
        layout1 = findViewById(R.id.Home_layout1);
        layout2 = findViewById(R.id.Home_layout2);
        layout3 = findViewById(R.id.Home_layout3);
        layout4 = findViewById(R.id.Home_layout4);
        layout5 = findViewById(R.id.Home_layout5);
        layout6 = findViewById(R.id.Home_layout6);
        layout7 = findViewById(R.id.Home_layout7);
        layout8 = findViewById(R.id.Home_layout8);

        TV1 = findViewById(R.id.home_TV1ID);
        TV2 = findViewById(R.id.home_TV2ID);
        TV3 = findViewById(R.id.home_TV3ID);
        TV4 = findViewById(R.id.home_TV4ID);
        TV5 = findViewById(R.id.home_TV5ID);
        TV6 = findViewById(R.id.home_TV6ID);

        //Check if DarkMode is activated previously by a user or not
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout1.setBackgroundColor(Color.DKGRAY);
            layout2.setBackgroundColor(Color.DKGRAY);
            layout3.setBackgroundColor(Color.DKGRAY);
            layout4.setBackgroundColor(Color.DKGRAY);
            layout5.setBackgroundColor(Color.DKGRAY);
            layout6.setBackgroundColor(Color.DKGRAY);

            TV1.setTextColor(Color.WHITE);
            TV2.setTextColor(Color.WHITE);
            TV3.setTextColor(Color.WHITE);
            TV4.setTextColor(Color.WHITE);
            TV5.setTextColor(Color.WHITE);
            TV6.setTextColor(Color.WHITE);
            //layout7.setBackgroundColor(Color.DKGRAY);
            //layout8.setBackgroundColor(Color.DKGRAY);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case  R.id.buttonActivityID:

                Intent activityintent = new Intent(getApplicationContext(),Activities.class);
                startActivity(activityintent);
                break;

            case R.id.buttonNoticeBoardID:
                Intent NoticeBoardintent = new Intent(getApplicationContext(),NoticeBoard.class);
                startActivity(NoticeBoardintent);
                break;

            case  R.id.buttoniumsID:
                Intent intentiums = new Intent(getApplicationContext(),IUMS.class);
                startActivity(intentiums);
                break;

            case R.id.buttonReminderID:

                Intent intentreminder = new Intent(getApplicationContext(),Reminder.class);
                startActivity(intentreminder);
                break;

            case R.id.buttoncgpaID:
                Intent cgpaintent = new Intent(getApplicationContext(),CGPAScreen1.class);
                startActivity(cgpaintent);
                break;

            case R.id.buttonDiaryID:
                Intent Diaryintent = new Intent(getApplicationContext(),Diary.class);
                startActivity(Diaryintent);

                break;

            case R.id.nav_profileID:
                Intent profileintent = new Intent(getApplicationContext(),Profile.class);
                startActivity(profileintent);
                break;

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(),"Profile is selected",Toast.LENGTH_LONG).show();
                Intent intentprofile = new Intent(getApplicationContext(),Profile.class);
                startActivity(intentprofile);
                break;

            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(),"Setting is selected",Toast.LENGTH_LONG).show();
                Intent intentsettings = new Intent(getApplicationContext(),Settings.class);
                startActivity(intentsettings);
                this.finish();
                break;

            case R.id.nav_feedback:
                Toast.makeText(getApplicationContext(),"feedback is selected",Toast.LENGTH_LONG).show();
                Intent intentfeedback = new Intent(getApplicationContext(),Feedback.class);
                startActivity(intentfeedback);
                break;

            case R.id.nav_aboutus:
                Toast.makeText(getApplicationContext(),"aboutus is selected",Toast.LENGTH_LONG).show();
                Intent intentaboutus = new Intent(getApplicationContext(),About.class);
                startActivity(intentaboutus);
                break;

            case R.id.nav_signOut:
                Toast.makeText(getApplicationContext(),"signout Successfully",Toast.LENGTH_LONG).show();
                Intent intentsignout = new Intent(getApplicationContext(),Login.class);
                SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedin",false);
                editor.commit();
                this.finish();
                startActivity(intentsignout);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
