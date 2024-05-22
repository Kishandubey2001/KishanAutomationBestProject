package com.eva.AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.coding.Allproduct.ProductClass;
import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.testScript.BaseClass;

public class AddReveiwOnProductTestScript extends BaseClass{
	@Test
	public void verifyAddReviewOnProuduct()
	{
		ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  CommonResuableCode cd=	  new CommonResuableCode(kw);
		  cd.gotoproductpage();
		  
	}

}
