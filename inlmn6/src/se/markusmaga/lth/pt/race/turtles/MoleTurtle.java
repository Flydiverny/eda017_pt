package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

import java.util.*;

public class MoleTurtle extends RaceTurtle {
	private static final int CHANCE_TO_HIDE = 20;
	private static final int CHANCE_TO_SURFACE = 40;
	
	private boolean hidden = false;
	
	public MoleTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		super(w, x, y, startNumber);
	}
	
	@Override
	public Color getColor() {
		return new Color(139, 69, 19); //brown
	}
	
	@Override
	public void raceStep() {
		Random rnd = new Random();
		int steps = getNextStep();
		
		int randomvalue = rnd.nextInt(100);
		
		if(randomvalue < CHANCE_TO_HIDE && hidden) {
			hide();
		} else if(randomvalue < CHANCE_TO_SURFACE && !hidden) {
			unhide();
		}
		
		forward(steps);
	}
	
	public void hide() {
		penUp();
		hidden = true;
		//visible(false);
	}
	
	public void unhide() {
		penDown();
		hidden = false;
	}
	
	@Override
	public String getType() {
		return "MoleTurtle";
	}
}