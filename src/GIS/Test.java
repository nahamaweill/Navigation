package GIS;

import java.text.ParseException;

public class Test {

	public static void main(String[] args) {
		//2018-11-28 15:25:35
		Data d = new Data("40:65:a3:35:4c:c4,Efrat,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2018-11-28 15:25:35,1,-75,32.17218268216534,34.81446401702757,13.65040888895076,6,WIFI");
		long h = d.getUTC();
		System.out.println(h);
	}

}
