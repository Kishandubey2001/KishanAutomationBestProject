package com.eva.AutomationPractice;

import org.testng.Assert;

import com.coding.Allproduct.ProductClass;
import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.testScript.BaseClass;

public class CheckoutProduct extends BaseClass{
	
	public CommonResuableCode cd;
	
	public void verifyproductcheckout()
	{
		 ProductClass pc=  new ProductClass(kw);
		   String actualhomepagetext=  pc.verifyhome();
		   Assert.assertEquals(actualhomepagetext, "Home");
		   cd.gotoproductpage();
		   
	}

}
