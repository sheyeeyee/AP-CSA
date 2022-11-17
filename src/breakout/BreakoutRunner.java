package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import utilities.GDV5;

public class BreakoutRunner extends GDV5 {
	private Brick[] bricks;
	
	public BreakoutRunner() {
		super();
		bricks = Brick.makeBricks();
	}
	
	public static void main(String[] args) {
		BreakoutRunner b = new BreakoutRunner();
		b.start();
	}

	//bc of this, no loops needed since these are being called continuously
	@Override
	public void update() { //60 fps, driver called 60 times per second
		
	}

	@Override
	public void draw(Graphics2D win) { //at the processor speed (~3000 fps, called 3000 times per second)
		for (Brick b:bricks) {
			b.draw(win);
		}
	}
}
