package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
       StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
       
//       Student obj=new Student();
//       obj.setStudentId(12);
//       obj.setStudentCity("Hyderabad");
//       obj.setStudentName("Lekha");
//       int r = studentDao.insert(obj);
//       System.out.println("Number of records inserted is "+r);
     
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       System.out.println("**************WELCOME TO OUR APPLICATION***************");
       while(go)
       {

           System.out.println("PRESS 1 for add new student");
           System.out.println("PRESS 2 for display all students");
           System.out.println("PRESS 3 for get detail of single student");
           System.out.println("PRESS 4 for delete students");
           System.out.println("PRESS 5 for update student");
           System.out.println("PRESS 6 for exit");
           try {
        	   int input=Integer.parseInt(br.readLine());   
        	   switch(input)
        	   {
        	   case 1://add a new student
        		   
        		   //Taking inputs from user
        		   System.out.println("Enter student Id");
        		   int uid=Integer.parseInt(br.readLine());
        		   System.out.println("Enter student name");
        		   String uname=br.readLine();
        		   System.out.println("Enter student's city");
        		   String ucity=br.readLine();
        		   
        		   //creating student object and setting values
        		   Student obj=new Student();
        		   obj.setStudentId(uid);
        		   obj.setStudentName(uname);
        		   obj.setStudentCity(ucity);
        		   
        		   //saving student object by calling insert of student dao
        		  int r= studentDao.insert(obj);
        		   System.out.println(r+" Student added");
        		   System.out.println("****************************************************");
        		   System.out.println();
        		   break;
        		   
        	   case 2://display all student
        		   
        		   System.out.println("*********************************************************");
        		   List<Student> students=studentDao.getAllStudents();
        		   for(Student obj1:students)
        		   {
        			   System.out.println("Student name : "+ obj1.getStudentName());
        			   System.out.println("Student id : "+obj1.getStudentId());
        			   System.out.println("Student city :"+obj1.getStudentCity());
        			   System.out.println("--------------------------------------------------------");
        		   }
        		   System.out.println("***********************************************************");
        		   
        		   break;
        		   
        	   case 3://get single student

        		   System.out.println("*********************************************************");
        		   System.out.println("Enter student Id");
        		   int userid=Integer.parseInt(br.readLine());
        		   Student obj2=studentDao.getStudent(userid);
    			   System.out.println("Student name : "+ obj2.getStudentName());
    			   System.out.println("Student id : "+obj2.getStudentId());
    			   System.out.println("Student city :"+obj2.getStudentCity());
    			   System.out.println("--------------------------------------------------------");
        		   
        		   break;
        	   case 4:// delete student
        		   
        		   System.out.println("*********************************************************");
        		   System.out.println("Enter student Id to delete");
        		   int stud_id=Integer.parseInt(br.readLine());
        		   studentDao.deleteStudent(stud_id);
        		   System.out.println("Student deleted!!!!!!");
        		   System.out.println("*********************************************************");
        		   
        		   break;
        		   
        	   case 5://update the student name
        		   System.out.println("*********************************************************");
        		   System.out.println("Enter student Id to update");
        		   int studId=Integer.parseInt(br.readLine());
        		   
        		   Student ob=studentDao.getStudent(studId);
        		   
        		   System.out.println("Enter the name of the student to modify");
        		   String sname=br.readLine();
        		   
        		   ob.setStudentName(sname);
        		   studentDao.updateStudent(ob);
        		   System.out.println("Student updated!!!!!!!");
        		   System.out.println("*********************************************************");
        		   
        		   break;
        	   case 6:
        		   go=false;
        		   break;
        	   }
           }
          catch(Exception e)
           {
        	System.out.println("Invalid Input try with another one!!");
        	System.out.println(e.getMessage());
           }
           
       }
       System.out.println("Thank you for using the Application");
       
    }
}
