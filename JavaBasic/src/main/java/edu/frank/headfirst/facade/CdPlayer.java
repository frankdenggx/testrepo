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
 * File Name : CdPlayer.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-3 12:58:46
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.facade;

/**
 * <p>
 * 	CdPlayer class
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class CdPlayer {

	/**
	 * Amplifier class instance
	 */
	private Amplifier amplifier;

	/**
	 *
	 * turn on the amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void on() {
		System.out.println("cd player on!");
	}

	/**
	 *
	 * turn off the amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void off() {
		System.out.println("cd player off!");
	}

	/**
	 *
	 * eject the amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void eject() {
		System.out.println("cd player eject!");
	}

	/**
	 *
	 * pause the amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void pause() {
		System.out.println("cd player pause!");
	}

	/**
	 *
	 * play the amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void play() {
		System.out.println("cd player play!");
	}

	/**
	 *
	 * play the amplifier with special object
	 *
	 * @param playInObject
	 *			special in object
	 * @since JavaBasic 1.0.0.0
	 */
	public void play(Object playInObject) {
		System.out.println("cd palyer will play with special object!");
	}

	/**
	 *
	 * stop the amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void stop() {
		System.out.println("cd player stop!");
	}

	@Override
	public String toString() {
		return "This is CdPlayer object!";
	}
}
