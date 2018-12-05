package Packman_Game;

import java.util.ArrayList;

import GIS.GIS_element;
import Geom.Point3D;

public class Packman {

	private Point3D location;
	private long ID;
	private double speed;
	private double radius;

	Packman() {
		location = new Point3D(0, 0, 0);
		ID = 0;
		speed = 1;
		radius = 1;
	}

	Packman(Point3D point, long ID, double speed, double radius) {
		this.location = point;
		this.ID = ID;
		this.speed = speed;
		this.radius = radius;
	}

	public Point3D getLocation() {
		return location;
	}


	public String getID() {
		return ID;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	///////////////////////////My Functions//////////////////////////////////
	
	public void move(double x_move, double y_move, double z_move) {
		this.location.set_x(location.get_x() + x_move);
		this.location.set_y(location.get_x() + y_move);
		this.location.set_z(location.get_x() + z_move);
	}
	
	public Packman closest(ArrayList<Fruit> fruit_list) {
		
		return null;
		
	}
}
