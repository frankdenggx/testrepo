package edu.frank.net;

import java.io.*;
import java.net.*;
import java.util.Date;

public class ClientTest {
	
	protected class Packet {
		public final int MAX_DATA_LEN = 256; 
		public int m_nTag = 0;
		public int m_nRet = 0;
		public int m_nLen = 0;
		public int m_nKind = 0;
		public int[] m_nContents = new int[MAX_DATA_LEN /4];
		
		public Packet(int nTag, int nRet, int nLen, int nKind, String strContents) {
			m_nTag = nTag;
			m_nRet = nRet;
			m_nLen = nLen > MAX_DATA_LEN ? MAX_DATA_LEN : nLen;
			m_nKind = nKind;
		}
		
		public Packet() { // default to form a state-changed-packet
			m_nTag = 0x03;
			m_nRet = 0;
			m_nLen = 20;
			m_nKind = 0x0;
			m_nContents[0] = (int)Math.round(Math.random());
			m_nContents[1] = (int)Math.round(Math.random());
			m_nContents[2] = 1;//(int)Math.round(Math.random());
			m_nContents[3] = (int)Math.round(Math.random());
			m_nContents[4] = (int)Math.round(Math.random());
		}
		
		public void clone(Packet packet) {
			m_nTag = packet.m_nTag;
			m_nRet = packet.m_nRet;
			m_nLen = packet.m_nLen;
			m_nKind = packet.m_nKind;
			for (int i = 0; i < m_nLen / 4; i++)
				m_nContents[i] = packet.m_nContents[i];
		}
		
		public boolean recvFrom(DataInputStream input)
		throws IOException,Exception {
			if (null == input)
				throw new Exception("null intput stream");
			m_nTag = input.readByte();
			if (0x03 != m_nTag && 0x7F != m_nTag && 0x14 != m_nTag)
				return false; // invalid packet
			m_nRet = input.readByte();
			m_nLen = input.readShort();
			if (m_nLen > MAX_DATA_LEN) // too large
				return false;
			m_nKind = input.readInt();
			for (int i = 0; i < m_nLen / 4; i++) {
				m_nContents[i] = input.readInt();
			}
			return true;
		}
		
		public boolean writeTo(DataOutputStream output)
		throws IOException,Exception {
			if (0 == m_nTag || m_nLen > MAX_DATA_LEN)
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
			
			log("sent:" + this.toString());
			return true;
		}
		
		public String toString() {
			String strPacket = "tag:" + m_nTag + " ret:" + m_nRet + " len:" + m_nLen + " kind:" + m_nKind;
			if (m_nLen > 0)
				strPacket += " ";
			for (int i = 0; i < m_nLen / 4; i++)
				strPacket += m_nContents[i] + " ";
			return strPacket;
		}
	}
	
	private Socket m_sock = null;
	private DataOutputStream m_outputStream = null;
	
	private void connect(String strIP, int nPort)
	throws IOException,Exception {
		log("connecting to " + strIP + ":" + nPort);
		if (null == strIP && nPort <= 0)
			throw new IllegalArgumentException("ip:" + strIP + " port:" + nPort);
		m_sock = new Socket(strIP, nPort);
		m_outputStream = new DataOutputStream(m_sock.getOutputStream());
		log("connected on port:" + m_sock.getLocalPort());
		m_sock.setSendBufferSize(16 * 1024);
	}
	
	private void disconnect()
	throws IOException {
		if (null != m_outputStream) {
			m_outputStream.close();
			m_outputStream = null;
		}
		if (null != m_sock && !m_sock.isClosed()) {
			m_sock.close();
			m_sock = null;
		}
		log("disconnected");
	}
	
	private void sendUpgrade()
	throws IOException, Exception {
		Packet packet = new Packet(0x7D, 0, 0, 0x7C7C, null);
		packet.writeTo(m_outputStream);
	}
	
	private void sendLogout()
	throws IOException, Exception {
		Packet packet = new Packet(0x7D, 0, 0, 0x7D7d, null);
		packet.writeTo(m_outputStream);
	}
	
	private void sendStateChanged(int nSeq)
	throws IOException, Exception {
		Packet packet = new Packet();
		packet.m_nLen = 28;
		packet.m_nContents[5] = nSeq;
		packet.m_nContents[6] = (int)(System.currentTimeMillis() & 0xFFFFFFFF);
		System.out.println("seq:" + nSeq + " " + " now:" + packet.m_nContents[6]);
		packet.writeTo(m_outputStream);
	}
	
