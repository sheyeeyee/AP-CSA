package veryBeginning;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		
		int age;
		String first, last, name; //declaring a string that can be printed
		Scanner reader = new Scanner(System.in); //setting up scanner object (reader is the name)
		
//		System.out.println("How old are you? ");
//		age = reader.nextInt(); //takes an integer for age
//		System.out.println("You are " + age + " years old.");
		
//		System.out.println("What is your name? ");
//		name = reader.next(); //only print one word
//		System.out.println("Hi " + name);
		
//		System.out.println("What is your name? ");
//		name = reader.nextLine(); //print all words in the same line
//		System.out.println("Hi " + name);
		
//		double land;

//		System.out.println("How many square feet of land do you own?");
//		land = reader.nextDouble();
//		double acres = land/43650.0;
//		System.out.println("You own " + acres + " acres of land");
		
//		double x = 3.1415926;
//		x = x * 10000;
//		x = Math.round(x)/10000;
//		System.out.println(x);
		
//		String city;
//		
//		System.out.println("What is your favorite city?");
//		city = reader.nextLine();
//		System.out.println("There are " + city.length() + " characters in this city name."); //.length() counts the number of characters
//		System.out.println(city.toUpperCase());
//		System.out.println(city.toLowerCase());
		
		double change = 4.52;
		int hello;
		hello = (int) change * 100;
		System.out.println(hello);
	}
}