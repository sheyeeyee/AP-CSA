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

public class BreakoutPaddle extends Rectangle {	
	private static int pVx = 20;
	
	public static int getPVX() {
		return pVx;
	}
	
	public BreakoutPaddle(int pStartX, int pStartY, int pWidth, int pHeight) {
		super(pStartX, pStartY, pWidth, pHeight);
	}
	
	public void paddleMove() {
		if (BreakoutRunner.getGameStart() && BreakoutBall.getLives() > 0) {
			if (GDV5.KeysPressed[KeyEvent.VK_A] && this.getX() > 0) { //as long as the paddle is within the upper limit of the window, it goes up
				this.translate(-pVx, 0);
			}
			if (GDV5.KeysPressed[KeyEvent.VK_D] && this.getX() < BreakoutRunner.getWinX() - getWidth()) {
				this.translate(pVx, 0);
			}
			if (GDV5.KeysPressed[KeyEvent.VK_LEFT] && this.getX() > 0) { //as long as the paddle is within the upper limit of the window, it goes up
				this.translate(-pVx, 0);
			}
			if (GDV5.KeysPressed[KeyEvent.VK_RIGHT] && this.getX() < BreakoutRunner.getWinX() - getWidth()) {
				this.translate(pVx, 0);
			}
		}
	}
	
	public void resetPaddlePosition() {
		this.translate(0, 0);
		this.setLocation(BreakoutRunner.getWinX() / 2 - BreakoutRunner.getPWidth() / 2, BreakoutRunner.getPY());
	}
}
