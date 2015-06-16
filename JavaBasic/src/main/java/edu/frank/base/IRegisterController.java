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
 *  : IRegisterController.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 10:33:56
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base;

import edu.frank.base.exception.RegistrationException;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public interface IRegisterController {

	/**
	 *
	 * ID
	 *
	 * @param id
	 * 			ID
	 * @param name
	 * 			
	 * @return
	 * 			 0- 1-
	 * @throws RegistrationException
	 * 			
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	int register(int id, String name) throws RegistrationException;

	/**
	 *
	 * ID
	 *
	 * @param id
	 * 			ID
	 * @return
	 * 			 0-	1-
	 * @throws RegistrationException
	 * 			
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	int release(int id) throws RegistrationException;

	/**
	 *
	 * 
	 *
	 * @param name
	 * 			
	 * @return
	 * 			 0- 1-
	 * @throws RegistrationException
	 * 			
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	int release(String name) throws RegistrationException;

}