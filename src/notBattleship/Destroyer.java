package notBattleship;

public class Destroyer extends Boat implements Attacker {
	public Destroyer(int team, Coordinates location, int direction) {
		super(team, location, direction, 2, 2, 1);
	}

	public String getID() {
		return "D" + this.getTeam();
	}

	public String getActions() {
		String ret1 = "Choose any of the following actions for the Destroyer:\n";
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
		
		for (int i = 0; i < choices.length; i++) {
			if (choices[i] == 1) returned += this.move(w);
			if (choices[i] == 2) returned += this.turn(left);
			if (choices[i] == 3) returned += this.turn(right);
			if (choices[i] == 4) returned += this.attack(w);
		}
		return returned;
	}

	public String attack(World w) {
		Coordinates us = this.getLocation();
		Coordinates opp = w.getAdjacentLocation(us, this.getNumDirection());
		int strength = this.getStrength();
		
		if (opp != null) {
			Boat b = w.getOccupant(opp);
			if (b != null) {
				if (b.getTeam() != this.getTeam()) return this.getID() + ": Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
				else return this.getID() + " can't attack because of friendly fire?? ";
			}
		}
		return "There are no boats in range currently. ";
	}
	
	public String takeHit(int strength) {
		int ran = (int) (Math.random() * 1);
		
		if (ran == 1) {
			this.takeHit(strength);
			return this.getID() + " takes " + strength + " damage. ";
		}
		else return this.getID() + " avoids the attack! ";
	}
}
