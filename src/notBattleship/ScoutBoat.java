package notBattleship;

public abstract class ScoutBoat extends Boat {
	public ScoutBoat(int team, Coordinates location, int direction, int health, int vision) {
		super(team, location, direction, health, 1, vision);
	}
	
	public String takeHit(int numAttack, World w) {
		int attacked = 1;
		int randomAttack = (int) ((Math.random() * 3) + 1);
		
		if (randomAttack == attacked) {
			return super.takeHit(numAttack, w);
		}
		else return this.getID() + " has avoided the attack! \n";
	}
}