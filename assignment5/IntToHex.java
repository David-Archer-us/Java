

import java.util.Scanner;

public class IntToHex {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an integer here: ");
		try {
			String input = in.nextLine().trim();
			int value = Integer.parseInt(input);
			System.out.println(Integer.toHexString(value));
			in.close();
		}catch(NumberFormatException Numex) {
			System.out.println("Invalid input operation!");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
