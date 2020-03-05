

public class EmployeeTest {

	public static void main(String[] args) throws Exception {
		
		Employee employee = new Employee("John", "Smith", "101", 35);
			
		try {
			System.out.println(employee.computePay(40));
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			System.out.println(employee.computePay(23));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			System.out.println(employee.computePay(1));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			System.out.println(employee.computePay(0));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			System.out.println(employee.computePay(-5));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			System.out.println(employee.computePay(45));
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
