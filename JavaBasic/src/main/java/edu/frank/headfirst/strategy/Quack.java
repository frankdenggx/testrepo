package edu.frank.headfirst.strategy;

/**
 * quick with "gua gua jiao"
 * @author yoyu
 *
 */
public class Quack implements QuackBehavior {

	/* (non-Javadoc)
	 * @see com.yoyudeng.headfirst.strategy.QuackBehavior#quick()
	 */
	@Override
	public void quack() {
		System.out.println("Quack!");// "gua gua jiao" implement

	}

}
