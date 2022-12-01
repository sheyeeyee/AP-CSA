package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JFrame;

import utilities.GDV5;

public class BreakoutRunner extends GDV5 {
	//create variable for max window sizes
	public static int winX = getMaxWindowX();
	public static int winY = getMaxWindowY();
	
	//set paddle parameters
	private static int pWidth = 200;
	private static int pHeight = 15;
	private static int pOffset = 20;
	
	//creating objects
	Brick[] bricks;
	BreakoutBall ball = new BreakoutBall(20);
	BreakoutPaddle p = new BreakoutPaddle((winX / 2 - pWidth / 2), winY - pHeight - pOffset, pWidth, pHeight);
	
	//customizing colors
	String brickColor = "";
	String ballColor = "";
	String paddleColor = "";

	//colors
	private static Color pastelBlue = new Color(180, 224, 229);
	private static Color pastelTeal = new Color(72, 218, 188);
	private static Color pastelLightGreen = new Color(171, 232, 219);
	private static Color pastelTan = new Color(229, 209, 180);
	private static Color pastelTan2 = new Color(186, 170, 146);
	
	//gamestates
	public int gameState = 1;
	
	public BreakoutRunner() {
		super();
		bricks = Brick.makeBricks(); //bricks array equals the makeBricks() method
	}
	
	public static void main(String[] args) {
		BreakoutRunner runner = new BreakoutRunner();
		runner.start();
	}

	//bc of this, no loops needed since these are being called continuously
	@Override
	public void update() { //60 fps, driver called 60 times per second
		ball.move(p, bricks);
		ballHitBricks(ball, bricks);
		ball.resetBall();
		p.paddleMove();
	}

	@Override
	public void draw(Graphics2D win) { //at the processor speed (~3000 fps, called 3000 times per second)
		if (gameState == 0) {
			Pages.home(win);
		}
		
		if (gameState == 1) {
			//bricks (syntactic sugar)
			for (Brick b:bricks) {
				b.draw(win);
			}
			
			//ball
			win.setColor(pastelTan);
			win.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());
			
			//paddle
			win.setColor(pastelTan2);
			win.fillRect((int) p.getX(), (int) p.getY(), (int) p.getWidth(), (int) p.getHeight());
		}
	}
	
	public void ballHitBricks(BreakoutBall ball, Brick[] brick) {
		for (Brick b:bricks) {
			if (ball.intersects(b)) {
				//ball intersects top
				if (collisionDirection(ball, b, ball.vX, ball.vY) == 1) {
					ball.vY = -Math.abs(ball.vY);
				}
				
				//ball intersects bottom
				if (collisionDirection(ball, b, ball.vX, ball.vY) == 3) {
					ball.vY = Math.abs(ball.vY);
				}
				
				//ball intersects left
				if (collisionDirection(ball, b, ball.vX, ball.vY) == 2) {
					ball.vX = -Math.abs(ball.vX);
				}
				
				//ball intersects right
				if (collisionDirection(ball, b, ball.vX, ball.vY) == 0) {
					ball.vX = Math.abs(ball.vX);
				}
			}
		}
		System.out.println("vY: " + ball.vY + " " + "vX: " + ball.vX);
	}
}
