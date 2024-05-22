package com.evs.vtiger.commonCodes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.commonCodesORlayer.CommonReusabledORlayer;
import com.evs.vtiger.utils.KishanWebUtil;

public class CommonResuableCode extends CommonReusabledORlayer{
    private KishanWebUtil kc;
	public CommonResuableCode(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public void gotoLoginpage()
	{
	 kc.myclick(getgotoLoginPage());	
	}
	
	public void validLogin(String Username,String Password)
	{    gotoLoginpage();
		kc.mySenkeys(getUserName(), Username);
		kc.mySenkeys(getPassword(), Password);
		kc.myclick(getLoginbutton());
	}
	public void logout()
	{
		kc.myclick(getLogout());
	}
	
	public String verifyhome()
	{
	String homepagetext=	kc.mygetText(gethomepage());
	return homepagetext;
	}
	
	public void gotoproductpage()
	{
		kc.myclick(getgotoproductpage());
	}
	
	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement allproducttext;
	public WebElement getAllproductText()
	{
		return allproducttext;
	}
	

}
