package com.eva.AddreviewOnProduct;

import org.testng.Assert;

import com.evs.vtiger.utils.KishanWebUtil;

public class AddReviewOnProductClass extends AddReveiwOnProductOrlayer{
      private KishanWebUtil kc;
	public AddReviewOnProductClass(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public void addReveiwOnproduct()
	{
	String actualText=	kc.mygetText(gettextAllProducts());
	String expectedText="ALL PRODUCTS";
	Assert.assertEquals(actualText, expectedText);
	kc.myclick(getclickonViewProduct());
	kc.isDisplayed(gettextWriteYourReview());
	kc.mySenkeys(getnameTB(), "Kishan Dubey Automation Tester");
    kc.mySenkeys(getemailTB(), "kishanautomationtester2001@yopmail.com");
    kc.mySenkeys(getreviewTB(), "This is product is better than other products");
    kc.myclick(getclickonSubmitBT());
  String actualthankyoumsg=  kc.mygetText(gettextofThankyou());
  String expectedthankyoumsg="Thank you for your review.";
  Assert.assertEquals(actualthankyoumsg, expectedthankyoumsg);
	}
	
	
	

}
