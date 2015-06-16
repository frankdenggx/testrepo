/**
 * CopyRight : Hotel1802 All Right Reserved.
 * Project : JavaBasic
 * JDK Version : 1.6.13
 * File Version : 1.0.0.0
 * File Name : UseSerializableTest.java
 * File Desc :
 *		This file would be used for UseSerializable testing
 *
 * Author : yoyudenghihi
 * Date : 2010-12-8 02:21:54
 * History :
 * <Name>				<DateTime>					<Content>
 * yoyudenghihi		2010-12-8 02:21:54				Create
 */
package edu.frank.io;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

/**
 * <p>
 * <code>UseSerializable test case</code>
 * </p>
 *
 * @since JavaBasic 1.0.0.0
 * @author yoyudenghihi
 * @version 1.0.0.0
 */
public class UseSerializableTest extends TestCase {

	/**
	 * testing file path
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final String FILE_PATH = "src/test/resources/edu/frank/io/PPDATA.dat";

	/**
	 * testing instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static PPDataSerializable useSerializable;

	/**
	 * testing file
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static File file = null;

	/**
	 * data prepared flag
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static boolean dataPrepared = false;

	/**
	 * Construct a new instance of UseSerializableTest.java
	 *
	 * @param name
	 * @since JavaBasic 1.0.0.0
	 */
	public UseSerializableTest(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		if (null == file) {
			file = preparedFile();
		}
		useSerializable = PPDataSerializable.getInstance();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link edu.frank.io.UseSerializable#writeObject(java.io.File, java.io.ObjectOutputStream)}
	 * .
	 */
	public void testWriteObject() {
		try {
			useSerializable.writeObject(file, null);
			dataPrepared = true;
			assertTrue("successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("failed to write object to file : " + FILE_PATH, false);
		}
	}

	/**
	 * Test method for
	 * {@link edu.frank.io.UseSerializable#readObject(java.io.File, java.io.ObjectInputStream)}
	 * .
	 */
	public void testReadObject() {
		try {
			if (!dataPrepared) {
				useSerializable.writeObject(file, null);
			}
			PPData data = (PPData) useSerializable.readObject(file, null);
			if (null != data) {
				data.output();
				assertTrue("successfully", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("failed to read object from file : " + FILE_PATH, false);
		}
	}

	/**
	 *
	 * prepare file for testing
	 *
	 * @since JavaBasic 1.0.0.0
	 *
	 */
	private File preparedFile() throws IOException {
		File file = new File(FILE_PATH);
		if (null != file && file.exists()) {
			file.delete();
		}
		file.createNewFile();
		return file;
	}

}
