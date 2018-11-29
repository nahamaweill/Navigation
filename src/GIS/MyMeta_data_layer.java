package GIS;

import java.util.ArrayList;

public class MyMeta_data_layer {

	ArrayList<MyMeta_data> data = new ArrayList<MyMeta_data>();
	
	public MyMeta_data_layer() {
		data = new ArrayList<MyMeta_data>();
	}
	
	public MyMeta_data_layer(String[] s) {
		for (int i = 0; i < s.length; i++) {
			data.add(new MyMeta_data(s[i]));
		}
	}
	
	public MyMeta_data_layer(ArrayList<MyMeta_data> data) {
		for (int i = 0; i < data.size(); i++) {
			data.add(new MyMeta_data(data.get(i)));
		}
	}

	public void add(MyMeta_data arg0) {
		data.add(arg0);
	}

	@Override
	public String toString() {
		String h = "MyMeta_data_layer : \n";
		for (int i = 0; i < data.size(); i++) {
			h = h + "data - " + data.get(i).toString();
		}
		return h;
	}

}
