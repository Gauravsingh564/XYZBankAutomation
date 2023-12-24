package com.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	public String[][] getExcelFileData(String path,String sheet) throws Exception{
		FileInputStream f= new FileInputStream(path);
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sheets=wb.getSheet(sheet); 
		int row=sheets.getPhysicalNumberOfRows();
		int col=sheets.getRow(0).getPhysicalNumberOfCells();
		System.out.println(row);
		System.out.println(col);
		String[][] data=new String [row-1][col]; 
		for(int i=1;i<row;i++) {
			Row r=sheets.getRow(i);
			for(int j=0;j<col;j++) {
				data[i-1][j]=r.getCell(j).toString();
			}
		}
		f.close();
		return data;
	}

}
