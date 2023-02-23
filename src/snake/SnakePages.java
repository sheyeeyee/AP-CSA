package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;

import breakout.BreakoutBall;
import breakout.BreakoutRunner;
import breakout.Brick;
import breakout.Colors;
import breakout.Pages;
import breakout.PowerUp;
import pong.Score;
import utilities.GDV5;

public class SnakePages {
	private static Integer score;
	
	//getter and setter
	public static int getScore() {
		return score;
	}
	public static void setScore(int newScore) {
		score = newScore;
	}
	public static void addScore(int addScore) {
		score = score + addScore;
	}
	
	public static void home(Graphics2D font) {
		font.setColor(Color.white);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		font.drawString("Snake", 180, 200);
		
		font.setColor(Colors.pastelGreen8);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		font.drawString("MMORPG", 300, 230);
		
		font.setFont(new Font("Arial", Font.ITALIC, 15));
		font.drawString("Copyright Shelley Wei :)", 230, 260);
		
		font.setColor(Colors.pastelTeal7);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("PRESS THE CORRESPONDING NUMBER FOR GAME MODE", 85, 290);
		
		font.setColor(Colors.pastelTeal5);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("PRESS ESCAPE FOR CUSTOMIZATION", 165, 310);
		
		font.setColor(Colors.pastelTeal5);
		font.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		font.drawString("1: EASY", 170, 350);
		
		font.setColor(Colors.pastelTeal4);
		font.drawString("2: NORMAL", 240, 390);
		
		font.setColor(Colors.pastelTeal3);
		font.drawString("3: HARD", 320, 430);
		
		//W
		font.setColor(Colors.pastelGreen);
		font.fillRect(100-30+20, 450+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(103-30+20, 453+20, 20, 20);
		
		//A
		font.setColor(Colors.pastelGreen);
		font.fillRect(75-30+20, 475+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(78-30+20, 478+20, 20, 20);
		
		//S
		font.setColor(Colors.pastelGreen);
		font.fillRect(100-30+20, 475+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(103-30+20, 478+20, 20, 20);
		
		//D
		font.setColor(Colors.pastelGreen);
		font.fillRect(125-30+20, 475+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(128-30+20, 478+20, 20, 20);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 12));
		font.drawString("A", 80-30+20, 490+20);
		font.drawString("D", 130-30+20, 490+20);
		font.drawString("W", 105-30+20, 465+20);
		font.drawString("S", 105-30+20, 490+20);
		
		font.setColor(Colors.pastelGreen7);
		font.drawString("MOVE SNAKE", 137-40+20, 525+10);
		
		//UP ARROW
		font.setColor(Colors.pastelGreen);
		font.fillRect(277-50-30, 450+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(280-50-30, 453+20, 20, 20);
		
		//LEFT ARROW
		font.setColor(Colors.pastelGreen);
		font.fillRect(252-50-30, 475+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(255-50-30, 478+20, 20, 20);
		
		//DOWN ARROW
		font.setColor(Colors.pastelGreen);
		font.fillRect(277-50-30, 475+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(280-50-30, 478+20, 20, 20);
		
		//RIGHT ARROW
		font.setColor(Colors.pastelGreen);
		font.fillRect(302-50-30, 475+20, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(305-50-30, 478+20, 20, 20);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.PLAIN, 15));
		font.drawString("<", 257-50-30, 490+20);
		font.drawString(">", 307-50-30, 490+20);

		font.setFont(new Font("Arial", Font.BOLD, 10));
		font.drawString("/\\", 283-50-30, 463+20);
		font.drawString("\\/", 283-50-30, 488+20);
		
		//ESC
		font.setColor(Colors.pastelTeal5);
		font.fillRect(145, 450+20, 23, 13);
		font.setColor(Colors.pastelTeal10);
		font.fillRect(148, 453+20, 20, 10);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 8));
		font.drawString("ESC", 129+20, 460+20);
		
		font.setColor(Colors.pastelTeal16);
		font.setFont(new Font("Arial", Font.BOLD, 12));
		font.drawString("PAUSE", 118+20, 460);
		
		//how to play
		font.setColor(Colors.pastelGreen5);
		font.setFont(new Font("Arial", Font.ITALIC, 20));
		font.drawString("HOW TO PLAY", 340+20, 485);
		font.setColor(Colors.pastelGreen8);
		font.setFont(new Font("Arial", Font.BOLD, 20));
		font.drawString("Eat!", 460+20, 505);
	}
	
	public static void customize(Graphics2D font) {
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Color.darkGray);
		font.drawString("Customize Bricks", 545, 285);
		font.drawString("Customize Ball", 155, 490);
		font.drawString("Customize Paddles", 585, 610);
		
		font.setColor(Colors.pastelBlue8);
		font.drawString("Customize Bricks", 540, 280);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR BRICK COLOR", 220, 318);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Colors.pastelTan8);
		font.drawString("Customize Ball", 150, 485);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR BALL COLOR", 155, 430);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Colors.pastelGreen8);
		font.drawString("Customize Paddles", 580, 605);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR PADDLE COLOR", 270, 643);
		
		//brick colors
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Color.black);
		if (BreakoutRunner.getBrickColor() == "W") {
			font.drawString("W", 351, 285);
		}
		else if (BreakoutRunner.getBrickColor() == "E") {
			font.drawString("E", 415, 285);
		}
		else if (BreakoutRunner.getBrickColor() == "R") {
			font.drawString("R", 465, 285);
		}
		else if (BreakoutRunner.getBrickColor() == "I" || BreakoutRunner.getBrickColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			font.setColor(Color.black);
			font.drawString("I for Default Brick Color", 458, 123);
		}
		
		//ball colors
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Color.black);
		if (BreakoutRunner.getBallColor() == "T") {
			font.drawString("T", 555, 490);
		}
		else if (BreakoutRunner.getBallColor() == "Y") {
			font.drawString("Y", 605, 490);
		}
		else if (BreakoutRunner.getBallColor() == "U") {
			font.drawString("U", 655, 490);
		}
		else if (BreakoutRunner.getBallColor() == "O" || BreakoutRunner.getBallColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			font.setColor(Color.black);
			font.drawString("O for Default Ball Color", 463, 153);
		}
		
