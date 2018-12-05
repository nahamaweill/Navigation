package Packman_Game;

public class Pixel {

	private double x;
	private double y;

	public Pixel(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Pixel arg0) {
		if (getX() != arg0.getX() || getY() != arg0.getY())
			return false;

		return true;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {

		return this.y;
	}

	public void move(double arg0, double arg1) {
		this.x += arg0;
		this.y += arg1;
	}

	@Override
	public String toString() {
		return " x value : " + this.getX() + " y value : " + this.getY();
	}

}
