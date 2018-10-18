
public class Circle {
	Point point = new Point();
	
	public int speed;
	
	public int x;
	
	public int y;
	
	public int radious;
	
	public int getRadious() {
		return radious;
	}
	public void setRadious(int radious) {
		this.radious = radious;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Circle(Point point) {
		this.point = point;
	}
	
	public void printCircle() {
		System.out.println("Radious: " + radious + "; " + "[x, y]: [" + x + ", " + y + "]; " + "Speed: " + 
				speed + "; " + "Angle: " + point.getAngle() + "; " + "[x, y]: [" + point.getX() + ", " + point.getY() + "]");
	}
	
}
