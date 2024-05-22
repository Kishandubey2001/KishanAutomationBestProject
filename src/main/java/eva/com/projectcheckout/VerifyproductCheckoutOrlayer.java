package eva.com.projectcheckout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class VerifyproductCheckoutOrlayer {
	
	public VerifyproductCheckoutOrlayer(KishanWebUtil kw)
	{
	 PageFactory.initElements(kw.getDriver(),this);
	}
	
	@FindBy(xpath = "//img[@src=\"/get_product_picture/1\"]")
	private WebElement firstproduct;
	public WebElement getmousehoverfirstproduct()
	{
		return firstproduct;
	}
	
	@FindBy(xpath = "(//a[@data-product-id='1'])[2]")
	private WebElement firstProduct;
	public WebElement getclickOnFirstProductaddtocart()
	{
		return firstProduct;
	}
	
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement clickcountinueshopping;
	public WebElement getclickOnContinueShoppingBT()
	{
		return clickcountinueshopping;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-shopping-cart']/parent::a[@href='/view_cart']")
	   private WebElement clickoncartbutton;
	   public WebElement getclickoncartbutton()
	   {
		   return clickoncartbutton;
	   }

}
