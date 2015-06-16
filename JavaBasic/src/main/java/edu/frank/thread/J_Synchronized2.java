/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * Version: 1.0
 * FileName: J_Synchronized2
 * Description:
 * 		J_Experiment2:
 * 		
 * 		J_Experiment2,
 * 		updateData
 * 		analyzeData 
 * 		
 * 		J_AssiantData2:
 * 		
 * 		synchronized
 * 
 * 		J_AnalyzeData2:
 * 		
 * 		synchronized
 * 
 * 		J_Synchronized2
 * 		
 * 		
 * 		J_Experiment2 m_classExperiment = 
 * 			new J_Experiment2();
 * 		
 * 		J_AssiantData2 m_classAssiantData =
 *  		new J_AssiantData2(m_classExperiment);	
 *  	
 *  	J_AnalyzeData2 m_classAnalyzeData = 
 *  		new J_AnalyzeData2(m_classExperiment);
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
class J_SynExperiment2{
	private int nTemperature;	//
	private int nPressure;		//
	
	/**
	 * 
	 * @param m_nTemperature 
	 * @param m_nPressure 
	 */
	public void updateData(int m_nTemperature,int m_nPressure){
		
		this.nTemperature = m_nTemperature;
		this.nPressure = m_nPressure;
		System.out.println("Update Data: T=" + this.nTemperature + 
				" P=" + this.nPressure);
	}
	
	/**
	 * 
	 */
	public void annalyzeData(){
		
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
	}
}


/**
 * 
 * @author yoyudenghihi
 *
 */
class J_SynAssiantData2 extends Thread{
	
	J_SynExperiment2 classExperiment;	//
	
	public J_SynAssiantData2(J_SynExperiment2 m_classExperiment){
		
		this.classExperiment = m_classExperiment;
	}
	
	public void run(){
		
		int m_nVirtualTemperature;
		int m_nVirtualPressure;
		for(; true; ){
			m_nVirtualTemperature = (int) (Math.random() * 1000);
			m_nVirtualPressure = (int) (Math.random() * 1000);
			synchronized(this.classExperiment){
				this.classExperiment.updateData(m_nVirtualTemperature,
						m_nVirtualPressure);
			}
		}
	}
}


/**
 * 
 * @author yoyudenghihi
 *
 */
class J_SynAnalyzeData2 extends Thread{
	
	J_SynExperiment2 classExperiment;	//
	
	public J_SynAnalyzeData2(J_SynExperiment2 m_classExperiment){
		
		this.classExperiment = m_classExperiment;
	}
	
	public void run(){
		
		for(; true; ){
			synchronized(this.classExperiment){
				this.classExperiment.annalyzeData();
			}
		}
	}
	
}


/**
 * 
 * @author yoyudenghihi
 *
 */
public class J_Synchronized2 {

	/**
	 * 
	 */
	public J_Synchronized2() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		J_SynExperiment2 m_classExperiment = new J_SynExperiment2();
		J_SynAssiantData2 m_classAssiantData = 
			new J_SynAssiantData2(m_classExperiment);
		J_SynAnalyzeData2 m_classAnalyzeData = 
			new J_SynAnalyzeData2(m_classExperiment);
		m_classAssiantData.start();
		m_classAnalyzeData.start();

	}

}