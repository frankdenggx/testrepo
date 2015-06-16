/**
 * 	: Thinker
 * 	: FastView
 * JDK	: jdk1.5.0
 * 	: 1.3
 * 	: 2008.6.4
 * 				
 * 2007.11.11	chenjh		
 * 2008.6.4		chenjh		
 * 								
 * 2008.8.7		chenjh		01
 */
package edu.frank.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.ArrayList;

public class CommunicateThread extends Thread {
	// ?web?
	private static List<CommunicateThread> m_broadcastList = new ArrayList<CommunicateThread>();
	// web
	private static int m_nAvailableConn = 20; // web
	private int m_nClientVersion = -1; // 
	private boolean m_bRunning = false;
	private Socket m_sock = null;
	private String m_strPeerIP = null;
	private long m_nEstablishedTime = -1; // 
	private DataInputStream m_inputStream = null; // 
	private DataOutputStream m_outputStream = null; // 
	private boolean m_bKeepAlive = false; // keep alivewebtrue
	private boolean m_bAliveReceived = false; // keep alive
	private boolean m_bStateReceived = false; // 
	private Packet m_pktLatestState = new Packet(0x7F, 0, 28, 0x7B7B);
	private Packet m_pktAliveEcho = new Packet(0x7F, 0, 0, 0x7A7A);
	
	/**
	 * 
	 */
	public static void endAll() {
		CommunicateThread thread = null;
		for (int i = 0; i < m_broadcastList.size(); i++) {
			thread = m_broadcastList.get(i);
			thread.m_bRunning = false;
		}
	}
	
	/**
	 * web
	 * @param nMax 
	 */
	public static void setMaxConnection(int nMax) {
		if (nMax > 0 && nMax < 1024)
			m_nAvailableConn = nMax;
	}

	/**
	 * web
	 * @return 
	 */
	public static int getMaxConnection() {
		return m_nAvailableConn;
	}
	
	public CommunicateThread(Socket sock) {
		if (null == sock)
			throw new IllegalArgumentException("null sock");
		m_sock = sock;
		m_bRunning = true;
	}

	public void run() {
		SocketServer.log("connected from " + m_sock.getInetAddress().toString() + ":" + m_sock.getPort());
		m_nEstablishedTime = System.currentTimeMillis();
		
		// 
		try {
			m_strPeerIP = m_sock.getInetAddress().getHostAddress();
			m_sock.setSoTimeout(2000);
			m_inputStream = new DataInputStream(m_sock.getInputStream());
			m_outputStream = new DataOutputStream(m_sock.getOutputStream());
		} catch (Exception ex) {
			try {
				m_sock.close();
			} catch (Exception ex2) {
				SocketServer.log(ex2 + " from " + this.toString() + " @CommunicateThread::CommunicateThread");
			}
			SocketServer.log("sock fail:" + ex + " from " + this.toString() + " @CommunicateThread::run");
			return;
		}
		
		// 
		final int KEEP_ALIVE_LIFE_TIME = 600000; // 
												//m_bKeepAlive=true
		long nLastAliveTime = System.currentTimeMillis(); // alive
		Packet packet = new Packet();
		while (m_bRunning) {
			try {
				// 
				int nRecv = 0; // 
				while (nRecv++ < 10 && packet.recvFrom(m_inputStream)) { // 10
					processPacket(packet);
					packet.reset();
				}
			} catch (SocketTimeoutException ex) {
			} catch (IOException ex) {
				SocketServer.log("recv fail:" + ex + " from " + this.toString() + " @CommunicateThread::run");
				m_bRunning = false;
			} catch (Exception ex) {
				SocketServer.log("data fail:" + ex + " from " + this.toString() + " @CommunicateThread::run");
			}
			if (m_bStateReceived) { // 
				broadcast(m_pktLatestState);
				m_pktLatestState.m_nContents[0] = 0;
				m_pktLatestState.m_nContents[1] = 0;
				m_pktLatestState.m_nContents[2] = 0;
				m_pktLatestState.m_nContents[3] = 0;
				m_pktLatestState.m_nContents[4] = 0;
				m_bStateReceived = false;
			}
			
			if (m_bRunning && m_bKeepAlive) { // 
				if (m_bAliveReceived) {
					try {
						send(m_pktAliveEcho);
						nLastAliveTime = System.currentTimeMillis();
					} catch (Exception ex) {
						SocketServer.log("send echo fail:" + ex + " from " + this.toString() + " @CommunicateThread::run");
					}
					m_bAliveReceived = false;
				} else {
					// keep alive(web )(10)keep alive)
					if (System.currentTimeMillis() - nLastAliveTime > KEEP_ALIVE_LIFE_TIME) {
						SocketServer.log("dead connection:" + this.toString() + " @CommunicateThread::run");
						m_bRunning = false;
					}
				}
			}

			try {
				Thread.sleep(100L);
			} catch (InterruptedException ex) {
			}
		}
		
		m_broadcastList.remove(this);
		m_nAvailableConn++;
		try {
			if (null != m_inputStream) {
				m_inputStream.close();
				m_inputStream = null;
			}
		} catch (Exception ex) {
			SocketServer.log(ex + " from " + this.toString() + " @CommunicateThread::run");
		}
		try {
			if (null != m_outputStream) {
				m_outputStream.close();
				m_outputStream = null;
			}
		} catch (Exception ex) {
			SocketServer.log(ex + " from " + this.toString() + " @CommunicateThread::run");
		}
		try {
			if (null != m_sock && !m_sock.isClosed()) {
				m_sock.close();
				m_sock = null;
			}
		} catch (Exception ex) {
			SocketServer.log(ex + " from " + this.toString() + " @CommunicateThread::run");
		}
		SocketServer.log("disconnected from " + this.toString());
	}
	
