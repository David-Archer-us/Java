

import java.util.ArrayList;
import java.util.List;

public class MethodTest {
	
	public static <T> int count(List<T> list)
	{
		int count = 0;
		for (T t : list)
		{
			count += 1;
		}
		return count;
	}

	public static void main(String[] args) 
	{
		List<String> sList = new ArrayList<>();
		sList.add("I am here.");
		sList.add("Where are you?");
		sList.add("I am looking for you.");
		sList.add("I can not find you.");
		sList.add("I miss you.");
		System.out.println("Number of Strings: " + count(sList));

		List<Integer> iList = new ArrayList<>();
		iList.add(1);
		iList.add(2);
		iList.add(3);
		iList.add(4);
		iList.add(5);
		iList.add(6);
		System.out.println("Number of Integers: " + count(iList));
		
		List<Double> dList = new ArrayList<>();
		dList.add(1.1);
		dList.add(2.2);
		dList.add(3.3);
		dList.add(4.4);
		dList.add(5.5);
		dList.add(6.6);
		dList.add(7.7);
		dList.add(8.8);
		System.out.println("Number of Doubles: " + count(dList));	
	}
}
