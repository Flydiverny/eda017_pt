package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class SeriousRacerTurtle extends RaceTurtle {
	
	protected Color lineColor = new Color(255, 0, 0); //red
	
	public SeriousRacerTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		super(w, x, y, startNumber);
	}
	
	@Override
	public void raceStep() {
		int steps = getNextStep();
		forward(steps);
	}
	
	@Override
	public String getType() {
		return "SeriousRacer";
	}
}