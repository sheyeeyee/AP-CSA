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

import breakout.BreakoutBall;
import breakout.Brick;
import breakout.Colors;
import breakout.Pages;
import breakout.PowerUp;
import pong.Score;
import utilities.GDV5;

public class SnakeRunner extends GDV5 {
	//create variable for max window sizes
	private static int winX = GDV5.getMaxWindowX();
	private static int winY = GDV5.getMaxWindowY();
	
	private int count = 0;
	
	private static int columns = winX / Tile.getTileSize();
	private int rows = winY / Tile.getTileSize();
	private int numTiles = columns * rows;
	private int colArray = 0;
	
	private static Tile[] board;
	private Tile head;
	private Snake s = new Snake(4);
	
	//gamestates
	private static int gameState = 0;
	private static boolean gameStart = false;
//	private static boolean gameStart = true;
	private static boolean startPage = true;
	
	public SnakeRunner() {
		super();
		head = s.body.get(0);
		makeBoard();
	}
	
	public static void main(String[] args) {
		SnakeRunner runner = new SnakeRunner();
		runner.start();
	}

	@Override
	public void update() {
		gameState();
		if (gameStart) {
			count++;
			head.setHeadDirection();
			if (count % 20 == 0) {
				head.updateDirection(board);
				s.updateBodyDirection(board);
				s.moveSnake();
			}
		}
		else if (gameState == 0) s.resetSnakePosition();
	}

	@Override
	public void draw(Graphics2D win) {
		if (gameState == 0) {
			SnakePages.home(win);
			SnakePages.setScore(0);
			BreakoutBall.setLives(5);
		}
		if (gameState == 4) {
			SnakePages.pausedGame(win);
		}
		if (gameState == 5) {
			SnakePages.customize(win);
		}
		if (gameStart) {
			GDV5.setMaxWindowX(600);
			GDV5.setMaxWindowY(600);
			drawBoard(win);
			s.draw(win);
			SnakePages.scoreboard(win);
			SnakePages.youWinLose(win);
		}
	}
	
	public void drawBoard(Graphics2D pb) {
		for (Tile t : board) {
			t.draw(pb);
		}
	}
	
	//CHALLENGE 1
	public void makeBoard() {
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
	
	public static void gameState() {
		//0: splash page
		//1: easy mode
		//2: medium mode
		//3: hard mode
		//4: pause page
		//5: customization page
				
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] && gameState == 0) {
			gameState = 5; //customization
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_Q] && gameState == 5) {
			gameState = 0;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_1] && gameState == 0) {
			gameState = 1;
			gameStart = true;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_2] && gameState == 0) {
			gameState = 2;
			gameStart = true;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_3] && gameState == 0) {
			gameState = 3;
			gameStart = true;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] && gameStart) {
			gameState = 4; //pause
			gameStart = false;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_SPACE] && !gameStart) {
			gameState = 1; //resume game
			gameStart = true;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 0; //splash page
			gameStart = false;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 0; //splash page
			gameStart = false;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_Q] && gameState == 4) {
			gameState = 0; //splash page
			gameStart = false;
		}
		
		if (gameState == 0) {
			if (startPage == true) startPage = false;
		}
	}

	
	//getters and setters
	public static int getColumns() {
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

	public static void setGameStart(boolean newGameStart) {
		gameStart = newGameStart;
	}

	public boolean isStartPage() {
		return startPage;
	}

	public void setStartPage(boolean startPage) {
		this.startPage = startPage;
	}
}
