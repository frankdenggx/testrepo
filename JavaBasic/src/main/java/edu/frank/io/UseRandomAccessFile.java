/**
 * Hotel 1802
 * LearnBasicJava
 * JDK1.6.0_10
 * 2010-05-31
 * denggx
 * 1.0
 * RandomAccessFile
 * 
 * <>				<>				<>
 */
package edu.frank.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * @author yoyu
 *
 */
public class UseRandomAccessFile {
	
	private static UseRandomAccessFile newInstance = null;	//
	private RandomAccessFile rafFile = null;	//
	
	/**
	 * 
	 */
	public UseRandomAccessFile(){
		
	}
	
	/**
	 * 
	 * @return 
	 */
	public static UseRandomAccessFile getInstance(){
		if (null == newInstance){
			newInstance = new UseRandomAccessFile();
		}
		return newInstance;
	}
	
	/**
	 * 
	 * @param file 
	 * @return 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public String readFile(File file) throws Exception {
		long lFilePointer = -1;
		long lFileLength = 0;
		String strRead = null;
		String strTemp = null;
		byte[] byteRead = null;
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canRead()){
			throw new IllegalArgumentException("The file can't read!");
		}
		try{
			rafFile = new RandomAccessFile(file,"r");
			if (null != rafFile){
				lFileLength = rafFile.length();
				byteRead = new byte[2048];
				strRead = "";
				do{
					rafFile.read(byteRead, 0, 2048);
					strTemp = new String(byteRead);
					strRead = strRead + strTemp;
					lFilePointer = rafFile.getFilePointer();
				}while(lFilePointer < lFileLength);
				
			}
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != rafFile){
				try{
					rafFile.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
				rafFile = null;
			}
		}
		
		return strRead;
		
	}
	
	/**
	 * 
	 * @param strFileName 
	 * @return 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public String readFile(String strFileName) throws Exception{
		long lFilePointer = -1;
		long lFileLength = 0;
		String strRead = null;
		String strTemp = null;
		byte[] byteRead = null;
		if (null == strFileName || strFileName.length() <= 0 ){
			throw new IllegalArgumentException("The file name is wrong!");
		}
		try{
			rafFile = new RandomAccessFile(strFileName,"r");
			if (null != rafFile){
				lFileLength = rafFile.length();
				byteRead = new byte[2048];
				strRead = "";
				do{
					rafFile.read(byteRead, 0, 2048);
					strTemp = new String(byteRead);
					strRead = strRead + strTemp;
					lFilePointer = rafFile.getFilePointer();
				}while(lFilePointer < lFileLength);
				
			}
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != rafFile){
				try{
					rafFile.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
				rafFile = null;
			}
		}
		
		return strRead;
	}
	
	/**
	 * 
	 * @param file 
	 * @param strWrite 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public void writeFile(File file,String strWrite) throws Exception {
		byte[] byteWrite = null;
		if (null == file || !file.exists() || !file.isFile()){
			throw new IllegalArgumentException("The file is wrong!");
		}
		if (!file.canWrite()){
			throw new IllegalArgumentException("The file can't be written!");
		}
		if (null == strWrite || strWrite.length() <= 0){
			throw new IllegalArgumentException("Nothing can't be written!");
		}
		
		try{
			rafFile = new RandomAccessFile(file,"rw");
			byteWrite = strWrite.getBytes();
			if (rafFile.length() > 0){
				rafFile.seek(rafFile.length());
				rafFile.writeChars("\n");
			}
			rafFile.seek(rafFile.length());
			rafFile.write(byteWrite);
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != rafFile){
				try{
					rafFile.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
				rafFile = null;
			}
		}
	}
	
	/**
	 * 
	 * @param strFileName 
	 * @param strWrite 
	 * @throws Exception IllegalArgumentException <br/>
	 * 					 IOException 
	 */
	public void writeFile(String strFileName,String strWrite) throws Exception {
		byte[] byteWrite = null;
		if (null == strFileName || strFileName.length() <= 0){
			throw new IllegalArgumentException("The file name is wrong!");
		}
		if (null == strWrite || strWrite.length() <= 0){
			throw new IllegalArgumentException("Nothing can't be written!");
		}
		
		try{
			rafFile = new RandomAccessFile(strFileName,"rw");
			byteWrite = strWrite.getBytes();
			if (rafFile.length() > 0){
				rafFile.seek(rafFile.length());
				rafFile.writeChars("\n");
			}
			rafFile.seek(rafFile.length());
			rafFile.write(byteWrite);
		}catch(IOException ex){
			throw new IOException(ex);
		}finally{
			if (null != rafFile){
				try{
					rafFile.close();
				}catch(IOException ex){
					throw new IOException("Can't close file!");
				}
				rafFile = null;
			}
		}
	}
	
	/**
	 * 
	 */
	public void test(){
		String strWriteContent = null;
		String strFileContent = null;
		String strFileName = null;
		File file = null;
		
		try{
			file = new File("E:\\my_test.txt");
			strFileName = "E:\\my_test.txt";
			strWriteContent = "I am a student!";
			this.writeFile(file, strWriteContent);
			strFileContent = this.readFile(file);
			if (null != strFileContent)
				System.out.println("File:\n" + strFileContent);
			strWriteContent = "";
			this.writeFile(strFileName,strWriteContent);
			strFileContent = this.readFile(strFileName);
			if (null != strFileContent)
				System.out.println("File:\n" + strFileContent);
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
	

}
