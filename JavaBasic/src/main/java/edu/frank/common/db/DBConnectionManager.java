/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 * Hotel1802 Studio
 *
 * 
 * 
 *
 */

/**
 *  : <Hotel1820 Studio>
 * EAS : <7.0>
 *  : <JavaBasic>
 *
 *  : <edu.frank.common.db>
 *  : <DBConnectionManager>
 *  : 1.0
 * 
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 * : <2011-09-26 00:50>
 *
 *
 */

package edu.frank.common.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<>
 * </p>
 *  @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 *		<> <p>
 *	<2011-09-26 00:50> <p>
 *	<>	 <p>
 *
 *
 * @since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class DBConnectionManager {

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DbRegistryTypeEnum dbRegistryType;

	/**
	 * <Properties>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final String DB_REGISTRY_PROPERTIES_FILENAME = "db.properties";

	/**
	 * <XML>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final String DB_REGISTRY_XML_FILENAME = "db.xml";

	/**
	 * <XMLProperties[]>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private String strFilePath = null;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static DBConnectionManager dbInstance = null;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static int dbClients;

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Vector<Driver> dbDrivers = new Vector<Driver>();

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(DBConnectionManager.class);

	/**
	 * <>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private Hashtable<String, DBConnectionPool> dbPools = new Hashtable<String, DBConnectionPool>();

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 03:19:27> 		<p>
	 * <> 			<p>
	 *
	 * @param registryType
	 * 				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public synchronized static DBConnectionManager getInstance(DbRegistryTypeEnum registryType) {
		if (null == dbInstance) {
			dbInstance = new DBConnectionManager(registryType);
		}
		dbClients++;
		return dbInstance;
	}// End of methord getInstance

	/**
	 *
	 * <  <code>DBConnectionManager</code> >
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * Frank Deng	<p>
	 * <2011-9-26 03:19:27> 		<p>
	 * <> 			<p>
	 *
	 * @param registryType
	 * 				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private DBConnectionManager(DbRegistryTypeEnum registryType) {
		init(registryType);
	}

	/**
	 *
	 * <JNDI>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 01:20:19>		<p>
	 * <>			<p>
	 *
	 * @param strFilePath
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void setFile(String strFilePath) {
		if (this.dbRegistryType.compareTo(DbRegistryTypeEnum.JNDI) != 0) { // JNDI
			if (!StringUtils.isBlank(strFilePath)) {
				this.strFilePath = strFilePath;
			}
		}
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 01:33:32>		<p>
	 * <>			<p>
	 *
	 * @param registryType
	 * 				
	 * 				<ul>
	 * 					<li>JNDI</li>
	 * 					<li>PROERTIES</li>
	 * 					<li>XML</li>
	 * 				</ul>
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private void init(DbRegistryTypeEnum registryType) {
		InputStream in = null;
		if (registryType.compareTo(DbRegistryTypeEnum.JNDI) == 0) { // JNDI 

		} else if (registryType.compareTo(DbRegistryTypeEnum.PROPERTIES) == 0) { // PROPERTIES
			// 
			in = getClass()
					.getResourceAsStream(DB_REGISTRY_PROPERTIES_FILENAME);
			Properties dbProps = new Properties();
			try {
				dbProps.load(in);
			} catch (IOException e) {
				logger.error("Can't not load file: " + this.strFilePath);
				return;
			}
			loadDriver(dbProps);
			createPools(dbProps);
		} else if (registryType.compareTo(DbRegistryTypeEnum.XML) == 0) { // XML
			// 
			Document document = null;
			DocumentBuilderFactory factory = null;
			DocumentBuilder builder = null;
			in = getClass().getResourceAsStream(DB_REGISTRY_XML_FILENAME);
			factory = DocumentBuilderFactory.newInstance();
			try {
				builder = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				logger.error("Can't create DocumentBuilder! CAUSE:"
						+ e.getMessage());
				return;
			}
			try {
				document = builder.parse(in);
			} catch (SAXException e) {
				logger.error("Can't SAX XML File! CASUE:" + e.getMessage());
				return;
			} catch (IOException e) {
				logger.error("can't load the file : " + this.strFilePath);
				return;
			}
			document.normalize();
			if (null != document) {
				loadDriver(document);
				createPools(document);
			}
		} else {
			logger.error("The register type is incorrect!");
		}

		// close io input stream
		if (null != in) {
			try {
				in.close();
			} catch (IOException e) {
				logger.error("Can't close IO Input Stream!");
				return;
			}
			in = null;
		}
	}// End of methord init

	/**
	 *
	 * <PROPERTIES>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 01:36:49>		<p>
	 * <>			<p>
	 *
	 * @param props
	 *			PROPERTIES
	 * @since JavaBasic 1.0.0.0
	 */
	private void loadDriver(Properties props) {
		Enumeration<?> propNames = props.propertyNames();
		while (propNames.hasMoreElements()) {
			String elemName = (String) propNames.nextElement();
			if (!elemName.endsWith(".DRIVER")) {
				continue;
			}
			String driverClassName = props.getProperty(elemName);
			try {
				Driver driver = (Driver) Class.forName(driverClassName)
						.newInstance();
				DriverManager.registerDriver(driver);
				this.dbDrivers.addElement(driver);
			} catch (Exception ex) {
				logger.error("error :\n" + ex.toString());
				return;
			}
		}

		/*StringTokenizer st = new StringTokenizer(driverClass);
		while (st.hasMoreElements()) {
			String driverClassName = st.nextToken().trim();
			try {
				Driver driver = (Driver) Class.forName(driverClassName)
						.newInstance();
				DriverManager.registerDriver(driver);
				this.dbDrivers.addElement(driver);
			} catch (Exception ex) {
				logger.error("error :\n" + ex.toString());
				return;
			}
		}*/
	}// End of methord loadDriver

	/**
	 *
	 * <XML>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 01:37:47>		<p>
	 * <>			<p>
	 *
	 * @param doc
	 *			XML
	 * @since JavaBasic 1.0.0.0
	 */
	private void loadDriver(Document doc) {
		Node rootElement = doc.getDocumentElement();
		if (rootElement.hasChildNodes()) {
			NodeList listDatabase = doc.getElementsByTagName("DATABASE");
			for (int i = 0; i < listDatabase.getLength(); i++) {
				Node dbNode = listDatabase.item(i);
				if (dbNode.getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}
				NamedNodeMap attributesMap = dbNode.getAttributes();
				Node driverNode = attributesMap.getNamedItem("driver");
				if (dbNode.getNodeType() != Node.ATTRIBUTE_NODE) {
					continue;
				}
				String strDriverName = driverNode.getNodeValue();
				Driver driver = null;
				try {
					driver = (Driver) Class.forName(strDriverName)
							.newInstance();
				} catch (InstantiationException e) {
					logger.error("error : \n" + e.getMessage());
					return;
				} catch (IllegalAccessException e) {
					logger.error("error : \n" + e.getMessage());
					return;
				} catch (ClassNotFoundException e) {
					logger.error("error : \n" + e.getMessage());
					return;
				}
				try {
					DriverManager.registerDriver(driver);
					this.dbDrivers.addElement(driver);
				} catch (SQLException e) {
					logger.error("error : \n" + e.getMessage());
				}
			}
		}
	}

	/**
	 *
	 * <XML>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 01:38:46>		<p>
	 * <>			<p>
	 *
	 * @param doc
	 *			XML
	 * @since JavaBasic 1.0.0.0
	 */
	public void createPools(Document doc) {
		Node root = doc.getDocumentElement();
		if (root.hasChildNodes()) {
			NodeList listDBPools = doc.getElementsByTagName("DATABASE");
			for (int i = 0; i < listDBPools.getLength(); i++) {
				Node dbNode = listDBPools.item(i);
				if (dbNode.getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}
				NodeList listDBChilds = dbNode.getChildNodes();
				if (null != listDBChilds && listDBChilds.getLength() > 0) {
					String strPoolName = null;
					String strURL = null;
					String strUser = null;
					String strPassword = null;
					String strMaxConn = null;
					for (int k = 0; k < listDBChilds.getLength(); k++) {
						Node node = listDBChilds.item(k);
						if (node.getNodeType() != Node.ELEMENT_NODE) {
							continue;
						}
						if (node.getNodeName().equalsIgnoreCase("POOLNAME")) {
							strPoolName = node.getNodeValue();
						}
						if (node.getNodeName().equalsIgnoreCase("URL")) {
							strURL = node.getNodeValue();
						} else if (node.getNodeName().equalsIgnoreCase("USER")) {
							strUser = node.getNodeValue();
						} else if (node.getNodeName().equalsIgnoreCase("PASSWORD")) {
							strPassword = node.getNodeValue();
						} else if (node.getNodeName().equalsIgnoreCase("MAXCONN")) {
							strMaxConn = node.getNodeValue();
						}
					}

					if (null != strURL && null != strUser
							&& strPassword != null
							&& strURL.trim().length() > 0
							&& strUser.trim().length() > 0
							&& strPassword.trim().length() > 0) {
						int nMaxConn = -1;
						try {
							nMaxConn = Integer.parseInt(strMaxConn);
						} catch (NumberFormatException e) {
							logger.error("Can't format String strMaxConn:"
									+ strMaxConn);
						}

						DBConnectionPool pool = new DBConnectionPool(
								strPoolName, strURL, strUser, strPassword,
								nMaxConn);
						this.dbPools.put(strPoolName, pool);
					} else {
						logger.error("parameter error !");
						logger.error("poolname=" + strPoolName);
						logger.error("url=" + strURL);
						logger.error("user=" + strUser);
						logger.error("password=" + strPassword);
						logger.error("maxconn=" + strMaxConn);
					}

				}
			}
		}
	}

	/**
	 *
	 * <PROPERTIES>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 01:39:56>		<p>
	 * <>			<p>
	 *
	 * @param props
	 *			PROPERTES
	 * @since JavaBasic 1.0.0.0
	 */
	public void createPools(Properties props) {
		Enumeration<?> propNames = props.propertyNames();
		while (propNames.hasMoreElements()) {
			String fullURLName = (String) propNames.nextElement();
			if (fullURLName.endsWith(".URL")) {
				String prefixPoolName = fullURLName.substring(0, fullURLName
						.lastIndexOf("."));
				String url = props.getProperty(prefixPoolName + ".URL");
				if (null == url) {
					log("has not inited " + prefixPoolName + " for an URL");
					continue;
				}
				String user = props.getProperty(prefixPoolName + ".USER");
				String password = props.getProperty(prefixPoolName + ".PASSWORD");
				String maxconn = props.getProperty(prefixPoolName + ".MAXCONN", "0");
				int max;
				try {
					max = Integer.valueOf(maxconn).intValue();
				} catch (NumberFormatException ex) {
					log("wrong max connection number : " + maxconn
							+ " ! pool : " + prefixPoolName);
					max = 0;
				}
				DBConnectionPool pool = new DBConnectionPool(prefixPoolName, url,
						user, password, max);
				if (!StringUtils.isBlank(prefixPoolName)) {
					prefixPoolName = prefixPoolName.substring(fullURLName.indexOf(".") + 1, fullURLName.lastIndexOf("."));
				}
				this.dbPools.put(prefixPoolName, pool);
				log("success creating " + prefixPoolName + " ! ");
			}
		}
	}// End of methord createPools

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 03:26:49>		<p>
	 * <>			<p>
	 *
	 * @param dbPoolName
	 * 				
	 * @return
	 *				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public Connection getConnection(String dbPoolName) {
		DBConnectionPool pool = (DBConnectionPool) this.dbPools.get(dbPoolName);
		if (null != pool) {
			return pool.GetConnection();
		}
		return null;
	}// End of methord getConnection

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 03:27:42>		<p>
	 * <>			<p>
	 *
	 * @param dbPoolName
	 * 				
	 * @param lTimeOut
	 * 				
	 * @return
	 *				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public Connection getConnection(String dbPoolName, long lTimeOut) {
		DBConnectionPool pool = (DBConnectionPool) this.dbPools.get(dbPoolName);
		if (null != pool) {
			return pool.GetConnection(lTimeOut);
		}
		return null;
	}// End of methord getConnection

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 03:29:09>		<p>
	 * <>			<p>
	 *
	 * @param dbPoolName
	 * 				
	 * @param conn
	 *				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void freeConnetion(String dbPoolName, Connection conn) {
		DBConnectionPool pool = (DBConnectionPool) this.dbPools.get(dbPoolName);
		if (null != pool) {
			pool.freeClientConnection(conn);
		}
	}// End of methord FreeConnection

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 03:30:06>		<p>
	 * <>			<p>
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public void release() {
		// waitting until the last client release connetion
		if (--dbClients != 0) {
			return;
		}
		Enumeration<DBConnectionPool> allPools = this.dbPools.elements();
		while (allPools.hasMoreElements()) {
			DBConnectionPool pool = (DBConnectionPool) allPools.nextElement();
			pool.ReleaseConnection();
		}
		Enumeration<Driver> allDrivers = this.dbDrivers.elements();
		while (allDrivers.hasMoreElements()) {
			Driver driver = (Driver) allDrivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				log("release JDBC Driver : " + driver.getClass().getName()
						+ " registeration ! ");
			} catch (SQLException ex) {
				log("can't release JDBC Driver : "
						+ driver.getClass().getName() + " registeration ! ");
			}
		}
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng		<p>
	 * <2011-9-26 03:30:47>		<p>
	 * <>			<p>
	 *
	 * @param strMessage
	 * 				
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private void log(String strMessage) {
		logger.error(new Date() + ":" + strMessage);
	}// End of methord log

	/**
	 * <p>
	 * 	<>
	 * </p>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
	 * <p>
	 *
	 * 	Frank Deng <p>
	 * <2011-9-26 03:31:13> <p>
	 * <> <p>
	 *
	 * @Since JavaBasic 1.0.0.0
	 * @Version JavaBasic 1.0.0.0
	 */
	class DBConnectionPool {

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private int nRelease;

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private Vector<Connection> vecReleaConns = new Vector<Connection>();

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private int nMaxConn;

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private String strDSName;

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private DataSource dataSource = null;

		/**
		 * <URL>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private String url;

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private String user;

		/**
		 * <>
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		private String password;

		/**
		 *
		 * <  <code>DBConnectionPool</code> >
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * Frank Deng	<p>
		 * <2011-9-26 03:34:05> 		<p>
		 * <> 			<p>
		 *
		 * @param strDSName
		 * 			
		 * @param url
		 * 			URL
		 * @param user
		 * 			
		 * @param password
		 * 			
		 * @param nMaxConn
		 * 			
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public DBConnectionPool(String strDSName, String url, String user,
				String password, int nMaxConn) {
			this.strDSName = strDSName;
			this.url = url;
			this.user = user;
			this.password = password;
			this.nMaxConn = nMaxConn;
		}// End of methord DBConnectionPool

		/**
		 *
		 * <>
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * 	Frank Deng		<p>
		 * <2011-9-26 03:35:04>		<p>
		 * <>			<p>
		 *
		 * @param Conn
		 * 			
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public synchronized void freeClientConnection(Connection Conn) {
			this.vecReleaConns.addElement(Conn);// add the connection to the end
			this.nRelease++;
			notifyAll();
		}

		/**
		 *
		 * <>
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * 	Frank Deng		<p>
		 * <2011-9-26 03:35:27>		<p>
		 * <>			<p>
		 *
		 * @return
		 * 			
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public synchronized Connection GetConnection() {
			Connection conn = null;
			if (this.vecReleaConns.size() > 0) {
				conn = (Connection) this.vecReleaConns.firstElement();
				this.vecReleaConns.removeElementAt(0);
				try {
					if (conn.isClosed()) {
						log("from DataBase Pool : " + this.strDSName
								+ " delete a invalid connection success ! ");
						conn = GetConnection();// reconnection
					}
				} catch (SQLException SQL_Ex) {
					log("from DataBase Pool : " + this.strDSName
							+ "delete an invalid connetion fail ! ");
					conn = GetConnection(); // reconnection
				}
			} else if (this.nMaxConn == 0 || this.nRelease < this.nMaxConn) {
				conn = NewConnection();
			}
			if (null != conn) {
				this.nRelease++;
			}
			return conn;
		}// End of methord GetConnection

		/**
		 *
		 * <>
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * 	Frank Deng		<p>
		 * <2011-9-26 03:35:51>		<p>
		 * <>			<p>
		 *
		 * @param lTimeOut
		 * 			
		 * @return
		 * 			
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public synchronized Connection GetConnection(long lTimeOut) {
			long lStartTime = new Date().getTime();
			Connection conn = null;
			while (null == (conn = GetConnection())) {
				try {
					wait(lTimeOut);
				} catch (InterruptedException ex) {
					log("connection error ! ");
				}
				if ((new Date().getTime() - lStartTime) >= lTimeOut) {
					return null;
				}
			}
			return conn;
		}// End of methord GetConnection

		/**
		 *
		 * <>
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * 	Frank Deng		<p>
		 * <2011-9-26 03:36:35>		<p>
		 * <>			<p>
		 *
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public synchronized void ReleaseConnection() {
			Enumeration<Connection> allConnections = this.vecReleaConns
					.elements();
			while (allConnections.hasMoreElements()) {
				Connection conn = (Connection) allConnections.nextElement();
				try {
					conn.close();
					log("close DataBase Connection Pool : " + this.strDSName
							+ " one connection success ! ");
				} catch (SQLException SQL_Ex) {
					log("close DataBase Connection Pool : " + this.strDSName
							+ " one connection fail ! ");
				}
			}
			this.vecReleaConns.removeAllElements();
		}// End of methord ReleaseConnection

		/**
		 *
		 * <>
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * 	Frank Deng		<p>
		 * <2011-9-26 03:37:00>		<p>
		 * <>			<p>
		 *
		 * @return
		 * 			
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public Connection NewConnection() {
			Connection conn = null;
			try {
				if (null == conn) {
					conn = DriverManager.getConnection(this.url, this.user,
							this.password);
				}
			} catch (SQLException SQL_Ex) {
				logger.error("Can't not get conntection!", SQL_Ex);
			}
			return conn;
		}// End of methord NewConnection

		/**
		 *
		 * <>
		 *
		 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
		 * <p>
		 *
		 * 	Frank Deng		<p>
		 * <2011-9-26 03:37:32>		<p>
		 * <>			<p>
		 *
		 * @param registryType
		 * 			
		 * @return
		 * 			
		 *
		 * @since JavaBasic 1.0.0.0
		 */
		public Connection NewConnection(DbRegistryTypeEnum registryType) {
			Connection conn = null;
			if (registryType.compareTo(DbRegistryTypeEnum.JNDI) == 0) {
				try {
					InitialContext ctx = new InitialContext();
					this.dataSource = (DataSource) ctx.lookup("java:comp/env/"
							+ this.strDSName);
				} catch (NamingException NamingEx) {
					log("can't bind DataSource's Name ! ");
					NamingEx.printStackTrace();
				}
				if (null != this.dataSource) {
					try {
						conn = this.dataSource.getConnection();
					} catch (SQLException SQL_Ex) {
						log("can't create connection ! ");
						SQL_Ex.printStackTrace();
					}
				}
			} else {
				try {
					if (null == conn) {
						conn = DriverManager.getConnection(this.url, this.user,
								this.password);
					}
				} catch (SQLException SQL_Ex) {
					log("can't create connection ! ");
				}
			}
			return conn;
		}

	}// End of class DBConnectionPool


}// End of class DBConnectionManager