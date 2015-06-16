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
 * Package : com.yoyudeng.thinking.holdingyourobjects
 * File Name : AddingGroups.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-15 09:52:34
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.thinking.holdingyourobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * AddingGroups comment
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic
 */
public class AddingGroups {

	/**
	 * <code>main</code> comment
	 *
	 * @param args
	 *
	 * @since JavaBasic
	 */
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(
				1, 2, 3, 4, 5));
		Integer[] moreInts = { 6, 7, 8, 9, 10 };
		collection.addAll(Arrays.asList(moreInts));
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);
		System.out.print("collection elements : ");
		for (Integer i : collection) {
			System.out.print(i + " ");
		}
		System.out.print("\nlist elements : ");
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99);
		//list.add(21);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

}
