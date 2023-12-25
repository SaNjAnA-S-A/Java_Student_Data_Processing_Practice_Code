import java.util.Scanner;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


class StudentException extends Exception
{
		String errMsg;
		
		StudentException(String errMsg)
		{
			this.errMsg=errMsg;
		}
		
		void showError()
		{
			System.out.println("Error:"+errMsg);
		}
		
};

class AdmissionException  extends Exception
{
	public String errMsg;
		
	AdmissionException(String errMsg)
	{
		this.errMsg=errMsg;
	}
		
	void showError()
	{
		System.out.println("Error:"+errMsg);
	}
}

class ReportException extends Exception
{
	String errMsg;
    ReportException(String errMsg)
    {
	   this.errMsg=errMsg;
    }

    void showError()
    {
	  System.out.println("Error:"+errMsg);
    }
}

interface Studentdataprocessing
{
	void printdetails();
}

class Report
{
	 int marks[]=new int[10];
	 String subjects[]=new String[10];
	 float attendance[]=new float[10];
	 int e;
	 
	 Report()
	 {
	    this.marks[0]=0;
	    this.subjects[0]="";
	    this.attendance[0]=0.0f;
	 }
	
	 Report(int marks[],String subjects[],float attendance[]) 
	 {
	    for(int i=0;i<6;i++)
		{
	        this.marks[i]=marks[i];
	        this.subjects[i]=subjects[i];
	        this.attendance[i]=attendance[i];
	        

	     }
	  }
	
	 public void avgAttendence(int n)
	 {
	 	float avg=0.0f;
	 	for(int i=0;i<n;i++)
	 	{
	 	   avg=avg+attendance[i];	
	 	}
	 	avg=avg/n;
	 	System.out.println("average attendence: "+avg);
	 }

	 public void getReport(int n) 
	 {
	 	for(int i=0;i<n;i++)
	 	{
	 		Scanner scan=new Scanner(System.in);
	 		System.out.println("enter subject "+(i+1)+":");
	 		subjects[i]=scan.next();
	 	}
	 	for(int i=0;i<n;i++)
	 	{
	 		Scanner scan=new Scanner(System.in);
	 		System.out.println("Enter grade(1-10) for subject "+(i+1)+":");
	 		marks[i]=scan.nextInt();
	 		
	 		if(marks[i]>10)
	 		{
	 			System.out.println("Re-enter grade");
		 		marks[i]=scan.nextInt();
		 		if(marks[i]>10)
		 			System.exit(0);
	 		}
	 	}
	 	for(int i=0;i<n;i++)
	 	{
	 		Scanner scan=new Scanner(System.in);
	 		System.out.println("enter attendence for subject "+(i+1)+" in percentage:");
	 		attendance[i]=scan.nextFloat();
	 		if(attendance[i]>100 || attendance[i]<0)
	 		{
	 			for(e=0;e<2;e++) {
					System.out.println("Invalid attendence");
					System.out.println("Re-enter attendence");
					attendance[i]=scan.nextFloat();
					if(attendance[i]<100 || attendance[i]>0)
							break;
					}
					if(e==2)
						System.exit(0);
				}
	 		}
	 	}

	 public void printReport(int n) throws ReportException
	 {
	 	for(int i=0;i<n;i++)
	 	{
	 		//System.out.println("Student "+(i+1)+" report details");
	 		System.out.println("Grade points:"+marks[i]);
	 		if(marks[i]<=5)
			{
				throw new ReportException("Not eligible for sem-end exam");
			}
	 		System.out.println("Subjects:"+subjects[i]);
	 		System.out.println("Attendance:"+attendance[i]);
	 		if(attendance[i]<=75)
			{
				throw new ReportException("Not eligible for sem-end exam");
			}
	 		System.out.println('\n');
	 	}
	  }
}

