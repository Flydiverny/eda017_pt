import se.lth.cs.pt.turtle.visible.Turtle;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class HeartTurtle extends ColorTurtle {
	public HeartTurtle(GraphicsWindow_ w, double x, double y, Color c) {
		super(w, x, y, c);
	}
	
	public void drawHeart() {
		int heartWidth = 100;
		int halfHeart = heartWidth/2;
		int circleRadius = halfHeart/2;
		
		left(90);
		forward(halfHeart);
		left(90);
		
		
		int distance = 3;
		int lastdistance = 0;
		for(int i = 0; i < 25; i++) {
			int steps = 0;
			if(i == 0) 
				steps = distance;
			else
				steps = 3*distance*i;
			drawLine(steps);
			
			// draw 5 px i == 0 -> steps = distance + (2*distance + distance)*i

			// draw 15 px up -> steps = distance + (2*distance)*i 

			// draw 30 px down -> steps = distance + (2*distance)*i + distance

			// draw 45 px up -> step = (2*distance + distance)*i i == 3
			
			if(i % 2 == 0)
				increasingRotation(distance*2, true);
			else
				increasingRotation((int)(distance*0.9), false);
		}
	}
	
	public void drawLine(int distance) {
		penDown();
		forward(distance);
	}
	
	private void increasingRotation(int steps, boolean left) {
		int deg = left ? 90 : -90;
		penUp();
		forward(steps);
		this.left(deg);
		forward(this.lineWidth);
		this.left(deg);
	}
}