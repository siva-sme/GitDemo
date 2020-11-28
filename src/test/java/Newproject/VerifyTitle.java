package Newproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class VerifyTitle extends Base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(VerifyTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = browserinit();

		log.info("Browser initiated");

		driver.get(prop.getProperty("URL"));

		log.info("Navigated to respective URL");

		// GIT HUB

		System.out.println("Test - nav annotation 4");

		System.out.println("Test - nav annotation 5");

		System.out.println("Test - nav annotation 6");
	}

	@Test
	public void validateTitle() {

		HomePage hp = new HomePage(driver);

		Assert.assertEquals("FEATURED COURSES123", hp.text().getText());

		log.info("Text verified");

		System.out.println("Test - Title annotation");

        //git hub

		System.out.println("Test - nav annotation 1");

		System.out.println("Test - nav annotation 2");

		System.out.println("Test - nav annotation3");
		
		//GIT HUB
		
		System.out.println("Test - nav annotation 4");
		
		System.out.println("Test - nav annotation 5");
		
		System.out.println("Test - nav annotation 6");

	}

	@AfterTest
	public void browserclose()

	{

		driver.close();

		log.info("Browser Closed");

		System.out.println("AfterClass annotation");

	}

}
