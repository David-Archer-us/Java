
import java.util.HashMap;
import java.util.Map;

public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private String major;
	private String department;
	private double gpa;
	
	public Student() {
		this("", "", 0, "", "", 0.0);
	}
	
	public Student(String fName, String lName, int iAge,
			String sMajor, String sDepartment, double dGpa){
		firstName = fName;
		lastName = lName;
		age = iAge;
		major = sMajor;
		department = sDepartment;
		gpa = dGpa;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setAge(int iAge) {
		age = iAge;
	}
	
	public void setMajor(String sMajor) {
		major = sMajor;
	}
	
	public void setDepartment(String sDepartment) {
		department = sDepartment;
	}
	
	public void setGpa(double dGpa) {
		gpa = dGpa;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getMajor() {
		return major;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	class Course {
		Map<String, String> courses = new HashMap<String, String>();
		void printSchedule() {
			System.out.printf("%s %s: %s", firstName, lastName, courses);
		}
	}

}
