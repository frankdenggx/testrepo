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
 *  : edu.frank.base
 *  : AbstractPerson.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-29 06:58:39
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base.data;

import java.io.Serializable;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public abstract class AbstractPerson implements Serializable {

	/**
	 * 
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -6312092189934924771L;


	protected String id;
	protected String name;
	protected String sex;

	/**
	 *   <code>AbstractPerson</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public AbstractPerson() {
	}

	/**
	 *
	 * 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param id
	 * 			ID
	 * @param name
	 * 			
	 * @param sex
	 * 			
	 */
	public AbstractPerson(String id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public abstract String showInfo();

}