/*
 * 
 * Copyright (c) 2011 - HOZDO Logistics Co.,Ltd All Right Reserved.
 *  HOTEL1802 STUDIO 
 *
 * 
 * 
 *
 */

/**
 *  : <HOTEL1802 STUDIO>
 * JDK  : <1.6.10>
 *  : <JavaBasic>
 *
 *  : <edu.frank.base.data>
 *  : <JSONDom.java>
 *  : 1.0
 * <...>
 *
 *  : <Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com">Frank Deng</a>>
 *  : <2011-10-13 02:27:03>
 *  :
 * <>				<>					<>
 *
 */
package edu.frank.base.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import edu.frank.log4j.Log4JConfig;

/**
 * <p>
 * 	<>
 * </p>
 *
 * @author &lt Frank Deng Email:<a href="mailto:yoyudneghihi@gmail.com?subject=Java Program Communication">Frank Deng</a> &gt
 * <p>
 *
 * 	Frank Deng <p>
 * <2011-10-13 02:27:03> <p>
 * <> <p>
 *
 * @Since JavaBasic 1.0.0.0
 * @Version JavaBasic 1.0.0.0
 */
public class JSONDom {

	private static final Logger logger = Log4JConfig.getLogger(JSONDom.class);

	public JSONObject parserJSON(String json) throws IllegalArgumentException{
		if (StringUtils.isBlank(json)) {
			throw new IllegalArgumentException(
					"Invalid parameter, json string is empty.");
		}
		return JSONObject.fromObject(json);
	}

	public JSONObject[] getLeaves(String leafKey, JSONObject root)
			throws IllegalArgumentException, Exception {
		if (StringUtils.isBlank(leafKey)) {
			throw new IllegalArgumentException(
					"Invalid parameter, leaf key is empty.");
		}
		if (root == null) {
			throw new IllegalArgumentException(
					"Invalid parameter, parent is null.");
		}
		java.util.List<JSONObject> allLeavesList = new java.util.ArrayList<JSONObject>();
		JSONObject[] allLeaves = new JSONObject[0];
		if (isJSONLeaf(root)) {
			ArrayUtils.add(allLeaves, root);
		} else {
			java.util.Iterator iterator = root.keys();
			while (iterator.hasNext()) {
				String childKey = (String) iterator.next();
				Object child = root.get(childKey);
				if (child != null) {
					getJSONChild(allLeavesList, child);
				}
			}
		}
		if (allLeavesList != null) {
			java.util.List<JSONObject> tempAllLevesList = new java.util.ArrayList<JSONObject>(Arrays.asList(new JSONObject[allLeavesList.size()]));
			Collections.copy(tempAllLevesList, allLeavesList);
			java.util.Iterator iterator = tempAllLevesList.iterator();
			while (iterator.hasNext()) {
				JSONObject leaf = (JSONObject) iterator.next();
				if (leaf == null) {
					allLeavesList.remove(leaf);
					continue;
				}
				boolean isFindOut = false;
				java.util.Iterator contextIterator = leaf.keys();
				while (contextIterator.hasNext()) {
					String key = (String) contextIterator.next();
					if (!StringUtils.isBlank(key) && key.equalsIgnoreCase(leafKey)) {
						isFindOut = true;
						break;
					}
				}
				if (!isFindOut) {
					allLeavesList.remove(leaf);
				}
			}
			allLeaves = allLeavesList.toArray(new JSONObject[allLeavesList.size()]);

		}
		return allLeaves;
	}

	public void getJSONChild(java.util.List<JSONObject> allLeavesList, Object parent)
			throws Exception {
		if (parent instanceof JSONObject) {
			if (isJSONLeaf((JSONObject) parent)) {
				allLeavesList.add((JSONObject) parent);
				return;
			}
			java.util.Iterator iterator = ((JSONObject) parent).values()
					.iterator();
			while (iterator.hasNext()) {
				Object child = iterator.next();
				if (child != null) {
					getJSONChild(allLeavesList, child);
				}
			}
		} else if (parent instanceof JSONArray) {
			java.util.Iterator iteartor = ((JSONArray) parent).iterator();
			while (iteartor.hasNext()) {
				JSONObject child = (JSONObject) iteartor.next();
				if (child != null) {
					getJSONChild(allLeavesList, child);
				}
			}
		} else {
			return;
		}
	}

	//public JSONObject getJSONLeaf()

	public boolean isJSONLeaf(JSONObject node) throws IllegalArgumentException,
			Exception {
		if (node == null) {
			throw new IllegalArgumentException(
					"Invalid parameter, node of JSONObject is null.");
		}
		java.util.Iterator<String> iterator = node.keys();
		if (iterator.hasNext()) {
			String childKey = iterator.next();
			Object child = node.get(childKey);
			if (child != null) {
				if (!(child instanceof JSONObject)
						&& !(child instanceof JSONArray)) {
					return true;
				}
			} else {
				throw new Exception("JSONJSONnull");
			}
		}
		return false;
	}

