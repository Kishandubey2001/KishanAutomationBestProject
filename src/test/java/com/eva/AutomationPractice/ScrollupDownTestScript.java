package com.eva.AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.coding.Allproduct.ProductClass;
import com.evs.vtiger.testScript.BaseClass;
import com.evs.vtiger.testScript.RetryAnalyzer;

import verifyscrollupAndDownusingArrow.ScrollUpAndDownUsingArrowClass;

public class ScrollupDownTestScript extends BaseClass{
   @Test(retryAnalyzer = RetryAnalyzer.class,invocationCount = 1)
	public void ScrollupDown()
	{
	   ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  ScrollUpAndDownUsingArrowClass scroll=	  new ScrollUpAndDownUsingArrowClass(kw);
		  scroll.scrollupDown();
	}
   
   @Test(retryAnalyzer = RetryAnalyzer.class,invocationCount = 1)
	public void ScrollupDownwithoutarrow()
	{
	   ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  ScrollUpAndDownUsingArrowClass scroll=	  new ScrollUpAndDownUsingArrowClass(kw);
		  scroll.scrollupDownwithoutarrow();
	}
   
   
  
   
}
