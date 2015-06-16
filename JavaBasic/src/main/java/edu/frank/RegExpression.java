/**
 * Hotel1802
 * AccManSys
 * JDK1.6_10
 * 1.0
 * 
 * 2010-06-13
 * denggx
 * 
 * <>			<>				<>
 */
package edu.frank;

/**
 * 
 * @author denggx
 *
 */
public final class RegExpression{
	
	//Pattern
	private final String strREG_int = 
		"^\\d*$";	//int
	
	private final String strREG_float = 
		"\\d+(\\.\\d+)?$";	//float
	
	private final String strREG_date = 
		"^[\\d]{4}([-][\\d]{2}){2}$";	//date
	
	private final String strREG_time = 
		"^([12]{1}[\\d]{1}([:][123456]{1}[\\d]{1}){2}){1}$"; //time
	
	private final String strREG_datetime = 
		"^[\\d]{4}([-][\\d]{2}){2}([][12]{1}[\\d]{1}([:][123456]{1}[\\d]{1}){2}){1}$";	
		//datetime2010-06-13 13:15:12
	
	private final String strREG_qq = 
		"^\\d{5,9}$";	//qq
	
	private final String strREG_mobile = 
		"^[1]\\d{10}$";	//mobile
	
	private final String strREG_Phone = 
		"^((0[1-9]{1,2}[0-9]-[1-9]\\d{6,7})|(\\(0[1-9]{1,2}[0-9]\\)[1-9]\\d{6,7}))$";	
		//phone020-87117338(020)8711733878
	
	private final String strREG_email = 
		"^[\\w\\d]+@[\\w\\d]+(\\.[\\w\\d]+)+$";	//email
	
	private final String strREG_postcode = 
		"^\\d{6}$";	//postcode
	
	private final String strREG_idcard = 
		"^[1-9]\\d{14}|[1-9]\\d{13}[xX]{1}|[1-9]\\d{17}|[1-9]\\d{16}[xX]{1}$";	
	//idcard1518Xx
	
	private final String strREG_url = 
		"^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$";	//url
	
	/**
	 * Pattern
	 * @param m_strRegExp  [email]
	 * @return Pattern
	 */
	public final String getRegExp(String m_strRegExp){
		if(null == m_strRegExp || m_strRegExp.length() <= 0){
			return null;
		}
		String m_strREG = null;
		if(m_strRegExp.equalsIgnoreCase("int")){
			m_strREG = strREG_int;
		}else if(m_strRegExp.equalsIgnoreCase("float")){
			m_strREG = strREG_float;
		}else if(m_strRegExp.equalsIgnoreCase("date")){
			m_strREG = strREG_date;
		}else if(m_strRegExp.equalsIgnoreCase("time")){
			m_strREG = strREG_time;
		}else if(m_strRegExp.equalsIgnoreCase("datetime")){
			m_strREG = strREG_datetime;
		}else if(m_strRegExp.equalsIgnoreCase("qq")){
			m_strREG = strREG_qq;
		}else if(m_strRegExp.equalsIgnoreCase("mobile")){
			m_strREG = strREG_mobile;
		}else if(m_strRegExp.equalsIgnoreCase("phone")){
			m_strREG = strREG_Phone;
		}else if(m_strRegExp.equalsIgnoreCase("email")){
			m_strREG = strREG_email;
		}else if(m_strRegExp.equalsIgnoreCase("postcode")){
			m_strREG = strREG_postcode;
		}else if(m_strRegExp.equalsIgnoreCase("idcard")){
			m_strREG = strREG_idcard;
		}else if(m_strRegExp.equalsIgnoreCase("url")){
			m_strREG = strREG_url;
		}else{
			m_strREG = null;
		}
		return m_strREG;
	}
}