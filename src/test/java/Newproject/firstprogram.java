package Newproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class firstprogram extends Base {

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = browserinit();

	}

	@Test(dataProvider = "getdata")
	public void validateLogin(String mail, String pass) {

		driver.get(prop.getProperty("URL"));

		HomePage hp = new HomePage(driver);

		hp.login().click();

		LoginPage lp = new LoginPage(driver);

		lp.email().sendKeys(mail);

		lp.password().sendKeys(pass);

		lp.login().click();

		// lp.home().click();

        //git hub

		System.out.println("Test - nav annotation 1");

		System.out.println("Test - nav annotation 2");

		System.out.println("Test - nav annotation3");

	}
	
	
	
	
	@Test(dataProvider = "getdata")
	public void validateLoginGIT(String mail, String pass) {

        //git hub

		System.out.println("Test - nav annotation 1");

		System.out.println("Test - nav annotation 2");

		System.out.println("Test - nav annotation3");

	}

	@DataProvider
	public Object[][] getdata() {
		// row stands for how many data types test should run
		// Column stands for number of inputs (email, Password, etc)

		Object[][] ob = new Object[2][2];

		ob[0][0] = "1234";

		ob[0][1] = "siva";

		ob[1][0] = "5678";

		ob[1][1] = "avis";

		return ob;

	}

	@AfterTest
	public void browserclose()

	{

		driver.close();
	}

}
