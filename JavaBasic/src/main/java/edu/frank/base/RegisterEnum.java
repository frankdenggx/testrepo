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
 *  : RegisterEnum.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 10:47:15
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base;

/**
 * <p>
 * 	RegisterEnum 
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public enum RegisterEnum {
	CLASSREGISTER("Class Register"),	//
	CLIENTREGISTER("Client Register");	//

	/**
	 * 
	 */
	private String registerType;

	/**
	 *
	 *   <code>RegisterEnum</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param registerType
	 * 			
	 */
	private RegisterEnum(String registerType) {
		this.registerType = registerType;
	}

	/**
	 * 
	 *
	 * @return
	 * 		String
	 */
	@Override
	public String toString() {
		return registerType;
	}
}