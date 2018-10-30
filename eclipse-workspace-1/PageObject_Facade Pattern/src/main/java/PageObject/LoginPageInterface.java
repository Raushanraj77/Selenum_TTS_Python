package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface LoginPageInterface {

	  WebDriver driver = null;
	    
	    By user99GuruName = By.name("uid");

	    By password99Guru = By.name("password");

	    By titleText = By.className("barone");

	    By login = By.name("btnLogin");
	    
	    public void setUserName(String strUserName);
	    public void setPassword(String strPassword);
	    public void clickLogin();
	    public String getLoginTitle();
	    public void loginToGuru99(String strUserName,String strPasword);
	    
}
