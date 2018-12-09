package Geom;

import java.io.Serializable;
public class Point3D implements Geom_element, Serializable 
{
	/**
	 * This class represents a 3D point in space.
	 */
	private static final long serialVersionUID = 1L;
	private double _x,_y,_z;

	
	
	public Point3D(double x,double y,double z) 
	{
		_x=x;
		_y=y;
		_z=z;
	}

	public Point3D(Point3D p) 
	{
		_x=p.x();
		_y=p.y();
		_z=p.z();
	}
	public Point3D(double x,double y) 
	{
		this(x,y,0);
	}
	public double get_x() {
		return _x;
	}

	public void set_x(double _x) {
		this._x = _x;
	}

	public double get_y() {
		return _y;
	}

	public void set_y(double _y) {
		this._y = _y;
	}

	public double get_z() {
		return _z;
	}

	public void set_z(double _z) {
		this._z = _z;
	}

	public Point3D(String s) 
	{
		String[] a = s.split(",");
		_x = Double.parseDouble(a[0]);
		_y = Double.parseDouble(a[1]);
		_z = Double.parseDouble(a[2]);
	}
	///////////////////////////////////////////////////////////////////////////
	////////////////////////////       methods        /////////////////////////
	///////////////////////////////////////////////////////////////////////////


	public double x()
	{
		return _x;
	}
	public double y()
	{
		return _y;
	}
	public double z() 
	{
		return _z;
	}
	public int ix() 
	{
		return (int)_x;
	}
	public int iy() 
	{
		return (int)_y;
	}
	public int iz() 
	{
		return (int)_z;
	}

	public void add(Point3D p)
	{
		add(p._x,p._y,p._z);
	}
	public void add(double dx, double dy, double dz)
	{
		_x+=dx;
		_y+=dy;
		_z+=dz;
	}
	public void add(double x, double y)
	{
		this.add(x,y,0);
	}

	public String toString() 
	{
		return ""+_x+","+_y+","+_z;
	}
	public double distance2D(Point3D p2)
	{ 
		return this.distance3D(p2.x(), p2.y(), this.z());
	}
	public double distance3D(Point3D p2)
	{
		return this.distance3D(p2.x(), p2.y(), p2.z());
	}
	public double distance3D(double x, double y , double z)
	{
		double dx = _x-x;
		double dy = _y-y;
		double dz = _z-z;
		double t = dx*dx+dy*dy+dz*dz;
		return Math.sqrt(t);
	}

	public boolean equals(Point3D p2)
	{
		return ( (_x==p2._x) && (_y==p2._y) && (_z==p2._z) );
	}
	public boolean close2equals(Point3D p2, double dist)
	{
		return ( this.distance3D(p2)< dist );
	}
	public boolean equalsXY (Point3D p)
	{
		return p._x == _x && p._y == _y;
	}

	public String toFile() 
	{
		return _x+","+_y+","+_z;
	}

	public String toFile1()  
	{
		return "Point3D "+_x+" "+_y+" "+_z;
	}

	////////////////////////////////////////////////////////////////////////////////////////

	public final static int ONSEGMENT = 0,  LEFT = 1, RIGHT = 2, INFRONTOFA = 3, BEHINDB = 4, ERROR = 5;
	public final static int DOWN = 6, UP = 7;

	/** return up iff this point is above the SEGMENT (not the line) 
	 * 
	 * @param a represent a point
	 * @param b represent a point
	 * @return a line test 
	 */
	public int pointLineTest2(Point3D a, Point3D b)
	{
		int flag = this.pointLineTest(a,b);
		if(a._x < b._x )
		{
			if(a._x<=_x && b._x>_x)
			{
				if (flag == LEFT)
					return DOWN;
				if (flag == RIGHT)
					return UP;
			}
		}
		else 
			if(a._x > b._x )
			{
				if(b._x<=_x && a._x>_x)
				{
					if (flag == RIGHT) 
						return DOWN;
					if (flag == LEFT) 
						return UP;
				}
			}	
		return flag;
	}


	public int pointLineTest(Point3D a, Point3D b)
	{

		if(a== null || b==null || a.equalsXY(b)) 
			return ERROR;

		double dx = b._x-a._x;
		double dy = b._y-a._y;
		double res = dy*(_x-a._x)-dx*(_y-a._y);

		if (res < 0)
			return LEFT;
		if (res > 0)
			return RIGHT;

		if (dx > 0)
		{
			if (_x < a._x)
				return INFRONTOFA;
			if (b._x < _x)
				return BEHINDB;
			return ONSEGMENT;
		}
		if (dx < 0) 
		{
			if (_x > a._x)
				return INFRONTOFA;
			if (b._x > _x)
				return BEHINDB;
			return ONSEGMENT;
		}
		if (dy > 0) 
		{
			if (_y < a._y)
				return INFRONTOFA;
			if (b._y < _y)
				return BEHINDB;
			return ONSEGMENT;
		}
		if (dy < 0)
		{
			if (_y > a._y)
				return INFRONTOFA;
			if (b._y > _y) 
				return BEHINDB;
			return ONSEGMENT;
		}
		return ERROR;
	}


	////////////////////////////////////////////////////////////////
	public void rescale(Point3D center, Point3D vec)
	{
		if(center!=null && vec != null)
			rescale(center,vec.x(),vec.y(),vec.z());
	}

