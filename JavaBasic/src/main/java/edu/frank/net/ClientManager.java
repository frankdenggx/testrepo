package edu.frank.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;

/*
 * udp connection, listening on port 5009
 * for returning state of web-client with given ip 
 */
public class ClientManager extends Thread {
	private static int MAX_PACKET_LENGTH = 2048;
	private Socket m_tcpSock = null;
	private DataOutputStream m_tcpDOS = null;
	private DataInputStream m_tcpDIS = null;
	private int m_nPort = 5009;
	private boolean m_bRunning = false;
	
	public void end() {
		m_bRunning = false;
	}
	
	
	public ClientManager() {
		m_bRunning = true;
	}
	
	public void run() {
		DatagramSocket server = null;
		DatagramPacket recvPacket = new DatagramPacket(new byte[MAX_PACKET_LENGTH], MAX_PACKET_LENGTH);
		DatagramPacket sendPacket = null;
		byte [] bufStr = new byte[1024];
		while (m_bRunning) {
			SocketServer.log("ClientManager started");
			try {
				server = new DatagramSocket(m_nPort);
				server.setSoTimeout(5000);
				SocketServer.log("ClientManager listening on port:" + m_nPort);
			} catch (Exception ex) {
				SocketServer.log("open listen port:" + m_nPort + " fail:" + ex + " @ClientManager::run");
			}
			
			// recv query data and send back return
			ByteArrayInputStream bais = null;
			ByteArrayOutputStream baos = null;
			DataInputStream dis = null;
			DataOutputStream dos = null;
			String strIP = null;
			String strInfo = null;
			while (m_bRunning) {
				try {
					Thread.sleep(100L);
				} catch (Exception ex) {
				}
				try {
					int nTag = -1;
					int nFunc = -1;
					int nLen = 0;
					// read packet
					server.receive(recvPacket);
					bais = new ByteArrayInputStream(recvPacket.getData());
					dis = new DataInputStream(bais);
					if (0x08 != (nTag = dis.readByte()))	// read packet tag
						throw new Exception("invalid tag:" + nTag);
					if (0x08 != (nFunc = dis.readByte()))	// read func type
						throw new Exception("invalid func type:" + nFunc);
					if ((nLen = dis.readShort()) > 1024)	// read len
						throw new Exception("too large packet:" + nLen);
					dis.readInt();	// read kind
					dis.read(bufStr, 0, 24);	// read ip
					strIP = new String(bufStr).trim();
					dis.skipBytes(nLen - 32);
					
					SocketServer.log("query client state of " + strIP + " @ClientManger::run");
					
					// retrieve client info
					strInfo = getClientInfo(strIP);
					
					SocketServer.log(strInfo + " @ClientManger::run");
					
					// generate sending packet
					strIP = InetAddress.getLocalHost().getHostAddress();
					baos = new ByteArrayOutputStream();
					dos = new DataOutputStream(baos);
					dos.writeByte(0x09);	// write packet tag
					dos.writeByte(0x08);	// write func type
					dos.writeShort(1024);	// write packet len
					dos.writeInt(null == strInfo ? -1 : 1);
					dos.writeBytes(strIP);	// write ip
					for (int i = strIP.length(); i < 24; i++)
						dos.writeByte(0);	// fill ip field with zero
					if (null == strInfo) {
						for (int i = 0; i < 992; i++)
							dos.writeByte(0);
					} else {
						dos.writeBytes(strInfo);
						for (int i = strInfo.length(); i < 992; i++)
							dos.writeByte(0);
					}
					dos.flush();
					sendPacket = new DatagramPacket(baos.toByteArray(), baos.toByteArray().length,
							recvPacket.getAddress(), recvPacket.getPort());
					server.send(sendPacket);
					
					SocketServer.log("send ack to " + recvPacket.getAddress() + ":" + recvPacket.getPort() + " @ClientManger::run");
				} catch (SocketTimeoutException ex) {
				} catch (IOException ex) {
					SocketServer.log(ex + " @ClientManager::run");
					break;
				} catch (Exception ex) {
					SocketServer.log(ex + " @ClientManager::run");
				} finally {
					try {
						if (null != dos) {
							dos.close();
							dos = null;
						}
						if (null != baos) {
							baos.close();
							baos = null;
						}
						if (null != dis) {
							dis.close();
							dis = null;
						}
						if (null != bais) {
							bais.close();
							bais = null;
						}
					} catch (Exception ex) {
						SocketServer.log("close stream fail:" + ex + " @ClientManager::run");
					}
				}
			}
			
			if (null != server) {
				server.disconnect();
				server.close();
				server = null;
			}
			if (m_bRunning) {
				try {
					Thread.sleep(10000L);
				} catch (Exception ex) {
				}
				SocketServer.log("trying to restart ClientManager");
			} else {
				SocketServer.log("ClientManager closed");
				break;
			}
		}
	}
	
