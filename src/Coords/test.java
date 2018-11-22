package Coords;

import Geom.Point3D;

public class test {
	public static void main(String[]args)
	{
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.106352,35.205225,650);
		Point3D vec=new Point3D(32.106352,35.205225,650);
		//double ans= p.distance3d(p1, p2);
		
		double ans= p.distance3d(p1, p2);
		System.out.println(ans);


	}
}