	public void rescale(Point3D center, double size)
	{
		if(center!=null && size>0)
			rescale(center,size,size,size);
	}
	private void rescale(Point3D center, double sizeX,double sizeY, double sizeZ)
	{
		_x = center._x + ((_x - center._x) * sizeX);
		_y = center._y + ((_y - center._y) * sizeY);
		_z = center._z + ((_z - center._z) * sizeZ);
	} 

	public void rotate2D(Point3D center, double angle)
	{
		// angle -1/2PI .. 1/2Piregular degrees. 
		_x = _x - center.x();
		_y = _y - center.y();
		double a = Math.atan2(_y,_x);
		//	System.out.println("Angle: "+a);
		double radius = Math.sqrt((_x*_x) + (_y*_y));
		_x = (center.x() +  radius * Math.cos(a+angle));
		_y = (center.y() +  radius * Math.sin(a+angle));
	}								
	/** 
	 * computes the angleXY between p1 and p2 in RADIANS: <br><br>
	 * up:(PI/2)  , down (-PI/2) , right(0),  left(+- PI).   [-PI, +PI]
	 * @param p the point 
	 * @return the angleXY
	 */
	public double angleXY(Point3D p)
	{
		if(p==null)
			throw new RuntimeException("** Error: Point3D angle got null **");
		return Math.atan2((p._y-_y), (p._x-_x));
	}
	/** 
	 * computes the angleXY between p1 and p2 in RADIANS: <br><br>
	 * up:(PI/2)  , down (1.5PI) , right(0),  left(PI).   [0,2PI].
	 * @param p the point 
	 * @return the angleXY
	 */
	public double angleXY_2PI(Point3D p)
	{
		if(p==null)
			throw new RuntimeException("** Error: Point3D angle got null **");
		double ans = Math.atan2((p._y-_y), (p._x-_x));
		if (ans<0)
			ans = 2*Math.PI+ans;
		return ans;
	}
	/** computes the angleZ between p1 and p2 in RADIANS 
	 * @param p the point 
	 * @return the angleZ
	 */
	public double angleZ(Point3D p) 
	{
		if(p==null)
			throw new RuntimeException("** Error: Point3D angleZ got null **");
		return Math.atan2((p._z-_z), this.distance2D(p));
	}	
	/** return the (planer angle of the vector between this -- p, in DEGREES, in a
	 * compass order: north 0, east 90, south 180, west 270.
	 * @param p is the end point of the vector (z value is ignored). 
	 * @return angle in compass styye [0,360).
	 */
	public double north_angle(Point3D p)
	{
		double ans = 0;
		double a_rad = Math.atan2((p._y-_y), (p._x-_x));
		double a_deg = Math.toDegrees(a_rad);
		if(a_deg<=90) 
			ans = 90-a_deg;
		else
			ans = 450-a_deg;
		return ans;
	}
	/** return the vertical angles in DEGREES of the vector this--p
	 * 
	 * @param p the point
	 * @return the up angele
	 */
	public double up_angle(Point3D p)
	{
		double ans = 0;
		ans = Math.atan2((p._z-_z), this.distance2D(p));
		return Math.toDegrees(ans);
	}
	/** 
	 * return the vertical angles in DEGREES of the vector this--p, 
	 * @param h: is the extra height of the point p (used by GISElement).
	 * @param p represent a point
	 * @return the up angle
	 */
	public double up_angle(Point3D p, double h)
	{
		double ans = 0;
		ans = Math.atan2((p._z+h-_z), this.distance2D(p));
		return Math.toDegrees(ans);
	}
	/** transform from radians to angles
	 * 
	 * @param a number radian
	 * @return the number in degree
	 */
	public static double r2d(double a)
	{
		return Math.toDegrees(a);
	}
	/** transform from angles to radians
	 * 
	 * @param a number degree
	 * @return the number in radian
	 */
	public static double d2r(double a)
	{
		return Math.toRadians(a);
	}
	////////////////////////////////////////////////////////////////////////////////
	public final static int EARTH_R=6371000;
	public final static double R = 0.000008993;

	/**
	 * The function change the point gps from coordinates geometric to cartesian
	 */
	public void chang_Geometric_To_Cart()
	{
		//changing the point gps from coordinates geometric to cartesian
		// we used https://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
		
//		this._y= this.y()*R;
//		this._x= this.x()*R/ Math.cos(this.y()*(Math.PI/180));
		
		this._x=Math.toRadians(_x);// X From GPS To Rad
		this._y=Math.toRadians(_y);// Y From GPS To Rad
		this._x=Math.sin(_x)*6371000;
		this._y=Math.sin(_y)*6371000*0.847091174;
		
	}
	/** 
	 * The function change the point gps from coordinates cartesian to geometric
	 */
	
	public void chang_Cart_To_Geometric()
	{
		//changing the point gps from coordinates cartesian to geometric
		// we used https://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
		
//		double y = this.y()/R;
//		double x =  (this.x()*Math.cos(this.y()*(Math.PI/180))/R);
//		this._y = y;
//		this._x = x;
		
		this._x=_x/6371000;
		this._y=(_y/6371000)/0.847091174;
		this._x=Math.asin(_x);
		this._y=Math.asin(_y);
		this._x=Math.toDegrees(_x);
		this._y=Math.toDegrees(_y);
		
	}
}
