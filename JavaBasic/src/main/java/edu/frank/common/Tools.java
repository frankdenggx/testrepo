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
 * Project : ordmansys
 * Package : com.hozdo.ordmansys.util
 * File Name : Tools.java
 * File Version : 1.0.0.0
 * Description: <>
 *
 * Author : Frank <FrankDengGX@gmail.com>
 * Date : 2012-12-13
 * History :
 * <Name>				<Date>				<Content>
 * Frank				2012-12-13				<Created>
 *
 */
package edu.frank.common;

import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * <p>
 * 	Tools comment
 * </p>
 * @author Frank <FrankDengGX@gmail.com>
 * <p>
 *	No.1
 *	Modifier: Frank
 *	Modified Time: 2012-12-13 9:03:16
 *  Modified Content: <Created>
 * </p>
 *
 * @Version ordmansys 1.0.0.0
 * @Since ordmansys 1.0.0.0
 */
public class Tools {

	public static Timestamp getTime(String language, String location) {
		Locale locale = Locale.getDefault();
		TimeZone timeZone = TimeZone.getDefault();
		if (!StringUtils.isBlank(language)) {
			locale = new Locale(language);
		}
		if (!StringUtils.isBlank(location)) {
			timeZone = TimeZone.getTimeZone(location);
		}
		Calendar calendar = Calendar.getInstance(timeZone, locale);
		Timestamp st = new Timestamp(calendar.getTimeInMillis());
		return st;
	}

	public static String getUID() {
		UUID uuid = UUID.randomUUID();	// ȡUUIDΨһ��ʶ��
		ByteBuffer bbuffer = ByteBuffer.allocate(16).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
		String base64 = new String(Base64.encodeBase64(bbuffer.array())).substring(0, 22);	// 64λѹ���ȡǰ22λ
		String prefix = DateFormatUtils.formatUTC(new Date(), "yyyyDDD");	// ������ڱ�ʶ�����ײ����
		return prefix + base64;
	}

}
