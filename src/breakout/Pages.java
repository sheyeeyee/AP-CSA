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
	private static int score;
	
	//getter
	public static int getScore() {
		return score;
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
		font.fillRect(590, 700, 35, 35);
		font.setColor(new Color(167, 232, 187));
		font.fillRect(590, 700, 30, 30);
		
		font.setColor(Color.black);
		font.setFont(new Font("Arial", Font.BOLD, 12));
		font.drawString("ESC", 593, 713);
		
		font.setColor(new Color(167, 232, 187));
		font.setFont(new Font("Arial", Font.BOLD, 15));
		font.drawString("PAUSE", 580, 690);
		
		//how to play
		font.setColor(Colors.pastelTeal5);
		font.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		font.drawString("HOW TO PLAY: Break all of the bricks!", 420, 815);
	}
	
	public static void game(Graphics2D font) {
		
	}
	
	public static void switchMode() {
//		if (BreakoutRunner.gameState == 0 && (GDV5.KeysPressed[KeyEvent.VK_1]) {
//			BreakoutRunner.gameState == 1;
//		}
	}
}
