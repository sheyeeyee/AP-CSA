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
	
	private int count = 0;
	
	private int columns = winX / Tile.getTileSize();
	private int rows = winY / Tile.getTileSize();
	private int numTiles = columns * rows;
	private int colArray = 0, colShade;
	
	private static Tile[] board;
	private Tile head;
	private Snake s = new Snake(4);
	
	//gamestates
	private int gameState = 0;
	private boolean gameStart = false;
	private boolean startPage = true;
	
	public SnakeRunner() {
		super();
		head = s.body.get(0);
		makeBoard();
	}
	
	public static void main(String[] args) {
		SnakeRunner runner = new SnakeRunner();
		runner.makeBoard();
		runner.start();
	}

	@Override
	public void update() {
		count++;
		head.setHeadDirection();
		if (count % 20 == 0) {
			s.moveSnake();
			head.updateDirection(board);
		}
	}

	@Override
	public void draw(Graphics2D win) {
		drawBoard(win);
		s.draw(win);
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
//			board[i] = new Tile(tileX, tileY, Colors.pastelTeal9);
			tileX += Tile.getTileSize();
			count++;
//			colShade++;
			
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

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}

	public boolean isStartPage() {
		return startPage;
	}

	public void setStartPage(boolean startPage) {
		this.startPage = startPage;
	}
}
