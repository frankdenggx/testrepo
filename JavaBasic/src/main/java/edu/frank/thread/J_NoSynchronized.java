/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * Version: 1.0
 * FileName: J_NoSynchronized
 * Description:
 * 		J_Experiment:
 * 		
 * 		J_Experiment,
 * 		updateData
 * 		analyzeData 
 * 		
 * 		J_AssiantData:
 * 		
 * 
 * 		J_AnalyzeData:
 * 		
 * 
 * 		J_NoSynchronized
 * 		
 * 		
 * 		J_AssiantData m_classAssiantData =
 *  		new J_AssiantData(m_classExperiment);	
 *  	
 *  	J_AnalyzeData m_classAnalyzeData = 
 *  		new J_AnalyzeData(m_classExperiment);
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
class J_Experiment{
	
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
class J_AssiantData extends Thread{
	
	J_Experiment classExperiment;	//
	
	public J_AssiantData(J_Experiment m_classExperiment){
		
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
class J_AnalyzeData extends Thread{
	
	J_Experiment classExperiment;	//
	
	public J_AnalyzeData(J_Experiment m_classExperiment){
		
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
public class J_NoSynchronized {

	/**
	 * 
	 */
	public J_NoSynchronized() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		J_Experiment m_classExperiment = new J_Experiment();
		J_AssiantData m_classAssiantData = 
			new J_AssiantData(m_classExperiment);
		J_AnalyzeData m_classAnalyzeData = 
			new J_AnalyzeData(m_classExperiment);
		m_classAssiantData.start();
		m_classAnalyzeData.start();

	}

}