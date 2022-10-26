package beginningClass;

import java.util.Scanner;

public class GreedyJava {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		double dollars;
		int cents;
		
		int quarter = 25;
		int quarterS;
		int changeRemainQuarter;
		
		int dime = 10;
		int dimeS;
		int changeRemainDime;
		
		int nickel = 5;
		int nickelS;
		int changeRemainNickel;
		
		int penny = 1;
		int pennyS;
		
		int change;
		
		System.out.println("O hai! How much change is owed?");
		dollars = reader.nextDouble();
		cents = (int) (dollars * 100); //make sure cents is an int since it will always be whole number, mult dollar by 100 to change to cents
		
		quarterS = (int) ((cents - (cents % quarter)) / quarter); //to make it a multiple of 25 and then find how many quarters
		changeRemainQuarter = (cents - (quarter * quarterS)); //25 times the amt of quarters to find the remaining change
		
		dimeS = (int) ((changeRemainQuarter - (changeRemainQuarter % dime)) / dime); //to make it a multiple of 10 and then find how many dimes
		changeRemainDime = (changeRemainQuarter - (dime * dimeS));
		
		nickelS = (int) ((changeRemainDime - (changeRemainDime % nickel)) / nickel); //to make it a multiple of 5 and then find how many nickels
		changeRemainNickel = (changeRemainDime - (nickel * nickelS));
		
		pennyS = (int) ((changeRemainNickel - (changeRemainNickel % penny)) / penny); //to make it a multiple of 1 and then find how many pennies
		
		change = quarterS + dimeS + nickelS + pennyS;

		System.out.println("You need " + quarterS + " quarter(s), " + dimeS + " dime(s), " + nickelS + " nickel(s), and " + pennyS + " penny(ies).");
	}	
}