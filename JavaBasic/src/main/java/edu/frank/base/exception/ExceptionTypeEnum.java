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
 *  : edu.frank.base.exception
 *  : ExceptionTypeEnum.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 10:05:32
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base.exception;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public enum ExceptionTypeEnum {

	REGISTEREXCEPTION("Registration Exception"),	// 
	DBEXCEPTION("Database Operate Exception");

	/**
	 * 
	 */
	private String elemDescription;

	/**
	 *
	 *   <code>ExceptionTypeEnum</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param elemDescription
	 * 			
	 */
	private ExceptionTypeEnum(String elemDescription) {
		this.elemDescription = elemDescription;
	}

	/**
	 * 
	 *
	 * @return
	 * 		
	 */
	@Override
	public String toString() {
		return elemDescription;
	}

}