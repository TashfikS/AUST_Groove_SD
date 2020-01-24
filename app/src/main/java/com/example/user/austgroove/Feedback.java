package com.example.user.austgroove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    private EditText nameText,messageText;
    private Button submitbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);



        nameText = findViewById(R.id.nameID);
        messageText = findViewById(R.id.messageID);
        submitbutton = findViewById(R.id.subumitID);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = nameText.getText().toString();
                    String message = messageText.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");

                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"rejone.hridoy@gmail.com"});

                    intent.putExtra(Intent.EXTRA_SUBJECT,"feedback from App");
                    intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name+"\nMessage: "+message);

                    startActivity(Intent.createChooser(intent," Feedback with "));


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please fill all fields",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}

