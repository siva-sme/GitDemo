package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	By login = By.cssSelector("a[href*='sign_in']");
	
	By text = By.xpath("//*[@id='content']/div/div/h2");
	
	By navbar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	By popup = By.xpath("//button[text()='NO THANKS']");

	public WebElement login()

	{
		return driver.findElement(login);
	}

	public WebElement text()

	{
		return driver.findElement(text);
	}

	
	public WebElement navbar()

	{
		return driver.findElement(navbar);
	}
	
	
	public List<WebElement> popupSize()

	{
		return driver.findElements(popup);
	}
	
	
	public WebElement popup()

	{
		return driver.findElement(popup);
	}

}
