import java.util.ArrayList;
import java.util.Scanner;

/**********************************************************************
 * This class extends Assignment objects to provide a grade for each
 * grouping of assignments.
 * @Author Jack Groothuis
 * @Version Fall 2020
 *********************************************************************/
public class Grading extends Assignment {

	/******************************************************************
	 * These private variables indicate the basic information found
	 * within a Grading object.
	 *****************************************************************/
	private ArrayList<Assignment> assignList;
	private double grade;
	
	/******************************************************************
	 * This empty constructor creates an empty ArrayList of Assignments
	 * to be edited and modified by the methods below.
	 *****************************************************************/
	public Grading() {
		assignList = new ArrayList<Assignment>();
		grade = 0.00;
	}
	
	/******************************************************************
	 * This method returns only the current grade.
	 * @return the grade in the form of a percentage x 100
	 * (e.g. 100.00 = 100.00%) 
	 *****************************************************************/
	public double getGrade() {
		return grade;
	}

	/******************************************************************
	 * This method returns only the assignments in their .getInfo()
	 * strings.
	 * @return the grade in the form of a percentage (100.00 = 100.00%) 
	 *****************************************************************/
	public String getAssignments(){
		String s = "\n";
		for(int i = 0; i < assignList.size(); i++){
			s += assignList.get(i).getInfo();
			if(i != assignList.size()-1){
				s += "\n";
			}
		}
		return s;
	}

	/******************************************************************
	 * This method adds an Assignment object to the ArrayList stored
	 * in the Grading object.
	 * @param a represents the chosen Assignment
	 *****************************************************************/
	public void add(Assignment a){
		assignList.add(a);
		updateGrade();
	}

	/******************************************************************
	 * This method removes an Assignment object from the ArrayList
	 * stored in the Grading object.
	 * @param a represents the chosen Assignment
	 *****************************************************************/
	public void remove(Assignment a){
		assignList.remove(a);
		updateGrade();
	}

	/******************************************************************
	 * This method clears the ArrayList of Assignments and updates
	 * the grade variable back to 0.0 with updateGrade()
	 *****************************************************************/
	public void clear(){
		assignList.clear();
		updateGrade();
	}

	/******************************************************************
	 * This method updates the grade variable by taking every
	 * Assignment from the ArrayList and finding the mean for the new
	 * grade percentage.
	 *****************************************************************/
	public void updateGrade(){
		double sum = 0.0;
		for(int i = 0; i < assignList.size(); i++){
			sum += assignList.get(i).getGrade();
		}
		if(assignList.size() < 1){
			grade = 0;
		}else {
			grade = (sum / (double)assignList.size());
		}
	}

	/******************************************************************
	 * This method prints out each Assignment object by its given info
	 * and shows the average grade from all of them.
	 * @return a string showing the assignments and overall grade
	 *****************************************************************/
	public String toString() {
		String s = "";
		if (assignList.size() == 0){
			s += "[No Assignments] ";
			}else {
				for(int i = 0; i < assignList.size(); i++){
					s += "[" + assignList.get(i).getInfo() + "], ";
				}
			}
		s += getGrade();
		return s;
	}

	/******************************************************************
	 * This is the main method. It is used as a test bench to make sure
	 * any constructor(s) and/or method(s) function propertly.
	 *****************************************************************/
	public static void main(String [] args){
		System.out.println("---Testing Constructor(s)---");
		// Testing the empty constructor
		Grading g = new Grading();
		// (also testing toString() for the first time)
		System.out.println("First Grading object initialized.\nDefau" +
			"lt Values: " + g.toString());
		System.out.println("---Testing Current Methods---");
		System.out.println("Adding in 2 Assignments...");
		// Adding and reassuring the Assignment class is working
		Assignment a1 = new Assignment(85.50, "medium", true);
		System.out.println(a1.getInfo());
		// Then actually adding them to the Grade object
		g.add(a1);
		Assignment a2 = new Assignment(95.00, "high", true);
		System.out.println(a2.getInfo());
		g.add(a2);
		System.out.println("Grading object shows: " + g.toString());
		// Showing only the assignments, then only the grade with
		// getAssignments() and getGrade()
		System.out.println("Showing only Assignments:" + g.
			getAssignments());
		System.out.println("Showing only overall grade: " + g.getGrade(
			));
		System.out.print("Teacher will drop the lowest grade...\nNew" +
			" results: ");
		// Removing the first (and lowest) grade to show remove() works
		g.remove(a1);
		System.out.println(g.toString());
		// Clearing out the Grading object
		System.out.println("Semester's over. Clearing out Grading ob" +
			"ject...");
		g.clear();
		System.out.println(g.toString()); 
		System.out.println("---Tests Complete---");
	}
}
