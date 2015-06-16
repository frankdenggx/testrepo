/**
 * Hotel 1802
 * LearnBasicJava
 * JDK1.6.0_10
 * 2010-05-31
 * denggx
 * 1.0
 * IO Stream
 * 
 * <>				<>				<>
 */
package edu.frank.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * IO Stream
 * @author denggx
 *
 */
public class UseStream {
	
	private static UseStream instance = null;	//

	/**
	 * 
	 */
	public UseStream() {
	}

	/**
	 * 
	 * @return 
	 */
	public static UseStream getInstance(){
		if (null == instance)
			instance = new UseStream();
		return instance;
	}
	
	/**
	 * InputStream
	 * @param in 
	 * @throws IOException IO
	 */
	public void readIS(InputStream in) throws IOException {
		
		while (true){
			int nRead = in.read();
			if (nRead == -1)
				return;
			char cRead = (char) nRead;
			System.out.print(cRead);
			in.close();
		}
		
		/*
		String str = null;
		while (true){
			int nAvail = in.available();	//
			if (nAvail > 0){
				byte[] bRead = new byte[nAvail];
				int nRead = in.read(bRead);
				if (nRead == -1)
					return;
				str = new String(bRead,0,bRead.length);
				System.out.print(str);
			}
			
		}
		*/

	}
	
	/**
	 * OutputStream
	 * @param os 
	 * @throws IOException IO
	 */
	public void WriteOS(OutputStream os) throws IOException {
		String str = "I am a student!";
		byte[] bWrite = str.getBytes();
		os.write(bWrite);
		os.flush();
		os.close();
	}
	
	/**
	 * FileInputStream
	 * @param fis 
	 * @throws IOException IO
	 */
	public void readFS(FileInputStream fis) throws IOException {
		fis = new FileInputStream("E:\\test\\stream.txt");
		int nRead = -1;
		while((nRead = fis.read()) != -1){
			char cRead = (char) nRead;
			System.out.print(cRead);
		}
		System.out.println();
		fis.close();
	}
	
	/**
	 * FileOutputStream
	 * @param fos 
	 * @throws IOException IO
	 */
	public void writeFS(FileOutputStream fos) throws IOException {
		fos = new FileOutputStream("E:\\test\\stream.txt",true);
		String str = "";
		byte[] bWrite = str.getBytes();
		fos.write(bWrite);
		fos.close();
	}
	
	/**
	 * PrintStream
	 * @param ps 
	 * @throws IOException IO
	 */
	public void writePS(PrintStream ps) throws IOException {
		ps = new PrintStream(new FileOutputStream("E:\\test\\stream.txt"));
		String str = "";
		ps.println(str);
		ps.close();
	}
	
	/**
	 * 
	 * @throws IOException IO
	 */
	public void tryRedirection() {
		try{
			System.setIn(new FileInputStream("E:\\test\\stream.txt"));
			while (true){
				int i = System.in.read();
				if (i == -1)
					return;
				char c = (char) i;
				System.out.print(c);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param dis 
	 * @throws IOException IO
	 */
	public void readDIS(DataInputStream dis) throws IOException {
		dis = new DataInputStream(new FileInputStream("E:\\test\\stream.txt"));
		byte b;
		while(true){
			try{
				b = dis.readByte();
				b -=(byte) '0';
				System.out.print(b);
			}catch(EOFException ex){
				System.out.println();
				break;
			}
			
		}
		dis.close();
	}
	
	/**
	 * 
	 * @param dos 
	 * @throws IOException IO
	 */
	public void writeDOS(DataOutputStream dos) throws IOException {
		int b;
		dos = new DataOutputStream(new FileOutputStream("E:\\test\\stream.txt"));
		for (b=0; b<5; b++){
			dos.writeByte(b + '0');
		}
		dos.close();
	}
	
	/**
	 * 
	 * @param bis 
	 * @throws IOException IO
	 */
	public void readBIS(BufferedInputStream bis) throws IOException {
		bis = new BufferedInputStream(new FileInputStream("E:\\test\\stream.txt"));
		byte[] bRead = new byte[1024];
		String strRead = "";
		String strTemp = null;
		while(bis.read(bRead) != -1){
			strTemp = new String(bRead);
			strRead += strTemp;
		}
		System.out.println(strRead);
		bis.close();
	}
	
	/**
	 * 
	 * @param bos 
	 * @throws IOException IO
	 */
	public void writeBOS(BufferedOutputStream bos) throws IOException {
		bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\stream.txt"));
		String str = "";
		byte[] bWrite = str.getBytes();
		bos.write(bWrite);
		bos.close();
	}
	
	/**
	 * 
	 */
	public void test(){
		//this.tryRedirection();

		try {
			//this.readIS(System.in);
			//this.WriteOS(System.out);
			//this.readFS(null);
			//this.writeFS(null);
			//this.writePS(null);
			readBIS(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
