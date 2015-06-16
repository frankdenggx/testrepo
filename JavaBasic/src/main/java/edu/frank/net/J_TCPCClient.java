/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * J_TCPCClient
 * 1.0
 * CClient
 * 2010-03-04
 * yoyudenghihi
 * 
 * 							
 * 2010.03.04	yoyudenghihi		
 */
package edu.frank.net;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * 
 * @since 1.0 2010/03/11
 * @author yoyudenghihi
 * @version 1.0
 */
class Packet {
	private final static int MAX_PACKET_LEN = 256; // 󳤶
	private final static int HEADER_LEN = 8; // 
	private final static int MAX_DATA_LEN = MAX_PACKET_LEN - HEADER_LEN; // 
	public int m_nTag = 0; // 
	public int m_nRet = 0; // 
	public int m_nLen = 0; // 
	public int m_nKind = 0; // 
	public int[] m_nContents = new int[MAX_DATA_LEN /4]; // 
	private int m_nRecved = 0; // 
	private int m_nExpected = HEADER_LEN; // 
	private byte[] m_byBuffer = new byte[MAX_PACKET_LEN]; //
	
	/**
	 * 
	 */
	public Packet() {
	}
	
	/**
	 * 
	 * @param nRet 
	 * @param nLen 
	 * @param nKind 
	 */
	public Packet(int nTag, int nRet, int nLen, int nKind) {
		m_nTag = nTag;
		m_nRet = nRet;
		m_nLen = nLen > MAX_DATA_LEN ? MAX_DATA_LEN : (nLen < 0 ? 0 : nLen);
		m_nKind = nKind;
	}
	
	/**
	 * 
	 * @param packet 
	 */
	public void clone(Packet packet) {
		m_nTag = packet.m_nTag;
		m_nRet = packet.m_nRet;
		m_nLen = packet.m_nLen > MAX_DATA_LEN ? MAX_DATA_LEN : packet.m_nLen;
		m_nKind = packet.m_nKind;
		for (int i = 0; i < m_nLen / 4; i++)
			m_nContents[i] = packet.m_nContents[i];
	}
	
	/**
	 * packet
	 */
	public void reset() {
		m_nTag = 0;
		m_nRet = 0;
		m_nLen = 0;
		m_nKind = 0;
		m_nRecved = 0;
		m_nExpected = HEADER_LEN;
		
	}

	/**
	 * 
	 * @param input 
	 * @return true
	 * @throws IOException 
	 * @throws Exception 
	 */
	public boolean recvFrom(DataInputStream input)
	throws IOException,Exception {
		if (null == input)
			throw new Exception("null input stream");
		
		if (m_nRecved <= 0) { // 
			m_nTag = input.readByte();
			/*
			 * 0x7F 
			 * 0x7D 
			 */
			if (0x7F == m_nTag || 0x7D == m_nTag || 0x15 == m_nTag ||
					0x16 == m_nTag) {
				m_nRecved = 1;
				m_nExpected = HEADER_LEN - 1;
			} else {
				m_nRecved = 0;
				m_nExpected = HEADER_LEN;
				throw new Exception("invalid tag:" + m_nTag);
			}
		}
		
		int nRecved = input.read(m_byBuffer, m_nRecved, m_nExpected);
		if (nRecved > 0) {
			m_nRecved += nRecved;
			m_nExpected -= nRecved;
			if (m_nExpected <= 0) { // 
				if (HEADER_LEN == m_nRecved) { // 
					m_nRet = new Byte(m_byBuffer[1]).intValue();
					m_nLen = makeShort(m_byBuffer[2], m_byBuffer[3]);
					m_nKind = makeInt(m_byBuffer[4], m_byBuffer[5], m_byBuffer[6], m_byBuffer[7]);
					if (m_nLen > MAX_DATA_LEN || m_nLen < 0) { // 
						throw new Exception("invalid len:" + m_nLen);
					} else { // 
						if (m_nLen > 0) { // 0
							m_nExpected = m_nLen;
							return recvFrom(input); // 
						} else {
							return true;
						}
					}
				} else if (HEADER_LEN + m_nLen == m_nRecved){ // 
					int nCur = HEADER_LEN;
					// 
					for (int i = 0; i < m_nLen / 4; i++) {
						m_nContents[i] = makeInt(m_byBuffer[nCur], m_byBuffer[nCur + 1], m_byBuffer[nCur + 2], m_byBuffer[nCur + 3]);
						nCur += 4;
					}
					return true;
				} else {
					throw new Exception("recv more than expect");
				}
			} else {
				return false; // 
			}
		} else
			return false;
	}
	
