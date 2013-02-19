package se.markusmaga.lth.pt.race;

import se.markusmaga.lth.pt.helper.options.*;
import se.markusmaga.lth.pt.helper.*;

public class Launcher extends OptionsLauncher {
	private static final int DEFAULT_VALUE = 1;
	
	public static void main(String[] args) {
		new Launcher().run();
	}
	
	private void initiate() {

	}

	/**
	 * Sets up the menu alternatives and their callbacks.
	 */
	@Override
	protected void setupMenu() {
		addMenuAction("", new IFunction() {
			public void execute() {
				initiate();
			}
		});
	}
	
	@Override
	protected void setupOptions() {
		addOption("", "", DEFAULT_VALUE);
	}
}