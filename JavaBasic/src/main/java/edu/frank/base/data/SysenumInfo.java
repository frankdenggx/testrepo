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
 *  : <SysEnumInfo.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-10-6 11:40:23>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.base.data;

import java.util.Date;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-10-6 11:40:23> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class SysenumInfo extends AbstractBaseInfo {

	/**
	 * <ID >
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 7674443710188280155L;

	private EnumCategory enumCate;

	private String itemName;

	private String itemAlias;

	private String itemValue;

	/**
	 *
	 * <  <code>SysEnumInfo</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-10-6 11:40:23> 		<p>
	 * <> 			<p>
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param seq
	 * @param fid
	 * @param no
	 * @param name
	 * @param createTime
	 * @param description
	 */
	public SysenumInfo(int seq, String fid, int no, String name,
			Date createTime, String description, EnumCategory enumCate,
			String itemName, String itemAlias, String itemValue) {
		super(seq, fid, no, name, createTime, description);
		this.enumCate = enumCate;
		this.itemName = itemName;
		this.itemAlias = itemAlias;
		this.itemValue = itemValue;
	}

	/**
	 * @return the enumCate
	 */
	public EnumCategory getEnumCate() {
		return this.enumCate;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * @return the itemAlias
	 */
	public String getItemAlias() {
		return this.itemAlias;
	}

	/**
	 * @return the itemValue
	 */
	public String getItemValue() {
		return this.itemValue;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		SysenumInfo newSysenumInfo = new SysenumInfo(getSeq(), getFid(),
				getNo(), getName(), getCreateTime(), getDescription(), getEnumCate(),
				getItemName(), getItemAlias(), getItemValue());
		return newSysenumInfo;
	}

	/* (non-Javadoc)
	 * @see edu.frank.base.data.AbstractBaseInfo#toString()
	 */
	@Override
	public String toString() {
		return getItemAlias();
	}

	public String getTotalString() {
		return super.toString();
	}
}