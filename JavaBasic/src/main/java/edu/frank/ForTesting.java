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
 * Package : com.yoyudeng
 * File Name : ForTesting.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-2 05:33:08
 * History :
 * <Name>				<Date>				<Content>
 * yoyu					2011-3-2			create
 */
package edu.frank;

import java.util.Random;

/**
 * <p>
 * 	This class for java technology testing
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class ForTesting {

	/**
	 * class unique instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static ForTesting instance = null;

	/**
	 * construct a new <code>ForTesting</code> instance for class
	 *
	 * @since JavaBasic
	 */
	public ForTesting() {
	}

	/**
	 *
	 * <code>getInstance</code> return the unique class instance
	 *
	 * @return
	 * 		class unique instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static ForTesting getInstance() {
		if (instance == null) {
			instance = new ForTesting();
		}
		return instance;
	}

	/**
	 *
	 * <code>fly</code> when the Turkey fly 5 times,then the duck will fly once.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void fly() {
		Random rand = new Random();
		int randResult = rand.nextInt(5);
		System.out.println("randResult=" + randResult);
		if (randResult == 0) {
			System.out.println("I am flying now !");
		}
	}

	public void tryCatchFinally() {
		try {
			System.out.println("I'm in try!");
			System.exit(0);
		} catch (Exception ex) {
			System.out.println("Error!");
		} finally {
			System.out.println("1");
		}
	}

	/**
	 *
	 * <code>test</code> testing method
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void test() {
		fly();
		tryCatchFinally();
	}

}
