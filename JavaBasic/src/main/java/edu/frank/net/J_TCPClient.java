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

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author yoyudenghihi
 *
 */
public class J_TCPClient {
	private static final String strHost = "10.123.15.189";
	private static final int nPort = 5000;
	/**
	 * constructor
	 */
	public J_TCPClient() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * main method
	 * @param args console arguments
	 */
	public static void main(String[] args) {

		try {
			Socket socket = new Socket(strHost,nPort);
			DataInputStream dataInput = new DataInputStream(socket.getInputStream());
			System.out.println(dataInput.readUTF());
			//dataInput.close();
		} catch (UnknownHostException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}

}
