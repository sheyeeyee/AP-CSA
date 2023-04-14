package notBattleship;

public class AircraftCarrier extends Boat implements Attacker {
	private boolean hasPlanes;
	private double successRate = 1;
	
	public AircraftCarrier(int team, Coordinates location, int direction) {
		super(team, location, direction, 5, 1, 2);
	}
	
	public String getID() {
		return "A" + this.getTeam();
	}
	
	public String getActions() {
		String ret1 = "Choose any of the following actions for the Submarine:\n";
		String ret2 = "1. Move\n";
		String ret3 = "2. Turn left\n";
		String ret4 = "3. Turn right\n";
		String ret5 = "4. Launch planes\n";
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
		String returned = "";
		
		int vis = this.getVision();
		int attackR = Math.max(0, vis);
		
		if (hasPlanes) {
			for (int i = 0; i < attackR; i++) {
				for (int j = 0; j < attackR; j++) {
					Coordinates check = new Coordinates(i, j);
					
					if (w.isLocationOccupied(check)) {
						if (w.getOccupant(check).getTeam() != this.getTeam()) {
							returned += "Air raid!\n" + w.getOccupant(check).takeHit(attackR) + "\n";
							successRate *= 0.8;
							
							if (Math.random() > successRate) {
								hasPlanes = false;
								returned += "The planes have been destroyed. \n";
								return returned;
							}
						}
					}
					else returned += "There are no boats in this range currently. ";
				}
			}
		}
		if (!hasPlanes) {
			returned += this.getID() + " has no planes remaining. ";
		}
		return returned;
	}
}