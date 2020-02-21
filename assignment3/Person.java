

public class Person {
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String SSN;
	protected Address address;
	protected boolean specialAccomodations;
	protected String ID;
	
	public Person(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	public Person(String fName, String lName, Address addr) {
		firstName = fName;
		lastName = lName;
		address = addr;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	public void setAddress(Address addr) {
		address = addr;
	}
	public void setSpecialAccomodations(boolean tf) {
		specialAccomodations = tf;
	}
	public void setID(String id) {
		ID = id;
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
	public Address getAddress() {
		return address;
	}
	public boolean getSpecialAccomodations() {
		return specialAccomodations;
	}
	public String getID() {
		return ID;
	}
}
