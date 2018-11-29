package GIS;

import java.text.ParseException;

public class Test {

	public static void main(String[] args) throws ParseException {
		//2018-11-28 15:25:35
		MyMeta_data d= new MyMeta_data("00:78:9e:f9:e8:58,Hotbox,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-12-01 10:50:11,11,-91,32.1725225188478,34.81247911919242,31.65132309930995,6,WIFI");
		String ans= d.UTFFormat();
		System.out.println(ans);
		
	}

}
