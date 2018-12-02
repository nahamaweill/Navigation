package GIS;

import java.util.ArrayList;

public class MyMeta_data_layer {

	ArrayList<MyMeta_data> data = new ArrayList<MyMeta_data>();
	
	/**
	 * A defaultiv constructor
	 */
	public MyMeta_data_layer() {
		data = new ArrayList<MyMeta_data>();
	}
	/**
	 * A constructor that get a Array of Strings of element
	 * @param s Array of Strings of element
	 */
	
	public MyMeta_data_layer(String[] s) {
		for (int i = 0; i < s.length; i++) {
			data.add(new MyMeta_data(s[i]));
		}
	}
	/**
	 * A constructor that get a Array List of My meta data of element
	 * @param data a Array List of My meta data of element
	 */
	
	public MyMeta_data_layer(ArrayList<MyMeta_data> data) {
		for (int i = 0; i < data.size(); i++) {
			data.add(new MyMeta_data(data.get(i)));
		}
	}
	/**
	 * That function add a My meta data element to the layer
	 * @param the My meta data element to add
	 * 
	 */

	public void add(MyMeta_data arg0) {
		data.add(arg0);
	}
	/**
	 * 
	 * The function return a String of all the data of the layer
	 * @return the data of the layer
	 */

	@Override
	public String toString() {
		String h = "MyMeta_data_layer : \n";
		for (int i = 0; i < data.size(); i++) {
			h = h + "data - " + data.get(i).toString();
		}
		return h;
	}

}
