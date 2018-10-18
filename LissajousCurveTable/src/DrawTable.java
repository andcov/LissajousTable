import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
 
public class DrawTable extends JFrame {
   public static final int CANVAS_WIDTH  = 1000;
   public static final int CANVAS_HEIGHT = 1000;
   
   private DrawCanvas canvas;
   
   ArrayList<Circle> circlesX;
   ArrayList<Circle> circlesY;
   Figures fig;
   
   public DrawTable(ArrayList<Circle> circlesX, ArrayList<Circle> circlesY, Figures fig) {
	  this.circlesX = circlesX;
	  this.circlesY = circlesY;
	  this.fig = fig;
	   
      canvas = new DrawCanvas(circlesX, circlesY);
      canvas.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
 
      Container cp = getContentPane();
      cp.add(canvas);
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setTitle("Lissajous Table");
      setVisible(true);
   }

   private class DrawCanvas extends JPanel {
	   
	  ArrayList<Circle> circlesX;
	  ArrayList<Circle> circlesY;
	   
	  private DrawCanvas(ArrayList<Circle> circlesX, ArrayList<Circle> circlesY) {
		  this.circlesX = circlesX;
		  this.circlesY = circlesY;
	  }
	   
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         setBackground(Color.WHITE);
 
         
 			for(Circle c : circlesX) {
 				drawCenteredCircle(g, c.getX(), c.getY(), c.getRadious());
 				g.setColor(Color.RED);
 				g.fillRect((int)c.getPoint().getX() + c.getX(), (int)c.getPoint().getY() + c.getY(), 4, 4);
 				
 				g.setColor(Color.LIGHT_GRAY);
 				g.fillRect((int) c.getPoint().getX() + c.getX(), 0, 1, 1600);
 			}
 			
 			for(Circle c : circlesY) {
 				drawCenteredCircle(g, c.getX(), c.getY(), c.getRadious());
 				g.setColor(Color.RED);
 				g.fillRect((int)c.getPoint().getX() + c.getX(), (int)c.getPoint().getY() + c.getY(), 4, 4);
 				
 				g.setColor(Color.LIGHT_GRAY);
 				g.fillRect(0, (int) c.getPoint().getY() + c.getY(), 2560, 1);
 			}
 			
 			for(Point p : fig.getFigs()) {
 				g.setColor(Color.RED);
 				g.fillRect((int)p.getX(), (int)p.getY(), 1, 1);
 			}
 			
 			g.dispose();
      }
      
      public void drawCenteredCircle(Graphics g, int x, int y, int r) {
	    	      g.setColor(Color.BLACK);
		    	  int X = x - r;
		    	  int Y = y - r;
		    	  g.fillOval(X, Y, 2 * r, 2 * r);
      }
   }
}