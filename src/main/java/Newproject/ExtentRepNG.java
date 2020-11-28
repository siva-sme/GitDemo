package Newproject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig.ExtentSparkReporterConfigBuilder;

public class ExtentRepNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("New Report");

		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		
	    extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "SIVA");
		
		return extent;
	}

	

}
