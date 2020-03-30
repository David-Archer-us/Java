

import java.util.ArrayList;

public class ListManipulatorTester {

	public static void main(String[] args) {
		ListManipulator lm = new ListManipulator();
		
		ArrayList<Integer> lis = new ArrayList<>();
		lis.add(3);
		lis.add(8);
		lis.add(10);
		lis.add(199);
		lis.add(10);
		lis.add(8);
		lis.add(33);
		lis.add(199);
		lis.add(3);
		lis.add(8);
		lis.add(22);
		
		System.out.print(lis + "\n\n\n");
		
		ArrayList<Integer> newLis_1 = lm.sort(lis, true);
		System.out.print(newLis_1 + "\n");
		System.out.print(lis + "\n\n\n");
		
		ArrayList<Integer> newLis_2 = lm.sort(lis, false);
		System.out.print(newLis_2 + "\n");
		System.out.print(lis + "\n\n\n");
		
		ArrayList<Integer> newLis_3 = lm.swapLargestSmallest(lis);
		System.out.print(newLis_3 + "\n");
		System.out.print(lis + "\n\n\n");
		
		lm.table(lis);
		System.out.print("\n" + lis + "\n\n\n");

	}

}
