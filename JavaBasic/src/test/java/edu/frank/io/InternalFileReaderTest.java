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
 * File Name : InternalFileReaderTest.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-1-12 12:37:27
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.io;

import java.io.File;
import java.io.IOException;

import edu.frank.io.InternalFileReader;

import junit.framework.TestCase;

/**
 * <p>
 * 	InternalFileReaderTest comment
 * </p>
 * @author yoyu
 * @Version JavaBasic
 */
public class InternalFileReaderTest extends TestCase {

	private static final String TEST_FILE_PATH = "src/test/resources/com/yoyudeng/io/internal_data.txt";

	private InternalFileReader internalFileReader = null;

	private File file = null;

	/**
	 * construct a new <code>InternalFileReaderTest</code> instance for class
	 *
	 * @since JavaBasic
	 * @param name
	 */
	public InternalFileReaderTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		file = new File(TEST_FILE_PATH);
		internalFileReader = new InternalFileReader();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.frank.io.InternalFileReader#readFile(java.io.File)}.
	 */
	public void testReadFile() throws Exception {
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
