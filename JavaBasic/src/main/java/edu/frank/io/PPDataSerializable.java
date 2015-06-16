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
 * Package : edu.frank.io
 * File Name : PPDataSerializable.java
 * File Version : 1.0.0.0
 * Description: <>
 *
 * Author : Frank <FrankDengGX@gmail.com>
 * Date : 2012-3-29
 * History :
 * <Name>				<Date>				<Content>
 * Frank				2012-3-29				<Created>
 *
 */
package edu.frank.io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>
 * 	PPDataSerializable comment
 * </p>
 * @author Frank <FrankDengGX@gmail.com>
 * <p>
 *	No.1
 *	Modifier: Frank
 *	Modified Time: 2012-3-29 2:41:46
 *  Modified Content: <Created>
 * </p>
 *
 * @Version JavaBasic 1.0.0.0
 * @Since JavaBasic 1.0.0.0
 */
public class PPDataSerializable {
	private static PPDataSerializable instance = null;
	private PPDataSerializable(){
	};
	public static PPDataSerializable getInstance() {
		if (instance == null) {
			instance = new PPDataSerializable();
		}
		return instance;
	}

	public void writeObject(File file, ObjectOutputStream oos) throws Exception {
		if (null == file || !file.exists()) {
			throw new IllegalArgumentException("File error!");
		}
		if (!file.canWrite()) {
			throw new IllegalArgumentException("File error!");
		}
		try {
			if (null == oos) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
			}
			PPData data = new PPData();
			oos.writeObject(data); // 
			oos.close();
		} catch (IOException ex) {
			throw new IOException(ex);
		}

	}

	public Object readObject(File file, ObjectInputStream ois) throws Exception {
		Object obj = null;
		if (null == file || !file.exists()) {
			throw new IllegalArgumentException("File error!");
		}
		if (!file.canWrite()) {
			throw new IllegalArgumentException("File error!");
		}

		try {
			if (null == ois) {
				ois = new ObjectInputStream(new FileInputStream(file));
			}
			obj = ois.readObject();
		} catch (EOFException e) {
			return obj;
		} catch (IOException ex) {
			throw new IOException(ex);
		} finally {
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException ex) {
					throw new IOException(ex);
				}
			}
			ois = null;
		}
		return obj;
	}

	public void test(final String fileName) {
		File file = null;
		try {
			file = new File(fileName);
			if (null != file) {
				if (!file.exists()) {
					file.createNewFile();
				}
			}
			writeObject(file, null);
			PPData data = (PPData) readObject(file, null);
			data.output();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
