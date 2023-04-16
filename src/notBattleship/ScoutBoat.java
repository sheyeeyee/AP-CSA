package notBattleship;

public abstract class ScoutBoat extends Boat {
	public ScoutBoat(int team, Coordinates location, int direction, int health, int vision) {
		super(team, location, direction, health, 1, vision);
	}
	
	public String takeHit(int numAttack, World w) {
		int attacked = 0;
		int randomAttack = (int) (Math.random() * 4);
		
		if (randomAttack != attacked) {
			return this.getID() + " has avoided the attack! \n";
		}
		else return super.takeHit(numAttack, w);
//		return super.takeHit(numAttack, w);
	}
}