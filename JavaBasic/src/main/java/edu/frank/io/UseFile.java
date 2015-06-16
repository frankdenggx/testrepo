/**
 * Hotel 1802
 * LearnBasicJava
 * JDK1.6.0_10
 * 2010-05-31
 * denggx
 * 1.0
 * 
 * 
 * <>				<>				<>
 */
package edu.frank.io;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author yoyu
 *
 */
public class UseFile {

	private static UseFile instance = null;
	
	/**
	 * 
	 */
	public UseFile() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return 
	 */
	public static UseFile getInstance(){
		if (null == instance){
			instance = new UseFile();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public void test(){
		File file = null;
		File dir = null;
		try{
			//
			dir = new File("E:\\test\\");
			if (!dir.exists())
				dir.mkdir();
			System.out.println(":" + dir.getAbsolutePath());	//
			System.out.println(":" + dir.getCanonicalPath());//
			System.out.println(":" + dir.isHidden());//
			
			
			//
			file = new File("E:\\test\\file.txt");
			if (!file.exists())
				file.createNewFile();
			System.out.println(":" + file.getAbsolutePath());	//
			System.out.println(":" + file.getCanonicalPath());//
			System.out.println(":" + file.isHidden());//
			System.out.println(":" + file.getName());
			System.out.println(":" + file.getPath());
			System.out.println(":" + file.getTotalSpace());
			System.out.println(":" + file.getFreeSpace());
			System.out.println(":" + file.getUsableSpace());
			System.out.println(":" + file.getParent());
		}catch(IOException ex){
			System.out.println(ex.toString());
		}
	}

}
