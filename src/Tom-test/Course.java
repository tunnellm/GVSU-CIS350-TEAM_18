//Gunnna be honest cant remember how to package classes together

// import gradeScale
//import assignment;
import java.util.*;

/*
*
* */

public class Course<GradeScale, Assignment> {


    String courseName;
    int creditHours;
    ArrayList<Assignment> assignments = new ArrayList();
    ArrayList<GradeScale> gradeScale = new ArrayList();
// Array list of weights here just not sure how to make them corresponds to assignment types yet

    //Obviously super basic and in need of tweeking but general idea rn.
    public void calcPriority(Assignment temp, double weight){
        double result =  temp.getTotalPoints * weight * creditHours;
        temp.priority = result;
    }

    public Assignment createAssignment(double priority, boolean complete, String desc, double earnedPoints, double totalPoints, String type) {
        Assignment temp = new Assignment(type);
        calcPriority(temp);
        temp.setTotalPoints(totalPoints);
        temp.setEarnedPoints(earnedPoints);
        temp.setDesc(desc);
        temp.setComplete(complete);
        assignments.add(temp);

    }

    public void editAssignment(int index,boolean complete, String desc, double earnedPoints, double totalPoints, String type ){
        Assignment edit = assignments.get(index)
        edit.complete = complete;
        edit.totalPoints = totalPoints;
        edit.desc = desc;
        edit.earnedPoints = earnedPoints;
        edit.type = type;
        assignments.add(index,edit);
    }

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    public int getCreditHours() {
        return this.creditHours;
    }

    public void addAssignment(Assignment assignment, GradeScale gradeScale) {
        this.assignments.add(assignment);
        this.gradeScale.add(gradeScale);
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

