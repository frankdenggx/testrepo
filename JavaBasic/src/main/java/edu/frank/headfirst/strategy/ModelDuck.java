package edu.frank.headfirst.strategy;

/**
 * ModelDuck class
 * @author yoyu
 *
 */
public class ModelDuck extends Duck {

	public ModelDuck(){
		flyBehavior = new FlyNoWay();	// can't fly
		quackBehavior = new Quack(); // can quake
	}
	
	public void display(){
		System.out.println("I'm real a model duck!"); //display
	}
}
