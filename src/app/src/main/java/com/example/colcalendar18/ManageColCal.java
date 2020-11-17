package com.example.colcalendar18;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.colcalendar18.ui.main.AssignmentsFragment;
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
import android.widget.Spinner;

import com.example.colcalendar18.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.Objects;


public class ManageColCal extends AppCompatActivity {

    private static boolean validateFields(View view, String... args) {
        /*
        * For use when validating whether the user has correctly entered information for
        * each of the required fields of a given form.
        * :return: returns true if none of the fields match empty string else false
        * */
        boolean isTrue = true;
        for (String arg : args) {
            if (arg.matches("")) {
                isTrue = false;
                break;
            }
        }
        // Makes a snackbar if successfully validated
        if (!isTrue)
            Snackbar.make(view, "You forgot to fill out one of the forms", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        return isTrue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignments);



        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        /* This is where we add our tabular fragments*/
        sectionsPagerAdapter.addFragment(new CourseFragment());
        sectionsPagerAdapter.addFragment(new AssignmentsFragment());

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

                            /* courseField and hoursField returns the value of the text fields in Course tab*/
                            final EditText courseField = (EditText) findViewById(R.id.EditCourseName);
                            final EditText hoursField = (EditText) findViewById(R.id.EditCourseHours);

                            String courseName = courseField.getText().toString();
                            String courseHours = hoursField.getText().toString();
                            String snackString = "";
                            if (validateFields(view, courseName, courseHours)){
                                snackString = "Successfully added " + courseName;
                                Snackbar.make(view, snackString, Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
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
                                handler.postDelayed(r, 550);

                            }


                            Log.d("qlop", courseName);
                            Log.d("qlop2", courseHours);
                        case "assignments":
                            /* spinnerAssignmentField returns the text value of the selected course in the assignments tab*/
                            final Spinner spinnerAssignmentField = (Spinner) findViewById(R.id.CoursesSpinner);
                            String selectedAssignment = spinnerAssignmentField.getSelectedItem().toString();
                            Log.d("QOP", selectedAssignment);
                    }


                    // Change listener to instantiate class assignment, course, event based on tab selected
                    // Needs to show classes in here

                }
            }
        });

    }

}