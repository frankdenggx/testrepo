package edu.frank.headfirst.strategy;

/**
 * Fly with rocket power
 * @author yoyu
 *
 */
public class FlyRocketPowered implements FlyBehavior {

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.strategy.FlyBehavior#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I'm flying with a rocket!"); // fly with rocket power

	}

}
