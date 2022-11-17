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
	
	public Brick(int x, int y, Color c) {
		super(x, y, GDV5.getMaxWindowX() / 12, 25);
		col = c;
	}
	
	public static Brick[] makeBricks() {
		int x = 50;
		int y = 50;
		int padding = 10;
		int columns = 10;
		int rows = 10;
		
		Brick[] brick = new Brick[columns];
//		Brick[] brickColumn = new Brick[columns];
//		Brick[] brickRow = new Brick[rows];
		
		for (int i = 0; i < columns; i++) {
			brick[i] = new Brick(x, y, Color.blue);
			x += brick[0].width + padding;
		}
		
//		for (int i = 0; i < columns; i++) {
//			brick[i] = new Brick(x, y, Color.blue);
//			x += brick[0].width + padding;
//			
//			for (int n = 0; n < rows; n++) {
//				brick[n] = new Brick(x, y, Color.blue);
//				y += brick[0].width + padding;
//			}
//		}
		return brick;
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(col);
		pb.fill(this);
	}
}
