package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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

import pong.Score;
import utilities.GDV5;

public class SnakeRunner extends GDV5 {
	//create variable for max window sizes
	private static int winX = GDV5.getMaxWindowX();
	private static int winY = GDV5.getMaxWindowY();
	
	public static Tile[] board;
	
	public static void main(String[] args) {
		SnakeRunner runner = new SnakeRunner();
		runner.start();
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D win) {
		board = Tile.makeBoard();
		for (Tile t:board) {
			t.draw(win);
		}
	}
}
