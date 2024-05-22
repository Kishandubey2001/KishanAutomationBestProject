package com.evs.practice.contactform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class ContactFormOrlayer {
	
	public ContactFormOrlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@href='/contact_us']")
	private WebElement gotocontaceuspage;
	public WebElement getgotoContactUsPage()
	{
		return gotocontaceuspage;
	}
	
	@FindBy(xpath = "//h2[@class='title text-center'][.='Get In Touch']")
	private WebElement getinTouch;
	public WebElement getGetInTouch()
	{
		return getinTouch;
	}
	@FindBy(name = "name")
	private WebElement username;
	public WebElement getContactUsername()
	{
		return username;
	}
	
	@FindBy(name = "email")
	private WebElement email;
	public WebElement getContactEmail()
	{
		return email;
	}
	
	@FindBy(name = "subject")
	private WebElement subject;
	public WebElement getContactSubjectName()
	{
		return subject;
	}
	
	@FindBy(id = "message")
	private WebElement description;
	public WebElement getContactDescription()
	{
		return description;
	}
	
	@FindBy(name = "upload_file")
	private WebElement uploadfile;
	public WebElement getContactUsUploadfile()
	{
		return uploadfile;
	}
	
	@FindBy(name = "submit")
	private WebElement submitbutton;
	public WebElement getContactUsSubmitbutton()
	{
		return submitbutton;
	}
	

}
