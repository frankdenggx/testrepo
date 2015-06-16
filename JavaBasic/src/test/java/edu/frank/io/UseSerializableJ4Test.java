/**
 * CopyRight : Hotel1802 All Right Reserved.
 * Project : JavaBasic
 * JDK Version : 1.6.13
 * File Version : 1.0.0.0
 * File Name : UseSerializableJ4Test.java
 * File Desc :
 *		This file would be used for
 *
 * Author : yoyudenghihi
 * Date : 2010-12-8 03:54:22
 * History :
 * <Name>				<DateTime>					<Content>
 * yoyudenghihi		2010-12-8 03:54:22				Create
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

/**
 * <p><code>UseSerializableJ4Test</code></p>
 *
 * @since JavaBasic 1.0.0.0
 * @author yoyudenghihi
 * @version 1.0.0.0
 */
public class UseSerializableJ4Test {

	/**
	 * testing file path
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final String FILE_PATH = "src/test/resources/edu/frank/io/student.dat";

	/**
	 * testing instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static UseSerializable useSerializable;

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
	 * setUpBeforeClass
	 *
	 * @throws java.lang.Exception
	 * @since JavaBasic 1.0.0.0
	 *
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	/**
	 * tearDownAfterClass
	 *
	 * @throws java.lang.Exception
	 * @since JavaBasic 1.0.0.0
	 *
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	/**
	 * setUp
	 *
	 * @throws java.lang.Exception
	 * @since JavaBasic 1.0.0.0
	 *
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("set up");
		if (null == file) {
			file = preparedFile();
		}
		useSerializable = UseSerializable.getInstance();
	}

	/**
	 * tearDown
	 *
	 * @throws java.lang.Exception
	 * @since JavaBasic 1.0.0.0
	 *
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tear down");
	}

	/**
	 * Test method for {@link edu.frank.io.UseSerializable#writeObject(java.io.File, java.io.ObjectOutputStream)}.
	 */
	@Test
	public void testWriteObject() {
		System.out.println("test write object");
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
	 * Test method for {@link edu.frank.io.UseSerializable#readObject(java.io.File, java.io.ObjectInputStream)}.
	 */
	@Test
	public void testReadObject() {
		System.out.println("test read object");
		try {
			if (!dataPrepared) {
				useSerializable.writeObject(file, null);
			}
			Student student = (Student) useSerializable.readObject(file, null);
			if (null != student) {
				student.outStuInfo();
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
