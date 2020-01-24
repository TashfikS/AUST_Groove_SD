package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;

public class Settings extends AppCompatActivity implements View.OnClickListener,EditDialog.EditDialogListener {

    private Switch DarkMode;
    private RelativeLayout layout;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String Text;
    private Boolean isEdited = false;
    private TextView UserNameTV,EmailTV,SemesterTV,SectionTV,PhoneTV;
    private Button UsernameEB , PhoneNumberEB , SemesterEB, SectionEB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        layout = findViewById(R.id.SettingslayoutID);
        DarkMode  = findViewById(R.id.darkModeSwitchID);
        UserNameTV = findViewById(R.id.Settings_UsernameTVID);
        EmailTV = findViewById(R.id.Settings_EmailTVID);
        SemesterTV = findViewById(R.id.Settings_SemesterTVID);
        SectionTV = findViewById(R.id.Settings_SectionTVID);
        UsernameEB = findViewById(R.id.Settings_UsernameButton);
        PhoneNumberEB = findViewById(R.id.Settings_PhoneButton);
        SemesterEB = findViewById(R.id.Settings_SemesterButton);
        SectionEB = findViewById(R.id.Settings_SectionButton);
        PhoneTV = findViewById(R.id.Settings_PhoneTV);

        //Check if DarkMode is activated previously by a user or not
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
            DarkMode.setChecked(true);
        }
        // Set the user information through SharedPreference
        UserNameTV.setText(sharedPreferences.getString("userName",""));
        EmailTV.setText(sharedPreferences.getString("userEmail",""));
        SemesterTV.setText(sharedPreferences.getString("userSemester",""));
        SectionTV.setText(sharedPreferences.getString("userSection",""));


        UsernameEB.setOnClickListener(this);
        PhoneNumberEB.setOnClickListener(this);
        SemesterEB.setOnClickListener(this);
        SectionEB.setOnClickListener(this);


        DarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layout.setBackgroundColor(Color.DKGRAY);
                    Toast.makeText(getApplicationContext(),"Dark Mode activated",Toast.LENGTH_LONG).show();
                    sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("DarkMode",true);
                    editor.commit();
                }
                else{
                    layout.setBackgroundColor(Color.WHITE);
                    Toast.makeText(getApplicationContext(),"Dark Mode Deactivated",Toast.LENGTH_LONG).show();
                    sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("DarkMode",false);
                    editor.commit();

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Settings_UsernameButton :
                openDialog();
                if(isEdited){
                    UserNameTV.setText(Text);
                    isEdited = false;
                }

                break;
            case R.id.Settings_PhoneButton :
                openDialog();
                if(isEdited){
                    PhoneTV.setText(Text);
                    isEdited = false;
                }

                break;
            case R.id.Settings_SemesterButton:
                openDialog();
                if(isEdited){
                    SemesterTV.setText(Text);
                    isEdited = false;
                }

                break;
            case R.id.Settings_SectionButton:
                openDialog();
                if(isEdited){
                    SectionTV.setText(Text);
                    isEdited = false;
                }

                break;

        }
    }

    public void openDialog() {
        EditDialog editDialog = new EditDialog();
        editDialog.show(getSupportFragmentManager(), "edit dialog");
        Text = applyTexts(Text,isEdited);
    }

    @Override
    public String applyTexts(String Text,Boolean isEdited) {
        this.Text = Text;
        //Text = "";
        this.isEdited = isEdited;
        return Text;
    }

    @Override
    public void onBackPressed() {
        this.finish();
        Intent Homeintent = new Intent(getApplicationContext(),Home.class);
        startActivity(Homeintent);
    }
}
