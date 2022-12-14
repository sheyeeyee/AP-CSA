package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import utilities.GDV5;
import breakout.BreakoutRunner;
import pong.Ball;
import pong.PongRunner;

public class BreakoutBall extends Rectangle {	
	//starting ball position
	private static int startX = (int) (BreakoutRunner.getWinX() / 2 - 20 / 2);
	private static int startY = 600;
	
	//creating velocity variables (public)
	public int vX;
	public int vY;
	
	//lives
	private static int lives;
	
	//changing ball speed based on paddle movement
	private int nVX = 1;
//	private int countA;
//	private int countD;
	
	//for reset method
	private int count = 120;
	private boolean out = false;
	
	//ball constructor
	public BreakoutBall(int size) {
		super(startX, startY, size, size);
	}
	
	public static int getLives() {
		return lives;
	}
	public static void setLives(int newLives) {
		lives = newLives;
	}
	public static void addLives(int addLives) {
		lives += addLives;
	}
	
	//method for ball to move
	public void move(BreakoutPaddle p, Brick[] brick) {
		//CHALLENGE 1
//		vX = 3;
//		vY = 3;
		
		//game mode
		if (GDV5.KeysPressed[KeyEvent.VK_1]) {
			vX = 3;
			vY = 3;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_2]) {
			vX = 4;
			vY = 4;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_3]) {
			vX = 5;
			vY = 5;
		}
		
		//if ball goes to bottom
		if (this.getY() >= BreakoutRunner.getWinY()) {
			this.setLocation((int) (BreakoutRunner.getWinX() / 2 - this.getWidth() / 2), 600);
			count = 0;
			out = true;
			lives --;
		}
		
		//ball hits paddle
		if (this.intersects(p)) {		
			//ball hits paddle top
			if (GDV5.collisionDirection(p, this, vX, vY) == 1) {
				if (vX > 0) vX = Math.abs(vX);
				else if (vX < 0) vX = -Math.abs(vX);
				vY = -Math.abs(vY);
				System.out.println("P vX: " + vX + " vY: " + vY);
				
				if (GDV5.KeysPressed[KeyEvent.VK_A] || GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
					vX = vX - nVX;
				}
				else if (GDV5.KeysPressed[KeyEvent.VK_D] || GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
					vX = vX + nVX;
				}
			}
			//ball hits paddle left
			else if (GDV5.collisionDirection(p, this, vX, vY) == 2) {
				vX = -Math.abs(vX);
			}
			//ball hits paddle right
			else if (GDV5.collisionDirection(p, this, vX, vY) == 0) {
				vX = Math.abs(vX);
			}
		}
		//ball hits top
		if (this.getY() < 0) {
			vY = Math.abs(vY);
		}
		
		//ball hits left
		if (this.getX() < 0) {
			vX = Math.abs(vX);
		}
		
		//ball hits right
		else if (this.getX() > BreakoutRunner.getWinX() - this.width) {
			vX = -Math.abs(vX);
		}
		
		//CHALLENGE #
		//for resetting ball
		if (BreakoutRunner.getGameStart()) {
			if (count == 120) {
				this.translate(vX, vY);
			}
			else {
				this.translate(0, 0);
			}
		}
//		if (BreakoutRunner.getGameState() == 0 || lives == 0 || Pages.getScore() == Brick.getNumBricks()) {
//			this.translate(0, 0);
//			this.setLocation((int) (BreakoutRunner.getWinX() / 2 - this.getWidth() / 2), 600);
//		}
	}
		
	public void resetBall() {
		if (count == 120) {
			out = false;
		}
		if (out) {
			count++;
		}
	}
	
	public void resetBallPosition() {
		this.translate(0, 0);
		this.setLocation((int) (BreakoutRunner.getWinX() / 2 - this.getWidth() / 2), 600);
	}
}
