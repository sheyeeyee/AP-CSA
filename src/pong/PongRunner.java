package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import utilities.GDV5;


public class PongRunner extends GDV5 { //PongRunner is an instance of the GDV5 class, a "child"

	int pWidth = 10;
	int pOffset = 8;
	int respawnLimit = 300;
	int barWidth = 10;
	
	Ball ball = new Ball(20); //creating a ball object of size 20
	static String ballColor = ""; //set up for customization
	
	Paddle p1 = new Paddle(pOffset, 300, pWidth, 200); //creating paddles of width 20 and height 200
	Paddle p2 = new Paddle(getMaxWindowX() - (pWidth + pOffset), 300, pWidth, 200);
	static String paddleColor = ""; //set up for customization
	
	//new scoreboard object
	Score scoreboard = new Score();
	
	//create customization colors for ball and paddles
	Color pastelTeal = new Color(72, 218, 188);
	Color pastelBlue = new Color(180, 224, 229);
	Color pastelLightGreen = new Color(171, 232, 219);
	Color pastelTan = new Color(229, 209, 180);
	Color pastelTan2 = new Color(186, 170, 146);
	
	//set up gamestate for different screens
	static int gameState = 0;
	
	
	public static void main(String[] args) {
		PongRunner runner = new PongRunner(); //create an instance of the class to call methods in GDV5
		runner.start();
	}

	//bc of this, no loops needed since these are being called continuously
	@Override
	public void update() { //60 fps, driver called 60 times per second
		paddleBounce();
		pause();
		ball.move();
		autoMove();
		p1.p1Move();
		p2.p2Move();
	}

	@Override
	public void draw(Graphics2D win) { //at the processor speed (~3000 fps, called 3000 times per second)
		if (gameState == 0) {
			//splash page
			Score.splash(win);
			Score.score1 = 0;
			Score.score2 = 0;
		}
		if (gameState == 4) {
			smashBallCommentary(win);
		}
		if (gameState == 1 || gameState == 3 || gameState == 4) {
			//middle line
			win.setColor(pastelTan2);
			win.fillRect(getMaxWindowX() / 2 - barWidth / 2, 0, barWidth, getMaxWindowY());
		
			//scoreboard
			Score.scoreboard(win);
				
			//ball
			if (ballColor == "O" || ballColor == "") {
				win.setColor(pastelTan);
			}
			if (ballColor == "T") {
				win.setColor(pastelTeal);
			}
			if (ballColor == "Y") {
				win.setColor(pastelBlue);
			}
			if (ballColor == "U") {
				win.setColor(pastelLightGreen);
			}
			win.fillOval((int) ball.getX(), (int) ball.getY(), (int) ball.getWidth(), (int) ball.getHeight());
			
			//paddle1
			if (paddleColor == "P" || paddleColor == "") {
				win.setColor(pastelTan2);
			}
			if (paddleColor == "G") {
				win.setColor(pastelTeal);
			}
			if (paddleColor == "H") {
				win.setColor(pastelBlue);
			}
			if (paddleColor == "J") {
				win.setColor(pastelLightGreen);
			}
			win.fillRect((int) p1.getX(), (int) p1.getY(), (int) p1.getWidth(), (int) p1.getHeight());
			
			//paddle2
			if (paddleColor == "P" || paddleColor == "") {
				win.setColor(pastelTan2);
			}
			if (paddleColor == "G") {
				win.setColor(pastelTeal);
			}
			if (paddleColor == "H") {
				win.setColor(pastelBlue);
			}
			if (paddleColor == "J") {
				win.setColor(pastelLightGreen);
			}
			win.fillRect((int) p2.getX(), (int) p2.getY(), (int) p2.getWidth(), (int) p2.getHeight());
		}
		if (gameState == 2) {
			Score.pausedGame(win);
		}
		if (gameState == 5) {
			Score.menu(win);
		}
	}
	
