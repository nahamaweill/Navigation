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
	private String[] data = dataView.split(",");
	private long UTC;
	private Point3D point;
	private String name;
	private String type;
	private String time;

	public MyMeta_data(String dataView) {
		double x = Integer.parseInt(data[7]);
		double y = Integer.parseInt(data[6]);
		double z = Integer.parseInt(data[8]);
		point = new Point3D(x,y,z);
		this.dataView = dataView;
		this.name = data[1];
		this.type = data[10];
		this.time = data[3];
	}
	
	
	
	public Point3D getPoint() {
		return point;
	}



	public void setPoint(Point3D point) {
		this.point = point;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getDataView() {
		return dataView;
	}

	public void setDataView(String dataView) {
		this.dataView = dataView;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public long getUTC() {
		long time = new Date().getTime();
		this.UTC = time;
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
		return "Data [dataView=" + dataView + ", data=" + Arrays.toString(data) + ", UTC=" + UTC + ", point=" + point
				+ ", name=" + name + ", type=" + type + ", time=" + time + "]";
	}



	@Override
	public Point3D get_Orientation() {

		return null;
	}

}
