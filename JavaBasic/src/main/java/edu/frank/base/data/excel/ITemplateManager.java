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
 *  : <ITemplateManager.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-24 10:14:39>
 *
 *
 */
package edu.frank.base.data.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p>
 * 	<>
 * </p>
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-24 10:14:39> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public interface ITemplateManager {

	/**
	 *
	 * <>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 11:28:56> <p>
	 * :	<> <p>
	 *
	 * @param files
	 * 			Excel
	 * @return
	 * 			{@link java.util.Map}KeyExcelValueExcel
	 * 			Exceljava.util.MapKey  (Sheet) 
	 * 			Value (<code>Object[][]</code>)
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 * 			IO
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	java.util.Map getExcelsData(File[] files) throws FileNotFoundException, IOException;

	/**
	 *
	 * <Excel>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 11:29:02> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @return
	 * 			{@link java.util.Map}KeySheet,
	 * 			Value (<code>Object[][]</code>)
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 * 			IO
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	java.util.Map getExcelData(File file) throws FileNotFoundException, IOException;

	/**
	 *
	 * <Excel>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 11:29:07> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param sheetIndex
	 * 			<code>Sheet</code>Excel0
	 * @return
	 * 			{@link java.lang.Object} 
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 *			IO
	 *
	 * com.kingdee.eas.hozdo.common.excel.ExcelUtils#getSheetObjectData(File, int)
	 * @since HOZDoEAS7.0 1.0
	 */
	Object[][] getSheetObjectData(File file, int sheetIndex) throws FileNotFoundException, IOException;

	/**
	 *
	 * <Excel>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 11:29:07> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param sheetIndex
	 * 			<code>Sheet</code>Excel0
	 * @return
	 * 			{@link java.lang.String} 
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 *			IO
	 *
	 * @see com.kingdee.eas.hozdo.common.excel.ExcelUtils#getSheetData(File, int)
	 * @since HOZDoEAS7.0 1.0
	 */
	String[][] getSheetData(File file, int sheetIndex) throws FileNotFoundException, IOException;


}