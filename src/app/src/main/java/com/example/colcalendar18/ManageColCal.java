package com.example.colcalendar18;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.colcalendar18.ui.main.AssignmentsFragment;
import com.example.colcalendar18.ui.main.CourseFragment;
import com.example.colcalendar18.ui.main.EventFragment;
import com.example.colcalendar18.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

/**
 * This Class manages all of the tabular fragments
 *
 * @Author Marc
 * @Author Daniel
 */


public class ManageColCal extends AppCompatActivity {

    //persistent file names for saving
    private static final String COURSES_FILE = "courses.txt";
    private static final String ASSIGNS_FILE = "assigns.txt";
    private static final String EVENTS_FILE = "events.txt";
    private static final String DELIMITER = "\f";

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
        // Makes a snackbar if not successfully validated
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
        sectionsPagerAdapter.addFragment(new EventFragment());

        setContentView(R.layout.activity_add_assignments);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);


        // Clicking on tabs and the +1 button
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        final Intent intent = getIntent();
        final Calendar calendar = Calendar.getInstance();


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

                            if (validateFields(view, courseName, courseHours)) {

                                //saves course to courses.txt if valid
                                String printCourse = courseName + DELIMITER + courseHours + "\n";
                                saveToFile(printCourse, COURSES_FILE);

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
                            /* spinnerAssignmentField returns the text value of the selected course in the assignments tab*/

                            final Spinner spinnerAssignmentField = (Spinner) findViewById(R.id.CoursesSpinner);
                            final EditText weightingField = findViewById(R.id.AssignmentWeighting);
                            final EditText assignmentNameField = findViewById(R.id.AssignmentName);
                            final EditText assignmentPointsField = findViewById(R.id.AssignmentPoints);
                            final DatePicker assignmentDueDateField = findViewById(R.id.assignmentsDatePicker);

                            /* The follow holds the values that the user entered in the above fields*/

                            String selectedCourse = spinnerAssignmentField.getSelectedItem().toString();
                            String courseWeighting = weightingField.getText().toString();
                            String assignmentName = assignmentNameField.getText().toString();
                            String assignmentPoints = assignmentPointsField.getText().toString();

                            int assignmentDOM = assignmentDueDateField.getDayOfMonth();
                            int assignmentMO = assignmentDueDateField.getMonth();
                            int assignmentYR = assignmentDueDateField.getYear();



                            /* The follow code snippet displays the correct snackbar string letting the user know what
                             * information they have incorrectly entered.*/
                            if (validateFields(view, courseWeighting, assignmentName, assignmentPoints)) {

                                //saves assignments ti assigns.txt if valid


                                String snackSnack = "";
                                if (Double.parseDouble(courseWeighting) >= 1)
                                    snackSnack = "Weighting Must Be Less Than 1\n";
                                if (selectedCourse.equals("No Courses Added"))
                                    snackSnack += "Add a course first!";
                                if (assignmentDOM == calendar.get(Calendar.DAY_OF_MONTH) && assignmentMO == calendar.get(Calendar.MONTH) && assignmentYR == calendar.get(Calendar.YEAR)) {
                                    if (!snackSnack.equals(""))
                                        snackSnack += "\n";
                                    snackSnack += "Selected Date Must Be Different From Today's Date";
                                }
                                if (snackSnack.equals("")) {
                                    Course.courseHashMap.get(selectedCourse).createAssignment(Double.parseDouble(courseWeighting), Integer.parseInt(assignmentPoints), assignmentName, assignmentYR, assignmentMO, assignmentDOM);
                                    String printAssignment = selectedCourse + DELIMITER + courseWeighting + DELIMITER + assignmentPoints + DELIMITER + assignmentName + DELIMITER + assignmentYR + DELIMITER + assignmentMO + DELIMITER + assignmentDOM + "\n";
                                    saveToFile(printAssignment, ASSIGNS_FILE);
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
                        case "events":
                            final EditText eventNameField = findViewById(R.id.EventName);
                            final EditText eventDescriptionField = findViewById(R.id.EventDescription);
                            final DatePicker eventDatePickerField = findViewById(R.id.EventDatePicker);

                            String eventName = eventNameField.getText().toString();
                            String eventDescription = eventDescriptionField.getText().toString();

                            int eventDOM = eventDatePickerField.getDayOfMonth();
                            int eventMO = eventDatePickerField.getMonth();
                            int eventYR = eventDatePickerField.getYear();

                            if (validateFields(view, eventName, eventDescription)) {

                                //saves event to events.txt if valid
                                String printEvent = eventName + DELIMITER + eventDescription + DELIMITER + eventMO + DELIMITER + eventDOM + DELIMITER + eventYR + "\n";
                                saveToFile(printEvent, EVENTS_FILE);

                                new Event(eventName, eventDescription, eventMO, eventDOM, eventYR);
                                eventNameField.getText().clear();
                                eventDescriptionField.getText().clear();
                                eventDatePickerField.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                                Snackbar.make(view, "Added: " + eventName + "\n" + eventDescription, Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                            break;
                        default:


                    }


                    // Change listener to instantiate class assignment, course, event based on tab selected
                    // Needs to show classes in here

                }
            }
        });

    }

    public void saveToFile(String s, String FILE_NAME) {
        FileOutputStream fos = null;
        File file = new File(FILE_NAME);

        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(s.getBytes());
            System.out.println("saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}