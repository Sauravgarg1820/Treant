package com.trent.listnerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.trent.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ISuiteListener, ITestListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark = new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suit Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOW");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
       report.createTest(result.getMethod().getMethodName());
       UtilityClassObject.setTest(test);
       test.log(Status.INFO, result.getMethod().getMethodName()+"======Started======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"=====Started======");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot)UtilityClassObject.getdriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
	     test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"====FAILED====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}
