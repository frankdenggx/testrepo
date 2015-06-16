package edu.frank.headfirst.strategy;

/**
 * quick with "zhi zhi jiao"
 * @author yoyu
 *
 */
public class Squeak implements QuackBehavior {

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.strategy.QuackBehavior#quick()
	 */
	@Override
	public void quack() {
		System.out.println("Squeak!");// "zhi zhi jiao" implement

	}

}
