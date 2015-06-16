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
 *  : PancakeHouseMenu.java
 *  : 1.0.0.0
 *  
 *
 *  : Frank
 *  : 2011-5-2 01:38:05
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
public class PancakeHouseMenu {

	ArrayList<MenuItem> menuItems;

	/**
	 *  <code>PancakeHouseMenu</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public PancakeHouseMenu() {
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

	public void addItem(String name, String description, boolean vegetarian,
			double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

	/**
	 * @return the menuItems
	 */
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

}