package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout relativeLayout01,relativeLayout02;
    private EditText unEditText, pwEditText;
    private Button loginButton,signupButton;
    private ProgressBar progressBarSignin;
    private FirebaseAuth mAuth;

    SharedPreferences.Editor editor;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativeLayout01.setVisibility(View.VISIBLE);
            relativeLayout02.setVisibility(View.VISIBLE);


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Check if it is logged in before,then this activity won't execute
        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.contains("isLoggedin")){
            Boolean isloggedin = sharedPreferences.getBoolean("isLoggedin",false);
            if (isloggedin){
                Intent intent = new Intent(getApplicationContext(),Home.class);
                this.finish();
                startActivity(intent);
            }
        }

        relativeLayout01 = findViewById(R.id.rellay1);
        relativeLayout02 = findViewById(R.id.rellay2);

        unEditText = findViewById(R.id.singInEmailEditText);
        pwEditText = findViewById(R.id.signInpwEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signUpButton);
        progressBarSignin=findViewById(R.id.signInProgressBar);
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(this);
        signupButton.setOnClickListener(this);

        handler.postDelayed(runnable,5000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                userlogin();
                break;

            case R.id.signUpButton:
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                break;


        }

    }
    private void userlogin() {
        final String username = unEditText.getText().toString().trim();
        final String password = pwEditText.getText().toString().trim();

        if(username.isEmpty()){
            unEditText.setError("Enter an Email");
            unEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            unEditText.setError("Enter a valid email address");
            unEditText.requestFocus();
            return;
        }

        if(password.isEmpty()){
            pwEditText.setError("Enter a username");
            pwEditText.requestFocus();
            return;
        }

        if(password.length()<6){
            pwEditText.setError("Minimum length of a password sbould be 6");
            pwEditText.requestFocus();
            return;
        }

        progressBarSignin.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBarSignin.setVisibility(View.GONE);

                if(task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    //Parmanent Login Store
                    SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedin",true);
                    editor.putString("userEmail",username);
                    editor.commit();
                }
                else{
                    SharedPreferences sharedPreferences = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);

                    if(username.equals(sharedPreferences.getString("userEmail","")) && password.equals(sharedPreferences.getString("userPassword",""))){
                        finish();
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
