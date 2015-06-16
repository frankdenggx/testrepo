package edu.frank.apache.dbutils;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class CustomericDbUtil {

	private static BasicDataSource ds;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	/*static {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
	private static void initDataSource() throws Exception {
		try {
			Properties dbProp = new Properties();
			InputStream in = CustomericDbUtil.class.getClassLoader().getResourceAsStream("edu/frank/apache/dbutils/db.properties");
			dbProp.load(in);
			ds = BasicDataSourceFactory.createDataSource(dbProp);
		} catch (Exception e) {
			throw new RuntimeException("fail to create data source!", e);
		}	
	}
	public static Connection getConnection() throws Exception {
		Connection conn = tl.get();
		if (conn == null) {
			if (ds == null)
				initDataSource();
			conn = ds.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	public static void closeConnection() throws Exception {
		try {
			Connection conn = tl.get();
			if (conn != null)
				conn.close();
		} finally {
			tl.remove();
		}
	}
	public static void closeDataSource() throws Exception {
		if (ds != null) {
			ds.close();
		}
	}
	public static void startTransaction() throws Exception {
		Connection conn = tl.get();
		conn.setAutoCommit(false);
	}
	public static void commitTransaction() throws Exception {
		Connection conn = tl.get();
		conn.commit();
	}
}
