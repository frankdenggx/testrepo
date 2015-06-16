package edu.frank.headfirst.iterator;

public class MenuItem {

	String name;
	String decription;
	boolean vegetarian;
	double price;

	public MenuItem(String name, String decription, boolean vegetarian,
			double price) {
		this.name = name;
		this.decription = decription;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the decription
	 */
	public String getDecription() {
		return decription;
	}

	/**
	 * @return the vegetarian
	 */
	public boolean isVegetarian() {
		return vegetarian;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

}