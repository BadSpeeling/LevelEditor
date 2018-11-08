package General;

public class Coordinate {
	
	private double x;
	private double y;
	
	public Coordinate (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX () {
		return (int)x;
	}
	
	public int getY () {
		return (int)y;
	}
	
	public void translate (double dx, double dy) {
		x += dx;
		y += dy;
	}
	
}
