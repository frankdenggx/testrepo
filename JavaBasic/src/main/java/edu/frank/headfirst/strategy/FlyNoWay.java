package edu.frank.headfirst.strategy;

/**
 * fly no way
 * @author yoyu
 *
 */
public class FlyNoWay implements FlyBehavior {

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.strategy.FlyBehavior#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I can't fly!");//do nothing
	}

}
