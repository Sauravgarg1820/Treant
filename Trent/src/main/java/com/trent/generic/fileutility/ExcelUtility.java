package com.trent.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getdatafromexcelsheet(String sheetName, int rowNumber, int cellNumber) throws Throwable {
		FileInputStream fis = new FileInputStream("./Test Data/Trent workbook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./Test Data/Trent workbook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setdatafromexcelsheet(String sheetName, int rowNumber, int cellNumber) throws Throwable {
		FileInputStream fis = new FileInputStream("./Test Data/Trent workbook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber);

		FileOutputStream fos = new FileOutputStream("./Test Data/Trent workbook.xlsx");
		wb.close();

	}
}