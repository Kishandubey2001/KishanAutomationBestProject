package com.coding.Allproduct;

import org.testng.Assert;

import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.utils.KishanWebUtil;

public class ProductClass extends ProductORlayer{
	private KishanWebUtil kc;
	
	public ProductClass(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public String verifyhome()
	{
		String homepagetext=	kc.mygetText(gethomepage());
		return homepagetext;
	}

	public void verifytestfirstproduct()
	{kc.myclick(getClickonProduct());
	String actualAllProductvisible=	kc.mygetText(getAllproductText());
	Assert.assertEquals(actualAllProductvisible, "ALL PRODUCTS");
	kc.myclick(getclickOnViewProduct());
	String Actualtitleproductlist=	kc.getTitle();
	Assert.assertEquals(Actualtitleproductlist, "Automation Exercise - Product Details");
	kc.isDisplayed(getproductnamefirstgettext()); 
	kc.isDisplayed(getproductcategoryfirst());
	kc.isDisplayed(getproductpricefirst());
	kc.isDisplayed(getproductavailability());
	kc.isDisplayed(getproductcondition());
	kc.isDisplayed(getproductbrand());

	}

	public void verifysearchproduct()
	{
		kc.myclick(getClickonProduct());
		String actualAllProductvisible=	kc.mygetText(getAllproductText());
		Assert.assertEquals(actualAllProductvisible, "ALL PRODUCTS");
		kc.mySenkeys(getsearchproduct(), "Men Tshirt");
		kc.myclick(getclickonsearchButton());

	}
	public void AddtoCart() throws InterruptedException
	{
	kc.mymouseover(getmousehoverfirstproduct());
	kc.myclick(getclickOnFirstProductaddtocart());
	kc.myclick(getclickOnContinueShoppingBT());
	kc.mymouseover(getMousehoversecondProduct());
	kc.myclick(getclickonsecondProductAddtocart());
	kc.myclick(getclickOnsecondproductContinueBT());
	kc.myclick(getclickoncartbutton());
	kc.isDisplayed(getfirstproducttextIncart());
	kc.isDisplayed(getsecondprojectgettextIncart());
String nameoffirstProduct=	kc.mygetText(getproductnamefirstgettext());
System.out.println("Name of first product:-  "+nameoffirstProduct);
	String firstproductprice=	kc.mygetText(getproductpricefirst());
	System.out.println("First Product price:-   "+firstproductprice);
	String firstproductquantity=	kc.mygetText(getfirstproductquantity());
	System.out.println("FirstProjuct quantity:-  "+firstproductquantity);
	String firstproductTotalprice=   kc.mygetText(getfirstProductTotalPrice());
	System.out.println("Fist Product Totol price:-  "+firstproductTotalprice);
	String secondproductgettext=	kc.mygetText(getsecondprojectgettextIncart());
	System.out.println("Name of second product:-  "+secondproductgettext);
	String secondprojectquantity=  kc.mygetText(getsecondproductquantity());
	System.out.println("Second Product quantity :-  "+secondprojectquantity);
	String secondProductPrice=	kc.mygetText(getpriceofsecondproduct());
	System.out.println("Second Product basic Price:- "+secondProductPrice);
	String secondproductTotalprice=  kc.mygetText(getsecondProductTotalPrice());
	System.out.println("Second Product Total Price:-  "+secondproductTotalprice);

	}
	
	public void verifyproductQuantityincart()
	{CommonResuableCode cd=      new CommonResuableCode(kc);
		kc.myclick(getclickOnViewProduct());
	String actualTitle=	kc.getTitle();
	String expectedproductdetailstitle="Automation Exercise - Product Details";
	Assert.assertEquals(actualTitle, expectedproductdetailstitle); 
	kc.mySenkeys(getincreaseproductquantity(), "4");
	kc.myclick(getclickonaddtocartbuttoninsideviewcartpage());
	kc.myclick(getclickoncountinueBT());
	kc.myclick(getclickoncartBT());
String increasedquantity=	kc.mygetText(getincreasedProductQuantity());
Assert.assertEquals(increasedquantity, "4");
	
	}

}
