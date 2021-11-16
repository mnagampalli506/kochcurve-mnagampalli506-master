import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author
 * @version
 */
public class KochCurve {

	private double length;
	private int level;
	private double x;
	private double y;
	private double angle;

	public KochCurve(int level, double length,double x,double y,double angle) {
		this.length = length;
		this.level = level;
		this.x=x;
		this.y=y;
		this.angle=angle;

	}

	public void draw(PApplet marker) {
		drawKochCurve(length, angle, marker, x, y, level);
	}

	private void drawKochCurve(double length, double angle, PApplet drawer, double x, double y, int level) {
		if (level < 1) {
			double endX = x + length * Math.cos(angle);
			double endY = y + length * Math.sin(angle);

			drawer.line((float) x, (float) y, (float) endX, (float) endY);
		} else {
			drawKochCurve(length / 3, angle, drawer, x, y, level - 1);

			x = x + ((length / 3) * Math.cos(angle));
			y = y + ((length / 3) * Math.sin(angle));
			angle = angle - 60 * Math.PI / 180;
			drawKochCurve(length / 3, angle, drawer, (float) (x), (float) (y), level - 1);

			x = x + ((length / 3) * Math.cos(angle));
			y = y + ((length / 3) * Math.sin(angle));
			angle = angle + 120 * Math.PI / 180;
			drawKochCurve(length / 3, angle, drawer, (float) (x), (float) (y), level - 1);

			x = x + ((length / 3) * Math.cos(angle));
			y = y + ((length / 3) * Math.sin(angle));
			angle = angle - 60 * Math.PI / 180;
			drawKochCurve(length / 3, angle, drawer, (float) (x), (float) (y), level - 1);
		}

	}

}
