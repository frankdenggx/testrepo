/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * JDK Version: 1.6.15
 * File Version: 1.0
 * File Name: Testable.java
 * Description:
 * Author: yoyudenghihi
 * Date: 2009.10.26
 * History:
 * <author>				<time>				<version>				<desc>
 * yoyudenghihi			2009.10.26			1.0						create
 */
package edu.frank.annotation;


/**
 * @author yoyudenghihi
 *
 */
public class Testable {

	/**
	 *
	 */
	public Testable() {

	}

	public void executed(){
		System.out.println("Executing...");
	}

	@Test void testExecute(){
		executed();
	}

}
