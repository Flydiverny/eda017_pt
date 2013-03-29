package se.markusmaga.lth.pt.snake;

import java.util.*;
import se.lth.cs.pt.dots.Color;
import se.lth.cs.pt.dots.DotWindow_;

public class Snake extends Body {
	private LinkedList<Body> bodyParts;
	private DotWindow_ w;
	private int eatCounter;
	private int dX = 1, dY = 0;
	
	public Snake(DotWindow_ w, int x, int y) {
		super(x, y);
		this.w = w;
		bodyParts = new LinkedList<Body>();
		setColor(Color.RED);
	}
	
	public void forward() {
		//this.clear(w); only needed if theres no body
		
		if(hasEaten()) {
			addBodyPart();
		} else {
			shuffleBody();
		}
		
		this.setLocation(this.getX()+dX, this.getY()+dY); // move head
		this.display(w); 
	}
	
	public void move(int deltaX, int deltaY) {
		this.dX = deltaX;
		this.dY = deltaY;
	}
	
	public boolean hasCollission() {
		if(this.x >= (w.getWidth()) || this.x < 0 || this.y < 0 || this.y >= (w.getHeight())) {
			return true;
		}
		
		for(Body b : bodyParts) {
			if(b.collission(this))
				return true;
		}
		
		return false;
	}
	
	private void shuffleBody() {
		Body body =	bodyParts.poll(); // get first in queue
		if(body != null) {		
			body.clear(w);
			body.setLocation(this.getX(), this.getY()); // move to head
			body.display(w); // display it
			
			bodyParts.offer(body); // add last in queue
		}
	}
	
	private void addBodyPart() {
		Body b = new Body(this.getX(), this.getY());
		Random rng = new Random();
		b.setColor(new Color(rng.nextInt(255),rng.nextInt(255),rng.nextInt(255)));
		b.display(w);
		bodyParts.offer(b);
	}
	
	public void eat(int food) {
		eatCounter += food;
	}
	
	private boolean hasEaten() {
		eatCounter--;
		
		if(eatCounter < 0) {
			eatCounter = 0;
		}
		
		return eatCounter > 0;
	}
	
	public void displaySnake() {
		this.display(w);
		this.eat(3);
	}
}
