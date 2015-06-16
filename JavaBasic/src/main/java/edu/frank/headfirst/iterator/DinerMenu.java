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
 *  : DinerMenu.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-5-2 01:58:10
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.headfirst.iterator;

/**
 * <p>
 * 
 * </p>
 *
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class DinerMenu {

	final int MAX_MENU_NUM = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	/**
	 *  <code>DinerMenu</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public DinerMenu() {
		menuItems = new MenuItem[MAX_MENU_NUM];
		addItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat", true,
				2.99);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false,
				2.99);
		addItem("Soup of the day",
				"Soup of the day, with a side of potato salad", false, 3.29);
		addItem(
				"Hotdog",
				"A hot dog, with saurkraut, relish, onions, topped with cheese",
				false, 3.05);
		// Other menu item
	}

	/**
	 *
	 * 
	 *
	 * @param name
	 *            
	 * @param decription
	 *            
	 * @param vegetarian
	 *            
	 * @param price
	 *            
	 * @since JavaBasic 1.0.0.0
	 */
	public void addItem(String name, String decription, boolean vegetarian,
			double price) {
		MenuItem menuItem = new MenuItem(name, decription, vegetarian, price);
		if (numberOfItems >= MAX_MENU_NUM) {
			System.err.println("Sorry, menu is full! Can't add item to menu!");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems += 1;
		}
	}

	/**
	 * @return the menuItems
	 */
	public MenuItem[] getMenuItems() {
		return menuItems;
	}

}