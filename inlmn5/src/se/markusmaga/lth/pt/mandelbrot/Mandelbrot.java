package se.markusmaga.lth.pt.mandelbrot;

import se.lth.cs.pt.dots.DotWindow_;
import se.lth.cs.pt.dots.Color;
import java.awt.Point;

public class Mandelbrot {
	public static final int MAX_ITERATIONS	= 255;
	public static final double START_SCALE	= 2;
	public static final double START_RE		= -0.5;
	public static final double START_IM		= 0.0;
	
	private int max_iterations;
	private double currentScale;
	private double targetRe, targetIm;
	
	/**
	 * Creates a new Mandelbrot with default values.
	 */
	public Mandelbrot() {
		this(MAX_ITERATIONS, START_RE, START_IM, START_SCALE);
	}

	/**
	 * Creates a new Mandelbrot with default values and max_iterations.
	 * @param max_iterations - maximum iterations used to determine mandelbrot
	 */
	public Mandelbrot(int max_iterations) {
		this(max_iterations, START_RE, START_IM, START_SCALE);
	}
	
	/**
	 * Creates a new Mandelbrot.
	 * @param max_iterations - maximum iterations used to determine mandelbrot
	 * @param re - Starting point on Real axis when using {@link #display(DotWindow) display} method.
	 * @param im - Starting point on Imaginary axis when using {@link #display(DotWindow) display} method.
	 */
	public Mandelbrot(int max_iterations, double re, double im, double scale) {
		this.max_iterations	= max_iterations;
		this.targetRe		= re;
		this.targetIm		= im;
		this.currentScale	= scale;
	}
	
	/**
	 * Calculate the new real number from a given real number for Mandelbrot
	 * @param re - Current real number to add.
	 * @param a - New real number to calculate from.
	 * @param b - New imaginary number to calculate from.
	 */
	private double calculateRe(double re, double a, double b) {
		return a * a - b * b + re;
	}
	
	/**
	 * Calculate the new imaginary number from a given imaginary number for Mandelbrot
	 * @param im - Current imaginary number to add.
	 * @param a - New real number to calculate from.
	 * @param b - New imaginary number to calculate from.
	 */
	private double calculateIm(double im, double a, double b) {
		return 2 * a * b + im;
	}
	
	/**
	 * Calculate the Mandelbrot iteration count for a complex number.
	 * @param re - Real part of complex number.
	 * @param im - Imaginary part of complex number.
	 */
	private int calculate(double re, double im) {
		double a=0, b=0;
		
		int iterations=0;
		while( a*a + b*b < 2*2 && iterations < max_iterations) {
			// z = a + ib
			// z^2 = (a+ib)^2 = a^2 + 2abi - b^2
			// c = re + im
			// z2 = z^2 + c
			
			double atemp = calculateRe(re, a, b);
			b = calculateIm(im, a, b);
			a = atemp;
			iterations++;
		}
	
		return iterations;
	}
	
	/**
	 * Increases scale (zooms in), used when deciding complex number for a given coordinate.
	 */
	public void increaseScale() {
		this.currentScale *= 1.1;
	}
	
	/**
	 * Decreases scale (zooms out), used when deciding complex number for a given coordinate.
	 */
	public void decreaseScale() {
		this.currentScale *= 0.9;
	}
	
	/**
	 * Sets scale to scale.
	 * @param scale - Scale to set, generally 0 < scale < 2
	 */
	public void setScale(double scale) {
		this.currentScale = scale;
	}
	
	public void setScaleByX(int max, int min, int width) {
		double x1 = xToRe(min, width);
		double x2 = xToRe(max, width);
		
		System.out.println(x2-x1);
		setScale(x2-x1);
	}
	
	public void setScaleByY(int max, int min, int height) {
		double y1 = yToIm(min, height);
		double y2 = yToIm(max, height);

		System.out.println(y2-y1);
		setScale(y2-y1);
	}

    /**
     * Gets current scale
     * @return double - scale
     */
	public double getScale() {
		return this.currentScale;
	}
	
	/**
	 * Set complex number used as the center for displaying Mandelbrot.
	 * @param re - Real part of complex number.
	 * @param im - Imaginary part of complex number.
	 */
	public void setCenter(double re, double im) {
		this.targetRe = re;
		this.targetIm = im;
	}
	
	/**
	 * Calculates and sets complex number used as the center for displaying Mandelbrot,
	 * based on the coordinates and given dimensions.
	 * @param x - x coordinate to caculate real number from.
	 * @param y - y coordinate to caculate imaginary number from.
	 * @param width - width for window that Mandelbrot will be displayed in.
	 * @param height - height for window that Mandelbrot will be displayed in.
	 */
	public void setCenterByCoordinates(int x, int y, int width, int height) {
		setCenter(xToRe(x, width), yToIm(y, height));
	}
	
	/**
	 * Converts a x coordinate to a real number, based on current scale and window width.
	 * @param x - x coordinate to caculate real number from.
	 * @param width - width for window that Mandelbrot will be displayed in.
	 */
	private double xToRe(double x, double width) {
		return coordToComplex(x, width, targetRe);
	}
	
	/**
	 * Converts a y coordinate to a imaginary number, based on current scale and window height.
	 * @param y - y coordinate to caculate imaginary number from.
	 * @param height - height for window that Mandelbrot will be displayed in.
	 */
	private double yToIm(double y, double height) {
		return coordToComplex(y, height, targetIm);
	}
	
	/**
	 * Converts a coordinate to its complex counterpart, based on current scale and specified dimension.
	 * @param c - x or y coordinate to convert
	 * @param dim - width or height for scale conversion
	 * @param tar - current complex center for same axis as c.
	 */
	private double coordToComplex(double c, double dim, double tar) {
		return (this.currentScale/2-tar)*-1+this.currentScale/dim*c;
	}
	
	/**
	 * Displays Mandelbrot in input window.
	 * @param w - DotWindow to setColors in.
	 */
	public void display(DotWindow_ w) {
		for(int x = 0; x < w.getWidth(); x++) {
			for(int y = 0; y < w.getHeight(); y++) {
				double im = yToIm(y, w.getHeight());
				double re = xToRe(x, w.getWidth());
				
				int iterations = calculate(re, im);
				w.setDot(x, y, getColor(iterations));
			}
		}
	}
	
	/**
	 * Returns a Color representation for a count of iterations.
	 * @param it - iterations
	 */
	public Color getColor(int it) {
		double c = 255.0/this.max_iterations*it;
		
		if(it < this.max_iterations/3)
			return new Color(127, 127-(int) (c/2.0), 127);
		else if(it < this.max_iterations/3*2)
			return new Color(0, 0, (int) c);
		else
			return new Color(255-(int) c, 0, 0);
	}
}
