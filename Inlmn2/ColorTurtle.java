import se.lth.cs.pt.turtle.visible.Turtle;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class ColorTurtle extends Turtle {
	public ColorTurtle(GraphicsWindow_ w, double x, double y, Color c) {
		super(w, x, y);
		this.lineColor = c;
	}
}