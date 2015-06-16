/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * J_MulticastServer
 * 1.0
 * 
 * 2010-03-04
 * yoyudenghihi
 * 
 * 							
 * 2010.03.04	yoyudenghihi		
 */
package edu.frank.net;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 
 *
 * @see java.net.MulticastSocket
 * @since 1.0 2010/03/04
 * @author yoyudenghihi
 * @version 1.0
 */
public class J_MulticastServer {

	// 
	private static final String APP_NAME = "J_MulticastServer"; // 
	private static final String APP_VERSION = "1.0"; // 
	private static final String APP_RELEASE = "2010.03.04"; // 򷢲

	// 
	private static final SimpleDateFormat DATE_FORMAT =
		new SimpleDateFormat("yyyy-MM-dd"); // "--"
	private static String m_strLastLogDate = DATE_FORMAT.format(new Date()); // 
	private static final String DEFAULT_LOG_PATH = "./debug_log"; // 
	private static String m_strLogPath = DEFAULT_LOG_PATH; // 

	// 
	private static Properties m_configProperties = null; // 
	private static final String DEFAULT_PRPOERTIES = "MulticastServer.properties"; // 
	private static String m_strConfigPropertiesPath = DEFAULT_PRPOERTIES; // 
	private static FileReader m_configFileReader = null; // 

	// 
	private static final String DEFAULT_GROUP_IP = "228.5.6.7"; // IP
	private static final int DEFAULT_GROUP_PORT = 8000; // 
	private static String m_strGroupIp = DEFAULT_GROUP_IP; // IP
	private static int m_nGroupPort = DEFAULT_GROUP_PORT; // 
	private static final int DEFAULT_TIME_OUT = 10000; // 
	private static int nTimeOut = DEFAULT_TIME_OUT; // 
	private static MulticastSocket m_dataSocket = null; // 
	private static DatagramPacket m_recvPacket = null; // 
	private static DatagramPacket m_sendPacket = null; // 
	private static InetAddress m_groupAddr = null; // 
	private static InetAddress[] m_clientAddrs = null; // 
	private static int[] m_clientPorts = null;	//
	private static final int MAX_CLIENTS = 100;	//
	private static int nMaxClients = MAX_CLIENTS;	//
	private static int nAvliableClients = nMaxClients;	//
	private static byte[] m_recvBuffer = new byte[1024]; // 
	private static byte[] m_sendBuffer = null; // 

	private static J_MulticastServer m_server = null; // 

	/**
	 *
	 */
	public J_MulticastServer() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 *
	 * @return 
	 */
	public String getAppName() {

		return APP_NAME;
	}

	/**
	 * 
	 *
	 * @return 
	 */
	public String getAppVersion() {

		return APP_VERSION;
	}

	/**
	 * 򷢲
	 *
	 * @return 򷢲
	 */
	public String getAppRelease() {

		return APP_RELEASE;
	}

	/**
	 * IP
	 *
	 * @return IP
	 */
	public String getGroupIp() {

		return m_strGroupIp;
	}

	/**
	 * IP
	 *
	 * @param strGroupIp
	 */
	public void setGroupIp(String strGroupIp) {

		m_strGroupIp = strGroupIp;
	}

	/**
	 * 
	 *
	 * @return 
	 */
	public int getGroupPort() {

		return m_nGroupPort;
	}

	/**
	 * 
	 *
	 * @param strGroupPort 
	 */
	public void setGroupPort(int nGroupPort) {

		m_nGroupPort = nGroupPort;
	}

	/**
	 * 
	 *
	 * @return 
	 */
	public InetAddress getGroupInetAddress() {

		return m_groupAddr;
	}

	/**
	 * 
	 *
	 * @return 
	 */
	public InetAddress[] getClientInetAddress() {

		return m_clientAddrs;
	}

