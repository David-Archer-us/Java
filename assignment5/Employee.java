

public class Employee {
	
	private String firstName, lastName, employeeID;
	private double hourlyPay;
	
	public Employee(String fName, String lName, String sEmployeeID, double dHourlyPay) {
		firstName = fName;
		lastName = lName;
		employeeID = sEmployeeID;
		hourlyPay = dHourlyPay;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	public void setEmployeeID(String id) {
		employeeID = id;
	}
	public void setHourlyPay(double pay) {
		hourlyPay = pay;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public double getHourlyPay() {
		return hourlyPay;
	}
	
	public class TooManyHoursWorkedException extends Exception{

		public TooManyHoursWorkedException(String message) {
			super(message);
		}
	}
	
	public double computePay(int hours) throws Exception {
		if(hours < 0) {
			throw new NumberFormatException("Hours may not be negative.");
		}else if(hours > 40) {
			throw new TooManyHoursWorkedException("Employee may not work more than 40 hours per week.");
		}
		return hours * hourlyPay;
	}

}
