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
 * File Name : DvdPlayer.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-3 12:36:11
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.facade;

/**
 * <p>
 * DvdPlayer class
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class DvdPlayer {

	/**
	 * Amplifier class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Amplifier amplifier;

	/**
	 * SurroundAudio class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Object surroundAudio;

	/**
	 * TwoChannelAudio class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Object twoChannelAudio;

	/**
	 *
	 * turn on the dvd player
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void on() {
		System.out.println("dvd player on!");
	}

	/**
	 *
	 * turn off the dvd player
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void off() {
		System.out.println("dvd player off!");
	}

	/**
	 *
	 * eject the dvd player
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void eject() {
		System.out.println("dvd player eject!");
	}

	/**
	 *
	 * pause the dvd player
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void pause() {
		System.out.println("dvd player pause!");
	}

	/**
	 *
	 * play the dvd player
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void play() {
		System.out.println("dvd player play!");
	}

	/**
	 *
	 * play the dvd player with special object
	 *
	 * @param playInObject
	 *			the special in object
	 * @since JavaBasic 1.0.0.0
	 */
	public void play(Object playInObject) {
		System.out.println("dvd player play with special object!");
	}

	/**
	 *
	 * set SurroundAudio instance
	 *
	 * @param surroundAudio
	 *			SurroundAudio object
	 * @since JavaBasic	1.0.0.0
	 */
	public void setSurroundAudio(Object surroundAudio) {
		this.surroundAudio = surroundAudio;
	}

	/**
	 *
	 * set TwoChannelAudio instance
	 *
	 * @param twoChannelAudio
	 *			TwoChannelAudio object
	 * @since JavaBasic 1.0.0.0
	 */
	public void setTwoChannelAudio(Object twoChannelAudio) {
		this.twoChannelAudio = twoChannelAudio;
	}

	/**
	 *
	 * stop the dvd player
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void stop() {
		System.out.println("stop dvd player!");
	}

	@Override
	public String toString() {
		return "This is DvdPlayer object!";
	}
}
