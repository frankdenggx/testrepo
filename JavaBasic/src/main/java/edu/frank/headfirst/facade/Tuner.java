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
 * Package : com.yoyudeng.headfirst.facade
 * File Name : Tuner.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-3 12:48:44
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.facade;

/**
 * <p>
 * Tuner class
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class Tuner {

	/**
	 * Amplifier class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Amplifier amplifier;

	/**
	 * am channel
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static boolean am = false;

	/**
	 * fm channel
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static boolean fm = false;

	/**
	 * radio frequency
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static float frequency = 0.0f;

	/**
	 *
	 * turn on tuner
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void on() {
		System.out.println("Tuner on!");
	}

	/**
	 *
	 * turn off tuner
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void off() {
		System.out.println("Tuner off!");
	}

	/**
	 *
	 * set tuner to am channel
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void setAm() {
		if (am && !fm) {
			System.out.println("Tuner is on am!");
		} else {
			System.out.println("Tuner will set to am!");
		}
		am = true;
		fm = false;
	}

	/**
	 *
	 * set tuner to fm channel
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void setFm() {
		if (fm && !am) {
			System.out.println("Tuner is on fm!");
		} else {
			System.out.println("Tuner will set to fm!");
		}
		fm = true;
		am = false;
	}

	/**
	 *
	 * set tuner frequency
	 *
	 * @param frequency
	 *			tuner frequency, must >= 0.0
	 * @since JavaBasic
	 */
	public void setFrequency(float frequency) {
		Tuner.frequency = frequency;
	}

	@Override
	public String toString() {
		return "This is Tuner object!";
	}
}
