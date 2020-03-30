

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private String major;
	private String department;
	private double gpa;
	private LinkedList<Course> courses;
	
	public Student(String fName, String lName, int iAge,
			String sMajor, String sDepartment, double dGpa, LinkedList<Course> lCourses){
		firstName = fName;
		lastName = lName;
		age = iAge;
		major = sMajor;
		department = sDepartment;
		gpa = dGpa;
		courses = (LinkedList<Course>)lCourses.clone();
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
	
	public void setCourses(LinkedList<Course> lCourses)
	{
		courses = (LinkedList<Course>)lCourses.clone();
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
	
	public LinkedList<Course> getCourse()
	{
		return courses;
	}
	
	public void addCourse(Course course)
	{
		courses.add(course);
	}
	
	public void removeCourse(Course course)
	{
		courses.remove(course);
	}
	
	public void sortCourses(String attr, boolean ascending)
	{
		Collections.sort(courses, new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				int result = 0;				
				switch(attr) {
				case "name":
					result = c1.getName().compareToIgnoreCase(c2.getName());
					break;
				case "department":
					result = c1.getDepartment().compareToIgnoreCase(c2.getDepartment());
					break;
				case "time":
					result = c1.getTime().compareToIgnoreCase(c2.getTime());
					break;
				case "weekday":
					result = DayOfWeek.valueOf(c1.getWeekday().toUpperCase()).compareTo(DayOfWeek.valueOf(c2.getWeekday().toUpperCase()));
					break;
				case "description":
					result = c1.getDescription().compareToIgnoreCase(c2.getDescription());
					break;
				default:
					result = 0;
					break;
				}
				if (ascending == false)
				{
					result = -result;
				}
				return result;
			}
		});
		Iterator it = courses.iterator();
		while(it.hasNext())
		{
			System.out.print(((Course)it.next()).toString());
		}
	}
	
	public String toString()
	{
		return "\nStudent Name: " + firstName + " " + lastName + 
				"\nStudent Age: " + age +
				"\nStudent Major: " + major + 
				"\nStudent Department: " + department + 
				"\nStudent GPA: " + gpa + 
				coursesToString();
	}
	
	public String coursesToString()
	{
		String coursesString = "";
		Iterator it = courses.iterator();
		while(it.hasNext())
		{
			coursesString += it.next().toString();
		}
		return coursesString;
	}

}
