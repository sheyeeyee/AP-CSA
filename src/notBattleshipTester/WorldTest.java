package notBattleshipTester;
import java.util.*;

public class WorldTest {
	private static BoatTest[][] map;
	static final int NORTH = 0;
	static final int NORHTEAST = 1;
	static final int EAST = 2;
	static final int SOUTHEAST = 3;
	static final int SOUTH = 4;
	static final int SOUTHWEST = 5;
	static final int WEST = 6;
	static final int NORTHWEST = 7;
	
	public WorldTest(int width, int height) {
		if(Math.min(width, 4) == width) {
			width = 4;
		}
		else if(Math.max(width, 10) == width) {
			width = 10;
		}
		
		if(Math.min(height, 4) == height) {
			height = 4;
		}
		else if(Math.max(height, 10) == height) {
			height = 10;
		}
		
		map = new BoatTest[height][width];
		for(int i = 0; i < height; i ++) {
			for(int j = 0; j < width; j ++) {
				map[i][j] = null;
			}
		}
	}
	
	public int getWidth() {
		return this.map[0].length;
	}
	
	public int getHeight() {
		return this.map.length;
	}
	
	public BoatTest getOccupant(Coordinates coord) {
		int x = coord.getX();
		int y = coord.getY();
		return map[y][x];
	}
	
	public boolean isLocationValid(CoordinatesTest checked) {
		int x = checked.getX();
		int y = checked.getY();
		
		if(x < 0 || x >= this.getWidth()) {
			return false;
		}
		if(y < 0 || y >= this.getHeight()) {
			return false;
		}

		return true;
	}
	
	public boolean isLocationOccupied(CoordinatesTest checkedCoord) {
		int x = checkedCoord.getX();
		int y = checkedCoord.getY();
		
		return map[y][x] != null;
	}
	
	public boolean setOccupant(BoatTest boat, CoordinatesTest coord) {
		int x = coord.getX();
		int y = coord.getY();
		if(!isLocationOccupied(coord)) {
			map[y][x] = boat;
			return true;
		}
		return false;
	}
	
	public static void setNull(CoordinatesTest coord) {
		int x = coord.getX();
		int y = coord.getY();
		WorldTest.map[y][x] = null;
	}
	// 8, 0
	public CoordinatesTest getAdjacentLocation(CoordinatesTest coord, int direction) {
		int y = coord.getX();
		int x = coord.getY();
		switch(direction) {
			case(0): // north
				CoordinatesTest checked = new CoordinatesTest(y, x-1); // north works
				if(isLocationValid(checked)) return checked;
				break;
			case(1):
				CoordinatesTest checked2 = new CoordinatesTest(y+1, x-1); 
				if(isLocationValid(checked2)) return checked2;
				break;
			case(2):
				CoordinatesTest checked3 = new CoordinatesTest(y+1, x);
				if(isLocationValid(checked3)) return checked3;
				break;
			case(3):
				CoordinatesTest checked4 = new CoordinatesTest(y+1, x+1);
				if(isLocationValid(checked4)) return checked4;
				break;
			case(4):
				CoordinatesTest checked5 = new CoordinatesTest(y, x+1);
				if(isLocationValid(checked5)) return checked5;
				break;
			case(5):
				CoordinatesTest checked6 = new CoordinatesTest(y-1, x+1);
				if(isLocationValid(checked6)) return checked6;
				break;
			case(6):
				CoordinatesTest checked7 = new CoordinatesTest(y-1, x); // WEST WORKS
				if(isLocationValid(checked7)) return checked7;
				break;
			case(7):
				CoordinatesTest checked8 = new CoordinatesTest(y-1, x-1);
				if(isLocationValid(checked8)) return checked8;
				break;
		}
		return null;
	}
	
	public String drawTeamMap(BoatTest[] boats, int view) {
//		System.out.println(this.getHeight());
//		System.out.println(this.getWidth());
		String[][] addOns = new String[this.getHeight()][this.getWidth()];
		String ret = "@ ";
		
		for(int i = 0; i < addOns.length; i ++) {
			for(int j = 0; j < addOns[0].length; j ++) {
				addOns[i][j] = "###";
			}
		}
		
		if(view == 1) {
			for(int i = 0; i < this.getWidth(); i ++) {
				int add = i + 1;
				ret += " ";
				ret += add;
				ret += " ";
			}
			for(int i = 0; i < this.getHeight(); i ++) {
				ret += "\n";
				ret += (char) (i + 65) + " ";
				for(int j = 0; j < this.getWidth(); j++) {
					ret += addOns[i][j];
				}
			}
			return ret;
		}
		else if (view == 2) {
			for(BoatTest boat : boats) {
				CoordinatesTest coord = boat.getLocation();
				int x = coord.getX();
				int y = coord.getY();
				int vision = boat.getVision();
				
				int startY = Math.max(0, y-vision);
				int startX = Math.max(0,  x - vision);
//				String add = boat.getDirection() + boat.toString() +  " (" + x + "," + y + ")";
//				System.out.println(add);
				addOns[y][x] = boat.getDirection() + boat.toString();
//				System.out.println(boat.toString());
				for(int i = startY; i <= Math.min(this.getHeight()-1, y + vision); i ++) {
					
					for(int j = startX; j <= Math.min(this.getWidth()-1, x + vision); j ++) {
//						System.out.println("--");
//						System.out.println(j);
//						System.out.println(i);
						CoordinatesTest checkedCoord = new CoordinatesTest(j, i);
						if (isLocationOccupied(checkedCoord)) {
							if(map[i][j].getTeam() != boat.getTeam()) addOns[i][j] = map[i][j].getDirection() + map[i][j].toString();
						}
						if(addOns[i][j].equals("###")) addOns[i][j] = "~~~";
					}
				}
			}
		}
		else if(view == 3){
			for(BoatTest boat : boats) {
				CoordinatesTest coord = boat.getLocation();
				int x = coord.getX();
				int y = coord.getY();
				int vision = boat.getVision();
				
				int startY = Math.max(0, y-vision);
				int startX = Math.max(0,  x - vision);
				
				addOns[y][x] = boat.getHealth() + boat.toString();
				
				for(int i = startY; i <= Math.min(this.getHeight()-1, y + vision); i ++) {
					for(int j = startX; j <= Math.min(this.getWidth()-1, x + vision); j ++) {
						
						CoordinatesTest checkedCoord = new CoordinatesTest(j, i);

						if (isLocationOccupied(checkedCoord)) {
							if(map[i][j].getTeam() != boat.getTeam()) addOns[i][j] = map[i][j].getHealth() + map[i][j].toString();
						}
						if(addOns[i][j].equals("###")) addOns[i][j] = "~~~";
					}
				}
			}
		}
		for(int i = 0; i < this.getWidth(); i ++) {
			int add = i + 1;
			ret += " ";
			ret += add;
			ret += " ";
		}
		for(int i = 0 ; i < addOns.length; i ++) {
			ret += "\n";
			ret += (char) (i+65) + " ";
			for(int j = 0; j < addOns[0].length; j++) {
				ret += addOns[i][j];
			}
		}
		return ret;
	}
}