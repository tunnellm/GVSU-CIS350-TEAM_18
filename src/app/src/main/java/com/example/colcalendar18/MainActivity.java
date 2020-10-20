package com.example.colcalendar18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Course course = new Course("CIS 350", 10);
        setContentView(R.layout.activity_main);
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setDate(calendar.getDate());




//        File file = new File(getFilesDir(), "course.properties");
//        Log.d("F", file.getAbsolutePath()); 
//        Intent intent = new Intent(this, ExitService.class);
//            startService(intent);

    }
}