package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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

import breakout.Brick;
import breakout.Colors;
import pong.Score;
import utilities.GDV5;

public class SnakeRunner extends GDV5 {
	//create variable for max window sizes
	private static int winX = GDV5.getMaxWindowX();
	private static int winY = GDV5.getMaxWindowY();
	
	private int columns = winX / Tile.getTileSize();
	private int rows = winY / Tile.getTileSize();
	private int numTiles = columns * rows;
	private int colArray = 0, colShade;
	
	public static Tile[] board;
	
	public SnakeRunner() {
		super();
	}
	
	public static void main(String[] args) {
		SnakeRunner runner = new SnakeRunner();
		runner.makeBoard();
		runner.start();
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D win) {
		drawBoard(win);
	}
	
	public void drawBoard(Graphics2D pb) {
		for (Tile t : board) {
			t.draw(pb);
		}
	}
	
	//CHALLENGE 1
	void makeBoard() {
		int tileX = 0, tileY = 0, count = 0, colShade = 0;
		
		board = new Tile[numTiles];
		
		for (int i = 0; i < board.length; i++) {
			board[i] = new Tile(tileX, tileY, Colors.pastelTeals[colShade]);
			tileX += Tile.getTileSize();
			count++;
			
			if (count % columns == 0) {
				tileX = 0;
				tileY += Tile.getTileSize();
				colShade++;
			}
		}
	}

	
	//getters and setters
	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getNumTiles() {
		return numTiles;
	}

	public void setNumTiles(int numTiles) {
		this.numTiles = numTiles;
	}

	public int getColArray() {
		return colArray;
	}

	public void setColArray(int colArray) {
		this.colArray = colArray;
	}	
}
