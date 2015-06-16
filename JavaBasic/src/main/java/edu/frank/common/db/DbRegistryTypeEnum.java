/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 *  HOTEL1802 STUDIO 
 *
 * 
 * 
 *
 */

/**
 *  : <HOTEL1802 STUDIO>
 * JDK  : <1.6.10>
 *  : <JavaBasic>
 *
 *  : <edu.frank.common.db>
 *  : <DbRegistryTypeEnum.java>
 *  : 1.0
 * <>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 01:09:17>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.common.db;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-9-26 01:09:17> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public enum DbRegistryTypeEnum {

	JNDI("JNDI REGISTER"),		// JDNI 
	XML("XML REGISTER"),		// XML 
	PROPERTIES("PROPERTIES REGISTER");	// PROPERTIES 

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String dbRegistryType;	// 

	/**
	 *
	 * <  <code>DbRegistryTypeEnum</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 01:15:27> 		<p>
	 * <> 			<p>
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param dbRegistryType
	 */
	private DbRegistryTypeEnum(String dbRegistryType) {
		this.dbRegistryType = dbRegistryType;
	}

	@Override
	public String toString() {
		return this.dbRegistryType;	// 
	}
}