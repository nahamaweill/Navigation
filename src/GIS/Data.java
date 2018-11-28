package GIS;

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

public class Data implements Meta_data {

	private String[] data;
	private long UTC;

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public Data(String s) {
		setData(s.split(","));
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
		String alltheTime = ""+Date  +" "+  theTime+"";
		return alltheTime;
	}

	@Override
	public Point3D get_Orientation() {

		return null;
	}

}
