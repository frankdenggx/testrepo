/**
 * Copy Right: (c) 2005-2008 Thinker Tech.Co.,Ltd., All Right Reserved.
 * Project Name: Practice
 * JDK Version: 1.6.15
 * File Version: 1.0
 * Description:
 * Date
 * Author:
 * History:
 * <author>			<time>			<version>			<desc>
 * 
 */
package edu.frank.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author yoyudenghihi
 *
 */
public class Practice5_1 {
	
	/**
	 * 
	 */
	public Practice5_1() {

		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public static void addNum(){
		System.out.print("Please input an integer:");
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(System.in));
		while(null == in){
			System.out.print("Please input an integer:");
		}
		if (null != in){
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		addNum();

	}

}
