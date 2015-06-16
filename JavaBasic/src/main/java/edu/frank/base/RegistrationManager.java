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
 *  : RegistrationManager.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 11:10:44
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base;

import edu.frank.base.exception.RegistrationException;

/**
 * <p>
 * 	RegistrationManager 
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public final class RegistrationManager implements IRegisterController, Runnable {

	/**
	 *   <code>RegistrationManager</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public RegistrationManager() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see edu.frank.base.IRegisterController#register(int, java.lang.String)
	 */
	@Override
	public int register(int id, String name) throws RegistrationException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.frank.base.IRegisterController#release(int)
	 */
	@Override
	public int release(int id) throws RegistrationException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.frank.base.IRegisterController#release(java.lang.String)
	 */
	@Override
	public int release(String name) throws RegistrationException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}