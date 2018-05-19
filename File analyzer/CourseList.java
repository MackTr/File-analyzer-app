/*Mackenzie Trenholm 40057679
 * ASSIGNMENT 4
 * DUE APRIL 13th 2018
 */
import java.util.NoSuchElementException;




public class CourseList {
	
	//inner class CourseNode
	class CourseNode{
		private Course c;
		private CourseNode next;
		
		//inner class default constructor
		public CourseNode() {
			c=null;
			this.next=null;
		}
		//inner parameterized constructor
		public CourseNode(Course c, CourseNode next) {
			this.c=c;
			this.next=next;
		}
		
		//copy constructor
		public CourseNode(CourseNode c1) {
			this.c=c1.c.clone();
			this.next=c1.next;
		}
			
//		CLONE METHOD
		public CourseNode clone() {
			 try{
		            CourseNode clone = (CourseNode)super.clone();
		            return clone;
		        } catch (CloneNotSupportedException e){
		            return null;
		        }
	}
	
		//getters and setters
		
		public Course getCourse() {
			return c;
		}
		public void setCourse(Course c) {
			this.c = c;
		}
		public CourseNode getCourseNode() {
			return next;
		}
		public void setCourseNode(CourseNode next) {
			this.next = next;
		}
		
		
	}
	public CourseNode head;
	private int size=0;         
	
	 public int getSize() {
	        return size;
	    }

	 public CourseNode getHead() {
	        return head;
	    }
	
	public CourseList() {
		head=null;
		size=0;
	}
	public CourseList(CourseList cl) {
		if(cl.head==null) {
			head=null;   
		}
			else {
				head=null;
				CourseNode w, ww, www;
				
				w=cl.head;
				ww=www=null;
				
				while(w!=null) {
					if(head==null) {
						ww=new CourseNode(w);
						head=ww;
					}
					else {
						www=new CourseNode(w);
						ww.next=www;
						ww=www;
						
					}
					ww=www=null;
					size=cl.size;
				
			}
		}
	}
	public void addToStart(Course c) {
		CourseNode cn = new CourseNode(c, head); 
		head=cn;
		cn=null;
		size++;
	}
	public void insertAtIndex( Course c, int index)throws NoSuchElementException{
		if(size==0&&index!=0) {
			throw new NoSuchElementException("Empty list");
		}
		else if( (index<0||index>(size-1))&& index!=0) {
			throw new NoSuchElementException("No such index");
		}
		else {
			CourseNode w= head;
			int counter=0;
			
			if(index==0) 
				head= new CourseNode(c,head);
			
			else {
				while(counter!=index-1) {
					w=w.next;
					counter++;
				}
				w.next=new CourseNode(c, w.next);
				
			}
			
			size++;
		}
	}
	public void deleteFromIndex(int index)throws NoSuchElementException{
		if(size==0) {
			throw new NoSuchElementException("Empty list");
		}
		else if( (index<0||index>(size-1))&& index!=0) {
			throw new NoSuchElementException("No such index");
		}
		else {
			CourseNode w= head;
			int counter=0;
			
			if(index==0) {
				head= w.next;
			}
			else {
				while(counter!=index-1) {
					w=w.next;
					counter++;
				}
				w.next=w.next.next;
			}
			size--;
		}
	}
	public void deleteFromStart() {
		if(size==0) {
			System.out.println("List empty");
		}
		else {
			CourseNode w= head;
			head= w.next;
			size--;
		}
	}
	public void replaceAtIndex(Course c, int index) {
		if((index<0||index>(size-1))&& index!=0) {
			System.out.println("invalid index");
			return;
		}
		CourseNode w= head;
		int counter=0;
		
		if(size==0&& index==0) {
			head=new CourseNode(c, w.next);
		}
		else {
			while(counter!=index-1) {
				w=w.next;
				counter++;
			}
			w.next=new CourseNode(c, w.next.next);
		}
	}
	public CourseNode find(String id) {
		CourseNode w=head;
		
		while(w!=null) {
			if(w.c.getCourseID().equals(id)) { 
				
				return w;}
			//HERE IS THE PRIVACY LEAK
				//dangerous as returning pointer that has access to methods
			w=w.next;	
		}
		
		return null;	
	}
	
	public boolean contains(String ID) {
		CourseNode w= head;
		while(w!=null) {
			if(w.c.getCourseID().equals(ID))
				return true;
			w=w.next;
		}
		return false;
	}
	public boolean equals(CourseList cl) {
		if(size!=cl.size) 
			return false;
		else if(head==null||cl.head==null)
			return false;
		else{
			int counter=0;
			CourseNode w= head;
			CourseNode ww= cl.head;
			
			while(w!=null) {
				if(w.c.equals(ww.c))
					counter++;
				w=w.next;
				ww=ww.next;
			}
			if(counter==size)
				return true;
			
			return false;
		}
		
		
	}
	public void showListContents() {
		CourseNode temp=head;
		if(temp==null) 
			System.out.println("list empty");
		else
			System.out.println("Here are the contents of the list");
		while(temp!=null) {
			System.out.println(temp.c+"------->");
			temp=temp.next;
		}
		System.out.println("X");
	}
	
	
	
	
}
