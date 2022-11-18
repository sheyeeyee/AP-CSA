package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import pong.Ball;
import utilities.GDV5;

public class BreakoutBall extends Rectangle {
	//create variable for max window sizes
	private static int winX = BreakoutRunner.getMaxWindowX();
	private static int winY = BreakoutRunner.getMaxWindowY();
	
	//starting ball position
	private static int startX = (int) (winX / 2 - 20 / 2);
	private static int startY = winY / 2;
	
	//creating velocity variables
	public static int vX;
	public static int vY;
	
	//for reset method
	private int count = 120;
	private boolean out = false;
	
	//ball constructor
	public BreakoutBall(int size) {
		super(startX, startY, size, size);
	}
	
	//method for ball to move (AI)
	public void move(BreakoutPaddle p) {
		vX = 5;
		vY = 5;
		startX += vX;
		startY += vY;
		
		//if ball goes out at bottom
		if (this.getY() > GDV5.getMaxWindowY() - this.height) {
			this.setLocation((int) (winX / 2 - this.getWidth() / 2), winY / 2);
			count = 0;
			out = true;
		}
		
		//ball hits paddle
		if (this.intersects(p)) {
			vY *= -1;
		}
		
		//ball hits top
		if (this.getY() < 0) {
			vY *= -1;
		}
		//ball hits left
		if (this.getX() < 0) {
			vX *= -1;
		}
		//ball hits right
		if (this.getY() > winX) {
			vX *= -1;
		}
		
		//reset
		if (count == 120) {
			this.translate(vX, vY);
		}
		else {
			this.translate(0, 0);
		}
	}
	
	public void resetBall() {
		if (count == 120) {
			out = false;
		}
		if (out) {
			count++;
		}
	}
}
