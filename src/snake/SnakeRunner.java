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
import utilities.SoundDriver;

public class SnakeRunner extends GDV5 {
	//create variable for max window sizes
	private static int winX = GDV5.getMaxWindowX();
	private static int winY = GDV5.getMaxWindowY();
	
	private int count = 0;
	
	private static int columns = winX / Tile.getTileSize();
	private static int rows = winY / Tile.getTileSize();
	private static int numTiles = columns * rows;
	private int colArray = 0;
	
	private Tile[] board;
	private static Snake s;
	private static Tile head;
	private static Tile chest;
	private Yummy f = new Yummy();
	
	private SoundDriver sound;
	private String[] fileNames = new String[1];
	
	//gamestates
	private static int gameState = 0;
	private static boolean gameStart = false;
//	private static boolean gameStart = true;
	private static boolean startPage = true;
	
	public SnakeRunner() {
		super();
		
		fileNames[0] = "snakeEatNoise.wav";
		sound = new SoundDriver(fileNames, this);
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
			updateSaveLines();
			f.spawnFood();
			snakeEat(chest, s, f);
		}
		else if (gameState == 0) resetSnake();
	}

	@Override
	public void draw(Graphics2D win) {
		if (gameState == 0) {
			SnakePages.home(win);
			SnakePages.setScore(0);
		}
		if (gameState == 4) {
			SnakePages.pausedGame(win);
		}
		if (gameState == 5) {
			SnakePages.customize(win);
		}
		if (gameStart) {
			drawBoard(win);
			win.setColor(Colors.pastelTeal1);
			win.fillRect(0, 0, winX, 30);
			win.setColor(Colors.pastelTan3);
			win.fillRect((int) f.getX(), (int) f.getY(), (int) f.getWidth(), (int) f.getHeight());
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
	
	public void snakeEat(Tile c, Snake snake, Yummy food) {
		if (c.intersects(food)) {
			food.setLocation((int) (Math.random() * SnakeRunner.getColumns()) * Tile.getTileSize(), (int) (Math.random() * (SnakeRunner.getRows() - 1)) * Tile.getTileSize() + Tile.getTileSize());
			s.addBody(1);
			sound.play(0);
			SnakePages.addScore(1);
		}
	}
	
	public void resetSnake() {
		Tile.setSnakeAlive(true);
		makeBoard();
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
			s = new Snake(4);
			head = s.body.get(0);
			chest = s.body.get(1);
			
			gameState = 1;
			gameStart = true;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_2] && gameState == 0) {
			s = new Snake(4);
			head = s.body.get(0);
			chest = s.body.get(1);
			
			gameState = 2;
			gameStart = true;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_3] && gameState == 0) {
			s = new Snake(4);
			head = s.body.get(0);
			chest = s.body.get(1);
			
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
	
	public void updateSaveLines() {
		if (gameState == 1) {
			if (count % 20 == 0) {
				head.updateDirection(board);
				s.updateBodyDirection(board);
				s.moveSnake();
				s.checkCollision();
			}
		}
		if (gameState == 2) {
			if (count % 15 == 0) {
				head.updateDirection(board);
				s.updateBodyDirection(board);
				s.moveSnake();
				s.checkCollision();
			}
		}
		if (gameState == 3) {
			if (count % 10 == 0) {
				head.updateDirection(board);
				s.updateBodyDirection(board);
				s.moveSnake();
				s.checkCollision();
			}
		}
	}

	
	//getters and setters
	public static int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public static int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public static int getNumTiles() {
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

	public static int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public static boolean isGameStart() {
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
