/**
 * 
 */
package edu.frank.io;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author yoyudenghihi
 *
 */
public class J_Echo {

	/**
	 * 
	 */
	public J_Echo() {

		// TODO Auto-generated constructor stub
	}
	
	public static void echo(InputStream m_in){
		byte[] m_byte = new byte[100];
		try {
			System.out.print(m_in.read(m_byte, 0, 10));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getMyAge(String strAge){
		int nAge = 0;
		try {
			return Integer.parseInt(strAge);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}finally{
			System.out.println("HERE");
		}
		return nAge;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int age = 0;
		J_Echo instance = new J_Echo();
		age = instance.getMyAge("25");
		System.out.println(age);

	}

}
