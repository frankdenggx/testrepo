/**
 * CopyRight: (C) 2005-2008 GuangZhou Thinker Tech.co.,Ltd. All Right Reserved.
 * Project: LearnBasicJava
 * JDK Version: 1.6.10
 * File Name:
 * File Version:
 * File Description:
 * Author:
 * Date:
 * History:
 * <author>			<time>			<version>			<desc>
 */
package edu.frank.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;


class J_File{

	private static final Logger PRO_LOGGER = Logger.getLogger(J_File.class);
	private String strFilePath = null;
	private String strFileName = null;
	private File file = null;

	public J_File(String m_strFilePath,String m_strFileName){

		strFilePath = m_strFilePath;
		strFileName = m_strFileName;
		file = new File(strFilePath + strFileName);
	}

	public int readFile(){
		if (null == file){
			PRO_LOGGER.debug("file is null");
			return 1;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String strCurrLine = null;
			while(null != (strCurrLine = br.readLine())){
				System.out.println(strCurrLine);
				PRO_LOGGER.error("strCurrLine=" + strCurrLine);
			}
			br.close();
		} catch (FileNotFoundException ex_file_notFound) {
			ex_file_notFound.printStackTrace();
		} catch (IOException ex_file_io) {
			ex_file_io.printStackTrace();
		}
		return 0;
	}

	public int writeFile(){
		if (null == file){
			PRO_LOGGER.debug("file is null");
			return 1;
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for(int i=0; i<10; i++){
				bw.write(i + '0');
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex_thread_interrup) {
					ex_thread_interrup.printStackTrace();
				}
			}
			bw.close();
		} catch (IOException ex_file_io) {
			ex_file_io.printStackTrace();
		}
		return 0;
	}

}


/**
 * @author yoyudenghihi
 *
 */
public class J_ThreadFile implements Runnable {

	private J_File classFile = null;

	/**
	 *
	 */
	public J_ThreadFile() {
	}

	public J_ThreadFile(J_File m_classFile){
		classFile = m_classFile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		if (classFile.writeFile() !=0){
			System.out.println("Write Err");
		}
		if (classFile.readFile() != 0){
			System.out.println("Read Err");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new Log4JConfig("properties");
		J_File m_classFile = new J_File("c:\\","test.txt");
		System.out.println("Program start");
		Thread m_threadA = new Thread(new J_ThreadFile(m_classFile));
		Thread m_threadB = new Thread(new J_ThreadFile(m_classFile));
		m_threadA.start();
		m_threadB.start();
		System.out.println("main method end");
	}

}
