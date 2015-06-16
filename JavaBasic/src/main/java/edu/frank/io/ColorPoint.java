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
 * Package : com.yoyudeng.io
 * File Name : ColorPoint.java
 * File Version : 1.0.0.0
 *
 *
 * Author : Frank
 * Date : 2011-2-26 04:08:15
 * History :
 * <Name>				<Date>				<Content>
 * Frank				am 04:08:15			 create
 */
package edu.frank.io;

/**
 * <p>
 * 	ColorPoint extends from <code>Point</code>, it is only special for the color.
 * </p>
 * @author yoyu
 * @Version JavaBasic
 */
public class ColorPoint extends Point {

	/**
	 * the color enumeration
	 */
	private final Color colorPoint;

	/**
	 * construct a new <code>ColorPoint</code> instance for class
	 *
	 * @since JavaBasic
	 * @param mNPointX
	 * 			X point position
	 * @param mNPointY
	 * 			Y point position
	 */
	public ColorPoint(Color colorPoint,int mNPointX, int mNPointY) {
		super(mNPointX, mNPointY);
		this.colorPoint = colorPoint;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (41 * super.hashCode() + colorPoint.hashCode());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		ColorPoint classColorPoint = (ColorPoint) obj;
		if (obj instanceof ColorPoint) {
			result = classColorPoint.canEqual(this) &&
				colorPoint.equals(classColorPoint.colorPoint) &&
				super.equals(classColorPoint);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.yoyudeng.io.Point#canEqual(java.lang.Object)
	 */
	@Override
	public boolean canEqual(Object mObjectPoint) {
		return super.canEqual(mObjectPoint);
	}


}
