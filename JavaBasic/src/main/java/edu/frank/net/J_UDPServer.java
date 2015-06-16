/**
 * 
 */
package edu.frank.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;




/**
 * @author yoyudenghihi
 *
 */
public class J_UDPServer {

	/**
	 * 
	 */
	public J_UDPServer() {

		// TODO Auto-generated constructor stub
	}

	public static byte[] getData() {
		Date date = new Date();
		return date.toString().getBytes();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DatagramSocket dataSocket = null;
		DatagramPacket inPacket = null;
		DatagramPacket outPacket = null;
		InetAddress cAddr = null;
		int cPort = -10000;
		byte[] inBuffer = new byte[1024];
		byte[] outBuffer = null;
		String str = null;
		try {
			dataSocket = new DatagramSocket(8000);
			while(true){
				inPacket = new DatagramPacket(inBuffer,0,inBuffer.length);
				dataSocket.receive(inPacket);
				cAddr = inPacket.getAddress();
				cPort = inPacket.getPort();
				str = new String(inPacket.getData(),0,inPacket.getLength());
				System.out.println("Client Addr=" + cAddr.getHostName() + " Port=" + cPort + ":" + str);
				outBuffer = getData();
				outPacket = new DatagramPacket(outBuffer,0,outBuffer.length,cAddr,cPort);
				dataSocket.send(outPacket);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
