package purchaseproductDownloadInvoice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class PurchaseProductDownLoadInvoice {
	public static void main(String[] args) throws InterruptedException {
		downLoadInvoiceAfterpurchaseOrder();
	}
	
	public static void downLoadInvoiceAfterpurchaseOrder() throws InterruptedException
	{
		WebDriver driver=	new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://automationexercise.com/");
		String actualhomepagetext=	driver.findElement(By.xpath("//i[@class='fa fa-home']/parent::a[@href='/']")).getText();
		String expected="Home";
		Assert.assertEquals(actualhomepagetext, expected);
	WebElement scroll=	driver.findElement(By.xpath("//a[@href=\"/brand_products/Mast & Harbour\"]"));
		Actions acobj=new Actions(driver);
		acobj.scrollToElement(scroll).build().perform();
		 
	WebElement firstproduct=	driver.findElement(By.xpath("//img[@src=\"/get_product_picture/1\"]"));
	    
	     acobj.moveToElement(firstproduct).build().perform();
	     JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement addtocart= driver.findElement(By.xpath("//img[@src=\"/get_product_picture/1\"]/following-sibling::h2/following-sibling::p/following-sibling::a[@data-product-id=\"1\"]"));
		js.executeScript("arguments[0].click()", addtocart);
		  //addtocart.click();
          // click on continue Buttonnnnn
		  
	WebElement clickonContinueBT=driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
    clickonContinueBT.click();

	   
		WebElement cartBT= driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']/parent::a[@href=\"/view_cart\"]"));
		cartBT.click();
		//verify user nevigate on the add to cart  page
		String actualtitleofaddtocart= driver.getTitle();
		String expectedTitle="Automation Exercise - Checkout";
		Assert.assertEquals(actualtitleofaddtocart, expectedTitle);
	WebElement clickprocedtocheckout=	driver.findElement(By.xpath("//a[text()='Proceed To Checkout']"));
	clickprocedtocheckout.click();
		//click on the registration button
		driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
		//registraion
		WebElement userNameTB= driver.findElement(By.xpath("//input[@name='name']"));
		userNameTB.sendKeys("codingKishan");
		WebElement emailTB=  driver.findElement(By.xpath("//h2[text()='New User Signup!']/following-sibling::form//input/following-sibling::input/following-sibling::input[@placeholder='Email Address']"));
	String randomString=	RandomString.make(2);
		emailTB.sendKeys("codingKishan@yopmail.com"+randomString);
		WebElement clicksubmitBT=  driver.findElement(By.xpath("//button[text()='Signup']"));
		clicksubmitBT.click();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("Kishan@12345");
		WebElement daydrop=  driver.findElement(By.xpath("//select[@id='days']"));
		Select handledaydrop=  new Select(daydrop);
		handledaydrop.selectByValue("5");
		WebElement monthdrop= driver.findElement(By.xpath("//select[@id='months']"));
		Select handlemonthdrop=   new Select(monthdrop);
		handlemonthdrop.selectByValue("9");
		WebElement yeardropdown=   driver.findElement(By.xpath("//select[@id='years']"));
		Select handleyeardown=    new Select(yeardropdown);
		handleyeardown.selectByValue("2005");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("first_name")).sendKeys("Kishan");
		driver.findElement(By.id("last_name")).sendKeys("Dubey");
		driver.findElement(By.id("company")).sendKeys("KishanCompany");
		driver.findElement(By.id("address1")).sendKeys("Bhadohi");
		driver.findElement(By.id("address2")).sendKeys("Varansi");
		WebElement countrydropdown=   driver.findElement(By.xpath("//select[@id='country']"));
		Select handleCountrydropdown=   new Select(countrydropdown);
		handleCountrydropdown.selectByValue("India");
        driver.findElement(By.id("state")).sendKeys("UP");
        driver.findElement(By.id("city")).sendKeys("Bhadohi");
        driver.findElement(By.id("zipcode")).sendKeys("221401");
        driver.findElement(By.id("mobile_number")).sendKeys("6393981251");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
       WebElement accountcreatetext= driver.findElement(By.xpath("//b[text()='Account Created!']"));
     boolean actualvalue=  accountcreatetext.isDisplayed();
     if(actualvalue==true)
     {
    	System.out.println("Account is created successfully and displayed on the page"); 
     }else
     {
     	System.out.println("Account is not created successfully and does not display on the page"); 
     }
    driver.findElement(By.xpath("//a[text()='Continue']")).click();
   String  actualloginusertext= driver.findElement(By.xpath("//b[text()='codingKishan']")).getText();
    Assert.assertEquals(actualloginusertext, "codingKishan");
    cartBT= driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']/parent::a[@href=\"/view_cart\"]"));
    cartBT.click();
    clickprocedtocheckout=	driver.findElement(By.xpath("//a[text()='Proceed To Checkout']"));
    clickprocedtocheckout.click();
    driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("This is Awasome product");
    driver.findElement(By.xpath("//a[text()='Place Order']")).click();
    driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("dabitCart");
    driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("4242424242424242");
    driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("343");
    driver.findElement(By.xpath("//input[@class='form-control card-expiry-month']")).sendKeys("05/09/2024");
    driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2025");
    driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();
    Thread.sleep(2000);
  driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();
  
  
    
    









	}
}
