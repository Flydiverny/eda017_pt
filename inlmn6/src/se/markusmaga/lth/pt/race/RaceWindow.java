package se.markusmaga.lth.pt.race;

import se.markusmaga.lth.pt.race.turtles.*;

import se.lth.cs.pt.graphics.basic.GraphicsWindow;
import se.lth.cs.pt.io.Keyboard;

public class RaceWindow {
	private final double LINE_OFFSET_Y;
	private final double LINE_BOT_Y;
	private final double LINE_OFFSET_X;
	private final double LINE_GOAL_X;

	private int windowWidth;
	private int windowHeight;
	
	private TurtleRace turtleRace;
	private int nbrOfTurtles;
	private GraphicsWindow gw;
	
	private List<RaceTurtle> racers;
	
	public RaceWindow(int width, int height) {
		this(width, height, 50, 50);
	}
	
	public RaceWindow(int width, int height, int offsetY, int offsetX) {
		this.windowWidth = width;
		this.windowHeight = height;
	
		this.LINE_OFFSET_Y = offsetY;
		this.LINE_BOT_Y = this.windowHeight-LINE_OFFSET_Y;
		
		this.LINE_OFFSET_X = offsetX;
		this.LINE_GOAL_X = this.windowWidth-LINE_OFFSET_X;
		
		this.racers = new LinkedList<RaceTurtle>();
	
		// Start stuff
		this.nbrOfTurtles = getAmountOfTurtles();
		
		this.gw = createWindow(windowWidth, windowHeight);
	}
	
	/**
	 * Creats a graphic window and draws goal line as well as start line.
	 * @param width Fönster bredd
	 * @param height Fönster höjd
	 */
	private GraphicsWindow createWindow(int width, int height) {
		GraphicsWindow w = new GraphicsWindow(width, height);
		
		w.drawLine(LINE_OFFSET_X, LINE_OFFSET_Y, LINE_OFFSET_X, LINE_BOT_Y, 2, Color.RED);

		int offset = 25;
		
		GoalTurtle g = new GoalTurtle(w, LINE_GOAL_X, -offset);
		g.left(180); // look down
		g.forward(LINE_OFFSET_Y+offset); // walk in
		g.drawGoal(LINE_BOT_Y-LINE_OFFSET_Y); // draw
		g.forward(LINE_OFFSET_Y+offset); // walk out

		return w;
	}
	
	/**
	 * Läser in antal önskade sköldpaddor från användaren
	 */
	private int getAmountOfTurtles() {
		return Keyboard.nextInt("Ange antal sköldpaddor: ");
	}
}