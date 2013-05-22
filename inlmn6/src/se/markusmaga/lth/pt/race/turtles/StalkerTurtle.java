package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class StalkerTurtle extends RaceTurtle {
	private static final int CHANCE_TO_HIDE = 20;
	private static final int CHANCE_TO_SURFACE = 40;
	
	private RaceTurtle target;
	
	public StalkerTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		this(w, x, y, startNumber, null);
	}
	
	public StalkerTurtle(GraphicsWindow_ w, double x, double y, int startNumber, RaceTurtle target) {
		super(w, x, y, startNumber);
		
		this.target = target;
	}
	
	public void stalk(RaceTurtle target) {
		this.target = target;
	}
	
	public boolean hasTarget() {
		return this.target != null;
	}
	
	@Override
	public Color getColor() {
		return new Color(255, 105, 180); //pink
	}
	
	@Override
	public void raceStep() {
		double dx = target.getX() - this.getX();
		double dy = target.getY() - this.getY();

		int newAngle = (int)Math.toDegrees(Math.atan2(dy, dx));
		right(dir+newAngle);

		forward(getNextStep());
	}
	
	@Override
	public String getType() {
		return "StalkerTurtle -- Stalking number " + target.getStartNumber();
	}
}