package Packman_Game;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

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

	public long getID() {
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

	/////////////////////////// My Functions//////////////////////////////////

	public void move(double x_move, double y_move, double z_move) {
		this.location.set_x(location.get_x() + x_move);
		this.location.set_y(location.get_x() + y_move);
		this.location.set_z(location.get_x() + z_move);
	}

	public Fruit closestFruit(ArrayList<Fruit> fruit_list) {
		double distance = this.location.distance3D(fruit_list.get(0).getLocation());
		long ID = 0;
		int price = 0;
		Point3D ans_point = fruit_list.get(0).getLocation();
		while (fruit_list.iterator().hasNext()) {
			Fruit runner = fruit_list.iterator().next();
			if (this.location.distance3D(runner.getLocation()) < distance) {
				ans_point = runner.getLocation();
				ID = runner.getID();
				price = runner.getPrice();
			}
		}
		Fruit ans = new Fruit(ans_point, ID, price);
		return ans;
	}

	public ArrayList<Fruit> MyTrack(ArrayList<Fruit> list) {
		java.util.Iterator<Fruit> iter = list.iterator();
		ArrayList<Fruit> ans = new ArrayList<Fruit>();
		while (iter.hasNext()) {
			Fruit runner = iter.next();
			if (this.location.get_x() == runner.getLocation().get_x()
					&& this.location.get_y() == runner.getLocation().get_y()) {
				ans.add(runner);
			}
		}
		return ans;
	}

	public int level(ArrayList<Fruit> list) {
		ArrayList<Fruit> ans = MyTrack(list);
		return ans.size();
	}

}
