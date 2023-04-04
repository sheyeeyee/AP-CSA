package notBattleship;

import notBattleship.World;

public abstract class Boat {
	private int team; //team number of this Boat
	private Coordinates location; //holds the position of the Boat
	private int direction; //direction the Boat is pointing in currently (as defined by the constants in the World object)
	private int health; //number of hits that the Boat can endure before sinking
	private int strength; //number of hits that the Boat can cause during an attack
	private int vision; //number of spaces in any direction that the Boat can view on the map
		//not dependent on which direction the Boat is facing

	public Boat(int team, Coordinates location, int direction, int health, int strength, int vision) {
		int x = location.getX();
		int y = location.getY();
		
		this.team = team;
		this.location = location;
		this.direction = direction;
		this.health = health;
		this.strength = strength;
		this.vision = vision;
	}
	
	public abstract String getID();
	public abstract String act(int[] choices, World w);
	public abstract String getActions();
	
	public String move(World w) {
		String thisBoat = this.toString();
		
		String currLocation = this.location.toString(); //need this bc that position will be null
		Coordinates newLocation = w.getAdjacentLocation(this.location, this.direction);
		
		if (newLocation != null && w.isLocationValid(newLocation)) {
			String movedLocation = newLocation.toString();
			if(w.setOccupant(this, newLocation)) {
				this.location = null;
				this.setLocation(newLocation);
				return thisBoat + " moves from " + currLocation + " to " + newLocation;
			}
		}
		
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public Coordinates getLocation() {
		return location;
	}

	public void setLocation(Coordinates location) {
		this.location = location;
	}

	public int getDirection() {
		if (direction == 0) return '\u2191';
		if (direction == 1) return '\u2197';
		if (direction == 2) return '\u2192';
		if (direction == 3) return '\u2198';
		if (direction == 4) return '\u2193';
		if (direction == 5) return '\u2199';
		if (direction == 6) return '\u2190';
		if (direction == 7) return '\u2196';
		return ' ';
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}
}
