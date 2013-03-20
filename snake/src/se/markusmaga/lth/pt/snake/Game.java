package se.markusmaga.lth.pt.snake;

import se.lth.cs.pt.dots.events.DotWindow;

public class Game {
	private Snake player;
	private DotWindow window;
		
	public Game() {
		window = new DotWindow(30,30,10);
		player = new Snake(15, 15);
	}

	public Game(int width, int height) {
		this();
	}
	
	public void play() {
		player.display(window);
	}
	
	
}
