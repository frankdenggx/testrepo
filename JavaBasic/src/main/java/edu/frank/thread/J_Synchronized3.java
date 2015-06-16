/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * Version: 1.0
 * FileName: J_Synchronized3.java
 * Description:
 * 		J_Experiment3:
 * 		
 * 		J_Experiment,
 * 		updateData
 * 		analyzeData 
 * 		
 * 		
 * 		
 * 		
 * 
 * 		J_AssiantData3:
 * 		
 * 
 * 		J_AnalyzeData3:
 * 		
 * 
 * 		J_Synchronized3
 * 		
 * 		
 * 		J_Experiment3 classExperiment3 = 
 * 			new J_Experiment3();
 * 		
 * 		J_AssiantData3 m_classAssiantData =
 *  		new J_AssiantData3(m_classExperiment3);	
 *  	
 *  	J_AnalyzeData3 m_classAnalyzeData = 
 *  		new J_AnalyzeData3(m_classExperiment3);
 *  	
 *  	
 *  	bDataReadybDataReadyfalse
 *  	    bDataReadytrue
 *  		
 * Author: yoyudenghihi
 * History:
 * <author>			<time>			<version>			<desc>
 * yoyudenghihi		2009.09.14		1.0				Create
 */
package edu.frank.thread;


/**
 * 
 * @see java.lang.Object
 * @since 1.0
 * @author yoyudenghihi
 *
 */
class J_SynExperiment3{
	private int nTemperature;	//
	private int nPressure;		//
	private boolean bDataReady = false;	//
	
	/**
	 * 
	 * @param m_nTemperature 
	 * @param m_nPressure 
	 */
	public synchronized void updateData(int m_nTemperature,int m_nPressure){
		
		while(bDataReady){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.nTemperature = m_nTemperature;
		this.nPressure = m_nPressure;
		System.out.println("Update Data: T=" + this.nTemperature + 
				" P=" + this.nPressure);
		bDataReady = true;
		this.notify();
	}
	
	/**
	 * 
	 */
	public synchronized void annalyzeData(){
		
		while(!bDataReady){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int m_nTemperature = this.nTemperature;
		int m_nPressure = this.nPressure;
		if (m_nTemperature != this.nTemperature){
			System.out.println("It is very dangerous now :");
			System.out.println("T(" + m_nTemperature + ")!=(" + 
					this.nTemperature + ")");
			System.exit(0);
		}
		if (m_nPressure != this.nPressure){
			System.out.println("It is very dangerous now :");
			System.out.println("P(" + m_nPressure + ")!=(" +
					this.nPressure + ")");
			System.exit(0);
		}
		System.out.println("Analyze Data: T=" + this.nTemperature +
				" P=" + this.nPressure);
		bDataReady = false;
		this.notify();
	}
}


/**
 * 
 * @author yoyudenghihi
 *
 */
class J_SynAssiantData3 extends Thread{
	
	J_SynExperiment3 classExperiment;	//
	
	public J_SynAssiantData3(J_SynExperiment3 m_classExperiment){
		
		this.classExperiment = m_classExperiment;
	}
	
	public void run(){
		
		int m_nVirtualTemperature;
		int m_nVirtualPressure;
		for(; true; ){
			m_nVirtualTemperature = (int) (Math.random() * 1000);
			m_nVirtualPressure = (int) (Math.random() * 1000);
			this.classExperiment.updateData(m_nVirtualTemperature,
					m_nVirtualPressure);
		}
	}
}


/**
 * 
 * @author yoyudenghihi
 *
 */
class J_SynAnalyzeData3 extends Thread{
	
	J_SynExperiment3 classExperiment;	//
	
	public J_SynAnalyzeData3(J_SynExperiment3 m_classExperiment){
		
		this.classExperiment = m_classExperiment;
	}
	
	public void run(){
		
		for(; true; ){
			this.classExperiment.annalyzeData();
		}
	}
	
}


/**
 * 
 * @author yoyudenghihi
 *
 */
public class J_Synchronized3 {

	/**
	 * 
	 */
	public J_Synchronized3() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		J_SynExperiment3 m_classExperiment = new J_SynExperiment3();
		J_SynAssiantData3 m_classAssiantData = 
			new J_SynAssiantData3(m_classExperiment);
		J_SynAnalyzeData3 m_classAnalyzeData = 
			new J_SynAnalyzeData3(m_classExperiment);
		m_classAssiantData.start();
		m_classAnalyzeData.start();

	}

}