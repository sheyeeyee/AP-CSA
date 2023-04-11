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
		int thisX = us.getX();
		int thisY = us.getY();
		String dir = this.getLetterDirection();
		int vis = this.getVision();
		int strength = this.getStrength();
		
		if (dir == "N") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX;
				int y = thisY - i;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "NE") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX + i;
				int y = thisY - i;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "E") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX + i;
				int y = thisY;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "SE") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX + i;
				int y = thisY + i;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "S") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX;
				int y = thisY + i;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "SW") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX - i;
				int y = thisY + i;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "W") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX - i;
				int y = thisY;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		if (dir == "NW") {
			for (int i = 1; i <= vis; i++) {
				int x = thisX - i;
				int y = thisY - i;
				Boat b = w.getOccupant(new Coordinates(x, y));
				
				if (b != null) {
					if (b.getTeam() != this.getTeam()) return "Fire cannons! " + b.takeHit(strength) + b.takeHit(strength);
					else return "Should be okay... ";
				}
			}
			return "There are no boats in range currently. ";
		}
		return "bruh";
	}
}
