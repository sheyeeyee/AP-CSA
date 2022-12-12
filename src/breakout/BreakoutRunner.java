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
	
	//set ball parameter
	private static int ballSize = 20;
	
	//set paddle parameters
	private static int pWidth = 200;
	private static int pHeight = 10;
	private static int pOffset = 20;
	private static int pX = (winX / 2 - pWidth / 2);
	private static int pY = winY - pHeight - pOffset;
	
	//creating objects
	static Brick[] brickArray;
	static Particles[] particleArray = new Particles[Particles.getPartNum()];
	BreakoutBall ball = new BreakoutBall(ballSize);
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
		brickArray = Brick.makeBricks(); //bricks array equals the makeBricks() method
	}
	
	public static void main(String[] args) {
		BreakoutRunner runner = new BreakoutRunner();
		runner.start();
	}

	//bc of this, no loops needed since these are being called continuously
	@Override
	public void update() { //60 fps, driver called 60 times per second
		ball.move(p, brickArray);
		ballHitBricks(ball, brickArray, particleArray);
//		Brick.setBricks();
		ball.resetBall();
		p.paddleMove();
		gameState();
		Particles.moveParticles();
//		PowerUp.randomPowerUp(ball);
	}

	@Override
	public void draw(Graphics2D win) { //at the processor speed (~3000 fps, called 3000 times per second)
		if (gameState == 0) {
			Pages.home(win);
			Pages.setScore(0);
			BreakoutBall.setLives(5);
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
			for (Brick b:brickArray) {
				b.draw(win);
			}
			for (int i = 0; i < particleArray.length; i++) {
				if (particleArray[i] != null) {
					particleArray[i].draw(win);
				}
			}
			
			//brick
			if (brickColor == "I" || brickColor == "") {
				Brick.setColorArray(0);
				System.out.println(Brick.getColorArray());
			}
			if (brickColor == "W") {
				Brick.setColorArray(1);
				System.out.println(Brick.getColorArray());
			}
			if (brickColor == "E") {
				Brick.setColorArray(2);
				System.out.println(Brick.getColorArray());
			}
			if (brickColor == "R") {
				Brick.setColorArray(3);
				System.out.println(Brick.getColorArray());
			}
			
			//ball
			if (ballColor == "O" || ballColor == "") {
				win.setColor(Colors.pastelTan5);
			}
			if (ballColor == "T") {
				win.setColor(Colors.pastelTeal5);
			}
			if (ballColor == "Y") {
				win.setColor(Colors.pastelBlue5);
			}
			if (ballColor == "U") {
				win.setColor(Colors.pastelGreen5);
			}
			win.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());
			
			//paddle
			if (paddleColor == "P" || paddleColor == "") {
				win.setColor(Colors.pastelTan6);
			}
			if (paddleColor == "G") {
				win.setColor(Colors.pastelTeal6);
			}
			if (paddleColor == "H") {
				win.setColor(Colors.pastelBlue6);
			}
			if (paddleColor == "J") {
				win.setColor(Colors.pastelGreen6);
			}
			win.fillRect((int) p.getX(), (int) p.getY(), (int) p.getWidth(), (int) p.getHeight());
			
			Pages.scoreboard(win);
			Pages.youWinLose(win);
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
	public static void setPWidth(int newWidth) {
		pWidth = newWidth;
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
	public static void setBallSize(int newBallSize) {
		ballSize = newBallSize;
	}
	public static String getBrickColor() {
		return brickColor;
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
	
	public static void restart() {
		brickArray = Brick.makeBricks();
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
			restart();
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_ENTER] && BreakoutBall.getLives() == 0) {
			gameState = 0; //splash page
			gameStart = false;
			restart();
		}
		else if (GDV5.KeysPressed[KeyEvent.VK_Q] && gameState == 4) {
			gameState = 0; //splash page
			gameStart = false;
			restart();
		}
		
		//brick colors
		if (GDV5.KeysPressed[KeyEvent.VK_W] && gameState == 5) {
			brickColor = "W";
//			Brick.setColorArray(1);
//			System.out.println(Brick.getColorArray());
		}
		if (GDV5.KeysPressed[KeyEvent.VK_E] && gameState == 5) {
			brickColor = "E";
//			Brick.setColorArray(2);
//			System.out.println(Brick.getColorArray());
		}
		if (GDV5.KeysPressed[KeyEvent.VK_R] && gameState == 5) {
			brickColor = "R";
//			Brick.setColorArray(3);
//			System.out.println(Brick.getColorArray());
		}
		
		//ball colors
		if (GDV5.KeysPressed[KeyEvent.VK_T] && gameState == 5) {
			ballColor = "T";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_Y] && gameState == 5) {
			ballColor = "Y";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_U] && gameState == 5) {
			ballColor = "U";
		}
		
		//paddle colors
		if (GDV5.KeysPressed[KeyEvent.VK_G] && gameState == 5) {
			paddleColor = "G";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_H] && gameState == 5) {
			paddleColor = "H";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_J] && gameState == 5) {
			paddleColor = "J";
		}
		
		//defaults
		if (GDV5.KeysPressed[KeyEvent.VK_I] && gameState == 5) {
			brickColor = "I";
//			Brick.setColorArray(0);
			System.out.println(Brick.getColorArray());
		}
		if (GDV5.KeysPressed[KeyEvent.VK_O] && gameState == 5) {
			ballColor = "O";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_P] && gameState == 5) {
			paddleColor = "P";
		}
		
		//CHALLENGE #
