package GIS;

import java.text.ParseException;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		MyGIS_Element e1= new MyGIS_Element("80:26:89:0d:4f:84,DIR-825-4f83,[WPA2-PSK-CCMP][WPS][ESS],2017-12-01 10:50:05,1,-68,32.17244003231061,34.81291470608912,31.60427366454716,3,WIFI");
		MyGIS_Element e2= new MyGIS_Element("00:78:9e:f9:e8:58,Hotbox,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-12-01 10:50:11,11,-91,32.1725225188478,34.81247911919242,31.65132309930995,6,WIFI");

		MyGIS_layer l = new MyGIS_layer();
		l.add(e1);
		l.add(e2);
		System.out.println(l.toString());
	}

}
