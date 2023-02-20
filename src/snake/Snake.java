package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;

import pong.Score;
import breakout.BreakoutRunner;
import breakout.Brick;
import breakout.Colors;
import utilities.GDV5;

public class Snake extends Rectangle {
	//create variable for max window sizes
	private static int winX = GDV5.getMaxWindowX();
	private static int winY = GDV5.getMaxWindowY();
	
	private static int sVx, sVy;
	
	ArrayList<Tile> body;
	
//	private static int sWidth = Tile.getTileSize();
//	private static int sHeight;
	
	public Snake(int size) {
		body = new ArrayList<Tile>();
		body.add(new Tile(winX / 2 - (2 * Tile.getTileSize()), winY / 2, Colors.pastelTan1));
		body.get(0).setDirection(1);
		addBody(size - 1, body.get(0).getDirection()); //subtract 1 because we already have the head on it so we just need the rest
	}
	
	public void addBody(int size) {
		int colShade = 3;
		int x = (int) body.get(0).getX(); //getting x position of head
		int y = (int) body.get(0).getY(); //getting y position of head
		
		for (int i = 0; i < size; i++) {
			body.add(new Tile(x + body.get(0).getDimension(), y, Colors.pastelTans[colShade]));
			x += body.get(0).getDimension();
			colShade++;
		}
	}
	
	public void addBody(int size, int direction) {
		int colShade = 3;
		int x = (int) body.get(0).getX(); //getting x position of head
		int y = (int) body.get(0).getY(); //getting y position of head
		
		for (int i = 0; i < size; i++) {
			body.add(new Tile(x + body.get(0).getDimension(), y, direction, Colors.pastelTans[colShade]));
			x += body.get(0).getDimension();
			colShade++;
		}
	}
	
	public void moveSnake() {
		for (Tile t : body) {
			t.move();
		}
	}
	
	public void draw(Graphics2D pb) {
		for (Tile t : body) {
			t.fill(pb);
		}
	}
	
//	public Snake(int sStartX, int sStartY, int sWidth, int sHeight) {
//		super(sStartX, sStartY, sWidth, sHeight);
//	}
//	
//	public void snakeMove() {
//		if (GDV5.KeysPressed[KeyEvent.VK_W]) {
//			sVx = 0;
//			sVy = -20;
//			this.translate(sVx, sVy);
//		}
//		if (GDV5.KeysPressed[KeyEvent.VK_A]) {
//			sVx = -20;
//			sVy = 0;
//			this.translate(sVx, sVy);
//		}
//		if (GDV5.KeysPressed[KeyEvent.VK_S]) {
//			sVx = 0;
//			sVy = 20;
//			this.translate(sVx, sVy);
//		}
//		if (GDV5.KeysPressed[KeyEvent.VK_D]) {
//			sVx = 20;
//			sVy = 0;
//			this.translate(sVx, sVy);
//		}
//	}
	
	public void resetSnakePosition() {
		this.translate(0, 0);
//		this.setLocation(winX / 2 - BreakoutRunner.getPWidth() / 2, BreakoutRunner.getPY());
	}
}
