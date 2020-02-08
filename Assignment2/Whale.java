

public class Whale extends Animal {

	public Whale(String sType, String sName, int iAge, String sSex,
			String sEnvironment, double dSpeed) {
		super(sType, sName, iAge, sSex, sEnvironment, dSpeed);
	}
	
	public void swim() {
		System.out.println("Swimming!");
	}
	
}
