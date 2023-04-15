package notBattleship;

public class Battleship extends Boat implements Attacker {
	public Battleship(int team, Coordinates location, int direction) {
		super(team, location, direction, 4, 3, 1);
	}
	
	public String getID() {
		return "B" + this.getTeam();
	}
	
	public String getActions() {
		String ret1 = "Choose any of the following actions for the Battleship:\n";
		String ret2 = "1. Move\n";
		String ret3 = "2. Turn left\n";
		String ret4 = "3. Turn right\n";
		String ret5 = "4. Attack\n";
		return ret1 + ret2 + ret3 + ret4 + ret5;
	}
	
	public String act(int[] choices, World w) {
		String returned = "";
		int left = -1;
		int right = 1;
		int choice = choices[0];
		
		if (choice == 1) returned += this.move(w);
		if (choice == 2) returned += this.turn(left);
		if (choice == 3) returned += this.turn(right);
		if (choice == 4) returned += this.attack(w);
		
		return returned;
	}
	
	public String attack(World w) {
		String result = "";
		
		Coordinates us = this.getLocation();
		Coordinates opp = w.getAdjacentLocation(us, this.getNumDirection());
		int strength = this.getStrength();
		
		if (opp != null) {
			Boat b = w.getOccupant(opp);
			if (b != null) {
				if (b.getTeam() != this.getTeam()) result += this.getID() + ": Fire cannons! " + b.takeHit(strength) + b.takeHit(strength) + "\n";
				else result += this.getID() + " can't attack because of friendly fire?? \n";
			}
		}
		else result += "There are no boats in range currently. \n";
		return result;
	}
}
