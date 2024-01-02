package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DBConnection;

public class StudentDao implements StudentDaoInterface{

	@Override
	public void viewStudentList() {
		
		try {
			Connection con = DBConnection.getDBConnection();
			String query = "select * from students_details";
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(query);
			while(rst.next()) {
			System.out.println("-----------------------------------");	
			System.out.println("Registartion number : "+rst.getInt(1));	
			System.out.println("Name : "+rst.getString(2));	
			System.out.println("Age : "+rst.getInt(3));	
			System.out.println("City : "+rst.getString(4));	
			System.out.println("-----------------------------------");	
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public boolean addStudent(StudentDTO st) {
		boolean done = false;
		try {
			Connection con = DBConnection.getDBConnection();
			String query = "insert into students_details(name, age, city) value(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, st.getName());
			pst.setInt(2, st.getAge());
			pst.setString(3, st.getCity());
			pst.executeUpdate();
			done=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public boolean updateStudent(int regNumber, String updated, int ch, StudentDTO st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchStudentByRegNumber(int regNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletStudent(int regNumber) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
