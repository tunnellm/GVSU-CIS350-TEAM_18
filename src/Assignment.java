/**********************************************************************
 * (Work in Progress)
 * This class contains the properties of an assignment later used in
 * the Calendar class
 *********************************************************************/
public class Assignment() {

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
        Assignment a = new Assignment(100.00,"Low",true);
        System.out.println(a.getInfo());
    }
}
