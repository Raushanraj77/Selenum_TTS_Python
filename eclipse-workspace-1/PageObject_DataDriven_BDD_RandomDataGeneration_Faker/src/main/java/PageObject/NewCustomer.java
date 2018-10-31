package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;



public class NewCustomer {
	
	WebDriver driver;
	Faker faker = new Faker();
	
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
    	
    	
    	driver.findElement(cutomerName).sendKeys(faker.name().firstName() + faker.name().lastName());
    	driver.findElement(male).click();
    	driver.findElement(dob).sendKeys("12/12/1980"); 
    	driver.findElement(address).sendKeys(faker.address().city());
    	driver.findElement(city).sendKeys(faker.address().city());
    	driver.findElement(state).sendKeys(faker.address().state());
    	driver.findElement(pinno).sendKeys("123456");
    	driver.findElement(telephoneno).sendKeys("123355666");
    	driver.findElement(email).sendKeys(faker.name().firstName()+"@yahoo.com");
    	driver.findElement(password).sendKeys("123355666");
    	driver.findElement(createCustomerButton).click();
  
    }
    
    public void navigateNewCustomer(WebDriver driver)
    {
    	driver.navigate().to("https://demo.guru99.com/v4/manager/addcustomerpage.php");
    }
    

}
