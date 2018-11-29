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
	
	
	public void setDataView(String dataView) {
		this.dataView = dataView;
	}


	public Point3D getPoint() {
		return point;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public String getDataView() {
		return dataView;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public long getUTC() {
		return this.UTC;
	}

	public String UTFFormat() {
		String str = Instant.ofEpochMilli(getUTC()).atOffset(ZoneOffset.UTC).toString();
		String theTime = str.substring(11, 19);
		String Date = str.substring(0, 10);
		String alltheTime = "" + Date + " " + theTime + "";
		return alltheTime;
	}

	

	@Override
	public String toString() {
		return " MyMeta_data :  \n UTC=" + UTC + ",\n point="
				+ point.toString() + ",\n name=" + name + ",\n type=" + type + ",\n time=" + time.toString();
	}


	@Override
	public Point3D get_Orientation() {

		return null;
	}

}
