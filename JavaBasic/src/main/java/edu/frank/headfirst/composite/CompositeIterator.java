package edu.frank.headfirst.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<Component> {
	private Stack<Iterator<Component>> stack = new Stack<Iterator<Component>>();
	
	public CompositeIterator(Iterator<Component> iterator) {
		stack.push(iterator);
	}
	
	@Override
	public boolean hasNext() {
		if (stack.isEmpty()) {
			return false;
		}
		Iterator<Component> iterator = stack.peek();
		if (!iterator.hasNext()) {
			stack.pop();
			return hasNext();
		} else {
			return true;
		}
	}

	@Override
	public Component next() {
		if (hasNext()) {
			Iterator<Component> iterator = (Iterator<Component>) stack.peek();
			Component c = iterator.next();
			/*if (c instanceof SubComponent) {
				stack.push(c.createIterator());
			}*/
			return c;
		} else {
			return null;
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
