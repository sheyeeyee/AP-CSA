package beginningClass;

import java.util.Scanner;

public class LeapYear {	
	public static boolean isLeapYear(int year) { //don't need an object to call it, the class calls it, you need year to be an argument
		if(year % 4 == 0) {
			if(year % 100 == 0 && year % 400 != 0) {
				return false;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please type in a year.");
		int givenYear = reader.nextInt();
		
		if(isLeapYear(givenYear) == true) {
			System.out.println(givenYear + " is a leap year.");
		}
		else {
			System.out.println(givenYear + " is not a leap year.");
		}
	}
}