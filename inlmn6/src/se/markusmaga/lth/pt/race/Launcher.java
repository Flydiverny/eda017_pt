package se.markusmaga.lth.pt.mandelbrot;

import se.markusmaga.lth.pt.helper.options.*;
import se.markusmaga.lth.pt.helper.*;

import se.lth.cs.pt.dots.listeners.DotWindow;

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