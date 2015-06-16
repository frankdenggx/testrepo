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
 *  : <TemplateManager.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-24 10:26:35>
 *
 *
 */
package edu.frank.base.data.excel;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<{@link #prepareData(Component, boolean)}>
 * </p>
 *
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
 *
 *		<> <p>
 *	<2011-6-24 10:26:35> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public abstract class TemplateManager implements ITemplateManager {

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(TemplateManager.class);

	/**
	 * <Excel>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	protected ExcelUtils excelUtils;

	/**
	 *
	 * <p>
	 * &lt  <code>TemplateManager</code>  &gt
	 * </p>
	 *
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	protected TemplateManager() {
		this.excelUtils = ExcelUtils.getInstance();
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.ITemplateManager#getExcelData(java.io.File)
	 */
	public Map getExcelData(File file) throws FileNotFoundException, IOException {
		return this.excelUtils.getExcelData(file);
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.ITemplateManager#getExcelsData(java.io.File[])
	 */
	public Map getExcelsData(File[] files) throws FileNotFoundException, IOException {
		return this.excelUtils.getExcelsData(files);
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.ITemplateManager#getSheetObjectData(java.io.File, int)
	 */
	public Object[][] getSheetObjectData(File file, int sheetIndex) throws FileNotFoundException, IOException {
		return this.excelUtils.getSheetObjectData(file, sheetIndex);
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.hozdo.common.excel.ITemplateManager#getSheetData(java.io.File, int)
	 */
	public String[][] getSheetData(File file, int sheetIndex) throws FileNotFoundException, IOException {
		return this.excelUtils.getSheetData(file, sheetIndex);
	}

	/**
	 *
	 * <>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 11:15:39> <p>
	 * :	<> <p>
	 *
	 * @param parentUI
	 * 			UI
	 * @param enableMultiple
	 * 			
	 * @return
	 * 			excelsDataMap java.util.MapKeyExcel
	 * 			ValueExcelExceljava.util.Map
	 * 			Key  (Sheet) Value
	 * 			(Object[]{String[],String[],...,String[]})
	 * @throws Exception
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	final java.util.Map prepareData(java.awt.Component parentUI, boolean enableMultiple) throws FileNotFoundException, IOException {
		java.util.Map excelsDataMap = null;
		if (enableBeforeReadFile()) {
			excuteBeforeReadFile();
		}
		// Excel
		java.io.File[] files = importExcel(parentUI, enableMultiple);
		if (enableBeforeReadData()) {
			excuteBeforeReadData();
		}
		// Excel
		excelsDataMap = getExcelsData(files);
		if (enableAfterReadData()) {
			excuteAfterReadData();
		}
		return excelsDataMap;
	}

	final java.io.File[] importExcel(java.awt.Component parentUI, boolean enableMultiple) throws FileNotFoundException {
		java.io.File[] files = null;
		if (enableBeforeReadFile()) {
			excuteBeforeReadFile();
		}
		// Excel
		files = this.excelUtils.importExcel(parentUI, enableMultiple);
		return files;
	}

	abstract void excuteBeforeReadFile();
	abstract void excuteBeforeReadData();
	abstract void excuteAfterReadData();
	boolean enableBeforeReadFile() {
		return false;
	}
	boolean enableBeforeReadData() {
		return false;
	}
	boolean enableAfterReadData(){
		return false;
	}

}