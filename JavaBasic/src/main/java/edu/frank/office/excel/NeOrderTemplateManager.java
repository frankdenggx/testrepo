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
 *  : <NeOrderTemplateManager.java>
 *  : 1.0
 * 
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-24 10:55:24>
 *
 *
 */
package edu.frank.office.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.frank.log4j.Log4JConfig;



/**
 * <p>
 * 	<>
 * </p>
 *  @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-24 10:55:24> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public class NeOrderTemplateManager extends TemplateManager {

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(NeOrderTemplateManager.class);

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static NeOrderTemplateManager manager = null;

	/**
	 *
	 * &lt  <code>NeOrderTemplateManager</code>  &gt
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private NeOrderTemplateManager() {
		super();
	}

	/**
	 *
	 * <>
	 *
	 * @author < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>><p>
	 *
	 * <> <p>
	 * <2011-6-24 11:44:54> <p>
	 * :	<> <p>
	 *
	 * @return
	 *			
	 * @since HOZDoEAS7.0 1.0
	 */
	public static NeOrderTemplateManager getManager() {
		if (manager == null) {
			manager = new NeOrderTemplateManager();
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
	public String[][] getSheetData(HSSFWorkbook workbook, int sheetIndex, int destInfo, String flag) throws FileNotFoundException, IOException{
		if (workbook == null) {
			throw new IOException("");
		}
		if (sheetIndex < 0) {
			throw new IOException("");
		}
		if (!(!StringUtils.isBlank(flag) && ((flag.equalsIgnoreCase("ROW|INDEX")) || (flag.equalsIgnoreCase("ROW|NUM"))
				|| (flag.equalsIgnoreCase("COLUMN|INDEX")) || (flag.equalsIgnoreCase("COLUMN|NUM"))))) {
			logger.error("FLAG=" + flag);
			throw new IOException(",\"ROW|INDEX\"\"ROW|NUM\"\"COLUMN|INDEX\"\"COLUMN|NUM\"");
		}

		if (flag.equalsIgnoreCase("ROW|INDEX")) {
			return getSheetIndexData(workbook, sheetIndex, destInfo, 1);
		} else if (flag.equalsIgnoreCase("ROW|NUM")) {
			String[][] sheetData = this.excelUtils.getSheetData(workbook, sheetIndex);
			int columnNum = (sheetData[destInfo - 1]).length;
			return getSheetNumData(workbook, sheetIndex, destInfo, columnNum);
		} else if (flag.equalsIgnoreCase("COLUMN|INDEX")) {
			return getSheetIndexData(workbook, sheetIndex, 1, destInfo);
		} else if (flag.equalsIgnoreCase("COLUMN|NUM")) {
			//
			String[][] sheetData = this.excelUtils.getSheetData(workbook, sheetIndex);
			int rowNum = sheetData.length;
			return getSheetNumData(workbook, sheetIndex, rowNum, destInfo);
		}

		logger.error("FLAG=" + flag);
		throw new IOException(",\"NUM\"\"INDEX\"");
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
	public String[][] getSheetData(HSSFWorkbook workbook, int[] sheetIndexs, int destInfo, String flag) throws FileNotFoundException, IOException{
		if (workbook == null) {
			throw new IOException("");
		}
		if (ArrayUtils.isEmpty(sheetIndexs)) {
			return new String[0][0];
		}
		java.util.List sheetsData = new java.util.ArrayList(sheetIndexs.length);
		for (int i = 0; i < sheetIndexs.length; i++) {
			String[][] sheetData = getSheetData(workbook, sheetIndexs[i], destInfo, flag);
			sheetsData.add(sheetData);
		}
		try {
			return componentSheetsData(sheetsData);
		} catch (Exception e) {
			throw new IOException("");
		}
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
	private String[][] getSheetIndexData(HSSFWorkbook workbook, int sheetIndex, int rowIndex, int columnIndex) throws FileNotFoundException, IOException {
		if ((rowIndex < 1) || (columnIndex < 1)) {
			logger.error("ROW_INDEX=" + rowIndex + ",COLUMN_INDEX=" + columnIndex);
			throw new IOException("1");
		}

		String[][] fetchData = null;
		try{
			String[][] sheetData;
			sheetData = this.excelUtils.getSheetData(workbook, sheetIndex);
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
	private String[][] getSheetNumData(HSSFWorkbook workbook, int sheetIndex, int rowNum, int columnNum) throws FileNotFoundException, IOException{
		if ((rowNum < 1) || (columnNum < 1)) {
			logger.error("ROW=" + rowNum + ",COLUMN=" + columnNum);
			throw new IOException("1");
		}
		String[][] fetchData = null;
		try{
			fetchData = new String[rowNum][columnNum];
			String[][] sheetData;
			sheetData = this.excelUtils.getSheetData(workbook, sheetIndex);
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

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-9-5 11:57:21> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @param releaseFlag
	 * 			
	 * @return
	 * 			
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 * 			
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public int[] getReleaseSheetIndexs(HSSFWorkbook workbook, String releaseFlag) throws FileNotFoundException, IOException {
		return this.excelUtils.getExcelSheetIndexs(workbook, releaseFlag);
	}

	public HSSFWorkbook getWorkbook(File file) throws FileNotFoundException, IOException {
		return this.excelUtils.getWorkbook(file);
	}

	public int getSheetCount(HSSFWorkbook workbook) throws FileNotFoundException, IOException {
		return this.excelUtils.getExcelSheetCount(workbook);
	}

	public String[][] componentAllData (String[][] originalSheetData, String[][] addSheetsData, String[][] releaseSheetsData) throws FileNotFoundException, IOException {
		try {
			java.util.Map orginalSheetDataMap = new java.util.HashMap();
			orginalSheetDataMap.put("referenceData", originalSheetData);
			componentData(orginalSheetDataMap, addSheetsData, 0);
			componentData(orginalSheetDataMap, releaseSheetsData, 1);
			return (String[][])orginalSheetDataMap.get("referenceData");
		} catch (Exception e) {
			throw new IOException("");
		}
	}

	private String[][] componentSheetsData(java.util.List sheetsData) throws Exception {
		if ((sheetsData == null) || (sheetsData.size() < 0)) {
			return null;
		}
		String[][] referenceData = new String[][]{};
		java.util.Map referenceDataMap = new java.util.HashMap();
		referenceDataMap.put("referenceData", referenceData);
		java.util.Iterator iterator = sheetsData.iterator();
		while (iterator.hasNext()) {
			String[][] sheetData = (String[][]) iterator.next();
			if (!ArrayUtils.isEmpty(sheetData)) {
				componentData(referenceDataMap, sheetData, 0);
			}
		}
		return (String[][]) referenceDataMap.get("referenceData");
	}

	private void componentData(java.util.Map referenceDataMap, String[][] sheetData, int flag) throws Exception {
		String[][] referenceData = (String[][]) referenceDataMap.get("referenceData");
		if (ArrayUtils.isEmpty(referenceData)) {
			referenceData = sheetData;
		} else {
			java.util.Map referenceMap = new java.util.HashMap();
			for (int i = 0; i < referenceData.length; i++) {
				String factory = referenceData[i][0];		// 
				String supplierCode = referenceData[i][4];	// 
				String officeCode = referenceData[i][5];			// 
				String deliveryCode= referenceData[i][7];	// 
				String materielCode = referenceData[i][12];	// 
				String issueNo = referenceData[i][13];	// 
				String deliveryDate = referenceData[i][10];	// 
				String deliveryTime = referenceData[i][11];	// 
				if (StringUtils.isBlank(factory)
						|| StringUtils.isBlank(supplierCode)
						|| StringUtils.isBlank(officeCode)
						|| StringUtils.isBlank(deliveryCode)
						|| StringUtils.isBlank(materielCode)
						|| StringUtils.isBlank(issueNo)
						|| StringUtils.isBlank(deliveryDate)
						|| StringUtils.isBlank(deliveryTime)
						){
					continue;
				}
				Integer integer = new Integer(i);
				SimpleNeOrderEntryInfo simpleNeOrderEntryInfo = getSimpleNeOrderEntryInfo(integer, i, referenceData);
				if (simpleNeOrderEntryInfo != null) {
	    			referenceMap.put(simpleNeOrderEntryInfo.toString(), simpleNeOrderEntryInfo);
	    		}
			}

			for (int i = 0; i < sheetData.length; i++) {
				String factory = sheetData[i][0];		// 
				String supplierCode = sheetData[i][4];	// 
				String officeCode = sheetData[i][5];			// 
				String deliveryCode= sheetData[i][7];	// 
				String materielCode = sheetData[i][12];	// 
				String issueNo = sheetData[i][13];	// 
				String deliveryDate = sheetData[i][10];	// 
				String deliveryTime = sheetData[i][11];	// 
				if (StringUtils.isBlank(factory)
						|| StringUtils.isBlank(supplierCode)
						|| StringUtils.isBlank(officeCode)
						|| StringUtils.isBlank(deliveryCode)
						|| StringUtils.isBlank(materielCode)
						|| StringUtils.isBlank(issueNo)
						|| StringUtils.isBlank(deliveryDate)
						|| StringUtils.isBlank(deliveryTime)
						){
					continue;
				}
				Integer integer = new Integer(i);
				SimpleNeOrderEntryInfo simpleNeOrderEntryInfo = getSimpleNeOrderEntryInfo(integer, i, sheetData);
				if (simpleNeOrderEntryInfo != null) {
					boolean isContains = referenceMap.containsKey(simpleNeOrderEntryInfo.toString());
					if (isContains) {
						SimpleNeOrderEntryInfo referenctEntryInfo = (SimpleNeOrderEntryInfo) referenceMap.get(simpleNeOrderEntryInfo.toString());
						Integer refInteger = referenctEntryInfo.getReference();
						int refIndex = refInteger.intValue();

						String refDeliveryNum = referenceData[refIndex][14];	// /
						String refSnp = referenceData[refIndex][19];	// SNP
			    		String refGoVolume = referenceData[refIndex][24];	// ()(M3)
			    		String refGoWeight = referenceData[refIndex][25];	// ()(T)
			    		String refGoNum = referenceData[refIndex][26];	// ()
			    		String refComeVolume = referenceData[refIndex][27];	// ()(M3)
			    		String refComeWeight = referenceData[refIndex][28];	// ()(T)
			    		String refComeNum = referenceData[refIndex][29];	// ()

			    		String deliveryNum = sheetData[i][14];	// /
			    		String snp = sheetData[i][19];	// SNP
			    		String goVolume = sheetData[i][24];	// ()(M3)
			    		String goWeight = sheetData[i][25];	// ()(T)
			    		String goNum = sheetData[i][26];	// ()
			    		String comeVolume = sheetData[i][27];	// ()(M3)
			    		String comeWeight = sheetData[i][28];	// ()(T)
			    		String comeNum = sheetData[i][29];	// ()

			    		java.math.BigDecimal bdNewDeliveryNum = null;
			    		if (!StringUtils.isBlank(refDeliveryNum) && !StringUtils.isBlank(deliveryNum)) {
			    			java.math.BigDecimal bdRefDeliveryNum = new java.math.BigDecimal(refDeliveryNum);
			    			java.math.BigDecimal bdDeliveryNum = new java.math.BigDecimal(deliveryNum);
			    			if (flag == 0) {	// 
			    				bdNewDeliveryNum =new java.math.BigDecimal(bdRefDeliveryNum.doubleValue() + bdDeliveryNum.doubleValue());
			    			} else { // 
			    				bdNewDeliveryNum = new java.math.BigDecimal(bdRefDeliveryNum.doubleValue() - bdDeliveryNum.doubleValue());
			    			}
			    			referenceData[refIndex][14] = String.valueOf(bdNewDeliveryNum);
			    		}

			    		if (!StringUtils.isBlank(refSnp) && !StringUtils.isBlank(snp)) {
			    			java.math.BigDecimal bdRefSnp = new java.math.BigDecimal(refSnp);
			    			java.math.BigDecimal bdSnp = new java.math.BigDecimal(snp);
			    			if (flag == 0) {	// 
			    				referenceData[refIndex][19] = String.valueOf(bdRefSnp.doubleValue() + bdSnp.doubleValue());
			    			} else {	// 
			    				referenceData[refIndex][19] = String.valueOf(bdRefSnp.doubleValue() - bdSnp.doubleValue());
			    			}
			    		}

			    		if (!StringUtils.isBlank(refGoVolume) && !StringUtils.isBlank(goVolume)) {
			    			java.math.BigDecimal bdRefGoVolume = new java.math.BigDecimal(refGoVolume);
			    			java.math.BigDecimal bdGoVolume = new java.math.BigDecimal(goVolume);
			    			if (flag == 0) {	// 
			    				referenceData[refIndex][24] = String.valueOf(bdRefGoVolume.doubleValue() + bdGoVolume.doubleValue());
			    			} else { // 
			    				referenceData[refIndex][24] = String.valueOf(bdRefGoVolume.doubleValue() - bdGoVolume.doubleValue());
			    			}
			    		}
			    		if (!StringUtils.isBlank(refGoWeight) && !StringUtils.isBlank(goWeight)) {
			    			java.math.BigDecimal bdRefGoWeight = new java.math.BigDecimal(refGoWeight);
			    			java.math.BigDecimal bdGoWeight = new java.math.BigDecimal(goWeight);
			    			if (flag == 0) {
			    				referenceData[refIndex][25] = String.valueOf(bdRefGoWeight.doubleValue() + bdGoWeight.doubleValue());
			    			} else {
			    				referenceData[refIndex][25] = String.valueOf(bdRefGoWeight.doubleValue() - bdGoWeight.doubleValue());
			    			}
			    		}
			    		java.math.BigDecimal bdNewPackingNum = null;
			    		if (!StringUtils.isBlank(refGoNum) && !StringUtils.isBlank(goNum)) {
			    			java.math.BigDecimal bdRefGoNum = new java.math.BigDecimal(refGoNum);
			    			java.math.BigDecimal bdGoNum = new java.math.BigDecimal(goNum);
			    			if (flag == 0) {
			    				bdNewPackingNum = new java.math.BigDecimal(bdRefGoNum.intValue() + bdGoNum.intValue());
			    			} else {
			    				bdNewPackingNum = new java.math.BigDecimal(bdRefGoNum.intValue() - bdGoNum.intValue());
			    			}
			    			referenceData[refIndex][26] = String.valueOf(bdNewPackingNum);
			    		}
			    		if (!StringUtils.isBlank(refComeVolume) && !StringUtils.isBlank(comeVolume)) {
			    			java.math.BigDecimal bdRefComeVolume = new java.math.BigDecimal(refComeVolume);
			    			java.math.BigDecimal bdComeVolume = new java.math.BigDecimal(comeVolume);
			    			if (flag == 0) {
			    				referenceData[refIndex][27] = String.valueOf(bdRefComeVolume.doubleValue() + bdComeVolume.doubleValue());
			    			} else {
			    				referenceData[refIndex][27] = String.valueOf(bdRefComeVolume.doubleValue() - bdComeVolume.doubleValue());
			    			}
			    		}
			    		if (!StringUtils.isBlank(refComeWeight) && !StringUtils.isBlank(comeWeight)) {
			    			java.math.BigDecimal bdRefComeWeight = new java.math.BigDecimal(refComeWeight);
			    			java.math.BigDecimal bdComeWeight = new java.math.BigDecimal(comeWeight);
			    			if (flag == 0) {
			    				referenceData[refIndex][28] = String.valueOf(bdRefComeWeight.doubleValue() + bdComeWeight.doubleValue());
			    			} else {
			    				referenceData[refIndex][28] = String.valueOf(bdRefComeWeight.doubleValue() - bdComeWeight.doubleValue());
			    			}
			    		}
			    		if (!StringUtils.isBlank(refComeNum) && !StringUtils.isBlank(comeNum)) {
			    			java.math.BigDecimal bdRefComeNum = new java.math.BigDecimal(refComeNum);
			    			java.math.BigDecimal bdNum = new java.math.BigDecimal(comeNum);
			    			if (flag == 0) {
			    				referenceData[refIndex][29] = String.valueOf(bdRefComeNum.intValue() + bdNum.intValue());
			    			} else {
			    				referenceData[refIndex][29] = String.valueOf(bdRefComeNum.intValue() - bdNum.intValue());
			    			}
			    		}
			    		if ((bdNewDeliveryNum != null) && (bdNewDeliveryNum.intValue() <= 0) && (bdNewPackingNum != null) && (bdNewPackingNum.intValue() <= 0)) {
			    			referenceData[refIndex][4] = "";	// 
			    			referenceData[refIndex][12] = "";	// 
			    			referenceData[refIndex][13] = "";	// 
			    		}
					} else {
						if (flag == 0) {
							// referenceData , referenceData
							int refLength = referenceData.length;
							int columnLength = referenceData[0].length;
							int newLength = refLength + 1;
							String[][] tempRef = new String[newLength][columnLength];
							for (int k = 0; k < refLength; k++) {
								for (int p = 0; p < columnLength; p++) {
									tempRef[k][p] = referenceData[k][p];
								}
							}
							for (int k = 0; k < columnLength; k++) {
								tempRef[refLength][k] = sheetData[i][k];
							}
							referenceData = tempRef;
						}
					}
	    		}
			}
		}
		referenceDataMap.put("referenceData", referenceData);
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-9-6 10:47:03> <p>
	 * :	<> <p>
	 *
	 * @param integer
	 * 			
	 * @param i
	 * 			
	 * @param data
	 * 			
	 * @return
	 * 			
	 * @throws Exception
	 * 			
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private SimpleNeOrderEntryInfo getSimpleNeOrderEntryInfo(Integer integer, int i, String[][] data) throws Exception {
		SimpleNeOrderEntryInfo simpleNeOrderEntryInfo = null;
		String factory = data[i][0];		// 
		String supplierCode = data[i][4];	// 
		String officeCode = data[i][5];			// 
		String deliveryCode= data[i][7];	// 
		String materielCode = data[i][12];	// 
		String issueNo = data[i][13];	// 
		String deliveryDate = data[i][10];	// 
		String deliveryTime = data[i][11];	// 
		if (!StringUtils.isBlank(factory)
				&& !StringUtils.isBlank(supplierCode)
				&& !StringUtils.isBlank(officeCode)
				&& !StringUtils.isBlank(deliveryCode)
				&& !StringUtils.isBlank(materielCode)
				&& !StringUtils.isBlank(issueNo)
				&& !StringUtils.isBlank(deliveryDate)
				&& !StringUtils.isBlank(deliveryTime)
				) {
			simpleNeOrderEntryInfo =
				new SimpleNeOrderEntryInfo(integer, factory.trim(), materielCode.trim(), supplierCode.trim(), officeCode.trim(), issueNo.trim(), deliveryCode.trim(), deliveryDate.trim(), deliveryTime.trim());
		}
		return simpleNeOrderEntryInfo;
	}

	/**
	 *
	 * <p>
	 * 	<[POJO]>
	 * </p>
	 *
	 *  @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 *		<> <p>
	 *	<2011-9-6 10:40:10> <p>
	 *	<>	 <p>
	 *
	 *
	 * @since HOZDoEAS7.0 1.0
	 * @Version HOZDoEAS7.0 1.0
	 */
	class SimpleNeOrderEntryInfo implements Serializable {
		/**
		 * <ID>
		 *
		 * @since HOZDoEAS7.0 1.0
		 */
		private static final long serialVersionUID = 2541193522130630628L;

		Integer reference;	// 
		String factory;		// 
		String materielCode;	// 
		String supplierCode;	// 
		String officeCode;		// 
		String issueNo;			// 
		String deliveryCode;	// 
		String deliveryDate;	// 
		String deliveryTime;	// 

		/**
		 *
		 * < <code>SimpleNeOrderEntryInfo</code> >
		 *
		 * @param reference
		 * @param factory
		 * @param materielCode
		 * @param supplierCode
		 * @param officeCode
		 * @param issueNo
		 * @param deliveryCode
		 * @param deliveryDate
		 * @param deliveryTime
		 * @since HOZDoEAS7.0 1.0
		 */
		public SimpleNeOrderEntryInfo(Integer reference, String factory,
				String materielCode,
				String supplierCode,
				String officeCode,
				String issueNo,
				String deliveryCode,
				String deliveryDate,
				String deliveryTime) {

			this.reference = reference;
			this.factory = factory;
			this.materielCode = materielCode;
			this.supplierCode = supplierCode;
			this.officeCode = officeCode;
			this.issueNo = issueNo;
			this.deliveryCode = deliveryCode;
			this.deliveryDate = deliveryDate;
			this.deliveryTime = deliveryTime;
		}

		public Integer getReference() {
			return this.reference;
		}

		public String getFactory() {
			return this.factory;
		}

		public String getMaterielCode() {
			return this.materielCode;
		}

		public String getSupplierCode() {
			return this.supplierCode;
		}

		public String getOfficeCode() {
			return this.officeCode;
		}

		public String getIssueNo() {
			return this.issueNo;
		}

		public String getDeliveryCode() {
			return this.deliveryCode;
		}

		public String getDeliveryDate() {
			return this.deliveryDate;
		}

		public String getDeliveryTime() {
			return this.deliveryTime;
		}

		@Override
		public boolean equals(Object obj) {
			SimpleNeOrderEntryInfo simpleNeOrderEntryInfo = (SimpleNeOrderEntryInfo) obj;
			if (this.factory.equals(simpleNeOrderEntryInfo.getFactory())
					&& this.materielCode.equals(simpleNeOrderEntryInfo.getMaterielCode())
					&& this.supplierCode.equals(simpleNeOrderEntryInfo.getSupplierCode())
					&& this.officeCode.equals(simpleNeOrderEntryInfo.getOfficeCode())
					&& this.issueNo.equals(simpleNeOrderEntryInfo.getIssueNo())
					&& this.deliveryCode.equals(simpleNeOrderEntryInfo.getDeliveryCode())
					&& this.deliveryDate.equals(simpleNeOrderEntryInfo.getDeliveryDate())
					&& this.deliveryTime.equals(simpleNeOrderEntryInfo.getDeliveryTime())) {
				return true;
			}
			return false;
			//return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return this.factory.hashCode()
			+ this.materielCode.hashCode()
			+ this.supplierCode.hashCode()
			+ this.officeCode.hashCode()
			+ this.issueNo.hashCode() * 29
			+ this.deliveryCode.hashCode()
			+ this.deliveryDate.hashCode()
			+ this.deliveryTime.hashCode();
		}

		/**
		 * <HashMapkey>
		 *
		 * @since HOZDoEAS7.0 1.0
		 */
		@Override
		public String toString() {
			return this.factory + this.materielCode + this.supplierCode + this.officeCode + this.issueNo + this.deliveryCode + this.deliveryDate + this.deliveryTime;
		}
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