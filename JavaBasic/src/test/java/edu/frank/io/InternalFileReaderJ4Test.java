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
 * File Name : InternalFileReaderJ4Test.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-2 06:22:43
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.frank.io.InternalFileReader;

/**
 * <p>
 * 	InternalFileReaderJ4Test <br>
 * 	test InternalFileReader class
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class InternalFileReaderJ4Test {

	/**
	 * testing file path
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final String TEST_FILE_PATH = "src/test/resources/com/yoyudeng/io/internal_data.txt";

	/**
	 * testing class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private InternalFileReader internalFileReader = null;

	/**
	 * file instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private File file = null;

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
		file = new File(TEST_FILE_PATH);
		internalFileReader = new InternalFileReader();
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
	 * Test method for {@link edu.frank.io.InternalFileReader#readFile(java.io.File)}.
	 */
	@Test
	public void testReadFile() {
		try {
			StringBuffer[] sb = internalFileReader.readFile(file);
			System.out.println("sb0 : |" + sb[0].toString() + "|");
			System.out.println("sb1 : |" + sb[1].toString() + "|");
			System.out.println("sb2 : |" + sb[2].toString() + "|");
			assertTrue(true);
		} catch (IOException e) {
			assertTrue(e.getMessage(),false);
		}
	}

}