abstract class Person
{
    static int j=0;
	static int n=0;
	static int t=0;
	static String arr1[][]=new String[500][2];
	static int arr2[][]=new int[500][4];
	static String arrses[][]=new String[20][3];
	static String sarr1[][]=new String[500][2];
	static int sarr2[][]=new int[500][5];
	static int arrse[][]=new int[20][6];
	static int y=0;
    public String name;
	public int phoneNo;
	public String emailId;
	public int age;
	
	Person()
	{
	   this.name="";
	   this.phoneNo=0;
	   this.emailId="";
	   this.age=0;
	}
	
    Person(String name,int phoneNo,String emailId,int age)
	{
	  this.name=name;
	  this.phoneNo=phoneNo;
	  this.emailId=emailId;
	  this.age=age;
	}
	
	abstract void readPerson() throws StudentException;
	    
	//abstract void printPerson();
	void printPerson()
	{
		System.out.println("Name: "+name+"\n");
		System.out.println("Phone number: "+phoneNo+"\n");
		System.out.println("Email Id: "+emailId+"\n");
		System.out.println("Age: "+age+"\n");
	}
	
	abstract void display();
	
	abstract void calCgpa(Report r, int i);
	
	abstract void search();
	    
	abstract void data();
	
}

class Course
{
    int courseId;
    String courseTitle;
	    
	Course()
	{
	  this.courseId=0;
	  this.courseTitle="";
	}
	
	Course(int courseId,String courseTitle)
	{
	  this.courseId=courseId;
	  this.courseTitle=courseTitle;
	}
	
	public void printCourses()
	{
		System.out.println("Course Id: "+courseId);
		System.out.println("Course title: "+courseTitle+"\n");
	}

	public void getCourse()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Course Id: ");
		courseId=scan.nextInt();
		//System.out.println("\n");
		System.out.println("Enter Course title: ");
	    courseTitle=scan.next();
	    //System.out.println("\n");
	}

}

class Student extends Person
{
		int stuId;
		int backlog;
		float cgpa;
		Course stuCourse=new Course();
		Report sRep=new Report();
		
		Student()
		{
			this.stuId=0;
			this.backlog=0;
			this.cgpa=0;
		}
		
		Student(int stuId, int backlog, float cgpa, int id, String title ,
				String name, int phoneNumber, String emailId, int age ) throws StudentException
		{
			super(name,phoneNumber,emailId,age);
			this.stuId=stuId;
			this.backlog=backlog;
			
			if(backlog>4)
			{
				throw new StudentException("Not promoted to next semester");
			}
			
			this.cgpa=cgpa;
			stuCourse.courseId=id;
			stuCourse.courseTitle=title;
		}
		
