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

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import edu.frank.common.Tools;

/**
 * 
 *
 * @author denggx
 * @see java.io.Serializable
 */
class Student implements Serializable {
	/**
	 * ID
	 */
	private static final long serialVersionUID = -3539844060765844870L;

	String strName = null;
	String persionId = "1000001";
	static long postalCode = 526109;
	int nId = -1;
	int nHeight = -1;
	transient long noSerializedInfo = 1000;
	static transient long staticSerializedInfo = 5000;

	public Student() {
		this.persionId = Tools.getUID();
	}

	/**
	 * 
	 */
	public void outStuInfo() {
		System.out.println("persion id:" + this.persionId);
		System.out.println("postal code:" + postalCode);
		System.out.println("student id:" + this.nId);
		System.out.println("student name:" + this.strName);
		System.out.println("student height:" + this.nHeight);
		System.out.println("student noSerializedInfo:" + this.noSerializedInfo);
		System.out.println("student staticSerializedInfo:" + staticSerializedInfo);
	}
}

/**
 * 
 *
 * @author denggx
 *
 */
public class UseSerializable {

	private static UseSerializable instance = null;

	/**
	 * 
	 */
	public UseSerializable() {
	}

	/**
	 * 
	 *
	 * @return 
	 */
	public static UseSerializable getInstance() {
		if (null == instance) {
			instance = new UseSerializable();
		}
		return instance;
	}

	/**
	 * 
	 *
	 * @param file
	 *            
	 * @param oos
	 *            
	 * @throws Exception
	 *             IllegalArgumentException <br/>
	 *             IOException IO
	 */
	public void writeObject(File file, ObjectOutputStream oos) throws Exception {
		if (null == file || !file.exists()) {
			throw new IllegalArgumentException("File error!");
		}
		if (!file.canWrite()) {
			throw new IllegalArgumentException("File error!");
		}
		try {
			if (null == oos) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
			}
			Student student = new Student();
			student.persionId = "1000001";
			student.nId = 10001;
			student.strName = "Zhang Foshan";
			student.nHeight = 176;
			oos.writeObject(student); // 
			oos.close();
		} catch (IOException ex) {
			throw new IOException(ex);
		}

	}

	/**
	 * 
	 *
	 * @param file
	 *            
	 * @param ois
	 *            
	 * @return 
	 * @throws Exception
	 *             IllegalArgumentException <br/>
	 *             IOException IO
	 */
	public Object readObject(File file, ObjectInputStream ois) throws Exception {
		Object obj = null;
		if (null == file || !file.exists()) {
			throw new IllegalArgumentException("File error!");
		}
		if (!file.canWrite()) {
			throw new IllegalArgumentException("File error!");
		}

		try {
			if (null == ois) {
				ois = new ObjectInputStream(new FileInputStream(file));
			}
			obj = ois.readObject();
		} catch (EOFException e) {
			return obj;
		} catch (IOException ex) {
			throw new IOException(ex);
		} finally {
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException ex) {
					throw new IOException(ex);
				}
			}
			ois = null;
		}
		return obj;
	}

	/**
	 * 
	 */
	public void test() {
		File file = null;
		try {
			file = new File("E:\\test\\student.dat");
			if (null != file) {
				if (!file.exists()) {
					file.createNewFile();
				}
			}
			writeObject(file, null);
			Student student = (Student) readObject(file, null);
			student.outStuInfo();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}