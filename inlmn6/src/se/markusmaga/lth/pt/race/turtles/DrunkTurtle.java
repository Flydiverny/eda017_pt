package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

import java.util.*;

public class DrunkTurtle extends RaceTurtle {
	private int drunkness;
	
	private Random rnd;
	
	public DrunkTurtle(GraphicsWindow_ w, double x, double y, int startNumber, int drunkness) {
		super(w, x, y, startNumber);
		
		this.drunkness = drunkness;
		this.rnd = new Random();
	}
	
	@Override
	public Color getColor() {
		return new Color(255, 215, 0); //yellow
	}
	
	@Override
	public void raceStep() {
		int action = rnd.nextInt(2);
		
		if(action == 1) {
			left(3*drunkness);
		} else {
			right(3*drunkness);
		}
		
		forward(getNextStep());
	}
	
	@Override
	public String getType() {
		return "DrunkTurtle -- " + this.drunkness + " promille";
	}
}