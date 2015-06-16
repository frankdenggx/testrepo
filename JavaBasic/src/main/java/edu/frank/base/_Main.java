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
 *  : _Main.java
 *  : 1.0.0.0
 * 
 *
 *  : Frank
 *  : 2011-4-26 11:13:17
 *  :
 * <>				<>				<>
 *
 */
package edu.frank.base;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import edu.frank.common.Tools;
import edu.frank.common.db.DBConnectionManager;
import edu.frank.common.db.DbRegistryTypeEnum;
import edu.frank.headfirst.singleton.LazyInstance;
import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	
 * </p>
 * @author Frank
 * @Version JavaBasic 1.0.0.0
 */
public final class _Main implements Runnable {

	private static final Logger logger = Log4JConfig.getLogger(_Main.class);
	Integer i;
	int j;
	private Timestamp ts;

	/**
	 *   <code>_Main</code> 
	 *
	 * @since JavaBasic 1.0.0.0
	 */
	public _Main() {
	}

	/**
	 *
	 * 
	 *
	 * @param args
	 *			
	 * @since JavaBasic 1.0.0.0
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * java.util.Properties properties = System.getProperties();
		 * java.util.Iterator iterator = properties.keySet().iterator(); while
		 * (iterator.hasNext()) { String key = (String) iterator.next(); String
		 * value = properties.getProperty(key); System.out.println("key=" + key
		 * + " value=" + value); }
		 * 
		 * System.out.println((new java.util.Random()).nextInt(10));
		 */

		//prepareData();

		/*
		 * URL url = _Main.class.getResource("");
		 * System.out.println(url.getPath());
		 */

