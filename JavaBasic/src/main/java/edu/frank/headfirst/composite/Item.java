package edu.frank.headfirst.composite;

import java.util.Iterator;

import edu.frank.json.JsonPluginsUtil;

public class Item extends Component {

	public Item(String name, String description) {
		super(name, description);
	}
	@Override
	public Iterator<Component> createIterator() {
		return new NullIterator();
	}
	
	@Override
	public void print() {
		//super.print();
		System.out.println(JsonPluginsUtil.beanToJson(this));
	}
}
