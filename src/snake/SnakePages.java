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
		
		font.setColor(new Color(1, 69, 60));
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		font.drawString("MMORPG", 300, 230);

		font.setColor(Colors.pastelGreen8);
		font.setFont(new Font("Arial", Font.ITALIC, 15));
		font.drawString("Copyright Shelley Wei :)", 215, 260);
		
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
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
		font.setColor(Color.darkGray);
		font.drawString("Customize Snake", 545/2, 285);
		font.drawString("Customize Board", 155/2, 490);
		
		font.setColor(Colors.pastelBlue8);
		font.drawString("Customize Snake", 540/2, 280);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR SNAKE COLOR", 220/2, 318);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
		font.setColor(Colors.pastelTan8);
		font.drawString("Customize Board", 150/2, 485);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR BOARD COLOR", 155/2, 430);
		
//		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
//		font.setColor(Colors.pastelGreen8);
//		font.drawString("Customize Paddles", 580/2, 605);
//		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
//		font.drawString("PRESS THE CORRESPONDING LETTER FOR PADDLE COLOR", 270/2, 643);
		
		//snake colors
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
		font.setColor(Color.black);
		if (SnakeRunner.getSnakeColor() == "W") {
			font.drawString("W", 351/2, 285);
		}
		else if (SnakeRunner.getSnakeColor() == "E") {
			font.drawString("E", 415/2, 285);
		}
		else if (SnakeRunner.getSnakeColor() == "R") {
			font.drawString("R", 465/2, 285);
		}
		else if (SnakeRunner.getSnakeColor() == "I" || SnakeRunner.getSnakeColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
			font.setColor(Color.black);
			font.drawString("I for Default Snake Color", 458/2, 123);
		}
		
		//board colors
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
		font.setColor(Color.black);
		if (SnakeRunner.getBoardColor() == "T") {
			font.drawString("T", 555/2, 490);
		}
		else if (SnakeRunner.getBoardColor() == "Y") {
			font.drawString("Y", 605/2, 490);
		}
		else if (SnakeRunner.getBoardColor() == "U") {
			font.drawString("U", 655/2, 490);
		}
		else if (SnakeRunner.getBoardColor() == "O" || SnakeRunner.getBoardColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
			font.setColor(Color.black);
			font.drawString("O for Default Board Color", 463/2, 153);
		}
		
		//paddle colors
//		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
//		font.setColor(Color.black);
//		if (BreakoutRunner.getPaddleColor() == "G") {
//			font.drawString("G", 405/2, 610);
//		}
//		else if (BreakoutRunner.getPaddleColor() == "H") {
//			font.drawString("H", 455/2, 610);
//		}
//		else if (BreakoutRunner.getPaddleColor() == "J") {
//			font.drawString("J", 505/2, 610);
//		}
//		else if (BreakoutRunner.getPaddleColor() == "P" || BreakoutRunner.getPaddleColor() == "") {
//			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
//			font.setColor(Color.black);
//			font.drawString("P for Default Paddle Color", 453/2, 183);
//		}
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
		
		font.setColor(Colors.pastelTeal7);
		font.drawString("T", 550/2, 485);
//		font.drawString("G", 400/2, 605);
		
		font.setColor(Colors.pastelBlue7);
		font.drawString("W", 346/2, 280);
		font.drawString("Y", 600/2, 485);
//		font.drawString("H", 450/2, 605);
		
		font.setColor(Colors.pastelGreen7);
		font.drawString("E", 410/2, 280);
		font.drawString("U", 650/2, 485);
//		font.drawString("J", 500/2, 605);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("R", 460/2, 280);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25/2));
		
		font.setColor(Colors.pastelTeal7);
		font.drawString("I for Default Snake Color", 458/2, 120);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("O for Default Board Color", 463/2, 150);
		
//		font.setColor(Colors.pastelTan7);
//		font.drawString("P for Default Paddle Color", 450/2, 180);
		
		font.setColor(new Color(205, 205, 205));
		font.drawString("PRESS Q TO GO BACK", 450/2, 750);
	}
	
	public static void pausedGame(Graphics2D font) {
		font.setColor(Color.darkGray);
		font.fillRect(115/2, 315/2+100, 750/2, 55/2);
		font.setColor(Color.gray);
		font.fillRect(110/2, 310/2+100, 750/2, 55/2);
		
		font.setColor(Color.darkGray);
		font.fillRect(505/2, 465/2+100, 565/2, 55/2);
		font.setColor(Color.gray);
		font.fillRect(500/2, 460/2+100, 565/2, 55/2);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50/2));
		font.setColor(Color.darkGray);
		font.drawString("Press SPACE to Resume Game", 125/2, 355/2+100);
		font.drawString("Press Q to Quit Game", 515/2, 505/2+100);
		
		font.setColor(Colors.pastelTan7);
		font.drawString("Press SPACE to Resume Game", 120/2, 350/2+100);
		font.setColor(Colors.pastelTeal9);
		font.drawString("Press Q to Quit Game", 510/2, 500/2+100);
	}
	
	public static void scoreboard(Graphics2D font) {		
		font.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		if (SnakeRunner.isGameStart() == true) {
			font.setColor(Color.white);
			font.drawString("Score: " + score.toString(), 30, 20);
		}
		
		if (SnakeRunner.getGameState() == 1) {
			font.drawString("Level: Easy", 530, 20);
		}
		if (SnakeRunner.getGameState() == 2) {
			font.drawString("Level: Normal", 512, 20);
		}
		if (SnakeRunner.getGameState() == 3) {
			font.drawString("Level: Hard", 528, 20);
		}
	}
	
	public static void youWinLose(Graphics2D font) {
		font.setColor(Color.white);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		
		if (score == SnakeRunner.getNumTiles()) {
			font.drawString("YOU WIN!", 200, 650);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
			font.drawString("Press ENTER to Leave the Game", 110, 750);
		}
		
		if (!Tile.getSnakeAlive()) {
			font.drawString("YOU LOSE!", 190, 200);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
			font.drawString("Press ENTER to Leave the Game", 110, 250);
		}
	}
}