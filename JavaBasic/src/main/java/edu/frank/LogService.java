/**
 * Thinker
 * LearnBasicJava
 * JDK1.6.17
 * LogService
 * 1.0
 * 
 * 2010-03-04
 * yoyudenghihi
 * 
 * 							
 * 2010.03.04	yoyudenghihi		
 */
package edu.frank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author yoyudenghihi
 *
 */
public class LogService {

	// 
	private static final SimpleDateFormat DATE_FORMAT =
		new SimpleDateFormat("yyyy-MM-dd"); // "--"
	private static final SimpleDateFormat DATETIME_FORMAT =
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String m_strLastLogDate = DATE_FORMAT.format(new Date()); // 
	private static final String DEFAULT_LOG_PATH = "./logs"; // 
	public static String m_strLogPath = DEFAULT_LOG_PATH; // 
	private static final String DEFAULT_LOG_FILENAME = "command.log";	//
	public static String m_strLogFileName = DEFAULT_LOG_FILENAME;	//

	/**
	 * 
	 *
	 * @param strMsg 
	 */
	synchronized public static void log(String strMsg) {

		File logFile = null; // 
		File logFileDir = null; // 
		FileWriter out_fw = null; // 
		BufferedWriter out_bw = null; // 

		final String strFileDir = m_strLogPath;
		final String strFile = m_strLogPath + "/" + m_strLogFileName;

		logFileDir = new File(strFileDir);
		if (null != logFileDir) {
			if (!logFileDir.exists()) {
				if (!logFileDir.mkdir()) {
					log("can't create directory for log !");
				}
			}
		}
		logFile = new File(strFile);
		if (null != logFile) {
			if (logFile.exists()
					&& !m_strLastLogDate.equals(DATE_FORMAT.format(new Date()))) {
				logFile.renameTo(new File(strFile + "." + m_strLastLogDate));
				m_strLastLogDate = DATE_FORMAT.format(new Date());
			}
		}

		// 
		try {
			out_fw = new FileWriter(logFile,true);
			out_bw = new BufferedWriter(out_fw);
			out_bw.write(DATETIME_FORMAT.format(new Date()) + " - " + strMsg);
			out_bw.write("\r\n");
			out_bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out_bw) {
					out_bw.close();
					out_bw = null;
				}
				if (null != out_fw) {
					out_fw.close();
					out_fw = null;
				}
			} catch (IOException ex_io) {
				ex_io.printStackTrace();
				log("close OutputStream error !");
			}
		}

	}
}