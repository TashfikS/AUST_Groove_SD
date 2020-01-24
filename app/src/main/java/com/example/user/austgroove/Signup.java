package com.example.user.austgroove;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity implements View.OnClickListener{
    private EditText nameEditText,emailEditText,secEditText,yrEditText,pwEditText;
    private Button registerButton,backButton;
    private ProgressBar progressBarSignUp;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        databaseReference = FirebaseDatabase.getInstance().getReference("UserDetails");

        mAuth = FirebaseAuth.getInstance();

        nameEditText=findViewById(R.id.signUpNameEditText);
        emailEditText=findViewById(R.id.emailEditText);
        secEditText=findViewById(R.id.sectionEditText);
        yrEditText=findViewById(R.id.yearSemesterEditText);
        pwEditText=findViewById(R.id.passwordEditText);
        registerButton=findViewById(R.id.registerButton);
        backButton=findViewById(R.id.backButton);
        progressBarSignUp=findViewById(R.id.signUpProgressBar);

        registerButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerButton:
                if(userRegister()){
                    Intent loginintent = new Intent(getApplicationContext(),Login.class);
                    this.finish();
                    startActivity(loginintent);
                }

                break;

            case R.id.backButton:
                onBackPressed();
                this.finish();
                break;
        }

    }

    private Boolean userRegister() {
        final String email= emailEditText.getText().toString().trim();
        final String password=pwEditText.getText().toString().trim();
        final String name = nameEditText.getText().toString();
        final String section = secEditText.getText().toString();
        final String Yearsemester = yrEditText.getText().toString();


        progressBarSignUp.setVisibility(View.VISIBLE);

        if(email.isEmpty()){
            emailEditText.setError("Enter an email address");
            emailEditText.requestFocus();
            return false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Enter a valid email address");
            emailEditText.requestFocus();
            return false;
        }

        if(password.isEmpty()){
            pwEditText.setError("Enter password");
            pwEditText.requestFocus();
            return false;
        }

        if(password.length()<6){
            pwEditText.setError("Enter valid password");
            pwEditText.requestFocus();
            return false;
        }
        if (name.isEmpty()){
            nameEditText.setError("Enter a real name");
            nameEditText.requestFocus();
            return false;
        }
        if(section.isEmpty()){
            secEditText.setError("Enter a Section(ex. A)");
            secEditText.requestFocus();
            return false;
        }
        if (Yearsemester.isEmpty()){
            yrEditText.setError("Enter a Year & Semester(ex. 1.1)");
            yrEditText.requestFocus();
            return false;
        }


        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBarSignUp.setVisibility(View.GONE);

                if(task.isSuccessful()){
                    SaveData(name,email,section,Yearsemester,password);
                    Toast.makeText(getApplicationContext(),"Register is complete",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Register is not complete",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return true;

    }

    private void SaveData(String name,String email,String section,String Yearsemester,String password) {
        // Saving Data in Firebase Real Time Database
        String key = databaseReference.push().getKey();
        UserDetails userDetails = new UserDetails(name,email,section,Yearsemester,password);
        databaseReference.child(key).setValue(userDetails);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
