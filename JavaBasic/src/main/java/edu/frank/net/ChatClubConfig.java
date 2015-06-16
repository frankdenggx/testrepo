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
 * Package : edu.frank.net
 * File Name : ChatClubConfig.java
 * File Version : 1.0.0.0
 * Description: <This file is for analysis application configuration.>
 *
 * Author : Frank <FrankDengGX@gmail.com>
 * Date : 2012-1-2
 * History :
 * <Name>				<Date>				<Content>
 * Frank				2012-1-2			 Created
 *
 */
package edu.frank.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	ChatClubConfig comment
 * </p>
 * @author Frank <FrankDengGX@gmail.com>
 * <p>
 *	No.1
 *	Modifier: Frank
 *	Modified Time: 2012-1-2 16:22:52
 *  Modified Content: <Created>
 * </p>
 *
 * @Version JavaBasic 1.0.0.0
 * @Since JavaBasic 1.0.0.0
 */
public class ChatClubConfig {

	/**
	 * Application logging
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private static final Logger log = Log4JConfig.getLogger(ChatClubConfig.class);

	/**
	 * Configuration file name
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private static String _FILE_NAME = "ChatClubConfig.properties";

	/**
	 * Server IP
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private static String _SERVER_IP = "_SERVER_IP";

	/**
	 * Server Port
	 *
	 * @Since JavaBasic 1.0.0.0
	 */
	private static String _SERVER_PORT = "_SERVER_PORT";

	/**
	 *
	 * Return the configuration file's properties.Through this method, you can get
	 * the root properties of the configuration before analysising.
	 *
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-2 16:33:47
	 * Modifier Content: Created
	 * </p>
	 *
	 * @return
	 * 			configuration properties
	 * @throws Exception
	 *			fail to load properties
	 * @since JavaBasic
	 */
	public static Properties getRootProp() throws Exception {
		Properties configuration = new Properties();
		StringBuffer sbErrMsg = new StringBuffer("Fail to load configuration file.");
		try {
			URL url = ChatClubConfig.class.getResource("");
			String rootPath = url.getPath();
			rootPath += _FILE_NAME;
			BufferedReader br = new BufferedReader(new FileReader(rootPath));
			configuration.load(br);
		} catch (Exception e) {
			log.error(sbErrMsg.toString(), e);
			throw new Exception(sbErrMsg.toString(), e);
		}
		return configuration;
	}

	/**
	 *
	 * Return server ip address
	 *
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-2 22:02:09
	 * Modifier Content: Created
	 * </p>
	 *
	 * @return
	 * 			Server IP
	 * @throws Exception
	 * 			Fail to get server ip
	 * @since JavaBasic
	 */
	public static String getServerIP() throws Exception {
		String serverIP = null;
		StringBuffer sbErrMsg = new StringBuffer("Fail to get server ip.");
		try {
			Properties rootProp = getRootProp();
			if (rootProp != null) {
				serverIP = rootProp.getProperty(_SERVER_IP);
			}
		} catch (Exception e) {
			log.error(sbErrMsg.toString(), e);
			throw new Exception(sbErrMsg.toString(), e);
		}
		return serverIP;
	}

	/**
	 *
	 * Return server port.
	 *
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-2 22:09:33
	 * Modifier Content: Created
	 * </p>
	 *
	 * @return
	 * 			Server port
	 * @throws Exception
	 * 			Fail to get server port
	 * @since JavaBasic
	 */
	public static int getServerPort() throws Exception {
		int serverPort = -1;
		StringBuffer sbErrMsg = new StringBuffer("Fail to get server port.");
		try {
			Properties rootProp = getRootProp();
			if (rootProp != null) {
				String serPort = rootProp.getProperty(_SERVER_PORT);
				if (!StringUtils.isBlank(serPort) && serPort.matches("^[1-9][0-9]*$")) {
					serverPort = (new Integer(serPort)).intValue();
				}
			}
		} catch (Exception e) {
			log.error(sbErrMsg.toString(), e);
			throw new Exception(sbErrMsg.toString(), e);
		}
		return serverPort;
	}

}
