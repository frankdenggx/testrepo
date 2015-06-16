/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * JDK Version: 1.6.15
 * File Version: 1.0
 * File Name: UseCaseTracker.java
 * Description: 
 * Author: yoyudenghihi
 * Date: 2009.10.26
 * History:
 * <author>				<time>				<version>				<desc>
 * yoyudenghihi			2009.10.26			1.0						create
 */
package edu.frank.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Track use case PasswordUtils
 * @see edu.frank.annotation.PasswordUtils
 * @since 1.0
 * @author yoyudenghihi
 *
 */
public class UseCaseTracker {

	/**
	 * constructor method
	 */
	public UseCaseTracker() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Track Cases
	 * @param useCases the list of use case
	 * @param cl the class which try to be tracked
	 */
	public static void trackseCases(List<Integer> useCases, Class<?> cl){
		for (Method m : cl.getDeclaredMethods()){
			UseCase uc = m.getAnnotation(UseCase.class);
			if (null != uc){
				System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (int i : useCases){
			System.out.println("Warning: Missing use case-" + i);
		}
	}
	
	/**
	 * Main method
	 * @param args console argument
	 */
	public static void main(String[] args) {

		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47,48,49,50);
		trackseCases(useCases,PasswordUtils.class);

	}

}
