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
	private int pVx = 30;
	
	public BreakoutPaddle(int pStartX, int pStartY, int pWidth, int pHeight) {
		super(pStartX, pStartY, pWidth, pHeight);
	}
	
	public void paddleMove() {
		if (GDV5.KeysPressed[KeyEvent.VK_A] && this.getX() > 0) { //as long as the paddle is within the upper limit of the window, it goes up
			this.translate(-pVx, 0);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_D] && this.getX() < BreakoutRunner.getWinX() - BreakoutRunner.getPWidth()) {
			this.translate(pVx, 0);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT] && this.getX() > 0) { //as long as the paddle is within the upper limit of the window, it goes up
			this.translate(-pVx, 0);
		}
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT] && this.getX() < BreakoutRunner.getWinX() - BreakoutRunner.getPWidth()) {
			this.translate(pVx, 0);
		}
	}
}
