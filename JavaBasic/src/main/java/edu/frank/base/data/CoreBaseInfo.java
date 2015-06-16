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
 * Copyright :  Hotel1802 All Right Reserved.
 * JDK Version :  1.6.10
 * Project :  JavaBasic
 * Package :  edu.frank.base.data
 * File Name :  CoreBaseInfo.java
 * File Version : 1.0.0.0
 * File Spec: comments
 *
 * Author : Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * Date : 2011-6-15 12:41:32
 * History :
 * <Name>				<Date>				<Comment>
 *
 */
package edu.frank.base.data;

import java.io.Serializable;

/**
 * <p>
 * 	CoreBaseInfo is the abstract class of all the information object.
 * </p>
 *
 * @author Frank Email:<a href="mailto:yoyudenghihi@163.com">yoyudenghihi@163.com</a>
 * @Version JavaBasic 1.0.0.0
 */
public abstract class CoreBaseInfo implements Comparable, Cloneable, Serializable {
	protected String id;
	protected String desc;

	public String getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return this.desc;
	}
}
