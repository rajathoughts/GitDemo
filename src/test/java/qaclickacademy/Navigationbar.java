package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.Loginpage;
import resources.Base;

public class Navigationbar extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver has initiated");
		driver.get(prop.getProperty("url"));
		log.info("initiated landingpage");
	}
	
	
		
	
	@Test
	public void navigateBar() throws IOException
	{
	
		Landingpage lp= new Landingpage(driver);
		//System.out.println(lp.getNavigateBar().isDisplayed());
		Assert.assertTrue(lp.getNavigateBar().isDisplayed());
		log.info("Navigation bar dispalted");			
		
	}
	

	
	
	@AfterTest
	public void teardrop() {
		driver.close();
	}
	
	
	

}
