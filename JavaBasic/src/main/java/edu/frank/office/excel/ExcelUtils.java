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
 *  : <ExcelUtils.java>
 *  : 1.0
 * Excel
 *
 *  : < Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * : <2011-6-22 03:35:08>
 *
 *
 */
package edu.frank.office.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.swing.JFileChooser;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<Excel>
 * </p>
 *  @author <Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>>
 * <p>
 *
 *		<> <p>
 *	<2011-6-22 03:35:08> <p>
 *	<>	 <p>
 *
 *
 * @since HOZDoEAS7.0 1.0
 * @Version HOZDoEAS7.0 1.0
 */
public class ExcelUtils {

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static final Logger logger = Log4JConfig.getLogger(ExcelUtils.class);

	/**
	 *<>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static ExcelUtils instance = null;

	/**
	 * <>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static String excelDescription = "Microsoft Office Excel (*.xls, *.xlsx)";

	/**
	 * <Excel>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private static String[] filters = {"xls", "xlsx"};

	/**
	 *
	 * &lt  <code>ExcelUtils</code>  &gt
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private ExcelUtils(){}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-22 03:39:18> <p>
	 * :	<> <p>
	 *
	 * @return
	 *		<code>ExcelUtils</code>
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public static ExcelUtils getInstance() {
		if (instance == null) {
			instance = new ExcelUtils();
		}
		return instance;
	}

	/**
	 *
	 * </>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-22 04:42:26> <p>
	 * :	<> <p>
	 *
	 * @param parentUI
	 * 			UI
	 * @param enableMultiple
	 * 			
	 * @return
	 *			Excel
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public File[] importExcel(java.awt.Component parentUI, String currentDirectoryPath, boolean enableMultiple) throws FileNotFoundException{
		File[] files = null;
		javax.swing.JFileChooser jFileChooser = new javax.swing.JFileChooser(currentDirectoryPath);
		jFileChooser.setFileFilter(new FileNameExtensionFilter(excelDescription, filters));
		jFileChooser.setMultiSelectionEnabled(enableMultiple);
		int option = jFileChooser.showOpenDialog(parentUI);
		if (option == JFileChooser.APPROVE_OPTION) {
			if (enableMultiple) {
				files = jFileChooser.getSelectedFiles();
			} else {
				files = new File[]{jFileChooser.getSelectedFile()};
			}
			if ((files == null) && (files.length <= 0)) {
				logger.error(",");
				throw new FileNotFoundException(",");
				//JOptionPane.showMessageDialog(parentUI, ",", "", JOptionPane.ERROR_MESSAGE);
				//MsgBox.showWarning(parentUI, ",");
				//return null;
			}
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if ((file == null) || !file.exists()) {
					logger.error(",");
					throw new FileNotFoundException(",");
					//JOptionPane.showMessageDialog(parentUI, ",", "", JOptionPane.ERROR_MESSAGE);
					//MsgBox.showWarning(parentUI, ",");
					//return null;
				}
			}
		}
		return files;
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-22 06:46:36> <p>
	 * :	<> <p>
	 *
	 * @param files
	 * 			Excel
	 * @return
	 *		  <code>excelsDataMap</code> {@link java.util.Map}KeyExcel,
	 * 		  ValueExcelExcel{@link java.util.Map}Key
	 * 		   (Sheet) Value (<code>Object[]{String[],String[],...,String[]}</code>)
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public java.util.Map getExcelsData(File[] files) throws FileNotFoundException, IOException{
		if ((files == null) || (files.length <= 0)) {
			return null;
		}
		java.util.Map excelsDataMap = new java.util.HashMap();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String fileName = file.getName();
			java.util.Map excelDataMap = getExcelData(file);
			excelsDataMap.put(fileName, excelDataMap);
		}
		return excelsDataMap;
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
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
	public java.util.Map getExcelData(File file) throws FileNotFoundException, IOException {
		if ((file == null) || !file.exists()) {
			return null;
		}
		InputStream in = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(in);
		if (workbook == null){
			return null;
		}
		java.util.Map excelFileMap = new java.util.HashMap();
		int sheetCount = workbook.getNumberOfSheets();	// 
		for (int i = 0; i < sheetCount; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);	// 
			if (sheet != null) {
				String sheetName = sheet.getSheetName();
				Object[][] sheetData = getSheetObjectData(workbook, i);
				excelFileMap.put(sheetName, sheetData);
			}
		}
		return excelFileMap;
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-22 05:59:15> <p>
	 * :	<> <p>
	 *
	 * @param workbook
	 * 			Excel
	 * @return
	 * 			<code>excelFileMap</code> {@link java.util.Map}KeySheet,
	 * 			Value
	 *
	 * @see java.util.Map
	 * @see {@link #getSheetObjectData(HSSFWorkbook, int)}
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private java.util.Map getExcelData(HSSFWorkbook workbook) throws FileNotFoundException, IOException {
		if (workbook == null){
			return null;
		}
		java.util.Map excelFileMap = new java.util.HashMap();
		int sheetCount = workbook.getNumberOfSheets();	// 
		for (int i = 0; i < sheetCount; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);	// 
			if (sheet != null) {
				String sheetName = sheet.getSheetName();
				Object[][] sheetData = getSheetObjectData(workbook, i);
				excelFileMap.put(sheetName, sheetData);
			}
		}
		return excelFileMap;
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
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
	 * @see {@link #getSheetObjectData(HSSFWorkbook, int)}
	 * @since HOZDoEAS7.0 1.0
	 */
	public Object[][] getSheetObjectData(File file, int sheetIndex) throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(in);
		return getSheetObjectData(workbook, sheetIndex);
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
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
	 * @see {@link #getSheetData(HSSFWorkbook, int)}
	 * @since HOZDoEAS7.0 1.0
	 */
	public String[][] getSheetData(File file, int sheetIndex) throws FileNotFoundException, IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		//InputStream in = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(in);
		return getSheetData(workbook, sheetIndex);
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-22 05:00:19> <p>
	 * :	<> <p>
	 *
	 * @param workbook
	 * 			Excel
	 * @param sheetIndex
	 * 			 Excel0
	 * @return
	 *			
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	private Object[][] getSheetObjectData(HSSFWorkbook workbook, int sheetIndex) throws IOException {
		Object[][] rowContent = null;
		if (workbook == null) {
			return null;
		}
		try{
			HSSFSheet worksheet = workbook.getSheetAt(sheetIndex);	//  sheetIndex 
			if (worksheet != null) {
				int lastRowNum = worksheet.getLastRowNum();	// 
				int lastColumnNum = worksheet.getRow(0).getLastCellNum();	// 
				rowContent = new Object[lastRowNum+1][lastColumnNum];
				for (int i = 0; i <= lastRowNum; i++) {
					HSSFRow row = worksheet.getRow(i);
					if (row == null) {
						continue;
					}
					//int lastColumnNum = row.getLastCellNum();	// 
					//String[] columnContent = new String[lastColumnNum];
					for (int j = 0; j < lastColumnNum; j++) {
						HSSFCell cell = row.getCell(j);	// 
						if (cell == null) {
							rowContent[i][j] = null;
						} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {	// 
							rowContent[i][j] = cell.getBooleanCellValue();
						} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {	// 
							rowContent[i][j] = cell.getNumericCellValue();
						} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
							rowContent[i][j] = cell.getErrorCellValue();
						} else {	//  {HSSFCell.CELL_TYPE_BLANK,
									//		HSSFCell.CELL_TYPE_FORMULA
									//		HSSFCell.CELL_TYPE_STRING
							rowContent[i][j] = cell.getStringCellValue();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new IOException("Excel");
		}

		return rowContent;
	}


	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a>&gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-6-22 05:00:19> <p>
	 * :	<> <p>
	 *
	 * @param workbook
	 * 			Excel
	 * @param sheetIndex
	 * 			 Excel0
	 * @return
	 *			
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public String[][] getSheetData(HSSFWorkbook workbook, int sheetIndex) throws IOException {
		String[][] rowContent = null;
		if (workbook == null) {
			return null;
		}
		try {
			HSSFSheet worksheet = workbook.getSheetAt(sheetIndex);	//  sheetIndex 
			if (worksheet != null) {
				int lastRowNum = worksheet.getLastRowNum();	// 
				HSSFRow hssfRow = worksheet.getRow(0);
				if (hssfRow == null) {
					return null;
				}
				int lastColumnNum = hssfRow.getLastCellNum();	// 
				rowContent = new String[lastRowNum+1][lastColumnNum];
				for (int i = 0; i <= lastRowNum; i++) {
					HSSFRow row = worksheet.getRow(i);
					if (row == null) {
						continue;
					}
					//int lastColumnNum = row.getLastCellNum();	// 
					//String[] columnContent = new String[lastColumnNum];
					for (int j = 0; j < lastColumnNum; j++) {
						Cell cell = row.getCell(j);	// 
						if (cell == null) {
							rowContent[i][j] = null;
						} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {	// 
							rowContent[i][j] = String.valueOf(cell.getBooleanCellValue());
						} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {	// 
							rowContent[i][j] = String.valueOf(cell.getNumericCellValue());
						} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {	// 
							//logger.error("Row: " + i + ",Column: " + j + "------------------ Formula : " + cell.getCellFormula());
							/*HSSFFormulaEvaluator evaluator = (HSSFFormulaEvaluator) workbook.getCreationHelper().createFormulaEvaluator();
							CellValue cellValue = evaluator.evaluate(cell);
							rowContent[i][j] = cellValue.getStringValue();*/
						}
						else {	//  {HSSFCell.CELL_TYPE_BLANK,
									//		HSSFCell.CELL_TYPE_ERROR
									//		HSSFCell.CELL_TYPE_FORMULA
									//		HSSFCell.CELL_TYPE_STRING
							rowContent[i][j] = cell.getStringCellValue();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new IOException("Excel");
		}

		return rowContent;
	}

	/**
	 *
	 * <Excel>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-9-5 12:05:51> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel
	 * @return
	 * 			Excel
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 * 			IO
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public int getExcelSheetCount(HSSFWorkbook workbook) throws FileNotFoundException, IOException {
		if (workbook == null){
			return 0;
		}
		return workbook.getNumberOfSheets();	// 
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-9-5 05:43:45> <p>
	 * :	<> <p>
	 *
	 * @param workbook
	 * 			
	 * @param sheetFlag
	 * 			
	 * @return
	 * 			
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 * 			IO
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public int[] getExcelSheetIndexs(HSSFWorkbook workbook, String sheetFlag) throws FileNotFoundException, IOException {
		if (workbook == null) {
			return null;
		}
		if (StringUtils.isBlank(sheetFlag)) {
			return null;
		}
		int sheetCount = workbook.getNumberOfSheets();
		int[] arraySheetIndexs = new int[sheetCount];
		Arrays.fill(arraySheetIndexs, -1);
		int specialSheetIndex = 0;
		for (int i = 0; i < sheetCount; i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);
			if (sheet != null) {
				String sheetName = sheet.getSheetName();
				int index = sheetName.indexOf(sheetFlag);
				if (index != -1) {
					arraySheetIndexs[specialSheetIndex] = i;
					specialSheetIndex++;
				}
			}
		}
		int[] sepecialSheetIndexs = new int[specialSheetIndex];
		specialSheetIndex = 0;
		for (int i = 0; i < sheetCount; i++) {
			if (arraySheetIndexs[i] != -1) {
				sepecialSheetIndexs[specialSheetIndex] = arraySheetIndexs[i];
				specialSheetIndex++;
			}
		}
		return sepecialSheetIndexs;
	}

	/**
	 *
	 * <>
	 *
	 * @author &lt Frank Deng Email:<a href="mailto:Guanxiong Deng@hozdo.com">Guanxiong Deng@hozdo.com</a> &gt
	 * <p>
	 *
	 * <> <p>
	 * <2011-9-5 05:42:41> <p>
	 * :	<> <p>
	 *
	 * @param file
	 * 			Excel 
	 * @return
	 * 			Excel
	 * @throws FileNotFoundException
	 * 			
	 * @throws IOException
	 * 			IO
	 *
	 * @since HOZDoEAS7.0 1.0
	 */
	public HSSFWorkbook getWorkbook(File file) throws FileNotFoundException, IOException {
		if ((file == null) || !file.exists()) {
			return null;
		}
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		HSSFWorkbook workbook = new HSSFWorkbook(in);
		in.close();
		return workbook;
	}


}