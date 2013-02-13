package se.markusmaga.lth.pt.mandelbrot;

import se.lth.cs.pt.dots.events.DotWindow;
import se.lth.cs.pt.dots.events.GameEvent;

public class MandelbrotWindow {
	private Mandelbrot m;
	private DotWindow w;
	
    /**
     * 
     * 
     * @param width 
     * @param height 
     * @param size 
     * @param iterations 
     */
	public MandelbrotWindow(int width, int height, int size, int iterations) {
		this.w = new DotWindow(width, height, size);
		this.m = new Mandelbrot(iterations);
		
		setupWindow();
	}
	
    /**
     * 
     * 
     */
	private void setupWindow() {
		w.useRectangularDots();
		w.setAutoUpdate(false);
		w.checkMouse(true, true, true, false, false);
		w.checkKeys(true, false, false);
	}
	
    /**
     * 
     * 
     * @param event 
     */
	private void mouseClicked(GameEvent event) {
		scaleChanger(event.getButton());
		m.setCenterByCoordinates(event.getX(), event.getY(), w.getWidth(), w.getHeight());
	}
	
    /**
     * 
     * 
     * @param event 
     */
	private void keyClicked(GameEvent event) {
		scaleChanger(event.getKeyCode());
	}
	
    /**
     * 
     * 
     * @param modifier 
     */
	private void scaleChanger(int modifier) {
		switch(modifier) {
		case 1:
		case 107:
			m.decreaseScale();
			break;
		case 3:
		case 109:
			m.increaseScale();
			break;
		case 32:
			m.setScale(2.0);
			break;
		}
	}
	
    /**
     * 
     * 
     * @param x 
     * @param y 
     * @param event 
     */
	private void mouseDragged(int x0, int y0, GameEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		if(x==x0 && y == y0) return;
		
		int xCenter = x0 + (x-x0)/2;
		int yCenter = y0 + (x-x0)/2;
		
		m.setCenterByCoordinates(xCenter, yCenter, w.getWidth(), w.getHeight());
		
		int xMax, xMin, yMax, yMin;
		if(x0 > x) {
			xMax = x0;
			xMin = x;
		} else {
			xMax = x;
			xMin = x0;
		}
		
		if(y0 > y) {
			yMax = y0;
			yMin = y;
		} else {
			yMax = y;
			yMin = y0;
		}
		
		if((xMax - xMin) > (yMax - yMin)) {
			m.setScaleByX(xMax, xMin, w.getWidth());
		} else {
			m.setScaleByY(yMax, yMin, w.getHeight());
		}
	}
	
	private int mouseDragX, mouseDragY;
	
    /**
     * Checks for events and decides what to do with them.
     */
	private void eventHandling() {
		
		
		GameEvent event = w.getNextEvent();
		switch (event.getKind()) {
		case GameEvent.MOUSE_CLICKED:
			mouseClicked(event);
			System.out.println("Mouse Clicke! x set to " + mouseDragX + " and y to " + mouseDragY);
			break;
		case GameEvent.MOUSE_PRESSED:
			mouseDragX = event.getX();
			mouseDragY = event.getY();
			System.out.println("Mouse Pressed! x set to " + mouseDragX + " and y to " + mouseDragY);
			break;
		case GameEvent.MOUSE_DRAGGED:
			System.out.println("Mouse Dragged! x set to " + mouseDragX + " and y to " + mouseDragY);
			break;
		case GameEvent.MOUSE_RELEASED:
			System.out.println("Mouse Released! x set to " + mouseDragX + " and y to " + mouseDragY);
			mouseDragged(mouseDragX, mouseDragY, event);
			break;
		//case GameEvent.MOUSE_RELEASED:
		//	mouseDragged(x, y, event);
		//	break;
		case GameEvent.KEY_PRESSED:
			keyClicked(event);
			break;
		}
	}
	
    /**
     * 
     * 
     */
	public void looper() {
		while(true) {
			m.display(w);
			w.update();
			
			eventHandling();
		}
	}
}