	/**
	 * 
	 *
	 * @return 0-OK 1-ERR
	 */
	public static int init() {

		try {
			m_configFileReader = new FileReader(new File(
					m_strConfigPropertiesPath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			log("properties's file can't found ! file path:"
					+ m_strConfigPropertiesPath);
			return -1;
		}
		m_configProperties = new Properties();
		try {
			m_configProperties.load(m_configFileReader);
		} catch (IOException e) {
			e.printStackTrace();
			log("load properties file error !");
			return -1;
		}
		try {
			m_strGroupIp = m_configProperties.getProperty("DEFAULT_GROUP_IP");
			m_nGroupPort = Integer.parseInt(m_configProperties
					.getProperty("DEFAULT_GROUP_PORT"));
			nTimeOut = Integer.parseInt(m_configProperties
					.getProperty("DEFAULT_TIMEOUT"));
			m_strLogPath = m_configProperties.getProperty("DEFAULT_LOG_PATH");
			nMaxClients = Integer.parseInt(m_configProperties.getProperty("MAX_CLIENTS"));
			m_clientAddrs = new InetAddress[nMaxClients];
			m_clientPorts = new int[nMaxClients];
		} catch (Exception ex) {
			ex.printStackTrace();
			log("init parameter error !");
			return -1;
		}
		return 0;
	}

	public static void start() {

		try {
			m_dataSocket = new MulticastSocket(m_nGroupPort);
			m_dataSocket.setSoTimeout(nTimeOut);
			m_groupAddr = InetAddress.getByName(m_strGroupIp);
			m_dataSocket.joinGroup(m_groupAddr);
			while (true) {
				m_recvPacket = new DatagramPacket(m_recvBuffer,0,m_recvBuffer.length);
				m_dataSocket.receive(m_recvPacket);
				InetAddress clientAddr = m_recvPacket.getAddress();
				int nClientPort = m_recvPacket.getPort();
				String strRecvNet = new String(m_recvPacket.getData(),0,m_recvPacket.getLength());
				System.out.println(m_recvBuffer.length);


				log(strRecvNet);
			}
		} catch (IOException e) {
			e.printStackTrace();
			log(e.getMessage());
		}
	}

	/**
	 * 
	 *
	 * @param strMsg 
	 */
	synchronized public static void log(String strMsg) {

		File logFile = null; // 
		File logFileDir = null; // 
		FileWriter out_fw = null; // 
		BufferedWriter out_bw = null; // 

		final String strFileDir = m_strLogPath;
		final String strFile = m_strLogPath + "/J_MulticastServer-"
				+ J_MulticastServer.m_nGroupPort + ".log";

		logFileDir = new File(strFileDir);
		if (null != logFileDir) {
			if (!logFileDir.exists()) {
				if (!logFileDir.mkdir()) {
					log("can't create directory for log !");
				}
			}
		}
		logFile = new File(strFile);
		if (null != logFile) {
			if (logFile.exists()
					&& !m_strLastLogDate.equals(DATE_FORMAT.format(new Date()))) {
				logFile.renameTo(new File(strFile + "." + m_strLastLogDate));
				m_strLastLogDate = DATE_FORMAT.format(new Date());
			}
		}

		// 
		try {
			out_fw = new FileWriter(logFile,true);
			out_bw = new BufferedWriter(out_fw);
			out_bw.write(new Date().toString() + " - " + strMsg);
			out_bw.write("\r\n");
			out_bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out_bw) {
					out_bw.close();
					out_bw = null;
				}
				if (null != out_fw) {
					out_fw.close();
					out_fw = null;
				}
			} catch (IOException ex_io) {
				ex_io.printStackTrace();
				log("close OutputStream error !");
			}
		}

	}

	public static byte[] getData() {

		String strMess = "ni shi shui wo men  doushi zhong guo ren women dou shifen "
				+ "re ai wome         ";
		return strMess.getBytes();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String strMsg = "";
		strMsg = "program:" + APP_NAME + " version:" + APP_VERSION
				+ " release:" + APP_RELEASE + " running now ,port:"
				+ J_MulticastServer.m_nGroupPort;
		log(strMsg);
		/*
		 * MulticastSocket dataSocket = null; DatagramPacket inPacket = null;
		 * DatagramPacket outPacket = null; InetAddress cAddr = null;
		 * InetAddress group = null; int nPort = 8000; int cPort = -10000;
		 * byte[] inBuffer = new byte[1024]; byte[] outBuffer = null; String str
		 * = null; try { dataSocket = new MulticastSocket(nPort); group =
		 * InetAddress.getByName("228.5.6.7"); dataSocket.joinGroup(group);
		 * while(true){ inPacket = new
		 * DatagramPacket(inBuffer,0,inBuffer.length);
		 * dataSocket.receive(inPacket); int nTimeLive =
		 * dataSocket.getTimeToLive(); System.out.println("Time To Live:" +
		 * nTimeLive); cAddr = inPacket.getAddress(); cPort =
		 * inPacket.getPort(); str = new
		 * String(inPacket.getData(),0,inPacket.getLength());
		 * System.out.println("Client Addr=" + cAddr.getHostName() + " Port=" +
		 * cPort + ":" + str); outBuffer = getData(); outPacket = new
		 * DatagramPacket(outBuffer,0,outBuffer.length,group,nPort);
		 * dataSocket.send(outPacket); } } catch (SocketException e) {
		 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		 */
		if (-1 != init()) {
			start();
		} else {
			strMsg = "running " + APP_NAME
					+ " error ! It'll shutdown at noce !";
			log(strMsg);
		}
	}

}
