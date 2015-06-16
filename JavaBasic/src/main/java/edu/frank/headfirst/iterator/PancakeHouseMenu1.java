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
 *  : PancakeHouseMenu1.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-5-2 08:59:42
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
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class PancakeHouseMenu1 {

	ArrayList<MenuItem> menuItems;	// 

	/**
	 *   <code>PancakeHouseMenu1</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public PancakeHouseMenu1() {
		menuItems = new ArrayList<MenuItem>();
		addItem("K&B's Pancake Breakfirst",
				"Pancakes with scramble eggs, and toast", true, 2.99);
		addItem("Regular Pancake Breakfirst",
				"Pancake with fried eggs, sausage", false, 2.99);
		addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries",
				true, 3.49);
		addItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true, 3.59);
	}

	/**
	 *
	 * 
	 *
	 * @param name
	 * 			
	 * @param description
	 * 			
	 * @param vegetarian
	 * 			
	 * @param price
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public void addItem(String name, String description, boolean vegetarian,
			double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

	/**
	 *
	 * 
	 *
	 * @return
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public Iterator createMenuIterator() {
		return new PancakeHouseIterator(menuItems);
	}

}