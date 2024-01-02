package model;

public interface StudentDaoInterface {
boolean viewStudentList();	
boolean addStudent(StudentDTO st);
boolean updateStudent(int regNumber, String updated,int ch, StudentDTO st);
boolean searchStudentByRegNumber(int regNumber);
boolean deletStudent(int regNumber);
}
