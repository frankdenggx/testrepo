package edu.frank.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.text.DecimalFormat;

/*
 * udp connection, listening on port 5011
 * for returning state of web-client with given ip 
 */
public class ServerDaemon extends Thread {
	private static int MAX_PACKET_LENGTH = 2048;
	private int m_nPort = 5011;
	private boolean m_bRunning = false;
	
	public void end() {
		m_bRunning = false;
	}
	
	public ServerDaemon() {
		m_bRunning = true;
	}
	
	public void run() {
		DatagramSocket server = null;
		DatagramPacket recvPacket = new DatagramPacket(new byte[MAX_PACKET_LENGTH], MAX_PACKET_LENGTH);
		DatagramPacket sendPacket = null;
		byte [] bufStr = new byte[1024];
		while (m_bRunning) {
			SocketServer.log("ServerDaemon started");
			try {
				server = new DatagramSocket(m_nPort);
				server.setSoTimeout(5000);
				SocketServer.log("ServerDaemon listening on port:" + m_nPort);
			} catch (Exception ex) {
				SocketServer.log("open listen port:" + m_nPort + " fail:" + ex + " @ServerDaemon::run");
			}
			
			// recv query data and send back return
			ByteArrayInputStream bais = null;
			ByteArrayOutputStream baos = null;
			DataInputStream dis = null;
			DataOutputStream dos = null;
			String strIP = null;
			String strInfo = null;
			long nBeginTime = new Date().getTime();
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
					if (0x0A != (nFunc = dis.readByte()))	// read func type
						throw new Exception("invalid func type:" + nFunc);
					if ((nLen = dis.readShort()) > 1024)	// read len
						throw new Exception("too large packet:" + nLen);
					dis.readInt();	// read kind
					dis.read(bufStr, 0, 24);	// read ip
					strIP = new String(bufStr).trim();
					dis.skipBytes(nLen - 32);

					SocketServer.log("query server @ServerDaemon::run");
					
					// construct version info
					String[] strTemps = SocketServer.getVersionString().split("\\.");
					String strBigVersion = "0.0";
					if (4 == strTemps.length)
						strBigVersion = strTemps[0] + "." + strTemps[1];
					strInfo = SocketServer.getAppName() + ";Release" + strBigVersion +
						",date:" + SocketServer.getReleaseDate() + ";" +
						parseDuration(new Date().getTime() - nBeginTime);
					
					// generate sending packet
					baos = new ByteArrayOutputStream();
					dos = new DataOutputStream(baos);
					dos.writeByte(0x09);	// write packet tag
					dos.writeByte(0x0A);	// write func type
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
					
					SocketServer.log("send ack to " + recvPacket.getAddress() + ":" + recvPacket.getPort() + " @ServerDaemon::run");
				} catch (SocketTimeoutException ex) {
				} catch (IOException ex) {
					SocketServer.log(ex + " @ServerDaemon::run");
					break;
				} catch (Exception ex) {
					SocketServer.log(ex + " @ServerDaemon::run");
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
						SocketServer.log("close stream fail:" + ex + " @ServerDaemon::run");
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
				SocketServer.log("trying to restart ServerDaemon");
			} else {
				SocketServer.log("ServerDaemon closed");
				break;
			}
		}
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
			SocketServer.log(ex + " @ServerDaemon::ipToInt");
			nIP = 0;
		}
		return nIP;
	}
	
	protected String parseDuration(long nDur) {
		DecimalFormat df = new DecimalFormat("00");
		return "" +(nDur / 86400000) + " day " + df.format((nDur % 86400000) / 3600000) + " hours " +
			df.format((nDur % 3600000) / 60000) + " minutes"; 
	}
	
	public static void main(String[] args) {
		ServerDaemon daemon = new ServerDaemon();
		System.out.println(daemon.parseDuration(1111));
	}
}