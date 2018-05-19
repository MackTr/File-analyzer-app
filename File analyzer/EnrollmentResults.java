/*Mackenzie Trenholm 40057679
 * ASSIGNMENT 4
 * DUE APRIL 13th 2018
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class EnrollmentResults {
	
	public static void main (String []args) {
		CourseList list1=new CourseList();
		//why?
		CourseList list2=new CourseList();
		CourseList list3=new CourseList();
		
		
		System.out.println("Welcome to Mack's program");
		
		
		Scanner scfile=null;
		Scanner scfileReq=null;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter file");
		String file=sc.nextLine();
		
		
		try {
			scfile = new Scanner(new FileInputStream("Syllabus.txt"));
			scfileReq= new Scanner(new FileInputStream(file));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found or unable to be opened, goodbye:-)");
			System.exit(0);
		}
		String id;
		String name;
		double credits;
		String pre=null;
		String co=null;
		String temp;
		String s;
		
		while (scfile.hasNextLine()) {
			s=scfile.next();
			if(s!="") {
				id=s;
				name=scfile.next();
				credits=scfile.nextDouble();
				
				scfile.nextLine();
				temp= scfile.nextLine();
				String[] prereq= temp.split("\\s+");
				
				if(prereq.length==2)
					pre=prereq[1];
				else
					pre="nothing";
				
				temp=scfile.nextLine();
				String[]coreq=temp.split("\\s");
				
				if(coreq.length==2)
					co=coreq[1];
				else
					co="nothing";
				Course add = new Course(id,name,credits,pre,co);
				
				if(!list1.contains(id))
					list1.addToStart(add);
				
			
			}
		}
		
		ArrayList<String> done = new ArrayList<String>();
		ArrayList<String> req = new ArrayList<String>();
		
		scfileReq.nextLine();
		
		while(scfileReq.hasNextLine()) {
			s=scfileReq.nextLine();
			
			if(s.equals("Requested"))
				break;
			done.add(s);
		}
		while(scfileReq.hasNextLine()) {
			s=scfileReq.nextLine();
			req.add(s);
		}
		if(req.size()!=0) {
			
			for(int i=0; i<req.size(); i++) {
				String request=req.get(i);
				Course course=list1.find(request).getCourse();
				
				String prereq= course.getPreReqID();
				String coreq= course.getCoReqID();
				
				String glue="";
				
				for(String x:done) {
					if(x.equals(prereq)||x.equals(coreq))
						glue+=x+" ";
				}
				if(done.contains(prereq)||done.contains(coreq))
					System.out.println("Student can enroll in "+ request+" as he has completed the prerequisites "+ glue);
				else if(req.contains(coreq))
						System.out.println("Student can enroll in "+ request+" as he is enrolling for corequisite "+ coreq);
				else
					System.out.println("Student cannot enroll in "+ request+ " course as he doesn't have sufficient background needed");
				
			}
		}
		else 
				System.out.println("No enrollment Courses Found");
		
		
		scfile.close();
		scfileReq.close();
			String loop="";
			do{
				System.out.println("Enter a course ID to have info");
				String input = sc.nextLine();
				
				if(list1.contains(input))
					System.out.println(list1.find(input).getCourse());
				else
					System.out.println("Course unavailable in syllabus");
				
				System.out.println("Would you like to search another course? Please enter answer (Yes/ No)");
				
				loop = sc.nextLine();
			
				}
			while(loop.equalsIgnoreCase("yes"));
			
			System.out.println("Program Ended");
			sc.close();
			
			Course c1 = new Course();
			Course c2= new Course("COMP248","Object_Oriented_prog I",3.5,"Math201","Math203");
			Course c3=new Course(c1,"a");
			
			
			
			System.out.println(c1.toString());
			System.out.println(c2.toString());
			System.out.println(c3.toString());
			System.out.println(c1.equals(c1));    //true
			System.out.println(c1.equals(c2));    //false
			
			list2.addToStart(c1);
			list2.addToStart(c2);
			list2.addToStart(c3);
			list2.find("a");
			list2.replaceAtIndex(c2, 1);
			
			list2.showListContents();
			list2.deleteFromStart();
			list2.showListContents();
			list2.deleteFromStart();
			list2.deleteFromStart();
			list2.showListContents();
	}
		
	
		
	}



