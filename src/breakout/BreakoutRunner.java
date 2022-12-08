package breakout;

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

import pong.Score;
import utilities.GDV5;

public class BreakoutRunner extends GDV5 {
	//create variable for max window sizes
	private static int winX = getMaxWindowX();
	private static int winY = getMaxWindowY();
	
	//set paddle parameters
	private static int pWidth = 200;
	private static int pHeight = 10;
	private static int pOffset = 20;
	private static int pX = (winX / 2 - pWidth / 2);
	private static int pY = winY - pHeight - pOffset;
	
	//ball collision with bricks
	private static int mvmtMax = 4;
	private static int mvmtMin = 1;
	private static int mvmt = mvmtMax - mvmtMin;
	private static int minV = 2;
	private static int maxV = 7;
	
	//creating objects
	Brick[] brickObjects;
	Particles[] particleObjects;
	BreakoutBall ball = new BreakoutBall(20);
	BreakoutPaddle p = new BreakoutPaddle(pX, pY, pWidth, pHeight);
	Pages scoreboard = new Pages();
	
	//customizing colors
	private static String brickColor = "";
	private static String ballColor = "";
	private static String paddleColor = "";
	
	//gamestates
	private static int gameState = 0;
	private static boolean gameStart = false;
	
	public BreakoutRunner() {
		super();
		brickObjects = Brick.makeBricks(); //bricks array equals the makeBricks() method
//		particleObjects = Particles.makeParticles();
	}
	
	public static void main(String[] args) {
		BreakoutRunner runner = new BreakoutRunner();
		runner.start();
	}

	//bc of this, no loops needed since these are being called continuously
	@Override
	public void update() { //60 fps, driver called 60 times per second
		ball.move(p, brickObjects);
		ballHitBricks(ball, brickObjects);
		Brick.setBricks();
		ball.resetBall();
		p.paddleMove();
		gameState();
	}

	@Override
	public void draw(Graphics2D win) { //at the processor speed (~3000 fps, called 3000 times per second)
		if (gameState == 0) {
			Pages.home(win);
			Pages.setScore(0);
			BreakoutBall.setLives(3);
		}
		if (gameState == 4) {
			Pages.pausedGame(win);
		}
		if (gameState == 5) {
			Pages.customize(win);
		}
		
		if (gameStart) {
			win.setColor(Color.black);
			win.fillRect(0, 0, winX, winY);
			
			//bricks (syntactic sugar)
			for (Brick b:brickObjects) {
				b.draw(win);
			}
			
			//ball
			if (ballColor == "O" || ballColor == "") {
				win.setColor(Colors.pastelTan);
			}
			if (ballColor == "T") {
				win.setColor(Colors.pastelTeal);
			}
			if (ballColor == "Y") {
				win.setColor(Colors.pastelBlue);
			}
			if (ballColor == "U") {
				win.setColor(Colors.pastelLightGreen);
			}
			win.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());
			
			//paddle
			if (paddleColor == "P" || paddleColor == "") {
				win.setColor(Colors.pastelTan2);
			}
			if (paddleColor == "G") {
				win.setColor(Colors.pastelTeal);
			}
			if (paddleColor == "H") {
				win.setColor(Colors.pastelBlue);
			}
			if (paddleColor == "J") {
				win.setColor(Colors.pastelLightGreen);
			}
			win.fillRect((int) p.getX(), (int) p.getY(), (int) p.getWidth(), (int) p.getHeight());
			
			Pages.scoreboard(win);
			Pages.youWin(win);
		}
	}
	
	//getters
	public static int getWinX() {
		return winX;
	}
	public static int getWinY() {
		return winY;
	}
	public static int getPWidth() {
		return pWidth;
	}
	public static int getPHeight() {
		return pHeight;
	}
	public static int getPX() {
		return pX;
	}
	public static int getPY() {
		return pY;
	}
	public static String getBallColor() {
		return ballColor;
	}
	public static String getPaddleColor() {
		return paddleColor;
	}
	public static int getGameState() {
		return gameState;
	}
	public static boolean getGameStart() {
		return gameStart;
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
		else if (GDV5.KeysPressed[KeyEvent.VK_ENTER] && Pages.getScore() == Brick.getNumBricks()) {
			gameState = 0; //splash page
			gameStart = false;
		}else if (GDV5.KeysPressed[KeyEvent.VK_ENTER] && BreakoutBall.getLives() == 0) {
			gameState = 0; //splash page
			gameStart = false;
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_Q] && gameState == 4) {
			gameState = 0; //splash page
			gameStart = false;
		}
		
		if (GDV5.KeysPressed[KeyEvent.VK_T] && gameState == 5) {
			ballColor = "T";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_Y] && gameState == 5) {
			ballColor = "Y";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_U] && gameState == 5) {
			ballColor = "U";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_G] && gameState == 5) {
			paddleColor = "G";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_H] && gameState == 5) {
			paddleColor = "H";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_J] && gameState == 5) {
			paddleColor = "J";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_O] && gameState == 5) {
			ballColor = "O";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_P] && gameState == 5) {
			paddleColor = "P";
		}
	}
	
	//CHALLENGE #
	public void ballHitBricks(BreakoutBall ball, Brick[] brick) {
		if (gameStart) {
			for (Brick b:brickObjects) {
				if (ball.intersects(b)) {
					//ball intersects top
					if (collisionDirection(b, ball, ball.vX, ball.vY) == 1) {
						if (minV < ball.vX && ball.vX < maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vX && ball.vX < -minV) ball.vX = ball.vX - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vX < -maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vX = ball.vX - (int) (Math.random() + mvmtMin);
						ball.vY = -Math.abs(ball.vY);
						System.out.println("T vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//ball intersects bottom
					if (collisionDirection(b, ball, ball.vX, ball.vY) == 3) {
						if (minV < ball.vX && ball.vX < maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vX && ball.vX < -minV) ball.vX = ball.vX - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vX < -maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vX = ball.vX - (int) (Math.random() + mvmtMin);
						ball.vY = Math.abs(ball.vY);
						System.out.println("B vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//ball intersects left
					if (collisionDirection(b, ball, ball.vX, ball.vY) == 2) {
						ball.vX = -Math.abs(ball.vX);
						if (minV < ball.vY && ball.vY < maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vY && ball.vY < -minV) ball.vY = ball.vY - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vY < -maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vY = ball.vY - (int) (Math.random() + mvmtMin);
						System.out.println("L vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//ball intersects right
					if (collisionDirection(b, ball, ball.vX, ball.vY) == 0) {
						ball.vX = Math.abs(ball.vX);
						if (minV < ball.vY && ball.vY < maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vY && ball.vY < -minV) ball.vY = ball.vY - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vY < -maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vY = ball.vY - (int) (Math.random() + mvmtMin);
						System.out.println("R vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//"remove" brick (move the brick to a part of the window that isn't visible)
					b.setLocation(-100, -100);
					
					//score
					Pages.addScore(1);
				}
			}
		}
	}
}