	protected String getClientInfo(String strIP) {
		String strInfo = null;
		try {
			if (null == m_tcpSock)
				m_tcpSock = new Socket(InetAddress.getLocalHost(), 8666);
			if (null == m_tcpDOS)
				m_tcpDOS = new DataOutputStream(m_tcpSock.getOutputStream());
			if (null == m_tcpDIS)
				m_tcpDIS = new DataInputStream(m_tcpSock.getInputStream());
			
			// send request
			m_tcpDOS.writeByte(0x7E);	// tag
			m_tcpDOS.writeByte(0);		// ret
			m_tcpDOS.writeShort(4);		// data len
			m_tcpDOS.writeInt(0);		// kind
			m_tcpDOS.writeInt(ipToInt(strIP));
			m_tcpDOS.flush();
			
			// read return
			int nRet = -1;
			int nVer = -1;
			int nDur = -1;
			m_tcpDIS.readByte();	// tag
			nRet = m_tcpDIS.readByte();	// ret
			m_tcpDIS.readShort();	// data len
			m_tcpDIS.readInt();	// kind
			nVer = m_tcpDIS.readInt();	// version number
			nDur = m_tcpDIS.readInt();	// running duration
			
			if (0 == nRet && -1 != nVer && -1 != nDur)
				strInfo = "web-client(" + strIP + ");" + "Release" + parseBigVersion(nVer) + ";" + parseDuration(nDur);
			else
				strInfo = "STOP";
		} catch (Exception ex1) {
			SocketServer.log("retrieve client info fail:" + ex1 + " @ClientManager::getClientInfo");
			strInfo = "STOP";
			try {
				if (null != m_tcpDIS) {
					m_tcpDIS.close();
					m_tcpDIS = null;
				}
				if (null != m_tcpDOS) {
					m_tcpDOS.close();
					m_tcpDOS = null;
				}
				if (null != m_tcpSock) {
					m_tcpSock.close();
					m_tcpSock = null;
				}
			} catch (Exception ex2) {
				SocketServer.log("close connection fail:" + ex2 + " @ClientManager::getClientInfo");
			}
		}
		return strInfo;
	}
	
	protected int ipToInt(String strIP) {
		if (null == strIP)
			throw new IllegalArgumentException("null ip");
		
		String [] strIPBytes = null;
		int nIP = 0;
		try {
			strIPBytes = strIP.split("\\.");
			nIP = (Integer.parseInt(strIPBytes[0]) << 24) + (Integer.parseInt(strIPBytes[1]) << 16) +
				(Integer.parseInt(strIPBytes[2]) << 8) + Integer.parseInt(strIPBytes[3]);
		} catch (Exception ex) {
			SocketServer.log(ex + " @ClientManager::ipToInt");
			nIP = 0;
		}
		return nIP;
	}
	
	protected String parseBigVersion(int nVer) {
		return ((nVer & 0xFF000000) >> 24) + "." + ((nVer & 0xFF0000) >> 16);
	}
	
	protected String parseVersion(int nVer) {
		return ((nVer & 0xFF000000) >> 24) + "." + ((nVer & 0xFF0000) >> 16) + "." + ((nVer & 0xFF00) >> 8) + "." + (nVer & 0xFF);
	}
	
	protected String parseDuration(long nDur) {
		DecimalFormat df = new DecimalFormat("00");
		return "" + (nDur / 86400000) + " day " + df.format((nDur % 86400000) / 3600000) + " hours " +
			df.format((nDur % 3600000) / 60000) + " minutes"; 
	}
}