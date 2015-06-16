package edu.frank.headfirst.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubComponent extends Component {
	List<Component> subItems = new ArrayList<Component>();

	public SubComponent(String name, String description) {
		super(name, description);
	}
	@Override
	public boolean add(Component c) {
		//return super.add(c);
		return subItems.add(c);
	}
	@Override
	public boolean remove(Component c) {
		//return super.remove(c);
		return subItems.remove(c);
	}
	@Override
	public Component getChild(int index) {
		//return super.getChild();
		return subItems.get(index);
	}
	@Override
	public Iterator<Component> createIterator() {
		return new CompositeIterator(subItems.iterator());
	}
	/*public Iterator createIterator() {
		return new CompositeIterator(subItems.iterator());
	}*/
	@Override
	public void print() {
		//super.print();
		System.out.print("\n" + getName());
		System.out.println("," + getDescription());
		System.out.println("----------------------");
		Iterator<Component> iterator = createIterator();
		while(iterator.hasNext()) {
			Component c = iterator.next();
			c.print();
		}
	}
	
}
