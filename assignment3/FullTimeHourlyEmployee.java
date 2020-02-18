package assignment3;

public class FullTimeHourlyEmployee extends PartTimeHourlyEmployee {
	protected double overtimePay;
	
	public FullTimeHourlyEmployee(String fName, String lName) {
		super(fName, lName);
	}
	public FullTimeHourlyEmployee(String fName, String lName, Address addr) {
		super(fName, lName, addr);
	}
	
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	public double getOvertimePay() {
		return overtimePay;
	}
	
	public String toString() {
		String description = "\nType: FullTimeHourlyEmployee" + "\nFirst Name: " + firstName
				+ "\nLast Name: " + lastName + "\nAge: " + age 
				+ "\nSocial Security Number: " + SSN 
				+ "\nAddress: " + address.toString()
				+ "\nSpecial Accomodations: " + specialAccomodations
				+ "\nID Number: " + ID + "\nHourly Pay: " + hourlyPay
				+ "\nOvertime Pay: " + overtimePay;
		return description;
	}
	public void introduce() {
		System.out.println(toString());
	}
	public void introduce(boolean ssn) {
		if (ssn == true) {
			System.out.println(toString());
		} else {
			String description = toString();
			String shortDescription = description.substring(0, description.indexOf("Social"))
					+ description.substring(description.indexOf("Address"));
			System.out.println(shortDescription);
		}
	}
	public void introduce(boolean ssn, boolean payment) {
		if (ssn == true && payment == true) {
			System.out.println(toString());
		} else if (ssn == true && payment == false) {
			String description = toString();
			String shortDescription = description.substring(0, description.indexOf("Hourly Pay"));
			System.out.println(shortDescription);
		} else if (ssn == false && payment == true) {
			String description = toString();
			String shortDescription = description.substring(0, description.indexOf("Social"))
					+ description.substring(description.indexOf("Address"));
			System.out.println(shortDescription);
		} else {
			String description = toString();
			String shortDescription = description.substring(0, description.indexOf("Social"))
					+ description.substring(description.indexOf("Address"), description.indexOf("Hourly Pay"));
			System.out.println(shortDescription);
		}
	}
	
	public double computePay(double hours) {
		if(hours>40) {
			return 40 * hourlyPay + (hours - 40) * overtimePay;
		}
		return hourlyPay * hours;
	}


}
