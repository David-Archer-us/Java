

public class Cat extends Animal implements Domesticated {

	public Cat(String sType, String sName, int iAge, String sSex,
			String sEnvironment, double dSpeed) {
		super(sType, sName, iAge, sSex, sEnvironment, dSpeed);
	}
	
	@Override
	public void walk() {
		System.out.println("Walking!");
	}

	@Override
	public void greetHuman() {
		System.out.println("Greeting!");
	}

	public void scratch() {
		System.out.println("Scratching!");
	}

}
