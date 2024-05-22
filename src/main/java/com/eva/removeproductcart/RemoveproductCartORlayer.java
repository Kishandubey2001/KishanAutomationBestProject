package com.eva.removeproductcart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class RemoveproductCartORlayer {
	public RemoveproductCartORlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	@FindBy(xpath = "//a[text()='Blue Top']/parent::h4/parent::td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")
	private WebElement removefirstProduct;
	public WebElement getremoveFisrtProductFromCart()
	{
		return removefirstProduct;
	}
	
	@FindBy(xpath = "//a[text()='Blue Top']")
	private WebElement removedProduct;
	public WebElement getRemovedProduct()
	{
		return removedProduct;
	}
	

}
