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
	private static int pHeight = 10;
	private static int pOffset = 20;
	
	//creating objects
	Brick[] brickObjects;
	BreakoutBall ball = new BreakoutBall(20);
	BreakoutPaddle p = new BreakoutPaddle((winX / 2 - pWidth / 2), winY - pHeight - pOffset, pWidth, pHeight);
	
	//customizing colors
	String brickColor = "";
	String ballColor = "";
	String paddleColor = "";
	
	//gamestates
	public int gameState = 1;
	
	public BreakoutRunner() {
		super();
		brickObjects = Brick.makeBricks(); //bricks array equals the makeBricks() method
	}
	
	public static void main(String[] args) {
		BreakoutRunner runner = new BreakoutRunner();
		runner.start();
	}

	//bc of this, no loops needed since these are being called continuously
	@Override
	public void update() { //60 fps, driver called 60 times per second
		ball.move(p, brickObjects);
		ballHitBricks(ball, brickObjects);
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
			for (Brick b:brickObjects) {
				b.draw(win);
			}
			
			//ball
			win.setColor(Colors.pastelTan);
			win.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());
			
			//paddle
			win.setColor(Colors.pastelTan2);
			win.fillRect((int) p.getX(), (int) p.getY(), (int) p.getWidth(), (int) p.getHeight());
		}
	}
	
	public void ballHitBricks(BreakoutBall ball, Brick[] brick) {
		for (Brick b:brickObjects) {
			if (ball.intersects(b)) {
				//ball intersects top
				if (collisionDirection(b, ball, ball.vX, ball.vY) == 1) {
					if (ball.vX < 3 && ball.vX > 0) ball.vX = ball.vX + (int) (Math.random() * 2 + 1);
					else if (ball.vX > -3 && ball.vX < 0) ball.vX = ball.vX - (int) (Math.random() * 2 + 1);
					else if (ball.vX < -3) ball.vX = ball.vX + (int) (Math.random() * 2 + 1);
					else ball.vX = ball.vX - (int) (Math.random() * 2 + 1);
					ball.vY = -Math.abs(ball.vY);
					System.out.println("T vY: " + ball.vY + " " + "vX: " + ball.vX);
				}
				
				//ball intersects bottom
				else if (collisionDirection(b, ball, ball.vX, ball.vY) == 3) {
					ball.vX = ball.vX + (int) (Math.random() * 2 + 1);
					ball.vY = Math.abs(ball.vY);
					System.out.println("B vY: " + ball.vY + " " + "vX: " + ball.vX);
				}
				
				//ball intersects left
				else if (collisionDirection(b, ball, ball.vX, ball.vY) == 2) {
					ball.vX = -Math.abs(ball.vX);
					ball.vY = ball.vY + (int) (Math.random() * 2 + 1);
					System.out.println("L vY: " + ball.vY + " " + "vX: " + ball.vX);
				}
				
				//ball intersects right
				else if (collisionDirection(b, ball, ball.vX, ball.vY) == 0) {
					ball.vX = Math.abs(ball.vX);
					ball.vY = ball.vY + (int) (Math.random() * 2 + 1);
					System.out.println("R vY: " + ball.vY + " " + "vX: " + ball.vX);
				}
				b.setLocation(-100, -100);
			}
		}
	}
}
