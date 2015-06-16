/* 
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved. 
 * 
 * 
 * 
 * 
 * 
 */

/**
 *  : <>
 * JDK : <1.5.0.8>
 *  : <JavaBasic 1.0>
 *
 *  : <edu.frank.thread>
 *  : <SleepAndWait.java>
 *  : 1.0
 * <Show different between sleep method and wait method.>
 *
 *  : <Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a>>
 *  : <2012-03-25 09:13:15>
 *
 *
 */
package edu.frank.thread;

/**
 * <p>
 * <Different between sleep and wait>
 * </p>
 * 
 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
 * <p>
 * 
 * <Frank Deng> <p>
 * <2012-03-25 09:13:15> <p>
 * :	<> <p>
 * 
 * 
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public class SleepAndWait implements Runnable {

	private int temperature;
	private int pressure;
	
	/**
	 * 
	 * < <code>SleepAndWait</code> >
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 *  <Frank Deng> <p>
	 * <2012-03-25 09:13:15> <p>
	 * <> <p>
	 *
	 * @throws Exception
	 *             
	 *
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public SleepAndWait() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
	}

	/**
	 * @return the temperature
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the pressure
	 */
	public int getPressure() {
		return pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	/**
	 * <>
	 * 
	 * @author &lt Frank Deng Email:<a href="mailto:guanxiong.deng@hozdo.com">Frank Deng</a> &gt
	 * <p>
	 *
	 *  <Frank Deng> <p>
	 * <2012-03-25 09:13:15> <p>
	 * <> <p>
	 * 
	 * @param args
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public static void main(String[] args) {
		Thread thread1 = new Thread(new SleepAndWait());
		Thread thread2 = new Thread(new SleepAndWait());
		thread1.start();
		thread2.start();
	}

}
