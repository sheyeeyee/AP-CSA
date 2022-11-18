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

public class Brick extends Rectangle {
	private Color col;
	private static Color pastelBlue = new Color(180, 224, 229);
	private static Color pastelTeal = new Color(72, 218, 188);
	private static Color pastelLightGreen = new Color(171, 232, 219);
	private static Color pastelTan = new Color(229, 209, 180);
	private static Color pastelTan2 = new Color(186, 170, 146);

	private static int bX = 50;
	private static int bY = 50;
	
	private static int columns = 10;
	private static int rows = 5;
	
	private static int bPadding = 15;
	
	private static int bWidth = (GDV5.getMaxWindowX() - 2 * bX - (columns - 1) * 15) / (columns);
	private static int bHeight = 30;
	
	public Brick(int x, int y, Color c) {
		super(x, y, bWidth, bHeight);
		col = c;
	}
	
	public static Brick[] makeBricks() {
		int count = 0;
		
		Brick[] brick = new Brick[columns * rows];
//		Brick[] brickColumn = new Brick[columns];
//		Brick[] brickRow = new Brick[rows];
		
//		for (int i = 0; i < columns; i++) {
//			brick[i] = new Brick(x, y, Color.blue);
//			x += brick[0].width + padding;
//		}
		
		for (int i = 0; i < brick.length; i++) {
			brick[i] = new Brick(bX, bY, pastelBlue);
			bX += brick[0].width + bPadding;
			count++;
			
			if (count % columns == 0) {
				bX = 50;
				bY += brick[0].height + bPadding;
			}
		}
		return brick;
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(col);
		pb.fill(this);
	}
}
