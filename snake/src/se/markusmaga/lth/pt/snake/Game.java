package se.markusmaga.lth.pt.snake;

import se.lth.cs.pt.dots.events.DotWindow;
import se.lth.cs.pt.dots.events.GameEvent;

import java.util.Random;

public class Game {
	private Snake player;
	private DotWindow window;
	private Body food;
	private int foodPower;
	private Random rng;
	
	public Game(int width, int height, int speed, int foodPower) {
		window = new DotWindow(width, height, 10);
		player = new Snake(window, width/2, height/2);
		
		food = new Body(0, 0);
		food.setColor(Color.GREEN);
		
		rng = new Random();
		
		this.foodPower = foodPower;
		
		player.displaySnake();
		randomizeFood();
		
		window.checkKeys(true,false,false);
		window.timeStep(speed);  
	}
	
	private void randomizeFood() {
		int randomX = rng.nextInt(window.getWidth());
		int randomY = rng.nextInt(window.getHeight());
		
		//food.clear(window); not really needed since it will be overwritten by snake
		food.setLocation(randomY, randomX);
		food.display(window);		
	}
	
	public void play() {
		do {
			GameEvent e = window.getNextEvent();
			
			switch (e.getKind()) {
				case GameEvent.KEY_PRESSED:
					if (e.getKey() == 'w') {
						player.move(0, -1);
					} else if (e.getKey() == 'a') {
						player.move(-1, 0);
					} else if (e.getKey() == 's') {
						player.move(0, 1);
					} else if (e.getKey() == 'd') {
						player.move(1, 0);
					} else if (e.getKey() == 'e') {
						player.eat(5);
					}
					break;
				case GameEvent.TICK:
					player.forward();
					break;
			}
			
			if(player.collission(food)) {
				player.eat(foodPower);
				randomizeFood();
			}
			
			food.display(window); // make sure its shown since body collission could hide it if it spawns inside the body
			
		} while(!player.hasCollission());
	}
}
