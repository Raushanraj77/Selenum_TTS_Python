
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ZipFileTest {
	
	WebDriver driver;
	
@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
	   
	}

@Test

	public void testSearch() throws IOException, InterruptedException
	{
	    
	    String file = ".\\Data\\data2.xlsx";
	 
	    ZipClass zipcls = new ZipClass();
	    zipcls.zipfiles(file , ".\\Data\\kushan.zip");
		
	  
	    
	   driver.findElement(By.xpath("//body/div/div[2]/div[1]/input[2]")).sendKeys("C:\\Users\\kam\\selenium_tryouts\\SeleniumCompressandUpload\\Data\\kushan.zip");
		Thread.sleep(5000);
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
