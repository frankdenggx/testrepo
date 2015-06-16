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
 *  : RegistrationException.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 10:29:14
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
public final class RegistrationException extends AbstractException {

	/**
	 * ID
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -2917049967552491858L;

	/**
	 *   <code>RegistrationException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public RegistrationException() {
	}

	/**
	 *   <code>RegistrationException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param exceptionType
	 * 			
	 */
	public RegistrationException(Enum<ExceptionTypeEnum> exceptionType) {
		super(exceptionType);
	}

	/**
	 *   <code>RegistrationException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param exceptionType
	 * 			
	 * @param message
	 * 			
	 */
	public RegistrationException(Enum<ExceptionTypeEnum> exceptionType,
			String message) {
		super(exceptionType, message);
	}

	/**
	 *   <code>RegistrationException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param message
	 * 			
	 */
	public RegistrationException(String message) {
		super(message);
	}

	/**
	 *   <code>RegistrationException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param cause
	 */
	public RegistrationException(Throwable cause) {
		super(cause);
	}

	/**
	 *   <code>RegistrationException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param message
	 * @param cause
	 */
	public RegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

}