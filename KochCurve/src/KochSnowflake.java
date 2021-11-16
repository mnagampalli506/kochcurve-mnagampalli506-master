import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author
 * @version
 */
public class KochSnowflake extends KochCurve {

	private int level;
	private double length;
	private double x;
	private double y;
	private double angle;

	public KochSnowflake(int level, double length, double x, double y, double angle) {
		super(level, length, x, y, angle);
		this.level = level;
		this.length = length;
		this.x = x;
		this.y = y;
		this.angle = angle;

	}

	public void draw(PApplet marker) {
		KochCurve curve = new KochCurve(level, length/3, x, y, 0);
		curve.draw(marker);
		double startX = x+((length / 3) * Math.cos(angle));
		double startY= y + ((length / 3) * Math.sin(angle));
		double lineAngle = angle - 120 * Math.PI / 180;

		KochCurve curve1 = new KochCurve(level, length/3, startX , startY, lineAngle);
		curve1.draw(marker);
		double startX1 = startX+((length / 3) * Math.cos(lineAngle));
		double startY2= startY + ((length / 3) * Math.sin(lineAngle));
		double lineAngle1 = lineAngle -120 * Math.PI / 180;
		KochCurve curve2 = new KochCurve(level, length/3, startX1 , startY2, lineAngle1);
		curve2.draw(marker);

	}

}
