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
 * pertaining to distribution of the file without specific, written prior permission.
 * 
 */

/**
 * CopyRight: <Hotel1802>
 * JDK Version: <1.5.0.8>
 * Project: <JavaBasic>
 *
 * Package: <edu.frank.encoding>
 * File Name: <EncodUtilTest.java>
 * File Version: 1.0
 * File Desc: <description>
 *
 * Author: <Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a>>
 * DateTime: <2012-03-25 09:13:15>
 *
 *
 */
package edu.frank.encoding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.frank.encoding.EncodUtil;
import junit.framework.TestCase;

/**
 * <p>
 * Description: <description>
 * </p>
 * 
 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
 * <p>
 * 
 * Modifier: <Frank Deng> <p>
 * Modify Time: <2012-03-25 09:13:15> <p>
 * Modification: <Created> <p>
 * 
 * 
 * @since JavaBasic 1.0
 * @Version JavaBasic 1.0
 */
public class EncodUtilTest extends TestCase {

	/**
	 * 
	 * Description: <Constructor of <code>EncodUtilTest</code>>
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * Modifier: <Frank Deng> <p>
	 * Modify Time: <2012-03-25 09:13:15> <p>
	 * Modification: <Created> <p>
	 *
	 * @throws Exception
	 *         	Constructor Exception
	 *
	 * @param name
	 *
	 * @since JavaBasic 1.0
	 */
	public EncodUtilTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link edu.frank.encoding.EncodUtil#getAllFiles(java.io.File, java.util.List, java.lang.String[])}.
	 */
	public void testGetAllFiles() {
		try {
			File rootFolder = new File("src/test/resources/edu/frank/encoding");
			List<File> fileList = new ArrayList<File>();
			String[] extensions = {"txt"};
			EncodUtil.getAllFiles(rootFolder, fileList, extensions);
			if (fileList.size() > 0) {
				assertTrue(true);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Test method for {@link edu.frank.encoding.EncodUtil#toISO88591(java.io.File)}.
	 */
	public void testtoISO88591() {
		try {
			File testFile = new File("src/test/resources/edu/frank/encoding/test.txt");
			EncodUtil.toISO88591(testFile);
			assertTrue(true);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
