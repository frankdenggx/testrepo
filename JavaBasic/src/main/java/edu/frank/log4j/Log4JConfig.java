/*
 * 
 * Hotel1802 
 *
 * 
 * 
 *
 */

/**
 *  : Hotel1802 
 * JDK  : 1.6.10
 *  : JavaBasic
 *
 *  : edu.frank.base
 *  : Log4JConfig.java
 *  : 1.0.0.0
 * apache logger 
 *
 *  : Frank
 *  : 2011-4-26 11:13:17
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.log4j;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Apache logger 
 *
 * @author yoyudeng
 *
 */
public class Log4JConfig extends Logger{

	private static String configFilePath = "./src/main/resources/edu/frank/log4j/log4jconfig.properties"; // 

	static {
		initLog4JLogger();
		new Log4JConfig("Log4JTest");
	}
	/**
	 *
	 *   <code>Log4JConfig</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 * @param name
	 * 			
	 */
	public Log4JConfig(String name) {
		super(name);
	}

	/**
	 *
	 * 
	 *
	 * @param c
	 * 			
	 * @return
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public static Logger getLogger(Class c) {
		initLog4JLogger();
		new Log4JConfig("Log4JTest");
		return Logger.getLogger(c.getClass());
	}

	/**
	 *
	 * 
	 *
	 * @param c
	 * 			
	 * @param configFilePath
	 * 			<br/>
	 * 			G:\config\log4jconfig.properties <br/>
	 * 			G:\config\log4jconfig.xml	<br/>
	 * 			/config/log4jconfig.properties	<br/>
	 * 			/config/log4jconfig.xml		<br/>
	 * @return
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public static Logger getLogger(Class c, String configFilePath) {
		return Logger.getLogger(c.getClass());
	}

	/**
	 *
	 * Apache 
	 *
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	private static void initLog4JLogger() {

		String suffix = StringUtils.substringAfterLast(configFilePath, ".");
		if (suffix.equalsIgnoreCase("xml")) {
			DOMConfigurator.configure(configFilePath);
		} else if (suffix.equalsIgnoreCase("properties")) {
			PropertyConfigurator.configure(configFilePath);
		} else {
			System.out.println("Serious error !\nWrong logger config path : "
					+ configFilePath);
		}
	}

}