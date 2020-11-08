package com.example.colcalendar18;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    CalendarView calendar;

    private Button loadCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setDate(calendar.getDate());

        loadCourses = findViewById(R.id.managecourse);
        loadCourses.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.managecourse) {
            Course oneTest = new Course("Diversity", 3);
            Course twoTest = new Course("Linear Algebra", 4);
            Intent intent = new Intent(this, ManageColCal.class);
            startActivity(intent);

        }
    }

}