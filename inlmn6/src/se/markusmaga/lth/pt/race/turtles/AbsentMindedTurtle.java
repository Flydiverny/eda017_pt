package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

import java.util.*;

public class AbsentMindedTurtle extends RaceTurtle {
	private int absentPercent;
	
	public AbsentMindedTurtle(GraphicsWindow_ w, double x, double y, int startNumber, int absentPercent) {
		super(w, x, y, startNumber);
		
		this.absentPercent = absentPercent;
	}
	
	@Override
	public Color getColor() {
		return new Color(0, 191, 255); //blue
	}
	
	@Override
	public void raceStep() {
		Random rnd = new Random();
		int steps = getNextStep();
		
		int action = rnd.nextInt(100);
		
		if(action <= absentPercent) return;
		
		forward(steps);
	}
	
	@Override
	public String getType() {
		return "AbsentMindedTurtle -- " + this.absentPercent + " % absent";
	}
}