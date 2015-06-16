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
 * Package : com.yoyudeng.collectionframework
 * File Name : ArraysLearnTest.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-5 04:02:25
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.collectionframework;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.frank.collectionframework.ArraysLearn;

/**
 * <p>
 * 	ArraysLearnTest comment
 * </p>
 * @author yoyu
 * @Version JavaBasic
 */
public class ArraysLearnTest {

	/**
	 * <code>setUpBeforeClass</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * <code>tearDownAfterClass</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * <code>setUp</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * <code>tearDown</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.frank.collectionframework.ArraysLearn#mergeSortLearn(java.lang.Object[], java.lang.Object[], int, int, int)}.
	 */
	@Test
	public void testMergeSortLearn() {
		Object[] src = {5,3,2,7,8};
		Object[] dest = new Object[5];
		ArraysLearn.mergeSortLearn(src, dest, 1, 6, 0);
	}

}