	//method for ball to bounce against paddle (CHALLENGE 1)
	public void paddleBounce() {
		if ((ball.intersects(p1) && gameState == 1) || (ball.intersects(p1) && gameState == 3)) {
			if (collisionDirection(p1, ball, 5, 5) == 1) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			if (collisionDirection(p1, ball, -5, -5) == 3) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			ball.vX *= -1;
		}
		else if (ball.intersects(p1) && gameState == 4) {
			if (collisionDirection(p1, ball, 5, 5) == 1) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			if (collisionDirection(p1, ball, -5, -5) == 3) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			if (GDV5.KeysPressed[KeyEvent.VK_S] && ball.vY < 0) {
				ball.vX = ball.vX * -1 + 3; //reverse direction but add 3 (instead of multiplying... that's too fast)
				ball.vY *= -2;
			}
			else if (GDV5.KeysPressed[KeyEvent.VK_S] && ball.vY > 0) {
				ball.vX = ball.vX * -1 + 3;
				ball.vY *= 2;
			}
			else ball.vX *= -1;
		}
		if ((ball.intersects(p2) && gameState == 1) || (ball.intersects(p2) && gameState == 3)) {
			if (collisionDirection(p2, ball, 5, 5) == 1) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			if (collisionDirection(p2, ball, -5, -5) == 3) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			ball.vX *= -1;
		}
		else if (ball.intersects(p2) && gameState == 4) {
			if (collisionDirection(p2, ball, 5, 5) == 1) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			if (collisionDirection(p2, ball, -5, -5) == 3) {
				ball.setLocation((int) (Math.random() + respawnLimit * (GDV5.getMaxWindowX() - respawnLimit)), (int) (Math.random() + respawnLimit * (GDV5.getMaxWindowY() - respawnLimit)));
			}
			if (GDV5.KeysPressed[KeyEvent.VK_DOWN] && ball.vY < 0) {
				ball.vX = ball.vX * -1 - 3;
				ball.vY *= -2;
			}
			else if (GDV5.KeysPressed[KeyEvent.VK_DOWN] && ball.vY > 0) {
				ball.vX = ball.vX * -1 + 3;
				ball.vY *= 2;
			}
			else ball.vX *= -1;
		}
		
		if (ball.intersects(p1) && gameState == 3) {
			if (collisionDirection(p1, ball, 5, 5) == 1) {
				Score.scoreAI = 0;
			}
			else if (collisionDirection(p1, ball, -5, -5) == 3) {
				Score.scoreAI = 0;
			}
			else Score.scoreAI += 1;
		}
		
		//top or bottom collisions
//		collisionDirection(p1, ball, 5, 5);
		
		//rip previous attempt before intersect
//		if (ball.getX() <= GDV5.getMaxWindowX()/2) {
//			if (ball.getY() <= p1.getY() && ball.getX() >= p1.getWidth()) {
//				ball.vX *= -1;
//			}
//		}
//		if (ball.getX() >= GDV5.getMaxWindowX()/2) {
//			if (ball.getY() <= p2.getY() && ball.getX() <= (GDV5.getMaxWindowX() - p2.getWidth())) {
//				ball.vX *= -1;
//			}
//		}
	}
	
	//CHALLENGE 2
	public static void pause() {
		//0: splash page
		//1: easy + normal mode
		//2: pause page
		//3: ai mode
		//4: smash ball mode
		//5: customization page
		
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] && gameState == 0) {
			gameState = 5; //customization
		}
		if (GDV5.KeysPressed[KeyEvent.VK_Q] && gameState == 5) {
			gameState = 0;
		}
		if ((GDV5.KeysPressed[KeyEvent.VK_1] || GDV5.KeysPressed[KeyEvent.VK_2]) && gameState == 0) {
			gameState = 1; //game starts
		}
		if (GDV5.KeysPressed[KeyEvent.VK_3]) {
			gameState = 3; //auto mode
		}
		if (GDV5.KeysPressed[KeyEvent.VK_4]) {
			gameState = 4; //smash ball
		}
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] && gameState == 1) {
			gameState = 2; //pause screen
		}
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] && gameState == 3) {
			gameState = 2; //pause screen
		}
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] && gameState == 4) {
			gameState = 2; //pause screen
		}
		if (GDV5.KeysPressed[KeyEvent.VK_SPACE] && gameState == 2) {
			gameState = 1; //resume game
		}
		if ((GDV5.KeysPressed[KeyEvent.VK_ENTER] && Score.score1 == 10) || (GDV5.KeysPressed[KeyEvent.VK_ENTER] && Score.score2 == 10)) {
			gameState = 0; //splash page
		}
		if (GDV5.KeysPressed[KeyEvent.VK_Q] && gameState == 2) {
			gameState = 0; //splash page
		}
		if (GDV5.KeysPressed[KeyEvent.VK_T] && gameState == 5) {
			ballColor = "T";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_Y] && gameState == 5) {
			ballColor = "Y";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_U] && gameState == 5) {
			ballColor = "U";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_G] && gameState == 5) {
			paddleColor = "G";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_H] && gameState == 5) {
			paddleColor = "H";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_J] && gameState == 5) {
			paddleColor = "J";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_O] && gameState == 5) {
			ballColor = "O";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_P] && gameState == 5) {
			paddleColor = "P";
		}

		//rip pause attempt
//		boolean pause = false;
//				
//		if (PongRunner.KeysPressed[KeyEvent.VK_ESCAPE]) { //have it only affect pause boolean, create another if else for if pause, if !pause
//			if (!pause) {
//				Ball.vX = 0;
//				Ball.vY = 0;
//				pause = true;
//			}
//			else {
//				//make 4 new variables for like pos and neg x and y
//				Ball.vX = 5;
//				Ball.vY = 5;
//				pause = false;
//			}
//		}
	}
	
	//CHALLENGE 3
	//single-player mode
	public void autoMove() {
		if (PongRunner.gameState == 3) {
			if (p2.getY() >= 0 && p2.getY() <= 600) {
				if (ball.getY() >= 100 && ball.getY() <= 700) {
					p2.setLocation(1200 - 18, (int) ball.getY() - 100);
				}
				else if (ball.getY() <= 100) {
					p2.setLocation(1200 - 18, 0);
				}
				else {
					p2.setLocation(1200 - 18, 600);
				}
			}
//			if (ball.getX() >= 600) {
//			p2.setLocation(1200 - 18, (int) ball.getY() - 100);
//			}
//			else if (ball.getX() < 600) {
//				p2.translate(0, 15);
//			}
		}
		if (PongRunner.gameState == 0) {
			p2.translate(0, 0);
			p2.setLocation(1200 - 18, 300);
		}
	}
	
	//smash ball commentary
	public void smashBallCommentary(Graphics2D font) {
		if (Math.abs(Ball.vY) > 10) {
			font.setColor(Color.black);
			font.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			font.drawString("get smooshed", 400, 500);
		}
	}
}