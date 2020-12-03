package com.example.colcalendar18;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    CalendarView calendar;
    private int notificationID = 1;
    private Button loadCourses;
    EventDisplay eventDisplay = new EventDisplay();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setDate(calendar.getDate());
        

        /* This overwritten method determines if the selected date is a
         * US Holiday using switch/case and if statements to determine
         * the correct date. (10 Total)
         */
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                EventDisplay.populateList();
                eventDisplay.displayInfo(getApplicationContext(), LocalDate.of(year, month + 1, dayOfMonth).getDayOfYear());
            }
        });

        loadCourses = findViewById(R.id.managecourse);
        loadCourses.setOnClickListener(this);
        findViewById(R.id.notificationon).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.managecourse) {

            /* "Manage ColCalendar button main page */
            Intent intent = new Intent(this, ManageColCal.class);
            startActivity(intent);
        }
        //Intent for notification
        Intent intent = new Intent(MainActivity.this , notificationReciever.class);
        intent.putExtra("notificationID", notificationID);
        intent.putExtra("message" , "You have an assignment due soon");

        //Pending Intent for notification
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        //Alarm manager for timing of notification.
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            if (v.getId() == R.id.notificationon) {
                for (Map.Entry<String, Course> stringCourseEntry : Course.courseHashMap.entrySet()) {
                    Map.Entry element = (Map.Entry) stringCourseEntry;
                    Course curCourse = (Course) element.getValue();
                    for (int i = 0; i < curCourse.assignments.size(); i++) {
                        Calendar curDate = Calendar.getInstance();
                        int day = curCourse.assignments.get(i).getDayOfMonth();
                        int month = curCourse.assignments.get(i).getMonth()  ;
                        int year = curCourse.assignments.get(i).getYear();
                        if ((day == curDate.get(Calendar.DAY_OF_MONTH) || (day - 1) == curDate.get(Calendar.DAY_OF_MONTH)) && (curDate.get(Calendar.MONTH) == month) && (curDate.get(Calendar.YEAR) == year)) {
                            alarmManager.set(AlarmManager.RTC_WAKEUP, curDate.getTimeInMillis(), pendingIntent);
                        }
                    }
                }
            }

    }

}