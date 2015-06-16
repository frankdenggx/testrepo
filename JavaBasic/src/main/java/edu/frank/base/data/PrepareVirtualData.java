/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 *  HOTEL1802 STUDIO 
 *
 * 
 * 
 *
 */

/**
 *  : <HOTEL1802 STUDIO>
 * JDK  : <1.6.10>
 *  : <JavaBasic>
 *
 *  : <edu.frank.base.data>
 *  : <PrepareVirtualData.java>
 *  : 1.0
 * <>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-9-26 16:27:46>
 *  :
 * <>				<>					<>
 * Frank Deng			2011-09-26					
 *
 */
package edu.frank.base.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import edu.frank.common.Tools;
import edu.frank.common.db.DBConnectionManager;
import edu.frank.common.db.DbRegistryTypeEnum;
import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-9-26	16:27:46> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class PrepareVirtualData implements Runnable {

	private static final Logger logger = Log4JConfig
			.getLogger(PrepareVirtualData.class);
	private static final String DB_POOL_NAME = "JavaBasicPool";
	int threadId = -1;
	java.sql.Connection conn;
	String table;
	String[] keys;
	Object[] values;
	int count;
	static DBConnectionManager instance;

	/**
	 *
	 * <  <code>PrepareVirtualData</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 04:27:46> 		<p>
	 * <> 			<p>
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public PrepareVirtualData(int threadId, java.sql.Connection conn, String table,
			String[] keys, Object[] values, int count)
			throws java.sql.SQLException, Exception {
		this.threadId = threadId;
		this.conn = conn;
		this.table = table;
		this.keys = keys;
		this.values = values;
		this.count = count;
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 04:28:06>		<p>
	 * <>			<p>
	 *
	 * @param args
	 *				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String[] EMPLOYEE_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID",
				"T_NO", "T_NAME", "T_CREATETIME", "T_DESC", "EMP_SEX",
				"EMP_AGE", "EMP_PHONE", "EMP_TELE", "EMP_EMAIL", "EMP_ZIP",
				"EMP_ADDR", "DETP_FID", "DEPT_NO" };

		Object[] EMPLOYEE_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", 1, 20, "(020)83039876",
				"15920496057", "xy@hotmail.com", 510000, ":",
				null, null };

		String[] DEPARTMENT_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID",
				"T_NO", "T_NAME", "T_CREATETIME", "T_DESC", "DEPT_PARENT",
				"DEPT_MEMBER", "DEPT_MANAGER", "DEPT_PHONE", "DEPT_FAX",
				"DEPT_RESPONSIBILITY" };

		Object[] DEPARTMENT_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", null,
				(new java.util.Random()).nextInt(10) * 10 + 5, "DEPT_MANAGER",
				"(020)83039877", "(020)83039877", ":" };

		String[] CUSTOMER_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID",
				"T_NO", "T_NAME", "T_CREATETIME", "T_DESC", "CUST_REP",
				"CUST_MANAGER", "CUST_CONTACT", "CUST_PHONE", "CUST_TELE",
				"CUST_FAX", "CUST_EMAIL", "CUST_ZIP", "CUST_ADDR" };

		Object[] CUSTOMER_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", "CUST_REP", "CUST_MANAGER",
				":", "(020)83039878", "15920496058", "(020)83039878",
				"xy@gmail.com", "526100", ":" };

		String[] PROJECT_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID", "T_NO",
				"T_NAME", "T_CREATETIME", "T_DESC", "PRO_REP", "PRO_MANAGER",
				"CUST_FID", "CUST_NO", "PRO_EXECUTOR", "DEPT_FID", "DEPT_NO",
				"PRO_STARTDATE", "PRO_ENDDATE", "PRO_CONTENT" };

		Object[] PROJECT_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", "PRO_REP", "PRO_MANAGER", null,
				null, ":", null, null,
				DateUtils.addDays(new java.util.Date(), -3),
				new java.util.Date(), ":" };

		String[] SYSENUM_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID", "T_NO",
				"T_NAME","T_CREATETIME", "T_DESC", "ENUM_CATE",
				"ITEM_NAME", "ITEM_ALIAS", "ITEM_VALUE"};

		Object[] SYSENUM_VALUES = new Object[] { null, "T_FID", -1, "item", new java.util.Date(),
				"item:", "1", "item", "item", "0"};

		try {
			instance = DBConnectionManager
					.getInstance(DbRegistryTypeEnum.PROPERTIES);
			/*java.sql.Connection conn1 = instance.getConnection(DB_POOL_NAME);
			java.sql.Connection conn2 = instance.getConnection(DB_POOL_NAME);
			java.sql.Connection conn3 = instance.getConnection(DB_POOL_NAME);
			java.sql.Connection conn4 = instance.getConnection(DB_POOL_NAME);*/
			java.sql.Connection conn5 = instance.getConnection(DB_POOL_NAME);
			/*Thread employeeThread = new Thread(new PrepareVirtualData(101, conn1,
					"employee", EMPLOYEE_COLUMN_KEYS, EMPLOYEE_VALUES, 100000));
			Thread departmentThread = new Thread(new PrepareVirtualData(102, conn2,
					"department", DEPARTMENT_COLUMN_KEYS, DEPARTMENT_VALUES,
					100000));
			Thread customerThread = new Thread(new PrepareVirtualData(103, conn3,
					"customer", CUSTOMER_COLUMN_KEYS, CUSTOMER_VALUES, 100000));
			Thread projectThread = new Thread(new PrepareVirtualData(104, conn4,
					"project", PROJECT_COLUMN_KEYS, PROJECT_VALUES, 100000));*/
			Thread sysenumThread = new Thread(new PrepareVirtualData(105, conn5,
					"sysenum", SYSENUM_COLUMN_KEYS, SYSENUM_VALUES, 100000));
			/*logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>> 101 Starting ... ");
			employeeThread.start();
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>> 102 Starting ... ");
			departmentThread.start();
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>> 103 Starting ... ");
			customerThread.start();
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>> 104 Starting ... ");
			projectThread.start();*/
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>> 105 Starting ... ");
			sysenumThread.start();
		} catch (java.sql.SQLException ex) {
			logger.error("SQL Exception : ", ex);
		} catch (Exception ex) {
			logger.error("Exception: ", ex);
		}
		//prepareData();
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-27 03:41:28>		<p>
	 * <>			<p>
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public static void prepareData(java.sql.Connection conn) {
		/*String poolName = "JavaBasicPool";

		String[] EMPLOYEE_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID",
				"T_NO", "T_NAME", "T_CREATETIME", "T_DESC", "EMP_SEX",
				"EMP_AGE", "EMP_PHONE", "EMP_TELE", "EMP_EMAIL", "EMP_ZIP",
				"EMP_ADDR", "DETP_FID", "DEPT_NO" };

		Object[] EMPLOYEE_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", 1, 20, "(020)83039876",
				"15920496057", "xy@hotmail.com", 510000, ":",
				null, null };

		String[] DEPARTMENT_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID",
				"T_NO", "T_NAME", "T_CREATETIME", "T_DESC", "DEPT_PARENT",
				"DEPT_MEMBER", "DEPT_MANAGER", "DEPT_PHONE", "DEPT_FAX",
				"DEPT_RESPONSIBILITY" };

		Object[] DEPARTMENT_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", null,
				(new java.util.Random()).nextInt(10) * 10 + 5, "DEPT_MANAGER",
				"(020)83039877", "(020)83039877", ":" };

		String[] CUSTOMER_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID",
				"T_NO", "T_NAME", "T_CREATETIME", "T_DESC", "CUST_REP",
				"CUST_MANAGER", "CUST_CONTACT", "CUST_PHONE", "CUST_TELE",
				"CUST_FAX", "CUST_EMAIL", "CUST_ZIP", "CUST_ADDR" };

		Object[] CUSTOMER_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", "CUST_REP", "CUST_MANAGER",
				":", "(020)83039878", "15920496058", "(020)83039878",
				"xy@gmail.com", "526100", ":" };

		String[] PROJECT_COLUMN_KEYS = new String[] { "T_SEQ", "T_FID", "T_NO",
				"T_NAME", "T_CREATETIME", "T_DESC", "PRO_REP", "PRO_MANAGER",
				"CUST_FID", "CUST_NO", "PRO_EXECUTOR", "DEPT_FID", "DEPT_NO",
				"PRO_STARTDATE", "PRO_ENDDATE", "PRO_CONTENT" };

		Object[] PROJECT_VALUES = new Object[] { null, "T_FID", -1, ":",
				new java.util.Date(), ":", "PRO_REP", "PRO_MANAGER", null,
				null, ":", null, null,
				DateUtils.addDays(new java.util.Date(), -3),
				new java.util.Date(), ":" };

		String[] ALL_TABLE_NAMES = new String[] { "employee", "department",
				"customer", "project" };

		Object[] ALL_TABLE_COLUMN_KEYS = new Object[] { EMPLOYEE_COLUMN_KEYS,
				DEPARTMENT_COLUMN_KEYS, CUSTOMER_COLUMN_KEYS,
				PROJECT_COLUMN_KEYS };

		Object[] ALL_TABLE_VALUES = new Object[] { EMPLOYEE_VALUES,
				DEPARTMENT_VALUES, CUSTOMER_VALUES, PROJECT_VALUES };

		DBConnectionManager dbConnectionManager = DBConnectionManager
				.getInstance(DbRegistryTypeEnum.PROPERTIES);
		Connection conn = dbConnectionManager.getConnection(poolName);
		if (conn != null) {
			String tableName = null;
			boolean rollBack = false;
			try {
				conn.setAutoCommit(false);
				logger.debug("Start to pump data! ");
				long start = System.currentTimeMillis();
				for (int i = 0; i < ALL_TABLE_NAMES.length; i++) {
					tableName = ALL_TABLE_NAMES[i];
					insertData(conn, tableName,
							(String[]) ALL_TABLE_COLUMN_KEYS[i],
							(Object[]) ALL_TABLE_VALUES[i], 1000000);
				}
				conn.commit();
				long end = System.currentTimeMillis();
				logger.error("Success for preparing data! Time: "
						+ (end - start) + " ms");
			} catch (SQLException ex) {
				logger.error("SQL exception! Table index: " + tableName, ex);
				rollBack = true;
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				rollBack = true;
			} finally {
				try {
					if (rollBack) {
						conn.rollback();
					}
					conn.setAutoCommit(true);
					dbConnectionManager.freeConnetion(poolName, conn);
				} catch (SQLException e) {
					logger.error("SQL exception!", e);
				}
			}
		}*/
		/*if (conn != null) {
			boolean rollBack = false;
			try {
				conn.setAutoCommit(false);
				logger.debug("Start to pump data! ");
				long start = System.currentTimeMillis();
				for (int i = 0; i < ALL_TABLE_NAMES.length; i++) {
					tableName = ALL_TABLE_NAMES[i];
					insertData(this.conn, tableName,
							(String[]) ALL_TABLE_COLUMN_KEYS[i],
							(Object[]) ALL_TABLE_VALUES[i], 1000000);
				}
				conn.commit();
				long end = System.currentTimeMillis();
				logger.error("Success for preparing data! Time: "
						+ (end - start) + " ms");
			} catch (SQLException ex) {
				logger.error("SQL exception! Table index: " + tableName, ex);
				rollBack = true;
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				rollBack = true;
			} finally {
				try {
					if (rollBack) {
						conn.rollback();
					}
					conn.setAutoCommit(true);
					instance.freeConnetion(DB_POOL_NAME, conn);
				} catch (SQLException e) {
					logger.error("SQL exception!", e);
				}
			}
		}*/
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-27 03:05:50>		<p>
	 * <>			<p>
	 *
	 * @param conn
	 * 			
	 * @param table
	 * 			
	 * @param columnKeyArray
	 * 			
	 * @param valueArray
	 * 			
	 * @param rowCount
	 * 			
	 * @throws SQLException
	 * 			SQL
	 * @throws Exception
	 * 			
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void insertData(Connection conn, String table,
			String[] columnKeyArray, Object[] valueArray, int rowCount)
			throws SQLException, Exception {
		if (ArrayUtils.isEmpty(columnKeyArray)
				|| ArrayUtils.isEmpty(valueArray)) {
			throw new Exception(
					"[Table: " + table + ",ID: " + this.threadId + "]" +
					"invalid parameter, column key array or value array is empty! ");
		}
		if (conn != null) {
			StringBuffer sb = new StringBuffer("INSERT INTO " + table
					+ " VALUES (");
			for (int i = 0; i < columnKeyArray.length; i++) {
				if (i + 1 == columnKeyArray.length) {
					sb.append("?");
				} else {
					sb.append("?, ");
				}
			}
			sb.append(")");
			PreparedStatement preStmt = conn.prepareStatement(sb.toString(),
					columnKeyArray);
			for (int i = 1; i <= rowCount; i++) {
				logger.debug("[Table: " + table + ", ID: " + this.threadId + " import row <" + i + ">");
				for (int k = 0; k < columnKeyArray.length; k++) {
					String key = columnKeyArray[k];
					Object valueObject = valueArray[k];
					if (valueObject instanceof String) {
						String value = (String) valueObject;
						if (key.matches("\\w*_FID")) {
							value = Tools.getUID();
						} else if (key.matches("\\w*_EMAIL")) {
							value = (value.substring(0, value.lastIndexOf("@"))
									+ i + value.substring(value.indexOf("@"),
									value.length()));
						} else if (key
								.matches("(\\w+_PHONE)|(\\w+_TELE)|(\\w+_ZIP)")) {
							// unchange
						} else {
							value += i;
						}
						preStmt.setString(k + 1, value);
					} else if (valueObject instanceof Integer) {
						if (key.matches("\\w*_NO")) {
							preStmt.setInt(k + 1, i);
						} /*else if (key.matches("(\\w*_SEX)|(\\w*_AGE)|(\\w*_ZIP)")) {
							// unchange
							} */else {
							preStmt.setInt(k + 1, ((Integer) valueObject)
									.intValue());
						}

					} else if (valueObject instanceof java.util.Date) {
						Timestamp timeStamp = new Timestamp(
								((java.util.Date) valueObject).getTime() + i
										* 1000);
						preStmt.setTimestamp(k + 1, timeStamp);
					} else {
						preStmt.setObject(k + 1, valueObject);
					}
				}
				preStmt.addBatch();
				if (i % 100 == 0 || i == rowCount) {
					preStmt.executeBatch();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if (this.conn != null) {
			boolean rollBack = false;
			try {
				this.conn.setAutoCommit(false);
				logger.debug("[ID:" + this.threadId + "]Start to pump " + this.table + "data! ");
				long start = System.currentTimeMillis();

				insertData(this.conn, this.table, this.keys, this.values, this.count);
				this.conn.commit();
				long end = System.currentTimeMillis();
				logger.error("[ID:" + this.threadId + "]" + "Success for preparing " + this.table + "data! Time: "
						+ (end - start) + " ms");
			} catch (SQLException ex) {
				logger.error("SQL exception! [Table index: " + this.table + ", ID: " + this.threadId + "]", ex);
				rollBack = true;
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				rollBack = true;
			} finally {
				try {
					if (rollBack) {
						this.conn.rollback();
					}
					this.conn.setAutoCommit(true);
					instance.freeConnetion(DB_POOL_NAME, this.conn);
					if (this.conn != null) {
						this.conn.close();
					}
				} catch (SQLException e) {
					logger.error("SQL exception! [Table index: " + this.table + ", ID: " + this.threadId + "]", e);
				}
			}
		}
	}
}