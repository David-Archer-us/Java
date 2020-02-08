

public class StudentTest {

	public static void main(String[] args) {
		Student student01 = new Student("John", "Smith", 20, "Computer Science","School of computer Science department", 3.6);
		Student.Course student01Agenda = student01.new Course();
		student01Agenda.courses.put("cs151", "Tuesday");
		student01Agenda.courses.put("cs152", "Wednesday");
		student01Agenda.courses.put("cs153", "Thursday");
		student01Agenda.printSchedule();
	}

}
