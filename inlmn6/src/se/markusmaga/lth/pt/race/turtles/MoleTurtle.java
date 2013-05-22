package se.markusmaga.lth.pt.race.turtles;

import se.lth.cs.pt.graphics.GraphicsWindow_;
import se.lth.cs.pt.graphics.Color;

import java.util.*;

public class MoleTurtle extends RaceTurtle {
	private static final int CHANCE_TO_HIDE = 20;
	private static final int CHANCE_TO_SURFACE = 30;
	
	private boolean hidden = false;
	
	private Random rnd;
	
	public MoleTurtle(GraphicsWindow_ w, double x, double y, int startNumber) {
		super(w, x, y, startNumber);
		rnd = new Random();
	}
	
	@Override
	public Color getColor() {
		return new Color(139, 69, 19); //brown
	}
	
	@Override
	public void raceStep() {
		int randomvalue = rnd.nextInt(100);
		
		if(randomvalue < CHANCE_TO_HIDE && !hidden) {
			hide();
		} else if(randomvalue < CHANCE_TO_SURFACE && hidden) {
			unhide();
		}
		
		forward(getNextStep());
	}
	
	public void hide() {
		penUp();
		hidden = true;
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