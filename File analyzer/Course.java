
import java.util.Scanner;

public class Course implements DirectlyRelatable, Cloneable {

	//5 variables, courseID has to be UNIQUE<----
	protected String courseID;
	protected String courseName;
	protected double credit;
	protected String preReqID;
	protected String coReqID;
	
	Scanner sc = new Scanner(System.in);
	
	//constructors
	//default
	public Course() {
		courseID="ENGR233";
		courseName="ads";
		credit=3.5;
		preReqID="ads";
		coReqID="ads";
	}
	//Parameterized constructor
	public Course(String courseID,String courseName,double credit,String preReqID,String coReqID) {
		this.courseID=courseID;
		this.courseName=courseName;
		this.credit=credit;
		this.preReqID=preReqID;
		this.coReqID=coReqID;
	}
	//copy constructor, except courseID which remains unique
	public Course(Course c, String uniqueCourseID) {
		courseID=uniqueCourseID;
		courseName=c.courseName;
		credit=c.credit;
		preReqID=c.preReqID;
		coReqID=c.coReqID;
	}
	
	//beginning of methods
	
	
	public Course clone(){

        System.out.print("Please enter new course ID for clone course: ");
        String ID = sc.next();

        try{
            Course clone = (Course)super.clone();
            clone.courseID = ID;
            return clone;
        } catch (CloneNotSupportedException e){
            return null;
        }


    }
	
	public String toString() {
		return("This course of ID: "+courseID+" of name: "+courseName+" is "+credit+" credits, requires "+preReqID+" as prerequisites, and "+coReqID+" as corequisites.");
	}
	public boolean equals(Object x) {
		if(x==null||getClass() !=x.getClass())
			return false;
		else {
			Course otherC=(Course)x;
			return(otherC.getCourseName()==this.courseName&&otherC.credit==this.credit&&otherC.getPreReqID()==this.preReqID&&otherC.coReqID==this.coReqID);
		}
	}
	
	//implementing interface method
	
	public boolean isDirectlyRelatable(Course c) {
		// The method isDirectlyRelated that takes in
		//another Course object C and should return true if C is pre-requisite or co-requisite of the current
		//course object, or vice-versa (hence the courses are directly related); otherwise it returns false
		if(c==null)
			return false;
		else if(!(c instanceof Course))
			return false;
		else {
			return(c.coReqID==this.coReqID&&c.preReqID==this.preReqID);
		}
	}
	
	//get/setters
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getPreReqID() {
		return preReqID;
	}
	public void setPreReqID(String preReqID) {
		this.preReqID = preReqID;
	}
	public String getCoReqID() {
		return coReqID;
	}
	public void setCoReqID(String coReqID) {
		this.coReqID = coReqID;
	}
	
	
	
	
	
	
	
	

}
