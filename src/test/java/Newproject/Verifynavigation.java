package Newproject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Verifynavigation extends Base {
	
	
	public WebDriver driver;


	@BeforeTest
	public void initialize() throws IOException {

		driver=browserinit();

		driver.get(prop.getProperty("URL"));
	}

	@Test
	public void validateNavigation() {

		HomePage hp = new HomePage(driver);
		
		Assert.assertTrue(hp.navbar().isDisplayed());
		
		//gii Hub
		
		System.out.println("Test - nav annotation 1");
		
		System.out.println("Test - nav annotation 2");
		
		System.out.println("Test - nav annotation3");

	

	}

	@AfterTest
	public void browserclose()

	{

		driver.close();
		
		System.out.println("AfterClass annotation");
	}

}
