/*
 * 
 * Hotel1802 
 *
 * 
 * ?
 *
 */

/**
 *  : Hotel1802 
 * JDK  : 1.6.10
 *  : JavaBasic
 *
 *  : edu.frank.headfirst.iterator
 *  : WaitreesTest.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-5-2 09:27:08
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.headfirst.iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public class WaitressTest {

	static PancakeHouseMenu1 pancakeHouseMenu;
	static DinerMenu1 dinerMenu;
	static Waitress waitress;

	/**
	 * <code>setUpBeforeClass</code> 
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pancakeHouseMenu = new PancakeHouseMenu1();
		dinerMenu = new DinerMenu1();
		waitress = new Waitress(pancakeHouseMenu, dinerMenu);

	}

	/**
	 * <code>tearDownAfterClass</code> 
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * <code>setUp</code> 
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * <code>tearDown</code> 
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.frank.headfirst.iterator.Waitress#printMenu()}.
	 */
	@Test
	public void testPrintMenu() {
		waitress.printMenu();
	}

}
