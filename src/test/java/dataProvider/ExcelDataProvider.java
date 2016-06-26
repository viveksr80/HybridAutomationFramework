package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
		File src = new File("./ApplicationData/AppData.xlsx");
		try 
		{
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
	
	public String getData(int sheetIndex, int row, int col)
	{
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		return data;	
	}
	
	public String getdata(String sheetName, int row, int col)
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return data;	
	}

}
