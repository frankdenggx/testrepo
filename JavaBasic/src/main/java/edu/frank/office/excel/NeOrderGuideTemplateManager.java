/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 * 
 *
 * 
 * 
 *
 */

/**
 *  : <>
 * EAS : <7.0>
 *  : <HOZDoEAS7.0>
 *
 *  : <com.kingdee.eas.hozdo.common.excel>
 *  : <NeOrderGuideTemplateManager.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-24 11:31:55>
 *
 *
 */
package edu.frank.office.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<>
 * </p>
 *
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-24 11:31:55> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public class NeOrderGuideTemplateManager extends TemplateManager {

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(NeOrderGuideTemplateManager.class);

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static NeOrderGuideTemplateManager manager = null;

	/**
	 *
	 * &lt  <code>NeOrderGuideTemplateManager</code>  &gt
	 *
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private NeOrderGuideTemplateManager() {
		super();
	}

	/**
	 *
	 * <>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-27 10:43:35> <p>
	 * :	<> <p>
	 *
	 * @return
	 *			
	 * @since HOZDoEAS7.0 1.0
	 */
	public static NeOrderGuideTemplateManager getManager() {
		if (manager == null) {
			manager = new NeOrderGuideTemplateManager();
		}
		return manager;
	}

	/**
	 *
	 * <ExcelExcel>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 12:57:47> <p>
	 * :	<> <p>
	 *
	 * @param parentUI
	 * 				UI
	 * @param currentDirectory
	 * 				
	 * @param enableMultiple
	 * 				
	 * @return
	 * 				Excel
	 * @throws Exception
	 * 				Excel
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public File[] loadExcels(java.awt.Component parentUI, String currentDirectory, boolean enableMultiple) throws FileNotFoundException {
		return importExcel(parentUI, currentDirectory, enableMultiple);
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 01:44:50> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param sheetIndex
	 * 			Excel
	 * @param destInfo
	 * 			
	 * @param flag
	 * 			
	 * 			<ul>
	 * 				<li>ROW|INDEX - </li>
	 *				<li>ROW|NUM - </li>
	 * 				<li>COLUMN|INDEX - </li>
	 * 				<li>COLUMN|NUM - </li>
	 * 			</ul>
	 * @return
	 * 			Excel
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 *			IO
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public String[][] getSheetData(File file, int sheetIndex, int destInfo, String flag) throws FileNotFoundException, IOException{
		if ((file == null) || (!file.exists())) {
			throw new IOException("");
		}
		if (!(!StringUtils.isBlank(flag) && ((flag.equalsIgnoreCase("ROW|INDEX")) || (flag.equalsIgnoreCase("ROW|NUM"))
				|| (flag.equalsIgnoreCase("COLUMN|INDEX")) || (flag.equalsIgnoreCase("COLUMN|NUM"))))) {
			logger.error("FLAG=" + flag);
			throw new IOException(",\"ROW|INDEX\"\"ROW|NUM\"\"COLUMN|INDEX\"\"COLUMN|NUM\"");
		}

		if (flag.equalsIgnoreCase("ROW|INDEX")) {
			return getSheetIndexData(file, sheetIndex, destInfo, 1);
		} else if (flag.equalsIgnoreCase("ROW|NUM")) {
			String[][] sheetData = this.excelUtils.getSheetData(file, sheetIndex);
			int columnNum = (sheetData[destInfo - 1]).length;
			return getSheetNumData(file, sheetIndex, destInfo, columnNum);
		} else if (flag.equalsIgnoreCase("COLUMN|INDEX")) {
			return getSheetIndexData(file, sheetIndex, 1, destInfo);
		} else if (flag.equalsIgnoreCase("COLUMN|NUM")) {
			//
			String[][] sheetData = this.excelUtils.getSheetData(file, sheetIndex);
			int rowNum = sheetData.length;
			return getSheetNumData(file, sheetIndex, rowNum, destInfo);
		}

		logger.error("FLAG=" + flag);
		throw new IOException(",\"NUM\"\"INDEX\"");
	}

	/**
	 *
	 * <Excel[11]
	 * 		 [11]<code>flag NUM - , INDEX - </code>
	 * 		 (rowIndex, columnIndex, "INDEX")/(rowNum, columnNum, "NUM")
	 * 		 >
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-23 11:00:24> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param sheetIndex
	 * 			Excel0
	 * @param rowInfo
	 * 			1
	 * @param columnInfo
	 * 			1
	 * @param flag
	 * 			 NUM -  INDEX - 
	 * @return
	 * 			Excel
	 * @throws Exception
	 *			Excel
	 *
	 * @see {@link #getSheetIndexData(File, int, int)}}
	 * @see {@link #getSheetNumData(File, int, int)}
	 * @since HOZDoEAS7.0 1.0
	 */
	public String[][] getSheetData(File file, int sheetIndex, int rowInfo, int columnInfo, String flag) throws IOException{
		if ((file == null) || (!file.exists())) {
			throw new IOException("");
		}
		if (!((!StringUtils.isBlank(flag) && (flag.equalsIgnoreCase("NUM"))) || flag.equalsIgnoreCase("INDEX"))) {
			logger.error("FLAG=" + flag);
			throw new IOException(",\"NUM\"\"INDEX\"");
		}

		if (flag.equalsIgnoreCase("NUM")) {
			return getSheetNumData(file, sheetIndex, rowInfo, columnInfo);
		} else if (flag.equalsIgnoreCase("INDEX")) {
			return getSheetIndexData(file, sheetIndex, rowInfo, rowInfo);
		} else {
			logger.error("FLAG=" + flag);
			throw new IOException(",\"NUM\"\"INDEX\"");
		}

	}

	/**
	 *
	 * <>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 12:20:12> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param sheetIndex
	 * 			Excel0
	 * @param rowIndex
	 * 			
	 * @param columnIndex
	 * 			
	 * @return
	 * 			Excel
	 * @throws Exception
	 *			
	 * @since HOZDoEAS7.0 1.0
	 */
	private String[][] getSheetIndexData(File file, int sheetIndex, int rowIndex, int columnIndex) throws FileNotFoundException, IOException {
		if ((rowIndex < 1) || (columnIndex < 1)) {
			logger.error("ROW_INDEX=" + rowIndex + ",COLUMN_INDEX=" + columnIndex);
			throw new IOException("1");
		}

		String[][] fetchData = null;
		try{
			String[][] sheetData;
			sheetData = this.excelUtils.getSheetData(file, sheetIndex);
			int rowNum = sheetData.length;
			int columnNum = (sheetData[rowIndex - 1]).length;
			fetchData = new String[rowNum - rowIndex + 1][columnNum];
			for (int i = rowIndex - 1; i < rowNum; i++) {
				String[] rowData = sheetData[i];
				for (int j = columnIndex - 1; j < rowData.length; j++) {
					fetchData[i + 1 - rowIndex][j] = rowData[j];
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			logger.error(e.getMessage(), e);
			throw new IOException("");
		}
		return fetchData;
	}

	/**
	 *
	 * <>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 12:20:12> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param sheetIndex
	 * 			Excel0
	 * @param rowIndex
	 * 			
	 * @param columnIndex
	 * 			
	 * @return
	 * 			Excel
	 * @throws Exception
	 *			
	 * @since HOZDoEAS7.0 1.0
	 */
	private String[][] getSheetNumData(File file, int sheetIndex, int rowNum, int columnNum) throws FileNotFoundException, IOException{
		if ((rowNum < 1) || (columnNum < 1)) {
			logger.error("ROW=" + rowNum + ",COLUMN=" + columnNum);
			throw new IOException("1");
		}
		String[][] fetchData = null;
		try{
			fetchData = new String[rowNum][columnNum];
			String[][] sheetData;
			sheetData = this.excelUtils.getSheetData(file, sheetIndex);
			for (int i = 0; i < rowNum; i++) {
				String[] rowData = sheetData[i];
				for (int j = 0; j < columnNum; j++) {
					fetchData[i][j] = rowData[j];
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			logger.error(e.getMessage(), e);
			throw new IOException("");
		}

		return fetchData;
	}

	@Override
	void excuteAfterReadData() {
	}

	@Override
	void excuteBeforeReadData() {
	}

	@Override
	void excuteBeforeReadFile() {
	}

}