package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class MyGIS_Element implements GIS_element {

	/*
	 * in this class we can to find any information about the element with
	 * dataObjects Arr
	 */

	private String dataView;
	private String[] dataObjects = dataView.split(",");
	private Point3D point;

	public String getDataView() {
		return dataView;
	}

	public void setDataView(String dataView) {
		this.dataView = dataView;
	}

	public String[] getDataObjects() {
		return dataObjects;
	}

	public void setDataObjects(String[] dataObjects) {
		this.dataObjects = dataObjects;
	}

	public Point3D getPoint() {
		return point;
	}

	public void setPoint(Point3D point) {
		this.point = point;
	}

	public MyGIS_Element() {
		dataView = "";
		point = new Point3D(0, 0, 0);
	}

	public MyGIS_Element(MyGIS_Element Other) {
		this.dataView = Other.dataView;
		this.point = new Point3D(Other.point);
	}

	
	
	@Override
	public Geom_element getGeom() {

		return null;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub

	}

}
