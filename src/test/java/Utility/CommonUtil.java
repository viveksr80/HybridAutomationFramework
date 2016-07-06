package Utility;

import factory.DataProviderFactory;

public class CommonUtil 
{
	
	public static Object[][] getData(String sheetName)
	{
		
		int row = DataProviderFactory.getExcel1().getRowCont(sheetName);
		int col = DataProviderFactory.getExcel1().getColumnCount(sheetName);
		
		Object data[][] = new Object[row-1][col];
		
		for(int rowNum=2; rowNum <= row; rowNum++){
			for(int colNum=0; colNum<col; colNum++){
				data[rowNum-2][colNum] = DataProviderFactory.getExcel1().getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}

}
