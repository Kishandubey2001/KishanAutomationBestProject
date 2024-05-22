package addtocartFromRecommended;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class AddtocartFromRecommendedOrlayer {
	
	public AddtocartFromRecommendedOrlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(),this);
	}
	
	@FindBy(xpath = "//h2[text()='recommended items']")
	private WebElement textofRecommendedProduct;
	public WebElement gettextofRecommendedProduct()
	{
		return textofRecommendedProduct;
	}
	@FindBy(xpath = "//h2[text()='recommended items']/following-sibling::div//div//div[contains(@class,'item')]/following-sibling::div//div/following-sibling::div/following-sibling::div//div//div//div//img/following-sibling::h2/following-sibling::p[text()='Summer White Top']/following-sibling::a[@data-product-id=\"6\"]")
	private WebElement clickonaddtocart;
	public WebElement getclickonaddtocart()
	{
		return clickonaddtocart;
	}
	
	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement clickonviewCart;
	public WebElement getclickonviewCart()
	{
		return clickonviewCart;
	}

}
