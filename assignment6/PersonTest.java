

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class PersonTest {

	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<>();
		
		persons.add(new Person("Joe", "Smith", 40));
		persons.add(new Person("Amy", "Gold", 32));
		persons.add(new Person("Tony", "Stork", 21));
		persons.add(new Person("Sean", "Irish", 24));
		persons.add(new Person("Tina", "Brock", 28));
		persons.add(new Person("Lenny", "Hep", 18));
		
		sortPersons(persons, "firstName", true);
		printPersons(persons);
		sortPersons(persons, "firstName", false);
		printPersons(persons);
		sortPersons(persons, "lastName", true);
		printPersons(persons);
		sortPersons(persons, "lastName", false);
		printPersons(persons);
		sortPersons(persons, "age", true);
		printPersons(persons);
		sortPersons(persons, "age", false);
		printPersons(persons);
	}
	
	public static void sortPersons(ArrayList<Person> persons, String attr, Boolean ascending) 
	{
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				int result = 0;
				switch(attr) {
					case "firstName":
						result = p1.getFirstName().compareTo(p2.getFirstName());
						break;
					case "lastName":
						int p1L = p1.getLastName().length();
						int p2L = p2.getLastName().length();
						result = p1L - p2L;
						break;
					case "age":
						result = p1.getAge() - p2.getAge();
						break;
					default:
						result = 0;
						break;
				}
				if(ascending == false)
				{
					result = - result;
				}
				return result;
			}
		});
	}
	
	public static void printPersons(ArrayList<Person> persons)
	{
		Iterator it = persons.iterator();
		String personString = "";
		while(it.hasNext())
		{
			personString += it.next().toString();
			
		}
		System.out.println();
		System.out.print(personString);
	}

}
