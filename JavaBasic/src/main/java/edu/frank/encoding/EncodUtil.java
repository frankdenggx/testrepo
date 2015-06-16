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
 * pertaining to distribution of the file without specific, written prior permission.
 * 
 */

/**
 * CopyRight: <Hotel1802>
 * JDK Version: <1.5.0.8>
 * Project: <JavaBasic 1.0>
 *
 * Package: <edu.frank.encoding>
 * File Name: <Encoding.java>
 * File Version: 1.0
 * File Desc: <>
 *
 * Author: <Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a>>
 * DateTime: <2012-03-25 09:13:15>
 *
 *
 */
package edu.frank.encoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.frank.office.excel.BackupFileFilter;

/**
 * <p>
 * This class will help you change a char or string's encoding to another.
 * </p>
 * 
 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
 * <p>
 * 
 * Modifier: <Frank Deng>
 * <p>
 * Modify Time: <2012-03-25 09:13:15>
 * <p>
 * Modification: <Created>
 * <p>
 * 
 * 
 * @since JavaBasic 1.0
 * @Version JavaBasic 1.0
 */
public class EncodUtil {

	/**
	 * 
	 * Constructor of <code>EncodUtil</code>
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * Modifier: <Frank Deng>
	 * <p>
	 * Modify Time: <2012-03-25 09:13:15>
	 * <p>
	 * Modification: <Created>
	 * <p>
	 * 
	 * @throws Exception
	 * Constructor Exception
	 * 
	 * 
	 * @since JavaBasic 1.0
	 */
	public EncodUtil() {
	}

	/**
	 * 
	 * Retrieve all files under the input folder and put them into an <code>ArrayList</code> So that you can use in
	 * other method. Notice that the parameter named extensions is an array contained of <code>String</code>, you should
	 * define it as "{'txt', 'java', ...}". Furthermore, you should handle the exception included
	 * <code>IOException</code> and others.
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * 
	 * Modifier: <Frank Deng>
	 * <p>
	 * Modify Time: <2012-03-25 09:13:15>
	 * <p>
	 * Modification: <Created>
	 * <p>
	 * 
	 * @param folder
	 * The root folder
	 * @param fileList
	 * All file under the root folder
	 * @param extensions
	 * file extension
	 * @throws Exception
	 * IOException and other exception
	 * 
	 * @since JavaBasic 1.0
	 */
	public static void getAllFiles(File folder, List<File> fileList, String... extensions) throws Exception {
		if (folder == null || !folder.exists()) {
			return;
		}
		File[] files = folder.listFiles();
		File[] javaFiles = folder.listFiles(new BackupFileFilter(extensions));
		for (File file : javaFiles) {
			fileList.add(file);
		}
		for (File file : files) {
			if (file == null || !file.exists() || !file.isDirectory()) {
				continue;
			} else {
				getAllFiles(file, fileList);
			}
		}
	}

	/**
	 * 
	 * Remove all character not encode by 'ISO-8859-1'.
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * 
	 * Modifier: <Frank Deng>
	 * <p>
	 * Modify Time: <2012-03-25 09:13:15>
	 * <p>
	 * Modification: <Created>
	 * <p>
	 * 
	 * @param file
	 * source file
	 * @throws Exception
	 * remove character exception
	 * 
	 * @since JavaBasic 1.0
	 */
	public static void toISO88591(File file) throws Exception {
		if (file != null && file.exists() && file.isFile()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			File tempFile = new File(file.getParentFile() + "/temp.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
			for (int c = br.read(); c != -1;) {
				if (!isISO88591((char) c)) {
					bw.write(c);
				}
				c = br.read();
			}
			br.close();
			bw.flush();
			bw.close();
			file.delete();
			tempFile.renameTo(file);
			/*
			 * RandomAccessFile rf = new RandomAccessFile(file, "rw"); String line = null; String temp = null;
			 * while(!StringUtils.isBlank(line = rf.readLine())) { if (!getEncoding(line).equals("ISO-8859-1")) { temp =
			 * line;
			 * 
			 * //line = tranToISO88591(line); rf.seek(rf.getFilePointer()-temp.length()); for (int i = 0; i <
			 * temp.length(); i++) { line.replace(line.charAt(i),(char)32); } rf.write(line.getBytes()); } } rf.close();
			 */
		}
	}

	/**
	 * 
	 * Translate a string's encoding as 'ISO-8859-1'.
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * 
	 * Modifier: <Frank Deng>
	 * <p>
	 * Modify Time: <2012-03-25 09:13:15>
	 * <p>
	 * Modification: <Created>
	 * <p>
	 * 
	 * @param str
	 * the source string
	 * @return encoded string
	 * @throws Exception
	 * translate exception
	 * 
	 * @since JavaBasic 1.0
	 */
	public static String tranToISO88591(String str) throws Exception {
		String code = getEncoding(str);
		return (new String(str.getBytes(code), "ISO-8859-1"));
	}

	/**
	 * 
	 * Estimate a character is encoded by 'ISO-8859-1' or not.
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * 
	 * Modifier: <Frank Deng>
	 * <p>
	 * Modify Time: <2012-03-25 09:13:15>
	 * <p>
	 * Modification: <Created>
	 * <p>
	 * 
	 * @param c
	 * the source character
	 * @return true-the character is encode by 'ISO-8859-1' false-the character isn't encoded by 'ISO-8859-1'
	 * @throws Exception
	 * estimate exception
	 * 
	 * @since JavaBasic 1.0
	 */
	public static boolean isISO88591(char c) throws Exception {
		Character character = new Character(c);
		String str = character.toString();
		byte[] bytes = str.getBytes();
		if (bytes.length > 1)
			return true;
		return false;
	}

	/**
	 * 
	 * Return the encoding of the source string.
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 * 
	 * Modifier: <Frank Deng>
	 * <p>
	 * Modify Time: <2012-03-25 09:13:15>
	 * <p>
	 * Modification: <Created>
	 * <p>
	 * 
	 * @param str
	 * source string
	 * @return encoding name of the source string
	 * @throws Exception
	 * get encoding name exception
	 * 
	 * @since JavaBasic 1.0
	 */
	public static String getEncoding(String str) throws Exception {
		String encode = "";
		String[] encodes = { "GB2312", "ISO-8859-1", "UTF-8", "GBK" };
		for (int i = 0; i < encodes.length; i++) {
			if (str.equals(new String(str.getBytes(encodes[i]), encodes[i]))) {
				encode = encodes[i];
				break;
			}
		}
		return encode;
	}

}
