package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyGIS_layer implements GIS_layer {

	 ArrayList<GIS_element> layer = new ArrayList<GIS_element>();
	 MyMeta_data_layer data = new MyMeta_data_layer();

	/**
	 * A constructor that get a Array List of GIS elements
	 * 
	 * @param x Array List of GIS elements
	 */
	public MyGIS_layer(ArrayList<GIS_element> x) {
		for (int i = 0; i < x.size(); i++) {
			layer.add(x.get(i));
			data.add((MyMeta_data) x.get(i).getData());
		}
	}

	/**
	 * A constructor that get a collection of GIS elements 
	 * 
	 * @param a collection of GIS elements
	 */
	public MyGIS_layer(Set<GIS_element> a) {
		Iterator<GIS_element> iter = a.iterator();
		while (iter.hasNext()) {
			GIS_element p = (GIS_element) iter.next();
			this.layer.add((MyGIS_Element) p);
			this.data.add((MyMeta_data) p.getData());
		}
	}

	/**
	 * A constructor that get a Array of Strings of element
	 * 
	 * @param s Array of Strings of element
	 */
	public MyGIS_layer(String[] s) {
		for (int i = 0; i < s.length; i++) {
			MyGIS_Element ans = new MyGIS_Element(s[i]);
			layer.add(ans);
			data.add((MyMeta_data) ans.getData());
		}
	}
	/**
	 * That function add a GIS element to the GIS layer
	 * 
	 * @param arg0 the GIS_Element to add
	 * @return true if the element was added
	 */
	
	@Override
	public boolean add(GIS_element arg0) {
		return layer.add((MyGIS_Element) arg0);
	}
	/**
	 * That function add a collection to the GIS layer
	 * 
	 * @param arg0 a collection to add
	 * @return true if the collection was added
	 */

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		return layer.addAll((Collection<? extends MyGIS_Element>) arg0);
	}
	/**
	 * This function clear the layer
	 */

	@Override
	public void clear() {
		layer.clear();
	}
	/**
	 * This function check if the layer contain the object arg0
	 * 
	 * @param arg0 the object to check
	 * @return True if the layer contain the object, false otherwise 
	 */

	@Override
	public boolean contains(Object arg0) {
		return layer.contains(arg0);
	}
	/**
	 * This function check if the layer contain the collection arg0
	 * 
	 * @param arg0 the collection to check
	 * @return True if the layer contain this collection, false otherwise 
	 */

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return layer.containsAll(arg0);
	}
	/**
	 * The function check if the layer is empty
	 * 
	 * @return true if the layer is empty and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return layer.isEmpty();
	}
	/**
	 * This function return an Array List pointer
	 * 
	 * @return the Array List pointer
	 */
	@Override
	public Iterator<GIS_element> iterator() {
		return layer.iterator();
	}
	/**
	 * This function remove an Object from the layer
	 * 
	 * @param arg0 the object to remove
	 * @return true if the object was removed, false otherwise
	 */
	@Override
	public boolean remove(Object arg0) {
		return layer.remove(arg0);
	}
	/**
	 * This function remove all the elements from the layer that are contained in the collection
	 * 
	 * @param arg0 the collection to remove
	 */

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return layer.removeAll(arg0);
	}
	/**
	 * This function remove all the elements from the layer that are contained in the collection
	 * 
	 * @param arg0 the collection to remove
	 */

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return layer.retainAll(arg0);
	}
	/**
	 * This function return the size of the layer
	 * 
	 * @return the size of the layer
	 */

	@Override
	public int size() {
		return layer.size();
	}
	/**
	 * This function converse the Array List to a Array
	 * 
	 * @return the Array after conversion 
	 */

	@Override
	public Object[] toArray() {
		return layer.toArray();
	}
	/**
	 * This function returns an Array containing all of the elements in this Array List
	 * 
	 * @return the new Array
	 */

	@Override
	public <T> T[] toArray(T[] arg0) {
		return layer.toArray(arg0);
	}
	/**
	 * 
	 * The function return a String of all the data of the layer
	 * 
	 * @return the data of the layer
	 */

	@Override
	public String toString() {
		String h = " MyGIS_layer :\n";
		for (int i = 0; i < layer.size(); i++) {
			h = h + i + ")  " + layer.get(i).toString() + "\n\n";
		}
		return h;
	}
	/**
	 * This function return the data of the layer
	 * 
	 * @return the data of the layer
	 */

	@Override
	public MyMeta_data_layer get_Meta_data() {
		return this.data;
	}

}
