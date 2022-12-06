package com.rb.report;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport {

	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void startReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
		extent.addSystemInfo("Host Name", "Localhost");
		extent.addSystemInfo("Environment", "Stage");
		extent.addSystemInfo("User Name", "TEST121");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\spark-config.xml"));
	}

	@Test
	public void demoReportPass() {
		test = extent.startTest("demoReportPass");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "assert passes as we hardcoded");

	}
	@Test
	public void demoReportFail() {
		test = extent.startTest("demoReportFail");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "assert failed as we hardcoded");

	}

	@AfterMethod
	public void getResult(ITestResult tr) {
		if(tr.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, tr.getThrowable());
		}
		extent.endTest(test);
		
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}

}
