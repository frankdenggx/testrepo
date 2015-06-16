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
 * File Name : Projector.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-3 12:27:55
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.facade;

/**
 * <p>
 * Projector class
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class Projector {

	/**
	 * DvdPlayer instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DvdPlayer dvdPlayer;

	/**
	 * tv mode flag
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static boolean tvMode = false;

	/**
	 * wide screen mode flag
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static boolean wideScreenMode = false;

	/**
	 *
	 * turn on projector
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void on() {
		System.out.println("Projector on!");
	}

	/**
	 *
	 * turn off projector
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void off() {
		System.out.println("Projector off!");
	}

	/**
	 *
	 * set project to tv mode
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void tvMode() {
		if (tvMode) {
			System.out.println("Projector is on tv mode!");
		} else {
			System.out.println("Projector will set to tv mode!");
		}
		tvMode = true;
	}

	/**
	 *
	 * set projector to wide screen mode
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void wideScreenMode() {
		if (wideScreenMode) {
			System.out.println("Projector is on widde screen mode!");
		} else {
			System.out.println("Projector will set to wide screen mode!");
		}
		wideScreenMode = true;

	}

	/**
	 *
	 * set dvd player
	 *
	 * @param dvdPlayer
	 *			dvd player instance
	 * @since JavaBasic 1.0.0.0
	 */
	public void setDvd(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
		this.dvdPlayer.toString();
	}

	@Override
	public String toString() {
		return "This is Projector object!";
	}
}
