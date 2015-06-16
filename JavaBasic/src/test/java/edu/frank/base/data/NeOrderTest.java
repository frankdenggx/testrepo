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
 * Copyright :  Hotel1802 All Right Reserved.
 * JDK Version :  1.6.10
 * Project :  JavaBasic
 * Package :  edu.frank.base.data
 * File Name :  NeOrderTest.java
 * File Version : 1.0.0.0
 * File Spec: comments
 *
 * Author : Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * Date : 2011-6-16 01:33:47
 * History :
 * <Name>				<Date>				<Comment>
 *
 */
package edu.frank.base.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <p>
 * 	NeOrderTest comment
 * </p>
 *
 * @author Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * @Version JavaBasic 1.0.0.0
 */
public class NeOrderTest {

	private static NeOrderInfo instance;
	private static NeOrderDetailInfo detailInstance;

	/**
	 * <code>setUpBeforeClass</code> comment
	 *
	 * @throws java.lang.Exception
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		instance = new NeOrderInfo();
		instance.setBizNo("BIZ1000001");
		instance.setCreateDate(new java.util.Date());
		instance.setCreator("Frank");
		instance.setCustName("CUSTNAME1000001");
		instance.setCustNo("CUSTNO1000001");
		instance.setCustRep("REP1000001");
		instance.setOrderNO("ORD1000001");
		instance.setProName("PRONAME1000001");
		instance.setProNo("PRONO1000001");
		instance.setStatus("");
		instance.setTotalNum(new java.math.BigDecimal(100));
		instance.setTotalVolume(new java.math.BigDecimal(100.56));
		instance.setTotalWeight(new java.math.BigDecimal(100.67));

		detailInstance = new NeOrderDetailInfo();
		detailInstance.setDeliveryDate(new java.util.Date());
		detailInstance.setDeliveryTime(new java.util.Date());
		detailInstance.setDeliveryName("DELNAME1000001");
		detailInstance.setDeliveryOrg("DELORG1000001");
		detailInstance.setDeliveryWarehouseCode("DELWHC1000001");
		detailInstance.setDeliveryWarehouseName("DELWHN1000001");
		detailInstance.setInWarehouseCode("IWHC1000001");
		detailInstance.setInWarehouseInNum(new java.math.BigDecimal(50));
		detailInstance.setInWarehouseName("INWHN100001");
		detailInstance.setInWarehouseOutNum(new java.math.BigDecimal(50));
		detailInstance.setMaterielCode("MC1000001");
		detailInstance.setMaterielName("MN1000001");
		detailInstance.setNum(new java.math.BigDecimal(100));
		detailInstance.setOutWarehouseCode("OWHC1000001");
		detailInstance.setOutWarehouseInNum(new java.math.BigDecimal(50));
		detailInstance.setOutWarehouseName("OWHN1000001");
		detailInstance.setOutWarehouseOutNum(new java.math.BigDecimal(50));
		detailInstance.setParent(instance);
		detailInstance.setSupplierCode("SUPC1000001");
		detailInstance.setSupplierName("SUPN100001");
		detailInstance.setVolume(new java.math.BigDecimal(100.56));
		detailInstance.setWeight(new java.math.BigDecimal(100.96));

		NeOrderDetailCollection<NeOrderDetailInfo> detailCollection = new NeOrderDetailCollection<NeOrderDetailInfo>();
		detailCollection.add(detailInstance);
		instance.setDetail(detailCollection);

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

	/**
	 * Test method for {@link edu.frank.base.data.NeOrderInfo#toString()}.
	 */
	@Test
	public void testToString() {
		System.out.println(instance.toString());
		NeOrderDetailCollection collection = instance.getDetail();
		java.util.Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			NeOrderDetailInfo detailInfo = (NeOrderDetailInfo) iterator.next();
			System.out.println(detailInfo.toString());
		}
		org.junit.Assert.assertTrue(true);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.frank.base.data.NeOrderInfo#compareTo(java.lang.Object)}.
	 */
	@Test
	public void testCompareTo() {
		org.junit.Assert.assertTrue(true);
		NeOrderInfo clone = (NeOrderInfo) instance.clone();
		org.junit.Assert.assertTrue("Compare to fail !", clone.compareTo(instance)==0);
		//fail("Not yet implemented");
	}

}
