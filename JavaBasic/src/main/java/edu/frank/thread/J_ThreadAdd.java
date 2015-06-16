/**
 * 
 */
package edu.frank.thread;

class accumulator{
	private int nThreadId = -1;
	
	protected synchronized void addOption(int m_nThreadId,int[] m_temps,
			int m_nStart,int m_nMax){
		nThreadId = m_nThreadId;
		int dResult = 0;
		long m_lStartTime = System.currentTimeMillis();
		for(int i=m_nStart; i<m_nMax;i++){
			dResult += m_temps[i];
		}
		long m_lEndTime = System.currentTimeMillis();
		System.out.println("ThreadId=" + nThreadId + " Result=" + dResult +
				" Time=" + (m_lEndTime - m_lStartTime) + "MS");
	}
	
}

class forAccumulator extends Thread{
	accumulator acc = null;
	private int[] temps = null;
	private int nStart = 0;
	private int nMax = 0;
	private int nThreadId = -1;
	
	public forAccumulator(accumulator m_acc,int[] m_temps,
			int m_nStart,int m_nMax,int m_nThreadId){
		this.acc = m_acc;
		this.temps = m_temps;
		this.nStart = m_nStart;
		this.nMax = m_nMax;
		this.nThreadId = m_nThreadId;
	}
	
	public void run(){
		acc.addOption(nThreadId,temps,nStart,nMax);
	}
}

/**
 * @author yoyudenghihi
 *
 */
public class J_ThreadAdd{
	
	public J_ThreadAdd(){
		
	}
	
	public static void main(String[] args){
		int m_nRandom = 0;
		int m_dResult = 0;
		do{
			m_nRandom = (int)(Math.random()*10000000);
		}while(m_nRandom<1000000);
		int[] m_dRandoms = new int[m_nRandom];
		for(int i = 0; i < m_nRandom; i++){
			m_dRandoms[i] = (int)(Math.random()*10);
		}
		long m_lStartTime = System.currentTimeMillis();
		for(int i = 0; i < m_nRandom; i++){
			m_dResult += m_dRandoms[i];
		}
		long m_lEndTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("Num=" +m_nRandom + " Result=" + m_dResult + " Time=" + 
				(m_lEndTime - m_lStartTime) + "MS");
		System.out.println("");
		accumulator acc = new accumulator();
		forAccumulator th1 = new 	forAccumulator(acc,m_dRandoms,0,m_nRandom/2,1);
		forAccumulator th2 = new forAccumulator(acc,m_dRandoms,m_nRandom/2,m_nRandom,2);
		th1.start();
		th2.start();	
	}
}
