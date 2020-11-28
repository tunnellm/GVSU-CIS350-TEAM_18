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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.colcalendar18.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

// Author: Marc


public class ManageColCal extends AppCompatActivity {

    private static boolean validateFields(View view, String... args) {
        /*
        * For use when validating whether the user has correctly entered information for
        * each of the required fields of a given form.
        * :return: returns true if none of the fields match empty string else false
        * */
        boolean isTrue = true;
        for (String arg : args) {
            if (arg.equals("")) {
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

        /* Instantiate the fragments here before attempting to open table that depends on them*/
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new CourseFragment());
        sectionsPagerAdapter.addFragment(new AssignmentsFragment());

        setContentView(R.layout.activity_add_assignments);




        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        /* This is where we add our tabular fragments*/


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

                            Log.d("coursename ", courseName);
                            Log.d("hourse ", courseHours);
                            if (validateFields(view, courseName, courseHours)){

                                String snackString = "Successfully added " + courseName;
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
                            break;

                        case "assignments":
                            /*Handles instantiating courses
                            * Validates if the fields are entered in the fields in the correct manner
                            * and then instantiates a new assignment via Course Class based on that
                            * information. Refreshes if the information has been inputted correctly.*/
                            Log.d("In ASsignments ", tabName);
                            /* spinnerAssignmentField returns the text value of the selected course in the assignments tab*/

                            final Spinner spinnerAssignmentField = (Spinner) findViewById(R.id.CoursesSpinner);
                            final EditText weightingField = findViewById(R.id.AssignmentWeighting);
                            final EditText assignmentNameField = findViewById(R.id.AssignmentName);
                            final EditText assignmentPointsField = findViewById(R.id.AssignmentPoints);
                            final DatePicker assignmentDueDateField = findViewById(R.id.assignmentsDatePicker);

                            /* The follow holds the values that the user entered in the above fields*/
                            String selectedCourse = spinnerAssignmentField.getSelectedItem().toString();
                            String courseWeighting = weightingField.getText().toString();
                            Log.d("boop", courseWeighting);
                            String assignmentName = assignmentNameField.getText().toString();
                            String assignmentPoints = assignmentPointsField.getText().toString();

                            int assignmentDOM = assignmentDueDateField.getDayOfMonth();
                            int assignmentMO = assignmentDueDateField.getMonth();
                            int assignmentYR = assignmentDueDateField.getYear();

                            Calendar calendar = Calendar.getInstance();

                            /* The follow code snippet displays the correct snackbar string letting the user know what
                            * information they have incorrectly entered.*/
                            if (validateFields(view, courseWeighting, assignmentName, assignmentPoints)){
                                String snackSnack = "";
                                if(Double.parseDouble(courseWeighting) >= 1)
                                    snackSnack = "Weighting Must Be Less Than 1";
                                if(assignmentDOM == calendar.get(Calendar.DAY_OF_MONTH) && assignmentMO == calendar.get(Calendar.MONTH) && assignmentYR == calendar.get(Calendar.YEAR)){
                                    if(!snackSnack.equals(""))
                                        snackSnack += "\n";
                                    snackSnack += "Selected Date Must Be Different From Today's Date";
                                }
                                if(snackSnack.equals("")) {
                                    Log.d("parsedouble", String.valueOf(Double.parseDouble(courseWeighting)));
                                    Course.courseHashMap.get(selectedCourse).createAssignment(Double.parseDouble(courseWeighting), Integer.parseInt(assignmentPoints), assignmentName, assignmentYR, assignmentMO, assignmentDOM);
                                    snackSnack = "Correctly Added Assignment to " + selectedCourse;
                                    assignmentDueDateField.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                                    assignmentPointsField.getText().clear();
                                    weightingField.getText().clear();
                                    assignmentNameField.getText().clear();

                                }
                                Snackbar.make(view, snackSnack, Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                            break;
                        case "event":
                            break;
                        default:
                            Log.d("DEFAULT", "yes");




                    }


                    // Change listener to instantiate class assignment, course, event based on tab selected
                    // Needs to show classes in here

                }
            }
        });

    }

}