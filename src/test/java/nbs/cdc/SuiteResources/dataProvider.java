package nbs.cdc.SuiteResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class dataProvider {

	@DataProvider
	public Object[][] dataProvider1() throws IOException {
		
		FileInputStream fis= new FileInputStream("E://My Learning//My Learnings//Selenium//FIles//fb.xlsx");
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		
		XSSFSheet sheet= wb.getSheet("Sheet1");
		
		int rowCount= sheet.getLastRowNum();
		int colCount= sheet.getRow(1).getLastCellNum();
		
		//System.out.println(rowCount+"_"+colCount);
		
		Object[][] data= new Object[rowCount][colCount];
		for(int i=1; i<rowCount+1; i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<colCount; j++) {
				XSSFCell cell= row.getCell(j);
				String cellVal= (cell!=null) ? cell.toString() : " ";
				data[i-1][j]= cellVal;
				//System.out.println(cellVal);
			}
		}
		
		wb.close();  // Close the workbook
	    fis.close(); // Close the FileInputStream
		return data;
	    
		
		
	}

}
