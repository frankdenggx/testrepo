/**
 * CopyRight:
 * ProjectName:
 * JDK Version:
 * File Version:
 * Create Time:
 * Author:
 * Modify History:
 * <date>			<modifier>				<content>
 */
package edu.frank.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author yoyudenghihi
 *
 */
public class J_ServerThread extends Thread {
	private Socket m_socket;
	private int m_id;
	private static final int nPort = 5000;

	/**
	 * constructor
	 * @param socket 
	 * @param id ID
	 */
	public J_ServerThread(Socket socket,int id) {

		m_socket = socket;
		m_id = id;
	}

	public void run(){
		try {
			System.out.println("Socket[" + m_id + "] connetion success...");
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(m_socket.getOutputStream(),"GBK")),true);
			out.println("Socket[" + m_id + "] welcome client");
			BufferedReader br = new BufferedReader(new InputStreamReader(m_socket.getInputStream(),"GBK"));
			while(true){
				String strRev = br.readLine();
				System.out.println("Socket[" + m_id + "] receives:" + strRev);
				int n = strRev.length();
				if (n > 0){
					char c = strRev.charAt(n - 1);
					if (c == 'q')
						break;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try{
				System.out.println("Socket[" + m_id +"] is closing...");
				m_socket.close();
			}catch(IOException ex){
				System.err.println(ex);
			}
		}
	}
	
	/**
	 * main method
	 * @param args console arguments
	 */
	public static void main(String[] args) {

		int n =1;
		ServerSocket server = null;
		try{
			server = new ServerSocket(nPort);
			System.out.println("server start>>>");
		}catch(IOException ex){
			System.err.println(ex);
		}
		while(true){
			try{
				System.out.println("Wait No." + n + " connection...");
				Socket socket = server.accept();
				J_ServerThread thread = new J_ServerThread(socket,n++);
				thread.start();
			}catch(IOException ex){
				System.err.println(ex);
			}
		}

	}

}
