package com.example.user.austgroove;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.user.austgroove.R;

import java.util.Calendar;



public class addReminder extends AppCompatActivity {

    private int notificationId = 1;
    TextView date_tv,time_tv;
    TimePickerDialog timePickerDialog;
    Button dateB,timeB,setB,setC;
    DatePickerDialog datePickerDialog;


    EditText editText;
    Calendar calendar;
    int year;
    int month;
    int dayOfMonth;
    int currentHour;
    int currentMinute;
    String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);


        setB=findViewById(R.id.setBtn);
        setC=findViewById(R.id.cancelBtn);
        dateB=findViewById(R.id.dateB);
        timeB=findViewById(R.id.timeB);
        editText = findViewById(R.id.editText);

        date_tv =findViewById(R.id.DatePicker_tv);
        time_tv=findViewById(R.id.timePicker_tv);




        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo", editText.getText().toString());

        // getBroadcast(context, requestCode, intent, flags)
        final PendingIntent alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);

        final AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        dateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(addReminder.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date_tv.setText(day + "/" + (month + 1) + "/" + year);
                                String date = day + "/" + (month + 1) + "/" + year;
                                SharedPreferences sharedPreferences = getSharedPreferences("Reminder",Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor =sharedPreferences.edit();
                                editor.putString("date", date);
                                editor.apply();
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        timeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(addReminder.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        time_tv.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                        String time = String.format("%02d:%02d", hourOfDay, minutes) + amPm;
                        SharedPreferences sharedPreferences = getSharedPreferences("Reminder",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sharedPreferences.edit();
                        editor.putString("Time", time);
                        editor.apply();
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();



            }
        });

        setC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCancel = new Intent(getApplicationContext(), Reminder.class);
                startActivity(intentCancel);
            }
        });
        setB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int hour = currentHour;
                int minute = currentMinute;

                // Create time.
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();


                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                Toast.makeText(addReminder.this, "Done!", Toast.LENGTH_SHORT).show();

                Intent intentSet = new Intent(getApplicationContext(),Reminder.class);
                startActivity(intentSet);

                String taskName = editText.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences("Reminder",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("name", taskName);
                editor.apply();
            }
        });
    }
}
