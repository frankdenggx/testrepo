/**
 * 
 */
package edu.frank;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @author yoyudenghihi
 *
 */
public class GCTimerTask extends TimerTask{
	
	private static GCTimerTask instance = null;

	/**
	 * 
	 */
	public GCTimerTask() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		Calendar calender = new GregorianCalendar();
		int m_nHour = calender.get(Calendar.HOUR_OF_DAY);
		int m_nMin = calender.get(Calendar.MINUTE);
		System.out.println("[" + String.valueOf(m_nHour) + ":" + String.valueOf(m_nMin) +
				"]");
		System.out.println("JVM" + java.lang.Runtime.getRuntime().freeMemory()/(1024*1024) +
				"M/" + java.lang.Runtime.getRuntime().totalMemory()/(1024*1024) + "M" +
				";MaxMem:" + java.lang.Runtime.getRuntime().maxMemory()/(1024*1024) + "M");
		System.gc();
		
	}
	
	private void startWork(){
		Timer timer = new Timer();
		timer.schedule(instance, 0,1000*60);
		
	}
	
	public static  GCTimerTask getInstance(){
		if (null == instance){
			instance = new GCTimerTask();
			instance.startWork();
		}
		return instance;
	}

}
