package com.eva.AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.coding.Allproduct.ProductClass;
import com.eva.subscritioncartpage.Cartsubscription;
import com.eva.verifysubscriptionInhomepage.SubscriptionHomepage;
import com.evs.practice.contactform.ContactUsPage;
import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.testScript.BaseClass;
import com.evs.vtiger.testScript.RetryAnalyzer;

public class AutomationPracticeProject extends BaseClass{
	public CommonResuableCode cd;
	@Test(enabled = true, invocationCount = 2,retryAnalyzer = RetryAnalyzer.class)
	public void tc001ContactUs()
	{
		ContactUsPage cu	=new ContactUsPage(kw);
		cu.createcontactUsForm();
	}
	@Test(enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void projectAllList()
	{
	     ProductClass pc=  new ProductClass(kw);
	   String actualhomepagetext=  pc.verifyhome();
	   Assert.assertEquals(actualhomepagetext, "Home");
	   pc.verifytestfirstproduct();
	   
	}
	@Test(enabled = true)
	public void verifysearchproduct()
	{
		 ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  pc.verifysearchproduct();
		
	
	}
	@Test(enabled = true)
	public void verifyHomePageSubscription() throws InterruptedException
	{
		 ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  SubscriptionHomepage sbobj=	  new SubscriptionHomepage(kw);
		  sbobj.subscriptionHomepage();
	}
	
	@Test(enabled = true)
	public void verifyCartsubscription() throws InterruptedException
	{
		 ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  Cartsubscription csubscription=    new Cartsubscription(kw);
		  csubscription.subscriptioncart();
		  
	}
	@Test(enabled = true)
	public void verifyAddproductInCart() throws InterruptedException
	{
		 ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  CommonResuableCode cd=	  new CommonResuableCode(kw);
		  cd.gotoproductpage();
		  pc.AddtoCart();
		  
	}
	@Test(retryAnalyzer = RetryAnalyzer.class,invocationCount = 1)
	public void verifyproductquantiyincart()
	{
		ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  pc.verifyproductQuantityincart();
	}
	
	
	
	
//	@DataProvider
//	public Object [][] logindata()
//	{
//		return new Object [][] {
//			{"codingkishan@yopmail.com","Kishan@12345"},
//			{"codingkisn@yopmail.com","Kishan@1234"},
//			{"codingkishan@yopmail.com","Kishan@12345"},
//			{"codingkisn@yopil.com","Kishan@1234"},
//			{" "," "}
//		};
//	}
//	
//	
//	@Test(dataProvider = "logindata")
//	public void validlogin(String Username,String Password)
//	{
//		cd= new CommonResuableCode(kw);
//	    cd.validLogin(Username, Password);	
//	}

}
