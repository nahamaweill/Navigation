package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

public class Csv2kml {

	final String startKml_untill_3_line = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
			+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n"
			+ "";

	public ArrayList<String[]> loadCsvLine(String csvFile) throws FileNotFoundException {
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String[]> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				String[] dataLine = line.split(csvSplitBy);
				data.add(dataLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public StringBuilder kmlPlacemark(String csvFile) throws FileNotFoundException {
		ArrayList<String[]> data = loadCsvLine(csvFile);
		StringBuilder sb = new StringBuilder();
		sb.append(startKml_untill_3_line);
		String ans;
		for (int i = 2; i < data.size(); i++) {
			ans = "<Placemark>/n " + "<name><!CDATA[" + data.get(i)[1] + "]]></name>/n"
					+ "<description><![CDATA[BSSID :<b>" + data.get(i)[0] + "</b><br/>Capabilities:<b>" + data.get(i)[2]
					+ "</b><br/>Channel:<b>" + data.get(i)[4] + "</b><br/>RSSI:<b>" + data.get(i)[5]
					+ "</b><br/>Date:<b>" + data.get(i)[3] + "</b>]]></description><styleUrl>#red</styleUrl>/n"
					+ "<Point>/n" + "<Coordinates>" + data.get(i)[6] + "," + data.get(i)[7] + "</Coordinates></Point>/n"
					+ "</Placemark>";
			sb.append(ans);
		}
		sb.append("</Folder>\r\n" + "</Document></kml>");
		return sb;
	}

	public void createKmlFile(String newFile, String csvFile) throws FileNotFoundException, IOException {
		StringBuilder sb = kmlPlacemark(csvFile);
		try {
			PrintWriter pw = new PrintWriter(new File(newFile));
			pw.write(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
