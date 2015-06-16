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
 * Package : com.yoyudeng.headfirst.singleton
 * File Name : EagerInstance.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-7 06:45:54
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.singleton;

/**
 * <p>
 * 	EagerInstance : one of the singleton implement
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class EagerInstance {

	/**
	 * uniqueness class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static EagerInstance instance = new EagerInstance();

	/**
	 *
	 * construct a new <code>EagerInstance</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private EagerInstance(){

	}

	/**
	 *
	 * <code>getInstance</code> : return the class instance.
	 *
	 * @return
	 * 		uniqueness class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static EagerInstance getInstance() {
		return instance;
	}
}
