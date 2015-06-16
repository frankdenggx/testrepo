/*
 * Software License
 * The file Library is
 * Copyright (C) 2010-2011 Hotel1802 Technologies Studio All Right Reserved .
 *
 * By obtaining,using,and/or copying this software and/or its associated
 * documentation, you agree that you have read, understood, and will comply
 * with the following terms and conditions :
 *
 * Permission to use, copy, modify, and distribute this file and its associated
 * documentation for any purpose and without fee is hereby granted, provide that
 * the above copyright notice appears in all copies, and that both that copyright
 * notice and this permission ontice appear in supporting documentation, and that
 * the name of Hotel802 or the author not be used in advertising or publicity
 * pertaining to distribution of the file without specific, written prior permission .
 *
 */
/**
 * Copyright : Hotel1802 All Right Reserved.
 * JDK Version : 1.6.10
 * Project : JavaBasic
 * Package : com.yoyudeng.headfirst.templatemethod
 * File Name : AbstractClass.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-7 12:52:18
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.templatemethod;

/**
 * <p>
 * 	This class will show us which method can be defined in the template method.
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public abstract class AbstractClass {

	/**
	 *
	 * <code>templateMethod</code> template method
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	final void templateMethod() {
		primitiveOperation1();	// implement by subclass
		primitiveOperation2();	// implement by subclass
		concreteOperation();	// the subclass can't override this method.It
								// can be used by the super class or the subclass
		hook();					// with null or default implement
	}

	/**
	 *
	 * <code>primitiveOperation1</code> will be override by subclass
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	abstract void primitiveOperation1();

	/**
	 *
	 * <code>primitiveOperation2</code> will be override by subclass
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	abstract void primitiveOperation2();

	/**
	 *
	 * <code>concreteOperation</code> do something.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	final void concreteOperation(){
		// do something
	}

	/**
	 *
	 * <code>hook</code> method will provides the null or default.
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	void hook() {};

}
