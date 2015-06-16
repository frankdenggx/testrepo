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
 * File Name : ChatClubServer.java
 * File Version : 1.0.0.0
 * Description: <>
 *
 * Author : Frank <FrankDengGX@gmail.com>
 * Date : 2012-1-2
 * History :
 * <Name>				<Date>				<Content>
 * Frank				2012-1-2				<Created>
 *
 */
package edu.frank.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	ChatClubServer comment
 * </p>
 * @author Frank <FrankDengGX@gmail.com>
 * <p>
 *	No.1
 *	Modifier: Frank
 *	Modified Time: 2012-1-2 4:21:38
 *  Modified Content: <Created>
 * </p>
 *
 * @Version JavaBasic 1.0.0.0
 * @Since JavaBasic 1.0.0.0
 */
public class ChatClubServer implements Runnable {

	private static final Logger log = Log4JConfig.getLogger(ChatClubServer.class);

	private static int _SERVER_PORT = -1;

	private Socket clientSocket = null;
	/**
	 * construct a new <code>ChatClubServer</code> instance for class
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-2 4:21:38
	 * Modifier Content:
	 * </p>
	 *
	 * @since JavaBasic
	 */
	public ChatClubServer(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		StringBuffer sbErrMsg = new StringBuffer();
		try {
			if (this.clientSocket != null) {
				InputStream in = this.clientSocket.getInputStream();
				OutputStream out = this.clientSocket.getOutputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				PrintWriter pw = new PrintWriter(out);
				String recMsg = null;
				while (!StringUtils.isBlank(recMsg = br.readLine())) {
					log.error(recMsg);
					pw.println("Welcome client[" + this.clientSocket.getInetAddress().getHostAddress() + "] !");
				}
				br.close();
				pw.close();
			}
		} catch (IOException e) {
			sbErrMsg.append("Fail to created server socket.");
			log.error(sbErrMsg.toString(), e);
			return;
		} finally {
			try {
				this.clientSocket.close();
			} catch (IOException e) {
				log.error(sbErrMsg.append("Fail to closed client socket."));
			}
			this.clientSocket = null;
		}
	}

	private static void init() throws Exception {
		_SERVER_PORT = ChatClubConfig.getServerPort();
	}

	/**
	 * <code>main</code> comment
	 *
	 * @author Frank <FrankDengGX@gmal.com>
	 * <p>
	 * No.1
	 * Modifier: Frank
	 * Modifier Time: 2012-1-2 4:21:38
	 * Modifier Content:
	 * </p>
	 *
	 * @param args
	 * @since JavaBasic
	 */
	public static void main(String[] args) {
		try {
			init();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return;
		}
		StringBuffer sbErrMsg = new StringBuffer();
		try {
			ServerSocket serverSocket = new ServerSocket(_SERVER_PORT);
			Socket acceptSocket = null;
			while(true) {
				acceptSocket = serverSocket.accept();
				Thread chatClubServer = new Thread(new ChatClubServer(acceptSocket));
				chatClubServer.start();
			}
		} catch (IOException e) {
			sbErrMsg.append("Fail to created server socket.");
			log.error(sbErrMsg.toString(), e);
			return;
		}

	}

}
