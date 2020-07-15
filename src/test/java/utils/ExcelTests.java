package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTests {
	
	public static void main(String[] args) {
		getRowCount();
		getCellData();
	}
	
	public static void getCellData() {
		
		try {
			String excelpath = "./data/testworksheet.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			DataFormatter formatter = new DataFormatter();
			String value =formatter.formatCellValue(sheet.getRow(1).getCell(1));
			System.out.println("Value is : "+ value);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getRowCount() {
		
			
		try {
			String excelpath = "./data/testworksheet.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int row = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: "+ row);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
