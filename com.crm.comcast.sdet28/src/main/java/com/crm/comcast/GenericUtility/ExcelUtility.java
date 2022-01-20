package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Utility foe Excel File
 * @author kajal
 *
 */

public class ExcelUtility {
	/**
	 * This method will return string value from Excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String getStringCellData(String sheetName,int rowNo,int cellNo) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		return cell.getStringCellValue();
	}
	/**
	 * this method will return numeric cell data
	 * @param sheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
	public double getNumericCellData(String sheetName,int rowno,int cellno) throws Throwable{
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetName).getRow(rowno).getCell(cellno).getNumericCellValue();
	}
	/**
	 * This method will return multiple set of data from excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */

	public Object[][] getmultipleData(String sheetName) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowNo = sheet.getLastRowNum();
		int cellNo = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowNo][cellNo];
		for(int i=0;i<rowNo;i++) {
			for(int j=0; j<cellNo; j++) {
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return data;
		
	}


/**
 * This method will write data into excel sheet
 * @param sheetName
 * @param rowNo
 * @param cellNO
 * @param value
 * @throws Throwable 
 */
public void WriteDataIntoExcel(String sheetName,int rowNo,int cellNO,String value) throws Throwable {
	FileInputStream readfile = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
	Workbook workbook = WorkbookFactory.create(readfile);
	workbook.createSheet(sheetName).createRow(rowNo).createCell(cellNO).setCellValue(value);
	
	OutputStream writeFile = new FileOutputStream(IPathConstants.EXCEL_FILEPATH);
	workbook.write(writeFile);
	workbook.close();
	
}
	
}