		void readPerson() throws StudentException
		{
			int e=0;
			Student s=new Student();
			if(y!=500)
			{
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter student name: ");
				name=scan.next();
				if(java.util.regex.Pattern.compile( "[0-9]" ).matcher(name).find())
				{
					for(e=0;e<2;e++) {
					System.out.println("Invalid name");
					System.out.println("Re-enter your name");
					name=scan.next();
					if(!java.util.regex.Pattern.compile( "[0-9]" ).matcher(name).find())
							break;
					}
					if(e==2)
						System.exit(0);
				}
				//System.out.println("\n");
				sarr1[y][0]=name;
				System.out.println("Enter phone number: ");
				phoneNo=scan.nextInt();
				sarr2[y][0]=phoneNo;
				//System.out.println("\n");
				System.out.println("Enter email(gmail/yahoo) id: ");
				emailId=scan.next();
				if(!(emailId.contains("@gmail.com") || emailId.contains("@yahoo.com")) )
				{
					for(e=0;e<2;e++) {
					System.out.println("Invalid emailId");
					System.out.println("Re-enter your emailId");
					emailId=scan.next();
					if(emailId.contains("@gmail.com") || emailId.contains("@yahoo.com"))
							break;
					}
					if(e==2)
						System.exit(0);
				}
				sarr1[y][1]=emailId;
				//System.out.println("\n");
				System.out.println("Enter age: ");
				age=scan.nextInt();
				if(age <=1)
				{
						for(e=0;e<2;e++)
						{
							System.out.println("Invalid age");
							//System.exit(0);
							System.out.println("Re-enter your age");
							age=scan.nextInt();
							if(age > 16 && age < 30)
								break;
						}
						if(e==2)
							System.exit(0);
					
				}
				else if(age >30)
				{
						System.out.println("Age limit exceeding for admission!!!");
						System.exit(0);					
				}
				else if(age <16)
				{
						System.out.println("Under Age !!!, cannot be admitted");
						System.exit(0);
					
				}
				sarr2[y][1]=age;
				//System.out.println("\n");
				System.out.println("Enter student id: ");
				stuId=scan.nextInt();
				for(int i=0;i<9;i++)
				{
					if(stuId==arrse[i][0] || stuId==sarr2[i][2])
					{
						System.out.println("Student Id already exists");
						System.exit(0);
					}
						
				}
				sarr2[y][2]=stuId;
				//System.out.println("\n");
				System.out.println("Number of backlogs(If Fresher Enter 0): ");
				backlog=scan.nextInt();
				sarr2[y][3]=backlog;
				//System.out.println("\n");
				
			if(backlog>4)
			{
				throw new StudentException("Not promoted to next semester");
			}
				
			System.out.println("Enter cgpa(If Fresher Enter 0): ");
			cgpa=scan.nextFloat();
			if(cgpa>=9 && backlog>2 )
			{
				System.out.println("wrong cgpa");
				System.out.println("Re-enter cgpa");
				cgpa=scan.nextFloat();
				if(cgpa>=9 && backlog>2 )
					System.exit(0);
			}
	
			sarr2[y][4]=(int) cgpa;
			System.out.println("\n");
			y++;
	}
			
	}
		
		void printPerson()
		{
			//Person::printPerson();
			//System.out.println(+"Student ID: "+stuId+);
			//System.out.println(+"Backlogs: "+backlog+);
			//System.out.println(+"CGPA: "+cgpa+);
			 for(int k=0;k<y;k++)
		    {
				System.out.println("Student "+(k+1)+" details");
		    	System.out.println("Student name: "+sarr1[k][0]);
				System.out.println("phone number: "+sarr2[k][0]);
				System.out.println("email id: "+sarr1[k][1]);
				System.out.println("age: "+sarr2[k][1]);
			    System.out.println("student id:"+sarr2[k][2]);
			    System.out.println("Backlog:"+sarr2[k][3]);
			    System.out.println("CGPA:"+sarr2[k][4]);
			    System.out.println("\n");
			}
		}

		
		void calCgpa(Report r, int n)
		{
			int sum=0;
			for(int i=0;i<n;i++)
			{
				sRep.marks[i]=r.marks[i];
				if(r.marks[i]<5)
					System.out.println("Not eligible for sem-end exam as marks scored is "+r.marks[i]);
			}
			for(int i=0;i<n;i++)
			{
				sum=sum+sRep.marks[i];
			}
			cgpa=(float)(sum)/n;
			System.out.println("CGPA: "+cgpa);
		}

		
		void regCourse(Course c)
		{
			stuCourse.courseId=c.courseId;
			stuCourse.courseTitle=c.courseTitle;
		}


		
		void display()
		{

			System.out.println("Student Id:"+stuId);
			System.out.println("Backlog:"+backlog);
			System.out.println("CGPA:"+cgpa);
			System.out.println("Course Id:"+stuCourse.courseId);
			System.out.println("Course Title:"+stuCourse.courseTitle);
			System.out.println("Name:"+name);
			System.out.println("Phone Number:"+phoneNo);
			System.out.println("Email Id:"+emailId);
			System.out.println("Age:"+age);

	}
		
