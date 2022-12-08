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
import breakout.BreakoutPaddle;

public class Pages extends Rectangle {
	private static Integer score;
	
	//getter
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
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		font.drawString("Breakout", 350, 300);
		
		font.setColor(Colors.pastelLightGreen);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.drawString("MMORPG", 590, 375);
		
		font.setFont(new Font("Arial", Font.ITALIC, 15));
		font.drawString("Copyright Shelley Wei :)", 520, 415);
		
		font.setColor(Colors.pastelTeal7);
		font.setFont(new Font("Arial", Font.PLAIN, 25));
		font.drawString("PRESS THE CORRESPONDING NUMBER FOR GAME MODE", 250, 460);
		
		font.setColor(Colors.pastelTeal5);
		font.setFont(new Font("Arial", Font.PLAIN, 25));
		font.drawString("PRESS ESCAPE FOR CUSTOMIZATION", 380, 490);
		
		font.setColor(Colors.pastelTeal4);
		font.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		font.drawString("1: EASY", 180, 575);
		
		font.setColor(new Color(14, 144, 117));
		font.drawString("2: NORMAL", 490, 575);
		
		font.setColor(new Color(14, 136, 110));
		font.drawString("3: HARD", 850, 575);
		
		//W
		font.setColor(Color.gray);
		font.fillRect(300, 650, 35, 35);
		font.setColor(Color.white);
		font.fillRect(300, 650, 30, 30);
		
		//A
		font.setColor(Color.gray);
		font.fillRect(260, 690, 35, 35);
		font.setColor(Colors.pastelLightGreen1);
		font.fillRect(260, 690, 30, 30);
		
		//S
		font.setColor(Color.gray);
		font.fillRect(300, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(300, 690, 30, 30);
		
		//D
		font.setColor(Color.gray);
		font.fillRect(340, 690, 35, 35);
		font.setColor(Colors.pastelLightGreen1);
		font.fillRect(340, 690, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("A", 262, 705);
		font.drawString("D", 342, 705);
		
		font.setColor(new Color(167, 232, 187));
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
		font.setColor(Colors.pastelLightGreen1);
		font.fillRect(810, 690, 30, 30);
		
		//DOWN ARROW
		font.setColor(Color.gray);
		font.fillRect(850, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(850, 690, 30, 30);
		
		//RIGHT ARROW
		font.setColor(Color.gray);
		font.fillRect(890, 690, 35, 35);
		font.setColor(Colors.pastelLightGreen1);
		font.fillRect(890, 690, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("<", 812, 705);
		font.drawString(">", 892, 705);
		
		font.setColor(new Color(167, 232, 187));
		font.drawString("PADDLE TO THE LEFT", 670, 670);
		font.drawString("PADDLE TO THE RIGHT", 900, 670);
		
		//ESC
		font.setColor(Color.gray);
		font.fillRect(580, 700, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(580, 700, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 12));
		font.drawString("ESC", 583, 713);
		
		font.setColor(new Color(167, 232, 187));
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
		font.drawString("Customize Ball", 155, 360);
				
		font.setColor(Color.darkGray);
		font.drawString("Customize Paddles", 585, 510);
		
		font.setColor(new Color(229, 209, 180));
		font.drawString("Customize Ball", 150, 355);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR BALL COLOR", 155, 300);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.setColor(new Color(140, 225, 176));
		font.drawString("Customize Paddles", 580, 505);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.drawString("PRESS THE CORRESPONDING LETTER FOR PADDLE COLOR", 270, 543);
		
		if (BreakoutRunner.getBallColor() == "T") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("T", 555, 360);
		}
		else if (BreakoutRunner.getBallColor() == "Y") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("Y", 605, 360);
		}
		else if (BreakoutRunner.getBallColor() == "U") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("U", 655, 360);
		}
		else if (BreakoutRunner.getBallColor() == "O" || BreakoutRunner.getBallColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			font.setColor(Color.black);
			font.drawString("O for Default Ball Color", 463, 193);
		}
		
		if (BreakoutRunner.getPaddleColor() == "G") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("G", 405, 510);
		}
		else if (BreakoutRunner.getPaddleColor() == "H") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("H", 455, 510);
		}
		else if (BreakoutRunner.getPaddleColor() == "J") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("J", 505, 510);
		}
		else if (BreakoutRunner.getPaddleColor() == "P" || BreakoutRunner.getPaddleColor() == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			font.setColor(Color.black);
			font.drawString("P for Default Paddle Color", 463, 223);
		}
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		
		font.setColor(new Color(72, 218, 188));
		font.drawString("T", 550, 355);
		font.drawString("G", 400, 505);
		
		font.setColor(new Color(180, 224, 229));
		font.drawString("Y", 600, 355);
		font.drawString("H", 450, 505);
		
		font.setColor(new Color(171, 232, 219));
		font.drawString("U", 650, 355);
		font.drawString("J", 500, 505);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.setColor(new Color(186, 170, 146));
		font.drawString("O for Default Ball Color", 460, 190);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.setColor(new Color(186, 170, 146));
		font.drawString("P for Default Paddle Color", 460, 220);
		
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		font.setColor(new Color(205, 205, 205));
		font.drawString("PRESS Q TO GO BACK", 450, 700);
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
		
		font.setColor(new Color(229, 209, 180));
		font.drawString("Press SPACE to Resume Game", 120, 350);
		font.setColor(new Color(72, 218, 188));
		font.drawString("Press Q to Quit Game", 510, 500);
	}
	
	public static void scoreboard(Graphics2D font) {
		Integer liveScore = BreakoutBall.getLives();
		
		font.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		if (BreakoutRunner.getGameStart() == true) {
			font.setColor(Colors.pastelTan);
			font.drawString("Score: " + score.toString(), 50, 32);
			font.setColor(Colors.pastelTan2);
			font.drawString("Lives: " + liveScore.toString(), 162, 32);
		}
	}
	
	public static void youWin(Graphics2D font) {
		font.setColor(Color.white);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		
		if (score == Brick.getNumBricks()) {
			font.drawString("YOU WIN!", 200, 500);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 600);
		}
		
		if (BreakoutBall.getLives() == 0) {
			font.drawString("YOU LOSE!", 200, 500);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 600);
		}
	}
	
	public static void switchMode() {
//		if (BreakoutRunner.gameState == 0 && (GDV5.KeysPressed[KeyEvent.VK_1]) {
//			BreakoutRunner.gameState == 1;
//		}
	}
}
