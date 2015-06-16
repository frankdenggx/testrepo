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
 * File Name : InternalFileReader.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-1-11 11:48:27
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <p>
 * InternalFileReader comment
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic
 */
public class InternalFileReader {

	//mark definition
	private static final String ENGLISH = "------------ENGLISH------------";
	private static final String CHINESE = "------------CHINESE------------";
	private static final String PUTONGHUA = "------------PUTONGHUA----------";

	/**
	 *
	 * <code>readFile</code> comment
	 *
	 * @param file
	 * 			the internal file prepare to read
	 * @return
	 * 			array contains the content around of the mark
	 * @throws IOException
	 * 			when the file object is null or the file is not existence or
	 * 			the file is not a file.
	 *
	 * @since JavaBasic
	 */
	public StringBuffer[] readFile(File file) throws IOException {
		if (null == file) {
			throw new IOException("Invald parameter,the file object is null");
		}
		if (!file.exists()) {
			throw new IOException("The file: '" + file.getAbsolutePath()
					+ "' is not existence");
		}
		if (!file.isFile()) {
			throw new IOException("The file: '" + file.getName()
					+ "' is not a file");
		}

		BufferedReader br = new BufferedReader(new FileReader(file));
		String tempString = null;
		StringBuffer bufferEnglish = new StringBuffer("");
		StringBuffer bufferChinese = new StringBuffer("");
		StringBuffer bufferPutonghua = new StringBuffer("");

		while ((tempString = br.readLine()) != null) {
			if (tempString.equals(ENGLISH)) {
				readContent(br, bufferEnglish, ENGLISH);
			} else if (tempString.equals(CHINESE)) {
				readContent(br, bufferChinese, CHINESE);
			} else if (tempString.equals(PUTONGHUA)) {
				readContent(br, bufferPutonghua, PUTONGHUA);
			}
		}

		return new StringBuffer[] { bufferEnglish, bufferChinese, bufferPutonghua };

	}

	/**
	 *
	 * <code>readContent</code> comment
	 *
	 * @param br
	 * @param sb
	 * @param flag
	 * @throws IOException
	 *
	 * @since JavaBasic
	 */
	private void readContent(BufferedReader br, StringBuffer sb, String flag)
			throws IOException {
		String tempString = null;
		while (((tempString = br.readLine()) != null)
				&& !(tempString.equals(flag))) {
			sb.append(tempString);
		}
	}

}