		/*void readpPerson() throws StudentException
		{
			Scanner scan=new Scanner(System.in);
			Global g=new Global();
			System.out.println("Enter student name: ");
			name=scan.next();
			System.out.println("\n");
			g.sarr1[g.y][0]=name;
			System.out.println("Enter phone number: ");
			phoneNo=scan.nextInt();
			g.sarr2[g.y][0]=phoneNo;
			System.out.println("\n");
			System.out.println("Enter email id: ");
			emailId=scan.next();
			g.sarr1[g.y][1]=emailId;
			System.out.println("\n");
			System.out.println("Enter age: ");
			age=scan.nextInt();
			g.sarr2[g.y][1]=age;
			System.out.println("\n");
			System.out.println("Enter student id: ");
			stuId=scan.nextInt();
			g.sarr2[g.y][2]=stuId;
			System.out.println("\n");
			System.out.println("Number of backlogs: ");
			backlog=scan.nextInt();
			g.sarr2[g.y][3]=backlog;
			System.out.println("\n");
				
			if(backlog>4)
			{
				throw new StudentException("Not promoted to next semester");
			}
				
			System.out.println("Enter cgpa: ");
			cgpa=scan.nextFloat();
			System.out.println("\n");
			g.y++;
	}*/
			
		
		void search()
		{
			Scanner scan=new Scanner(System.in);
			int ss;
			int i;
			System.out.println("Enter student id: ");
			ss=scan.nextInt();
			System.out.println("\n");
			for(i=0;i<9;i++)
			{
				if(ss==arrse[i][0])
				{
					System.out.println("Student Id: "+arrse[i][0]);					
					System.out.println("Backlog: "+arrse[i][1]);
					System.out.println("CGPA:"+arrse[i][2]);
					System.out.println("Student name:"+arrses[i][1]);
					System.out.println("Email Id:"+arrses[i][2]);
					System.out.println("Phone number: "+arrse[i][4]);
					System.out.println("Age:"+arrse[i][5]);
			    }
				
				else if(ss==sarr2[i][2])
				{
					System.out.println("Student Id: "+sarr2[i][2]);					
					System.out.println("Backlog: "+sarr2[i][3]);
					System.out.println("CGPA:"+sarr2[i][4]);
					System.out.println("Student name:"+sarr1[i][0]);
					System.out.println("Email Id:"+sarr1[i][1]);
					System.out.println("Phone number: "+sarr2[i][0]);
					System.out.println("Age:"+sarr2[i][1]);
			    }
			}
			if(i==10)
			{
				System.out.println("Entry not found");
			}
				
		}
		
		void data()
		{
		if(t!=10)
		{
			arrse[t][0]=stuId;
			arrse[t][1]=backlog;
			arrse[t][2]=(int) cgpa;
			arrse[t][3]=stuCourse.courseId;
			arrses[t][0]=stuCourse.courseTitle;
			arrses[t][1]=name;
			arrse[t][4]=phoneNo;
			arrses[t][2]=emailId;
			arrse[t][5]=age;
			t++;
			
			if(t==9)
			{
				t=0;
			}
	}
		else 
		{
			t=0;
		}
	}
	 
		
};



class Professor extends Person
{
    public int pId;
    public int experience;
    public Course pCourse=new Course();
    public Report pRep=new Report();
    int e;

    Professor()
    {
        this.pId=0;
        this.experience=0;
    }

    Professor(int pId,int experience, String name, int phoneNumber, String emailId, int item,int age)
    {
    	super(name,phoneNumber,emailId,age);
        this.pId=pId;
        this.experience=experience;
    }
    
    void display() {};
    
    void calCgpa(Report r, int i) {};
    
    void search() {};
    
    void data() {};
    
