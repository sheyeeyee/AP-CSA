package beginningClass;

import java.util.Scanner;

public class EmailGenerator {
		
	public static String makeUserName(String first, String last) {
		return (first + last.substring(0,1)).toLowerCase();
	}
	
	public static int makeIdNumber() {
		return (int)((Math.random() + 1) * Math.pow(10, 8));
	}
	
	public static String makeEmail(String user, int id, String domain) {
		return user + ("" + id).substring(5) + domain;
	}
	
	public static void main(String[] args) {
		Scanner names = new Scanner(System.in);
		
		System.out.println("Please input your name.");
		String firstName = names.next();
		String lastName = names.next();
		
		String domain = "@mytusd.org";
		
		System.out.println(makeIdNumber());
		System.out.println("This user's email is: " + makeEmail(makeUserName(firstName, lastName), makeIdNumber(), domain));
	}
}