package GIS;

import java.awt.Point;
import java.util.Iterator;

import Geom.Geom_element;
import Geom.Point3D;

public class MyGIS_Element implements GIS_element {

	private Point3D point;
	private MyMeta_data data;
	/**
	 * A defaultiv constructor
	 */
	public MyGIS_Element() {
		point = new Point3D(0, 0, 0);
		data = null;
	}
	/**
	 * A copy constructor
	 * 
	 * @param Other MyGIS_Element object
	 */

	public MyGIS_Element(MyGIS_Element Other) {
		point = new Point3D(Other.point);
		this.data.setDataView(Other.data.getDataView());
	}
	/**
	 * A constructor with String
	 * 
	 * @param s the String
	 */

	public MyGIS_Element(String s) {
		this.data = new MyMeta_data(s);
		this.point = data.getPoint();
	}
	/**
	 * The function get the point
	 * 
	 * @return the point
	 */

	public Geom_element getGeom() {
		return this.point;
	}
	/**
	 * The function get the data
	 * 
	 * @return the data
	 */

	@Override
	public Meta_data getData() {
		return this.data;

	}
	/**
	 * This function translate a vector 3D to a gps point
	 * 
	 * @param vec that we want to translate to a gps point
	 * 
	 */

	@Override
	public void translate(Point3D vec) {
		point.add(vec);
	}
	/**
	 * The function return a String of all the data of the element
	 * 
	 * @return the data of the element
	 */
	@Override
	public String toString() {
		return "\n MyGIS_Element :\n " + data.toString()  ;
	}


}
