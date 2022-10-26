package beginningClass;

import java.util.Scanner;

public class Mario {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int height;
		
		while (true) {
			System.out.println("Please input an integer pyramid height no less than 0 and no greater than 23.");
			height = reader.nextInt();
			
			if (height >= 0 && height <= 23) {
				break;
			}
			System.out.println("Invalid height.");
		}
		
		for (int i = 1; i <= height; i++) { //repeat until it reaches the number of layers
			//initializing strings for # and spaces
			String tag = "";
			String space = "";
			
			for (int t = 0; t < i; t++) { //the # correlate with the number of layers
				tag += "#";
			}
			
			for (int s = 0; s < height - i; s++) { //you account for the # taking up one character
				space += " ";
			}
			
			System.out.println(space + tag + " " + tag);
		}
	}

}