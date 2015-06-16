/*
 * 
 * Hotel1802 
 *
 * 
 * 
 *
 */

/**
 *  : Hotel1802 
 * JDK  : 1.6.10
 *  : JavaBasic
 *
 *  : edu.frank.base.data
 *  : Teacher.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-29 07:08:03
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base.data;

import java.math.BigDecimal;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public final class Teacher extends AbstractPerson {

	/**
	 * 
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = 6614845255355184851L;
	private String dept;
	private BigDecimal salary;

	/**
	 *   <code>Teacher</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public Teacher() {
		super();
	}

	/**
	 *   <code>Teacher</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param id
	 * @param name
	 * @param sex
	 */
	public Teacher(String id, String name, String sex) {
		super(id, name, sex);
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setSalary(String salary) {
		this.salary = new BigDecimal(salary);
	}

	/* (non-Javadoc)
	 * @see edu.frank.base.data.AbstractPerson#showInfo()
	 */
	@Override
	public String showInfo() {
		return "Teacher info :\n" +
		"ID:" + id + "\n" +
		"Name:" + name + "\n" +
		"Sex:" + sex + "\n" +
		"Dept:" + dept + "\n" +
		"Salary:" + salary + "\n";
	}

}