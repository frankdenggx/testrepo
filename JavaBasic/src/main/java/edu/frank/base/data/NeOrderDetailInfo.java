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
 * File Name :  NeOrderDetailInfo.java
 * File Version : 1.0.0.0
 * File Spec: comments
 *
 * Author : Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * Date : 2011-6-15 01:00:04
 * History :
 * <Name>				<Date>				<Comment>
 *
 */
package edu.frank.base.data;

import java.math.BigDecimal;
import java.util.Date;

import edu.frank.common.Tools;

/**
 * <p>
 * 	NeOrderDetailInfo comment
 * </p>
 *
 * @author Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * @Version JavaBasic 1.0.0.0
 */
public class NeOrderDetailInfo extends CoreBaseInfo {

	/**
	 *  Class serialized ID
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -2729692243456989377L;

	private NeOrderInfo parent;
	private String inWarehouseCode;
	private String inWarehouseName;
	private String outWarehouseCode;
	private String outWarehouseName;
	private String supplierCode;
	private String supplierName;
	private String materielCode;
	private String materielName;
	private String deliveryWarehouseCode;
	private String deliveryWarehouseName;
	private Date deliveryDate;
	private Date deliveryTime;
	private String deliveryName;
	private BigDecimal num;
	private BigDecimal volume;
	private BigDecimal weight;
	private String deliveryOrg;
	private BigDecimal inWarehouseInNum;
	private BigDecimal inWarehouseOutNum;
	private BigDecimal outWarehouseInNum;
	private BigDecimal outWarehouseOutNum;

	public NeOrderDetailInfo() {
		this.id = Tools.getUID();
	}


	public NeOrderInfo getParent() {
		return this.parent;
	}


	public void setParent(NeOrderInfo parent) {
		this.parent = parent;
	}


	public String getInWarehouseCode() {
		return this.inWarehouseCode;
	}


	public void setInWarehouseCode(String inWarehouseCode) {
		this.inWarehouseCode = inWarehouseCode;
	}


	public String getInWarehouseName() {
		return this.inWarehouseName;
	}


	public void setInWarehouseName(String inWarehouseName) {
		this.inWarehouseName = inWarehouseName;
	}


	public String getOutWarehouseCode() {
		return this.outWarehouseCode;
	}


	public void setOutWarehouseCode(String outWarehouseCode) {
		this.outWarehouseCode = outWarehouseCode;
	}


	public String getOutWarehouseName() {
		return this.outWarehouseName;
	}


	public void setOutWarehouseName(String outWarehouseName) {
		this.outWarehouseName = outWarehouseName;
	}


	public String getSupplierCode() {
		return this.supplierCode;
	}


	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}


	public String getSupplierName() {
		return this.supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getMaterielCode() {
		return this.materielCode;
	}


	public void setMaterielCode(String materielCode) {
		this.materielCode = materielCode;
	}


	public String getMaterielName() {
		return this.materielName;
	}


	public void setMaterielName(String materielName) {
		this.materielName = materielName;
	}


	public String getDeliveryWarehouseCode() {
		return this.deliveryWarehouseCode;
	}


	public void setDeliveryWarehouseCode(String deliveryWarehouseCode) {
		this.deliveryWarehouseCode = deliveryWarehouseCode;
	}


	public String getDeliveryWarehouseName() {
		return this.deliveryWarehouseName;
	}


	public void setDeliveryWarehouseName(String deliveryWarehouseName) {
		this.deliveryWarehouseName = deliveryWarehouseName;
	}


	public Date getDeliveryDate() {
		return this.deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Date getDeliveryTime() {
		return this.deliveryTime;
	}


	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public String getDeliveryName() {
		return this.deliveryName;
	}


	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}


	public BigDecimal getNum() {
		return this.num;
	}


	public void setNum(BigDecimal num) {
		this.num = num;
	}


	public BigDecimal getVolume() {
		return this.volume;
	}


	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}


	public BigDecimal getWeight() {
		return this.weight;
	}


	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}


	public String getDeliveryOrg() {
		return this.deliveryOrg;
	}


	public void setDeliveryOrg(String deliveryOrg) {
		this.deliveryOrg = deliveryOrg;
	}


	public BigDecimal getInWarehouseInNum() {
		return this.inWarehouseInNum;
	}


	public void setInWarehouseInNum(BigDecimal inWarehouseInNum) {
		this.inWarehouseInNum = inWarehouseInNum;
	}


	public BigDecimal getInWarehouseOutNum() {
		return this.inWarehouseOutNum;
	}


	public void setInWarehouseOutNum(BigDecimal inWarehouseOutNum) {
		this.inWarehouseOutNum = inWarehouseOutNum;
	}


	public BigDecimal getOutWarehouseInNum() {
		return this.outWarehouseInNum;
	}


	public void setOutWarehouseInNum(BigDecimal outWarehouseInNum) {
		this.outWarehouseInNum = outWarehouseInNum;
	}


	public BigDecimal getOutWarehouseOutNum() {
		return this.outWarehouseOutNum;
	}


	public void setOutWarehouseOutNum(BigDecimal outWarehouseOutNum) {
		this.outWarehouseOutNum = outWarehouseOutNum;
	}

	/**
     * Returns a shallow copy of this <tt>NeOrderDetailInfo</tt> instance.  (The
     * elements themselves are not copied.)
     *
     * @return a clone of this <tt>NeOrderDetailInfo</tt> instance
     */
	@Override
	protected Object clone() {
		try {
			NeOrderDetailInfo cloneInstance = (NeOrderDetailInfo) super.clone();
			cloneInstance.parent = getParent();
			cloneInstance.inWarehouseCode = getInWarehouseCode();
			cloneInstance.inWarehouseName = getInWarehouseName();
			cloneInstance.outWarehouseCode = getOutWarehouseCode();
			cloneInstance.outWarehouseName = getOutWarehouseName();
			cloneInstance.supplierCode = getSupplierCode();
			cloneInstance.supplierName = getSupplierName();
			cloneInstance.materielCode = getMaterielCode();
			cloneInstance.materielName = getMaterielName();
			cloneInstance.deliveryDate = getDeliveryDate();
			cloneInstance.deliveryTime = getDeliveryTime();
			cloneInstance.deliveryName = getDeliveryName();
			cloneInstance.deliveryOrg = getDeliveryOrg();
			cloneInstance.deliveryWarehouseCode = getDeliveryWarehouseCode();
			cloneInstance.deliveryWarehouseName = getDeliveryWarehouseName();
			cloneInstance.num = getNum();
			cloneInstance.volume = getVolume();
			cloneInstance.weight = getWeight();
			cloneInstance.inWarehouseInNum = getInWarehouseInNum();
			cloneInstance.inWarehouseOutNum = getInWarehouseOutNum();
			cloneInstance.outWarehouseInNum = getOutWarehouseInNum();
			cloneInstance.outWarehouseOutNum = getOutWarehouseOutNum();
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
		NeOrderDetailInfo compareNeOrderDetailInfo = (NeOrderDetailInfo) o;
		return compareNeOrderDetailInfo.id.compareTo(this.id);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName());
		sb.append("[" + this.id + ", ");
		sb.append("parent=" + getParent());
		sb.append(", ");
		sb.append("inWarehouseCode=" + getInWarehouseCode());
		sb.append(", ");
		sb.append("inWarehouseName=" + getInWarehouseName());
		sb.append(", ");
		sb.append("outWarehouseCode=" + getOutWarehouseCode());
		sb.append(", ");
		sb.append("outWarehouseName" + getOutWarehouseName());
		sb.append(", ");
		sb.append("supplierCode=" + getSupplierCode());
		sb.append(", ");
		sb.append("supplierName=" + getSupplierName());
		sb.append(", ");
		sb.append("materielCode=" + getMaterielCode());
		sb.append(", ");
		sb.append("materielName=" + getMaterielName());
		sb.append(", ");
		sb.append("deliveryWarehouseCode=" + getDeliveryWarehouseCode());
		sb.append(", ");
		sb.append("deliveryWarehouseName=" + getDeliveryWarehouseName());
		sb.append(", ");
		sb.append("deliveryDate=" + getDeliveryDate());
		sb.append(", ");
		sb.append("deliveryTime=" + getDeliveryTime());
		sb.append(", ");
		sb.append("deliveryName=" + getDeliveryName());
		sb.append(", ");
		sb.append("num=" + getNum());
		sb.append(", ");
		sb.append("volume=" + getVolume());
		sb.append(", ");
		sb.append("weight=" + getWeight());
		sb.append(", ");
		sb.append("deliveryOrg=" + getDeliveryOrg());
		sb.append(", ");
		sb.append("inWarehouseInNum=" + getInWarehouseInNum());
		sb.append(", ");
		sb.append("inWarehouseOutNum=" + getInWarehouseOutNum());
		sb.append(", ");
		sb.append("outWarehouseInNum=" + getOutWarehouseInNum());
		sb.append(", ");
		sb.append("outWarehouseOutNum=" + getOutWarehouseOutNum());
		sb.append("]");
		this.desc = sb.toString();
		return this.desc;
	}

}
