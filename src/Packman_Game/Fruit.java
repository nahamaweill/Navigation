package Packman_Game;

import Geom.Point3D;

public class Fruit {

	private Point3D location;
	private long ID;
	private int price;
	
	Fruit(){
	location = new Point3D(0,0,0);
	ID = 0;
	this.price = 1;
	}
	
	Fruit(Point3D point, long ID,int price){
		this.location = new Point3D(point);
		this.ID = ID;
		this.price = price;
	}
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public Point3D getLocation() {
		return location;
	}
	public int getPrice() {
		return price;
	}
	
	
}
