package notBattleship;

public abstract class ScoutBoat extends Boat {
	public ScoutBoat(int team, Coordinates location, int direction, int health, int vision) {
		super(team, location, direction, health, 1, vision);
	}
	
	public String takeHit(int numAttack) {
		int attacked = 1;
		int randomAttack = (int) ((Math.random() * 3) + 1);
		
		if (randomAttack == attacked) return this.getID() + " takes 1 damage. ";
		else return this.getID() + " has avoided the attack! ";
	}
}