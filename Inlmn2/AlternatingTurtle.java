import se.lth.cs.pt.turtle.visible.Turtle;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class AlternatingTurtle extends Turtle {
	protected Color mainColor;
	protected Color altColor;

	public AlternatingTurtle(GraphicsWindow_ w, double x, double y) {
		this(w, x, y, Color.BLACK, Color.WHITE);
	}
	
	public AlternatingTurtle(GraphicsWindow_ w, double x, double y, Color mC, Color aC) {
		super(w, x, y);
		this.lineWidth = 5;
		this.lineColor = mC;
		this.mainColor = mC;
		this.altColor = aC;
	}
	
	public void setLineWidth(int width) {
		this.lineWidth = width;
	}
	
	public void forward(int distance) {
		if(!draws) {
			super.forward(distance);
			return;
		}
		
		int blocks = distance / this.lineWidth;
		alternatingDrawer(blocks);
	}
	
	public void drawGoal(int distance) {
		penDown();
		int blocks = distance / this.lineWidth;
		alternatingDrawer(blocks);
		goalRotation(blocks);
		alternatingDrawer(blocks);
		penUp();
	}
	
	private void alternatingDrawer(int blocks) {
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