    void readPerson()
    {
    	Scanner scan=new Scanner(System.in);
    	if(n!=500)
    	{
    		System.out.println("Enter professor name: ");
    		name=scan.next();
    		if(java.util.regex.Pattern.compile( "[0-9]" ).matcher(name).find())
			{
				for(e=0;e<2;e++) {
				System.out.println("Invalid name");
				System.out.println("Re-enter your name");
				name=scan.next();
				if(!java.util.regex.Pattern.compile( "[0-9]" ).matcher(name).find())
						break;
				}
				if(e==2)
					System.exit(0);
			}
    		arr1[n][0]=name;
    		//System.out.println("\n");
    		System.out.println("Enter phone number: ");
    		phoneNo=scan.nextInt();
    		arr2[n][0]=phoneNo;
    		//System.out.println("\n");
    		System.out.println("Enter email id: ");
    		emailId=scan.next();
    		if(!(emailId.contains("@gmail.com") || emailId.contains("@yahoo.com")) )
			{
				for(e=0;e<2;e++) {
				System.out.println("Invalid emailId");
				System.out.println("Re-enter your emailId");
				emailId=scan.next();
				if(emailId.contains("@gmail.com") || emailId.contains("@yahoo.com"))
						break;
				}
				if(e==2)
					System.exit(0);
			}
    		arr1[n][1]=emailId;
    		//System.out.println("\n");
    		System.out.println("Enter age: ");
    		age=scan.nextInt();
    		if(age <=1)
			{
					for(e=0;e<2;e++)
					{
						System.out.println("Invalid age");
						//System.exit(0);
						System.out.println("Re-enter your age");
						age=scan.nextInt();
						if(age > 16 && age < 30)
							break;
					}
					if(e==2)
						System.exit(0);
				
			}
			else if(age >68)
			{
					System.out.println("Age limit exceeding !!!");
					System.exit(0);					
			}
			else if(age <23)
			{
					System.out.println("Under Age !!!, cannot be permitted");
					System.exit(0);
				
			}
    		arr2[n][1]=age;
    		//System.out.println("\n");
    	    System.out.println("Enter professor id:");
    	    pId=scan.nextInt();
    	   arr2[n][2]=pId;
    	   //System.out.println("\n");
    	   System.out.println("enter your years of experience:");
    	   experience=scan.nextInt();
    	   if(experience <= 0 || experience >= 32)
    	   {
  				System.out.println("incorrect!! Re-enter ");
  				experience=scan.nextInt();
  				 if(experience <= 0 || experience >= 32)
  					System.exit(0);
    	   }
    	   arr2[n][3]=experience;
    	   System.out.println("\n");
    	   n++;
    }
    }

    
    void printPerson()
    {
        //Person::printPerson();
        //System.out.println(+"professor Id:"+pId+);
        //System.out.println(+"Experience:"+experience+);
        for(int k=0;k<n;k++)
        {
        	System.out.println("professor "+(k+1)+" details");
        	System.out.println("professor name: "+arr1[k][0]);
    		System.out.println("phone number: "+arr2[k][0]);
    		System.out.println("email id: "+arr1[k][1]);
    		System.out.println("age: "+arr2[k][1]);
    	    System.out.println("professor id: "+arr2[k][2]);
    	    System.out.println("experience: "+arr2[k][3]);
    	    System.out.println("\n");
    	}
    }

    
    void updateMarks(Report r,int n)
    {
    	for(int i=0;i<n;i++)
    	{
        	pRep.marks[i]=r.marks[i];
    	}	
    }
    
    void updateAttendence(Report r,int n)
    {
        for(int i=0;i<n;i++)
    	{
        	pRep.attendance[i]=r.attendance[i];
    	}
    }
    
};

class Admission implements Studentdataprocessing
{
	static int  m=0;
	static String array[]=new String[500];
	static int array2[][]=new int[500][2];
	int j;
	public int admId;
	public static int counter;
	public String date;
	public float pucGrade;
	Student details[]=new Student[50];
	
	
	static
	{
		counter=1001;
	}
		
    Admission()
	{
	   this.date="";
	   this.pucGrade=0.0f;			
	}
		
	Admission(String date, float pucGrade) throws AdmissionException
	{
		admId=counter++;
		this.date=date;
		this.pucGrade=pucGrade;
			
		if(pucGrade<=50)
		{
			throw new AdmissionException("Ineligible : PUC grade < 50%");
		}
	}
	
