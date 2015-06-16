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
 *  : <EmployeeInfo.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 01:41:50>
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
 * <2011-9-26 01:41:50> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class EmployeeInfo extends AbstractBaseInfo {

	/**
	 * <ID>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -4304295007260476262L;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private SexEnum sex;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private int age;

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
	private String tele;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String email;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private int zip;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String addr;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DepartmentInfo dept;

	/**
	 *
	 * <  <code>EmployeeInfo</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 01:41:50> 		<p>
	 * <> 			<p>
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param seq
	 * @param fid
	 * @param no
	 * @param name
	 * @param createTime
	 */
	public EmployeeInfo(int seq, String fid, int no, String name,
			Date createTime, String description, SexEnum sex, int age,
			String phone, String tele, String email, int zip, String addr,
			DepartmentInfo dept) {
		super(seq, fid, no, name, createTime, description);
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.tele = tele;
		this.email = email;
		this.zip = zip;
		this.addr = addr;
		this.dept = dept;
	}

	/**
	 * @return the sex
	 */
	public SexEnum getSex() {
		return this.sex;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * @return the tele
	 */
	public String getTele() {
		return this.tele;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return this.zip;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return this.addr;
	}

	/**
	 * @return the dept
	 */
	public DepartmentInfo getDept() {
		return this.dept;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		EmployeeInfo newEmployeeInfo = new EmployeeInfo(getSeq(), getFid(),
				getNo(), getName(), getCreateTime(), getDescription(), getSex(), getAge(),
				getPhone(), getTele(), getEmail(), getZip(), getAddr(), getDept());
		return newEmployeeInfo;
	}

}