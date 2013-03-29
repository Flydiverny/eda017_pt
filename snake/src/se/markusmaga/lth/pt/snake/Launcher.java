package se.markusmaga.lth.pt.snake;

import se.markusmaga.lth.pt.helper.options.*;
import se.markusmaga.lth.pt.helper.*;

public class Launcher extends OptionsLauncher {
	private static final int WINDOW_WIDTH = 30;
	private static final int WINDOW_HEIGHT = 30;
	private static final int SPEED = 50;
	private static final int FOOD = 5;
	
	public static void main(String[] args) {
		new Launcher().run();
	}
	
	private void play(int speed) {
		int width = getIntValue("width");
		int height = getIntValue("height");
		int food = getIntValue("food");

		Game rw = new Game(width, height, speed, food);
		rw.play();
	}
	private void initiate() {
		int speed = getIntValue("speed");
		play(speed);
	}

	/**
	 * Sets up the menu alternatives and their callbacks.
	 */
	@Override
	protected void setupMenu() {
		addMenuAction("Start Snake", new IFunction() {
			public void execute() {
				initiate();
			}
		});
		
		addMenuAction("Start Snake (Slow)", new IFunction() {
			public void execute() {
				play(100);
			}
		});
		
		addMenuAction("Start Snake (Fast)", new IFunction() {
			public void execute() {
				play(25);
			}
		});
	}
	
	@Override
	protected void setupOptions() {
		addOption("width", "Ange fönster bredd (30)", WINDOW_WIDTH);
		addOption("height", "Ange fönster höjd (30)", WINDOW_HEIGHT);
		addOption("speed", "Ange hastighet (50)", SPEED);
		addOption("food", "Ange mat tillväxt (5)", FOOD);
	}
}
