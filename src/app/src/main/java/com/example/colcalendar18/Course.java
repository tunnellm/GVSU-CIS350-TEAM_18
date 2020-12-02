package com.example.colcalendar18;
// import gradeScale
import android.os.Build;

import androidx.annotation.RequiresApi;


import java.time.LocalDate;
import java.util.*;

    // Author: Marc


public class Course {



    String courseName;
    int creditHours;
    double classTotal;
    ArrayList<Assignment> assignments = new ArrayList<>();
    final Calendar calendar = Calendar.getInstance();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void algorithm () {

        // This sorts the assignment via our algorithm based on due date, points, and weighting.
        // There is logic that handles for when the player assigns a date that is in the next calendar year
        assignments.sort(new Comparator<Assignment>() {
                             @Override
                             public int compare(Assignment first, Assignment second) {
                                 int f = first.getDOY() - LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)).getDayOfYear();
                                 if (f < 0) {
                                     f = (first.getDOY() - (365 - LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)).getDayOfYear()));
                                 }
                                 int s = second.getDOY() - LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)).getDayOfYear();
                                 if (s < 0) {
                                     s = (second.getDOY() - (365 - LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)).getDayOfYear()));
                                 }
                                 return (int)
                                         (
                                         (f * second.getWeight() * 100) -

                                         (s * first.getWeight()) * 100);
                             }
                         }

                );



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Assignment> assignmentsList() {
        algorithm();
        return assignments;
    }


}

