package verifyscrollupAndDownusingArrow;

import com.evs.vtiger.utils.KishanWebUtil;

public class ScrollUpAndDownUsingArrowClass extends ScrollUpAndDownUsingArrowOrlayer{
    private KishanWebUtil kc;
	public ScrollUpAndDownUsingArrowClass(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public void scrollupDown()
	{
	 kc.scrollbyJavasript();
	 kc.isDisplayed(getsubscriptiontext());
	 kc.myclick(getarrow());
	 kc.isDisplayed(gettextdashboard());
	 
	}
	
	public void scrollupDownwithoutarrow()
	{
	 kc.scrollbyJavasript();
	 kc.isDisplayed(getsubscriptiontext());
	 kc.ActionsScroll(getsubscriptiontext());
	// kc.myclick(getarrow());
	 kc.isDisplayed(gettextdashboard());
	 
	}


}
