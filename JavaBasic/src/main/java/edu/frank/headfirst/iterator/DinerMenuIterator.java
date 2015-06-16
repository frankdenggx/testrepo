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
 *  : DinerMenuIterator.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-5-2 02:26:24
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.headfirst.iterator;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class DinerMenuIterator implements Iterator {

	MenuItem[] menuItems;
	int position = 0;

	/**
	 *   <code>DinerMenuIterator</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public DinerMenuIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	/* (non-Javadoc)
	 * @see edu.frank.headfirst.iterator.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (position >= menuItems.length || menuItems[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see edu.frank.headfirst.iterator.Iterator#next()
	 */
	@Override
	public Object next() {
		MenuItem menuItem = menuItems[position];
		position += 1;
		return menuItem;
	}

}