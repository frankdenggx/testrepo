/**
 * CopyRight:
 * ProjectName:
 * JDK Version:
 * File Version:
 * Create Time:
 * Author:
 * Modify History:
 * <date>			<modifier>				<content>
 */
package edu.frank.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * learnning java.io.File
 * @see java.io.File
 * @see java.io.FilenameFilter
 * @since 1.0
 * @author yoyudeng
 * @version 1.1
 */
public class SortedDirList {
	
	private static File file;
	
	/**
	 * constructor
	 * @param strRegex regular expression
	 */
	public SortedDirList(String strFilePath){
		file = new File(strFilePath);
	}
	
	/**
	 * get file list
	 * @return file list
	 */
	public static String[] getFileList(){
		String[] list;
		list = file.list();
		return list;
	}
	
	/**
	 * get file list 
	 * @param strRegex regular expression
	 * @return file list
	 */
	public static String[] getFileList(String strRegex){
		String[] list;
		final Pattern m_pattern = Pattern.compile(strRegex);
		list = file.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				return m_pattern.matcher(name).matches();
			}
			
		});
		return list;
	}
	
	/**
	 * output file list
	 * @param list file list
	 */
	public static void showFile(String[] list){
		for (String fileItem : list)
			System.out.println(fileItem);
	}
	
	/**
	 * main method
	 * @param args console arguments
	 */
	public static void main(String[] args) {
		new SortedDirList("./src/com/yoyudeng/io");
		showFile(getFileList("^DirList.?\\.java$"));

	}

}
