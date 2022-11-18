package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import pong.PongRunner;
import utilities.GDV5;

public class BreakoutBall extends Rectangle {
	private int winX = BreakoutRunner.getMaxWindowX();
	private int winY = BreakoutRunner.getMaxWindowY();
	
	private Color col;
	private static Color pastelBlue = new Color(180, 224, 229);
	private static Color pastelTeal = new Color(72, 218, 188);
	private static Color pastelLightGreen = new Color(171, 232, 219);
	private static Color pastelTan = new Color(229, 209, 180);
	private static Color pastelTan2 = new Color(186, 170, 146);
	
	private static int startX = 50;
	private static int startY = 50;
	
	public static int vX;
	public static int vY;
	
	public BreakoutBall(int size) {
		super(startX, startY, size, size);
	}
	
	public void move() {
		vX = 10;
		vY = 10;
		startX += vX;
		startY += vY;
		
		//if ball goes out at bottom
		if (this.getY() > GDV5.getMaxWindowY() - this.height) {
			this.setLocation((int) (winX / 2 - this.getWidth() / 2), winY / 2);
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
	}
	
	public void draw(Graphics2D pb) {
	}
}
