package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fabricator.Alphanumeric;
import fabricator.Calendar;
import fabricator.Contact;
import fabricator.Fabricator;
import fabricator.enums.DateFormat;



public class NewCustomer {
	
	WebDriver driver;
	Alphanumeric alpha = Fabricator.alphaNumeric();
	Contact contact = Fabricator.contact();
	Calendar cal = Fabricator.calendar();
	
	  By cutomerName = By.name("name");
	  By male = By.name("rad1");
	  By dob = By.name("dob");
	  By address = By.name("addr");
	  By city = By.name("city");
	  By state = By.name("state");
	  By pinno = By.name("pinno");
	  By telephoneno = By.name("telephoneno");
	  By password = By.name("password");
	  By createCustomerButton = By.name("sub");
	  By email = By.name("emailid");
    public NewCustomer(WebDriver driver){

        this.driver = driver;

      
    }
    
    public void createNewCustomer()
    {
    	
    	
    	driver.findElement(cutomerName).sendKeys(contact.firstName());
    	driver.findElement(male).click();
    	driver.findElement(dob).sendKeys(DateFormat.dd_MM_YYYY_BACKSLASH.toString()); 
    	driver.findElement(address).sendKeys(contact.address());
    	driver.findElement(city).sendKeys(contact.city());
    	driver.findElement(state).sendKeys(contact.state());
    	driver.findElement(pinno).sendKeys("123456");
    	driver.findElement(telephoneno).sendKeys("123355666");
    	driver.findElement(email).sendKeys(contact.eMail());
    	driver.findElement(password).sendKeys("123355666");
    	driver.findElement(createCustomerButton).click();
  
    }
    
    public void navigateNewCustomer(WebDriver driver)
    {
    	driver.navigate().to("https://demo.guru99.com/v4/manager/addcustomerpage.php");
    }
    

}
