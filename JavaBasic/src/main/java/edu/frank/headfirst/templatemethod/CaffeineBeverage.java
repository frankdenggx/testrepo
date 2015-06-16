/*
 * Software License
 * The file Library is
 * Copyright (C) 2010-2011 Hotel1802 Technologies Studio All Right Reserved .
 *
 * By obtaining,using,and/or copying this software and/or its associated
 * documentation, you agree that you have read, understood, and will comply
 * with the following terms and conditions :
 *
 * Permission to use, copy, modify, and distribute this file and its associated
 * documentation for any purpose and without fee is hereby granted, provide that
 * the above copyright notice appears in all copies, and that both that copyright
 * notice and this permission ontice appear in supporting documentation, and that
 * the name of Hotel802 or the author not be used in advertising or publicity
 * pertaining to distribution of the file without specific, written prior permission .
 *
 */
/**
 * Copyright : Hotel1802 All Right Reserved.
 * JDK Version : 1.6.10
 * Project : JavaBasic
 * Package : com.yoyudeng.headfirst.templatemethod
 * File Name : CoffeineBeverage.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-7 12:17:24
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.templatemethod;

/**
 * <p>
 * 	CaffeineBeverage class defines the template method <code>prepareRecipe</code>
 * 	for all of the caffeine beverage
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public abstract class CaffeineBeverage {

	/**
	 *
	 * <code>prepareRecipe</code> the template method is defined as final for forbidding
	 * the subclass to change.It can include primitive operation,hook,and other final method.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	/**
	 *
	 * <code>brew</code> is the abstract method prepared for the subclass to override.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	abstract void brew();

	/**
	 *
	 * <code>addCondiments</code> is the abstract method prepared for the subclass to override.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	abstract void addCondiments();

	/**
	 *
	 * <code>boilWater</code> method can be implemented by super class.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	void boilWater() {
		System.out.println("This method is used for boilling watter !");
	}

	/**
	 *
	 * <code>pourInCup</code> method can be implemented by super class.
	 *
	 *
	 * @since JavaBasic	1.0.0.0
	 */
	void pourInCup() {
		System.out.println("This method is used for pour the caffeine into the cup !");
	}
}
