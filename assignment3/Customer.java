

public class Customer extends Person {
	private String paymentMethodPreference;
	
	public Customer(String fName, String lName) {
		super(fName, lName);
	}
	public Customer(String fName, String lName, Address addr) {
		super(fName, lName, addr);
	}
	
	public void setPaymentMethodPreference(String paymentMethod) {
		paymentMethodPreference = paymentMethod;
	}
	public String getPaymentMethodPreference() {
		return paymentMethodPreference;
	}
	
	public String toString() {
		String description = "\nType: Customer" + "\nFirst Name: " + firstName
				+ "\nLast Name: " + lastName + "\nAge: " + age 
				+ "\nSocial Security Number: " + SSN 
				+ "\nAddress: " + address.toString()
				+ "\nSpecial Accomodations: " + specialAccomodations
				+ "\nID Number: " + ID + "\nPayment Method Preference: " + paymentMethodPreference;
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
			String shortDescription = description.substring(0, description.indexOf("Payment"));
			System.out.println(shortDescription);
		} else if (ssn == false && payment == true) {
			String description = toString();
			String shortDescription = description.substring(0, description.indexOf("Social"))
					+ description.substring(description.indexOf("Address"));
			System.out.println(shortDescription);
		} else {
			String description = toString();
			String shortDescription = description.substring(0, description.indexOf("Social"))
					+ description.substring(description.indexOf("Address"), description.indexOf("Payment"));
			System.out.println(shortDescription);
		}
	}
	
	public String makePayment() {
		return paymentMethodPreference;
	}
}
