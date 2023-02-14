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
	
	private static int tileSize = 30;
	private static int columns = winX / tileSize;
	private static int rows = winY / tileSize;
	private static int numTiles = columns * rows;;
	
	public Tile(int x, int y, Color c) {
		super(x, y, 0, 0); //setting size to 0 then setting size to size right after
		this.setSize(tileSize, tileSize); //using object to call setSize() method to use the size variables that aren't static
		col = c;
	}
	
	public static Tile[] makeBoard() {
		int count = 0;
		int tileX = 0, tileY = 0;
		Tile[] tileArray = new Tile[numTiles];
		
		for (int i = 0; i < tileArray.length; i++) {
			tileArray[i] = new Tile(tileX, tileY, Colors.pastelTeal9);
			tileX += tileSize;
			count++;
			
			if (count % columns == 0) {
				tileX = 0;
				tileY += tileSize;
			}
		}
		return tileArray;
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

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}
}
