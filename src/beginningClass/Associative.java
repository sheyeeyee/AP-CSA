package beginningClass;

import java.util.Scanner;

public class Associative {
	private int x;
	private int y;
	private int z;
	
	public Associative(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int firstTwo() { //this is a method of the class Associative
		return (x + y) * z;
	}
	
	public int lastTwo() {
		return x + (y * z);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please input your three integers."); //collect the first second third values before attributing them to the object
		int first = reader.nextInt();
		int second = reader.nextInt();
		int third = reader.nextInt();
		
		Associative assoc = new Associative(first, second, third);
		
		System.out.println("Grouping the first two terms, (" + first + " + " + second + ") * " + third + " = " + assoc.firstTwo());
		System.out.println("Grouping the last two terms, " + first + " + (" + second + " * " + third + ")" + " = " + assoc.lastTwo());
	}

}