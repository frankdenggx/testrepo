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
 * File Name : DuckTest.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-7 01:55:53
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.templatemethod;


import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.frank.headfirst.templatemethod.Duck;

/**
 * <p>
 * 	DuckTest testing
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class DuckTest {

	/**
	 * Duck array waiting to sort
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static Duck[] ducks;

	/**
	 * <code>setUpBeforeClass</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ducks = new Duck[] {
			new Duck("Money",5),
			new Duck("Lousy",9),
			new Duck("Kendy",7),
			new Duck("Lisery",3)
		};
	}

	/**
	 * <code>tearDownAfterClass</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * <code>setUp</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * <code>tearDown</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortDuck() throws Exception {
		System.out.println("Befor sorting:");
		display(ducks);
		Arrays.sort(ducks);
		System.out.println("After sorting:");
		display(ducks);
	}

	/**
	 *
	 * <code>display</code> display the duck array content.
	 *
	 * @param ducks
	 *			the ducks array
	 * @since JavaBasic 1.0.0.0
	 */
	private void display(Duck[] ducks) {
		for(Duck duck : ducks) {
			System.out.println(duck);
		}
	}

}
