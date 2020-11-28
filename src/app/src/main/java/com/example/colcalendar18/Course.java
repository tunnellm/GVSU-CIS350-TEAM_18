package com.example.colcalendar18;
// import gradeScale
import com.example.colcalendar18.ui.main.CourseFragment;

import java.util.*;

    // Author: Marc

public class Course {



    String courseName;
    int creditHours;
    double classTotal;
    ArrayList<Assignment> assignments = new ArrayList<>();
    /*
    * Courses hashmap for use by other classes.
    * Automatically adds to hashmap when course is instantiated*/
    public static HashMap<String, Course> courseHashMap = new HashMap<>();

// Array list of weights here just not sure how to make them corresponds to assignment types yet

//    Obviously super basic and in need of tweeking but general idea rn. Weight is weight of assignment based on type (ie 15% for labs or something)
    public void calcPriority(Assignment temp, double weight){
        double result =  (temp.getTotalPoints() * weight * creditHours) / classTotal;
        temp.setPriority(result);
    }


    public void createAssignment(double weighting, int totalPoints, String assignmentName, int year, int month, int dayOfMonth) {
        Assignment temp = new Assignment();
        temp.setAssignmentName(assignmentName);
//        calcPriority(temp, 0);
        temp.setTotalPoints(totalPoints);
        temp.setEarnedPoints(0);
        temp.setWeight(weighting);
        temp.setComplete(false);
        temp.setDueDate(year, month, dayOfMonth);
        assignments.add(temp);
    }

    public void editAssignment(int index, boolean complete, double weight, double earnedPoints, double totalPoints, double type ){
        Assignment edit = assignments.get(index);
        edit.setComplete(complete);
        edit.setTotalPoints(totalPoints);
        edit.setWeight(weight);
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

    public ArrayList<Assignment> assignmentsList() {
        return assignments;
    }

}

