package Newproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;

	public Properties prop;

	public WebDriver browserinit() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Work\\Selenium\\E2Eproject\\src\\main\\java\\resources\\global.properties");

		prop.load(fis);

		String Browsername = prop.getProperty("Browser");

		System.out.println(Browsername);

		if (Browsername.equals("chrome"))

		{

			System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (Browsername.equals("firefox"))

		{

			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		else if (Browsername.equals("ie"))

		{

			System.setProperty("webdriver.ie.driver", "C:\\work\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) {
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
				
		try {
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationFile;
		
	}
	
}
