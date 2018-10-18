import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LissajousCurve {
	public static int circleNumX = 10;
	public static int circleNumY = 6;
	public static int space = 30;
	public static int radious = 40;
	
	ArrayList<Circle> circX;
	ArrayList<Circle> circY;
	Figures figs;
	
	public LissajousCurve() {
		circX = new ArrayList<Circle>();
		circY = new ArrayList<Circle>();
		figs = new Figures();
	}
	
	public static void main(String[] args) throws InterruptedException{		
		TimeUnit.SECONDS.sleep(1);
		
		LissajousCurve lj = new  LissajousCurve();
		
		ArrayList<Circle> circlesX = lj.circX;
		ArrayList<Circle> circlesY = lj.circY;
		Figures fig = lj.figs;
		
		for(int i = 0; i < circleNumX; i++) {
			Point p = new Point();
			Circle circle = new Circle(p);
			circle.setRadious(radious);
			circle.setSpeed((i + 1) % (circleNumX));
			if(circle.getSpeed() == 0) {
				circle.setSpeed(circleNumX);
			}
			
			circle.setY(radious);
			circle.setX(space * (i + 1) + radious + 2 * radious * i + 2 * radious);

			circlesX.add(circle);
		}
		
		for(int i = 0; i < circleNumY; i++) {
			Point p = new Point();
			Circle circle = new Circle(p);
			circle.setRadious(radious);
			circle.setSpeed((i + 1) % (circleNumY));
			if(circle.getSpeed() == 0) {
				circle.setSpeed(circleNumY);
			}
			
			circle.setX(radious);
			circle.setY(space * (i + 1) + radious + 2 * radious * i + 2 * radious);

			circlesY.add(circle);
		}
		
		DrawTable t = new DrawTable(circlesX, circlesY, fig);
		
		double speedMultiplier = 0.01;
		
		while(true) {
			for(Circle c : circlesX) {
				int r = c.getRadious();
				double a = c.getPoint().getAngle();
				
				double X, Y;
				
				X = Math.cos(a) * r;
				Y = Math.sin(a) * r;
				
				c.getPoint().setX(X);
				c.getPoint().setY(Y);
				
				a += c.getSpeed() * speedMultiplier;
				
				if(a >= 360.0) {
					a = 0;
				}
				
				c.getPoint().setAngle(a);
			}
			
			for(Circle c : circlesY) {
				int r = c.getRadious();
				double a = c.getPoint().getAngle();
				
				double X, Y;
				
				X = Math.cos(a) * r;
				Y = Math.sin(a) * r;
				
				c.getPoint().setX(X);
				c.getPoint().setY(Y);
				
				a += c.getSpeed() * speedMultiplier;
				
				if(a >= 360.0) {
					a = 0;
				}
				
				c.getPoint().setAngle(a);
			}
			
			Point p;
			for(Circle cx : circlesX) {
				for(Circle cy : circlesY) {
					p = new Point();
					p.setX(cx.getPoint().getX() + cx.getX());
					p.setY(cy.getPoint().getY() + cy.getY());
					
					fig.addPoint(p);
				}
			}
			
			t.repaint();
			
			TimeUnit.MILLISECONDS.sleep(70);
		}
	}
}
