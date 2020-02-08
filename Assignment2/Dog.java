

public class Dog extends Animal implements Domesticated {

	public Dog(String sType, String sName, int iAge, String sSex,
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

	public void bark() {
		System.out.println("Barking!");
	}
	public void swim() {
		System.out.println("Swimming!");
	}
}