		/*
		 * tring strDate1 = "2011-12-01"; String strDate2 = "2011-12-31"; String
		 * strDate3 = "2011-12-15"; String strDate4 = "2011-12-16"; String
		 * strDate5 = "2012-01-01";
		 * 
		 * String[] testDemo = new String[] { strDate1, strDate2, strDate3,
		 * strDate4, strDate5 }; SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy-MM-dd"); for (int i = 0; i < testDemo.length;
		 * i++) { Date testDate = sdf.parse(testDemo[i]); testDate =
		 * subDay(testDate, -1); System.out.println("Date:" +
		 * sdf.format(testDate)); }
		 * System.out.println("-----------------------------" +
		 * java.text.NumberFormat.getInstance().format(0.123));
		 */
		/*
		 * Thread thread1 = new Thread(new _Main()); Thread thread2 = new
		 * Thread(new _Main()); thread1.start(); thread2.start();
		 */
		/*
		 * long d = Math.min(24, 244); System.out.println(d);
		 */
		//		System.out.println(String.format("%tA, %<tB %<td", new Date()));
		_Main instance = new _Main();
		/*
		 * Date[] courseDays = courseDays = instance.findCourseDays(); if
		 * (!ArrayUtils.isEmpty(courseDays)) { for (int i = 0; i <
		 * courseDays.length; i++) {
		 * System.out.println(String.format("%tY-%<tm-%<td", courseDays[i])); }
		 * }
		 * 
		 * FullMoons f = new FullMoons(); FullMoons.main(args);
		 */
		/*
		 * Locale local1 = Locale.getDefault(); Locale local2 = new Locale("en",
		 * "US"); Locale[] locals = {local1, local2}; URL url =
		 * instance.getClass().getClassLoader().getResource("");
		 * 
		 * for(int i = 0; i < locals.length; i++) { Locale local = locals[i];
		 * ResourceBundle bundle =
		 * ResourceBundle.getBundle("edu.frank.base.MesgResource", local);
		 * String msg = bundle.getString("msg");
		 * System.out.println(MessageFormat.format(msg, "Frank", new Date())); }
		 */
		/*
		 * String s1 = new String("ABCDEFG"), s2 = new String("EFGHIJ"); String
		 * s3 = s1.substring(4, 7), s4 = s2.substring(0, 3);
		 * System.out.println((s3==s4) + "," + (s3+s4).equals(s4+s3));
		 */
		/*
		 * String sa = "2013-03-16"; String MILLISECOND_FORMAT = ".SSS"; Date
		 * check = null; DateFormat df = null; Locale locale = Locale.US;
		 * SimpleDateFormat dtfmt = (SimpleDateFormat) DateFormat
		 * .getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, locale);
		 * SimpleDateFormat fullfmt = new SimpleDateFormat(dtfmt.toPattern() +
		 * MILLISECOND_FORMAT, locale); SimpleDateFormat dfmt =
		 * (SimpleDateFormat) DateFormat.getDateInstance( DateFormat.SHORT,
		 * locale); SimpleDateFormat[] fmts = { fullfmt, dtfmt, dfmt }; for
		 * (SimpleDateFormat fmt : fmts) { try { check = fmt.parse(sa); df =
		 * fmt; if (check != null) { break; } } catch (ParseException ignore) {
		 * } }
		 */
		/* Date date = new Date(); */
		/*
		 * int x = -11; System.out.println(Integer.toHexString(x)); assert (x >
		 * 0) : "x=" + x;
		 */
		/*List<Integer> a = new ArrayList<Integer>();
		a.add(new Integer(1));
		a.add(new Integer(2));
		a.add(new Integer(3));
		a.add(new Integer(3));
		a.add(new Integer(4));
		a.add(new Integer(5));
		List<Integer> b = new ArrayList<Integer>();
		b.add(new Integer(3));
		b.add(new Integer(4));
		b.add(new Integer(4));
		b.add(new Integer(5));
		b.add(new Integer(6));
		b.add(new Integer(7));

		List<Integer> union = (List<Integer>) CollectionUtils.union(a, b);
		List<Integer> intersection = (List<Integer>) CollectionUtils
				.intersection(a, b);
		List<Integer> disjunction = (List<Integer>) CollectionUtils
				.disjunction(a, b);
		List<Integer> subtract = (List<Integer>) CollectionUtils.subtract(a, b);
		System.out.println("A=" + ArrayUtils.toString(a.toArray()));
		System.out.println("B=" + ArrayUtils.toString(b.toArray()));
		System.out.println(ArrayUtils.toString(union.toArray()));
		System.out.println(ArrayUtils.toString(intersection.toArray()));
		System.out.println(ArrayUtils.toString(disjunction.toArray()));
		System.out.println(ArrayUtils.toString(subtract.toArray()));*/
		//int i = 1;
		//double d = 2.78d;
		//System.out.println(i * d);

		//Calendar calendar = Calendar.getInstance();
		//System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//double d = 3.1415D;
		//rs.getBigDecimal("T_DATA");

		//BigDecimal data = new BigDecimal(String.v);
		//System.out.println(data);

