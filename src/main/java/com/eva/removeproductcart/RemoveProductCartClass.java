package com.eva.removeproductcart;

import com.evs.vtiger.utils.KishanWebUtil;

public class RemoveProductCartClass extends RemoveproductCartORlayer{
      private KishanWebUtil kc;
	public RemoveProductCartClass(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	public void removedProductFromCart()
	{
		kc.myclick(getremoveFisrtProductFromCart());
		kc.isDisplayed(getRemovedProduct());
		
	}

}
