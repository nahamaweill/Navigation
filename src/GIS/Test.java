package GIS;

import java.text.ParseException;

public class Test {

	public static void main(String[] args) throws ParseException {
		//2018-11-28 15:25:35
		MyMeta_data d= new MyMeta_data("42501_13111_7943940,Partner,UNKNOWN;il,2017-12-01 10:50:05,0,-99,32.17244003231061,34.81291470608912,31.60427366454716,3,GSM\r\n");
		long ans= d.getUTC();
		System.out.println(ans);
		
	}

}
