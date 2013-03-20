package se.markusmaga.lth.pt.snake;

import java.util.*;
import se.lth.cs.pt.dots.Color;
import se.lth.cs.pt.dots.DotWindow_;

public class Snake extends Body {
	private LinkedList<Body> bodyParts;
	protected Color color = Color.RED;
	
	public Snake(int x, int y) {
		super(x, y);
		body = new LinkedList<Body>();
	}
	
	private void move(DotWindow_ w) {
		Body body =	bodyParts.pollLast();
		
		w.setDot(body.getX(), b.getY(), Color.WHITE);

		w.setDot(this.getX(), this.getY(), body.getColor());
		
	}
	
	public void display(DotWindow_ w) {
		w.setDot(this.getX(), this.getY(), this.getColor());
	
		for(Body b : body) {
			w.setDot(b.getX(), b.getY(), b.getColor());
		}
	}
}
