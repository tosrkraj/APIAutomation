package Utility;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ExcelUtils {
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath,String sheetname)
	{
		

		try {
			wb = new XSSFWorkbook(excelpath);
			sheet = wb.getSheet(sheetname);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	
		public void datadriventests()
	{
		
		
		int totalrowcount = 0;
		int statuscode = 0;
		int i=0,j=0;
		totalrowcount = sheet.getLastRowNum();
		
		
		String unit,consumption,site_id,year,month,Energy_consumption,business_unit_desc;		
		
		System.out.println("String Value of 1 ROW " +sheet.getRow(1).getCell(0));
		
		
		RestAssured.baseURI = "https://data.calgary.ca";
		
		
				//RequestSpecification Request = 
					
				
		for (i=1;i<=totalrowcount;i++)
		
		{
			
				Response response = given().contentType(ContentType.JSON).log().all()
				.get("/resource/crbp-innf.json?site_id="+sheet.getRow(i).getCell(2)
								+ "&month=" + sheet.getRow(i).getCell(6)
								+ "&year=" + sheet.getRow(i).getCell(5)
								+ "&total_consumption=" + sheet.getRow(i).getCell(7));
				
				
				response.prettyPrint();
				
				
			
				JsonPath extractor = response.jsonPath();
				
				unit = extractor.getString("unit");
				consumption = extractor.getString("total_consumption");
				site_id = extractor.getString("site_id");
				year = extractor.getString("year");
				month = extractor.getString("month");
				Energy_consumption = extractor.getString("energy_description");
				business_unit_desc = extractor.getString("business_unit_desc");
						
				statuscode = response.getStatusCode();
				
			
				
				Assert.assertEquals(statuscode,200);
				Assert.assertEquals(unit,"["+sheet.getRow(i).getCell(8)+"]");
				Assert.assertEquals(consumption,"["+sheet.getRow(i).getCell(7)+"]");
				Assert.assertEquals(site_id,"["+sheet.getRow(i).getCell(2)+"]");
				Assert.assertEquals(year,"["+sheet.getRow(i).getCell(5)+"]");
				Assert.assertEquals(month,"["+sheet.getRow(i).getCell(6)+"]");
				Assert.assertEquals(Energy_consumption,"["+sheet.getRow(i).getCell(4)+"]");
				Assert.assertEquals(business_unit_desc,"["+sheet.getRow(i).getCell(0)+"]");
				
				//sheet.getRow(i).getCell(9).setCellValue("Passed");
				
	
		
		}		
		
	
	}		
		
	}
	


