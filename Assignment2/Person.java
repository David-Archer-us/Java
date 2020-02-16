

public class Person {
	
	private String firstName;
	private String lastName;
	private Integer age;
	private String SSN;
	private String address;
	private String gender;
	private Double weight;
	
	public Person(String fName, String lName, int iAge, String sSSN,
			 String sAddress, String sGender, double dWeight) {
		firstName = fName;
		lastName = lName;
		age = iAge;
		SSN = sSSN;
		address = sAddress;
		gender = sGender;
		weight = dWeight;
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
	public void setSSN(String sSSN) {
		SSN = sSSN;
	}
	public void setAddress(String sAddress) {
		address = sAddress;
	}
	public void setGender(String sGender) {
		gender = sGender;
	}
	public void setWeight(double dWeight) {
		weight = dWeight;
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
	public String getSSN() {
		return SSN;
	}
	public String getAddress() {
		return address;
	}
	public String getGender() {
		return gender;
	}
	public double getWeight() {
		return weight;
	}
	
	public String toString() {
		String description = firstName + " " + lastName + ":\n"
				+ "Age: " + age + "\nSocial security number: "
				+ SSN + "\nAddress: " + address + "\nGender: "
				+ gender + "\nWeight: " + weight + "\n";
		return description;
	}
	public void introduce() {
		System.out.println(this.toString());
	}

}
