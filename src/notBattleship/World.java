package notBattleship;

public class World {
	private Boat[][] map;
	
	public static int NORTH = 0;
	public static int NORHTEAST = 1;
	public static int EAST = 2;
	public static int SOUTHEAST = 3;
	public static int SOUTH = 4;
	public static int SOUTHWEST = 5;
	public static int WEST = 6;
	public static int NORTHWEST = 7;
	
//	private int view;
	
	public World(int mWidth, int mHeight) {
		if (mWidth < 4) mWidth = 4;
		if (mHeight < 4) mHeight = 4;
		if (mWidth > 10) mWidth = 10;
		if (mHeight > 10) mHeight = 10;
		
		map = new Boat[mWidth][mHeight];
		for (Boat[] row: map) {
			for (Boat b: row) {
				b = null;
			}
		}
	}
	
	public int getWidth() {
		return this.map[0].length;
	}
	
	public int getHeight() {
		return this.map.length;
	}
	
	public Boat getOccupant(Coordinates c) {
		int x = c.getX();
		int y = c.getY();
		return map[y][x];
	}
	
	public boolean isLocationOccupied(Coordinates c) {
		int x = c.getX();
		int y = c.getY();
		
		return map[y][x] != null;
	}
	
	public boolean isLocationValid(Coordinates c) {
		int x = c.getX();
		int y = c.getY();
		
		if (x < 0 || x >= this.getWidth()) return false;
		if (y < 0 || y >= this.getHeight()) return false;
		return true;
	}
	
	public boolean setOccupant(Boat b, Coordinates c) {
		int x = c.getX();
		int y = c.getY();
		
		if (!isLocationOccupied(c)) {
			map[y][x] = b;
			return true;
		}
		return false;
	}
	
	public Coordinates getAdjacentLocation(Coordinates c, int direction) {
		int x = c.getX();
		int y = c.getY();
		
		if (direction == 0) { //north
			Coordinates adj = new Coordinates(x, y-1);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 1) { //northeast
			Coordinates adj = new Coordinates(x+1, y-1);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 2) { //east
			Coordinates adj = new Coordinates(x+1, y);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 3) { //southeast
			Coordinates adj = new Coordinates(x+1, y+1);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 4) { //south
			Coordinates adj = new Coordinates(x, y+1);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 5) { //southwest
			Coordinates adj = new Coordinates(x-1, y+1);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 6) { //west
			Coordinates adj = new Coordinates(x-1, y);
			if (isLocationValid(adj)) return adj;
		}
		if (direction == 7) { //northwest
			Coordinates adj = new Coordinates(x-1, y-1);
			if (isLocationValid(adj)) return adj;
		}
		return null;
	}
	
	public String drawTeamMap(Boat[] boat, int view) {
		int rows = this.getHeight();
		int columns = this.getWidth();
		
		String start = "@ ";
		String[][] board = new String[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = "###";
			}
		}
		
		if (view != 1) {
			//boat dir, type, team
			
			for (Boat b: boat) {
				Coordinates c = b.getLocation();
				
				int vision = b.getVision();
				
				int x = c.getX();
				int y = c.getY();
				
				int startX = Math.max(0, x - vision);
				int startY = Math.max(0, x - vision);
				int visLimX = Math.min(columns - 1, x + vision);
				int visLimY = Math.min(rows - 1, y + vision);
				
				board[y][x] = b.getDirection() + b.toString();
				
				for (int i = startY; i <= visLimY; i++) {
					for (int j = startX; j <= visLimX; j++) {
						Coordinates check = new Coordinates(j, i);
						if (isLocationOccupied(check)) {
							if (map[i][j].getTeam() != b.getTeam()) {
								if (view == 2) {
									board[i][j] = "" + map[i][j].getDirection() + map[i][j].getID();
								}
								if (view == 3) {
									board[i][j] = "" + map[i][j].getHealth() + map[i][j].getID();
//									board[i][j] = "1  ";
								}
							}
						}
						//change all ### to ~~~ if in vision
						if (board[i][j].equals("###")) {
							board[i][j] = "~~~";
						}
					}
				}
			}
		}
		
		//number labels
		for (int i = 0; i < columns; i++) {
			int num = i + 1;
			start += " ";
			start += num;
			start += "  ";
		}
		//letter labels
		for (int i = 0; i < rows; i++) {
			start += "\n";
			start += (char)(65 + i);
			
			for (int j = 0; j < columns; j++) {
				start += " " + board[i][j];
			}
		}
		return start;
	}
}
