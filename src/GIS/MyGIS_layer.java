package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyGIS_layer implements GIS_layer {

	private ArrayList<GIS_element> layer = new ArrayList<GIS_element>();
	private MyMeta_data_layer data = new MyMeta_data_layer();

	public MyGIS_layer(ArrayList<GIS_element> x) {
		for (int i = 0; i < x.size(); i++) {
			layer.add(x.get(i));
			data.add((MyMeta_data) x.get(i).getData());
		}
	}

	public MyGIS_layer(Set<GIS_element> a) {
		Iterator<GIS_element> iter = a.iterator();
		while (iter.hasNext()) {
			GIS_element p = (GIS_element) iter.next();
			this.layer.add((MyGIS_Element) p);
			this.data.add((MyMeta_data) p.getData());
		}
	}

	public MyGIS_layer(String[] s) {
		for (int i = 0; i < s.length; i++) {
			MyGIS_Element ans = new MyGIS_Element(s[i]);
			layer.add(ans);
			data.add((MyMeta_data) ans.getData());
		}
	}

	@Override
	public boolean add(GIS_element arg0) {
		return layer.add((MyGIS_Element) arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		return layer.addAll((Collection<? extends MyGIS_Element>) arg0);
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
		String h = " MyGIS_layer :\n";
		for (int i = 0; i < layer.size(); i++) {
			h = h + i + ")  " + layer.get(i).toString() + "\n\n";
		}
		return h;
	}

	@Override
	public MyMeta_data_layer get_Meta_data() {
		return this.data;
	}

}
