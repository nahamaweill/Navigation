package GIS;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.lang.Object;
import java.text.Format;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;

import Geom.Point3D;

public class MyMeta_data implements Meta_data {

	private String dataView;
	private String[] data;
	private long UTC;
	private Point3D point;
	private String name;
	private String type;
	private String time;

	/**
	 * A constructor that gets a String of the data
	 * @param dataView the string of the data
	 */
	public MyMeta_data(String dataView) {
		this.dataView = dataView;
		data = dataView.split(",");
		double x = Double.parseDouble(data[7]);
		double y = Double.parseDouble(data[6]);
		double z = Double.parseDouble(data[8]);
		point = new Point3D(x,y,z);
		this.name = data[1];
		this.type = data[10];
		this.time = data[3];
		this.UTC = new Date().getTime();
	}
	/**
	 * A copy constructor
	 * @param other My Meta data element
	 */
	
	public MyMeta_data(MyMeta_data other) {
		this.dataView = other.dataView;
		this.data = dataView.split(",");
		this.point = new Point3D(other.point);
		this.name = other.name;
		this.type = other.type;
		this.time = other.time;
		this.UTC = other.UTC;
	}
	/**
	 * The function set the data view
	 * @param dataView the string to set
	 */
	
	public void setDataView(String dataView) {
		this.dataView = dataView;
	}
	/**
	 * The function gets the Point 3D
	 * @return the point 3D
	 */

	public Point3D getPoint() {
		return point;
	}
	/**
	 * The function gets the name
	 * @return the name
	 */

	public String getName() {
		return name;
	}
	/**
	 * The function gets the time
	 * @return the time
	 */

	public String getTime() {
		return time;
	}
	/**
	 * The function gets the Data View
	 * @return the data view
	 */

	public String getDataView() {
		return dataView;
	}
	/**
	 * The function return a Array of string of data
	 * @return a Array of string of data
	 */

	public String[] getData() {
		return data;
	}
	/**
	 * The function set the data
	 * @param data a Array of String of data to set
	 */

	public void setData(String[] data) {
		this.data = data;
	}
	/**
	 * The function gets a Universal Time Clock in millisecond
	 * @return the UTC in millisecond
	 */

	@Override
	public long getUTC() {
		return this.UTC;
	}
	/**
	 * The function change millisecond to time
	 * @return the time change from millisecond
	 */

	public String UTFFormat() {
		String str = Instant.ofEpochMilli(getUTC()).atOffset(ZoneOffset.UTC).toString();
		String theTime = str.substring(11, 19);
		String Date = str.substring(0, 10);
		String alltheTime = "" + Date + " " + theTime + "";
		return alltheTime;
	}
	/**
	 * the function return a String of all the data of the element
	 * @return the data of the element
	 */

	@Override
	public String toString() {
		return "MyMeta_data:\n UTC=" + UTC + ",\n point="
				+ point.toString() + ",\n name=" + name + ",\n type=" + type + ",\n time=" + time.toString();
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public Point3D get_Orientation() {

		return null;
	}

}
