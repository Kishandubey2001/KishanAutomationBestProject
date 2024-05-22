package com.eva.AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.coding.Allproduct.ProductClass;
import com.evs.vtiger.testScript.BaseClass;

import viewCategoryListandBrand.ViewCategoryListAndBrandClass;

public class ViewCategoryAndBrandList extends BaseClass{
	@Test(priority = 1)
public void verifyViewCategoryList()
{
	 ProductClass pc=  new ProductClass(kw);
	  String actualhomepagetext=  pc.verifyhome();
	  Assert.assertEquals(actualhomepagetext, "Home");
	  ViewCategoryListAndBrandClass viewC=     new ViewCategoryListAndBrandClass(kw);
	  viewC.viewCategoryList();
}

	@Test(priority = 2)
	public void verifyViewBrandList()
	{
		 ProductClass pc=  new ProductClass(kw);
		  String actualhomepagetext=  pc.verifyhome();
		  Assert.assertEquals(actualhomepagetext, "Home");
		  ViewCategoryListAndBrandClass viewC=     new ViewCategoryListAndBrandClass(kw);
		  cd.gotoproductpage();
		  viewC.viewBrandList();
	}
	
	
}
