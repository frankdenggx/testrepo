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
 *  : <CustomerInfo.java>
 *  : 1.0
 * <>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 12:20:05>
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
 * <2011-9-26 12:20:05> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class CustomerInfo extends AbstractBaseInfo {

	/**
	 * <ID>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 7028778533394913410L;

	private String custPhone;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String custTele;

	/**
	 * <Email>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String custEmail;

	private String custFax;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private EmployeeInfo custRep;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private EmployeeInfo custManager;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String custContact;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private int custZip;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String custAddr;

	/**
	 *
	 * <  <code>CustomerInfo</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 12:22:10> 		<p>
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
	public CustomerInfo(int seq, String fid, int no, String name,
			Date createTime, String description, String custTele, String custPhone,
			String custEmail, String custFax, EmployeeInfo custRep, EmployeeInfo custManager,
			String custContact, int custZip, String custAddr) {
		super(seq, fid, no, name, createTime, description);
		this.custPhone = custPhone;
		this.custTele = custTele;
		this.custEmail = custEmail;
		this.custFax = custFax;
		this.custRep = custRep;
		this.custManager = custManager;
		this.custContact = custContact;
		this.custZip = custZip;
		this.custAddr = custAddr;
	}

	public String getCustPhone() {
		return this.custPhone;
	}
	/**
	 * @return the custTel
	 */
	public String getCustTele() {
		return this.custTele;
	}

	public String getCustFax() {
		return this.custFax;
	}

	/**
	 * @return the custEmail
	 */
	public String getCustEmail() {
		return this.custEmail;
	}

	/**
	 * @return the custRep
	 */
	public EmployeeInfo getCustRep() {
		return this.custRep;
	}

	/**
	 * @return the custManager
	 */
	public EmployeeInfo getCustManager() {
		return this.custManager;
	}

	/**
	 * @return the custContact
	 */
	public String getCustContact() {
		return this.custContact;
	}

	/**
	 * @return the custZip
	 */
	public int getCustZip() {
		return this.custZip;
	}

	/**
	 * @return the custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		CustomerInfo newCustomer = new CustomerInfo(getSeq(), getFid(),
				getNo(), getName(), getCreateTime(), getDescription(), getCustPhone(),
				getCustTele(), getCustEmail(), getCustFax(), getCustRep(), getCustManager(),
				getCustContact(), getCustZip(), getCustAddr());
		return newCustomer;
	}

}