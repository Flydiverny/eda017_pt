package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.turtle.Turtle;
import se.lth.cs.pt.die.Die;
import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public abstract class RaceTurtle extends Turtle implements Comparable<RaceTurtle> {
	private static final int DEFAULT_DIE = 12;
	private static final int DEFAULT_SPEED = 5;

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
		//setSpeed(2000);
		right(90);
		penDown();
		
		//setSpeed(DEFAULT_SPEED);
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
	
	public abstract Color getColor();
	
	public String toString() {
		return "Number " + getStartNumber() + " (" + getType() + ")";
	}
	
	public void forward(int distance)
	{
		double d1 = this.x;
		double d2 = this.y;
		this.x += distance * Math.cos(Math.toRadians(this.dir));
		this.y -= distance * Math.sin(Math.toRadians(this.dir));
		
		if (this.draws)
		  this.w.drawLine(d1, d2, this.x, this.y, 2.0D, this.getColor());
	}
	
	@Override
	public int compareTo(RaceTurtle rt) {
		return getAmountOfSteps()-rt.getAmountOfSteps();
	}
}