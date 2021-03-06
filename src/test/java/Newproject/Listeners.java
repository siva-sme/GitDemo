package Newproject;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {

	ExtentReports extent = ExtentRepNG.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSuccess(result);

		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailure(result);

		// WebDriver driver = null;
		
		extentTest.get().fail(result.getThrowable());

		String testcaseName = result.getMethod().getMethodName();

		/*
		 * try { WebDriver driver = (WebDriver)
		 * result.getMethod().getTestClass().getRealClass().getDeclaredField("driver")
		 * .get(result.getInstance()); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		Class clazz = result.getTestClass().getRealClass();

		Field field = null;
		try {
			field = clazz.getDeclaredField("driver");
		} catch (NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}

		field.setAccessible(true);

		WebDriver driver = null;
		try {
			driver = (WebDriver) field.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException e) {

			e.printStackTrace();

		}

		extentTest.get().addScreenCaptureFromPath(getScreenshot(testcaseName, driver), result.getMethod().getMethodName());


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onFinish(context);

		extent.flush();
	}

}