	public static void main(String[] args) {
		JSONDom jsonDom = new JSONDom();
		/********************* JSON ************************************/
		StringBuffer sbJson = new StringBuffer("{");
		// -------
		// 
		sbJson.append("\"header\":[{");

		/*font setting*/
		sbJson.append("\"font\":[{");
		sbJson.append("\"font\":\"\",");
		sbJson.append("\"font-family\":\"Verdana, Geneva, sans-serif\",");  /*tahoma, verdana, simsum*/
		sbJson.append("\"font-size\":\"14px\",");
		sbJson.append("\"font-weight\":\"bolder\",");
		sbJson.append("\"color\":\"#4f6b72\"");
		sbJson.append("}]");
		sbJson.append(",");
		/*background setting*/
		sbJson.append("\"background\":[{");
		sbJson.append("\"background\":\"\","); /*none,important*/
		sbJson.append("\"background-color\":\"#e6eae9\"");
		sbJson.append("}]");

		sbJson.append("}]");
		sbJson.append(",");
		// 
		sbJson.append("\"body\":[{");
		sbJson.append("}]");
		sbJson.append(",");
		// 
		sbJson.append("\"footer\":[{");
		sbJson.append("}]");
		// -------
		sbJson.append("}");
		/***********************************************************************/
		try {
			JSONObject jsonRoot = jsonDom.parserJSON(sbJson.toString());
			JSONObject[] leaves = jsonDom.getLeaves("font", jsonRoot);
			for (int i = 0; i < leaves.length; i++) {
				JSONObject jsonObject = leaves[i];
				if (jsonObject != null) {
					logger.debug("------------- node:\n" + jsonObject.toString());
				}
			}
			java.io.File file = new java.io.File("E:\\test.xls");
			if (file != null) {
				if (!file.exists()) {
					file.createNewFile();
				}
			}
			//jsonDom.loadExcel(file);
			jsonDom.exportExcel(file, leaves);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	public void exportExcel(java.io.File file, JSONObject[] fonts) throws FileNotFoundException, IOException{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("test");
		HSSFCellStyle columnStyle = workbook.createCellStyle();
		columnStyle.setFillForegroundColor((short) 13);
		columnStyle.setFillPattern((short)CellStyle.SOLID_FOREGROUND);
		sheet.setDefaultColumnStyle(1, columnStyle);
		String[][] headerData = new String[][] {
				{"", ""}
		};
		int[][] bodyData = new int[][] {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		HSSFCellStyle headerCellStyle = workbook.createCellStyle();
		//headerCellStyle.setFillBackgroundColor((short) 189);
		// 
		HSSFFont headerFont = workbook.createFont();
		headerFont.setFontName("");
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short) 16);
		headerFont.setColor((short) HSSFColor.BLUE.index2);
		headerCellStyle.setFont(headerFont);

		int headerCount = headerData.length;
		for (int i = 0; i < headerCount; i++) {
			HSSFRow header = sheet.createRow(i);
			header.setRowStyle(headerCellStyle);
			String[] headerContext = headerData[i];
			int columnLength = headerContext.length;
			for (int j = 0; j < columnLength; j++) {
				String cellValue = headerData[i][j];
				HSSFCell cell = header.createCell(j);
				cell.setCellValue(cellValue);
				cell.setCellStyle(headerCellStyle);

			}
		}
		int lastRowNum = sheet.getLastRowNum();
		int bodyCount = bodyData.length;
		int rowIndex = 0;
		for (int i = lastRowNum + 1; i <= bodyCount; i++) {
			HSSFRow header = sheet.createRow(i);
			//header.setRowStyle(headerCellStyle);
			int[] bodyContext = bodyData[rowIndex];
			int columnLength = bodyContext.length;
			for (int j = 0; j < columnLength; j++) {
				int cellValue = bodyData[rowIndex][j];
				HSSFCell cell = header.createCell(j);
				cell.setCellValue(cellValue);
				//cell.setCellStyle(headerCellStyle);

			}
			rowIndex++;
		}
		HSSFRow formulaRow = sheet.getRow(1);
		HSSFCell formulaCell = formulaRow.createCell(2);
		formulaCell.setCellFormula("SUM(A2:B2)");
		formulaCell = formulaRow.createCell(3);
		formulaCell.setCellFormula("SUBTOTAL(9, A2:A4)");

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.flush();
		fos.close();
	}

	public void loadExcel(java.io.File file) throws FileNotFoundException, IOException {
		if (file != null && file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow row = sheet.getRow(0);
			HSSFCell cell = row.getCell(0);
			HSSFCellStyle cellStyle = cell.getCellStyle();
			HSSFFont font = cellStyle.getFont(workbook);
			cellStyle.setFillBackgroundColor((short)189);
			logger.debug("font name:" + font.getFontName());
			row = sheet.getRow(3);
			cell = row.getCell(4);
			if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				HSSFFormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator(workbook);
				System.out.println("------------- formula : " + cell.getCellFormula() + "------------ value : " + formulaEvaluator.evaluate(cell).getNumberValue());
			}
			sheet.setDefaultColumnStyle(0, cellStyle);
			fis.close();
		}
	}

}