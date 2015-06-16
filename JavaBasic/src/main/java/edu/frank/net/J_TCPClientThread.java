/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * J_TCPClientThread
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
import java.net.Socket;

import edu.frank.LogService;


/**
 * TCP
 * @see java.net.Socket
 * @since 1.0 2010/03/05
 * @author yoyudenghihi
 * @version 1.0
 *
 */
public class J_TCPClientThread implements Runnable{

	private Socket m_socket = null;	//
	private int m_nClientId = 0;	//ID

	private static final String DEFAULT_TCP_HOST = "192.168.1.97";	//TCP
	private static String m_strHost = DEFAULT_TCP_HOST;	//TCP
	private static final int DEFAULT_TCP_PORT = 5000;		//TCP
	private static int m_nPort = DEFAULT_TCP_PORT;	//TCP

	private static BufferedReader m_recvReader = null;		//
	private static PrintWriter m_sendWriter = null;	//[]
	private static String m_strRecvMsg = null;	//
	private static String m_strSendMsg = null; //

	/**
	 *
	 */
	public J_TCPClientThread(int nClientId) {
		this.m_nClientId = nClientId;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogService.m_strLogFileName = "J_TCPClientThread.log";
		Thread client1 = new Thread(new J_TCPClientThread(1));
		client1.start();
		Thread client2 = new Thread(new J_TCPClientThread(2));
		client2.start();
	}

	public void run() {

		try{
			this.m_socket = new Socket(m_strHost,m_nPort);
			m_sendWriter = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(this.m_socket.getOutputStream(),"GBK"))
					);
			m_strSendMsg = "Client[" + this.m_nClientId +"] - Hello World";
			Thread.sleep(2000);
			m_sendWriter.println(m_strSendMsg);
			m_recvReader = new BufferedReader(new InputStreamReader(this.m_socket.getInputStream(),"GBK"));
			log("recv data from " + this.m_socket.getInetAddress().getHostAddress() + ":" + this.m_socket.getPort() + " msg:");
			while(true){
				m_strRecvMsg = m_recvReader.readLine();
				log(m_strRecvMsg);
				int nReadLength = m_strRecvMsg.length();
				if (nReadLength > 0){
					char cEndChar = m_strRecvMsg.charAt(nReadLength - 1);
					if (cEndChar == 'q') {
						break;
					}
				}
			}

		}catch(IOException ex_io){
			log(ex_io.getMessage());
		} catch (InterruptedException e) {
			log(e.getMessage());
		}finally{
			try{
				if (null != m_recvReader){
					m_recvReader.close();
					m_recvReader = null;
				}
				if (null != m_sendWriter){
					m_sendWriter.close();
					m_sendWriter = null;
				}
				if (null != this.m_socket){
					this.m_socket.close();
					this.m_socket = null;
				}
			}catch(IOException ex){
				log(ex.getMessage());
			}

		}

	}

	/**
	 * 
	 *
	 * @param strMsg 
	 */
	public static void log(String strMsg) {
		LogService.log(strMsg);
	}

}