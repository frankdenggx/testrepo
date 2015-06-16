/**
 * 
 */
package edu.frank.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * @author yoyudenghihi
 *
 */
public class J_UDPClient {

	/**
	 * 
	 */
	public J_UDPClient() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DatagramSocket dataSocket = null;
		DatagramPacket inPacket = null;
		DatagramPacket outPacket = null;
		InetAddress sAddr = null;
		byte[] inBuffer = new byte[1024];
		byte[] outBuffer = null;
		String str = "Hello";
		try {
			dataSocket = new DatagramSocket();
			sAddr = InetAddress.getByName("10.123.15.189");
			outBuffer = str.getBytes();
			outPacket = new DatagramPacket(outBuffer,0,outBuffer.length,sAddr,8000);
			dataSocket.send(outPacket);
			inPacket = new DatagramPacket(inBuffer,0,inBuffer.length);
			dataSocket.receive(inPacket);
			str = new String(inPacket.getData(),0,inPacket.getLength());
			System.out.println(str);
			dataSocket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