	public String toString() {
		return m_strPeerIP + ":" + m_sock.getPort();
	}
	
	/**
	 * respresp.m_nTag==-1
	 * @param packet 
	 * @throws Exception
	 */
	protected void processPacket(Packet packet)
	throws Exception {
		if (null == packet)
			throw new IllegalArgumentException("invalid param");
		
		if (0x7F == packet.m_nTag) { // web
			switch (packet.m_nKind) {
			case 0x7A7A: // keep alive
				SocketServer.log("alive from " + this.toString());
				m_bAliveReceived = true;
				break;
			case 0x7E7E: // 
				m_bRunning = false;
				break;
			case 0x7F7F: // 
				if (m_nAvailableConn > 0) {
					m_nAvailableConn--;
					if (0 != packet.m_nContents[1] && 0x7F000001 != packet.m_nContents[1])
						m_strPeerIP = intToIP(packet.m_nContents[1]);
					m_nClientVersion = packet.m_nContents[0];
					SocketServer.log("ver:" + parseVersion(m_nClientVersion) + "@" + this.toString() +  " from " + 
							m_sock.getInetAddress().toString() + ":" + m_sock.getPort() + " registered");
					
					m_broadcastList.add(this);
					m_bKeepAlive = true;
				} else { // 
					Packet pkt = new Packet();
					pkt.m_nTag = 0x7F;
					pkt.m_nRet = 0;
					pkt.m_nLen = 0;
					pkt.m_nKind = 0x7979;
					send(pkt);
				}
				break;
			default:
				SocketServer.log("invalid kind:" + packet.m_nKind + " @CommunicateThread::processPacket");
			}
		} else if (0x14 == packet.m_nTag || 0x03 == packet.m_nTag) { // 
			// 0x14 
			// 0x03 
			for (int i = 0; i < 5; i++)
				if (0 != packet.m_nContents[i])
					m_pktLatestState.m_nContents[i] = packet.m_nContents[i];
			m_pktLatestState.m_nContents[5] = packet.m_nContents[5]; // for test and tracing. sequence
			m_pktLatestState.m_nContents[6] = packet.m_nContents[6]; // for test and tracing. timestamp
			m_bStateReceived = true;
		} else if (0x7E == packet.m_nTag) { // 
			int nDur = -1;
			int nVer = -1;
			CommunicateThread client = null;
			packet.m_nRet = -1;
			packet.m_nLen = 8;
			for (int i = 0; i < m_broadcastList.size(); i++) {
				client = m_broadcastList.get(i);
				if (null != client && intToIP(packet.m_nContents[0]).equals(client.m_strPeerIP)) {
					nDur = (int)(System.currentTimeMillis() - client.m_nEstablishedTime);
					nVer = client.m_nClientVersion;
					packet.m_nRet = 0;
				}
			}
			packet.m_nContents[0] = nVer;
			packet.m_nContents[1] = nDur;
			send(packet);
		} else if (0x7D == packet.m_nTag) { // 
			switch (packet.m_nKind) {
			case 0x7979: // 
				broadcast(packet);
				break;
			case 0x7C7C: // 
				broadcast(packet);
				break;
			case 0x7D7D: // 
				broadcast(packet);
				break;
			default:
				SocketServer.log("invalid kind:" + packet.m_nKind + " @CommunicateThread::processPacket");
			}
		} else {
			SocketServer.log("invalid tag:" + packet.m_nKind + " @CommunicateThread::processPacket");
		}
	}
	
	synchronized protected void send(Packet packet)
	throws Exception {
		if (m_sock.isClosed() || !m_sock.isConnected())
			throw new Exception("sock closed");
		if (null == packet)
			throw new Exception("null packet");
		if (null == m_outputStream)
			throw new Exception("null sender");
		if (!m_bRunning) {
			throw new Exception("client not running");
		}
		
		if (0 != packet.m_nTag) // must be init
			packet.writeTo(m_outputStream);
	}
	
	synchronized private static void broadcast(Packet packet) {
		CommunicateThread client = null;
		for (int i = 0; i < m_broadcastList.size(); i++) {
			try {
				if (null != (client = m_broadcastList.get(i)))
					client.send(packet);
			} catch (Exception ex) {
				ex.printStackTrace();
				SocketServer.log("fail to send msg to client:" + client + " @CommunicateThread::broadcast");
			}
		}
	}
	
	private static String parseVersion(int nVer) {
		return ((nVer & 0xFF000000) >> 24) + "." + ((nVer & 0xFF0000) >> 16) + "." + ((nVer & 0xFF00) >> 8) + "." + (nVer & 0xFF);
	}
	
	private static String intToIP(int nIP) {
		return String.valueOf((nIP >>24) & 0xFF) + "." + String.valueOf((nIP >> 16) & 0xFF) + "." +
			String.valueOf((nIP >> 8) & 0xFF) + "." + String.valueOf((nIP & 0xFF));
	}
	
}
