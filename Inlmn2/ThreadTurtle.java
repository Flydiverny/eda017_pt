import se.lth.cs.pt.turtle.visible.Turtle;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;
import se.lth.cs.pt.die.Die;

public class ThreadTurtle extends Turtle implements Runnable {
	public static Die d = new Die(6);

	public ThreadTurtle(GraphicsWindow_ w, double x, double y, Color c) {
		super(w, x, y);
		this.lineColor = c;
	}
	
	public void run() {
		d.roll();
		this.forward(d.getNbrOfSpots());
	}	
}