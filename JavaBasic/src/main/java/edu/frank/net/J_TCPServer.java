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

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author yoyudenghihi
 *
 */
public class J_TCPServer {
	private static final int nPort = 5000;

	/**
	 * constructor
	 */
	public J_TCPServer() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * main method
	 * @param args console arguments
	 */
	public static void main(String[] args) {

		ServerSocket server = null;
		try{
			server = new ServerSocket(nPort);
		}catch(IOException ex){
			System.err.println(ex);
		}
		while(true){
			try{
				Socket socket = server.accept();
				DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
				dataOut.writeUTF("Hello from server!");
				dataOut.close();
			}catch(IOException ex){
				System.err.println(ex);
			}
		}

	}

}
