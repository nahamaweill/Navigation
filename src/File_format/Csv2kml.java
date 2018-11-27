package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

public class Csv2kml {

	final static String startKml_untill_3_line = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
			+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\">" + "\n" + "<Document><Folder>\n";

	final static String endKml_2_lines = "</Folder>\n</Document></kml>";

	public static ArrayList<String[]> loadCsvLine(String csvFile) throws FileNotFoundException {
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

	public static String newKmlFile(String csvFile) throws FileNotFoundException {
		ArrayList<String[]> data = loadCsvLine(csvFile);
		String s = startKml_untill_3_line;
		String ans;
		for (int i = 2; i < data.size(); i++) {
			ans = "<Placemark>\n" + "<name>" + data.get(i)[1] + "</name>\n" + "<description>" + data.get(i)[10]
					+ "</description>\n" + "<Point><coordinates>" + data.get(i)[7] + "," + data.get(i)[6] + ","
					+ data.get(i)[8] + "</coordinates></Point>\n" + "<time>" + data.get(i)[3] + "</time></Placemark>\n";
			s = s + ans;
		}
		s = s + endKml_2_lines;
		return s;
	}

	public static void newOBJkml(String newFile, String csvFile) throws FileNotFoundException {
		String s = newKmlFile(csvFile);
		try {
			PrintWriter pw = new PrintWriter(new File(newFile));
			pw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		newOBJkml("File.kml", "C:\\Users\\DELL\\Desktop\\Ex2\\Ex2\\data\\WigleWifi_20171203085618.csv");
	}

}
