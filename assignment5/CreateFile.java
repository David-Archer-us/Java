

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		try {
			File file = new File("command_line_input.txt");
			file.createNewFile();
			FileWriter filewriter = new FileWriter(file, true);
			System.out.println("Please enter what you want here. You can enter '@q' to quit at any time. ");
			String input = "";
			String end = "";
			while(!(end.equals("@q"))) {
				input = in.nextLine().trim();
				end = input.substring(input.length()-2);
				if(end.equals("@q")) {
					input = input.substring(0, input.length()-2).trim();
				}
				filewriter.write(input + "\n");
			}
			filewriter.close();
			in.close();
		}catch(IOException io_ex) {
			System.out.println("Invalid I/O operation!");
		}catch(Exception input_ex) {
			System.out.println("An error occured!");
		}
	}
}
