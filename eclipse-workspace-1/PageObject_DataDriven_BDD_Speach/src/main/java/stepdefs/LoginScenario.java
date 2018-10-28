package stepdefs;

import java.util.concurrent.TimeUnit;

import javax.speech.synthesis.Synthesizer;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import SpeachReporting.SpeachReporting;
import ExtentReport.ExtentReport;
import PageObject.*;
import JSONRead.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;


public class LoginScenario {
	     WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	
	    ExtentReport extRpt = new ExtentReport();
	    
	    SpeachReporting speachRpt = new SpeachReporting();
	   
	    Synthesizer syn; 
	    JSONReader jsonRead = new JSONReader();
	    Logger log = Logger.getLogger("devpinoyLogger");
	@Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
		    syn = speachRpt.setupSpeachReporting();
		    System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	        driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	        
	        driver.get(jsonRead.jsonRead(".\\Data\\sel.json", "URL"));
	     
	        speachRpt.speachReport("Navigated to" + jsonRead.jsonRead(".\\Data\\sel.json", "URL"),syn);
	        log.debug("Navigating to Login Page");
	        extRpt.setUpReport();
	  
	}
	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	  
		   extRpt.startTestCase("User Login");
	
		    objLogin = new Login(driver);

		    //Verify login page title

		   
		    
		    String loginPageTitle = objLogin.getLoginTitle();

		 //   Assert.assertTrue(loginPageTitle.toLowerCase().contains(jsonRead.jsonRead(".\\Data\\sel.json", "TITLE")));

		    //login to application

		    objLogin.loginToGuru99(jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME"), jsonRead.jsonRead(".\\Data\\sel.json", "PASSWORD"));
		    speachRpt.speachReport("Loggen in with User Name " + jsonRead.jsonRead(".\\Data\\sel.json", "PASSWORD"),syn);
		    log.debug("Entered the user name and password" + jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME") + "and"  +jsonRead.jsonRead(".\\Data\\sel.json", "PASSWORD"));
		    extRpt.logEvents("Logged Successfully");

	   
	}
	
	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		 objHomePage = new HomePage(driver);

		    //Verify home page

		 objHomePage = new HomePage(driver);

		    //Verify home page

		    assertThat(objHomePage.getHomePageDashboardUserName().toLowerCase()).isEqualTo("manger id : mgr123");
		    speachRpt.speachReport("Successfully Navigated to Home Page",syn);
		    driver.close();
		    extRpt.createFinalReport();
		    log.debug("Creating final report");
	
	}

}
