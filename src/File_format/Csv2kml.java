package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Csv2kml {
	public static List<String[]> loadCsvFile(String fileWithPath, String delimiter) {
		// read CSV file
		Vector<String[]> list = new Vector<String[]>();
		if (delimiter == null || delimiter.equals("")) {
			delimiter = ",";
		}
		BufferedReader reader = null;
		String readString;
		try {
			// open file
			reader = new BufferedReader(new FileReader(new File(fileWithPath)));
			while ((readString = reader.readLine()) != null) {
				list.add(readString.split(delimiter));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static HashMap<String, HashMap<String, Double>> readMultiDataFromCsv(String fileWithPath, int codeColumn,
			int dataColumn, int multiColumn) {

		// read CSV file
		List<String[]> stringVector = loadCsvFile(fileWithPath, ",\"");
		int size = stringVector.size(); // size of rows in the CSV file
		HashMap<String, HashMap<String, Double>> dataMap = new HashMap<String, HashMap<String, Double>>();
		double max = Double.NEGATIVE_INFINITY;
		double min = Double.POSITIVE_INFINITY;
		String regex = "\"";
		String replacement = "";
		String code, data, multiData;

		// ignore header, start with index 1
		for (int i = 1; i < size; i++) {
			String[] row = stringVector.get(i); // get row with index i: array of strings (for each column)
			code = row[codeColumn].replaceAll(regex, replacement).trim();
			data = row[dataColumn].replaceAll(regex, replacement).trim();
			multiData = row[multiColumn].replaceAll(regex, replacement).trim();

			if (!dataMap.containsKey(code)) {
				HashMap<String, Double> tmp = new HashMap<String, Double>();
				dataMap.put(code, tmp);
			}
			HashMap<String, Double> nested = dataMap.get(code);
			double value = new Double(data);
			nested.put(multiData, new Double(value));

			// save minimum and maximum
			max = Math.max(value, max);
			min = Math.min(value, min);
		}

		// save min and max to HashMap
		HashMap<String, Double> minmax = new HashMap<String, Double>();
		minmax.put("minimum", min);
		minmax.put("maximum", max);
		dataMap.put("info", minmax);
		return dataMap;
	}

}
