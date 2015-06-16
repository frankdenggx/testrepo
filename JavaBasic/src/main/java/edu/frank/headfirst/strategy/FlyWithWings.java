package edu.frank.headfirst.strategy;

/**
 * flying behavior
 * @author yoyu
 *
 */
public class FlyWithWings implements FlyBehavior {

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.strategy.FlyBehavior#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I can fly!");	//fly

	}

}
