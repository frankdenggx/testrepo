package edu.frank.office.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface ITemplateManager {


	java.util.Map getExcelsData(File[] files) throws FileNotFoundException, IOException;

	java.util.Map getExcelData(File file) throws FileNotFoundException, IOException;

	Object[][] getSheetObjectData(File file, int sheetIndex) throws FileNotFoundException, IOException;

	String[][] getSheetData(File file, int sheetIndex) throws FileNotFoundException, IOException;


}
