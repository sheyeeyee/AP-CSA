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

		Coordinates currLocation = getLocation();
		Coordinates newLocation = w.getAdjacentLocation(getLocation(), this.direction);
		
		if (newLocation != null && w.isLocationValid(newLocation)) {
			if(w.setOccupant(this, newLocation)) {
//				this.location = null;
//				w.setNull(currLocation);
				this.setLocation(newLocation);
				w.setOccupant(null, currLocation);
				return thisBoat + " moves from " + currLocation + " to " + newLocation + ". \n";
			}
			else return thisBoat + " cannot move to " + newLocation + " as it is occupied. \n";
		}
		else return thisBoat + " cannot move off the map. \n";
	}
	
	public String turn(int dir) {
		String result = this.getID();
		
		if (dir == -1) result += " turned left";
		else result += " turned right";
		
		this.direction += dir;
		if (direction < 0) direction = 7;
		if (direction > 7) direction = 0;
		result += ", now facing " + this.getLetterDirection() + ". \n";
		return result;
	}
	
	public String takeHit(int attack, World w) {
		String result = this.toString();
		
		if (strength > this.health) {
			this.setHealth(0);
			w.setOccupant(null, this.getLocation());
			result += " has been sunk! \n";
		}
		else {
			this.setHealth(this.getHealth() - attack);
			result += " takes " + attack + " damage. \n";
		}
		return result;
	}
	
	public String toString() {
		return this.getID();
	}

	public int getTeam() {
		return team;
	}

//	public void setTeam(int team) {
//		this.team = team;
//	}

	public Coordinates getLocation() {
		return location;
	}

	public void setLocation(Coordinates c) {
		this.location = c;
	}
	
//	public int getDirection() {
//		return direction;
//	}
	
	public String getDirection() {
		if (direction == 0) return "Y";
		if (direction == 1) return "U";
		if (direction == 2) return "J";
		if (direction == 3) return "M";
		if (direction == 4) return "N";
		if (direction == 5) return "B";
		if (direction == 6) return "G";
		if (direction == 7) return "T";
		return "";
	}
	
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
	
	public int getNumDirection() {
		return direction;
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
