package se.markusmaga.lth.pt.snake;

import se.markusmaga.lth.pt.helper.options.*;
import se.markusmaga.lth.pt.helper.*;

public class Launcher extends OptionsLauncher {
	private static final int DEFAULT_VALUE = 1;
	
	public static void main(String[] args) {
		new Launcher().run();
	}
	
	private void initiate() {
		Game rw = new Game(500,300);
		rw.play();
	}

	/**
	 * Sets up the menu alternatives and their callbacks.
	 */
	@Override
	protected void setupMenu() {
		addMenuAction("Start Race", new IFunction() {
			public void execute() {
				initiate();
			}
		});
	}
	
	@Override
	protected void setupOptions() {
		//addOption("", "", DEFAULT_VALUE);
	}
}
