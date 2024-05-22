package com.eva.subscritioncartpage;

import com.evs.vtiger.utils.KishanWebUtil;

public class Cartsubscription extends CartSubscriptionOrlayer{
	private KishanWebUtil kc;
	public Cartsubscription(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}

	public void subscriptioncart() throws InterruptedException
	{
		//kc.ActionsScroll(getsubscription());
		//kc.scrollbyJavasript();
		kc.scrolltoElement(getsubscription());
		Thread.sleep(1000);
		kc.mySenkeys(getemailsubscriber(), "kishan@yopmail.com");
		kc.myclick(getemailsubscriberarrowbutton());
		kc.isDisplayed(getsuccessmessage());
	}

}
