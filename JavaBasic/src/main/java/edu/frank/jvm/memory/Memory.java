/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 *  HOTEL1802 STUDIO 
 *
 * 
 * 
 *
 */

/**
 *  : <HOTEL1802 STUDIO>
 * JDK  : <1.6.10>
 *  : <JavaBasic>
 *
 *  : <edu.frank.jvm.memory>
 *  : <Memory.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-29 12:21:16>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.jvm.memory;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-9-29 12:21:16> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class Memory implements Runnable{

	/**
	 *
	 * <  <code>Memory</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-29 12:21:16> 		<p>
	 * <> 			<p>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public Memory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * <...>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-29 12:21:16>		<p>
	 * <>			<p>
	 *
	 * @param args
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread newThread = new Thread(new Memory());
		newThread.start();

	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(3 * 60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}