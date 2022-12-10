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
import breakout.Brick;

public class Particles extends Rectangle {
	private static Particles[] particlesArray;
	
	//colors
	private Color col;
	private int counter;
	
	//particle visibility
	private boolean partVis = true;
	
	//array of colors for particles
	private static Color[] colors = {Colors.pastelTeal1, Colors.pastelTeal2, Colors.pastelTeal3, 
			Colors.pastelTeal4, Colors.pastelTeal5, Colors.pastelTeal6, Colors.pastelTeal7, 
			Colors.pastelTeal8, Colors.pastelTeal9};
	
	//particle position
	private static int partX = Brick.getBX();
	private static int partY = Brick.getBX();
	
	//# of columns
	private static int columns = Brick.getBWidth() / 5;
	private static int rows = Brick.getBHeight() / 5;
	
	//particle speed
	private static int partVX;
	private static int partVY;
	
	//# of particles
	private static int particlesNum = columns * rows;
	
	//particle size
	private static int partSize = 5;
		
		
	//particle constructor
	public Particles(int x, int y, Color c) {
		super(x, y, partSize, partSize);
		col = c;
		this.counter = 0;
	}
	
	//getters and setters
	public void setColor(Color newColor) {
		col = newColor;
	}
	public static int getPartNum() {
		return particlesNum;
	}
	
	//method to create particles
	public static Particles[] makeParticles(Brick brickObject) {
		int count = 0;
		
		partX = (int) brickObject.getX();
		partY = (int) brickObject.getY();
		
		//create particle array
		particlesArray = new Particles[particlesNum];
		
		for (int i = 0; i < particlesArray.length; i++) {
			particlesArray[i] = new Particles(partX, partY, brickObject.getColor());
			partX += partSize;
			count++;
			
			if (count % columns == 0) {
				partX -= brickObject.getBWidth();
				partY += partSize;
			}
		}
		return particlesArray;
	}
	
	public void move() {
		if (this.counter % 120 == 0) {
			if (Math.random() < 0.5) partVX = 1;
			if (Math.random() > 0.5) partVX = -1;
			if (Math.random() < 0.5) partVY = 1;
			if (Math.random() > 0.5) partVY = -1;
			this.translate(partVX, partVY);
		}
		this.counter++;
	}
	
	public static void moveParticles() {
		for (Particles p:particlesArray) {
			p.move();
		}
	}
	
	//draw particles method
	public void draw(Graphics2D pb) {
		if (partVis) {
			pb.setColor(col);
			pb.fill(this);
		}
	}
}
