package Coords;

import Geom.Point3D;

public class test {
	public static void main(String[]args)
	{
//		MyCoords p=new MyCoords();
//		Point3D p1=new Point3D(32.103306, 35.209028,670);
//		Point3D p2=new Point3D(32.106352,35.205225,650);
////		Point3D vec=new Point3D(0.0030369999999990682,-0.0038139999999984298,-20.0);
//		Point3D vec=new Point3D(4419.031773198498,3118.3281829347993,3370.555085323563);
//	//	double ans= p.distance3d(p1, p2);
//		
//		Point3D vec1= p.vector3D(p1, p2);
//		System.out.println(vec1.toString());
//		
//		Point3D p3= p.add(p1, vec1);
//		System.out.println(p3.toString());
//		
////	    p1.chang_Geometric_To_Cart();
////		System.out.println(p1.toString());
//		
		MyCoords p=new MyCoords();
		Point3D p1=new Point3D(32.103315,35.209039,670);
		Point3D p2=new Point3D(32.106352,35.205225,650);
		double[] ans = p.azimuth_elevation_dist(p1, p2);
		System.out.println("azi: "+ans[0]+" elev: "+ans[1]+" dis: "+ans[2]);

		
	}
}
