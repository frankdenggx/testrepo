/**
 * 
 */
package edu.frank.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;


/**
 * @author yoyudenghihi
 *
 */
public class J_MulticastClient {

	/**
	 * 
	 */
	public J_MulticastClient() {

		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MulticastSocket multicastSocket = null;
		InetAddress group = null;
		DatagramPacket outPacket = null;
		DatagramPacket inPacket = null;
		final int nGroupPort = 8000;
		final String strGroupAddr = "228.5.6.7";
		byte[] inBuffer = new byte[1024];
		byte[] outBuffer = null;
		String strRevMessage = null;
		String strSendMessage = null;
		try {
			group = InetAddress.getByName(strGroupAddr);
			multicastSocket = new MulticastSocket(nGroupPort);
			multicastSocket.joinGroup(group);
			
			strSendMessage = "Hello World!";
			outBuffer = strSendMessage.getBytes();
			outPacket = new DatagramPacket(outBuffer,0,outBuffer.length,group,nGroupPort);
			multicastSocket.send(outPacket);
			
			inPacket = new DatagramPacket(inBuffer,0,inBuffer.length);
			multicastSocket.receive(inPacket);
			strRevMessage = new String(inPacket.getData(),0,inPacket.getLength());
			System.out.println(strRevMessage);
			multicastSocket.leaveGroup(group);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			multicastSocket.close();
		}
	}

}
