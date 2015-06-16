/**
 * Hotel 1802
 * LearnBasicJava
 * JDK1.6.0_10
 * 2010-05-31
 * denggx
 * 1.0
 * ReaderWriter
 * 
 * <>				<>				<>
 */
package edu.frank.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  
 * @author yoyu
 *
 */
public class UseReaderWriter {

	private static UseReaderWriter instance = null;	//
	
	/**
	 * 
	 */
	public UseReaderWriter(){
		
	}
	
	/**
	 * 
	 * @return 
	 */
	public static UseReaderWriter getInstance(){
		if (null == instance){
			instance = new UseReaderWriter();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param file 
	 * @param fileReader  NULL
	 * @return 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public String readFileFR(File file,FileReader fileReader) throws Exception {
		String strFileContent = null;
		String strTemp = null;
		char[] cBuff = null;
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canRead()){
			throw new IllegalArgumentException("The file can't read!");
		}
		try{
			cBuff = new char[1024];
			if (null == fileReader)
				fileReader = new FileReader(file);
			strFileContent = "";
			while((fileReader.read(cBuff)) != -1){
				strTemp = new String(cBuff);
				strFileContent = strFileContent + strTemp;
			}
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != fileReader){
				try{
					fileReader.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
			}
		}
		return strFileContent;
	}
	
	/**
	 * 
	 * @param file 
	 * @param fileWriter 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public void writeFileFW(File file,FileWriter fileWriter,String strWriter) 
		throws Exception {
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canWrite()){
			throw new IllegalArgumentException("The file can't be written!");
		}
		
		try{
			if (null == fileWriter)
				fileWriter = new FileWriter(file);
			fileWriter.write(strWriter);
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != fileWriter){
				try{
					fileWriter.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
				fileWriter = null;
			}
		}
	}
	
	/**
	 * BufferedReader
	 * @param file 
	 * @param buffReader BufferedReader󣨻
	 * @return 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public String readFileBR(File file,BufferedReader buffReader) throws Exception {
		String strFileContent = null;
		String strTemp = null;
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canRead()){
			throw new IllegalArgumentException("The file can't read!");
		}
		try{
			if (null == buffReader)
				buffReader = new BufferedReader(new FileReader(file));
			strFileContent = "";
			while((strTemp = buffReader.readLine()) != null){
				strFileContent = strFileContent + strTemp;
			}
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != buffReader){
				try{
					buffReader.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
			}
		}
		return strFileContent;
	}
	
	/**
	 * BufferedWriter
	 * @param file 
	 * @param buffWriter BufferedWriter󣨻
	 * @param strWriter 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public void writeFileBW(File file,BufferedWriter buffWriter,String strWriter) 
		throws Exception {
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canWrite()){
			throw new IllegalArgumentException("The file can't be written!");
		}
		
		try{
			if (null == buffWriter)
				buffWriter = new BufferedWriter(new FileWriter(file));
			buffWriter.write(strWriter);
			buffWriter.newLine();
			buffWriter.flush();
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != buffWriter){
				try{
					buffWriter.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
				buffWriter = null;
			}
		}
	}
	
	/**
	 * PrintWriter
	 * @param file 
	 * @param ptWriter PrintWriter󣨶
	 * @param strWriter 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public void writeFilePW(File file,PrintWriter ptWriter,String strWriter) 
		throws Exception {
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canWrite()){
			throw new IllegalArgumentException("The file can't be written!");
		}
		
		if (null == ptWriter)
			ptWriter = new PrintWriter(new FileWriter(file));
		ptWriter.println(strWriter);
		if (ptWriter.checkError())
			throw new IOException("Write file error!");
		ptWriter.close();
	}
	
	/**
	 * 
	 */
	public void test(){
		String strFileContent = null;
		File file = null;
		String strWriter = null;
		try{
			file = new File("E:\\rwInstance.txt");
			
			//FileReader
			strFileContent = this.readFileFR(file,null);
			if (null != strFileContent)
				System.out.println("rwInstance File:\n" + strFileContent);
			
			//FileWriter
			strWriter = "I am a boy!";
			this.writeFileFW(file, null, strWriter);
			
			//BufferedReader
			strFileContent = this.readFileBR(file, null);
			if (null != strFileContent)
				System.out.println("rwInstance File:\n" + strFileContent);
			
			//BufferedWriter
			strWriter = "";
			this.writeFileBW(file,null,strWriter);
			
			//PrintWriter
			strWriter = "";
			this.writeFilePW(file, null, strWriter);
			
			//BufferedReader
			strFileContent = this.readFileBR(file, null);
			if (null != strFileContent)
				System.out.println("rwInstance File:\n" + strFileContent);
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	
	
}
