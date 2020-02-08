

public class Animal {
	String type;
	String name;
	int age;
	String sex;
	String environment;
	double speed;
	
	public Animal(String sType, String sName, int iAge, String sSex,
			String sEnvironment, double dSpeed) {
		type = sType;
		name = sName;
		age = iAge;
		sex = sSex;
		environment = sEnvironment;
		speed = dSpeed;
	}
	
	public void setType(String sType) {
		type = sType;
	}
	public void setName(String sName) {
		name = sName;
	}
	public void setAge(int iAge) {
		age = iAge;
	}
	public void setSex(String sSex) {
		sex = sSex;
	}
	public void setEnvironment(String sEnvironment) {
		environment = sEnvironment;
	}
	public void setSpeed(double dSpeed) {
		speed = dSpeed;
	}
	
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getEnvironment() {
		return environment;
	}
	public double getSpeed() {
		return speed;
	}
	
	public void move() {
		System.out.println("Moving!");
	}
	public void sound() {
		System.out.println("Sounding!");
	}
	public void eat() {
		System.out.println("Eating!");
	}
	public void sleep() {
		System.out.println("Sleeping!");
	}
	
	public String toString() {
		String s = "\nType: " + type + "\nName: " + name
				+ "\nAge: " + age + "\nSex: " + sex
				+ "\nEnvironment: " + environment 
				+ "\nSpeed: " + speed;
		return s;
	}

}
