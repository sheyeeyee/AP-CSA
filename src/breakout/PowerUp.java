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

//CHALLENGE

public class PowerUp extends Rectangle {
	private static int count0 = 0, count0_1, count1 = 0, count1_1 = 0;
	private static int duration = 420;
	
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
	public static void powerDownPaddle(BreakoutPaddle paddle) {
		BreakoutRunner.setPWidth(50, paddle);
		count0_1 = 0;
	}
	public static void powerUpBall(BreakoutBall ball) {
		BreakoutRunner.setBallSize(50, ball);
		count1 = 0;
	}
	public static void powerDownBall(BreakoutBall ball) {
		BreakoutRunner.setBallSize(5, ball);
		count1_1 = 0;
	}
	public static void powerUpLives() {
		BreakoutBall.addLives(2);
	}
	public static void powerDownLives() {
		BreakoutBall.addLives(-1);
	}
	
	public static void powerUpUpdate(BreakoutBall ball, BreakoutPaddle paddle) {
		if (count0 == duration) {
			resetPWidth(paddle);
			count0 = 0;
		}
		if (count0_1 == duration) {
			resetPWidth(paddle);
			count0_1 = 0;
		}
		if (count1 == duration) {
			resetBallSize(ball);
			count1 = 0;
		}
		if (count1_1 == duration) {
			resetBallSize(ball);
			count1_1 = 0;
		}
		
		if (count0 < duration) {
			count0++;
		}
		if (count0_1 < duration) {
			count0++;
		}
		if (count1 < duration) {
			count1++;
		}
		if (count1_1 < duration) {
			count1_1++;
		}
	}
	
	public static void resetTimers() {
		count0 = duration;
		count0_1 = duration;
		count1 = duration;
		count1_1 = duration;
	}
}
