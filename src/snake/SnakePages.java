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
		font.setColor(Color.gray);
		font.fillRect(100, 450, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(103, 453, 20, 20);
		
		//A
		font.setColor(Color.gray);
		font.fillRect(75, 475, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(78, 478, 20, 20);
		
		//S
		font.setColor(Color.gray);
		font.fillRect(100, 475, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(103, 478, 20, 20);
		
		//D
		font.setColor(Color.gray);
		font.fillRect(125, 475, 23, 23);
		font.setColor(Colors.pastelGreen10);
		font.fillRect(128, 478, 20, 20);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("A", 70, 480);
		font.drawString("D", 342, 705);
		
		font.setColor(Colors.pastelGreen7);
		font.drawString("PADDLE TO THE LEFT", 120, 670);
		font.drawString("PADDLE TO THE RIGHT", 350, 670);
		
		//UP ARROW
		font.setColor(Color.gray);
		font.fillRect(850, 650, 35, 35);
		font.setColor(Color.white);
		font.fillRect(850, 650, 30, 30);
		
		//LEFT ARROW
		font.setColor(Color.gray);
		font.fillRect(810, 690, 35, 35);
		font.setColor(Colors.pastelGreen9);
		font.fillRect(810, 690, 30, 30);
		
		//DOWN ARROW
		font.setColor(Color.gray);
		font.fillRect(850, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(850, 690, 30, 30);
		
		//RIGHT ARROW
		font.setColor(Color.gray);
		font.fillRect(890, 690, 35, 35);
		font.setColor(Colors.pastelGreen9);
		font.fillRect(890, 690, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("<", 812, 705);
		font.drawString(">", 892, 705);
		
		font.setColor(Colors.pastelGreen7);
		font.drawString("PADDLE TO THE LEFT", 670, 670);
		font.drawString("PADDLE TO THE RIGHT", 900, 670);
		
		//ESC
		font.setColor(Color.gray);
		font.fillRect(580, 700, 35, 35);
		font.setColor(Colors.pastelGreen9);
		font.fillRect(580, 700, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 12));
		font.drawString("ESC", 583, 713);
		
		font.setColor(Colors.pastelGreen7);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("PAUSE", 570, 690);
		
		//how to play
		font.setColor(Colors.pastelTeal5);
		font.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		font.drawString("HOW TO PLAY: Break all of the bricks!", 420, 815);
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
