/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * J_TCPServerThread
 * 1.0
 * TCP
 * 2010-03-04
 * yoyudenghihi
 * 
 * 							
 * 2010.03.04	yoyudenghihi		
 */
package edu.frank.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import edu.frank.LogService;

/**
 * TCP
 *
 * @see java.net.ServerSocket
 * @since 1.0 2010/03/05
 * @version 1.0
 * @author yoyudenghihi
 *
 */
public class J_TCPServerThread extends Thread {

	// 
	private static final String APP_NAME = "J_TCPServerThread"; // 
	private static final String APP_VERSION = "1.0"; // 
	private static final String APP_RELEASE = "2010.03.04"; // 

	private Socket m_socket; // Socket
	private int m_nSocketId; // Socket ID
	private static final int SOCKET_TIMEOUT = 30000; // Socket
	private static int m_nTimeOut = SOCKET_TIMEOUT; // Socket
	private static final int DEFAULT_TCP_PORT = 5000; // TCP
	private static int m_nPort = DEFAULT_TCP_PORT; // TCP

	private static long m_lStartTime = 0; // 
	private static long m_lCurrTime = 0; // 

	private static String m_strLogMsg = null; // 

	/**
	 * 
	 *
	 * @param socket
	 *            
	 * @param id
	 *            ID
	 */
	public J_TCPServerThread(Socket socket, int id) {

		this.m_socket = socket;
		try {
			this.m_socket.setSoTimeout(m_nTimeOut);
		} catch (SocketException e) {
			log(e.getMessage());
		}
		this.m_nSocketId = id;
	}

	/**
	 * 
	 */
	synchronized public static void AppStart() {
		m_strLogMsg = "program:" + APP_NAME + " version:" + APP_VERSION
				+ " release:" + APP_RELEASE + " running now ,port:" + m_nPort;
		log(m_strLogMsg);
		m_lStartTime = System.currentTimeMillis();

	}

	/**
	 * 
	 */
	@Override
	public void run() {
		try {
			log("Socket[" + this.m_nSocketId + "] connetion success...");
			m_lStartTime = System.currentTimeMillis();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(this.m_socket.getOutputStream(),
							"GBK")), true);
			out.println("Socket[" + this.m_nSocketId + "] welcome client");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					this.m_socket.getInputStream(), "GBK"));
			while (true) {
				String strRev = br.readLine();
				log("Socket[" + this.m_nSocketId + "] receives:" + strRev);
				int n = strRev.length();
				if (n > 0) {
					char c = strRev.charAt(n - 1);
					if (c == 'q') {
						break;
					}
				}
			}
		} catch (IOException ex) {
			m_lCurrTime = System.currentTimeMillis();
			if ((m_lCurrTime - m_lStartTime) >= m_nTimeOut) {
				log("Socket[" + this.m_nSocketId + "] time out !");
			}
			log(m_strLogMsg);
			log(ex.getMessage());
		} finally {
			try {
				log("Socket[" + this.m_nSocketId + "] is closing...");
				this.m_socket.close();
			} catch (IOException ex) {
				log(ex.getMessage());
			}
		}
	}

	/**
	 * 
	 *
	 * @param strMsg
	 *            
	 */
	public static void log(String strMsg) {
		LogService.log(strMsg);
	}

	/**
	 * 
	 *
	 * @param args
	 *            
	 */
	public static void main(String[] args) {
		LogService.m_strLogFileName = "J_TCPServerThread.log";
		int n = 1;
		ServerSocket server = null;
		try {
			server = new ServerSocket(m_nPort);
			log("server start>>>");
		} catch (IOException ex) {
			log(ex.getMessage());
		}
		while (true) {
			try {
				log("Wait No." + n + " connection...");
				Socket socket = server.accept();
				J_TCPServerThread thread = new J_TCPServerThread(socket, n++);
				thread.start();
			} catch (IOException ex) {
				log(ex.getMessage());
			}
		}

	}

}