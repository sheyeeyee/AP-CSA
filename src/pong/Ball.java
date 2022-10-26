package pong;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Ball extends Rectangle {
	private int winX = PongRunner.getMaxWindowX();
	private int winY = PongRunner.getMaxWindowY();
	
	//set starting position of ball
	static int startX = 600;
	static int startY = 400;
	
	//make different modes by changing speeds in if statements based on button press
	public static int vX;
	public static int vY;
	
	private boolean out = false;
	private int count = 120;
	
	public Ball(int size) {
		super(startX, startY, size, size);
	}
	
	public void move() {
		pauseCounter();
		
		//game mode
		if (GDV5.KeysPressed[KeyEvent.VK_1]) {
			vX = 5;
			vY = 5;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_2]) {
			vX = 10;
			vY = 10;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_3]) {
			vX = 15;
			vY = 15;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_4]) {
			vX = 6;
			vY = 6;
		}
		startX += vX;
		startY += vY;
		
		//hitting top or bottom edges
		if (this.getY() < 0) {
			vY *= -1;
		}
		if (this.getY() > GDV5.getMaxWindowY() - this.height) {
			vY *= -1;
		}
		
		//leaving through the right or left sides, reposition ball to center
		if (this.getX() < 0) {
			if (PongRunner.gameState == 4) {
				vX = 4;
				vY = 4;
			}
			this.setLocation((int) (winX / 2 - this.getWidth() / 2), winY / 2);
			Score.score2 += 1;
			Score.scoreAI = 0;
			out = true;
			count = 0;
		}
		if (this.getX() > 1180) {
			if (PongRunner.gameState == 4) {
				vX = -4;
				vY = -4;
			}
			this.setLocation((int) (winX / 2 - this.getWidth() / 2), winY / 2);
			Score.score1 += 1;
			Score.scoreAI = 0;
			out = true;
			count = 0;
		}
		
		//pause
//		boolean pause = false;
//		
//		if (PongRunner.KeysPressed[KeyEvent.VK_ESCAPE]) { //have it only affect pause boolean, create another if else for if pause, if !pause
//			if (!pause) {
//				vX = 0;
//				vY = 0;
//				pause = true;
//			}
//			else {
//				//make 4 new variables for like pos and neg x and y
//				vX = 5;
//				vY = 5;
//				pause = false;
//			}
//		}
		
		//for resetting ball
		if (PongRunner.gameState == 1 || PongRunner.gameState == 3 || PongRunner.gameState == 4) {
			if (count == 120) {
				this.translate(vX, vY);
			}
			else {
				this.translate(0, 0);
			}
		}
		if (PongRunner.gameState == 0) {
			this.translate(0, 0);
			this.setLocation((int) (winX / 2 - this.getWidth() / 2), winY / 2);
		}
		
		//stop ball when player wins
		if (Score.score1 == 10 || Score.score2 == 10) {
			vX = 0;
			vY = 0;
		}
	}
	
	public void pauseCounter() {
		if (out) {
			count++;
		}
		if (count == 120) {
			out = false;
		}
	}
}