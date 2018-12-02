package GIS;

import java.text.ParseException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws ParseException {

		MyGIS_Element e1 = new MyGIS_Element(
				"80:26:89:0d:4f:84,DIR-825-4f83,[WPA2-PSK-CCMP][WPS][ESS],2017-12-01 10:50:05,1,-68,32.17244003231061,34.81291470608912,31.60427366454716,3,WIFI");
		MyGIS_Element e2 = new MyGIS_Element(
				"00:78:9e:f9:e8:58,Hotbox,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-12-01 10:50:11,11,-91,32.1725225188478,34.81247911919242,31.65132309930995,6,WIFI");
		MyGIS_Element e3 = new MyGIS_Element(
				"c4:04:15:60:6a:b5,Ben Ami_2.4,[WPA2-PSK-CCMP][WPS][ESS][BLE],2017-12-01 10:50:29,11,-73,32.171728186062275,34.8118405837912,31.30445033277722,4,WIFI");
		MyGIS_Element e4 = new MyGIS_Element(
				"c4:12:f5:85:27:c2,varda,[WPA2-PSK-CCMP][ESS][BLE],2017-12-01 10:50:32,1,-88,32.17154067297358,34.811768201385796,31.186797226280795,4,WIFI");
		MyGIS_Element e5 = new MyGIS_Element(
				"3c:1e:04:07:2a:ff,ronkla2_5,[WPA2-PSK-CCMP][ESS][BLE],2017-12-01 10:50:35,48,-85,32.17135803478369,34.81168874408503,31.090525572576986,6,WIFI");
		MyGIS_Element e6 = new MyGIS_Element(
				"16:ae:db:c1:ae:55,Fuck Off Yourself,[WPA2-PSK-CCMP][WPS][ESS],2017-12-01 10:57:26,9,-79,32.16927107246911,34.81201044802282,27.21999505256496,3,WIFI");
		MyGIS_Element e7 = new MyGIS_Element(
				"86:2a:a8:eb:a9:60,Mheta_AP,[WPA2-PSK-CCMP][ESS],2017-12-01 10:57:26,6,-90,32.16927107246911,34.81201044802282,27.21999505256496,3,WIFI");
		MyGIS_Element e8 = new MyGIS_Element(
				"d8:5d:4c:d1:4d:b0,Yotam _ work _ room,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP-preauth][ESS],2017-12-01 10:58:23,9,-68,32.17107862941617,34.81330158971711,28.915995433589472,3,WIFI");
		MyGIS_Element e9 = new MyGIS_Element(
				"a0:4f:d4:45:1f:a1,nurit,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS][BLE],2017-12-01 10:58:26,1,-78,32.17110086640514,34.813083395926654,28.87277115238635,3,WIFI");
		MyGIS_Element e10 = new MyGIS_Element(
				"62:b2:55:67:2b:86,Bezeq Free 672B84,[ESS],2017-12-01 10:59:32,6,-92,32.17092410916535,34.81275918581424,29.998889595076953,2,WIFI");
		MyGIS_Element e11 = new MyGIS_Element(
				"20:0c:c8:2b:2a:14,nina,[WPA2-PSK-CCMP][WPS][ESS],2017-12-01 10:59:50,11,-76,32.16964553962474,34.812198841457004,30.62408958535301,3,WIFI");
		MyGIS_Element e12 = new MyGIS_Element(
				"e8:94:f6:e2:6e:4b,frank,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-12-01 11:00:34,6,-65,32.17019624834832,34.81245570309557,29.861150924216155,3,WIFI");

		ArrayList<GIS_element> x = new ArrayList<GIS_element>();
		x.add(e1);
		x.add(e2);
		x.add(e3);
		x.add(e4);
		x.add(e5);
		x.add(e6);
		ArrayList<GIS_element> y = new ArrayList<GIS_element>();
		y.add(e7);
		y.add(e8);
		y.add(e9);
		y.add(e10);
		y.add(e11);
		y.add(e12);
		
		MyGIS_layer p1 = new MyGIS_layer(x);		
		MyGIS_layer p2 = new MyGIS_layer(y);
		
		MyGIS_layer[] ans = new MyGIS_layer[2];
		ans[0] = p1;
		ans[1] = p2;
		MyGIS_project pol = new MyGIS_project(ans);
		
		//System.out.println(pol.toString());
		System.out.println(pol.project2kml());
	}

}
