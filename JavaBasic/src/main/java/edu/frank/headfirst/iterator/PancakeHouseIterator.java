/*
 * 
 * Hotel1802 
 *
 * 
 * 
 *
 */

/**
 *  : Hotel1802 
 * JDK  : 1.6.10
 *  : JavaBasic
 *
 *  : edu.frank.headfirst.iterator
 *  : PancakeHouseIterator.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-5-2 02:15:03
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.headfirst.iterator;

import java.util.ArrayList;

/**
 * <p>
 * 
 * </p>
 *
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class PancakeHouseIterator implements Iterator {

	ArrayList<MenuItem> menuItems;
	int index = 0;

	/**
	 *  <code>PancakeHouseIterator</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see edu.frank.headfirst.iterator.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (index >= menuItems.size()
				|| menuItems.get(index) == null) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see edu.frank.headfirst.iterator.Iterator#next()
	 */
	@Override
	public Object next() {
		MenuItem menuItem = menuItems.get(index);
		index += 1;
		return menuItem;
	}

}