package com.example.colcalendar18;
// import assignment
// import grade-scale
import java.util.*;

/*
*
* */

public class Course<Assignment> {


    String courseName;
    int creditHours;
    ArrayList<Assignment> assignments = new ArrayList();

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public void setCreditHours(int hours) {
        this.creditHours = hours;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void assignmentsList() {
        // TO-DO; Populate list with assignments and corresponding weighting
    }
}