	public void regStudent(Student s)
	{
		for(int i=0;i<details.length;i++)
		{
			details[i]=new Student();
		}
		
		if(j!=500)
		{
			details[j].stuId=s.stuId;
			details[j].backlog=s.backlog;
			details[j].cgpa=s.cgpa;
			//details[j].stuCourse.courseId=s.stuCourse.courseId;
			//details[j].stuCourse.courseTitle=s.stuCourse.courseTitle;
			j++;
		}
	}

	public void setDetails() throws AdmissionException
	{
		Scanner scan=new Scanner(System.in);
		if(m!=500){
		System.out.println("Admission ID: "+(++counter)+"\n");
		array2[m][0]=counter;
		System.out.println("Admission date(dd-mm-yy): ");
		date=scan.next();
		System.out.println("\n");
		array[m]=date;
		System.out.println("PUC grade: ");
		pucGrade=scan.nextFloat();
		System.out.println("\n");
		
		if(pucGrade<=50)
		{
			throw new AdmissionException("Ineligible : PUC grade < 50%");
		}
		array2[m][1]=(int) pucGrade;
		m++;
	}
   }

	public void printdetails()
	{
		for(int k=0;k<j;k++)
		{
			System.out.println("Student "+(k+1)+" admission details");
			System.out.println("Date: "+array[k]);
			System.out.println("Admission ID:"+array2[k][0]);
			System.out.println("PUC grade "+array2[k][1]);
		    System.out.println("\n");
		}
	}
}


class PersonFactory
{
	public Person getPerson(String m)
	{
		if(m.equalsIgnoreCase("student"))
			return new Student();
		else if(m.equalsIgnoreCase("professor"))
			return new Professor();
		return null;
	}
};



public class Main {