	/**
	 * 
	 * @param output 
	 * @return true
	 * @throws IOException 
	 * @throws Exception 
	 */
	public boolean writeTo(DataOutputStream output)
	throws IOException,Exception {
		if (m_nTag < 0 || m_nLen < 0 || m_nLen > MAX_DATA_LEN)
			throw new Exception("packet not init");
		if (null == output)
			throw new Exception("null output stream");
		output.writeByte(m_nTag);
		output.writeByte(m_nRet);
		output.writeShort(m_nLen);
		output.writeInt(m_nKind);
		for (int i = 0; i < m_nLen / 4; i++)
			output.writeInt(m_nContents[i]);
		output.flush();
		return true;
	}
	
	/**
	 * 
	 * @return 
	 */
	public String toString() {
		String strPacket = "tag:" + m_nTag + " ret:" + m_nRet + " len:" + m_nLen + " kind:" + m_nKind + "";
		if (m_nLen > 0)
			strPacket += "\ncontent:";
		for (int i = 0; i < m_nLen /4; i++)
			strPacket += m_nContents[i] + " ";
		return strPacket;
	}
	
	private int makeInt(byte b1, byte b2, byte b3, byte b4) {
		int ret = 0;
		ret = ((new Byte(b1).intValue() & 0xFF) << 24) + ((new Byte(b2).intValue() & 0xFF) << 16) +
			((new Byte(b3).intValue() & 0xFF) << 8) + (new Byte(b4).intValue() & 0xFF);
		return ret;
	}
	
	private short makeShort(byte b1, byte b2) {
		return new Integer(((new Byte(b1).shortValue()) << 8) + new Byte(b2).shortValue()).shortValue();
	}
}

/**
 * CClient
 * @since 1.0 2010/03/10
 * @author yoyudenghihi
 * @version 1.0
 *
 */
public class J_TCPCClient implements Runnable{
	
	private static final String DEF_JSER_HOST = "10.123.15.143";
	private static final int DEF_JSER_PORT = 8445;
	private static final int DEF_TIMEOUT = 2000;
	private static final int DEF_EACH_KEEPALIVE = 30000;
	private static final int DEF_RETRIES = 5;
	
	private int m_nRetries = DEF_RETRIES;
	private int m_nKeepAlieve = DEF_EACH_KEEPALIVE;
	private int m_nTimeOut = DEF_TIMEOUT;
	private String m_strHost = DEF_JSER_HOST;
	private int m_nPort = DEF_JSER_PORT;
	private Socket m_clientSocket = null;
	
	private DataOutputStream m_dosSend = null;
	private DataInputStream m_disRecv = null;
	private BufferedOutputStream m_bfos = null;
	
	private boolean m_bIsRunning = true;
	private boolean m_bConnected = false;
	private final Packet m_pktAlive = new Packet(0x15, 0, 0, 0x1A1A);
	private final Packet m_pktUpdate = new Packet(0x15,0,0,0x1B1B);
	
