package edu.frank.headfirst.facade;

/**
 * <p>
 * 	PopcornPopper class
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class PopcornPopper {

	/**
	 *
	 * turn on the PopcornPopper
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void on() {
		System.out.println("PopcornPopper on!");
	}

	/**
	 *
	 * turn off the PopcornPopper
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void off() {
		System.out.println("PopcornPopper off!");
	}

	/**
	 *
	 * pop the popcorn
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void pop() {
		System.out.println("start to pop the popcorn!");
	}

	@Override
	public String toString() {
		return "This is PopcornPopper object!";
	}

}
