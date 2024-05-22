package verifyscrollupAndDownusingArrow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class ScrollUpAndDownUsingArrowOrlayer {
	
	public ScrollUpAndDownUsingArrowOrlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	@FindBy(xpath = "//h2[text()='Subscription']")
	private WebElement subscriptiontext;
	public WebElement getsubscriptiontext()
	{
		return subscriptiontext;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-angle-up']")
	private WebElement arrow;
	public WebElement getarrow()
	{
		return arrow;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-angle-up']")
	private WebElement textdashboard;
	public WebElement gettextdashboard()
	{
		return textdashboard;
	}


}
