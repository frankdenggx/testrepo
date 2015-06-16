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
 * Package : com.yoyudeng.operator
 * File Name : BitwiseOperator.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-5 03:19:15
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.operator;

/**
 * <p>
 * test the bitwise operator
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class BitwiseOperator {

	/**
	 * construct a new <code>BitwiseOperator</code> instance for class
	 *
	 * @since JavaBasic
	 */
	public BitwiseOperator() {
	}

	/**
	 *
	 * unsigned dextroposition
	 *
	 * @param operator
	 * 			source operator
	 * @param dextroposition
	 *			the dextroposition byte
	 * @since JavaBasic 1.0.0.0
	 */
	public void unsignDextroposition(int operator, int dextroposition) {
		System.out.println("The result of " + operator + ">>>()"
				+ dextroposition + " is " + (operator >>> dextroposition));
	}

}