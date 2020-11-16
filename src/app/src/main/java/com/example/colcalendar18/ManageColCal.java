package com.example.colcalendar18;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.colcalendar18.ui.main.CourseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.colcalendar18.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.Objects;


public class ManageColCal extends AppCompatActivity {
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignments);



        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        sectionsPagerAdapter.addFragment(new CourseFragment());

        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        final Intent intent = getIntent();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.fab) {
                    String tabName = Objects.requireNonNull(tabs.getTabAt(tabs.getSelectedTabPosition())).getText().toString().toLowerCase();
                    /* Handles adding course, assignments, and events.*/

                    switch (tabName) {

                        case "courses":
                            /* Handles instantiating courses.
                             * Checks if the user has correctly entered the information in the field
                             * and then instantiates a new course based on that information. Refreshes
                             * if the information has been put in correctly*/

                            final EditText courseField = (EditText) findViewById(R.id.EditCourseName);
                            final EditText hoursField = (EditText) findViewById(R.id.EditCourseHours);

                            String courseName = courseField.getText().toString();
                            String courseHours = hoursField.getText().toString();
                            String snackString = "";
                            if (courseName.matches("") || courseHours.matches("")) {
                                snackString = "You forgot to fill out one of the forms";
                                Snackbar.make(view, snackString, Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            } else {
                                snackString = "Successfully added " + courseName;
                                new Course(courseName, Integer.parseInt(courseHours));
                                courseField.getText().clear();
                                hoursField.getText().clear();
                                Runnable r = new Runnable() {
                                    @Override
                                    public void run() {
                                        finish();
                                        startActivity(getIntent());
                                    }
                                };
                                Handler handler = new Handler();
                                Snackbar.make(view, snackString, Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                handler.postDelayed(r, 250);

                            }


                            Log.d("qlop", courseName);
                            Log.d("qlop2", courseHours);
                        case "ASSIGNMENTS":

                    }


                    // Change listener to instantiate class assignment, course, event based on tab selected
                    // Needs to show classes in here

                }
            }
        });

    }

}