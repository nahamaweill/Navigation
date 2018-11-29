package GIS;

import java.awt.Point;

import Geom.Geom_element;
import Geom.Point3D;

public class MyGIS_Element implements GIS_element {

	private Point3D point;
	private MyMeta_data data;

	public MyGIS_Element() {
		point = new Point3D(0, 0, 0);
		data = null;
	}

	public MyGIS_Element(MyGIS_Element Other) {
		point = new Point3D(Other.point);
		this.data.setDataView(Other.data.getDataView());
	}

	public MyGIS_Element(String s) {
		this.data = new MyMeta_data(s);
		this.point = data.getPoint();
	}

	public Geom_element getGeom() {
		return this.point;
	}

	@Override
	public Meta_data getData() {
		return this.data;

	}

	@Override
	public void translate(Point3D vec) {
		point.add(vec);
	}

	@Override
	public String toString() {
		return "MyGIS_Element :  \n " + data.toString()  ;
	}

	
}
