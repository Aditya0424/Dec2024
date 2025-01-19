package nbs.cdc.Suite;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class myTests extends nbs.cdc.SuiteResources.Base{

	
	@Test(dataProviderClass = nbs.cdc.SuiteResources.dataProvider.class , dataProvider= "dataProvider1")
	public void runFBTest(String usn, String pwd) throws IOException {
		System.out.println(usn);
		System.out.println(pwd);
		driver.findElement(By.cssSelector("#email")).sendKeys(usn);
		driver.findElement(By.cssSelector("#pass")).sendKeys(pwd);
	}
	
	

}
