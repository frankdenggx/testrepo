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
 *  : <DepartmentInfo.java>
 *  : 1.0
 * <>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 02:49:02>
 *  :
 * <>				<>					<>
 * Frank Deng			2011-09-26					
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
 * <2011-9-26 02:49:02> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class DepartmentInfo extends AbstractBaseInfo {

	/**
	 * <ID>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -9145562820506548964L;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DepartmentInfo parent;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private EmployeeInfo manager;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private int member;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String responsibility;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String phone;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String fax;

	/**
	 *
	 * <  <code>DepartmentInfo</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 02:49:02> 		<p>
	 * <> 			<p>
	 *
	 * @param seq
	 * 			
	 * @param fid
	 * 			ID
	 * @param no
	 * 			
	 * @param name
	 * 			
	 * @param createTime
	 * 			
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public DepartmentInfo(int seq, String fid, int no, String name,
			Date createTime, String description, DepartmentInfo parent,
			int member, EmployeeInfo manager, String phone, String fax,
			String responsibility) {
		super(seq, fid, no, name, createTime, description);
		this.parent = parent;
		this.member = member;
		this.manager = manager;
		this.responsibility = responsibility;
		this.phone = phone;
		this.fax = fax;
	}

	/**
	 * @return the parent
	 */
	public DepartmentInfo getParent() {
		return this.parent;
	}

	/**
	 * @return the manager
	 */
	public EmployeeInfo getManager() {
		return this.manager;
	}

	/**
	 * @return the member
	 */
	public int getMember() {
		return this.member;
	}

	/**
	 * @return the responsibility
	 */
	public String getResponsibility() {
		return this.responsibility;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return this.fax;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		DepartmentInfo newDeptmentInfo = new DepartmentInfo(getSeq(), getFid(),
				getNo(), getName(), getCreateTime(), getDescription(),
				getParent(),  getMember(), getManager(),
				getPhone(), getFax(), getResponsibility());
		return newDeptmentInfo;
	}

}