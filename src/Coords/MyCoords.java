package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	public final static int EARTH_R = 6371000;

	/**
	 * This function computes a new point which is the gps point transformed by a 3D
	 * vector (in meters), the function is using a function that change a geometric
	 * coordinate to a cartesian coordinate.
	 * 
	 * @param gps                   point
	 * @param local_vector_in_meter that will bring us to the new point
	 * @return the new gps point.
	 */
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// changing the point gps from coordinates polar to cartesian
		gps.chang_Geometric_To_Cart();
		Point3D temp = new Point3D(gps);
		temp.add(local_vector_in_meter);
		return temp;
	}
	
	/**
	 * This function computes the 2D distance (in meters) between the two gps like
	 * points we used the file Excel that was send to use by Boaz.
	 * 
	 * @param gps0 the first point
	 * @param gps1 the second point
	 * @return the distance 2D in meters
	 */
	public double distance2d(Point3D gps0, Point3D gps1)
	{
		double lon_norm = Math.cos(gps0.x() * Math.PI / 180);
		double dis_lat = gps1.x() - gps0.x();
		double dis_lon = gps1.y() - gps0.y();
		dis_lat = gps0.d2r(dis_lat);
		dis_lon = gps0.d2r(dis_lon);
		dis_lat = Math.sin(dis_lat) * EARTH_R;
		dis_lon = Math.sin(dis_lon) * EARTH_R * lon_norm;
		double dis = dis_lat * dis_lat + dis_lon * dis_lon;
		return Math.sqrt(dis);
	}

	/**
	 * This function computes the 3D distance (in meters) between the two gps like
	 * points we used the file Excel that was send to use by Boaz.
	 * 
	 * @param gps0 the first point
	 * @param gps1 the second point
	 * @return the distance 3D in meters
	 */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double dis= distance2d(gps0, gps1);
		double dis_alt = gps1.z() - gps0.z();
		dis= dis*dis + dis_alt*dis_alt;
		return Math.sqrt(dis);
	}

	/**
	 * This function computes the 3D vector (in meters) between two gps like points
	 * the function is using a function that change a geometric coordinate to a
	 * cartesian coordinate.
	 * 
	 * @param gps0 the first point
	 * @param gps1 the second point
	 * @return the 3D vector
	 */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		gps0.chang_Geometric_To_Cart();
		gps1.chang_Geometric_To_Cart();
		Point3D vec = new Point3D(gps1.x() - gps0.x(), gps1.y() - gps0.y(), gps1.z() - gps0.z());
		return vec;
	}

	/**
	 * This function computes the polar representation of the 3D vector be
	 * gps0-->gps1 the function calculate the azimuth, the elevation and the
	 * distance we used:
	 * https://he.wikipedia.org/wiki/%D7%90%D7%96%D7%99%D7%9E%D7%95%D7%98
	 * http://www.damada.co.il/topics/math/db/trigo_right_triangle/trigo_right_triangle.shtml
	 * 
	 * @param gps0 the first point
	 * @param gps1 the second point
	 * @return Double array- arr[0]- azimuth, arr[1]- elevation, arr[2]- distance
	 */
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// calculating the azimuth
		double azi_x = gps1.x() - gps0.x();
		double azi_y = gps1.y() - gps0.y();
		double x = Math.abs(Math.atan(azi_y / azi_x)*(180/Math.PI));
		
		double azi=0;
		if (azi_x>0 && azi_y>0)
			azi = x;
		else if (azi_x<0 && azi_y>0)
			azi = 180-x;
		else if (azi_x<0 && azi_y<0)
			azi = 180+x;
		else 
			azi = 360-x;
		

		// calculating the distance
		double dis = distance3d(gps0, gps1);

		// calculating the elevation
		double dis_2D = distance2d(gps0, gps1);
		double ang = Math.acos(dis_2D / dis);
		double elev = dis * (Math.sin(ang));


		double[] ans = { azi, elev, dis };

		return ans;
	}

	/**
	 * This function verify if this point is a valid lat, lon , alt coordinate:
	 * [-180,+180],[-90,+90],[-450, +inf]
	 * 
	 * @param p 3D point
	 * @return true- if the point is valid, false- otherwise
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		p.chang_Cart_To_Geometric();
		if (p.x() < -180 || p.x() > 180) // verify if the lat is correct
			return false;
		if (p.y() < -90 || p.y() > 90) // verify if the lon is correct
			return false;
		if (p.z() < -450) // verify if the alt is correct
			return false;
		return true;
	}

}