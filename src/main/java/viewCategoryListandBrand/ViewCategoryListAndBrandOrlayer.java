package viewCategoryListandBrand;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class ViewCategoryListAndBrandOrlayer {
	
	public ViewCategoryListAndBrandOrlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	
	@FindBy(xpath = "//h2[text()='Category']")
	private WebElement categorytext;
	public WebElement getcategorytext()
	{
		return categorytext;
	}
	
	@FindBy(xpath = "//a[@href=\"#Women\"]")
	private WebElement clickwomenCategory;
	public WebElement getclickwomenCategory()
	{
		return clickwomenCategory;
	}
	
	@FindBy(xpath = "//div[@id='Women']/div/ul/li/a[text()='Dress ']")
	private WebElement clickwomenDress;
	public WebElement getclickwomenDress()
	{
		return clickwomenDress;
	}
	
	@FindBy(xpath = "//h2[text()='Women - Dress Products']")
	private WebElement womenDressProducts;
	public WebElement getwomenDressProducts()
	{
		return womenDressProducts;
	}
	
	@FindBy(xpath = "//h2[text()='Brands']")
	private WebElement textofBrands;
	public WebElement gettextBrands()
	{
		return textofBrands;
	}
	
	@FindBy(xpath = "//a[text()='Polo']")
	private WebElement clickPoloBrand;
	public WebElement getclickPoloBrand()
	{
		return clickPoloBrand;
	}
	
	@FindBy(xpath = "//h2[text()='Brand - Polo Products']")
	private WebElement textofBrandPoloProduct;
	public WebElement gettextofBrandPoloProduct()
	{
		return textofBrandPoloProduct;
	}
	
	@FindBy(xpath = "//a[text()='Biba']")
	private WebElement clickonBibaProduct;
	public WebElement getclickonBibaProduct()
	{
		return clickonBibaProduct;
	}
	
	@FindBy(xpath = "//h2[text()='Brand - Biba Products']")
	private WebElement textofBrandBibaProduct;
	public WebElement gettextofBrandBibaProduct()
	{
		return textofBrandBibaProduct; 
	}
}
