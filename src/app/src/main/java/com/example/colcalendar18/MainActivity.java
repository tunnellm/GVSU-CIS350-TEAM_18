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
import android.widget.Toast;


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

        /* This overwritten method determines if the selected date is a
         * US Holiday using switch/case and if statements to determine
         * the correct date. (10 Total)
         */
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                switch (month) {
                    case 0:
                        if (dayOfMonth == 1) {
                            Toast.makeText(MainActivity.this, "New Year's Day", Toast.LENGTH_SHORT).show();
                        }else if (dayOfMonth == 20) {
                            Toast.makeText(MainActivity.this, "Martin Luther King, Jr. Day", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        if (dayOfMonth == 17) {
                            Toast.makeText(MainActivity.this, "George Washington's Birthday", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        if (dayOfMonth == 25) {
                            Toast.makeText(MainActivity.this, "Memorial Day", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 6:
                        if (dayOfMonth == 4) {
                            Toast.makeText(MainActivity.this, "Independence Day", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 8:
                        if (dayOfMonth == 7) {
                            Toast.makeText(MainActivity.this, "Labor Day", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 9:
                        if (dayOfMonth == 12) {
                            Toast.makeText(MainActivity.this, "Columbus Day", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 10:
                        switch (dayOfMonth) {
                            case 11:
                                Toast.makeText(MainActivity.this, "Veterans Day", Toast.LENGTH_SHORT).show();
                                break;
                            case 26:
                                Toast.makeText(MainActivity.this, "Thanksgiving Day", Toast.LENGTH_SHORT).show();
                            default:
                                break;
                        }
                        break;
                    case 11:
                        if (dayOfMonth == 25) {
                            Toast.makeText(MainActivity.this, "Christmas Day", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        loadCourses = findViewById(R.id.managecourse);
        loadCourses.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.managecourse) {

            /* "Manage ColCalendar button main page */
            Course oneTest = new Course("Diversity", 3);
            Course twoTest = new Course("Linear Algebra", 4);
            Intent intent = new Intent(this, ManageColCal.class);
            startActivity(intent);

        }
    }

}