	public void run() {
		System.out.println("J_TCPCClient Start...");
		int nRetries = 0;
		while(m_bIsRunning){
			m_bConnected = false;
			try{
				m_bConnected = tcpConnected(m_strHost,m_nPort);
			}catch(IOException ex_io){
				System.out.println("tcp connect fail:" + ex_io + "@run");
			}
			
			int nEchoExpect = 0;	//
											//5
			long nNextAliveTime = System.currentTimeMillis() + m_nKeepAlieve;
			Packet packet = new Packet();
			while(m_bIsRunning && m_bConnected){	//
				
				//
				try{
					int nRecv = 0;	//
					while(nRecv++ < 10 && packet.recvFrom(m_disRecv)){	//10
						processPacket(packet);
						packet.reset();
						nEchoExpect = 0;	//
					}
				}catch(SocketTimeoutException ex){
					
				}catch(IOException ex_io){
					System.out.println("connection dead(recv):" + ex_io + "@run");
					m_bConnected =false;
				} catch (Exception e) {
					System.out.println("read data fail:" + e + "@run");
				}
				
				//KeepAlive
				if (m_bConnected && System.currentTimeMillis() > nNextAliveTime){
					if (nEchoExpect >= 5){	//5
						System.out.println("error occur,reset the connection");
						m_bConnected = false;
					}else{
						try{
							//KeepAlive
							m_pktAlive.writeTo(m_dosSend);
							nEchoExpect++;
							nNextAliveTime += m_nKeepAlieve;
							m_pktUpdate.writeTo(m_dosSend);
						}catch(IOException ex_io){
							System.out.println("connection dead(send):" + ex_io + "@run");
							ex_io.printStackTrace();
							m_bConnected =false;
						}catch(Exception ex){
							System.out.println("read data fail:" + ex + "@run");
						}
					}
				}
				
				try{
					Thread.sleep(100L);
				}catch(InterruptedException ex){
					
				}
			}
			
			m_bConnected =false;
			try{
				tcpDisConnected();
			}catch(IOException ex_io){
				System.out.println("tcp disconnect fail:" + ex_io + "@run");
			}finally{
				try{
					Thread.sleep(10000L);
					System.out.println("try to re-connect to JServer");
				}catch(InterruptedException ex){
					
				}
			}
			
			if (nRetries++ >= m_nRetries){	//5
				System.out.println("too many errors occur! more then " + m_nRetries);
				nRetries = 0;
			}
		}
		
	}
	
	protected void processPacket(Packet packet){
		if (0x15 == packet.m_nTag){
			switch(packet.m_nKind){
				case 0x1A1A:	//
					System.out.println("recv keepalive from JServer !");
					break;
				default:
					System.out.println("invalid kind:" + packet.m_nKind);
					break;
			}
		}else if (0x16 == packet.m_nTag){
			switch(packet.m_nKind){
				case 0x1D1D:	//
					System.out.println("System config change !");
					break;
				case 0x1E1E:		//
					System.out.println("Remote center change !");
					break;
				default:
					System.out.println("invalid kind:" + packet.m_nKind);
					break;
			}
		}else{
			System.out.println("invalid tag :" + packet.m_nTag);
		}
	}
	
	protected boolean tcpConnected(String strHost,int nPort) throws IOException{
		System.out.println("try to connect to " + strHost + ":" + nPort);
		if (nPort < 0){
			throw new IOException("invalid port :" + nPort);
		}
		m_clientSocket = new Socket(strHost,nPort);
		if (null == m_clientSocket){
			throw new IOException("create socket fail !");
		}
		m_clientSocket.setSoTimeout(m_nTimeOut);
		m_disRecv = new DataInputStream(m_clientSocket.getInputStream());
		m_dosSend = new DataOutputStream(m_clientSocket.getOutputStream());
		//JServerKeepAlive
		m_dosSend.writeByte(0x15);
		m_dosSend.writeByte(0x0);
		m_dosSend.writeShort(0x0);
		m_dosSend.writeInt(0x1F1F);
		m_dosSend.flush();
		System.out.println("Connect on port:" + m_clientSocket.getLocalPort());
		return true;
		
	}
	
	protected boolean tcpConnected(InetAddress netAddr,int nPort) throws IOException{
		return tcpConnected(netAddr.toString(),nPort);
	}
	
	protected void tcpDisConnected() throws IOException{
		if (null != m_clientSocket && !m_clientSocket.isClosed()){
			if (null != m_dosSend){
				m_dosSend.writeByte(0x15);
				m_dosSend.writeByte(0x0);
				m_dosSend.writeShort(0x0);
				m_dosSend.writeInt(0x7A7A);
				m_dosSend.flush();
				m_dosSend.close();
				m_dosSend = null;
			}
			if (null != m_bfos){
				m_bfos.close();
				m_bfos = null;
			}
			if (null != m_disRecv){
				m_disRecv.close();
				m_disRecv = null;
			}
			m_clientSocket.close();
			m_clientSocket = null;
		}
	}
	
	public void destroy(){
		try{
			m_bIsRunning = false;
			tcpDisConnected();
			System.out.println("J_TCPCClient exit !");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		J_TCPCClient clsInstanceClass = new J_TCPCClient();
		try{
			new Thread(clsInstanceClass).start();
		}catch(Exception ex){
			clsInstanceClass.destroy();
		}
		
	}
	
	

}
