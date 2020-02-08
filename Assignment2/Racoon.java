

public class Racoon extends Animal {
	
	public Racoon(String sType, String sName, int iAge, String sSex,
			String sEnvironment, double dSpeed) {
		super(sType, sName, iAge, sSex, sEnvironment, dSpeed);
	}
	
	public void swim() {
		System.out.println("Swimming!");
	}
	public void scratch() {
		System.out.println("Scratching!");
	}

}
