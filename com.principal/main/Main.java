package main;

import java.util.Scanner;

import model.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Student Management System");
		System.out.println();
		StudentDaoInterface dao = new StudentDao();
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		while(true) {	
    		System.out.println("Please Enter Your Choice : ");
    		System.out.println("####---------####");
    		System.out.println("1 - View Students List\n2 - Add New Student\n3 - Update Student\n4 - Search Student By Registration Number\n5 - Delete Student\n6 - Exit");
    		int choice=input.nextInt();
    	switch(choice) {
        case 1 :
    		System.out.println("View All Students : ");
        	dao.viewStudentList();
        	break;
        case 2 :
        	System.out.println("Add a New Student : ");
        	System.out.println("------------------");
        	System.out.print("1 - Please enter the name : ");
        	String name = in.nextLine();
        	System.out.print("2 - Please enter the age : ");
        	int age = input.nextInt();
        	System.out.print("3 - Please enter the city : ");
        	String city = in.nextLine();
        	StudentDTO st = new StudentDTO(name, age, city);
        	boolean done = dao.addStudent(st);
        	if(done) {
        		System.out.println("Student "+name+" added successfully!!!\n");
        	}else {
        		System.out.println("Sommething went wrong!! Student not added!!!\n");
        	}
        	break;
        case 3 :
        	
        	break;
        case 4 :
    		System.out.println("Find Student By Registration Number");
    		System.out.println("-----------------------------------");
    		System.out.print("Please enter the RN : ");
    		int regNum=input.nextInt();
    		System.out.println();
            dao.searchStudentByRegNumber(regNum);
        	break;
        case 5 :
        	System.out.println("Delete Student By Registration Number");
    		System.out.println("-----------------------------------");
    		System.out.print("Please enter the RN : ");
    		int regiNum=input.nextInt();
            dao.deleteStudent(regiNum);
        	break;
        case 6 :
        	System.out.println("Thanks for using Student Management System\nGood Bye!!!");
        	System.exit(0);
        default :
        	System.out.println("Please enter a correct choice!!!");
        }
}
	}

}
