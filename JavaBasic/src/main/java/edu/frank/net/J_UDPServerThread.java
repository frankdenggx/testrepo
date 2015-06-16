/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * J_UDPServerThread
 * 1.0
 * UDP
 * 2010-03-04
 * yoyudenghihi
 * 
 * 							
 * 2010.03.04	yoyudenghihi		
 */
package edu.frank.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import edu.frank.LogService;




/**
 * UDP
 * @see java.net.DatagramSocket
 * @see java.net.DatagramPacket
 * @since 1.0 2010/03/05
 * @author yoyudenghihi
 * @version 1.0
 *
 */
public class J_UDPServerThread {

	// 
	private static final String APP_NAME = "J_UDPServerThread"; // 
	private static final String APP_VERSION = "1.0"; // 
	private static final String APP_RELEASE = "2010.03.04"; // 

	private static final int DEFALUT_UDP_PORT = 8800;	//UDP
	private static int m_nPort = DEFALUT_UDP_PORT;	//UDP
	private static final int DEFAULT_TIMEOUT = 50000;	//UDP
	private static int m_nTimeOut = DEFAULT_TIMEOUT;	//UDP
	private static DatagramSocket m_dataSocket = null;	//UDP
	private static String m_strLogMsg = null;	//

	private static DatagramPacket m_recvPacket = null;	//
	private static DatagramPacket m_sendPacket = null;	//
	private static byte[] m_recvBuffer = new byte[1024];	//
	private static byte[] m_sendBuffer = null;	//
	private static String m_strRecvMsg = null;	//
	private static String m_strSendMsg = null;	//
	private static InetAddress m_inetClientAddr = null;	//
	private static int m_nClientPort = -1;		//


	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		m_strLogMsg = APP_NAME + "_" + APP_VERSION +
				"_" + APP_RELEASE + " running ...";
		log(m_strLogMsg);
		System.out.println(m_strLogMsg);
		try{
			m_dataSocket = new DatagramSocket(m_nPort);
			if (null != m_dataSocket) {
				m_dataSocket.setSoTimeout(m_nTimeOut);
			}
			while(true){
				//
				m_recvPacket = new DatagramPacket(m_recvBuffer,0,m_recvBuffer.length);
				m_dataSocket.receive(m_recvPacket);
				m_inetClientAddr = m_recvPacket.getAddress();
				m_nClientPort = m_recvPacket.getPort();
				m_strRecvMsg = new String(m_recvBuffer,0,m_recvPacket.getLength());
				m_strLogMsg = "recv from client(" +
					m_inetClientAddr.getHostAddress() +":" + m_nClientPort + "):" +
					m_strRecvMsg;
				log(m_strLogMsg);
				System.out.println(m_strLogMsg);

				//
				m_strSendMsg = "Hello Client ! Welcome to this !";
				m_sendBuffer = m_strSendMsg.getBytes();
				m_sendPacket = new DatagramPacket(m_sendBuffer,0,m_sendBuffer.length,m_inetClientAddr,m_nClientPort);
				m_dataSocket.send(m_sendPacket);
			}
		}catch(IOException ex_io){
			log(ex_io.getMessage());
			if (null != m_dataSocket){
				m_dataSocket.close();
				m_dataSocket = null;
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