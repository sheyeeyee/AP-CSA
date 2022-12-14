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
import breakout.Brick;

//CHALLENGE #

public class PowerUp extends Rectangle {
	private static int powerUpType;
	private static int powerUpNum = 3; //paddle size, ball size, lives, bricks disappear??
	private static boolean powerUp0 = false, powerUp1 = false, powerUp2 = false;
	
	private static int brickIndex;
	private static Brick[] bricks;
	
	public PowerUp() {
		super();
	}
	
	public static void resetPWidth() {
		BreakoutRunner.setPWidth(200);
	}
	public static void resetBallSize() {
		BreakoutRunner.setBallSize(20);
	}
	public static void resetLives() {
		BreakoutBall.setLives(5);
	}
	
	public static void randomPowerUp(BreakoutBall ball) {
		int count0 = 0, count1 = 0, count2 = 0;
		
		Brick[] bricks = new Brick[powerUpNum];
		
		if (BreakoutRunner.getGameStart()) {
			for (int i = 0; i < bricks.length; i++) {
				brickIndex = (int) (Math.random() * bricks.length);
				
				if (ball.intersects(bricks[brickIndex])) {
					powerUpType = (int) (Math.random() * powerUpNum);
					
					if (powerUpType == 0) {
						if (count0 == 120) {
							resetPWidth();
							powerUp0 = false;
						}
						else {
							BreakoutRunner.setPWidth(400);
							powerUp0 = true;
						}
						if (powerUp0) count0++;
					}
					if (powerUpType == 1) {
						if (count1 == 120) {
							resetBallSize();
							powerUp1 = false;
						}
						else {
							BreakoutRunner.setBallSize(100);
							powerUp1 = true;
						}
						if (powerUp1) count1++;
					}
					if (powerUpType == 2) {
						if (count2 == 120) {
							resetLives();
							powerUp2 = false;
						}
						else {
							BreakoutBall.addLives(2);
							powerUp2 = true;
						}
						if (powerUp2) count2++;
					}
				}
			}
		}
	}
}
