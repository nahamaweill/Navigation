package GIS;

import java.util.ArrayList;
import java.util.Date;

public class MyMeta_data_project {

	ArrayList<MyMeta_data_layer> data = new ArrayList<MyMeta_data_layer>();
	long UTC;
	
	public MyMeta_data_project() {
		UTC = new Date().getTime();
	}

	/**
	 * 
	 * That function add a My meta data layer to the project
	 * @param the My meta data layer to add
	 */
	public void add(MyMeta_data_layer arg0) {
		data.add(arg0);
	}
	/**
	 * The function return a String of all the data of the project
	 * @return the data of the project
	 */

	@Override
	public String toString() {
		String h = "MyMeta_data_project :\n";
		for (int i = 0; i < data.size(); i++) {
			h = h + "data - " + data.get(i).toString();
		}
		return h;
	}

}
