package eva.com.projectcheckout;

import org.testng.Assert;

import com.coding.Allproduct.ProductORlayer;
import com.evs.vtiger.commonCodes.CommonResuableCode;
import com.evs.vtiger.utils.KishanWebUtil;

public class VerifyProductCheckout extends ProductORlayer{
    private KishanWebUtil kc;
	public VerifyProductCheckout(KishanWebUtil kw) {
		super(kw);
	 this.kc=kw;
	}
	CommonResuableCode cd;
	
	public void verifyplaceorderProduct()
	{
		kc.mymouseover(getmousehoverfirstproduct());
		kc.myclick(getclickOnFirstProductaddtocart());
		kc.myclick(getclickOnContinueShoppingBT());
		
		kc.myclick(getclickoncartbutton());
	String actualtitle=	kc.getTitle();
	String expectedTitle="Automation Exercise - Checkout";
	Assert.assertEquals(actualtitle, expectedTitle);
	cd.getclickonProceedtocheck();
	cd.getgotoLoginPage();
	
	
	}
	


}
