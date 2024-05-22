package com.evs.vtiger.testScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.utils.KishanWebUtil;

import lombok.Getter;
@Getter
public class BaseClass {
	

	
	
	protected KishanWebUtil kw=	KishanWebUtil.getobject();
	public CommonResuableCode cd;
	private static ExtentReports extent;
	
	@BeforeSuite
	public void beforesuit()
	{
		extent =new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("test-output/VtigerExtentReports.html");
		extent.attachReporter(spark);
	}
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser,String url)
	{	kw.launchbrowser(browser);
	    kw.deleteAllcookies();
	//kw.maximizeWindow();
	kw.hitUrl(url);
	//kw.maximizeWindow();
	

	}
		//@BeforeGroups({"Smoke"})
	@Parameters({"Username","Password"})
	@BeforeMethod
	public void beforemethod(String Username,String Password,Method mt) throws InterruptedException, IOException
	{ 
		ExtentTest  exTest=extent.createTest(mt.getName());
		kw.setExtentTestObject(exTest);
		cd= new CommonResuableCode(kw);
	    cd.validLogin(Username, Password);	
	
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("This is  before method");
	}
	@AfterMethod
	public void aftermethod(ITestResult result,Method mt) throws InterruptedException
	{
		if(result.getStatus()==result.FAILURE)
		{
		String snapshotPath=kw.takeSnapshot(mt.getName());	
	     kw.getExtentTestObject().addScreenCaptureFromPath(snapshotPath);
		}
		cd.logout();
		Thread.sleep(8000);
        extent.flush();
		
	}
	@AfterClass
	public void afterclass()
	{
		kw.myquite();
	}
	
	@AfterSuite
	public void aftersuit()
	{
		
		extent.flush();
	}


}
