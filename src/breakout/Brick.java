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
	
	//array of colors for bricks
	private static Color[] colors = {Colors.pastelTeal0, Colors.pastelTeal, Colors.pastelTeal1, Colors.pastelTeal2, Colors.pastelTeal3, 
			Colors.pastelTeal4, Colors.pastelTeal5, Colors.pastelTeal6, Colors.pastelTeal7, 
			Colors.pastelTeal8, Colors.pastelTeal9, Colors.pastelTeal10};

	//position of top row
	private static int bX = 50;
	private static int bY = 50;
	
	//# of columns and rows
	private static int columns = 10;
//	private static int rows;
	private static int numBricks;
	
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
	
	//method to create bricks
	public static Brick[] makeBricks(int level) { //makeBricks(int columns, int rows)
		int count = 0;
		int count2 = 0;
		
		if (level == 1) numBricks = 60;
		if (level == 2) numBricks = 90;
		if (level == 3) numBricks = 120;
		
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
		pb.setColor(col);
		pb.fill(this);
	}
}
