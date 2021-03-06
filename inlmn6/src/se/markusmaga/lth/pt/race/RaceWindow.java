package se.markusmaga.lth.pt.race;

import se.markusmaga.lth.pt.race.turtles.*;

import se.lth.cs.pt.graphics.basic.GraphicsWindow;
import se.lth.cs.pt.io.Keyboard;
import se.lth.cs.pt.graphics.Color;

import java.util.*;

public class RaceWindow {
	private final int LINE_OFFSET_Y;
	private final int LINE_BOT_Y;
	private final int LINE_OFFSET_X;
	private final int LINE_GOAL_X;

	private int windowWidth;
	private int windowHeight;
	
	private int nbrOfTurtles;
	private List<RaceTurtle> racers;
	private GraphicsWindow w;
	
	private boolean allowSerious	= true;
	private boolean allowMole		= true;
	private boolean allowAbsent		= true;
	private boolean allowStalker	= true;
	private boolean allowDrunk		= true;

	public RaceWindow(int width, int height) {
		this(width, height, 50, 50);
	}
	
	public RaceWindow(int width, int height, int offsetY, int offsetX) {
		this.windowWidth	= width;
		this.windowHeight	= height;
	
		this.LINE_OFFSET_Y	= offsetY;
		this.LINE_BOT_Y		= this.windowHeight - LINE_OFFSET_Y;
		
		this.LINE_OFFSET_X	= offsetX;
		this.LINE_GOAL_X	= this.windowWidth - LINE_OFFSET_X;
		
		this.racers			= new ArrayList<RaceTurtle>();
		
		// Start stuff
		this.nbrOfTurtles	= getAmountOfTurtles();
		
		this.w = createWindow();
	}
	
	public void setTurtleTypes(boolean serious, boolean mole, boolean absent, boolean stalker, boolean drunk) {
		this.allowSerious	= serious;
		this.allowMole		= mole;
		this.allowAbsent	= absent;
		this.allowStalker	= stalker;
		this.allowDrunk		= drunk;
	}
	
	public void performRace() {
		generateRacers();
		printRacers();
		
		w.show();
		
		//drawGoalLine();
		race();
	}
	
	public void race() {
		List<RaceTurtle> winners = new ArrayList<RaceTurtle>();
		
		do {
			for(int i = 0; i < racers.size(); i++) {
				RaceTurtle t = racers.get(i);
				
				t.raceStep();
				
				if(t.getX() >= LINE_GOAL_X) {
					winners.add(t);
					racers.remove(t);
					i--;
				}
			}
		} while(!fullWinnerTable(winners) && racers.size() != 0);
		
		printWinners(winners);
	}
	
	private boolean fullWinnerTable(List<RaceTurtle> winners) {
		if(winners.size() < 3) return false;
		
		int lastSteps = 0;
		int placement = 1;
		for(RaceTurtle t : winners) {
			if(t.getAmountOfSteps() != lastSteps) {
				lastSteps = t.getAmountOfSteps();
				placement++;
			}
		}
		
		return placement > 3;
	}
	
	private void printWinners(List<RaceTurtle> winners) {
		StringBuilder output = new StringBuilder();

		int lastSteps = 0;
		int placement = 1;
		for(RaceTurtle t : winners) {
			if(t.getAmountOfSteps() != lastSteps) {
				output.append(placement++ + ":");
				lastSteps = t.getAmountOfSteps();
			}
			
			output.append("\t" + t.getAmountOfSteps() + " steps -- " + t + "\n");
		}
		
		System.out.print(output.toString());
	}
	
	public void printRacers() {
		for(RaceTurtle t : racers) {
			System.out.println(t);
		}
	}
	
	private void drawGoalLine() {
		int offset = 25;
		
		AlternatingTurtle g = new AlternatingTurtle(w, LINE_GOAL_X-5, -offset);
		g.left(180); // look down
		g.forward(LINE_OFFSET_Y+offset); // walkin 
		g.drawGoal(LINE_BOT_Y-LINE_OFFSET_Y); // draw 
		g.forward(LINE_OFFSET_Y+offset); // walkout
	}
	
	private void generateRacers() {
		double turtleSpace = (LINE_BOT_Y-LINE_OFFSET_Y) / (nbrOfTurtles+1.0); 
	
		List<StalkerTurtle> stalkers = new ArrayList<StalkerTurtle>();
		
		Random rnd = new Random();
		int number = 0;

		do {
			switch(rnd.nextInt(5)) {
				case 0:
					if(allowSerious) {
						number++;
						racers.add(new SeriousRacerTurtle(w, LINE_OFFSET_X, LINE_OFFSET_Y + turtleSpace*number, number));
					}
					break;
				case 1:
					if(allowMole) {
						number++;
						racers.add(new MoleTurtle(w, LINE_OFFSET_X, LINE_OFFSET_Y + turtleSpace*number, number));
					}
					break;
				case 2:
					if(allowAbsent) {
						number++;
						racers.add(new AbsentMindedTurtle(w, LINE_OFFSET_X, LINE_OFFSET_Y + turtleSpace*number, number, rnd.nextInt(100)));
					}
					break;
				case 3:
					if(allowDrunk) {
						number++;
						racers.add(new DrunkTurtle(w, LINE_OFFSET_X, LINE_OFFSET_Y + turtleSpace*number, number, rnd.nextInt(5)+1));
					}
					break;
				case 4:
					if(allowStalker) {
						number++;
						StalkerTurtle st = new StalkerTurtle(w, LINE_OFFSET_X, LINE_OFFSET_Y + turtleSpace*number, number);
						racers.add(st);
						stalkers.add(st);
					}
					break;
				default:
					break;
			}
		} while(racers.size() < nbrOfTurtles);
		
		// Give stalkers some targets
		for(StalkerTurtle st : stalkers) {
			do {
				int index = rnd.nextInt(racers.size());
				RaceTurtle rt = racers.get(index);
				
				if(rt != st)
					st.stalk(rt);
			} while(!st.hasTarget());
		}
	}
	
	/**
	 * Creats a graphic window and draws goal line as well as start line.
	 * @param width Fönster bredd
	 * @param height Fönster höjd
	 */
	private GraphicsWindow createWindow() {
		GraphicsWindow w = new GraphicsWindow(this.windowWidth, this.windowHeight);
		
		w.drawLine(LINE_OFFSET_X, LINE_OFFSET_Y, LINE_OFFSET_X, LINE_BOT_Y, 2, Color.RED);
		w.drawLine(LINE_GOAL_X, LINE_OFFSET_Y, LINE_GOAL_X, LINE_BOT_Y, 2, Color.RED);
		
		w.hide();

		return w;
	}
	
	/**
	 * Läser in antal önskade sköldpaddor från användaren
	 */
	private int getAmountOfTurtles() {
		return Keyboard.nextInt("Ange antal sköldpaddor: ");
	}
}
