package beginningClass;

public class Car {
	private int yearModel;
	private String make;
	private int speed;
	
	public Car (int yM, String m) {
		speed = 0;
		yearModel = yM;
		make = m;
	}
	
	public int getYearModel() {
		return yearModel;
	}

	public String getMake() {
		return make;
	}

	public int getSpeed() {
		return speed;
	}

	public void accelerate() {
		speed += 5;
	}
	
	public void brake() {
		speed -= 5;
	}
}