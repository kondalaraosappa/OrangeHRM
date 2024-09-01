package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import generalOperations.BaseClass;

public class MyListner implements ITestListener {
	ExtentReports extentreport;
	ExtentTest extenttest ;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("ExecutionStarted");
	    extentreport = MyExtentReport.generateReport();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getName();
		//System.out.println(TestName + "TestExecutionStarted");
		extenttest = extentreport.createTest(TestName);
		extenttest.log(Status.INFO, "TestExecutionStarted");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		try {
			extenttest.addScreenCaptureFromPath(BaseClass.captureScreenShots(TestName));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(TestName + "TesCasePass");
		extenttest.log(Status.PASS, "TesCasePass");
	};

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();
		try {
			extenttest.addScreenCaptureFromPath(BaseClass.captureScreenShots(TestName));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(TestName + "TesCaseFailed");
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, "TesCaseFailed");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("ExecutionFinished");
		extentreport.flush();
		File filepath=new File(System.getProperty("user.dir")+"//test-output//Reports//extentreport.html");
       try {
		Desktop.getDesktop().browse(filepath.toURI());
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	

}
