/*
 * Software License
 * The file Library is
 * Copyright (C) 2010-2011 DOTASEVEN Technologies Studio All Right Reserved .
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
 * Copyright : DOTASEVEN All Right Reserved.
 * JDK Version : 1.6.10
 * Project : JavaBasic
 * Package : edu.frank.util
 * File Name : DateUtil.java
 * File Version : 1.0.0.0
 * File Desc : Date common operation class
 *
 * Author : <a href="mailto:yoyudenghihi@163.com?subject=Java+Programming+Technology+Communication&body=Hi,+Frank,">Frank Deng</a>
 * DateTime : 2011-9-2 11:07:24
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * Date common operation class. It's a class decleared <code>final</code>.
 * </p>
 *
 * @author <a href="mailto:yoyudenghihi@163.com?subject=Java+Programming+Technology+Communication&body=Hi,+Frank,">Frank Deng</a>
 * <p>
 *
 * Modifier: <p>
 * Modify Time: 2011-9-2 11:37:45 <p>
 * Modify Content: content <p>
 *
 * @Version JavaBasic 1.0
 * @since JavaBasic 1.0
 */
public final class DateUtil {

	/**
	 * Program logger
	 *
	 * @since JavaBasic 1.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(DateUtil.class);

	public static int calculateDate(java.util.Date date1, java.util.Date date2) throws Exception {
		if ((date1 == null) || (date2 == null)) {
			logger.equals("invald input parameter");
			throw new Exception("");
		}
		java.math.BigDecimal duration = new java.math.BigDecimal( (date2.getTime() - date1.getTime())/(24 * 60 * 60 * 1000));
		return duration.intValue();
	}

	public static java.util.Date formatDate(java.util.Date date, String formater) throws ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(formater);
		String dateString = sdf.format(date);
		return parseDate(dateString, formater);
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-23 02:08:36> <p>
	 * :	<> <p>
	 *
	 * @param date
	 * 			
	 * @return
	 *		 	, 2011-05-11 12:00:25 2011-05-11 00:00:00
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public static java.util.Date getStartTime(java.util.Date date) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(java.util.Calendar.HOUR);
		boolean time = (calendar.get(java.util.Calendar.AM_PM) == java.util.Calendar.AM);
		calendar.set(java.util.Calendar.HOUR_OF_DAY, 24);
		calendar.set(java.util.Calendar.HOUR,time?0:(-(hour+12)));
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		calendar.set(java.util.Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-23 02:08:36> <p>
	 * :	<> <p>
	 *
	 * @param date
	 * 			
	 * @return
	 *		 	, 2011-05-11 12:00:25 2011-05-11 23:59:59.999
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public static java.util.Date getEndTime(java.util.Date date) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		boolean time = (calendar.get(java.util.Calendar.AM_PM) == java.util.Calendar.AM);
		calendar.set(java.util.Calendar.HOUR_OF_DAY, 24);
		calendar.set(java.util.Calendar.HOUR,time?23:11);
		calendar.set(java.util.Calendar.MINUTE, 59);
		calendar.set(java.util.Calendar.SECOND, 59);
		calendar.set(java.util.Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-24 04:29:36> <p>
	 * :	<> <p>
	 *
	 * @param strDate
	 * 			"20110225""2011/02/25""2011-02-25"
	 * @return
	 *			: 2011-02-25
	 * @throws Exception
	 * 			
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public static java.util.Date getDate(String strDate) throws Exception {
		if(StringUtils.isBlank(strDate)) {
			throw new Exception("");
		}
		String realDateString = strDate;
		if (strDate.indexOf("/") > 0) {
			if (!((strDate.length() == 10) && strDate.matches("[0-9]{4}/[0-1][0-9]/[0-3][0-9]"))) {
				throw new Exception("");
			}
			realDateString = strDate.substring(0, 4) + "-" + strDate.substring(5, 7) + "-" + strDate.substring(8, 10);
		} else if (strDate.indexOf("-") > 0) {
			if (!((strDate.length() == 10) && strDate.matches("[0-9]{4}-[0-1][0-9]-[0-3][0-9]"))) {
				throw new Exception("");
			}
		} else {
			if (!((strDate.length() == 8) && strDate.matches("[0-9]{4}[0-1][0-9][0-3][0-9]"))) {
				throw new Exception("");
			}
			realDateString = strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6, 8);
		}

		try {
			return parseDate(realDateString, "yyyy-MM-dd");
		} catch (ParseException e) {
			throw new Exception("");
		}
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-24 04:29:36> <p>
	 * :	<> <p>
	 *
	 * @param strDate
	 * 			"20110225091000""2011/02/25 15:15:15""2011-02-25 15:15:15"
	 * @return
	 *			
	 *
	 * @throws BOSException
	 * 			
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public static java.util.Date getDateTime(String strDate) throws Exception {
		if(StringUtils.isBlank(strDate)) {
			throw new Exception("");
		}
		String realDateString = strDate;
		if (strDate.indexOf("/") > 0) {
			if (!((strDate.length() == 19) && strDate.matches("[0-9]{4}/[0-1][0-9]/[0-3][0-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]"))) {
				throw new Exception("");
			}
			realDateString = strDate.substring(0, 4) + "-" + strDate.substring(5, 7) + "-" + strDate.substring(8, 10) + " " + strDate.substring(11, 13) +
			":" + strDate.substring(14, 16) + ":" + strDate.substring(17, 19);
		} else if (strDate.indexOf("-") > 0) {
			if (!((strDate.length() == 19) && strDate.matches("[0-9]{4}-[0-1][0-9]-[0-3][0-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]"))) {
				throw new Exception("");
			}
		} else {
			if (!((strDate.length() == 14) && strDate.matches("[0-9]{4}[0-1][0-9][0-3][0-9][0-2][0-9][0-5][0-9][0-5][0-9]"))) {
				throw new Exception("");
			}
			realDateString = strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6, 8) + " " + strDate.substring(8, 10) +
			":" + strDate.substring(10, 12) + ":" + strDate.substring(12, 14);
		}

		try {
			return parseDate(realDateString, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			throw new Exception("");
		}
	}

	/**
	 *
	 * <<code>{@link java.util.Date}</code>>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-8-22 04:43:04> <p>
	 * :	<> <p>
	 *
	 * @param date
	 * 			
	 * @return
	 * 			
	 * @throws Exception
	 *			
	 *
	 * @since JavaBasic 1.0
	 */
	public static java.util.Date getStartDate(java.util.Date date) throws Exception {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		int minDate = calendar.getActualMinimum(java.util.Calendar.DATE);
		calendar.set(java.util.Calendar.DATE, minDate);
		return calendar.getTime();
	}

	/**
	 *
	 * <<code>{@link java.util.Date}</code>>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-8-22 04:43:04> <p>
	 * :	<> <p>
	 *
	 * @param date
	 * 			
	 * @return
	 * 			
	 * @throws Exception
	 *			
	 *
	 * @since JavaBasic 1.0
	 */
	public static java.util.Date getEndDate(java.util.Date date) throws Exception {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		int maxDate = calendar.getMaximum(java.util.Calendar.DATE);
		calendar.set(java.util.Calendar.DATE, maxDate);
		return calendar.getTime();
	}

	public static java.util.Date parseDate(String date, String datePattern) throws Exception {
		if (date == null) {
			throw new Exception("Input date object is null");
		}
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		return sdf.parse(date);
	}


}