package com.evs.vtiger.commonCodesORlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class CommonReusabledORlayer {
	
	public CommonReusabledORlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@href=\"/login\"]")
	private WebElement gotologinpage;
	public WebElement getgotoLoginPage()
	{
		return gotologinpage;
	}
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement userName;
	public WebElement getUserName()
	{
		return userName;
	}
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement password;
	public WebElement getPassword()
	{
	    return password;	
	}
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginbutton;
	public WebElement getLoginbutton()
	{
		return loginbutton;
	}
	
	@FindBy(xpath = "//a[@href=\"/logout\"]")
	private WebElement logout;
	public WebElement getLogout()
	{
		return logout;
	}
	
	@FindBy(xpath = "//a[@href='/products']")
	private WebElement clickonproduct;
	public WebElement getgotoproductpage()
	{
		return clickonproduct;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")
	private WebElement homepagetext;
	public WebElement gethomepage()
	{
		return homepagetext;
	}
	
	@FindBy(xpath = "//a[@href=\"/view_cart\"]")
	private WebElement cart;
	public WebElement gotocartpage()
	{
		return cart;
	}
	
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement clickonProceedtocheck;
	public WebElement getclickonProceedtocheck()
	{
		return  clickonProceedtocheck; 
	}
	
	
	
	
	
	

}
