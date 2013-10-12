// An Arraylist implementation of a Stack

import java.util.ArrayList;

public class Stack <T> {
	protected ArrayList<T> items;
	
	public Stack () {
		items = new ArrayList();
	}
	
	public void push (T item) {
		items.add(item);
	}
	
	public T pop () {
		T item = items.get(items.size()-1);
		items.remove(items.size()-1);
		return item;
	}
	
	public int size () {
		return items.size();
	}
}