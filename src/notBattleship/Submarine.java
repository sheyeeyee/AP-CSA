package notBattleship;

public class Submarine extends ScoutBoat implements Attacker {
	private int numOfTorpedoes;
	
	public Submarine(int team, Coordinates location, int direction, int numOfTorpedoes) {
		super(team, location, direction, 3, 2);
		this.numOfTorpedoes = numOfTorpedoes;
	}
	
	public String getID() {
		return "S" + this.getTeam();
	}
	
	public String getActions() {
		String ret1 = "Choose any of the following actions for the Submarine:\n";
		String ret2 = "1. Move\n";
		String ret3 = "2. Turn left\n";
		String ret4 = "3. Turn right\n";
		String ret5 = "4. Submerge\n";
		String ret6 = "5. Fire torpedoes\n";
		return ret1 + ret2 + ret3 + ret4 + ret5 + ret6;
	}
	
	public String act(int[] choices, World w) {
		String result = "";
		int left = -1;
		int right = 1;
		int choice = choices[0];
		
		if (choice == 1) result += this.move(w);
		if (choice == 2) result += this.turn(left);
		if (choice == 3) result += this.turn(right);
		if (choice == 4) result += this.submerge(w);
		if (choice == 5) result += this.attack(w);

		return result;
	}
	
	public String attack(World w) {
		String result = "";
		
		int vision = this.getVision();
		int strength = (int) (Math.random() * this.getStrength() + 1);
		
		Coordinates currCoord = this.getLocation();
		
		if (numOfTorpedoes <= 0) result += this.getID() + " has no torpedoes remaining. \n";
		else {
			for (int i = 0; i < vision; i++) {
				Boat opp;
				
				if (w.getAdjacentLocation(currCoord, this.getNumDirection()) != null) opp = w.getOccupant(w.getAdjacentLocation(currCoord, this.getNumDirection()));
				else opp = null;
				
				if (opp != null) {
					if (opp.getTeam() != this.getTeam()) {
						result += this.getID() + ": Fire torpedoes! " + opp.takeHit(strength, w) + "\n";
						numOfTorpedoes --;
					}
					else result += this.getID() + " can't attack because of friendly fire?? \n";
				}
				else result += this.getID() + ": There are no boats in range currently. \n";
//				currCoord = w.getAdjacentLocation(currCoord, this.getNumDirection());
//				Boat opp;
//				
//				if (currCoord != null) {
//					opp = w.getOccupant(currCoord);
//					
//					if (opp != null) {
//						if (opp.getTeam() != this.getTeam()) {
//							result += this.getID() + ": Fire cannons! " + opp.takeHit(strength) + opp.takeHit(strength) + "\n";
//							numOfTorpedoes -= 1;
//						}
//						else result += this.getID() + " can't attack because of friendly fire?? \n";
//					}
//				}
//				else result += "There are no boats in range currently. \n";
				
//				if (currCoord != null) {
//					currCoord = w.getAdjacentLocation(currCoord, this.getNumDirection());
//					Boat b = w.getOccupant(currCoord);
//					if (b != null) {
//						if (b.getTeam() != this.getTeam()) {
//							result += this.getID() + ": Fire cannons! " + b.takeHit(strength) + b.takeHit(strength) + "\n";
//							numOfTorpedoes -= 1;
//						}
//						else result += this.getID() + " can't attack because of friendly fire?? \n";
//					}
//				}
//				if (w.isLocationOccupied(currCoord)) {
//					
//				}
//				else result += "There are no boats in range currently. \n";
			}
		}
		return result;
	}
	
	public String submerge(World w) {
		while (true) {
			int currX = this.getLocation().getX();
			int currY = this.getLocation().getY();
			Coordinates oldLoc = new Coordinates(currX, currY);
			int newX = (int) (Math.random() * w.getWidth());
			int newY = (int) (Math.random() * w.getHeight());
			int minMove = 2;
			
			if (newX > currX + minMove || newX < currX - minMove) {
				if (newY > currY + minMove || newY < currY - minMove) {
					Coordinates newLoc = new Coordinates(newX, newY);
					if (newLoc != null && w.isLocationValid(newLoc)) {
						this.setLocation(newLoc);
						w.setOccupant(null, oldLoc);
					}
					return getID() + " moves from " + oldLoc + " to " + newLoc + ". ";
				}
			}
		}
	}
}