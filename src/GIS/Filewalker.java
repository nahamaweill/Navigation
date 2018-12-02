package GIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import File_format.Csv2kml;;

public class Filewalker {

	/**
	 * This function read a file csv and return a Array List of Array of strings, every array contain a line in the file.
	 * 
	 * @param csvFile that which provides us the data
	 * @return data a Array List of Array of strings, every array contain a line in the file.
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String[]> loadCsvLine(String csvFile) throws FileNotFoundException {
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String[]> data = new ArrayList<>();
		String[] dataLine;
		if (csvFile.charAt(csvFile.length() - 1) == 'v') {
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				while ((line = br.readLine()) != null) {
					dataLine = line.split(csvSplitBy);
					data.add(dataLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	
	public ArrayList<String> walk(String path) throws Exception {

		ArrayList<String> ans = new ArrayList<String>();
		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			ans = null;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				ans.add(f.toString());
				System.out.println("File:" + f.getAbsoluteFile());
			}
		}
		return ans;
	}
	/**
	 * This function create a MyGIS project from the file csv.
	 * 
	 * @param file csv with the data of the project
	 * @return a MyGIS project
	 * @throws Exception
	 */
	public static MyGIS_project creat_project(ArrayList<String> file) throws Exception {
		MyGIS_layer[] layers = new MyGIS_layer[file.size()];
		for (int i = 0; i < file.size(); i++) {
			ArrayList<String[]> ans = loadCsvLine(file.get(i));
			MyGIS_layer layer = creat_Layer(ans);
			layers[i] = layer;
		}
		MyGIS_project project = new MyGIS_project(layers);
		return project;
	}
	/**
	 * This function create a MyGIS layer from the file csv.
	 * 
	 * @param the data of the layer from the file
	 * @return a MyGIS layer
	 */
	public static MyGIS_layer creat_Layer(ArrayList<String[]> layer) {
		MyGIS_Element element;
		ArrayList<GIS_element> ans = new ArrayList<GIS_element>();
		for (int i = 2; i < layer.size(); i++) {
			element = creat_Element(layer.get(i));
			ans.add(element);
		}
		MyGIS_layer lay = new MyGIS_layer(ans);
		return lay;

	}
	/**
	 * This function create a MyGIS element from the file csv.
	 * 
	 * @param the data of the element from the file
	 * @return a MyGIS element
	 */
	public static MyGIS_Element creat_Element(String[] element) {
		String full = "";
		for (int i = 0; i < element.length - 1; i++) {
			full = full + element[i] + ",";
		}
		full = full + element[element.length - 1];
		MyGIS_Element elem = new MyGIS_Element(full);
		return elem;
	}

//    public static 

	public static void main(String[] args) throws Exception {
		Filewalker fw = new Filewalker();
		ArrayList<String> h = fw.walk("C:\\Users\\DELL\\Desktop\\Ex2\\Ex2\\data");
		MyGIS_project ans = creat_project(h);

//		System.out.println(ans.toString());
		ans.newProjectkml("ans.kml");


	}

}
