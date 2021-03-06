

public class Employee extends Person {
	
	private String employeeID;
	private String employeeStatus;
	private String startDate;
	private Double hourlyPay;
	private Double yearlySalary;
	
	public Employee(String fName, String lName, int iAge, String sSSN,
			 String sAddress, String sGender, double dWeight, 
			 String sEmployeeID, String status, String date,
			 double dHourlyPay, double dYearlySalary) 
	{
		super(fName, lName, iAge, sSSN, sAddress, sGender, dWeight);
		employeeID = sEmployeeID;
		employeeStatus = status;
		startDate = date;
		hourlyPay = dHourlyPay;
		yearlySalary = dYearlySalary;
	}
	
	public void setEmployeeID(String id) {
		employeeID = id;
	}
	public void setEmployeeStatus(String status) {
		employeeStatus = status;
	}
	public void setStartDate(String date) {
		startDate = date;
	}
	public void setHourlyPay(double pay) {
		hourlyPay = pay;
	}
	public void setYearlySalary(double salary) {
		yearlySalary = salary;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public String getStartDate() {
		return startDate;
	}
	public double getHourlyPay() {
		return hourlyPay;
	}
	public double getYearlySalary() {
		return yearlySalary;
	}
	
	public String toString() {
		String description = getFirstName() + " " + getLastName() + ":\n"
				+ "Age: " + getAge() + "\nSocial security number: "
				+ getSSN() + "\nAddress: " + getAddress() + "\nGender: "
				+ getGender() + "\nWeight: " + getWeight() + "\n"
				+ "Employee ID: " + getEmployeeID() + "\n" 
				+ "Employee Status: " + getEmployeeStatus() + "\n"
				+ "Start Date: " + getStartDate();
		if (employeeStatus == "full time") {
			description += "\nYearly Salary: " + yearlySalary;
		} else {
			description += "\nHourly Pay: " + hourlyPay;
		}
		return description;
	}
	
	public void introduce() {
		System.out.println(toString());
	}
	
	public double calculatePay(int hoursOrWeeks) {
		double pay = 0.0;
		if (employeeStatus == "full time") {
			pay = hoursOrWeeks * (yearlySalary / 52);
		} else {
			pay = hoursOrWeeks * hourlyPay;
		}
		return pay;
	}

}
