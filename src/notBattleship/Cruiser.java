package notBattleship;

public class Cruiser extends ScoutBoat {
	public Cruiser(int team, Coordinates location, int direction) {
		super(team, location, direction, 3, 3);
	}
	
	public String getID() {
		return "C" + this.getTeam();
	}
	
	public String getActions() {
		String ret1 = "Choose any of the following actions for the Cruiser:\n";
		String ret2 = "1. Move\n";
		String ret3 = "2. Turn left\n";
		String ret4 = "3. Turn right\n";
		return ret1 + ret2 + ret3 + ret4;
	}
	
	public String act(int[] choices, World w) {
		String returned = "";
		int left = -1;
		int right = 1;
		
		for (int i = 0; i < choices.length; i++) {
			if (choices[i] == 1) returned += this.move(w);
			if (choices[i] == 2) returned += this.turn(left);
			if (choices[i] == 3) returned += this.turn(right);
		}
		
		return returned;
	}
}
