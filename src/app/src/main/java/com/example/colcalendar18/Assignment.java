package com.example.colcalendar18;

import android.os.Build;
import android.text.format.DateFormat;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Assignment {

    private double totalPoints;
    private double earnedPoints;
    private double weight;
    private boolean complete;
    private double type;
    private String assignmentName;
    private int year;
    private int month;
    private int dayOfMonth;
    //Priority = num between 1-100 from some calc in class based on type, points avaliable, and class credits.
    private double priority;

    public Assignment(){
    }

    public void setDueDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDueDate() {
        Month.of(this.month).name();

        String string = Month.of(this.month + 1).name() + "/" + this.dayOfMonth + "/" + this.year;


        return string ;
    }

    public void setAssignmentName(String name) {
        this.assignmentName = name;
    }

    public String getAssignmentName() {
        return this.assignmentName;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public double getType() {
        return type;
    }

    public void setType(double type) {
        this.type = type;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }



}