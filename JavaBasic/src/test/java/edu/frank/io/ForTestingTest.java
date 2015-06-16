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
 * Package : com.yoyudeng.io
 * File Name : ForTestingTest.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-2 06:02:01
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.io;

import junit.framework.TestCase;

import edu.frank.ForTesting;

/**
 * <p>
 * 	ForTestingTest test ForTesting class
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class ForTestingTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.frank.ForTesting#fly()}.
	 */
	public void testFly() {
		ForTesting instance = ForTesting.getInstance();
		for (int i = 0; i < 5; i++) {
			instance.fly();
		}
	}

}
