

public class Student implements Cloneable {
	
	private String firstName, lastName, major, department;
	private int age;
	private double gpa;
	private Course course1, course2, course3, course4;
	
	public Student(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	public Student(String fName, String lName, String sMajor, String sDepartment, int iAge, double dGpa) {
		firstName = fName;
		lastName = lName;
		major = sMajor;
		department = sDepartment;
		age = iAge;
		gpa = dGpa;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	public void setMajor(String sMajor) {
		major = sMajor;
	}
	public void setDepartment(String sDepartment) {
		department = sDepartment;
	}
	public void setAge(int iAge) {
		age = iAge;
	}
	public void setGpa(double dGpa) {
		gpa = dGpa;
	}
	public void setCourse1(String sName, String sDescription, String sDepartment, String sTime, String sWeekday) {
		course1 = new Course(sName, sDescription, sDepartment, sTime, sWeekday);
	}
	public void setCourse2(String sName, String sDescription, String sDepartment, String sTime, String sWeekday) {
		course2 = new Course(sName, sDescription, sDepartment, sTime, sWeekday);
	}
	public void setCourse3(String sName, String sDescription, String sDepartment, String sTime, String sWeekday) {
		course3 = new Course(sName, sDescription, sDepartment, sTime, sWeekday);
	}
	public void setCourse4(String sName, String sDescription, String sDepartment, String sTime, String sWeekday) {
		course4 = new Course(sName, sDescription, sDepartment, sTime, sWeekday);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMajor() {
		return major;
	}
	public String getDepartment() {
		return department;
	}
	public int getAge() {
		return age;
	}
	public double getGpa() {
		return gpa;
	}
	public Course getCourse1() {
		return course1;
	}
	public Course getCourse2() {
		return course2;
	}
	public Course getCourse3() {
		return course3;
	}
	public Course getCourse4() {
		return course4;
	}
	
	public void printInfo() {
		String student = "\nFirst Name: " + firstName + "\nLast Name: " + lastName
				+ "\nMajor: " + major + "\nDepartment: " + department
				+ "\nAge: " + age + "\nGPA: " + gpa 
				+ "\nCourse1: " + course1.toString()
				+ "\nCourse2: " + course2.toString()
				+ "\nCourse3: " + course3.toString()
				+ "\nCourse4: " + course4.toString();
		System.out.println(student);
	}
	
	protected Object clone() throws CloneNotSupportedException{
		Student student =(Student)super.clone();
		student.course1 = (Course)this.course1.clone();
		student.course2 = (Course)this.course2.clone();
		student.course3 = (Course)this.course3.clone();
		student.course4 = (Course)this.course4.clone();
		return student;
	}

}
