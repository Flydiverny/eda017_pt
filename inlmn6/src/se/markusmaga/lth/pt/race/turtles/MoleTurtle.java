package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class MoleTurtle extends RaceTurtle {
	private static final int CHANCE_TO_HIDE = 20;
	private static final int CHANCE_TO_SURFACE = 40;
	
	protected Color lineColor = new Color(139, 69, 19); //brown
	
	public MoleTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		super(w, x, y, startNumber);
	}
	
	@Override
	public void raceStep() {
		int steps = getNextStep();
		forward(steps);
	}
	
	@Override
	public String getType() {
		return "MoleTurtle";
	}
}