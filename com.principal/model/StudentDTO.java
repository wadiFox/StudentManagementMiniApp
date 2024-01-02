package model;

public class StudentDTO {
    private int registrationNumber;
	private String name;
	private int age;
	private String city;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}



	public StudentDTO(int registrationNumber, String name, int age, String city) {
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student : registrationNumber =>" + registrationNumber + ""
				+ ", name =>" + name + ", age =>"
				+ age + ", city =>"
				+ city ;
	}
	

}
