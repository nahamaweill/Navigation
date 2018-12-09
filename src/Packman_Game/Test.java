package Packman_Game;

import Geom.Point3D;

public class Test {
	public static void main(String[] args) {
		Point3D pStart= new Point3D (32.10571,35.20232);
		Point3D pEnd= new Point3D (32.10180,35.21239);
		pStart.chang_Geometric_To_Cart();
		pEnd.chang_Geometric_To_Cart();
		
		double x=pEnd.get_x()-pStart.get_x();
		double ans = x/1433;
		double y=pEnd.get_y()-pStart.get_y();
		double ans1 = y/642;
		System.out.println(ans);
		System.out.println(ans1);
	}
}
