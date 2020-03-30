

import java.util.LinkedList;

public class StudentTester {

	public static void main(String[] args) {
		
		Course c1 = new Course("CS_151", "oop", "CS", "18:00", "Tuesday");
		Course c2 = new Course("CS_146", "data", "CS1", "07:30", "Monday");
		Course c3 = new Course("CS_147", "archi", "CS2", "19:30", "Thursday");
		Course c4 = new Course("ams", "culture", "lit", "13:30", "Wednesday");
		LinkedList<Course> courses = new LinkedList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		
		Student s = new Student("Lisa", "Zhang", 25, "CS", "Computer", 3.88, courses);
		
		System.out.print(s.toString());
		System.out.println();
		
		Course c5 = new Course("ams1", "culture2", "lite", "15:00", "Wednesday");
		s.addCourse(c5);
		System.out.print(s.toString());
		System.out.println();
		
		s.removeCourse(c2);
		System.out.print(s.toString());
		System.out.println();
		
		s.sortCourses("weekday", true);
		System.out.println();
		System.out.print(s.toString());
		System.out.println();

	}

}
