package com.example.colcalendar18;
// import gradeScale
import com.example.colcalendar18.ui.main.CourseFragment;

import java.util.*;

/*
*
* */

public class Course {

    String courseName;
    int creditHours;
    double classTotal;
    ArrayList<Assignment> assignments = new ArrayList<>();
    public static HashMap<String, Course> courseHashMap = new HashMap<>();

// Array list of weights here just not sure how to make them corresponds to assignment types yet

//    Obviously super basic and in need of tweeking but general idea rn. Weight is weight of assignment based on type (ie 15% for labs or something)
    public void calcPriority(Assignment temp, double weight){
        double result =  (temp.getTotalPoints() * weight * creditHours) / classTotal;
        temp.setPriority(result);
    }


    public void createAssignment(double priority, boolean complete, String desc, double earnedPoints, double totalPoints, String type) {
        Assignment temp = new Assignment(type);
        calcPriority(temp, 0);
        temp.setTotalPoints(totalPoints);
        temp.setEarnedPoints(earnedPoints);
        temp.setDesc(desc);
        temp.setComplete(complete);
        assignments.add(temp);
    }

    public void editAssignment(int index, boolean complete, String desc, double earnedPoints, double totalPoints, String type ){
        Assignment edit = assignments.get(index);
        edit.setComplete(complete);
        edit.setTotalPoints(totalPoints);
        edit.setDesc(desc);
        edit.setEarnedPoints(earnedPoints);
        edit.setType(type);
        assignments.add(index,edit);
    }

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        courseHashMap.put(this.getCourseName(), this);
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }
    public double getClassTotal() { return classTotal; }

    public void setClassTotal(double classTotal) { this.classTotal = classTotal; }

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

