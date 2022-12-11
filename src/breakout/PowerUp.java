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
	private static int brickIndex;
	
	private static int powerUpType;
	private static int powerUpNum = 3; //paddle size, ball size, lives, bricks disappear??
	
	private static Brick[] bricks;
	
	public PowerUp() {
		super();
	}
	
	public static void randomPowerUp(BreakoutBall ball) {
		for (int i = 0; i < bricks.length; i++) {
			brickIndex = (int) (Math.random() * bricks.length);
			
			if (ball.intersects(bricks[brickIndex])) {
				powerUpType = (int) (Math.random() * powerUpNum);
				
				if (powerUpType == 0) {
					BreakoutRunner.setPWidth(400);
				}
				if (powerUpType == 1) {
					BreakoutRunner.setBallSize(100);
				}
				if (powerUpType == 2) {
					BreakoutBall.addLives(2);
				}
			}
		}
	}
}
