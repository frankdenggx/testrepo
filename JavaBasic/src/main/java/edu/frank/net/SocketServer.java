package edu.frank.net;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SocketServer {

	private static final String APP_NAME = "SocketServer";
	private static final String VERSION_STRING = "2.8.0.1";
	private static final String RELEASE_DATE = "2008-08-15";
	private static final SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd");
	private static int m_nLogto = 0;
	private static String m_strLastLogDate = DATE_FORMAT.format(new Date());
	private static SocketServer m_server = null;
	private Relayer m_relayer = null;
	private int m_nPort = 8666;
	private ClientManager m_clientManager = null;
	private ServerDaemon m_serverDaemon = null;
	
	public static String getAppName() {
		return APP_NAME;
	}
	
	public static String getVersionString() {
		return VERSION_STRING;
	}
	
	public static String getReleaseDate() {
		return RELEASE_DATE;
	}
	
	private void loadParameter() {
		File fConf = new File("conf.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String strLine = null;
		boolean bInSection = false;
		try {
			if (!fConf.exists())
				throw new Exception("conf.txt not exists");
			
			String[] strTemps = null;
			fr = new FileReader(fConf);
			br = new BufferedReader(fr);
			
			while (null != (strLine = br.readLine())) {
				if (strLine.trim().length() <= 0 || strLine.startsWith("#"))
					continue;
				if (strLine.equalsIgnoreCase(("[web server setup]"))) {
					bInSection = true;
					continue;
				}
				if (strLine.equals("[")) {
					bInSection = false;
					continue;
				}
				if (bInSection) {
					strTemps = strLine.split("=");
					strTemps[0] = strTemps[0].trim();
					strTemps[1] = strTemps[1].trim();
					if (strTemps[0].equalsIgnoreCase("max_nms_conn") && 8667 == m_nPort) {
						CommunicateThread.setMaxConnection(Integer.parseInt(strTemps[1]));
					}
					if (strTemps[0].equalsIgnoreCase("max_als_conn") && 8666 == m_nPort) {
						CommunicateThread.setMaxConnection(Integer.parseInt(strTemps[1]));
					}
				}
			}
		} catch (Exception ex) {
			log("load conf file fail:" + ex + " @loadParameter");
		} finally {
			try {
				if (null != br) {
					br.close();
					br = null;
				}
				if (null != fr) {
					fr.close();
					fr = null;
				}
			} catch (Exception ex) {
				log("close stream fail:" + ex + " @loadParameter");
			}
		}
	}
	
	private void start() {
		log(APP_NAME + " v" + VERSION_STRING + " startup");
		loadParameter();
		log("max conn:" + CommunicateThread.getMaxConnection());
		if (8666 == m_nPort || 8667 == m_nPort)
			(m_relayer = new Relayer(m_nPort)).start();
		if (8667 == m_nPort) {
			(m_clientManager = new ClientManager()).start();
			(m_serverDaemon = new ServerDaemon()).start();
		}
	}
	
	private void close() {
		if (null != m_serverDaemon) {
			m_serverDaemon.end();
			m_serverDaemon = null;
		}
		if (null != m_relayer) {
			m_relayer.end();
			m_relayer = null;
		}
		if (null != m_clientManager) {
			m_clientManager.end();
			m_clientManager = null;
		}
		log(APP_NAME + " shutdown");
	}
	
	public static void main(String[] args) {
		String USAGE_STRING =
			"usage:\n" +
			"SocketServer [LISTEN_PORT] [LOG_TO_FILE]\n" +
			"LISTEN_PORT: listening port, generally, 8666 for alarm system and 8667 for nm system\n" +
			"\tdefault as 8666\n" +
			"LOG_TO_FILE: 0 - write log to file, 1 - write log to screen\n" +
			"\tdefault as 0\n";
		m_server = new SocketServer();
		while (true) {
			try {
				if (args.length >= 1)
					m_server.m_nPort = Integer.parseInt(args[0]);
				if (args.length >= 2)
					m_nLogto = Integer.parseInt(args[1]);
				if (m_server.m_nPort <= 0)
					throw new IllegalArgumentException("port:" + args[0]);
				m_server.start();
				synchronized (m_server) {
					m_server.wait();
				}
			} catch (IllegalArgumentException ex) {
				System.out.println(ex);
				System.out.println(USAGE_STRING);
				break;
			} catch (Exception ex) {
				log("app interrupted:" + ex);
			} finally {
				m_server.close();
				try {
					Thread.sleep(20000);
				} catch (Exception ex2) {
				}
				log("trying to restart app");
			}
		}
	}
	
	synchronized public static void log(String strLog) {
		if (0 == m_nLogto) {
			File file = null;
			FileWriter fw = null;
			BufferedWriter bw = null;
			final String strFile = "debug_log/server_" + m_server.m_nPort + ".log";
			
			try {
				file = new File(strFile);
				if (file.exists() && !m_strLastLogDate.equals(DATE_FORMAT.format(new Date()))) {
					file.renameTo(new File(strFile + "." + m_strLastLogDate));
					m_strLastLogDate = DATE_FORMAT.format(new Date());
				}
				// log
				fw = new FileWriter(strFile, true);
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
