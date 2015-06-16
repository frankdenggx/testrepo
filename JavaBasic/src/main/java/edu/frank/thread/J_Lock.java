/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co,Ltd. All Right Reserved.
 * Version: 1.0
 * FileName: J_Lock
 * Description:
 * 		
 * 		
 * 		
 * 		
 * 		AclassDataAclassDataB
 * 		BclassDtaAclassDataB
 * 		
 * Author: yoyudenghihi
 * History:
 * <author>			<time>				<version>					<desc>
 * yoyudenghihi		2009.09.14			1.0						Create
 */
package edu.frank.thread;

/**
 * <br>
 * @author yoyudenghihi
 *
 */
class J_Data{
	
	/**
	 * 
	 */
	public void goLongTime(){
		for(int i=0; i<100; i++){
//			double dSinResult = Math.sin(i);
//			int nTemp = (int) dSinResult + i;
//			i = nTemp - (int) dSinResult;
			Math.sin(i);
		}
	}
	
}

/**
 * A
 * @author yoyudenghihi
 *
 */
class J_ThreadA extends Thread {

	J_Data classDataA;
	J_Data classDataB;

	public J_ThreadA(J_Data classDataA, J_Data classDataB) {

		this.classDataA = classDataA;
		this.classDataB = classDataB;
	}

	@Override
	public void run() {

		for (; true;) {
			synchronized (this.classDataA) {
				System.out.println("J_ThreadA Lock classDataA");
				this.classDataA.goLongTime();
				synchronized (this.classDataB) {
					System.out.println("J_ThreadB Lock classDataB");
					this.classDataA.goLongTime();
					this.classDataB.goLongTime();
				}
			}
			System.out.println("J_ThreadA free both classDataA and classDataB");
		}
	}

}

/**
 * B
 * @author yoyudenghihi
 *
 */
class J_ThreadB extends Thread{
	
	J_Data classDataA;
	J_Data classDataB;
	
	public J_ThreadB(J_Data classDataA,J_Data classDataB){
		
		this.classDataA = classDataA;
		this.classDataB = classDataB;
	}
	
	@Override
	public void run(){
		
		for(;true;){
			synchronized(this.classDataB){
				System.out.println("J_ThreadB Lock classDataB");
				this.classDataB.goLongTime();
				synchronized(this.classDataA){
					System.out.println("N_ThreadB Lock classDataA");
					this.classDataA.goLongTime();
					this.classDataB.goLongTime();
				}
			}
			System.out.println("J_ThreadB free both classDataA and classDataB");
		}
	}
	
}


/**
 * 
 * @author yoyudenghihi
 *
 */
public class J_Lock {

	/**
	 * 
	 */
	public J_Lock() {

		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		J_Data dataA = new J_Data();
		J_Data dataB = new J_Data();
		J_ThreadA threadA = new J_ThreadA(dataA,dataB);
		J_ThreadB threadB = new J_ThreadB(dataA,dataB);
		threadA.start();
		threadB.start();
	}

}