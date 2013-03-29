package se.markusmaga.lth.pt.snake;

import se.lth.cs.pt.dots.Color;
import se.lth.cs.pt.dots.DotWindow_;

public class Body {
	protected int x, y;
	protected Color color = Color.BLUE;
	
	public Body(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void display(DotWindow_ w) {
		if(x < 0 || y < 0 || x >= w.getWidth() || y >= w.getHeight()) return; // dont try to draw if its a retarded position
		
		w.setDot(this.getX(), this.getY(), this.getColor());
	}
	
	public void clear(DotWindow_ w) {
		w.setDot(this.getX(), this.getY(), Color.WHITE);
	}
	
	public boolean collission(Body b) {
		return (this.x == b.x && this.y == b.y);
	}
}
