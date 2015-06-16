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
 *  : <edu.frank.base.data>
 *  : <EnumCategory.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-10-6 10:53:54>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.base.data;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-10-6 10:53:54> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public enum EnumCategory {

	ALL("", "0"),
	MEASURE_UNIT("", "1"),
	CURRENCY("", "2");

	private String alias;
	private String value;

	private EnumCategory(String alias, String value) {
		this.alias = alias;
		this.value = value;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	public static EnumCategory getByValue(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		EnumCategory[] arrays = EnumCategory.values();
		if (ArrayUtils.isEmpty(arrays)) {
			return null;
		}
		for (int i = 0; i < arrays.length; i++) {
			EnumCategory enumCategory = arrays[i];
			if (enumCategory.getValue().equals(value)) {
				return enumCategory;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return getAlias();
	}



}