	private void sendStateChanged(String strContent)
	throws IOException, Exception {
		String [] strTemps = strContent.split(";");
		Packet packet = new Packet();
		packet.m_nLen = 28;
		packet.m_nContents[0] = Integer.parseInt(strTemps[0]);
		packet.m_nContents[1] = Integer.parseInt(strTemps[1]);
		packet.m_nContents[2] = Integer.parseInt(strTemps[2]);
		packet.m_nContents[3] = Integer.parseInt(strTemps[3]);
		packet.m_nContents[4] = Integer.parseInt(strTemps[4]);
		packet.writeTo(m_outputStream);
	}
	
	private void sendConnExceed()
	throws IOException, Exception {
		Packet packet = new Packet();
		packet.m_nTag = 0x7D;
		packet.m_nRet = 0;
		packet.m_nLen = 0;
		packet.m_nKind = 0x7979;
		packet.writeTo(m_outputStream);
	}
	
	private void sendBytes(String[] strBytes, int nStartIndex)
	throws IOException, Exception {
		if (null == strBytes || nStartIndex >= strBytes.length)
			throw new IllegalArgumentException("bytes:" + strBytes + " index:" + nStartIndex);
		if (null == m_outputStream)
			throw new Exception("null outputStream");
		for (int i = nStartIndex; i < strBytes.length; i++)
			m_outputStream.writeByte(Integer.parseInt(strBytes[i]));
		m_outputStream.flush();
		
		String strSent = "";
		for (int i = nStartIndex; i < strBytes.length; i++)
			strSent += strBytes[i] + " ";
		log("sent:" + strSent);
	}
	