//		brickArray = Brick.makeBricks(); //bricks array equals the makeBricks() method
	}
	
	//CHALLENGE #
	public void ballHitBricks(BreakoutBall ball, Brick[] brick, Particles[] part) {
		int mvmtMax = 2;
		int mvmtMin = 0;
		int mvmt = mvmtMax - mvmtMin;
		int minV = 2;
		int maxV = 6;
		
		if (gameStart) {
			for (Brick b:brickArray) {
				if (ball.intersects(b) && b.getBrickVis() == true) {
					b.setBrickVis(false);
					particleArray = Particles.makeParticles(b);
					
					int colDir = collisionDirection(b, ball, ball.vX, ball.vY);
//					System.out.println(colDir);
					
					//score
					Pages.addScore(1);
					
					//ball intersects top
					if (colDir == 1) {
						if (minV < ball.vX && ball.vX < maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vX && ball.vX < -minV) ball.vX = ball.vX - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vX < -maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vX = ball.vX - (int) (Math.random() + mvmtMin);
						ball.vY = -Math.abs(ball.vY);
						System.out.println("T vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//ball intersects bottom
					else if (colDir == 3) {
						if (minV < ball.vX && ball.vX < maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vX && ball.vX < -minV) ball.vX = ball.vX - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vX < -maxV) ball.vX = ball.vX + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vX = ball.vX - (int) (Math.random() + mvmtMin);
						ball.vY = Math.abs(ball.vY);
						System.out.println("B vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//ball intersects left
					else if (colDir == 2) {
						ball.vX = -Math.abs(ball.vX);
						if (minV < ball.vY && ball.vY < maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vY && ball.vY < -minV) ball.vY = ball.vY - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vY < -maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vY = ball.vY - (int) (Math.random() + mvmtMin);
						System.out.println("L vX: " + ball.vX + " vY: " + ball.vY);
					}
					
					//ball intersects right
					else if (colDir == 0) {
						ball.vX = Math.abs(ball.vX);
						if (minV < ball.vY && ball.vY < maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else if (-maxV < ball.vY && ball.vY < -minV) ball.vY = ball.vY - (int) (Math.random() * mvmt + mvmtMin);
						else if (ball.vY < -maxV) ball.vY = ball.vY + (int) (Math.random() * mvmt + mvmtMin);
						else ball.vY = ball.vY - (int) (Math.random() + mvmtMin);
						System.out.println("R vX: " + ball.vX + " vY: " + ball.vY);
					}
				}
			}
		}
	}
}
