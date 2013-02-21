package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

import java.util.*;

public class DrunkTurtle extends RaceTurtle {
	private int drunkness;
	
	public DrunkTurtle(GraphicsWindow_ w, double x, double y, int startNumber, int drunkness) {
		super(w, x, y, startNumber);
		
		this.drunkness = drunkness;
	}
	
	@Override
	public Color getColor() {
		return new Color(255, 215, 0); //yellow
	}
	
	@Override
	public void raceStep() {
		Random rnd = new Random();
		int steps = getNextStep();
		
		int action = rnd.nextInt(2);
		
		if(action == 1) {
			left(3*drunkness);
		} else {
			right(3*drunkness);
		}
		
		forward(steps);
	}
	
	@Override
	public String getType() {
		return "DrunkTurtle -- " + this.drunkness + " promille";
	}
}