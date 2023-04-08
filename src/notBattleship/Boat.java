package notBattleship;

public abstract class Boat {
	private int team; //team number of this Boat
	private Coordinates location; //holds the position of the Boat
	private int direction; //direction the Boat is pointing in currently (as defined by the constants in the World object)
	private int health; //number of hits that the Boat can endure before sinking
	private int strength; //number of hits that the Boat can cause during an attack
	private int vision; //number of spaces in any direction that the Boat can view on the map
		//not dependent on which direction the Boat is facing

	public Boat(int team, Coordinates location, int direction, int health, int strength, int vision) {
//		int x = location.getX();
//		int y = location.getY();
		
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
			else return thisBoat + " cannot move to " + movedLocation + " as it is occupied.";
		}
		else return thisBoat + " cannot move off the map";
	}
	
	public String turn(int dir) {
		String returned = this.getID();
		
		if (dir == -1) returned += " turned left";
		else returned += " turned right";
		
		this.direction += dir;
		if (direction < 0) dir = 7;
		if (direction > 7) dir = 0;
		returned += ", now facing " + this.getLetterDirection();
		return returned;
	}
	
	public String takeHit(int attack) {
		String returned = this.toString();
		
		if (strength > this.health) {
			this.setHealth(0);
			returned += " has been sunk!";
		}
		else {
			this.setHealth(this.health - attack);
			returned += " takes " + attack + " damage.";
		}
		return returned;
	}
	
	public String toString() {
		return this.getID();
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

	public void setLocation(Coordinates c) {
		this.location = c;
	}
	
	public int getDirection() {
		return direction;
	}

//	public char getDirection() {
//		if (direction == 0) return '↑';
//		if (direction == 1) return '↗';
//		if (direction == 2) return '→';
//		if (direction == 3) return '↘';
//		if (direction == 4) return '↓';
//		if (direction == 5) return '↙';
//		if (direction == 6) return '←';
//		if (direction == 7) return '↖';
//		return ' ';
//	}
	
//	public char getDirection() {
//		if (direction == 0) return '\u2191';
//		if (direction == 1) return '\u2197';
//		if (direction == 2) return '\u2192';
//		if (direction == 3) return '\u2198';
//		if (direction == 4) return '\u2193';
//		if (direction == 5) return '\u2199';
//		if (direction == 6) return '\u2190';
//		if (direction == 7) return '\u2196';
//		return ' ';
//	}
	
	public String getLetterDirection() {
		if (direction == 0) return "N";
		if (direction == 1) return "NE";
		if (direction == 2) return "E";
		if (direction == 3) return "SE";
		if (direction == 4) return "S";
		if (direction == 5) return "SW";
		if (direction == 6) return "W";
		if (direction == 7) return "NW";
		return "";
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
