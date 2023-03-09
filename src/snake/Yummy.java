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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit;

import breakout.BreakoutBall;
import breakout.Brick;
import breakout.Colors;
import breakout.Pages;
import breakout.PowerUp;
import pong.Score;
import snake.SnakeRunner;
import utilities.GDV5;

public class Yummy extends Rectangle {
	//IDEA: if the snake eats smth, then have the next thing slide in ("fall") from the top rather than spawning, have the start and stop place of it be random but it only goes straight downward to the stop place
	
	private static int fStartX = (int) (Math.random() * SnakeRunner.getColumns()) * Tile.getTileSize();
	private static int fStartY = (int) (Math.random() * (SnakeRunner.getRows() - 1)) * Tile.getTileSize() + Tile.getTileSize();
//	private static int fStartY = -30;
//	private static int fEndY;
	
	private int fDirection = 1;


	public Yummy() {
		super(fStartX, fStartY, 0, 0); //when the object is made, it automatically has rectangle object attributes (rectangle object)
		this.setSize(Tile.getTileSize(), Tile.getTileSize());
		
//		this.setfDirection(fDirection);
	}
	
	
	public void spawnFood() { //need to check whether snake is there or not
		fStartX = (int) (Math.random() * SnakeRunner.getColumns()) * Tile.getTileSize();
		fStartY = (int) (Math.random() * (SnakeRunner.getRows() - 1)) * Tile.getTileSize() + Tile.getTileSize();
//		fEndY = (int) (Math.random() * (SnakeRunner.getRows() - 1)) * Tile.getTileSize() + Tile.getTileSize();
		
//		if (this.getY() != fEndY) this.translate(0, Tile.getTileSize());
//		else this.translate(0, 0);
	}


	public int getfX() {
		return fStartX;
	}

	public void setfX(int newfX) {
		fStartX = newfX;
	}

	public int getfY() {
		return fStartY;
	}

	public void setfY(int newfY) {
		fStartY = newfY;
	}
	
	public int getfDirection() {
		return fDirection;
	}

	public void setfDirection(int fDirection) {
		this.fDirection = fDirection;
	}
}