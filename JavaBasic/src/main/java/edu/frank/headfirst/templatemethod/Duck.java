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
package edu.frank.headfirst.templatemethod;

/**
 * <p>
 * 	Duck will implement the comparable interface.
 * </p>
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class Duck implements Comparable<Object> {

	/**
	 * Duck name
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	String name;

	/**
	 * Duck weight
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	int weight;

	/**
	 * construct a new <code>Duck</code> instance for class
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object object) {
		Duck otherDuck = (Duck) object;
		if (weight < otherDuck.weight) {
			return -1;
		} else if (weight > otherDuck.weight) {
			return 1;
		} else {	// this.weight = otherDuck.weight
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Duck [name=" + name + ", weight=" + weight + "]";
	}

}
