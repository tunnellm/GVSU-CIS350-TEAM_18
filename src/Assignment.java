/**********************************************************************
 * (Work in Progress)
 * This class contains the properties of an assignment later used in
 * the Calendar class
 *********************************************************************/
public class Assignment {

    private double grade;
    private String priority;
    private boolean complete;

    public Assignment(){
        grade = 0.00;
        priority = "medium";
        complete = false;
    }

    public Assignment(double grade, String priority, boolean complete){
        this.grade = grade;
        this.priority = priority;
        this.complete = complete;
    }

    public double getGrade(){
        return grade;
    }

    public String getPriority(){
        return priority;
    }

    public boolean getComplete(){
        return complete;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }

    public void setPriority(String priority){
        this.priority = priority;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }

    public String getInfo(){
        String s = "";
        s += grade + " ";
        s += priority + " ";
        s += complete;
        return s;
    }

    public static void main(String[] args){
        System.out.println("---Testing Current Methods---");
        Assignment a0 = new Assignment();
        System.out.println("Assignment 0 (Default): " + a0.getInfo());
        Assignment a1 = new Assignment(100.00,"low",true);
        System.out.println("Assignment 1: " + a1.getInfo());
        System.out.println("Showing gets for Default:");
        System.out.println(a0.getGrade());
        System.out.println(a0.getPriority());
        System.out.println(a0.getComplete());
        System.out.println("\nSetting Default equal to Assignment 1...");
        a0.setGrade(100.00);
        a0.setPriority("low");
        a0.setComplete(true);
        if (a0.getInfo().equals(a1.getInfo())) {
            System.out.println("Correct! Results:");
        }else {
            System.out.println("Error");
        }
        System.out.println(a0.getInfo() + "\n" + a1.getInfo());
        System.out.println("--Test Complete--");
    }
}