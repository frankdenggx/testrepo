/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * J_UDPClientThread
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


/**
 * UDP
 * @see java.net.DatagramSocket
 * @see java.net.DatagramPacket
 * @since 1.0 2010/03/05
 * @author yoyudenghihi
 * @version 1.0
 *
 */
public class J_UDPClientThread {

	private static final int DEFALUT_UDP_PORT = 8800;	//UDP
	private static int m_nPort = DEFALUT_UDP_PORT;	//UDP
	private static final int DEFAULT_TIMEOUT = 50000;	//UDP
	private static int m_nTimeOut = DEFAULT_TIMEOUT;	//UDP
	private static DatagramSocket m_dataSocket = null;	//UDP
	private static InetAddress m_inetClientAddr = null;	//
	private static String m_strLogMsg = null;	//

	private static DatagramPacket m_recvPacket = null;	//
	private static DatagramPacket m_sendPacket = null;	//
	private static byte[] m_recvBuffer = new byte[1024];	//
	private static byte[] m_sendBuffer = null;	//
	private static String m_strRecvMsg = null;	//
	private static String m_strSendMsg = "";	//

	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		m_strLogMsg = "usage: J_UDPClientThread [IP] [ClientId]\n" +
								"as: J_UDPClientThread 10.123.15.143 A";
		if (null != args && args.length >= 2){
			String strClientIP = args[0];
			String strClientID = args[1];
			try{

				//
				m_dataSocket = new DatagramSocket();
				m_dataSocket.setSoTimeout(m_nTimeOut);
				m_inetClientAddr = InetAddress.getByName(strClientIP);
				while(true){
					char cInput;
					do{
						cInput = (char) (System.in.read());
						if (cInput != '\n' && cInput != '\r') {
							m_strSendMsg += cInput;
						}
					}while(cInput != '\n');
					m_strSendMsg = "client[" + strClientID + "]:" + m_strSendMsg;
					System.out.println(m_strSendMsg);
					m_sendBuffer = m_strSendMsg.getBytes();
					m_sendPacket = new DatagramPacket(m_sendBuffer,0,m_sendBuffer.length,m_inetClientAddr,m_nPort);
					m_dataSocket.send(m_sendPacket);

					//
					m_recvPacket = new DatagramPacket(m_recvBuffer,0,m_recvBuffer.length);
					m_dataSocket.receive(m_recvPacket);
					m_strRecvMsg = new String(m_recvBuffer,0,m_recvPacket.getLength());
					System.out.println(m_strRecvMsg);
				}
			}catch(IOException ex_io){
				ex_io.printStackTrace();
			}
		} else {
			System.out.println(m_strLogMsg);
		}

	}

}