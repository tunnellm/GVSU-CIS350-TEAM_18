package com.example.colcalendar18;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import com.example.colcalendar18.Course;
import com.example.colcalendar18.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.FileInputStream;
import java.util.Map;


// import android.widget.Toast;

/**********************************************************************
 *
 * The following class is used by the MainEvent class to find Event
 * names and descriptions on a specific date.
 *
 * @Author Marc
 *********************************************************************/

public class EventDisplay {

    // the integer represents the DateTime integer, and the HashMap
    // provides a place to store an ArrayList of strings based on
    // names and descriptions of events
    private static int date;
    private static HashMap<Integer, List<String>> hm = new HashMap<>();

    // the default constructor assumes the date is some default number
    public EventDisplay() {
        date = 0;
    }

    // the next constructor parses a DateTime integer and uses a
    // method to display event names and descriptions for the
    // specified date (if any)
//    public EventDisplay(int d) {
//        date = d;
//        this.displayInfo();
//    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void populateList() {
        // Assignments by Marc
        Iterator chmIterator = Course.courseHashMap.entrySet().iterator();
        while(chmIterator.hasNext()) {
            Map.Entry element = (Map.Entry)chmIterator.next();
            Course course = (Course) element.getValue();
            for (Assignment ass : course.assignmentsList()) {
                String boop = assignmentsStuff(ass);
                try  {
                    if (!hm.get(ass.getDOY()).contains(boop)){
                        hm.get(ass.getDOY()).add(boop);
                    }
                } catch (NullPointerException q) {
                    hm.put(ass.getDOY(), new ArrayList<String>());
                    hm.get(ass.getDOY()).add(boop);
                }
            }
        }

        for (Event ev : Event.eventsList) {
            String evString = "\nEvent: " +  ev.getEventName() + "\nDescription: " + ev.getEventDescription() + "\n";
            try {
                if (!hm.get(ev.getDOY()).contains(evString)) {
                    hm.get(ev.getDOY()).add(evString);
                }
            } catch (NullPointerException q) {
                hm.put(ev.getDOY(), new ArrayList<String>());
                hm.get(ev.getDOY()).add(evString);
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static String assignmentsStuff(Assignment assignment) {
        StringBuilder boop = new StringBuilder();
        boop.append("\nAssignment Name: ").append(assignment.getAssignmentName()).append("\n");
        boop.append("Assignment Weighting: ").append(Double.valueOf(assignment.getWeight())).append(", Points: ")
                .append(assignment.getTotalPoints()).append("\n");
        boop.append("Assignment Due Date: ").append(assignment.getDueDate()).append("\n");
        return String.valueOf(boop);
    }


    // this method is intended to display info from the constructor
    public void displayInfo(Context context, int DOY) {
        String sb = "";
        try {

            for (String s : hm.get(DOY)) {
                sb += s;
            }
        } catch (NullPointerException q) {
            sb = "No Events";
        }

        Toast.makeText(context, sb, Toast.LENGTH_SHORT).show();

    }

    // finally the main method is used to test the class if
    // constructors and/or methods are called
//    public static void main(String[] args) {
//        EventDisplay eD = new EventDisplay(5);
//    }
}
