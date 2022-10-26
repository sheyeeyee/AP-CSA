package beginningClass;

import java.util.Scanner;

public class CarRunner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Make: ");
		String m = input.nextLine();
		
		System.out.print("Year: ");
		int yM = input.nextInt();
		
		Car myCar = new Car(yM, m);
		
		for (int i = 0; i < 5; i++) {	
			myCar.accelerate();
			System.out.println(myCar.getYearModel() + " " + myCar.getMake() + ", Car Speed: " + myCar.getSpeed());
		}
		
		for (int i = 0; i < 5; i++) {	
			myCar.brake();
			System.out.println(myCar.getYearModel() + " " + myCar.getMake() + ", Car Speed: " + myCar.getSpeed());
		}
	}

}