	public static void main(String[] args) throws StudentException {
		// TODO Auto-generated method stub
		
		System.out.println("                                                                                                     \n");
		System.out.println("\t\t\t\t*****************************************************************************************************\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t********************************************\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t         ARAKSHAN TECHNOLOGICAL UNIVERSITY  \t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t*\tLead your dream... \t *\t\t\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t********************************************\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    *\n");
		System.out.println("\t\t\t\t*****************************************************************************************************\n");
	    //System.out.println("\t\t\t\t\t%s",ctime(&t));
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    System.out.println("\t\t\t\t\t\t\t"+dtf.format(now));  
	    //displays the system time

		System.out.println("\t\t\t\t*****************************************************************************************************\n");
		System.out.println("\t\t\t\t\t\tChairmen: Sanjana A ,Ramya");
		System.out.println("\n\t\t\t\t\t\t\tPress any key to continue.........\t\t\t\t\t\t\t\t\t\t\n");

	
	
	int n = 0;
	Person p,q;
	PersonFactory o = new PersonFactory();
	String x;
	int ch;
	Course c=new Course();
	Report r=new Report();
	Student q1;
	Student s=new Student();
	Student m=new Student();
	Admission a=new Admission();
	Professor pf=new Professor();
	Scanner scan = new Scanner(System.in);
	System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    *\n");
	System.out.println("\t\t\t\t*\t\t\t\t\t\t********************************************\t\t\t\t\t\t\t    *\n");
	System.out.println("\t\t\t\t*\t\t\t\t\t         ARAKSHAN TECHNOLOGICAL UNIVERSITY  \t\t\t\t\t\t    *\n");
	System.out.println("\t\t\t\t*\t\t\t\t\t\t\t\t*\tLead your dream... \t *\t\t\t\t\t\t\t\t\t    *\n");
	System.out.println("\t\t\t\t*\t\t\t\t\t\t********************************************\t\t\t\t\t\t\t    *\n");
	
	
	q1=new Student(01,4,7.89f,101,"Maths","Amit",74844343,"amit@gmail.com",17);
	   q1.data();
	   q1=new Student(02,3,8.9f,101,"Electrical","Adil",74825343,"adil@gmail.com",20);
	   q1.data();
 q1=new Student(07,2,7.8f,101,"Electronics","Sarah",67898543,"_saru@yahoo.com",18);
	   q1.data();
	   q1=new Student(101,0,9.0f,101,"Sociology","Sheetal",34574343,"sheetal@gmail.com",19);
	   q1.data();
	   q1=new Student(121,3,6.9f,101,"Physics","Nimit",98723343,"nimit@hotmail.com",16);
	   q1.data();
	   q1=new Student(123,1,5.9f,101,"Astronomy","Poorvi",49054343,"poorvi@gmail.com",17);
	   q1.data();
	   q1=new Student(162,1,9.04f,101,"Robotics","Manan",84367890,"manan@yahoo.com",18);
	   q1.data();
	   q1=new Student(168,1,9.2f,101,"Biotechnology","Maira",94398343,"maira@gmail.com",18);
	   q1.data();
 q1=new Student(179,0,8.89f,101,"Computer_Science","Shridit",76544343,"shri@gmail.com",17);
	   q1.data();

	while(true)
	{
	System.out.println("                                                                                                     \n");
	System.out.println("-----------------------------------------------------------------------------------------------------\n");
	System.out.println("Enter student or professor ?");
	x=scan.next();
	p=o.getPerson(x);
	if(x.equals("student"))
	{
		
		System.out.println("Enter your choice");
		System.out.println("\n1.Student admission");
		System.out.println("2.Courses registered");
		System.out.println("3.Student Report"); 
		System.out.println("4.CGPA ");
		System.out.println("5.Show recent student details"); 
		System.out.println("6.Show student details");
		System.out.println("7.Search for student by student id");
		System.out.println("Exit");
		ch = scan.nextInt();
		System.out.println("\n");
		
		switch(ch)
		{
			case 1: try
					{
						p.readPerson();
						a.regStudent(s);
						a.setDetails();
						System.out.println("\n");
					}
					
					catch(StudentException z)
					{
						z.showError();
					}
					
					catch(AdmissionException w)
					{
						w.showError();
					}
					break;
					
			case 2: c.getCourse();
					s.regCourse(c);
					break;
			
			case 3: try {
					if(r.subjects[0]!="")
					{
						r.printReport(n);
						System.out.println("\n");
					}
					else 
					{
						System.out.println("Report not yet created");
					}
					}
					catch(ReportException e)
					{
						e.showError();
					}
			        break;
			        
			case 4: if(s.cgpa != 0)
					{
						p.calCgpa(r,n);
						System.out.println("\n");
					}
					else 
					{
						System.out.println("Report not yet created");
						System.out.println("\n");
					}
			
			       break;
			       
			case 5:try {
					System.out.println("\n");
					p.printPerson();
			       if(c.courseId != 0)
			       {
			    	   System.out.println("Student report details");
		               c.printCourses();
	               }
				  else
				   {
				  		System.out.println("course not yet registered");
				  		System.out.println("\n");
				   } 
			        a.printdetails();
			        System.out.println("\n");
			       
			       	if(r.attendance[0] != 0)
					{
			       		System.out.println("Student report details");
						r.printReport(n);
						System.out.println("\n");
					}
					else 
					{
						System.out.println("Report not yet created");
						System.out.println("\n");
					}
					}
					catch(ReportException e)
					{
						e.showError();
					}
					
			        break;
			        
			case 6:
			try {
				q1=new Student(01,4,7.89f,101,"Maths","Amit",748485,"amit@gmail.com",17);
				 q1.display();
			     q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		          
			   System.out.println("\n-------------------\n");
			try {
				q1=new Student(02,3,8.9f,101,"Electrical","Adil",74824,"adil@gmail.com",20);
				 q1.display();
			     q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			      
			       System.out.println("\n-------------------\n");
				q1=new Student(07,2,7.8f,101,"Electronics","Sarah",67893,"_saru@yahoo.com",18);
				q1.display();
			    q1.data();
		
			       
			       System.out.println("\n-------------------\n");
			try {
				q1=new Student(101,0,9.0f,101,"Sociology","Sheetal",54343,"sheetal@gmail.com",19);

			       q1.display();
			       q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			       System.out.println("\n-------------------\n");
			try {
				q1=new Student(121,3,6.9f,101,"Physics","Nimit",9944343,"nimit@hotmail.com",16);
				q1.display();
			    q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			       
			       System.out.println("\n-------------------\n");
			try {
				q1=new Student(123,1,5.9f,101,"Astronomy","Poorvi",89054343,"poorvi@gmail.com",17);
				q1.display();
			    q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			       
			       System.out.println("\n-------------------\n");
			try {
				q1=new Student(162,1,9.04f,101,"Robotics","Manan",7484360,"manan@yahoo.com",18);
				q1.display();
			    q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			       
			       System.out.println("\n-------------------\n");
			try {
				q1=new Student(168,1,9.2f,101,"Biotechnology","Maira",96598343,"maira@gmail.com",18);
				q1.display();
			    q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			       
			       System.out.println("\n-------------------\n");
			try {
				q1=new Student(179,0,8.89f,101,"Computer_Science","Shridit",6544343,"shri@gmail.com",17);
				  q1.display();
			      q1.data();
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			     
			       System.out.println("\n-------------------\n");
			       break;
			       
			case 7:
				   q1=new Student(01,4,7.89f,101,"Maths","Amit",74844343,"amit@gmail.com",17);
				   q1.data();
				   q1=new Student(02,3,8.9f,101,"Electrical","Adil",74825343,"adil@gmail.com",20);
				   q1.data();
                   q1=new Student(07,2,7.8f,101,"Electronics","Sarah",67898543,"_saru@yahoo.com",18);
				   q1.data();
				   q1=new Student(101,0,9.0f,101,"Sociology","Sheetal",34574343,"sheetal@gmail.com",19);
				   q1.data();
				   q1=new Student(121,3,6.9f,101,"Physics","Nimit",98723343,"nimit@hotmail.com",16);
				   q1.data();
				   q1=new Student(123,1,5.9f,101,"Astronomy","Poorvi",49054343,"poorvi@gmail.com",17);
				   q1.data();
				   q1=new Student(162,1,9.04f,101,"Robotics","Manan",84367890,"manan@yahoo.com",18);
				   q1.data();
				   q1=new Student(168,1,9.2f,101,"Biotechnology","Maira",94398343,"maira@gmail.com",18);
				   q1.data();
			       q1=new Student(179,0,8.89f,101,"Computer_Science","Shridit",76544343,"shri@gmail.com",17);
				   q1.data();
			       q1.search();      
			 break;			
			       
			default: System.exit(0);
		}

	}

	if(x.equals("professor"))
	{
		System.out.println("Enter your choice");
		System.out.println("\n1.Enter your details");
		System.out.println("2.Update student Report");
		//System.out.println("3.CGPA ");
		System.out.println("3.Show Professor details"); 
		System.out.println("4.Exit");
		ch=scan.nextInt();
		System.out.println("\n");
		
		switch(ch)
		{
			case 1:p.readPerson();
					System.out.println("\n");
			       break;
			       
			case 2:
						System.out.println("Enter number of reg subjects ");
						n=scan.nextInt();
						System.out.println("\n");
					   r.getReport(n);
					   r.avgAttendence(n);
					   pf.updateMarks(r,n);
					   pf.updateAttendence(r,n);
					   System.out.println("\n");
					   s.calCgpa(r,n);
						System.out.println("\n");
			
					break;
			       
			case 3:p.printPerson();
					System.out.println("\n");
				   break;
				   
			default:System.exit(0);
				        
		}
		
	}

	}
	}

}

