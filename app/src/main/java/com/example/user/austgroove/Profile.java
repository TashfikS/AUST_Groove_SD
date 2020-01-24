package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


class UserProfile{

    public String name,email,yearSemester,section,password;

}
public class Profile extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseApp firebaseApp;
    private DatabaseReference databaseReference;
    private String userID;
    private TextView userTV,emailTV,semesterTV,sectionTV;
    List<UserProfile> userProfile;
    SharedPreferences.Editor editor;
    private RelativeLayout layout;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        layout = findViewById(R.id.Profile_layoutID);
        databaseReference = FirebaseDatabase.getInstance().getReference("UserDetails");

        //Check if DarkMode is activated previously by a user or not
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
        }

        userTV = findViewById(R.id.user_nameID);
        emailTV = findViewById(R.id.user_emailID);
        semesterTV = findViewById(R.id.user_semesterID);
        sectionTV = findViewById(R.id.user_sectionID);
        userProfile = new ArrayList<>();



    }

    @Override
    protected void onStart() {
        // Set previous  value if internet is not available
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        userTV.setText(sharedPreferences.getString("userName",""));
        emailTV.setText(sharedPreferences.getString("userEmail",""));
        semesterTV.setText(sharedPreferences.getString("userSemester",""));
        sectionTV.setText(sharedPreferences.getString("userSection",""));



        databaseReference.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userProfile.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    UserProfile user2;
                    UserProfile user = dataSnapshot1.getValue(UserProfile.class);
                    userProfile.add(user);

                }


                for (UserProfile userProfile1 : userProfile){
                    SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
                    String useremail = sharedPreferences.getString("userEmail","");
                    if(sharedPreferences.contains("userEmail")){
                        if ((userProfile1.email.equals(useremail))){
                            userTV.setText(userProfile1.name);
                            emailTV.setText(userProfile1.email);
                            semesterTV.setText(userProfile1.yearSemester);
                            sectionTV.setText(userProfile1.section);

                            // Store the value in SharedPreference
                            sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
                            editor = sharedPreferences.edit();
                            editor.putString("userName",userProfile1.name);
                            editor.putString("userSemester",userProfile1.yearSemester);
                            editor.putString("userSection",userProfile1.section);
                            editor.putString("userPassword",userProfile1.password);
                            editor.commit();
                        }

                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Unavailable Internet Connection",Toast.LENGTH_LONG).show();

            }

        });
        super.onStart();
    }
}
