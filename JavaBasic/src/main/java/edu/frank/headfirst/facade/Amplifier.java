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
 * 	Amplifier class
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class Amplifier {

	/**
	 * CdPlayer class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private CdPlayer cdPlayer;

	/**
	 * DvdPlayer class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DvdPlayer dvdPlayer;

	/**
	 * Tuner class instance
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Tuner tuner;

	/**
	 * surround sound flag
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private boolean surroundSound = false;

	/**
	 * stereo sound flag
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private boolean stereoSound = false;

	/**
	 * tuner initial volume
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private int volume = 100;

	/**
	 *
	 * turn on amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void on() {
		System.out.println("Amplifier on!");
	}

	/**
	 *
	 * turn off amplifier
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void off() {
		System.out.println("Amplifier off!");
	}

	/**
	 *
	 * set CdPlayer object
	 *
	 * @param cdPlayer
	 *			cd player
	 * @since JavaBasic 1.0.0.0
	 */
	public void setCd(CdPlayer cdPlayer) {
		this.cdPlayer = cdPlayer;
	}

	/**
	 *
	 * set DvdPlayer object
	 *
	 * @param dvdPlayer
	 *			dvd player
	 * @since JavaBasic	1.0.0.0
	 */
	public void setDvd(DvdPlayer dvdPlayer) {
		this.dvdPlayer = dvdPlayer;
	}

	/**
	 *
	 * set stereo sound
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void setStereoSound() {
		if (stereoSound && !surroundSound) {
			System.out.println("Amplifier is on stereo sound!");
		} else {
			System.out.println("Amplifier will be set on stereo sound!");
		}
		stereoSound = true;
		surroundSound = false;
	}

	/**
	 *
	 * set surround sound
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void setSurroundSound() {
		if (surroundSound && !stereoSound) {
			System.out.println("Amplifier is on surround sound!");
		} else {
			System.out.println("Amplifier will be set on surround sound!");
		}
		surroundSound = true;
		stereoSound = false;
	}

	/**
	 *
	 * set tuner object
	 *
	 * @param tuner
	 *			tuner object
	 * @since JavaBasic	1.0.0.0
	 */
	public void setTuner(Tuner tuner) {
		this.tuner = tuner;
	}

	/**
	 *
	 * set tuner volume
	 *
	 * @param volume
	 *			volume number (0~100)
	 * @since JavaBasic 1.0.0.0
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "This is Amplifier object!";
	}
}
