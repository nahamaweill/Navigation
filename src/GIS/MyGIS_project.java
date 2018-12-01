package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyGIS_project implements GIS_project {

	ArrayList<GIS_layer> listLayer = new ArrayList<GIS_layer>();
	MyMeta_data_project data = new MyMeta_data_project();

	public MyGIS_project() {
		listLayer = new ArrayList<GIS_layer>();
		data = new MyMeta_data_project();
	}

	public MyGIS_project(ArrayList<String[]> s) {
		for (int i = 0; i < s.size(); i++) {
			MyGIS_layer ans = new MyGIS_layer(s.get(i));
			listLayer.add(ans);
			data.add(ans.get_Meta_data());
		}
	}

	public MyGIS_project(MyGIS_layer[] list) {
		for (int i = 0; i < list.length; i++) {
			MyGIS_layer ans = new MyGIS_layer(list[i]);
			listLayer.add(ans);
			data.add(list[i].get_Meta_data());
		}

	}

	@Override
	public boolean add(GIS_layer arg0) {
		return listLayer.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> arg0) {
		return listLayer.addAll(arg0);
	}

	@Override
	public void clear() {
		listLayer.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return listLayer.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return listLayer.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return listLayer.isEmpty();
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		return listLayer.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return listLayer.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return listLayer.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return listLayer.retainAll(arg0);
	}

	@Override
	public int size() {
		return listLayer.size();
	}

	@Override
	public Object[] toArray() {
		return listLayer.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return listLayer.toArray(arg0);
	}

	@Override
	public String toString() {
		String h = "MyGIS_project : \n\n";
		for (int i = 0; i < listLayer.size(); i++) {
			h = h + listLayer.get(i).toString();
			//+ " data = \n" + data.toString();
		}
		return h;
	}

	@Override
	public Meta_data get_Meta_data() {
		return (Meta_data) this.data;
	}

}
