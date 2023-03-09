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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;

import pong.Score;
import breakout.Brick;
import breakout.Colors;
import utilities.GDV5;

public class Tile extends Rectangle {
	//create variable for max window sizes
	private static int winX = GDV5.getMaxWindowX();
	private static int winY = GDV5.getMaxWindowY();
	
	private int direction;
	private static boolean snakeAlive = true;
	
	private Color col;
	private int colorArray = 0;
	private int shade;
	
	private static int tileSize = 30;
	
	public Tile(int x, int y, Color c) {
		super(x, y, 0, 0); //setting size to 0 then setting size to size right after
		this.setSize(tileSize, tileSize); //using object to call setSize() method to use the size variables that aren't static
		col = c;
		this.setDirection(1);
	}
	
	public Tile(int x, int y, int direction, Color c) {
		super(x, y, 0, 0); //setting size to 0 then setting size to size right after
		this.setSize(tileSize, tileSize); //using object to call setSize() method to use the size variables that aren't static
		col = c;
		this.direction = direction;
	}
	
	public void updateDirection(Tile[] board) {
		//"this" refers to the snake's head, which calls this method and sets the direction for the tiles it's on
		for (int i = 0; i < board.length; i++) { //iterate thru board
			//the head is on that specific tile
			if (this.getX() == board[i].getX() && this.getY() == board[i].getY()) {
				board[i].setDirection(this.getDirection());
//				System.out.println("HEAD: " + board[i].getDirection());
			}
		}
	}
	
	public void move() {
		if (getSnakeAlive()) {
			if (direction == 1) this.translate(-tileSize, 0); //left
			else if (direction == 2) this.translate(0, -tileSize); //up
			else if (direction == 3) this.translate(tileSize, 0); //right
			else if (direction == 4) this.translate(0, tileSize); //down
			if (this.getX() < 0 || this.getY() < 30 || this.getX() > winX || this.getY() > winY) setSnakeAlive(false);
		}
		if (!getSnakeAlive()) this.translate(0, 0);
	}

	public void setHeadDirection() {
		if ((GDV5.KeysPressed[KeyEvent.VK_A] || GDV5.KeysPressed[KeyEvent.VK_LEFT]) && direction != 3) {
			direction = 1;
		}
		else if ((GDV5.KeysPressed[KeyEvent.VK_W] || GDV5.KeysPressed[KeyEvent.VK_UP]) && direction != 4) {
			direction = 2;
		}
		else if ((GDV5.KeysPressed[KeyEvent.VK_D] || GDV5.KeysPressed[KeyEvent.VK_RIGHT]) && direction != 1) {
			direction = 3;
		}
		else if ((GDV5.KeysPressed[KeyEvent.VK_S] || GDV5.KeysPressed[KeyEvent.VK_DOWN]) && direction != 2) {
			direction = 4;
		}
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(col);
		pb.draw(this);
	}
	public void fill(Graphics2D pb) {
		pb.setColor(col);
		pb.fill(this);
	}

	//getters and setters
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}
	
	public int getColorArray() {
		return colorArray;
	}
	
	public void setColorArray(int colorArray) {
		this.colorArray = colorArray;
	}

	public static int getTileSize() {
		return tileSize;
	}

	public static void setTileSize(int newTileSize) {
		tileSize = newTileSize;
	}

	public int getShade() {
		return shade;
	}

	public void setShade(int shade) {
		this.shade = shade;
	}

	public int getDimension() {
		return Tile.getTileSize();
	}
	
	public static boolean getSnakeAlive() {
		return snakeAlive;
	}
	
	public static void setSnakeAlive(boolean isSnakeAlive) {
		snakeAlive = isSnakeAlive;
	}
}