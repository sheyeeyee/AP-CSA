package snakeGame;

import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SnakeGame {
	//declare game size
	int gameSizeX = 20;
	int gameSizeY = 20;
	
	//declare game parameters
	int snakeLength = 3;
	int snakeX = 7;
	int snakeY = 7;
	int[] foodLocation;
	int direction = 0;
	int score = 0;
	int speed = 150;
	
	//declare game components
	JFrame gameFrame;
	JPanel gamePanel;
	Timer gameTimer;
	
	//initialize game
	public void initGame() {
		//create game frame
		gameFrame = new JFrame("Snake Game");
		gameFrame.setSize(400, 400);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create game panel
		gamePanel = new GamePanel();
		gamePanel.setFocusable(true);
		gamePanel.setBackground(Color.BLACK);
		gamePanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					direction = 0;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					direction = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					direction = 2;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					direction = 3;
				}
			}
		});
		gameFrame.add(gamePanel);
		
		//start game timer
		gameTimer = new Timer(speed, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateGame();
			}
		});
		gameTimer.start();
		
		//start game
		gameFrame.setVisible(true);
		resetGame();
	}
	
	//update game
	public void updateGame() {
		//update snake position
		if(direction == 0) {
			snakeY--;
		}
		if(direction == 1) {
			snakeX++;
		}
		if(direction == 2) {
			snakeY++;
		}
		if(direction == 3) {
			snakeX--;
		}
		
		//check if snake has hit wall
		if(snakeX < 0 || snakeY < 0 || snakeX > gameSizeX-1 || snakeY > gameSizeY-1) {
			gameOver();
			return;
		}
		
		//check if snake has eaten food
		if(snakeX == foodLocation[0] && snakeY == foodLocation[1]) {
			score++;
			snakeLength++;
			if(speed > 50) {
				speed -= 10;
				gameTimer.setDelay(speed);
			}
			generateFood();
		}
		
		//repaint game panel
		gamePanel.repaint();
	}
	
	//generate food
	public void generateFood() {
		Random random = new Random();
		foodLocation = new int[]{random.nextInt(gameSizeX), random.nextInt(gameSizeY)};
	}
	
	//reset game
	public void resetGame() {
		score = 0;
		speed = 150;
		snakeLength = 3;
		snakeX = 7;
		snakeY = 7;
		direction = 0;
		gameTimer.setDelay(speed);
		generateFood();
	}
	
	//game over
	public void gameOver() {
		//stop timer
		gameTimer.stop();
		
		//display game over screen
		String message = String.format("Game Over!\nYour Score: %d", score);
		int reply = JOptionPane.showConfirmDialog(gameFrame, message, "Game Over", JOptionPane.YES_NO_OPTION);
		if(reply == JOptionPane.YES_OPTION) {
			resetGame();
			gameTimer.start();
		} else {
			System.exit(0);
		}
	}
	
	//Game Panel
	class GamePanel extends JPanel {
		//draw snake
		public void drawSnake(Graphics g) {
			int blockSize = getWidth() / gameSizeX;
			for(int i=0; i<snakeLength; i++) {
				g.setColor(Color.GREEN);
				g.fillRect(snakeX * blockSize, snakeY * blockSize, blockSize, blockSize);
			}
		}
		
		//draw food
		public void drawFood(Graphics g) {
			int blockSize = getWidth() / gameSizeX;
			g.setColor(Color.YELLOW);
			g.fillRect(foodLocation[0] * blockSize, foodLocation[1] * blockSize, blockSize, blockSize);
		}
		
		//override paintComponent
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawSnake(g);
			drawFood(g);
		}
	}
	
	public static void main(String[] args) {
		SnakeGame game = new SnakeGame();
		game.initGame();
	}
}