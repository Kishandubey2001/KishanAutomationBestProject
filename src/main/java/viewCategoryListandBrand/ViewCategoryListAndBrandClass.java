package viewCategoryListandBrand;

import com.evs.vtiger.utils.KishanWebUtil;

public class ViewCategoryListAndBrandClass extends ViewCategoryListAndBrandOrlayer{
    private KishanWebUtil kc;
	public ViewCategoryListAndBrandClass(KishanWebUtil kw) {
		super(kw);
		this.kc=kw;
	}
	
	public void viewCategoryList()
	{
	  kc.isDisplayed(getcategorytext());
	  kc.myclick(getclickwomenCategory());
	  kc.myclick(getclickwomenDress());
	  kc.isDisplayed(getwomenDressProducts());
	}
	
	public void viewBrandList()
	{
		kc.isDisplayed(gettextBrands());
		kc.myclick(getclickPoloBrand());
		kc.isDisplayed(gettextofBrandPoloProduct());
		kc.myclick(getclickonBibaProduct());
		kc.isDisplayed(gettextofBrandBibaProduct());
	
	}

}
