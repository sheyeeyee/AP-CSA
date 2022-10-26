package pong;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import utilities.GDV5;

public class Paddle extends Rectangle {	
	public int pVy = 20;
	
	public Paddle(int pStartX, int pStartY, int pWidth, int pHeight) {
		super(pStartX, pStartY, pWidth, pHeight);
	}
	
	public void p1Move() {
		//double if statement means both run as long as it's true so you only need to account for one limit in each if statement
		if (PongRunner.gameState == 1 || PongRunner.gameState == 3 || PongRunner.gameState == 4) {
			if (GDV5.KeysPressed[KeyEvent.VK_W] && this.getY() > 0) { //as long as the paddle is within the upper limit of the window, it goes up
				this.translate(0, -pVy);
			}
			if (GDV5.KeysPressed[KeyEvent.VK_S] && this.getY() < 600) {
				this.translate(0, pVy);
			}
		}
		if (PongRunner.gameState == 0) {
			this.translate(0, 0);
			this.setLocation(8, 300);
		}
	}
	
	public void p2Move() {
		if (PongRunner.gameState == 1 || PongRunner.gameState == 4) {
			if (GDV5.KeysPressed[KeyEvent.VK_UP] && this.getY() > 0) {
				this.translate(0, -pVy);
			}
			if (GDV5.KeysPressed[KeyEvent.VK_DOWN] && this.getY() < 600) {
				this.translate(0, pVy);
			}
		}
		if (PongRunner.gameState == 0) {
			this.translate(0, 0);
			this.setLocation(1200 - 18, 300);
		}
	}
}