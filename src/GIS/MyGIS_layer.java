package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MyGIS_layer implements GIS_layer {

	ArrayList<GIS_element> layer = new ArrayList<GIS_element>();

	@Override
	public boolean add(GIS_element arg0) {
		return layer.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		return layer.addAll(arg0);
	}

	@Override
	public void clear() {
		layer.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return layer.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return layer.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return layer.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {
		return layer.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return layer.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return layer.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return layer.retainAll(arg0);
	}

	@Override
	public int size() {
		return layer.size();
	}

	@Override
	public Object[] toArray() {
		return layer.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return layer.toArray(arg0);
	}

	@Override
	public String toString() {
		String h = "";
		for (int i = 0; i < layer.size(); i++) {
			h = h + "MyGIS_layer [layer=" + layer.get(i).toString() + "]";
		}
		return h;
	}

	@Override
	public Meta_data get_Meta_data() {
		
		return null;
	}

}
