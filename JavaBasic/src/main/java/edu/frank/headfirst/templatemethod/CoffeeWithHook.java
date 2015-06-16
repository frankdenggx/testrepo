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
 * Package : com.yoyudeng.headfirst.templatemethod
 * File Name : TeaWithHook.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-7 01:09:38
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.headfirst.templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * TeaWithHook
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic 1.0.0.0
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.yoyudeng.headfirst.templatemethod.CaffeineBeverageWithHook#addCondiments
	 * ()
	 */
	@Override
	void addCondiments() {
		System.out.println("Adding sugar and milk !");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.yoyudeng.headfirst.templatemethod.CaffeineBeverageWithHook#brew()
	 */
	@Override
	void brew() {
		System.out.println("Dripping coffee through filter !");

	}

	@Override
	public boolean customerWantsCondiments() { // This is the hook method.
		String answer = getUserInput();

		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * <code>getUserInput</code> will get user answer.
	 *
	 * @return
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String getUserInput() {
		String answer = null;
		System.out
				.print("Would you like milk and sugar with your coffee (y/n)? ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException ex) {
			System.err.println("IO error tring to read your answer !");
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}

}
