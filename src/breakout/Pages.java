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

public class Pages {
	public static void home(Graphics2D font) {
		font.setColor(Color.white);
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		font.drawString("Breakout", 350, 300);
		
		font.setColor(new Color(171, 232, 219));
		font.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		font.drawString("MMORPG", 590, 375);
		
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
	
	public static void game(Graphics2D font) {
		
	}
	
	public static void switchMode() {
//		if (BreakoutRunner.gameState == 0 && (GDV5.KeysPressed[KeyEvent.VK_1]) {
//			BreakoutRunner.gameState == 1;
//		}
	}
}
