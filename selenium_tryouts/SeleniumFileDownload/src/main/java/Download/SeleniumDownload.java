package Download;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumDownload {
	@Test

	public void downloadTest() throws InterruptedException
	{
	 
    WebDriver driver;
	System.setProperty("webdriver.chrome.driver",".\\util\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.thinkbroadband.com/download");
	
	String sourceLocation = "https://www.sample-videos.com/audio/mp3/crowd-cheering.mp3";
    String wget_command = "cmd /c .\\util\\wget.exe -P C: --no-check-certificate "+ sourceLocation;

    try {
         Process exec = Runtime.getRuntime().exec(wget_command);
         System.out.println("File downloading started..");
         int exitVal = exec.waitFor();
         System.out.println("File downloaded..");
         driver.close();
    } catch (IOException ex) {
         System.out.println(ex.toString());
    }
	
	}
}
