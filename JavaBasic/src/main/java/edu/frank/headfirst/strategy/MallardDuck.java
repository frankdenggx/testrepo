package edu.frank.headfirst.strategy;

/**
 * Mallard Duck Class
 * @author yoyu
 *
 */
public class MallardDuck extends Duck {
	
	public MallardDuck(){
		quackBehavior = new Quack();	//quack
		flyBehavior = new FlyWithWings(); // fly with wings
	}
	
	public void display(){
		System.out.println("I'm a real Mallard Duck!");// mallard duck
	}
}
