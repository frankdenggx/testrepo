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
 *  : AbstractException.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 09:58:02
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base.exception;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public abstract class AbstractException extends Throwable implements
		Serializable {

	/**
	 * ID
	 * @since JavaBasic 1.0.0.0
	 */
	private static final long serialVersionUID = -1136057135298380142L;

	/**
	 * 
	 * @since JavaBasic 1.0.0.0
	 */
	Enum<ExceptionTypeEnum> exceptionType;

	/**
	 *   <code>AbstractException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public AbstractException() {
	}

	/**
	 *
	 *   <code>AbstractException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param exceptionType
	 * 				
	 */
	public AbstractException(Enum<ExceptionTypeEnum> exceptionType) {
		this.exceptionType = exceptionType;
	}

	/**
	 *
	 *   <code>AbstractException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param exceptionType
	 * 				
	 * @param message
	 * 				
	 */
	public AbstractException(Enum<ExceptionTypeEnum> exceptionType, String message) {
		super(message);
		this.exceptionType = exceptionType;

	}

	/**
	 *   <code>AbstractException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param message
	 */
	public AbstractException(String message) {
		super(message);
	}

	/**
	 *   <code>AbstractException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param cause
	 */
	public AbstractException(Throwable cause) {
		super(cause);
	}

	/**
	 *   <code>AbstractException</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param message
	 * @param cause
	 */
	public AbstractException(String message, Throwable cause) {
		super(message, cause);
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return exceptionType.toString();
	}
}