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
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author yoyudenghihi
 *
 */
public class J_ClientThread {

	private static final int nPort = 5000;
	
	/**
	 * constructor
	 */
	public J_ClientThread() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length < 2) {
			return;
		}
		try {
			Socket socket = new Socket(args[0],nPort);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK"));
			String strRev = br.readLine();
			System.out.println(strRev);
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK")),true);
			String strSend = null;
			char c;
			while(true){
				strSend = "";
				do{
					c = (char)(System.in.read());
					if (c != '\n' && c != '\r')
						strSend += c;
				}while(c != '\n');
				out.println("Client[" + args[1] + "]:" + strSend);
				int n = strSend.length();
				if (n > 0){
					c = strSend.charAt(n -1);
					if (c == 'q')
						break;
				}
			}
			br.close();
			out.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
