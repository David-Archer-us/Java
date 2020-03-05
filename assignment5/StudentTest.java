

public class StudentTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		try {
			Student student1 = new Student("John", "Smith", "Computer Science",
					"School of Computer Science department", 20, 3.6);
			student1.setCourse1("CS151", "Object Oriented Design and Programming",
					"CS", "6:00pm", "Tue");
			student1.setCourse2("CS121", "Grame Design", "CS", "3:00pm", "Mon");
			student1.setCourse3("Math200", "Advanced Algebra", "Math", "10:00am", "Wed");
			student1.setCourse4("Bio50", "The Living World", "Biology", "8:00am", "Thu");
			student1.printInfo();
			
			Student student2 = (Student)student1.clone();
			student2.printInfo();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
			
	}
}
