package model;

public interface StudentDaoInterface {
void viewStudentList();	
boolean addStudent(StudentDTO st);
boolean updateStudent(int regNumber, String updated,int ch, StudentDTO st);
boolean searchStudentByRegNumber(int regNumber);
//boolean deletStudent(int regNumber);
boolean deleteStudent(int regNumber);
//boolean deleteStudent1(int regNumber);
}
