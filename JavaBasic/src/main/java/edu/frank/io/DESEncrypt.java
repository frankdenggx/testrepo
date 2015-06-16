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
 * File Name : DESEncript.java
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

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

/**
 * <p>
 * 	DESEncript comment
 * </p>
 * @author Frank <FrankDengGX@gmail.com>
 * <p>
 *	No.1
 *	Modifier: Frank
 *	Modified Time: 2012-3-29 1:17:59
 *  Modified Content: <Created>
 * </p>
 *
 * @Version JavaBasic 1.0.0.0
 * @Since JavaBasic 1.0.0.0
 */
public class DESEncrypt {

	private static String defaultKey = "";
	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;

	/**
	 * construct a new <code>DESEncript</code> instance for class
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-3-29 1:17:59
	 * Modifier Content:
	 * </p>
	 *
	 * @since JavaBasic
	 */
	public DESEncrypt() throws Exception {
		this(defaultKey);
	}

	public DESEncrypt(String paramKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(paramKey.getBytes());
		this.encryptCipher = Cipher.getInstance("DES");
		this.encryptCipher.init(Cipher.ENCRYPT_MODE, key);
		this.decryptCipher = Cipher.getInstance("DES");
		this.decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	public static String byteArr2HexStr(byte[] arr) throws Exception {
		int len = arr.length;
		StringBuffer sb = new StringBuffer(len * 2);
		for (int i = 0; i < len; i++) {
			int temp = arr[i];
			while (temp < 0) {
				temp += 256;
			}
			if (temp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(temp, 16));
		}
		return sb.toString();
	}

	public static byte[] hex2byteArr(String hex) throws Exception {
		byte[] arr = hex.getBytes();
		int len = arr.length;
		byte[] out = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			String temp = new String(arr, i, 2);
			out[i / 2] = (byte) Integer.parseInt(temp, 16);
		}
		return out;
	}

	public byte[] encrypt(byte[] byteArr) throws Exception {
		return this.encryptCipher.doFinal(byteArr);
	}

	public String encrypt(String enString) throws Exception {
		return byteArr2HexStr(encrypt(enString.getBytes()));
	}

	public byte[] decrypt(byte[] byteArr) throws Exception {
		return this.decryptCipher.doFinal(byteArr);
	}

	public String decrypt(String deString) throws Exception {
		return new String(decrypt(hex2byteArr(deString)));
	}

	private Key getKey(byte[] byteArr) throws Exception {
		byte[] arr = new byte[8];
		for (int i = 0; i < byteArr.length && i < arr.length; i++) {
			arr[i] = byteArr[i];
		}

		Key key = new javax.crypto.spec.SecretKeySpec(arr, "DES");
		return key;
	}

	public static void main(String[] args) {
		try {
			String test = "f9a7d97eb107b4bbd9dacb1749fe0194";
			DESEncrypt instance = new DESEncrypt();
			System.out.println("-------- " + test);
			String enString = instance.encrypt(test);
			System.out.println("-------- " + enString);
			System.out.println("-------- " + instance.decrypt("468941e674cd0569bd76b9d7665f18fc"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