		//paddle colors
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Color.black);
		if (BreakoutRunner.getPaddleColor() == "G") {
			font.drawString("G", 405, 610);
		}
		else if (BreakoutRunner.getPaddleColor() == "H") {
			font.drawString("H", 455, 610);
		}
		else if (BreakoutRunner.getPaddleColor() == "J") {
			font.drawString("J", 505, 610);
		}
		else if (BreakoutRunner.getPaddleColor() == "P" || BreakoutRunner.getPaddleColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			font.setColor(Color.black);
			font.drawString("P for Default Paddle Color", 453, 183);
		}
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		
		font.setColor(Colors.pastelTeal7);
		font.drawString("T", 550, 485);
		font.drawString("G", 400, 605);
		
		font.setColor(Colors.pastelBlue7);
		font.drawString("W", 346, 280);
		font.drawString("Y", 600, 485);
		font.drawString("H", 450, 605);
		
		font.setColor(Colors.pastelGreen7);
		font.drawString("E", 410, 280);
		font.drawString("U", 650, 485);
		font.drawString("J", 500, 605);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("R", 460, 280);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		
		font.setColor(Colors.pastelTeal7);
		font.drawString("I for Default Brick Color", 455, 120);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("O for Default Ball Color", 460, 150);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("P for Default Paddle Color", 450, 180);
		
		font.setColor(new Color(205, 205, 205));
		font.drawString("PRESS Q TO GO BACK", 450, 750);
	}
	
	public static void pausedGame(Graphics2D font) {
		font.setColor(Color.darkGray);
		font.fillRect(115, 315, 750, 55);
		font.setColor(Color.gray);
		font.fillRect(110, 310, 750, 55);
		
		font.setColor(Color.darkGray);
		font.fillRect(505, 465, 565, 55);
		font.setColor(Color.gray);
		font.fillRect(500, 460, 565, 55);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(Color.darkGray);
		font.drawString("Press SPACE to Resume Game", 125, 355);
		font.drawString("Press Q to Quit Game", 515, 505);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("Press SPACE to Resume Game", 120, 350);
		font.setColor(Colors.pastelTeal6);
		font.drawString("Press Q to Quit Game", 510, 500);
	}
	
	public static void scoreboard(Graphics2D font) {
		Integer liveScore = BreakoutBall.getLives();
		
		font.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		if (BreakoutRunner.getGameStart() == true) {
			font.setColor(Colors.pastelTan);
			font.drawString("Score: " + score.toString(), 50, 32);
			font.setColor(Colors.pastelTan2);
			font.drawString("Lives: " + liveScore.toString(), 160, 32);
		}
		
		font.setColor(Colors.pastelTan4);
		if (BreakoutRunner.getGameState() == 1) {
			font.drawString("Level: Easy", 270, 32);
		}
		if (BreakoutRunner.getGameState() == 2) {
			font.drawString("Level: Normal", 270, 32);
		}
		if (BreakoutRunner.getGameState() == 3) {
			font.drawString("Level: Hard", 270, 32);
		}
	}
	
	public static void youWinLose(Graphics2D font) {
		font.setColor(Color.white);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		
		if (score == Brick.getNumBricks()) {
			font.drawString("YOU WIN!", 200, 650);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 750);
		}
		
		if (BreakoutBall.getLives() == 0) {
			font.drawString("YOU LOSE!", 200, 650);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 750);
		}
	}
}
