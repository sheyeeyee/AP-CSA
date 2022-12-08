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
	static Particles[] particlesArray;
	
	//colors
	private Color col;
	
	//array of colors for particles
	private static Color[] colors = {Colors.pastelTeal1, Colors.pastelTeal2, Colors.pastelTeal3, 
			Colors.pastelTeal4, Colors.pastelTeal5, Colors.pastelTeal6, Colors.pastelTeal7, 
			Colors.pastelTeal8, Colors.pastelTeal9};
	
	//particle position
	private static int partX = Brick.getBX();
	private static int partY = Brick.getBX();
	
	//particle speed
	private static int partVX;
	private static int partVY;
	
	//# of particles
	private static int particlesNum = 35;
	
	//particle size
	private static int partSize = 5;
		
		
	//particle constructor
	public Particles(int x, int y, Color c) {
		super(x, y, partSize, partSize);
		col = c;
	}
	
	//setters
	public void setColor(Color newColor) {
		col = newColor;
	}
	
	//method to create particles
	public static void makeParticles(Brick brickArray) {
		int count = 0;
		
		particlesArray = new Particles[particlesNum];
		
		for (int i = 0; i < particlesArray.length; i++) {
			particlesArray[i] = new Particles(partX, partY, brickArray.getColor());
			partX += (2 * partSize);
			count++;
			
			if (count % (particlesNum / 3) == 0) {
				partX += (2 * partSize);
				partY += partSize;
			}
		}
	}
	
	public void move() {
		if (Math.random() < 0.5) partVX = 1;
		if (Math.random() > 0.5) partVX = -1;
		if (Math.random() < 0.5) partVY = 1;
		if (Math.random() > 0.5) partVY = -1;
		this.x += partVX;
		this.y += partVY;
	}
	
	public static void moveParticles() {
		for (Particles p:particlesArray) {
			p.move();
		}
	}
	
	//draw particles method
	public void draw(Graphics2D pb) {
		pb.setColor(col);
		pb.fill(this);
	}
}
