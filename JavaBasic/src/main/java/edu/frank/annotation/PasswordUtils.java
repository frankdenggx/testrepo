/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * JDK Version: 1.6.15
 * File Version: 1.0
 * File Name: PasswordUtils.java
 * Description: 
 * Author: yoyudenghihi
 * Date: 2009.10.26
 * History:
 * <author>				<time>				<version>				<desc>
 * yoyudenghihi			2009.10.26			1.0						create
 */
package edu.frank.annotation;

import java.util.List;


/**
 * Password Utils which was annotated three UseCase
 * @see java.lang.Object
 * @since 1.0
 * @author yoyudenghihi
 *
 */
public class PasswordUtils {

	/**
	 * 
	 */
	public PasswordUtils() {

		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Validate Password
	 * @param m_strPassword user password
	 * @return true - password correct<br>
	 * 				  false - password incorrect
	 */
	@UseCase(id = 47, description = "Passwords must contain at least on numeric")
	public boolean validatePassword(String m_strPassword){
		return (m_strPassword.matches("\\w*\\d\\w*"));
	}
	
	/**
	 * Encrypt Password
	 * @param m_strPassword user password
	 * @return the string after encrypted
	 */
	@UseCase(id = 48)
	public String encryptPassword(String m_strPassword){
		return new StringBuilder(m_strPassword).reverse().toString();
	}
	
	/**
	 * check the new password is used or not
	 * @param prevPasswords the password list
	 * @param m_strPassword the new password
	 * @return true - not contain<br>
	 * 				 false - contain
	 */
	@UseCase(id = 49, description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String m_strPassword){
		return !prevPasswords.contains(m_strPassword);
	}
	
}
