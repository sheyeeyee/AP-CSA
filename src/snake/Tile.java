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
	private Color col;
	private int colorArray = 0;
	private int shade;
	
	private static int tileSize = 30;
	
	public Tile(int x, int y, Color c) {
		super(x, y, 0, 0); //setting size to 0 then setting size to size right after
		this.setSize(tileSize, tileSize); //using object to call setSize() method to use the size variables that aren't static
		col = c;
//		setShade(initShade);
	}
	
	public void draw(Graphics2D pb) {
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
}
