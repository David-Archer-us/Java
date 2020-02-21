

public class Address {
	int streetNumber;
	String streetName;
	String cityName;
	String zipCode;
	String state;
	
	public Address(int iStreetNumber, String sStreetName, String sCityName,
			String sState, String sZipCode) {
		streetNumber = iStreetNumber;
		streetName = sStreetName;
		cityName = sCityName;
		zipCode = sZipCode;
		state = sState;
	}
	
	public void setStreetNumber(int num) {
		streetNumber = num;
	}
	public void setStreetName(String name) {
		streetName = name;
	}
	public void setCityName(String name) {
		cityName = name;
	}
	public void setZipCode(String code) {
		zipCode = code;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public String getZipcode() {
		return zipCode;
	}
	public String getState() {
		return state;
	}
	
	public String toString() {
		String addr = streetNumber + " " + streetName + ", " 
				+ cityName + ", " + state + " " + zipCode;
		return addr;
	}

}
