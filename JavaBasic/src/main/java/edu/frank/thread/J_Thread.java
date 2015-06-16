/**
* Copyright: 2005-2008 GuangZhou Thinker Tech. Co.,Ltd. All Rights  Reserved.
* Version: 1.0
* FileName: J_Thread
* Author: yoyudenghihi
* Description:
* 		extends Thread
* 		new J_Thread(1).start();
* History:
* <author>			<time>			<version>			<desc>
* yoyudenghihi		2009.09.14		1.0				Create
*/
package edu.frank.thread;


/**
 * Java
 * @category Class
 * @see java.lang.Thread
 * @since 1.0
 * @author yoyudenghihi
 * @version 1.0
 */
public class J_Thread extends Thread{

	/**
	 * ID
	 */
	private int nThreadId;
	
	/**
	 * 
	 */
	public J_Thread(){
		
	}
	
	/**
	 * ,ID
	 * @category Method
	 * @param nThreadId ID
	 */
	public J_Thread(int nThreadId) {
		this.nThreadId = nThreadId;
	}
	
	public void run(){
		for (int i=0; i<5; i++){
			try{
				Thread.sleep((int)(Math.random()*1000));
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			System.out.println(getSystemTime(nThreadId));
		}
	}
	
	/**
	 * 
	 * @category Method
	 * @param nThreadId ID
	 * @return ID
	 */
	public String getSystemTime(int nThreadId){
		String strSystemTime = null;
		long lSystemTime = System.currentTimeMillis();
		strSystemTime = new String("ID=" + nThreadId + "=" +lSystemTime + "(ms)");
		return strSystemTime;
	}

	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		new J_Thread(1).start();
		new J_Thread(2).start();
	}

}