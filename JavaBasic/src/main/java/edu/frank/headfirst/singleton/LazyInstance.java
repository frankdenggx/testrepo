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
 * File Name : LazyInstance.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-7 06:40:11
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.singleton;

/**
 * <p>
 * 	LazyInstance : one of singleton implement
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class LazyInstance {

	/**
	 * the only instance of the class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static LazyInstance instance;

	/**
	 *
	 * construct a new <code>LazyInstance</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private LazyInstance() {
	}

	/**
	 *
	 * <code>getInstance</code> : provides the global access entrance
	 *
	 * @return
	 * 		class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static synchronized LazyInstance getInstance() {
		if (instance == null) {
			instance = new LazyInstance();
		}
		return instance;
	}

}
