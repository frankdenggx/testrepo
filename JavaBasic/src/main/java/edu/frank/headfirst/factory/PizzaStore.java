package edu.frank.headfirst.factory;

public class PizzaStore {
	private SimplePizzaFactory simplePizzaFactory;
	public PizzaStore(SimplePizzaFactory factory) {
		this.simplePizzaFactory = factory;
	}
	public Pizza orderPizza(String type) throws Exception {
		Pizza pizza = simplePizzaFactory.createPizza(type);
		return pizza;
	}
}
