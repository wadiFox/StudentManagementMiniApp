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
        	updateLogic();
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
	
	static void updateLogic() {
		StudentDaoInterface dao = new StudentDao();
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
    	System.out.println("Update Student By Registration Number");
		System.out.println("-----------------------------------");
		System.out.println("Please enter a choice to update :\n1 - Update name\n2 - Update city\n3 - Update age");
		int ch=input.nextInt();
		System.out.print("Please enter the RN : ");
		int regsNum=input.nextInt();
		StudentDTO std=new StudentDTO();
		if(ch==1) {
			System.out.print("Please enter the new name : ");
			String updatedName = in.nextLine();
			std.setName(updatedName);
			dao.updateStudent(regsNum, updatedName, ch, std);
			askForUpdate();
			}
		if(ch==2) {
			System.out.print("Please enter the new city : ");
			String updatedCity = in.nextLine();
			std.setName(updatedCity);
			dao.updateStudent(regsNum, updatedCity, ch, std);
			askForUpdate();
		}
		if(ch==3) {
			System.out.print("Please enter the new age : ");
			String updatedAge = in.nextLine();
			std.setAge(Integer.parseInt(updatedAge));
			dao.updateStudent(regsNum, updatedAge, ch, std);
			askForUpdate();
		}
		System.out.println();
	}
	static void askForUpdate() {
		Scanner input = new Scanner(System.in);
			System.out.println("Do you want to update something else?");
			System.out.println("-----------------------------------");
			System.out.println("1 - Yes\n2 - No");
			int ch1=input.nextInt();
			switch(ch1) {
			case 1:
				updateLogic();
				break;
			case 2:
				System.out.println();
				break;
			default : 
				System.out.println("DPlease choose a correct answer!!!!");		
			}
		}
	}

