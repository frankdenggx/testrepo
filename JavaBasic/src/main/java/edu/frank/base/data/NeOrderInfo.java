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
 * File Name :  NeOrderInfo.java
 * File Version : 1.0.0.0
 * File Spec: comments
 *
 * Author : Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * Date : 2011-6-15 12:57:51
 * History :
 * <Name>				<Date>				<Comment>
 *
 */
package edu.frank.base.data;

import edu.frank.common.Tools;

/**
 * <p>
 * 	NeOrderInfo <code>NeOrder</code> object information
 * </p>
 *
 * @author Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * @Version JavaBasic 1.0.0.0
 */
public class NeOrderInfo extends CoreBaseInfo {

	/**
	 *  Class serialized ID
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 1040481195511625791L;

	private String orderNO;
	private String bizNo;
	private String custNo;
	private String custName;
	private String proNo;
	private String proName;
	private String custRep;
	private String creator;
	private java.util.Date createDate;
	private String status;
	private java.math.BigDecimal totalNum;
	private java.math.BigDecimal totalVolume;
	private java.math.BigDecimal totalWeight;
	private NeOrderDetailCollection<NeOrderDetailInfo> detail;

	/**
	 * construct a new <code>NeOrderInfo</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public NeOrderInfo() {
		this.id = Tools.getUID();
	}

	public String getOrderNO() {
		return this.orderNO;
	}

	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}

	public String getBizNo() {
		return this.bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getProNo() {
		return this.proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getCustRep() {
		return this.custRep;
	}

	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.math.BigDecimal getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(java.math.BigDecimal totalNum) {
		this.totalNum = totalNum;
	}

	public java.math.BigDecimal getTotalVolume() {
		return this.totalVolume;
	}

	public void setTotalVolume(java.math.BigDecimal totalVolume) {
		this.totalVolume = totalVolume;
	}

	public java.math.BigDecimal getTotalWeight() {
		return this.totalWeight;
	}

	public void setTotalWeight(java.math.BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public NeOrderDetailCollection<NeOrderDetailInfo> getDetail() {
		return this.detail;
	}

	public void setDetail(NeOrderDetailCollection<NeOrderDetailInfo> detail) {
		this.detail = detail;
	}

	/**
     * Returns a shallow copy of this <tt>NeOrderInfo</tt> instance.  (The
     * elements themselves are not copied.)
     *
     * @return a clone of this <tt>NeOrderInfo</tt> instance
     */
	@Override
	protected Object clone()  {
		try {
			NeOrderInfo cloneInstance = (NeOrderInfo) super.clone();
			cloneInstance.orderNO = getOrderNO();
			cloneInstance.bizNo = getBizNo();
			cloneInstance.custNo = getCustNo();
			cloneInstance.custName = getCustName();
			cloneInstance.proNo = getProNo();
			cloneInstance.proName = getProName();
			cloneInstance.custRep = getCustRep();
			cloneInstance.creator = getCreator();
			cloneInstance.createDate = getCreateDate();
			cloneInstance.status = getStatus();
			cloneInstance.totalNum = getTotalNum();
			cloneInstance.totalVolume = getTotalVolume();
			cloneInstance.totalWeight = getTotalWeight();
			return cloneInstance;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		NeOrderInfo compareObject = (NeOrderInfo) o;
		return compareObject.id.compareTo(this.id);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName());
		sb.append("[");
		sb.append("id=" + getId());
		sb.append(", ");
		sb.append("orderNo=" + getOrderNO());
		sb.append(", ");
		sb.append("bizNo=" + getBizNo());
		sb.append(", ");
		sb.append("custNo=" + getCustNo());
		sb.append(", ");
		sb.append("custName=" + getCustName());
		sb.append(", ");
		sb.append("proNo=" + getProNo());
		sb.append(", ");
		sb.append("proName=" + getProName());
		sb.append(", ");
		sb.append("custRep=" + getCustRep());
		sb.append(", ");
		sb.append("creator=" + getCreator());
		sb.append(", ");
		sb.append("createDate=" + getCreateDate());
		sb.append(", ");
		sb.append("status=" + getStatus());
		sb.append(", ");
		sb.append("totalNum=" + getTotalNum());
		sb.append(", ");
		sb.append("totalVolume=" + getTotalVolume());
		sb.append(", ");
		sb.append("totalWeight=" + getTotalWeight());
		sb.append(", ");
		sb.append("detail=");
		sb.append("]");
		this.desc = sb.toString();
		return this.desc;
	}

}