		try {
			//instance.delData();
//			int i = 12;
//			System.out.println(i-=i*=i);
//			System.out.print(i+=i-=i*=i);
			getMaxETString("aaaaaabbccc!!!!!!!!!!!!");
			//int i = 0;
			System.out.println(0.653214);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDate(Timestamp ts) {
		this.ts = ts;
	}

	public Date[] findCourseDays() {
		Date[] courseDays = new Date[12];
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		System.out.println("This year is leap year ? " + "\nAnswer is : "
				+ isLeapYear(calendar));
		for (int i = 0; i < 12; i++) {
			calendar.setTime(currentDate);
			calendar.set(Calendar.MONTH, i);
			int lastDayOfMonth = calendar
					.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println("---lastDay:" + lastDayOfMonth);
			calendar.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
			System.out.println("---date:" + calendar.getTime());
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println("---date-week:" + dayOfWeek);
			if (dayOfWeek == 7) {
				calendar.add(Calendar.DAY_OF_MONTH, -1);

			} else if (dayOfWeek == 1) {
				calendar.add(Calendar.DAY_OF_MONTH, -2);
			}
			courseDays[i] = calendar.getTime();
			//calendar.clear(Calendar.DAY_OF_MONTH);
		}
		return courseDays;
	}

	private boolean isLeapYear(Calendar calendar) {
		boolean isLeapYear = false;
		int year = calendar.get(Calendar.YEAR);
		if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)) {
			isLeapYear = true;
		}
		return isLeapYear;
	}

	public void go() {
		System.out.println(this.j);
		System.out.println(this.i);
		this.i = new Integer(1);
		this.j = this.i;
		System.out.println(this.j);
		System.out.println(this.i);
	}

	public static void prepareData() throws Exception {
		DBConnectionManager instance = DBConnectionManager
				.getInstance(DbRegistryTypeEnum.PROPERTIES);
		if (instance != null) {
			java.sql.Connection conn = instance.getConnection("JavaBasicPool");
			if (conn == null) {
				return;
			}
			java.sql.Statement st = conn.createStatement();
			for (int i = 0; i < 50; i++) {
				StringBuffer sql = new StringBuffer();
				String uuid = Tools.getUID();
				sql.append("insert into `customer`(`FID`,`CUST_NO`,`CUST_NAME`,`CUST_ADDR`,`CUST_TEL`,`CUST_DESC`)");
				sql.append(" ");
				sql.append("values('" + uuid + "'," + (100000 + i) + ",'" + i
						+ "'" + ",'" + i + "','(020)" + (87117300 + i) + "','"
						+ i + "')");
				logger.debug(sql.toString());
				st.addBatch(sql.toString());
			}
			int[] number = st.executeBatch();
			logger.debug("execute num: " + number);
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				instance.freeConnetion("JavaBasicPool", conn);
			}
		}
	}

	public static Date subDay(Date currentDay, int subtrator) throws Exception {
		StringBuffer sbErrMsg = new StringBuffer(
				"Fail to deal with day calculation!");
		if (currentDay == null) {
			sbErrMsg.append("The input day is null.");
			throw new Exception(sbErrMsg.toString());
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		calendar.add(Calendar.DAY_OF_MONTH, subtrator);
		return calendar.getTime();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		LazyInstance instance = LazyInstance.getInstance();
		System.out.println("LazyInstance:" + instance.toString());
	}

	private int[] delData() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String[] paramList = new String[]{"0758", "0759"};
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=GBK", "root", "root");
			preStmt = conn.prepareStatement("DELETE FROM city WHERE citycode=?");
			for (String tmp : paramList) {
				preStmt.setString(1, tmp);
				preStmt.addBatch();
			}
			return preStmt.executeBatch();
		} finally {
			if (preStmt != null) {
				preStmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public static void getMaxETString(String inputString) throws Exception {
		if (inputString == null || inputString.length() == 0) {
			throw new IllegalArgumentException("input string is null or empty!");
		}
		if (inputString.length() <= 1) {
			System.out.println("没有相等子串！");
		}
		String maxString = null;
		StringBuffer bf = new StringBuffer();
		int maxCount = 0;

		char c = inputString.charAt(0);
		for (int i = 1; i < inputString.length(); i++) {
			char tmp = inputString.charAt(i);
			if (tmp == '!') {
				bf.append(c);
				if (bf.length() > maxCount && bf.length() >= 2) {
					maxString = bf.toString();
				}
				break;
			}
			if (c==tmp) {
				bf.append(tmp);
			} else {
				bf.append(c);
				if (bf.length() > maxCount && bf.length() >= 2) {
					maxString = bf.toString();
					maxCount = bf.length();
				}
				bf.setLength(0);
				c = tmp;
			}
			
		}
		if (maxString == null || maxString.length() == 0) {
			System.out.println("没有相等子串！");
		} else {
			System.out.println(maxString);
		}
	}

}