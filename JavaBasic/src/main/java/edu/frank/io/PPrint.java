/**
 * CopyRight:
 * ProjectName:
 * JDK Version:
 * File Version:
 * File Describe:
 * Create Time:
 * Author:
 * Modify History:
 * <date>			<modifier>				<content>
 */
package edu.frank.io;

import java.util.Arrays;
import java.util.Collection;

/**
 * learnning java.io.File
 * @see java.io.File
 * @see java.io.FilenameFilter
 * @since 1.0
 * @author yoyudeng
 * @version 1.1
 */
public class PPrint {

	/**
	 * constructor
	 */
	public PPrint() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * custom formatted function
	 * @param c collection
	 * @return String
	 */
	public static String pformat(Collection<?> c){
		if (c.size() == 0)
			return "[]";
		StringBuffer result = new StringBuffer("[");
		for (Object elem : c){
			if (c.size() != 1)
				result.append("\n ");
			result.append(elem);
		}
		if (c.size() != 1)
			result.append("\n");
		result.append("]");
		return result.toString();
	}
	
	/**
	 * custom output function
	 * @param c collection
	 */
	public static void pprint(Collection<?> c){
		System.out.println(pformat(c));
	}
	
	/**
	 * custom output function
	 * @param c Object
	 */
	public static void pprint(Object[] c){
		System.out.println(pformat(Arrays.asList(c)));
	}

}
