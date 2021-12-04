package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	By login= By.cssSelector("a[href*='/sign_in/']");
	By title= By.xpath("//h2[text()='Featured Courses']");
	By navigatebar= By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
      		
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigateBar()
	{
		return driver.findElement(navigatebar);
	}
	

}
