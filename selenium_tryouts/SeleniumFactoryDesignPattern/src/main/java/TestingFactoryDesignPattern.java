import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestingFactoryDesignPattern {
	

	    DriverManager driverManager;
	    WebDriver driver;

	    @BeforeTest
	    public void beforeTest() {
	        driverManager = DriverManagerFactory.getManager(DriverManagerFactory.DriverType.CHROME);
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        driver = driverManager.getDriver();
	    }

	    @AfterMethod
	    public void afterMethod() {
	        driverManager.quitDriver();
	    }

	    @Test
	    public void launchTestAutomationGuruTest() {
	        driver.get("http://google.com");
	        Assert.assertEquals("Google", driver.getTitle());
	    }

	    @Test
	    public void launchYahooTest() {
	        driver.get("https://www.yahoo.com");
	        Assert.assertEquals("Yahoo", driver.getTitle());
	    }

	}

