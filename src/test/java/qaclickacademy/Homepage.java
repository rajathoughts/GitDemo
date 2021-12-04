package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.Loginpage;
import resources.Base;

public class Homepage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initiated");
		
	}
	
		

	
	@Test(dataProvider="getData")
	public void homePage(String username,String password, String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		Landingpage lp= new Landingpage(driver);
		lp.getLogin().click();
		Loginpage lgp=new Loginpage(driver);
		lgp.getEmail().sendKeys(username);
		lgp.getPassword().sendKeys(password);
		//System.out.println(text);
        log.info(text);
		lgp.getLogin().click();
		
	}
	
	@AfterTest
	
	public void teardrop() {
		driver.close();
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricted user@email.com";
		data[0][1]="raja123456";
		data[0][2]="non restricted user";
		
		data[1][0]="restricted user@email.com";
		data[1][1]="radmaoc12345";
		data[1][2]="restricted user";
		return data;

	}
	

}
