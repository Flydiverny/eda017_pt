package se.markusmaga.lth.pt.snake;

import se.lth.cs.pt.dots.Color;

public class Body {
	protected int x, y;
	protected Color color = Color.BLUE;
	
	public Body(int x, int y) {
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
}
