import se.lth.cs.pt.turtle.visible.Turtle;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class GoalTurtle extends Turtle {
	protected Color mainColor = Color.BLACK;
	protected Color altColor = Color.WHITE;

	public GoalTurtle(GraphicsWindow_ w, double x, double y) {
		super(w, x, y);
		this.lineWidth = 5;
	}
	
	public void setLineWidth(int width) {
		this.lineWidth = width;
	}
	
	public void drawGoal(int distance) {
		int blocks = distance / this.lineWidth;
		
		penDown();
		
		goalDrawer(blocks);
		

		goalRotation(blocks);
		
		goalDrawer(blocks);
		
		penUp();
	}
	
	private void goalDrawer(int blocks) {
		for(int i = 0; i < blocks; i++) {
			super.forward(this.lineWidth);
			
			switchColor(i);
		}
	}
	
	private void switchColor(int block) {
		if(block % 2 == 0) 
			this.lineColor = altColor;
		else
			this.lineColor = mainColor;
	}
	
	private void goalRotation(int blocks) {
		switchColor(blocks);
	
		this.left(90);
		super.forward(this.lineWidth);
		this.left(90);
		super.forward(this.lineWidth);
	}
}