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
	private static Color[] colors = {Colors.pastelTeal1, Colors.pastelTeal2, Colors.pastelTeal3, 
			Colors.pastelTeal4, Colors.pastelTeal5, Colors.pastelTeal6, Colors.pastelTeal7, 
			Colors.pastelTeal8, Colors.pastelTeal9};

	//position of top row
	private static int bX = 50;
	private static int bY = 50;
	
	//# of columns and rows
	private static int columns = 10;
	private static int rows = 8;
	
	//space btwn bricks
	private static int bPadding = 5;
	
	//brick width and height
	private static int bWidth = (BreakoutRunner.winX - (2 * bX) - (columns - 1) * bPadding) / (columns);
	private static int bHeight = 30;
	
	
	//brick constructor
	public Brick(int x, int y, Color c) {
		super(x, y, bWidth, bHeight);
		col = c;
	}
	
	//method to create bricks
	public static Brick[] makeBricks() { //makeBricks(int columns, int rows)
		int count = 0;
		int count2 = 0;
		
		//create brick array
		Brick[] brickArray = new Brick[columns * rows];
//		Brick[] brickColumn = new Brick[columns];
//		Brick[] brickRow = new Brick[rows];
		
//		for (int i = 0; i < columns; i++) {
//			brick[i] = new Brick(x, y, Color.blue);
//			x += brick[0].width + padding;
//		}
		
		for (int i = 0; i < brickArray.length; i++) {
			brickArray[i] = new Brick(bX, bY, colors[count2]);
			bX += brickArray[0].width + bPadding;
			count++;
			
			if (count % columns == 0) {
				bX = 50;
				bY += brickArray[0].height + bPadding;
				count2++;
			}
		}
		return brickArray;
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(col);
		pb.fill(this);
	}
}
