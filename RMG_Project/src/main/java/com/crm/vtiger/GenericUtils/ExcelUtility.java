package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class contains method for reading the data from Excel sheet
 * @author SOUMYASANTA SAHOO
 *
 */
public class ExcelUtility {
	
	/**
	 * This method used to read data from Excel by specifying sheetname, rownum & cellnum
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetname, int rownum, int cellnum) throws IOException
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet=wb.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		return cell.getStringCellValue();
	}
	
	/**
	 * This method return all the data in the sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetname) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet=wb.getSheet(sheetname);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	/**
	 * This method will return cell value by giving testcase ID and header value
	 * @param sheetname
	 * @param tcID
	 * @param headerValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetname, String tcID, String headerValue) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_PATH1);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet=wb.getSheet(sheetname);
		int lastRow=sheet.getLastRowNum();
		int expectedRow=0;
		for(int i=0;i<lastRow;i++)
		{
			String testCaseID=sheet.getRow(i).getCell(0).getStringCellValue();
			if(testCaseID.equalsIgnoreCase(tcID))
			{
				expectedRow=i;
				break;
			}
		}
		expectedRow--;
		int expectedColumn=0;
		int lastCell=sheet.getRow(expectedRow).getLastCellNum();
		for(int j=0;j<lastCell;j++)
		{
			String value=sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if(value.equalsIgnoreCase(headerValue))
			{
				expectedColumn=j;
				break;
			}
		}
		return sheet.getRow(expectedRow+1).getCell(expectedColumn).getStringCellValue();
	}
	
	/**
	 * This method is used to write data inside the excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeExcelData(String sheetname,int rownum,int column, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream(IPathConstant.EXCEL_PATH);
		Workbook wb=WorkbookFactory.create(file);
		wb.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writeFile=new FileOutputStream(IPathConstant.EXCEL_PATH);
		wb.write(writeFile);
	}

}