	private void queryClientState(String strToIP, int nToPort, String strIP)
	throws IOException, Exception {
		DatagramSocket socket = null;
		DatagramPacket recvPacket = new DatagramPacket(new byte[1024], 1024);
		DatagramPacket sendPacket = null;
		byte [] bufStr = new byte[1024];
		
		// recv query data and send back return
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String strInfo = null;
		try {
			log("connecting to " + strToIP + ":" + nToPort);
			socket = new DatagramSocket();
			// generate sending packet
			baos = new ByteArrayOutputStream();
			dos = new DataOutputStream(baos);
			dos.writeByte(0x08);	// write packet tag
			dos.writeByte(0x08);	// write func type
			dos.writeShort(1024);	// write packet len
			dos.writeInt(0);	 // write ret
			dos.writeBytes(strIP);	// write ip
			for (int i = strIP.length(); i < 24; i++)
				dos.writeByte(0);	// fill ip field with zero
			for (int i = 0; i < 992; i++)
				dos.writeByte(0);
			dos.flush();
			sendPacket = new DatagramPacket(baos.toByteArray(), 1024);
			sendPacket.setAddress(InetAddress.getByName(strToIP));
			sendPacket.setPort(nToPort);
			socket.send(sendPacket);

			// read packet
			socket.receive(recvPacket);
			bais = new ByteArrayInputStream(recvPacket.getData());
			dis = new DataInputStream(bais);
			if (0x09 != dis.readByte())	// read packet tag
				throw new Exception("invalid tag");
			if (0x08 != dis.readByte())	// read func type
				throw new Exception("invalid func type");
			if (dis.readShort() > 1024)	// read len
				throw new Exception("too large packet");
			dis.readInt();	// read ret
			dis.read(bufStr, 0, 24);	// read ip
			strIP = new String(bufStr).trim();
			dis.read(bufStr, 0, 992);
			strInfo = new String(bufStr).trim();
			log("ip:" + strIP + " info:" + strInfo);
		} catch (Exception ex) {
			log(ex + " @ClientManager::run");
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
		
		socket.disconnect();
		socket.close();
	}
	
	public static void main(String[] args) {
		String USAGE_STRING =
			"usage:\n" +
			"ClientTest DEST_IP DEST_PORT TYPE [BYTES] [COUNT]\n" +
			"DEST_IP: destination host ip\n" +
			"DEST_PORT: destination port\n" +
			"TYPE: 0 - for one to-upgrade-packet\n" +
			"      1 - for one to-logout-packet\n" +
			"      2 - for continuous randomize to-update-state-packets\n" +
			"      3 - for generating a packet with specified bytes, BYTES must be set\n" +
			"      4 - query client state\n" +
			"      5 - quit for max conn exceed\n" +
			"      9 - for auto testing with random type and random data\n" + 
			"BYTES: bytes for generating a packet, must be all numbers\n" +
			"COUNT: count of to-update-state-packet to be send";
		if (args.length < 3) {
			System.out.println(USAGE_STRING);
			return;
		}
		
		String strDestIP = null; 
		int nDestPort = -1;
		int nType = -1;
		try {
			strDestIP = args[0];
			nDestPort = Integer.parseInt(args[1]);
			nType = Integer.parseInt(args[2]);
		} catch (Exception ex) {
			System.out.println(USAGE_STRING);
			return;
		}
		
		// begin test
		ClientTest test = new ClientTest();
		switch (nType) {
		case 0: // send upgrade
			try {
				test.connect(strDestIP, nDestPort);
				test.sendUpgrade();
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 1: // send logout
			try {
				test.connect(strDestIP, nDestPort);
				test.sendLogout();
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 2: // send continuous alarm state changed
			try {
				test.connect(strDestIP, nDestPort);
				for (int i = 0; i != Integer.parseInt(args[3]); i++) {
					test.sendStateChanged(i);
					Thread.sleep(10L);//500L + Math.round(500L * Math.random()));
				}
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 3: // send raw bytes
			try {
				test.connect(strDestIP, nDestPort);
				test.sendBytes(args, 3);
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 4: // query web-clients state
			try {
				test.queryClientState(strDestIP, nDestPort, "192.168.0.100");
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 5: // quit for max conn
			try {
				test.connect(strDestIP, nDestPort);
				test.sendConnExceed();
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 6: // send given state changed
			InputStreamReader isr = null;
			BufferedReader br = null;
			String strLine = null;
			try {
				isr = new InputStreamReader(System.in);
				br = new BufferedReader(isr);
				test.connect(strDestIP, nDestPort);
				System.out.print(">");
				while (null != (strLine = br.readLine()) && !strLine.equalsIgnoreCase("exit")) {
					test.sendStateChanged(strLine);
					System.out.print(">");
				}
			} catch (Exception ex) {
				test.log("test fail:" + ex);
			} finally {
				try {
					if (null != br) {
						br.close();
						br = null;
					}
				} catch (Exception ex) {
				}
				try {
					if (null != isr) {
						isr.close();
						isr = null;
					}
				} catch (Exception ex) {
				}
				try {
					test.disconnect();
				} catch (Exception ex) {
				}
			}
			break;
		case 9: // random test
			int nLoop = 0;
			while (true) {
				try {
					test.connect(strDestIP, nDestPort);
				} catch (Exception ex) {
					test.log("connect fail:" + ex);
				}
				
				nLoop = (int)Math.round(Math.random() * 20);
				while (nLoop-- > 0) {
					nType = (int)Math.round(Math.random() * 3);
					try {
						//nType = Integer.parseInt(args[2]);
						switch (nType) {
						case 0:
							test.sendUpgrade();
							break;
						case 1:
							test.sendLogout();
							break;
						case 2:
							/*
							int nCount = (int)Math.round(Math.random() * 20);
							while (nCount-- > 0) {
								try {
									test.sendStateChanged(nCount);
									Thread.sleep(Math.round(Math.random() * 3000));
								} catch (Exception ex) {
								}
							}
							*/
							break;
						case 3:
							String [] strArg = new String[1];
							strArg[0] = "" + (int)Math.round(Math.random() * 257);
							test.sendBytes(strArg, 0);
							break;
						default:
							System.out.println(USAGE_STRING);
						}
					} catch (Exception ex) {
						break;
					}
					
					try {
						Thread.sleep(500L);
					} catch (Exception ex) {
					}
				}
				
				try {
					test.disconnect();
				} catch (Exception ex) {
					test.log("disconnect fail:" + ex);
				}
				
				try {
					Thread.sleep(1000L);
				} catch (Exception ex) {
				}
			}
		default:
			System.out.println(USAGE_STRING);
			break;	
		}
	}
	
	private String m_strLogFile = "D:\\test_state.log";
	public void log(String strLog) {
		if (false) {
			File file = null;
			FileWriter fw = null;
			BufferedWriter bw = null;
	
			try {
				file = new File(m_strLogFile);
				// delete the log file if it's larger than 2M
				if (file.exists() && file.length() >= 2 * 1024 * 1024)
					file.delete();
				// log
				fw = new FileWriter(m_strLogFile, true);
				bw = new BufferedWriter(fw);
				bw.write(new Date().toString() + " - " + strLog);
				bw.write("\r\n");
				bw.flush();
			} catch (Exception ex) {
			} finally {
				try {
					if (null != bw) {
						bw.close();
						bw = null;
					}
					if (null != fw) {
						fw.close();
						fw = null;
					}
				} catch (Exception ex) {
					System.out.println("close writer fail");
				}
			}
		} else
			System.out.println(new Date() + " - " + strLog);
	}
	
}