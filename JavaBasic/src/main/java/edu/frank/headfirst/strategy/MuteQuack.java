package edu.frank.headfirst.strategy;

/**
 * Quack no way
 * @author yoyu
 *
 */
public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("<<Silence>>");// quack no way
		
	}

}
