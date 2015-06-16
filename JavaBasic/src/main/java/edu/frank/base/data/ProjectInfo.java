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
 *  : <ProjectInfo.java>
 *  : 1.0
 * <>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 23:00:03>
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
 * <2011-9-26 23:00:03> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class ProjectInfo extends AbstractBaseInfo {

	/**
	 * <ID>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 7802246655970873508L;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private EmployeeInfo proRep;

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
	private String provider;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String executor;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DepartmentInfo department;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Date startDate;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Date endDate;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String content;

	/**
	 *
	 * <  <code>ProjectInfo</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 23:00:03> 		<p>
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
	 * @param description
	 * 			
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public ProjectInfo(int seq, String fid, int no, String name,
			Date createTime, String description, EmployeeInfo proRep,
			EmployeeInfo manager, String provider, String executor,
			DepartmentInfo department, Date startDate, Date endDate) {

		super(seq, fid, no, name, createTime, description);
		this.proRep = proRep;
		this.manager = manager;
		this.provider = provider;
		this.executor = executor;
		this.department = department;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public EmployeeInfo getProRep() {
		return this.proRep;
	}

	public EmployeeInfo getManager() {
		return this.manager;
	}

	public String getProvider() {
		return this.provider;
	}

	public String getExecutor() {
		return this.executor;
	}

	public DepartmentInfo getDepartment() {
		return this.department;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public String getContent() {
		return this.content;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		ProjectInfo newProject = new ProjectInfo(getSeq(), getFid(), getNo(),
				getName(), getCreateTime(), getDescription(), getProRep(),
				getManager(), getProvider(), getExecutor(), getDepartment(),
				getStartDate(), getEndDate());
		return newProject;
	}

}