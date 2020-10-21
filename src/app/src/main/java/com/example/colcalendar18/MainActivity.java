package com.example.colcalendar18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import com.example.colcalendar18.CourseCatalog;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setDate(calendar.getDate());

        CourseCatalog courseCatalog = new CourseCatalog();

        courseCatalog.saveState("testing", getApplicationContext());

    }
}