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
 * File Name : ChatClubClient.java
 * File Version : 1.0.0.0
 * Description: <>
 *
 * Author : Frank <FrankDengGX@gmail.com>
 * Date : 2012-1-3
 * History :
 * <Name>				<Date>				<Content>
 * Frank				2012-1-3				<Created>
 *
 */
package edu.frank.net;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.KeyStroke;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	ChatClubClient comment
 * </p>
 * @author Frank <FrankDengGX@gmail.com>
 * <p>
 *	No.1
 *	Modifier: Frank
 *	Modified Time: 2012-1-3 1:38:59
 *  Modified Content: <Created>
 * </p>
 *
 * @Version JavaBasic 1.0.0.0
 * @Since JavaBasic 1.0.0.0
 */
public class ChatClubClient implements Runnable{

	private static final Logger log = Log4JConfig.getLogger(ChatClubClient.class);

	private int clientID = -1;

	/**
	 * construct a new <code>ChatClubClient</code> instance for class
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-3 1:38:59
	 * Modifier Content:
	 * </p>
	 *
	 * @since JavaBasic
	 */
	public ChatClubClient(int clientID) {
		this.clientID = clientID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		StringBuffer sbErrMsg = new StringBuffer("Fail to connect server.");
		try {
			Socket socket = new Socket(InetAddress.getByName(ChatClubConfig.getServerIP()), ChatClubConfig.getServerPort());
			if (socket != null) {
				log.error("client["+ this.clientID + "] try to connect!");
				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				KeyStroke ctrlD = KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK);
				String readMsg = null;
				while (!StringUtils.isBlank(readMsg = br.readLine())) {
					if (((int)readMsg.charAt(0)) == ctrlD.getKeyCode()) {
						break;
					}
					pw.println("Hello, I am client[" + this.clientID + "]:" + readMsg);
				}
				in.close();
				pw.close();
				socket.close();
			}
		} catch (Exception e) {
			log.error(sbErrMsg.toString(), e);
		}

	}

	/**
	 * <code>main</code> comment
	 *
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-3 1:38:59
	 * Modifier Content:
	 * </p>
	 *
	 * @param args
	 * @since JavaBasic
	 */
	public static void main(String[] args) {
		Thread clientA = new Thread(new ChatClubClient(1));
		Thread clientB = new Thread(new ChatClubClient(2));
		clientA.start();
		clientB.start();
	}



}
