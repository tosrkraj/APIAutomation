package APIAutoMation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Utility.ExcelUtils;

public class DatadrivenTest {
	
	
	@Test
	public void DatadrivenExcelTest()
	{
		
		 		
				String path = "./Data/Data.xlsx";
				String sheets = "Data";
				
				
				ExcelUtils excels = new ExcelUtils(path,sheets);
				
				excels.datadriventests();
	
		
	}
	
	
	
	

}
