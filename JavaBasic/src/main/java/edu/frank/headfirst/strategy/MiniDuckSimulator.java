package edu.frank.headfirst.strategy;

/**
 * Test Class
 * @author yoyu
 *
 */
public class MiniDuckSimulator {

	/**
	 * Main Method
	 * @param args console arguments
	 */
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.display();	// show duck color
		mallard.performFly();	// call MallardDuck performFly()
		mallard.performQuack(); // call MallardDuck performQuack()

		Duck model = new ModelDuck();
		model.display();	// show duck
		model.performFly();	//can't fly
		model.setFlyBehavior(new FlyRocketPowered()); // setting fly behavior
		model.performFly();// fly with rocket power
	}

}
