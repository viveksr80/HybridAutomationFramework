package dataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public String path = "./ApplicationData/AppData.xlsx";
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public ExcelReader(String path)
	{
		this.path = path;
		//File src = new File("./ApplicationData/AppData.xlsx");
		try 
		{
			
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			fis.close();
			
		} catch (Exception e) {
			
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
	
	//return the row count
	public int getRowCont(String sheetName)
	{
		int index = wb.getSheetIndex(sheetName);
		if(index==-1)
	
			return 0;
		else{
			sheet = wb.getSheetAt(index);
			int number = sheet.getLastRowNum()+1;
			return number;
		}
		
	}
	
	//return column count
	public int getColumnCount(String sheetName)
	{
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(0);
		if(row==null)
			return 0;
		int num = row.getLastCellNum();
		return num;
		
	}
	
	//
	public String getCellData(String sheetName, int colNum, int rowNum){
		int index = wb.getSheetIndex(sheetName);
		if(index==-1)
			return "";
		sheet = wb.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(colNum);
		if(cell==null)
			return "";
		
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA){
			String cellText = String.valueOf(cell.getNumericCellValue());
			return cellText;
		}else{
			
			return "";
				
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
