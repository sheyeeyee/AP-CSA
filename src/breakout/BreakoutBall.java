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

public class BreakoutBall extends Rectangle {	
	//starting ball position
	private static int startX = (int) (BreakoutRunner.winX / 2 - 20 / 2);
	private static int startY = BreakoutRunner.winY / 2;
	
	//creating velocity variables (public)
	public int vX = 5;
	public int vY = 5;
	
	private int nVX = 1;
	private int countA;
	private int countD;
	
	//for reset method
	private int count = 120;
	private boolean out = false;
	
	//ball constructor
	public BreakoutBall(int size) {
		super(startX, startY, size, size);
	}
	
	//method for ball to move (AI)
	public void move(BreakoutPaddle p, Brick[] brick) {
		//CHALLENGE 1
//		vX = 3;
//		vY = 3;
		
		//if ball goes to bottom
		if (this.getY() >= BreakoutRunner.winY) {
			this.setLocation((int) (BreakoutRunner.winX / 2 - this.getWidth() / 2), BreakoutRunner.winY / 2);
			count = 0;
			out = true;
//			vY = -Math.abs(vY);
		}
		
		//ball hits paddle
		if (this.intersects(p)) {
			vY = -Math.abs(vY);
			
//			if (GDV5.KeysPressed[KeyEvent.VK_A] || GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
//				vX = vX - nVX;
//				vY = -Math.abs(vY);
//				countA++;
//			}
//			else if (GDV5.KeysPressed[KeyEvent.VK_D] || GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
//				vX = vX + nVX;
//				vY = -Math.abs(vY);
//				countD++;
//			}
//			else vY = -Math.abs(vY);
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
		else if (this.getX() > BreakoutRunner.winX - this.width) {
			vX = -Math.abs(vX);
		}
		
		//ball hits bricks
//		for (int i = 0; i < brick.length; i++) {			
//			if (this.intersects(brick[i])) {
//				vY *= -1;
//			}
//		}
		
		//reset
		if (count == 120) {
			this.translate(vX, vY);
			
//			if (countA > 0) {
//				this.translate(vX + (countA * nVX), vY);
//			}
//			else if (countD > 0) {
//				this.translate(vX - (countD * nVX), vY);
//			}
//			else this.translate(vX, vY);
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
