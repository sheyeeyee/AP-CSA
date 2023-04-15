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
		String returned = "";
		int left = -1;
		int right = 1;
		int choice = choices[0];
		
		if (choice == 1) returned += this.move(w);
		if (choice == 2) returned += this.turn(left);
		if (choice == 3) returned += this.turn(right);
		if (choice == 4) returned += this.submerge(w);
		if (choice == 5) returned += this.attack(w);

		return returned;
	}
	
	public String attack(World w) {
		int vision = this.getVision();
		int strength = (int) (Math.random() * this.getStrength() + 1);
		Coordinates currCoord = this.getLocation();
		
		if (numOfTorpedoes <= 0) return this.getID() + " has no torpedoes remaining. ";
		
		else if (numOfTorpedoes > 0) {
			for (int i = 0; i < vision; i++) {
				currCoord = w.getAdjacentLocation(currCoord, this.getNumDirection());
				
				if (currCoord != null) {
					Boat b = w.getOccupant(currCoord);
					if (b != null) {
						if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
						else return this.getID() + " can't attack because of friendly fire?? ";
					}
				}
				else return "There are no boats in range currently. ";
			}
		}
		return "";
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