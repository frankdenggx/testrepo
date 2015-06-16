package edu.frank.headfirst.factory;

public abstract class PizzaStore1 {
	public Pizza orderPizza(String type) throws Exception {
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
	public abstract Pizza createPizza(String type) throws Exception;
}
