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
	
	private static int count0 = 0, count1 = 0;
	
	private boolean powerUpBall = false;
	private boolean powerUpPaddle = false;
	
	private static int brickIndex;
	
	public PowerUp() {
		super();
	}
	
	public static void resetPWidth(BreakoutPaddle paddle) {
		BreakoutRunner.setPWidth(200, paddle);
	}
	public static void resetBallSize(BreakoutBall ball) {
		BreakoutRunner.setBallSize(20, ball);
	}
	public static void resetLives() {
		BreakoutBall.setLives(5);
	}
	
	public static void powerUpPaddle(BreakoutPaddle paddle) {
		BreakoutRunner.setPWidth(400, paddle);
		count0 = 0;
	}
	public static void powerUpBall(BreakoutBall ball) {
		BreakoutRunner.setBallSize(50, ball);
		count1 = 0;
	}
	public static void powerUpLives() {
		BreakoutBall.addLives(2);
	}
	
	public static void powerUpUpdate(BreakoutBall ball, BreakoutPaddle paddle) {
		if (count0 == 300) {
			resetPWidth(paddle);
			count0 = 0;
		}
		if (count1 == 300) {
			resetBallSize(ball);
			count1 = 0;
		}
		
		if (count0 < 300) {
			count0++;
		}
		if (count1 < 300) {
			count1++;
		}
	}
	
	public static void resetTimers() {
		count0 = 300;
		count1 = 300;
	}
}
