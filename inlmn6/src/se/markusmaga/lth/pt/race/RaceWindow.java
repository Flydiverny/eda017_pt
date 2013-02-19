package se.markusmaga.lth.pt.race;

import se.markusmaga.lth.pt.race.turtles.*;

import se.lth.cs.pt.graphics.basic.GraphicsWindow;

public class RaceWindow {
	private static final double	LINE_TOP_Y		= 50;
	private static final double	LINE_BOT_Y		= 250;
	private static final double	START_LINE_X	= 50;
	private static final double	FINISH_LINE_X	= 450;

	private TurtleRace turtleRace;
	private int nbrOfTurtles;
	private GraphicsWindow gw;
	
	private List<RaceTurtle> racers;
	
	public RaceWindow(int width, int height) {
	
		this.gw = new GraphicsWindow(width, height);
		this.nbrOfTurtles = getAmountOfTurtles();
		
		this.racers = new LinkedList<RaceTurtle>();
	}
	
	/**
	 * Skapar ett fönster
	 * @param width Fönster bredd
	 * @param height Fönster höjd
	 */
	private GraphicsWindow createWindow(int width, int height) {
		GraphicsWindow w = new GraphicsWindow(width, height);
		
		w.drawLine(START_LINE_X, LINE_TOP_Y, START_LINE_X, LINE_BOT_Y, 2, Color.RED);
		w.drawLine(FINISH_LINE_X, LINE_TOP_Y, FINISH_LINE_X, LINE_BOT_Y, 2, Color.RED);	

		return w;
	}
	
	/**
	 * Läser in antal önskade sköldpaddor från användaren
	 */
	private int getAmountOfTurtles() {
		return Keyboard.nextInt("Ange antal sköldpaddor: ");
	}
}