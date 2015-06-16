/**
 * 
 */
package edu.frank.thread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class J_Sort{
	
	public J_Sort(){
		
	}
	
	public void BubbleSort(int[] m_arr){
		if (null != m_arr){
			int i,j,temp;
			int flag = 1;
			for (i = 0; i < m_arr.length && flag == 1; i++){
				flag = 0;
				for (j = 0; j < m_arr.length -1; j++){
					if (m_arr[j] > m_arr[j+1]){
						flag = 1;
						temp = m_arr[j];
						m_arr[j] = m_arr[j+1];
						m_arr[j+1] = temp;
					}
				}
			}
		}
	}
	
	public void QuickSort(int[] m_arr,int low,int high){
		if (null != m_arr){
			int i,j,temp;
			i = low;
			j = high;
			temp = m_arr[i];	//
			
			while(i<j){
				//
				while(i<j && temp <=m_arr[j]) j--;
				if (i < j){
					m_arr[i] = m_arr[j];
					i++;
				}
				//
				while(i < j && m_arr[i] < temp) i++;
				if (i < j){
					m_arr[j] = m_arr[i];
					j--;
				}
			}
			m_arr[i] = temp;
			if (low < i)
				QuickSort(m_arr,low,i-1);
			if (i < high)
				QuickSort(m_arr,j+1,high);
			
			
		}
	}
}

class J_BubbleSort extends Thread{
	
	private J_Sort classSort;
	private int[] arrData = null;
	
	public J_BubbleSort(){
		
	}
	
	public J_BubbleSort(J_Sort m_classSort,int[] m_arrData){
		this.classSort = m_classSort;
		this.arrData = m_arrData;
	}
	
	public void run(){
		long m_nStartTime = System.currentTimeMillis();
		classSort.BubbleSort(arrData);
		long m_nEndTime = System.currentTimeMillis();
		//System.out.println("Bubble:" + (m_nEndTime - m_nStartTime) + "MS");
	}
}

class J_QuickSort extends Thread{
	
	private J_Sort classSort;
	private int[] arrData = null;
	private int nLow = 0;
	private int nHigh = 0;
	
	public J_QuickSort(){
		
	}
	
	public J_QuickSort(J_Sort m_classSort,int[] m_arrData,int m_nLow,
				int m_nHigh){
		this.classSort = m_classSort;
		this.arrData = m_arrData;
		this.nLow = m_nLow;
		this.nHigh = m_nHigh;
	}
	
	public void run(){
		long m_nStartTime = System.currentTimeMillis();
		classSort.QuickSort(arrData, nLow, nHigh);
		long m_nEndTime = System.currentTimeMillis();
		System.out.println("Quack:" + (m_nEndTime - m_nStartTime) + "MS");
	}
}

/**
 * @author yoyudenghihi
 *
 */
public class J_ThreadSort {

	/**
	 * 
	 */
	public J_ThreadSort() {

		// TODO Auto-generated constructor stub
	}
	
	public static void showArray(int[] m_arrData){
		if (null != m_arrData){
			for (int i = 0; i < m_arrData.length; i++){
				System.out.print(m_arrData[i] + " ");
				if (i%10 == 0)
					System.out.println();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] m_arrData1 = null;
		int[] m_arrData2 = null;
		int m_nLength = 0;

		do{
			m_nLength = (int)(Math.random() *100000);
		}while(m_nLength < 10000);
		m_arrData1 = new int[m_nLength];
		m_arrData2 = new int[m_nLength];
		for (int i = 0; i < m_nLength; i++){
			m_arrData1[i] = (int)(Math.random() * 100000);
			m_arrData2[i] = m_arrData1[i];
		}
		
		try {
			System.setOut(new PrintStream(new FileOutputStream("test.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("program start...");
		J_Sort m_classSort = new J_Sort();
		J_BubbleSort m_threadBubbleSort = new J_BubbleSort(m_classSort,
					m_arrData1);
		J_QuickSort m_threadQuickSort = new J_QuickSort(m_classSort,
				m_arrData2,0,m_nLength-1);
		m_threadBubbleSort.start();
		m_threadQuickSort.start();
		if (!m_threadBubbleSort.isAlive() && m_threadQuickSort.isAlive()){
			System.out.println("m_threadBubbleSort is quick");
		}
		if (!m_threadQuickSort.isAlive() && m_threadBubbleSort.isAlive()){
			System.out.println("m_threadQuickSort is quick");
		}
		showArray(m_arrData2);
		System.out.println("program end...");
	}

}
