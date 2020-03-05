

public class Course implements Cloneable{
	private String name, description, department, time, weekday;
	
	public Course(String sName) {
		name = sName;
		description = "";
		department = "";
		time = "";
		weekday = "";
	}
	public Course(String sName, String sDescription, String sDepartment, String sTime, String sWeekday) {
		name = sName;
		description = sDescription;
		department = sDepartment;
		time = sTime;
		weekday = sWeekday;
	}
	
	public void setName(String sName) {
		name = sName;
	}
	public void setDescription(String sDescription) {
		description = sDescription;
	}
	public void setDepartment(String sDepartment) {
		department = sDepartment;
	}
	public void setTime(String sTime) {
		time = sTime;
	}
	public void setWeedday(String sWeekday) {
		weekday = sWeekday;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getDepartment() {
		return department;
	}
	public String getTime() {
		return time;
	}
	public String getWeekday() {
		return weekday;
	}
	
	public String toString() {
		String course = name + ", " + description + ", " + department + ", "
				+ time + ", " + weekday;
		return course;
	}
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
