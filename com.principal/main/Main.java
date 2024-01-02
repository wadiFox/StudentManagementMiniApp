package main;

import java.util.Scanner;

import model.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Student Management System");
		System.out.println();
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		while(true) {	
    		System.out.println("Please choose your action : ");
    		System.out.println("####---------####");
    		System.out.println("1 - View Students List\n2 - Add New Student\n3 - Update Student\n4 - Search Student By Registration Number\n5 - Delete Student\n6 - Exit");
    		int choice=input.nextInt();
    	switch(choice) {
        case 1 :
        	
        	break;
        case 2 :
        	
        	break;
        case 3 :
        	
        	break;
        case 4 :
        	
        	break;
        case 5 :
        	
        	break;
        case 6 :
        	System.out.println("Thanks for using Student Management System\nGood Bye!!!");
        	System.exit(0);
        }
}
	}

}
