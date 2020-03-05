

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileInput {

	public static void main(String[] args) throws Exception {
		
		try {
			Scanner reader = new Scanner(new File("quote.txt"));
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
			}
			reader.close();
		}catch(IOException IOex) {
			System.out.println("Invalid I/O operation!");
		}catch(Exception ex) {
			System.out.println("An error occured!");	
		}
	}
}
