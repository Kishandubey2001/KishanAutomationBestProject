package com.eva.AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.coding.Allproduct.ProductClass;
import com.eva.removeproductcart.RemoveProductCartClass;
import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.testScript.BaseClass;

public class RemoveProductfromCart extends BaseClass{
	@Test
	public void removeProductCart() throws InterruptedException
	{
		 ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  CommonResuableCode cd=	  new CommonResuableCode(kw);
		  cd.gotoproductpage();
		  pc.AddtoCart();
	String actualcarttitle=	  kw.getTitle();
	String expectedTitle="Automation Exercise - Checkout";
	Assert.assertEquals(actualcarttitle, expectedTitle);
	RemoveProductCartClass  rv=new RemoveProductCartClass(kw);
	rv.removedProductFromCart();
	
		  
	}

}
