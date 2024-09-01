package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReport {
	
	
	public static ExtentReports generateReport() {
		ExtentReports Report=new ExtentReports();
		File filepath=new File(System.getProperty("user.dir")+"//test-output//Reports//extentreport.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(filepath);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("OrangeHrm");
		spark.config().setReportName("OraneHrmAutomationReport");
		spark.config().setTimeStampFormat("dd//MM//yyyy hh:mm:ss");
		Report.attachReporter(spark);
		
		
		Report.setSystemInfo("Operating System", System.getProperty("os.name"));
		Report.setSystemInfo("SystemUserName", System.getProperty("user.name"));
		Report.setSystemInfo("JavaVerion", System.getProperty("java.version"));
		return Report; 


	}

}
