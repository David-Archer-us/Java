

public class Person {
	private String firstName;
	private String lastName;
	private Integer age;
	
	public Person(String fName, String lName, int iAge)
	{
		firstName = fName;
		lastName = lName;
		age = iAge;
	}
	
	public void setFirstName(String name)
	{
		firstName = name;
	}
	public void setLastName(String name)
	{
		lastName = name;
	}
	public void setAge(int iAge)
	{
		age = iAge;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public Integer getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return "\nName: " + firstName + " " + lastName + " " + age;
	}

}
