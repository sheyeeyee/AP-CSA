package notBattleshipTester;

public class CoordinatesTest {
	private int x, y;
	public CoordinatesTest() {
		this.x = 0;
		this.y = 0;
	}
	
	public CoordinatesTest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		char chara = (char) (65 + this.y);
		String ret = "";
		ret += chara;
		ret += (this.x+1);
		return ret;
	}
	
	
}