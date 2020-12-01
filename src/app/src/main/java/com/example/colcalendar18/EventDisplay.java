package com.example.colcalendar18;

import java.util.ArrayList;
import java.util.HashMap;
// import android.widget.Toast;

/**********************************************************************
 * (WIP)
 * 
 * The following class is used by the MainEvent class to find Event
 * names and descriptions on a specific date.
 *
 * @Author Jack Groothuis
 *********************************************************************/

public class EventDisplay {
		
		// the integer represents the DateTime integer, and the HashMap
		// provides a place to store an ArrayList of strings based on
		// names and descriptions of events
		private static int date;
		private HashMap<Integer, ArrayList<String>> hm = new HashMap<>();

		// the default constructor assumes the date is some default number
		public EventDisplay() {
				date = 0;
		}

		// the next constructor parses a DateTime integer and uses a
		// method to display event names and descriptions for the
		// specified date (if any)
		public EventDisplay(int d) {
			date = d;
			this.displayInfo();
		}
		
		// this method is intended to display info from the constructor
		public void displayInfo() {
			ArrayList<String> nameDesc = new ArrayList<>();
			/*
			for (int i = 0; i < hm.get(date).size(); i++) {
				if(nameDesc.contains(hm.get(date).get(ArrayList<String>)) {
					nameDesc.add(hm.get(date).get())
				}
			}
			@TheIinTeam Keep working on this method
			*/

			for(int i = 0; i < nameDesc.size(); i++) {
				System.out.println(nameDesc.get(i));
			}
		}

		// finally the main method is used to test the class if
		// constructors and/or methods are called
		public static void main(String[] args) {
			EventDisplay eD = new EventDisplay(5);
		}
}
