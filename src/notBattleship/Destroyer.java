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
		String result = "";
		int left = -1;
		int right = 1;
		
		for (int i = 0; i < choices.length; i++) {
			if (choices[i] == 1) result += this.move(w);
			if (choices[i] == 2) result += this.turn(left);
			if (choices[i] == 3) result += this.turn(right);
			if (choices[i] == 4) result += this.attack(w);
		}
		return result;
	}

	public String attack(World w) {
		Coordinates oppLocation = w.getAdjacentLocation(this.getLocation(), this.getNumDirection());
		Boat opp;
		int strength = this.getStrength();
		
		if (oppLocation != null) opp = w.getOccupant(oppLocation);
		else opp = null;
		
		if (opp != null) {
			if (opp.getTeam() != this.getTeam()) {
				return this.getID() + ": Fire cannons! " + opp.takeHit(strength, w) + opp.takeHit(strength, w) + "\n";
			}
			else return this.getID() + " can't attack because of friendly fire?? \n";			
		}
		else return this.getID() + ": There are no boats in range currently. \n";
//		String result = "";
//		
//		Coordinates c = this.getLocation();
//		Coordinates opp = w.getAdjacentLocation(c, this.getNumDirection());
//		int strength = this.getStrength();
//		
//		if (opp != null) {
//			Boat b = w.getOccupant(opp);
//			if (b != null) {
//				if (b.getTeam() != this.getTeam()) result += this.getID() + ": Fire cannons! " + b.takeHit(strength) + b.takeHit(strength) + "\n";
//				else result += this.getID() + " can't attack because of friendly fire?? \n";
//			}
//		}
//		else result += "There are no boats in range currently. \n";
//		return result;
	}
	
	public String takeHit(int strength) {
		int ran = (int) (Math.random() * 1);
		
		if (ran == 1) {
			this.takeHit(strength);
			return this.getID() + " takes " + strength + " damage. \n";
		}
		else return this.getID() + " avoids the attack! \n";
	}
}
