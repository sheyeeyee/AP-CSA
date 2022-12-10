package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import utilities.GDV5;
import breakout.BreakoutRunner;

public class Brick extends Rectangle {	
	//colors
	private Color col;
	
	//brick visibility
	private boolean brickVis = true;
	
	//array of colors for bricks
	private static Color[] colors = {Colors.pastelTeal0, Colors.pastelTeal, Colors.pastelTeal1, Colors.pastelTeal2, Colors.pastelTeal3, 
			Colors.pastelTeal4, Colors.pastelTeal5, Colors.pastelTeal6, Colors.pastelTeal7, 
			Colors.pastelTeal8, Colors.pastelTeal9, Colors.pastelTeal10};

	//position of top row
	private static int bX = 50;
	private static int bY = 50;
	
	//# of columns and rows
	private static int columns = 10;
	private static int rows = 12;
	private static int numBricks = columns * rows;
	
	//space btwn bricks
	private static int bPadding = 5;
	
	//brick width and height
	private static int bWidth = (BreakoutRunner.getWinX() - (2 * bX) - (columns - 1) * bPadding) / (columns);
	private static int bHeight = 30;
	
	
	//brick constructor
	public Brick(int x, int y, Color c) {
		super(x, y, bWidth, bHeight);
		col = c;
	}
	
	//getters
	public static int getBX() {
		return bX;
	}
	public static int getBY() {
		return bY;
	}
	public static int getBWidth() {
		return bWidth;
	}
	public static int getBHeight() {
		return bHeight;
	}
	public Color getColor() {
		return col;
	}
	public static int getNumBricks() {
		return numBricks;
	}
	public boolean getBrickVis() {
		return brickVis;
	}
	public void setBrickVis(boolean newBrickVis) {
		brickVis = newBrickVis;
	}
	
	//for different levels
	public static void setBricks() {
//		if (GDV5.KeysPressed[KeyEvent.VK_1]) {
//			rows = 6;
//			System.out.println("easdf");
//		}
//		if (GDV5.KeysPressed[KeyEvent.VK_2]) {
//			rows = 9;
//		}
//		if (GDV5.KeysPressed[KeyEvent.VK_3]) {
//			rows = 12;
//		}
	}
	
	//method to create bricks
	public static Brick[] makeBricks() { //makeBricks(int columns, int rows)
		int count = 0;
		int count2 = 0;
		
		bX = 50;
		bY = 50;
		
		//create brick array
		Brick[] brickArray = new Brick[numBricks];
		
		for (int i = 0; i < brickArray.length; i++) {
			brickArray[i] = new Brick(bX, bY, colors[count2]);
			bX += bWidth + bPadding;
			count++;
			
			if (count % columns == 0) {
				bX = 50;
				bY += bHeight + bPadding;
				count2++;
			}
		}
		return brickArray;
	}
	
	//draw bricks method
	public void draw(Graphics2D pb) {
		if (brickVis) {
			pb.setColor(col);
			pb.fill(this);
		}
	}
}
