package com.eva.verifysubscriptionInhomepage;

import com.evs.vtiger.utils.KishanWebUtil;

public class SubscriptionHomepage extends SubscriptionOfHomepageOrlayer {
   private KishanWebUtil kc;
	public SubscriptionHomepage(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public void subscriptionHomepage() throws InterruptedException
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
