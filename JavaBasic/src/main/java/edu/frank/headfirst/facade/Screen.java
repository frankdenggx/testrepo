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
package edu.frank.headfirst.facade;

/**
 * <p>
 * 	Screen class
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class Screen {

	/**
	 *
	 * screen up
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void up() {
		System.out.println("screen up!");
	}

	/**
	 *
	 * screen down
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void down() {
		System.out.println("Screen down!");
	}

	@Override
	public String toString() {
		return "This is Screen object";
	}


}
