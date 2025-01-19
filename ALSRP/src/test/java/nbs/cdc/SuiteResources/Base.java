package nbs.cdc.SuiteResources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base {
		
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\My Learning\\Softwares\\Selenium drivers\\chromedriver.exe\\");
		 driver=new ChromeDriver();
		 driver.get("https://www.facebook.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		
		captureScreenshot();
		driver.close();
		 
	}
	
	public void captureScreenshot() throws IOException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");  
		Date date=new Date();
		String myDate= formatter.format(date);
		//System.out.println(myDate);
		String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//System.out.println(methodName);
		
		WebElement element= driver.findElement(By.tagName("html"));
		//System.out.println(element.getAttribute("id"));
		File file= element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("Output/Evidences/" + methodName +"_"+ myDate +"_evidence.jpg" ));
	}
	
	

	
}
