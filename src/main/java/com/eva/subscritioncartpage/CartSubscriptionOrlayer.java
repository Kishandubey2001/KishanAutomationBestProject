package com.eva.subscritioncartpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class CartSubscriptionOrlayer {
	
	public CartSubscriptionOrlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	

	@FindBy(xpath = "//h2[text()='Subscription']")
	private WebElement subscription;
	public WebElement getsubscription()
	{
		return subscription;
		
	}
	
	@FindBy(id = "susbscribe_email")
	private WebElement emailsubscriber;
	public WebElement getemailsubscriber()
	{
		return emailsubscriber;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
	private WebElement emailsubscriberarrowbutton;
	public WebElement getemailsubscriberarrowbutton()
	{
		return emailsubscriberarrowbutton;
	}
	
	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	private WebElement successmessage;
	public WebElement getsuccessmessage()
	{
		return successmessage;
	}
	

}
