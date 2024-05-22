package com.eva.AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.coding.Allproduct.ProductClass;
import com.evs.vtiger.testScript.BaseClass;

import verifyscrollupAndDownusingArrow.ScrollUpAndDownUsingArrowClass;

public class ScrollupDownTestScript extends BaseClass{
   @Test
	public void ScrollupDown()
	{
	   ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  ScrollUpAndDownUsingArrowClass scroll=	  new ScrollUpAndDownUsingArrowClass(kw);
		  scroll.scrollupDown();
	}
   
   @Test
	public void ScrollupDownwithoutarrow()
	{
	   ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  ScrollUpAndDownUsingArrowClass scroll=	  new ScrollUpAndDownUsingArrowClass(kw);
		  scroll.scrollupDownwithoutarrow();
	}
   
   
  
   
}
