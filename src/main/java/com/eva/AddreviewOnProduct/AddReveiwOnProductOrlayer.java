package com.eva.AddreviewOnProduct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class AddReveiwOnProductOrlayer {
	
	public AddReveiwOnProductOrlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	
	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement textAllProducts;
	public WebElement gettextAllProducts()
	{
		return textAllProducts;
	}
	
	@FindBy(xpath ="//a[@href='/product_details/1']")
	private WebElement clickonViewProduct;
	public WebElement getclickonViewProduct()
	{
		return clickonViewProduct;
	}
	
	@FindBy(xpath = "//a[text()='Write Your Review']")
	private WebElement textWriteYourReview;
	public WebElement gettextWriteYourReview()
	{
		return textWriteYourReview;
	}
	
	@FindBy(id = "name")
	private WebElement nameTB;
	public WebElement getnameTB()
	{
		return nameTB;
	}

	@FindBy(id = "email")
	private WebElement emailTB;
	public WebElement getemailTB()
	{
		return emailTB;
	}
	
	@FindBy(id = "review")
	private WebElement reviewTB;
	public WebElement getreviewTB()
	{
		return reviewTB;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement clickonSubmitBT;
	public WebElement getclickonSubmitBT()
	{
		return clickonSubmitBT;
	}
	
	@FindBy(xpath = "//span[text()='Thank you for your review.']")
	private WebElement textofThankyou;
	public WebElement gettextofThankyou()
	{
		return textofThankyou;
	}


}
