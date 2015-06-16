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
package edu.frank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import org.apache.log4j.Logger;

import edu.frank.io.UseFile;
import edu.frank.io.UseRandomAccessFile;
import edu.frank.io.UseReaderWriter;
import edu.frank.io.UseSerializable;
import edu.frank.io.UseStream;
import edu.frank.log4j.Log4JConfig;

/**
 * 
 * @author yoyudenghihi
 * 
 */
public class LearnBasicJava_Main {

	private static final Logger logger = Log4JConfig
			.getLogger(LearnBasicJava_Main.class); //

	private static LearnBasicJava_Main instance = null;
	private static UseRandomAccessFile rafInstance = null;
	private static UseReaderWriter rwInstance = null;
	private static UseFile fInstance = null;
	private static UseSerializable serInstance = null;
	private static UseStream streamInstance = null;
	private static ForTesting forTestingInstance = null;

	/**
	 * 
	 */
	public LearnBasicJava_Main() {

	}

	/**
	 * 
	 */
	private void initAllInstance() {
		rafInstance = UseRandomAccessFile.getInstance(); //
		rwInstance = UseReaderWriter.getInstance(); //
		fInstance = UseFile.getInstance(); //
		serInstance = UseSerializable.getInstance(); //
		streamInstance = UseStream.getInstance(); //
		forTestingInstance = ForTesting.getInstance(); // for test instance
	}

	/**
	 * 
	 * @return
	 */
	public static LearnBasicJava_Main getNewInstance() {
		if (null == instance) {
			return new LearnBasicJava_Main();
		} else {
			return instance;
		}
	}

	/**
	 * 
	 */
	public void testIOClass() {
		rafInstance.test();
	}

	/**
	 * IO
	 */
	public void testRWClass() {
		rwInstance.test();
	}

	/**
	 * 
	 */
	public void testFileClass() {
		fInstance.test();
	}

	/**
	 * 
	 */
	public void testSerialClass() {
		serInstance.test();
	}

	/**
	 * 
	 */
	public void testStreamClass() {
		streamInstance.test();
	}

	/**
	 * 
	 * test the method
	 * 
	 * 
	 * @since JavaBasic
	 */
	public void testForTestingClass() {
		forTestingInstance.test();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("main method invoke, application start ...");
		//
		instance = LearnBasicJava_Main.getNewInstance();
		// instance.initAllInstance();

		//
		// instance.testIOClass();

		//
		// instance.testRWClass();

		//
		// instance.testFileClass();

		//
		// instance.testSerialClass();

		//
		// instance.testStreamClass();

		// run ForTesting class
		// instance.testForTestingClass();

		instance.testCallProc();

		logger.debug("application end ...");
		LogService.log("application end ...");
	}

	public void testCallProc() {
		try {
			/*
			 * Connection conn = null; try {
			 * Class.forName("oracle.jdbc.driver.OracleDriver"); conn =
			 * DriverManager
			 * .getConnection("jdbc:oracle:thin:@113.108.203.222:1521:hozdo",
			 * "hzdeas", "hzdeas"); if (conn == null) { throw new
			 * Exception("connection not prepared!"); } Timestamp pMonth = new
			 * Timestamp(DateUtil.parseDate("2013-07-01 00:00:00",
			 * "yyyy-MM-dd HH:mm:ss").getTime()); Timestamp pEndMonth = new
			 * Timestamp(DateUtil.parseDate("2013-10-01 00:00:00",
			 * "yyyy-MM-dd HH:mm:ss").getTime()); CallableStatement proc = null;
			 * proc = conn.prepareCall(
			 * "{call proc_hpsnemonstatement(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"
			 * ); proc.setInt(1, 0); proc.setString(2,
			 * "rwjmM1rwSN+g2ymhwyH8XsHawzE="); proc.setString(3, "3");
			 * proc.setString(4, "VyuE5jXmTse0Ul5Z/RFwZDNy00I=");
			 * proc.setTimestamp(5, pMonth); proc.setTimestamp(6, pEndMonth);
			 * proc.setString(7, null); proc.setString(8,
			 * "00000000-0000-0000-0000-00000000000013B7DE7F");
			 * proc.setTimestamp(9, new Timestamp((new Date()).getTime()));
			 * proc.setString(10, "v4sImjizTAmr3pejnpnkycznrtQ=");
			 * //fun_hpsMonStatement(0, pProId, pBizType, pWhId, 月份, 月份, null,
			 * '00000000-0000-0000-0000-00000000000013B7DE7F', sysdate,
			 * 'v4sImjizTAmr3pejnpnkycznrtQ='); proc.registerOutParameter(11,
			 * Types.VARCHAR); proc.execute(); String retMsg =
			 * proc.getString(11); System.out.println("存储过程返回值: " + retMsg); }
			 * catch (Exception ex) { System.err.println(ex); } finally { if
			 * (conn != null) { conn.close(); } }
			 */
			// 模拟并发
			Thread t1 = new Thread(new TestDBLock("t1"));
			Thread t2 = new Thread(new TestDBLock("t2"));
			t1.start();
			t2.start();

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	class TestDBLock implements Runnable {

		private String id;

		public TestDBLock(String threadId) {
			this.id = threadId;
		}

		@Override
		public void run() {
			try {
				Connection conn = null;
				String sid = null;
				try {
					if (id.equals("t2")) {
						Thread.sleep(3 * 1000L);
					}
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@113.108.203.222:1521:hozdo",
							"hzdeas", "hzdeas");
					if (conn == null) {
						throw new Exception("connection not prepared!");
					}
					System.out.println(id + "conn:" + conn.toString());
					CallableStatement proc = null;
					proc = conn.prepareCall("{call proc_frank_test(?, ?, ?)}");
					proc.setInt(1, 0);

					proc.setString(2, null);
					//proc.setString(3, null);
					proc.registerOutParameter(2, Types.VARCHAR);
					proc.registerOutParameter(3, Types.VARCHAR);
					proc.execute();
					sid = proc.getString(3);
					String handler = proc.getString(2);
					System.out.println(id + "存储过程返回SID: " + sid);
					System.out.println(id + "存储过程返回值: " + handler);
					if (id.equals("t1")) {
						Thread.sleep(60*1000L);
					}
				} catch(Exception e) {
					System.out.println(id + "存储过程返回SID: " + sid);
					System.err.println(e);
				} finally {
					if (conn != null) {
						conn.close();
					}
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

}