package Coords;

import Geom.Point3D;

public class coord implements coords_converter
{
	public final static int EARTH_R=6371000;
	public final static double LON_NORM=0.847091174;
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		//changing the point gps from coordinates polar to cartesian
		gps.chang_Geometric_To_Cart();
		Point3D temp = new Point3D(gps);
		temp.add(gps);
		return temp;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double dis_lat = gps1.x()-gps0.x();
		double dis_lon = gps1.y()-gps0.y();
		double dis_alt = gps1.z()-gps0.z();
		dis_lat = gps0.d2r(dis_lat);
		dis_lon = gps0.d2r(dis_lon);
		dis_lat = Math.sin(dis_lat)*EARTH_R;
		dis_lon = Math.sin(dis_lon)*EARTH_R*LON_NORM;
		double dis= dis_lat*dis_lat+dis_lon*dis_lon+dis_alt*dis_alt;
		return Math.sqrt(dis);
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		gps0.chang_Geometric_To_Cart();
		gps1.chang_Geometric_To_Cart();
		Point3D vec = new Point3D(gps1.x()-gps0.x(), gps1.y()-gps0.y(), gps1.z()-gps0.z());
		return vec;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double azi_x = gps1.x() - gps0.x();
		double azi_y = gps1.y() - gps0.y();
		double azi = Math.abs(Math.atan(azi_y/azi_x));
		
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if (p.x()<-180 || p.x()>180)
			return false;
		if (p.y()<-90 || p.y()> 90)
			return false;
		if (p.z()<-450)
			return false;
		return true;
	}

}