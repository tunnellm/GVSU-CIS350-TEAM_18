package com.example.colcalendar18;

public class Course {

    String courseName;
    int creditHours;

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void changeCourseName(String name) {
        this.courseName = name;
    }

    public String getCourseName() {
        return this.courseName;
    }


}
