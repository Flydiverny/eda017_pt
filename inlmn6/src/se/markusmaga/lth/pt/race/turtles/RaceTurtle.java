package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.turtle.visible.Turtle;
import se.lth.cs.pt.die.Die;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public abstract class RaceTurtle extends Turtle {
	private static final int DEFAULT_DIE = 6;
	
	private int startNumber;
	protected Die die;
	private int amountOfSteps = 0;
		
	protected RaceTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		this(w, x, y, startNumber, DEFAULT_DIE);
	}
	
	protected RaceTurtle(GraphicsWindow_ w, double x, double y, int startNumber, int dieSize) {
		super(w, x, y);
		
		die = new Die(dieSize);
		this.startNumber = startNumber;
		
		left(90);
		penDown();
	}
	
	public int getStartNumber() {
		return this.startNumber;
	}
	
	protected int getNextStep() {
		die.roll();
		amountOfSteps++;
		return die.getNbrOfSpots();
	}
	
	public int getAmountOfSteps() {
		return this.amountOfSteps;
	}
	
	public abstract void raceStep();
	
	public abstract String getType();
	
	public String toString() {
		return "Numer " + getStartNumber() + " (" + getType() + ")";
	}
}