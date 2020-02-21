

public class Employee extends Person {
	protected String levelOfEducation;
	protected boolean directDeposit;
	
	public Employee(String fName, String lName) {
		super(fName, lName);
	}
	public Employee(String fName, String lName, Address addr) {
		super(fName, lName, addr);
	}
	
	public void setLeveOfEducation(String level) {
		levelOfEducation = level;
	}
	public void setDirectDeposit(boolean tf) {
		directDeposit = tf;
	}
	
	public String getLevelOfEducation() {
		return levelOfEducation;
	}
	public boolean getDirectDeposit() {
		return directDeposit;
	}
}
