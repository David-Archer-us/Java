


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class ListManipulator {
	
	ArrayList<Integer> sort(ArrayList<Integer> myLst, Boolean ascending)
	{
		ArrayList<Integer> lst = (ArrayList<Integer>)myLst.clone();
		if (ascending)
		{
			Collections.sort(lst);
			return lst;
		}
		else
		{
			Collections.sort(lst, Collections.reverseOrder());
			return lst;
		}
	}
	
	ArrayList<Integer> swapLargestSmallest(ArrayList<Integer> lst)
	{
		ArrayList<Integer> myLst = (ArrayList<Integer>)lst.clone();
		int largest = Collections.max(myLst);
		int smallest = Collections.min(myLst);
		int indexOfLargest = myLst.indexOf(largest);
		int indexOfsmallest = myLst.indexOf(smallest);
		myLst.set(indexOfsmallest, largest);
		myLst.set(indexOfLargest, smallest);
		return myLst;
	}
	
	void table(ArrayList<Integer> myLst)
	{
		
		Iterator<Integer> it = myLst.iterator();
		TreeMap<Integer, Integer> tablet = new TreeMap<>();
		
		while(it.hasNext())
		{
			int key = it.next();
			if (tablet.containsKey(key))
			{
				tablet.replace(key, tablet.get(key)+1);
			}
			else
			{
				tablet.put(key, 1);
			}
		}
		System.out.print(tablet);
	}

}
