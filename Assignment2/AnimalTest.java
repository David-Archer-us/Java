

public class AnimalTest {

	public static void main(String[] args) {
		
		Dog myDog = new Dog("L", "Loise", 3, "F", "home", 10.0);
		Cat myCat = new Cat("B", "Rose", 2, "F", "home", 5.8);
		Racoon myRacoon = new Racoon("G", "Laura", 3, "M", "forest", 3.9);
		Whale myWhale = new Whale("F", "Warmer", 8, "F", "ocean", 30.0);
		
		System.out.print("My Dog" + myDog.toString() + "\n");
		myDog.walk();
		myDog.greetHuman();
		myDog.swim();
		myDog.bark();
		System.out.println("\n");
		
		System.out.print("My Cat" + myCat.toString() + "\n");
		myCat.toString();
		myCat.walk();
		myCat.greetHuman();
		myCat.scratch();
		System.out.println("\n");

		System.out.print("My Racoon" + myRacoon.toString() + "\n");
		myRacoon.toString();
		myRacoon.swim();
		myRacoon.scratch();
		System.out.println("\n");
		
		System.out.print("My Whale" + myWhale.toString() + "\n");
		myWhale.toString();
		myDog.swim();
		System.out.println("\n");
		
	}

}
