package notBattleshipTester;

public class BoatRunnerTest extends BoatTest {
	
    public BoatRunnerTest(int team, CoordinatesTest location, int direction, int health, int strength, int vision) {
        super(team, location, direction, health, strength, vision);
    }
    
    public String getID() {
        return "BA";
    }
    
    public String act(int[] choices, WorldTest world){
        return "Not implemented in Part A";
    }
    
    public String getActions(){
        return "Not implemented in Part A";
    }
    
    public static void main(String[] args) {
        CoordinatesTest c = new CoordinatesTest(2, 3);
        CoordinatesTest d = new CoordinatesTest();
        if (d.getX() == 0 && d.getY() == 0) System.out.println("Coordinates default to 0");
        
        WorldTest w = new WorldTest(2, 5); //should default to minimum of x = 4
//        System.out.println(w.getHeight());
//        System.out.println(w.getWidth());
        if (w.getHeight() == 5) {
            System.out.println("World height is correct");
        }
        if (!w.isLocationValid(new CoordinatesTest(2,6)))
            System.out.println("Marks an incorrect location");
        
        BoatRunnerTest a = new BoatRunnerTest(1, new CoordinatesTest(0,0), 0, 9, 5, 6);
        
        if (w.setOccupant(a, new CoordinatesTest(0,0)))
            System.out.println("Set a boat at (0,0)");
        CoordinatesTest e = w.getAdjacentLocation(new CoordinatesTest(0,0), w.SOUTHEAST);
        
        BoatRunnerTest[] barray = new BoatRunnerTest[1];
        barray[0] = new BoatRunnerTest(1, new CoordinatesTest(3,3), 2, 9, 5, 2);
//        barray[1] = new BoatRunner(1, new Coordinates(0,0), 2, 9, 5, 2);
        
//        System.out.println(w.drawTeamMap(null, 1));
        String map1 = w.drawTeamMap(barray, 2);
        System.out.println(map1);
        
    }
}