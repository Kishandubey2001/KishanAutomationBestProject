package com.coding.Allproduct;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utils.KishanWebUtil;

public class ProductORlayer {
	
	public ProductORlayer(KishanWebUtil kw)
	{
		PageFactory.initElements(kw.getDriver(), this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")
	private WebElement homepagetext;
	public WebElement gethomepage()
	{
		return homepagetext;
	}
	
	@FindBy(xpath = "//a[@href=\"/products\"]")
	private WebElement clickonproduct;
	public WebElement getClickonProduct()
	{
		return clickonproduct;
	}
	
	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement allproducttext;
	public WebElement getAllproductText()
	{
		return allproducttext;
	}
	
	@FindBy(xpath = "//a[@href='/product_details/11']")
	private WebElement clickonviewProduct;
	public WebElement getclickOnViewProduct()
	{
		return clickonviewProduct;
	}
	
	@FindBy(xpath = "//a[text()='Blue Top']/parent::h4/parent::td[@class='cart_description']")
	private WebElement productnamefirst;
	public WebElement getproductnamefirstgettext()
	{
		return productnamefirst;
	}
	
	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	private WebElement productcategoryfirst;
	public WebElement getproductcategoryfirst()
	{
		return productcategoryfirst;
	}
	@FindBy(xpath = "//a[text()='Blue Top']/parent::h4/parent::td/following-sibling::td")
	private WebElement productpricefirst;
	public WebElement getproductpricefirst()
	{
		return productpricefirst;
	}
	
	@FindBy(xpath = "//b[text()='Availability:']")
	private WebElement productavailability;
	public WebElement getproductavailability()
	{
		return productavailability;
	}
	
	@FindBy(xpath = "//b[text()='Condition:']")
	private WebElement productcondition;
	public WebElement getproductcondition()
	{
		return productcondition;
	}
	
	@FindBy(xpath = "//b[text()='Brand:']")
	private WebElement productbrand;
	public WebElement getproductbrand()
	{
		return productbrand;
	}
	
	@FindBy(id = "search_product")
	private WebElement searchproduct;
	public WebElement getsearchproduct()
	{
		return searchproduct;
	}
	
	@FindBy(id ="submit_search")
	private WebElement searchbutton;
	public WebElement getclickonsearchButton()
	{
		return searchbutton;
	}
	
	@FindBy(xpath = "//h2[text()='Searched Products']")
	private WebElement searchProductgext;
	public WebElement getsearchProductgext()
	{
		return searchProductgext;
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
	
	@FindBy(xpath = "//img[@src=\"/get_product_picture/2\"]")
	private WebElement mousehoversecondproduct;
	public WebElement getMousehoversecondProduct()
	{
		return mousehoversecondproduct;
	}
	
	@FindBy(xpath = "(//a[@data-product-id=\"2\"])[2]")
	private WebElement clickonsecondproductAddtocart;
	public WebElement getclickonsecondProductAddtocart()
	{
		return  clickonsecondproductAddtocart;
	}
	
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement clickOnsecondproductContinueBT;
	public WebElement getclickOnsecondproductContinueBT()
	{
		return clickOnsecondproductContinueBT;
	}
	
   @FindBy(xpath = "//a[text()='Blue Top']")
   private WebElement firstproductincart;
   public WebElement getfirstproducttextIncart()
   {
	   return firstproductincart;
   }
   
   @FindBy(xpath = "//a[text()='Men Tshirt']")
   private WebElement secondProductInCart;
   public WebElement getsecondprojectgettextIncart()
   {
	   return secondProductInCart;
   }
   @FindBy(xpath = "//td[@class='cart_price']")
   private WebElement priceoffirstProduct;
   public WebElement getpriceoffirstProduct()
   {
	   return priceoffirstProduct;
   }
   
   @FindBy(xpath = "//a[text()='Blue Top']/parent::h4/parent::td/following-sibling::td/following-sibling::td[@class='cart_quantity']")
   private WebElement firstproductquantity;
   public WebElement getfirstproductquantity()
   {
	   return firstproductquantity;
   }
   
   @FindBy(xpath = "//a[text()='Blue Top']/parent::h4/parent::td/following-sibling::td/following-sibling::td[@class='cart_quantity']/following-sibling::td[@class='cart_total']")
	private WebElement firstProductTotalPrice;
   public WebElement getfirstProductTotalPrice()
   {
	   return firstProductTotalPrice;
   }
   
   @FindBy(xpath = "//a[text()='Men Tshirt']/parent::h4/parent::td/following-sibling::td[@class='cart_price']")
   private WebElement priceofsecondproduct;
   public WebElement getpriceofsecondproduct()
   {
	   return priceofsecondproduct;
   }
   
   @FindBy(xpath = "//a[text()='Men Tshirt']/parent::h4/parent::td/following-sibling::td/following-sibling::td[@class='cart_quantity']")
   private WebElement secondproductquantity;
   public WebElement getsecondproductquantity()
   {
	   return  secondproductquantity; 
   }
   
   @FindBy(xpath = "//a[text()='Men Tshirt']/parent::h4/parent::td/following-sibling::td/following-sibling::td/following-sibling::td[@class='cart_total']")
   private WebElement secondProductTotalPrice;
   public WebElement getsecondProductTotalPrice()
   {
	   return secondProductTotalPrice;
   }
   
   @FindBy(xpath = "//i[@class='fa fa-shopping-cart']/parent::a[@href='/view_cart']")
   private WebElement clickoncartbutton;
   public WebElement getclickoncartbutton()
   {
	   return clickoncartbutton;
   }
   
   @FindBy(xpath = "//a[@href=\"/product_details/11\"]")
   private WebElement clickonviewproduct;
   public WebElement getclickonviewproduct()
   {
	   return clickonviewproduct;
   }
   
   @FindBy(id = "quantity")
   private WebElement increaseproductquantity;
   public WebElement getincreaseproductquantity()
   {
	   return increaseproductquantity;
   }
    
   @FindBy(xpath = "//button[@class='btn btn-default cart']")
   private WebElement clickonaddtocartbuttoninsideviewcartpage;
   public WebElement getclickonaddtocartbuttoninsideviewcartpage()
   {
	   return clickonaddtocartbuttoninsideviewcartpage;
   }
   
   @FindBy(xpath = "//button[text()='Continue Shopping']")
   private WebElement clickoncountinueBT;
   public WebElement getclickoncountinueBT()
   {
	   return clickoncountinueBT;
   }
   
   @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
   private WebElement clickoncartBT;
   public WebElement getclickoncartBT()
   {
	   return clickoncartBT;
   }
   
   @FindBy(xpath = "//a[text()='Sleeves Printed Top - White']/parent::h4/parent::td/following-sibling::td/following-sibling::td[@class='cart_quantity']")
   private WebElement increasedProductQuantity;
   public WebElement getincreasedProductQuantity()
   {
	   return increasedProductQuantity;
   }
   
   
	
	
	
	
	

}
