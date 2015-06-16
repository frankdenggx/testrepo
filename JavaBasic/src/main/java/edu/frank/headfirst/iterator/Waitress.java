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
 *  : Waitress.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-5-2 09:16:11
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
public class Waitress {

	private PancakeHouseMenu1 pancakeHouseMenu;
	private DinerMenu1 dinerMenu;

	/**
	 *
	 *   <code>Waitress</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param pancakeHouseMenu
	 * 				
	 * @param dinerMenu
	 * 				
	 */
	public Waitress(PancakeHouseMenu1 pancakeHouseMenu, DinerMenu1 dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu() {
		Iterator pancakeMenuHouseIterator = pancakeHouseMenu.createMenuIterator();
		Iterator dinerMenuIterator = dinerMenu.createMenuIterator();
		System.out.println("MENU\n----\nBREAKFIRST");
		printMenu(pancakeMenuHouseIterator);
		System.out.println("MENU\n---\nLUNCH");
		printMenu(dinerMenuIterator);
	}

	public void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.print(menuItem.getDecription() + "\n");
		}
	}

	// 

}