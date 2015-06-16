package edu.frank.net;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * tcp connection, listening on port 8666 or 8667
 * for relaying alarm state to web client
 */
class Relayer extends Thread {
	private int m_nPort = 8666;
	private boolean m_bRunning = false;
	
	public Relayer(int nPort) {
		m_nPort = nPort;
		m_bRunning = true;
	}
	
	public void run() {
		ServerSocket serverSock = null;
		Socket clientSock = null;
		
		while (true) {
			SocketServer.log("Relayer started");
			try {
				serverSock = new ServerSocket(m_nPort);
				serverSock.setSoTimeout(5000);
				SocketServer.log("Relayer listening on port:" + m_nPort);
			} catch (Exception ex1) {
				SocketServer.log("sock fail:" + ex1);
				try {
					Thread.sleep(10000);
				} catch (Exception ex2) {
				}
				continue;
			}
			while (m_bRunning) {
				try {
					clientSock = serverSock.accept();
					new CommunicateThread(clientSock).start();
				} catch (SocketTimeoutException ex) {
					continue;
				} catch (IOException ex) {
					SocketServer.log("sock fail:" + ex);
					break;
				}
			}
			try {
				if (null != serverSock && !serverSock.isClosed()) {
					serverSock.close();
					serverSock = null;
				}
				if (m_bRunning) {
					Thread.sleep(10000L);
					SocketServer.log("trying to restart Relayer");
				} else {
					SocketServer.log("Relayer closed");
					break;
				}
			} catch (InterruptedException ex) {
			} catch (IOException ex2) {
				SocketServer.log("Relayer crash:" + ex2);
			}
		}
	}
	
	public void end() {
		CommunicateThread.endAll();
		m_bRunning = false;
	}
}