package edu.frank.headfirst.strategy;

/**
 * Duck class
 * @author yoyu
 *
 */
public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck(){
	}
	
	public void swim(){
		System.out.println("All duck float,even decoys!");
	}
	
	public void display(){
	}
	
	public void performFly(){
		flyBehavior.fly();	// fly
	}
	
	public void performQuack(){
		quackBehavior.quack();	// quack
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior){
		this.quackBehavior = quackBehavior;
	}
	
	//other duck performent ...
	
	
}
