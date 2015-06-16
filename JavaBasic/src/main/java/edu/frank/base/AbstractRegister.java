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
 *  : AbstractRegister.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 10:43:49
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base;

import java.util.ArrayList;

/**
 * <p>
 * 
 * </p>
 *
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public abstract class AbstractRegister extends Thread {

	int id; // ID
	String name; // 
	RegisterEnum registerType; // 

	ArrayList<Object> registrationList; //
	int nRegisteredNum;	//
	int nMaxAllowNum;	//

	/**
	 *
	 *  <code>AbstractRegister</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param id
	 *            ID
	 * @param name
	 *            
	 * @param registerType
	 *            
	 */
	public AbstractRegister(int id, String name, RegisterEnum registerType) {
		this.id = id;
		this.name = name;
		this.registerType = registerType;
	}

	/**
	 *
	 * 
	 *
	 * @return
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public ArrayList<Object> getRegistrationList() {
		return registrationList;
	}

	/**
	 *
	 * 
	 *
	 * @return
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public int getRegisteredNum() {
		return nRegisteredNum;
	}

	/**
	 *
	 * 
	 *
	 * @return
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public int getMaxAllowNum() {
		return nMaxAllowNum;
	}

	/**
	 *
	 * 
	 *
	 * @return
	 *		
	 * @since JavaBasic 1.0.0.0
	 */
	public int getResidueNum() {
		return (nMaxAllowNum - nRegisteredNum);
	}

	/**
	 * ID
	 *
	 * @return
	 * 		
	 */
	@Override
	public String toString() {
		return "\nID" + id + "\n" + name + "\n"
				+ registerType.toString();
	}

}