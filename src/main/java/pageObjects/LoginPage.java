package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By email = By.id("user_email");

	By password = By.name(" password");

	By login = By.name("commit");
	
	By home = By.cssSelector("a[href*='rahulshettyacademy']");
	
	By error = By.xpath("//div[@class='main-hero']/div");

	public WebElement email()

	{
		return driver.findElement(email);
	}

	public WebElement password()

	{
		return driver.findElement(password);
	}

	public WebElement login()

	{
		return driver.findElement(login);
	}
	
	public WebElement home()

	{
		return driver.findElement(home);
	}
	
	public WebElement error()

	{
		return driver.findElement(error);
	}

}
