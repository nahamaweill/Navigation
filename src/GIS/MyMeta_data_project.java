package GIS;

import java.util.ArrayList;

public class MyMeta_data_project {

	ArrayList<MyMeta_data_layer> data = new ArrayList<MyMeta_data_layer>();

	public void add(MyMeta_data_layer arg0) {
		data.add(arg0);
	}

	@Override
	public String toString() {
		String h = "MyMeta_data_project :\n";
		for (int i = 0; i < data.size(); i++) {
			h = h + "data - " + data.get(i).toString();
		}
		return h;
	}

}
