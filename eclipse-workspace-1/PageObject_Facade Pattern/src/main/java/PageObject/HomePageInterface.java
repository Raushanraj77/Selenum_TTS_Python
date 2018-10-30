package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface HomePageInterface {
	
	    WebDriver driver = null;
	    By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	   
	    public String getHomePageDashboardUserName();
}
