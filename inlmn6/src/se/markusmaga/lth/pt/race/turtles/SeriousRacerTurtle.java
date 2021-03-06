package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

public class SeriousRacerTurtle extends RaceTurtle {

	public SeriousRacerTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		super(w, x, y, startNumber);
	}
		
	@Override
	public Color getColor() {
		return new Color(255, 0, 0); //red
	}
	
	@Override
	public void raceStep() {
		forward(getNextStep());
	}
	
	@Override
	public String getType() {
		return "SeriousRacer";
	}
}