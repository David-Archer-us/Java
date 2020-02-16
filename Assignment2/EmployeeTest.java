
public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Joe", "Smith", 21, "111111111",
				"361 North Road, Silicon Valley, CA 99999, US", "M",
				200.1, "A0B1", "contractor", "20100901", 60.0, 0.0);
		Employee e2 = new Employee("Lisa", "Gray", 22, "222222222",
				"362 North Road, Silicon Valley, CA 99999, US", "F",
				200.2, "A0B2", "full time", "20100902", 0.0, 110000);
		Employee e3 = new Employee("Timothy", "Briggs", 23, "333333333",
				"363 North Road, Silicon Valley, CA 99999, US", "M",
				200.3, "A0B3", "full time", "20100903", 0.0, 80000);
		Employee e4 = new Employee("George", "Wallace", 24, "444444444",
				"364 North Road, Silicon Valley, CA 99999, US", "M",
				200.4, "A0B4", "part time", "20100904", 20.0, 0.0);
		Employee e5 = new Employee("Amy", "Student", 25, "555555555",
				"369 North Road, Silicon Valley, CA 99999, US", "M",
				200.5, "A0B5", "contractor", "20100905", 45.0, 0.0);
		
		e1.introduce();
		System.out.printf("Total Pay: %.2f" + "\n\n", e1.calculatePay(30));
		e2.introduce();
		System.out.printf("Total Pay: %.2f" + "\n\n", e2.calculatePay(2));
		e3.introduce();
		System.out.printf("Total Pay: %.2f" + "\n\n", e3.calculatePay(30));
		e4.introduce();
		System.out.printf("Total Pay: %.2f" + "\n\n", e4.calculatePay(30));
		e5.introduce();
		System.out.printf("Total Pay: %.2f" + "\n\n", e5.calculatePay(30));

	}

}
