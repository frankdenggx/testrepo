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
 * Package : com.yoyudeng.headfirst.facade
 * File Name : HomeTheaterFacadeTest.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-3 05:03:22
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.facade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.frank.headfirst.facade.Amplifier;
import edu.frank.headfirst.facade.CdPlayer;
import edu.frank.headfirst.facade.DvdPlayer;
import edu.frank.headfirst.facade.HomeTheaterFacade;
import edu.frank.headfirst.facade.PopcornPopper;
import edu.frank.headfirst.facade.Projector;
import edu.frank.headfirst.facade.Screen;
import edu.frank.headfirst.facade.TheaterLight;
import edu.frank.headfirst.facade.Tuner;

/**
 * <p>
 * test HomeTheaterFacade class
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class HomeTheaterFacadeTest {

	/**
	 * HomeTheaterFacade class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static HomeTheaterFacade instance;
	private static Amplifier amplifier;
	private static Tuner tuner;
	private static CdPlayer cdPlayer;
	private static DvdPlayer dvdPlayer;
	private static Projector projector;
	private static TheaterLight theaterLight;
	private static Screen screen;
	private static PopcornPopper popcornPopper;

	/**
	 * <code>setUpBeforeClass</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		amplifier = new Amplifier();
		tuner = new Tuner();
		cdPlayer = new CdPlayer();
		dvdPlayer = new DvdPlayer();
		projector = new Projector();
		theaterLight = new TheaterLight();
		screen = new Screen();
		popcornPopper = new PopcornPopper();
		instance = new HomeTheaterFacade(amplifier, tuner, cdPlayer, dvdPlayer,
				popcornPopper, projector, screen, theaterLight);
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
	 * Test method for
	 * {@link edu.frank.headfirst.facade.HomeTheaterFacade#watchMovie(java.lang.String)}
	 * .
	 */
	@Test
	public void testWatchMovie() {
		instance.watchMovie("Ghost");
	}

	/**
	 * Test method for
	 * {@link edu.frank.headfirst.facade.HomeTheaterFacade#endMovie()}.
	 */
	@Test
	public void testEndMovie() {
		instance.endMovie();
	}

}
