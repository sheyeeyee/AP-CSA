package notBattleship;

public class Coordinates {
	private int x, y;
	
	public Coordinates() {
		this.x = 0;
		this.y = 0;
	}
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
		Coordinates c = new Coordinates();
		System.out.println(c);
	}
	
	public void setCoordinates(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public String toString() {
		int row = x + 1;
		char col = (char)(65 + y); //char 65 is A in ASCII
		return "" + col + row;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
