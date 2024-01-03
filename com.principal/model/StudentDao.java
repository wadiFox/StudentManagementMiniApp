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
		boolean done=false;
		try {
			Connection con=DBConnection.getDBConnection();
			if(ch==1) {
				String query="UPDATE students_details SET name = ? WHERE registration_number = ?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, updated);
				pst.setInt(2, regNumber);
				int affected = pst.executeUpdate();
				if(affected>0) {
					System.out.println("Student name updated successfully!!\nNew name : "+updated);
					done = true;
				}else {
					System.out.println("Please try again, Student name not updated!!");
					done = false;
				}
			}
			if(ch==2) {
				String query="UPDATE students_details SET city = ? WHERE registration_number = ?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, updated);
				pst.setInt(2, regNumber);
				int affected = pst.executeUpdate();
				if(affected>0) {
					System.out.println("Student city updated successfully!!\nNew city : "+updated);
					done = true;
				}else {
					System.out.println("Please try again, Student city not updated!!");
					done = false;
				}
			}
			if(ch==3) {
				String query="UPDATE students_details SET age = ? WHERE registration_number = ?";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setInt(1, Integer.parseInt(updated));
				pst.setInt(2, regNumber);
				int affected = pst.executeUpdate();
				if(affected>0) {
					System.out.println("Student age updated successfully!!\nNew age : "+updated);
					done = true;
				}else {
					System.out.println("Please try again, Student age not updated!!");
					done = false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return done;
	}

	@Override
	public boolean searchStudentByRegNumber(int regNumber) {
		
		try {
			Connection con = DBConnection.getDBConnection();
			String query = "select * from students_details where registration_number = "+regNumber;
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(query);
			if (!rst.next()) {
	            // when no records found returns false
	            System.out.println("No Student Found with the registration number : " + regNumber);
	            return false;
	        }
			/*
			while(rst.next()) {	
				System.out.println("Registartion number : "+rst.getInt(1));	
				System.out.println("Name : "+rst.getString(2));	
				System.out.println("Age : "+rst.getInt(3));	
				System.out.println("City : "+rst.getString(4));	
				System.out.println("-----------------------------------");	
				}
			*/
			do {
	            // Afficher les détails de l'étudiant
	            System.out.println("Registartion number : " + rst.getInt(1));
	            System.out.println("Name : " + rst.getString(2));
	            System.out.println("Age : " + rst.getInt(3));
	            System.out.println("City : " + rst.getString(4));
	        } while (rst.next());
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	/*
	@Override
	public boolean deletStudent(int regNumber) {
		boolean deleted=false;
		try {
			Connection con = DBConnection.getDBConnection();
			String query = "delete from students_details where registration_number = "+regNumber;
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
			deleted=true;
		} catch (Exception e) {
			e.printStackTrace();
			deleted = false;
		}
		return deleted;
	}*/
	/*
	@Override
	public boolean deleteStudent1(int regNumber) {
	    boolean deleted = false;

	    try (Connection con = DBConnection.getDBConnection();
	         PreparedStatement pst = con.prepareStatement("delete from students_details where registration_number = ?")) {

	        pst.setInt(1, regNumber);
	        int rowsAffected = pst.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Étudiant supprimé avec succès !");
	            deleted = true;
	        } else {
	            System.out.println("Aucun étudiant trouvé avec le numéro d'enregistrement : " + regNumber);
	            deleted = false; // Aucune ligne n'a été affectée, donc l'opération a échoué
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        // Si une exception se produit, considérez également que l'opération a échoué
	        deleted = false;
	    }

	    return deleted;
	}

	*/
	@Override
	public boolean deleteStudent(int regNumber) {
	    boolean deleted = false;

	    try {
	        Connection con = DBConnection.getDBConnection();
	        String query = "delete from students_details where registration_number = ?";
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setInt(1, regNumber);
	        int result = pst.executeUpdate();

	        // Verify if 1 record was deleted
	        if (result > 0) {
	        	System.out.println("Student with registration number "+regNumber+" deleted successfully!!!\n");
	            deleted = true;
	        } else {
	            System.out.println("No Student with registration number " + regNumber+" Found!!!");
	            // If no record was deleted, deleted becomes false
	            deleted = false;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return deleted;
	}

	

}
