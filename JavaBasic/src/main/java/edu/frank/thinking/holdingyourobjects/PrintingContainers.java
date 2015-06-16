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
 * File Name : PrintingContainers.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-15 10:40:39
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.thinking.holdingyourobjects;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * PrintingContainers comment
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic
 */
public class PrintingContainers {

	static Map<Object, Object> fill(Map<Object, Object> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}

	static void print(Map<Object, Object> map) {
		System.out.println(map.toString());
	}

	/**
	 * <code>main</code> comment
	 *
	 * @param args
	 *
	 * @since JavaBasic
	 */
	public static void main(String[] args) {
		// fill(new HashMap<Object,Object>());
		print(fill(new HashMap<Object, Object>()));
		print(fill(new TreeMap<Object, Object>()));
		print(fill(new LinkedHashMap<Object, Object>()));

	}

}
