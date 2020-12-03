package com.example.colcalendar18;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;

/**********************************************************************
 * (Work in Progress)
 * This class contains the properties of an event later used in
 * the Calendar class
 * @author Daniel Rose
 *********************************************************************/
public class Event{
    private int month;
    private int day;
    private int year;
    private String eventName;
    private String eventDescription;
    public static ArrayList<Event> eventsList = new ArrayList<>();


    public Event(){
        eventName = "Event";
        eventDescription = "Event Description";
        month = 1;
        day = 1;
        year = 2020;
    }

    public Event(String eventName, String eventDescription, int month, int day, int year){
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.month = month;
        this.day = day;
        this.year = year;
        eventsList.add(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getDOY() {
        return LocalDate.of(this.getYear(), this.getMonth() + 1, this.getDay()).getDayOfYear();
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getInfo(){
        return eventName + ": " + eventDescription + " | Month: "
                + month + " Day: " + day + " Year: " + year;
    }

    public static void main(String[] args){
        System.out.println("---Testing Current Methods---");
        Event e0 = new Event();
        System.out.println(e0.getInfo());
        Event e1 = new Event("Career Fair", "GVSU Career Fair", 1 , 1 , 1);
        System.out.println(e1.getEventName());
        e1.setEventName("GVSU Career Fair");
        System.out.println(e1.getEventDescription());
        e1.setEventDescription("Online Career Fair for current and former GVSU Students");
        System.out.println(e1.getMonth());
        e1.setMonth(10);
        System.out.println(e1.getDay());
        e1.setDay(15);
        System.out.println(e1.getYear());
        e1.setYear(2020);
        System.out.println("Change info with set methods...");
        System.out.println(e1.getInfo());
        System.out.println("---All Methods Tested---");
    }

}