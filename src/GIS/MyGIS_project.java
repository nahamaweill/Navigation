package GIS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyGIS_project implements GIS_project {

	final String startKml_untill_3_line = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
			+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\">" + "\n" + "<Document><Folder>\n";

	final String endKml_2_lines = "</Folder>\n</Document></kml>";

	ArrayList<GIS_layer> listLayer = new ArrayList<GIS_layer>();
	MyMeta_data_project data = new MyMeta_data_project();

	/**
	 * A defaultiv constructor
	 */
	public MyGIS_project() {
		listLayer = new ArrayList<GIS_layer>();
		data = new MyMeta_data_project();
	}

	/**
	 * A constructor that get a Array List of Array of Strings
	 * 
	 * @param s the Array List of Array of Strings
	 */

	public MyGIS_project(ArrayList<String[]> s) {
		for (int i = 0; i < s.size(); i++) {
			MyGIS_layer ans = new MyGIS_layer(s.get(i));
			listLayer.add(ans);
			data.add(ans.get_Meta_data());
		}
	}

	/**
	 * A constructor that get a Array of MyGIS layer
	 * 
	 * @param list of Array of MyGIS layer
	 */

	public MyGIS_project(MyGIS_layer[] list) {
		for (int i = 0; i < list.length; i++) {
			MyGIS_layer ans = new MyGIS_layer(list[i]);
			listLayer.add(ans);
			data.add(list[i].get_Meta_data());
		}

	}

	/**
	 * The function add a layer to the project
	 * 
	 * @param arg0 the layer we want to add
	 * @return true if the layer was added
	 */

	@Override
	public boolean add(GIS_layer arg0) {
		return listLayer.add(arg0);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public boolean addAll(Collection<? extends GIS_layer> arg0) {
		return listLayer.addAll(arg0);
	}

	/**
	 * This function clear the project
	 */
	@Override
	public void clear() {
		listLayer.clear();
	}

	/**
	 * This function check if the project contain the object arg0
	 * 
	 * @param arg0 the object to check
	 * @return True if the project contain the object, false otherwise
	 */
	@Override
	public boolean contains(Object arg0) {
		return listLayer.contains(arg0);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		return listLayer.containsAll(arg0);
	}

	/**
	 * The function check if the project is empty
	 * 
	 * @return true if the project is empty and false otherwise
	 */

	@Override
	public boolean isEmpty() {
		return listLayer.isEmpty();
	}

	/**
	 * 
	 * 
	 * 
	 */

	@Override
	public Iterator<GIS_layer> iterator() {
		return listLayer.iterator();
	}

	/**
	 * This function remove an Object from the project
	 * 
	 * @param arg0 the object to remove
	 */

	@Override
	public boolean remove(Object arg0) {
		return listLayer.remove(arg0);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return listLayer.removeAll(arg0);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return listLayer.retainAll(arg0);
	}

	/**
	 * This function return the size of the project
	 * 
	 * @param the size of the project
	 */

	@Override
	public int size() {
		return listLayer.size();
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public Object[] toArray() {
		return listLayer.toArray();
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public <T> T[] toArray(T[] arg0) {
		return listLayer.toArray(arg0);
	}

	/**
	 * The function return a String of all the data of the project
	 * 
	 * @return the data of the project
	 */

	@Override
	public String toString() {
		String h = "MyGIS_project : \n\n";
		for (int i = 0; i < listLayer.size(); i++) {
			h = h + listLayer.get(i).toString();
			// + " data = \n" + data.toString();
		}
		return h;
	}

	/**
	 * This function return the data of the project
	 * 
	 * @return the data of the project
	 */

	@Override
	public Meta_data get_Meta_data() {
		return (Meta_data) this.data;
	}

	public String project2kml() {
		String ans = "";
		for (int i = 0; i < listLayer.size(); i++) {
			for (int j = 0; j < listLayer.get(i).size(); j++) {
				ans = ans + listLayer.get(i).get_Meta_data().data.get(j).getDataView() + "\n";
			}
		}
		return ans;
	}

	public String csv2kml_p() {
		String s = project2kml();
		String[] k = s.split("\n");
		String[] d;
		String ans = "";
		for (int i = 0; i < k.length; i++) {
			ans = "<Placemark>\n" + "<name>" + data.get(i)[1] + "</name>\n" + "<description>" + data.get(i)[10]
					+ "</description>\n" + "<Point><coordinates>" + data.get(i)[7] + "," + data.get(i)[6] + ","
					+ data.get(i)[8] + "</coordinates></Point>\n" + "<time>" + data.get(i)[3] + "</time></Placemark>\n";
			s = s + ans;
		}
	}

	public void newProjectkml(String File, String newFileLocation) throws FileNotFoundException {
		String s = this.project2kml();
		try {
			PrintWriter pw = new PrintWriter(new File(newFileLocation));
			pw.write(startKml_untill_3_line);
			pw.write(s);
			pw.write(endKml_2_lines);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
