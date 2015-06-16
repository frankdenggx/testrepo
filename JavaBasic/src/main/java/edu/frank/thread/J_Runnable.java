/**
* Copyright: 2005-2008 GuangZhou Thinker Tech. Co.,Ltd. All Rights  Reserved.
* Version: 1.0
* FileName: J_Runnable
* Author: yoyudenghihi
* Description:
* 		implements Runnable
* 		Thread thread = new Thread(new J_Runnable(1));
* 		thread.start();
* History:
* <author>			<time>			<version>			<desc>
* yoyudenghihi		2009.09.14		1.0				Create
*/
package edu.frank.thread;


/**
 * Java
 * @category Class
 * @see java.lang.Runnable
 * @since 1.0
 * @author yoyudenghihi
 * @version 1.0
 */
public class J_Runnable implements Runnable {
	
	/**
	 * ID
	 */
	private int nThreadId = -1;

	/**
	 * 
	 */
	public J_Runnable() {

		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ,ID
	 * @category Method
	 * @param nThreadId ID
	 */
	public  J_Runnable(int nThreadId){
		this.nThreadId = nThreadId;
	}
	
	/**
	 * ,ID
	 * @category Method
	 * @param nThreadId ID
	 */
	public synchronized void init(int nThreadId){
		this.nThreadId = nThreadId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		String strMessage = null;
		for (int i=0; i<5; i++){
			try{
				Thread.sleep((int)Math.random() * 1000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			strMessage = getSystemTime(this.nThreadId);
			System.out.println("strMessag=" + strMessage);
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
		Thread threadTestA = new Thread(new J_Runnable(1));
		threadTestA.start();
		Thread threadTestB = new Thread(new J_Runnable(2));
		threadTestB.start();
	}

}