package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Font;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Score {
	static Integer score1 = 0;
	static Integer score2 = 0;
	static Integer scoreAI = 0;
	
	//CHALLENGE 4
	public static void splash(Graphics2D font) {
		font.setColor(Color.white);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		font.drawString("Pong", 450, 300);
		
		font.setColor(new Color(171, 232, 219));
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.drawString("MMORPG", 550, 375);
		
		font.setFont(new Font("Arial", Font.ITALIC, 15));
		font.drawString("Copyright Shelley Wei :)", 520, 415);
		
		font.setColor(new Color(72, 218, 188));
		font.setFont(new Font("Arial", Font.PLAIN, 25));
		font.drawString("PRESS THE CORRESPONDING NUMBER FOR GAME MODE", 250, 460);
		
		font.setColor(new Color(23, 185, 151));
		font.setFont(new Font("Arial", Font.PLAIN, 25));
		font.drawString("PRESS ESCAPE FOR CUSTOMIZATION", 380, 490);
		
		font.setColor(new Color(14, 162, 131));
		font.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		font.drawString("1: EASY", 75, 575);
		
		font.setColor(new Color(14, 144, 117));
		font.drawString("2: NORMAL", 320, 575);
		
		font.setColor(new Color(14, 136, 110));
		font.drawString("3: AI", 630, 575);
		
		font.setColor(new Color(14, 133, 106));
		font.drawString("4: SMASH BALL", 820, 575);
		font.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		font.drawString("(smash the ball down)", 873, 600);
		
		//W
		font.setColor(Color.gray);
		font.fillRect(300, 650, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(300, 650, 30, 30);
		
		//A
		font.setColor(Color.gray);
		font.fillRect(260, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(260, 690, 30, 30);
		
		//S
		font.setColor(Color.gray);
		font.fillRect(300, 690, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(300, 690, 30, 30);
		
		//D
		font.setColor(Color.gray);
		font.fillRect(340, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(340, 690, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("W", 302, 665);
		font.drawString("S", 302, 705);
		
		font.setColor(new Color(167, 232, 187));
		font.drawString("LEFT PADDLE UP", 255, 640);
		font.drawString("LEFT PADDLE DOWN", 240, 747);
		
		//UP ARROW
		font.setColor(Color.gray);
		font.fillRect(850, 650, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(850, 650, 30, 30);
		
		//LEFT ARROW
		font.setColor(Color.gray);
		font.fillRect(810, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(810, 690, 30, 30);
		
		//DOWN ARROW
		font.setColor(Color.gray);
		font.fillRect(850, 690, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(850, 690, 30, 30);
		
		//RIGHT ARROW
		font.setColor(Color.gray);
		font.fillRect(890, 690, 35, 35);
		font.setColor(Color.white);
		font.fillRect(890, 690, 30, 30);
		
		//CHALLENGE 5
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("/\\", 852, 665);
		font.drawString("\\/", 852, 705);
		
		font.setColor(new Color(167, 232, 187));
		font.drawString("RIGHT PADDLE UP", 800, 640);
		font.drawString("RIGHT PADDLE DOWN", 785, 747);
		
		//ESC
		font.setColor(Color.gray);
		font.fillRect(590, 670, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(590, 670, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 12));
		font.drawString("ESC", 593, 683);
		
		font.setColor(new Color(167, 232, 187));
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("PAUSE", 580, 660);
		
		//how to play
		font.setColor(new Color(72, 218, 188));
		font.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		font.drawString("HOW TO PLAY: Beat your opponent by keeping the ball in the window and being the first to score 10 points!", 85, 785);
	}
	
	public static void menu(Graphics2D font) {
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
		
		if (PongRunner.ballColor == "T") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("T", 555, 360);
		}
		else if (PongRunner.ballColor == "Y") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("Y", 605, 360);
		}
		else if (PongRunner.ballColor == "U") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("U", 655, 360);
		}
		else if (PongRunner.ballColor == "O" || PongRunner.ballColor == "") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			font.setColor(Color.black);
			font.drawString("O for Default Ball Color", 463, 193);
		}
		
		if (PongRunner.paddleColor == "G") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("G", 405, 510);
		}
		else if (PongRunner.paddleColor == "H") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("H", 455, 510);
		}
		else if (PongRunner.paddleColor == "J") {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			font.setColor(Color.black);
			font.drawString("J", 505, 510);
		}
		else if (PongRunner.paddleColor == "P" || PongRunner.paddleColor == "") {
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
		font.setColor(new Color(229, 209, 180));
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		
		//score1
		if (PongRunner.gameState == 1 || PongRunner.gameState == 4) {
			font.drawString(Score.score1.toString(), 260, 300);
		}
		if (PongRunner.gameState == 3) {
			font.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			font.drawString("Paddle Hits: " + Score.scoreAI.toString(), 190, 290);
		}
		
		//score2
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		font.drawString(score2.toString(), 880, 300);
		
		font.setColor(Color.black);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		
		if (Score.score1 == 10) {
			font.drawString("LEFT PLAYER WINS!", 200, 500);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 600);
		}
		if ((Score.score2 == 10 && PongRunner.gameState == 1) || (Score.score2 == 10 && PongRunner.gameState == 4)) {
			font.drawString("RIGHT PLAYER WINS!", 180, 500);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 600);
		}
		if (Score.score2 == 10 && PongRunner.gameState == 3) {
			font.drawString("RIGHT PLAYER WINS!", 180, 500);
			font.setColor(Color.darkGray);
			font.setFont(new Font("Comic Sans MS", Font.ITALIC, 50));
			font.drawString("Press ENTER to Leave the Game", 220, 600);
			font.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			font.drawString("nt, nt, better luck next time?", 440, 700);
		}
	}
}