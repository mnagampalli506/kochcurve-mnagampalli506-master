import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;


public class DrawingSurface extends PApplet {

	private KochCurve curve;
	private int level, length;
	private KochSnowflake snowflake;
	
	public DrawingSurface() {
		level = 0;
		length = 100;
		curve = new KochCurve (level,length,100,100,0);
		snowflake = new KochSnowflake(level,length,300,300,0);
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		
		textSize(12);
		fill(0);
		text("Use the mouse wheel to change length, use UP/DOWN keys to change level.",0,15);
		
		stroke(0);
		curve.draw(this);	
		snowflake.draw(this);
		
	}
	
	
	public void mouseWheel(MouseEvent event) {
		  int num = event.getCount();
		  length -= num*10;
		 curve = new KochCurve(level,length,100,100,0);
		 snowflake = new KochSnowflake(level,length,300,300,0);
	}
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			level++;
			curve = new KochCurve(level,length,100,100,0);
			snowflake = new KochSnowflake(level,length,300,300,0);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			level--;
			curve = new KochCurve(level,length,100,100,0);
			snowflake = new KochSnowflake(level,length,300,300,0);
		}
	}
	
	
}










