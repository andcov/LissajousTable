import java.util.ArrayList;

public class Figures {
	ArrayList<Point> figs = new ArrayList<Point>();
	
	public ArrayList<Point> getFigs() {
		return figs;
	}

	public void setFigs(ArrayList<Point> figs) {
		this.figs = figs;
	}

	public void addPoint(Point p) {
		figs.add(p);
	}
}
