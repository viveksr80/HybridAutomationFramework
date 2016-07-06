package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import dataProvider.ExcelReader;

public class DataProviderFactory 
{
	
	public 	static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	
	public 	static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}
	
	public 	static ExcelReader getExcel1()
	{
		ExcelReader excel1 = new ExcelReader("./ApplicationData/AppData.xlsx");
		return excel1;
	}

}
