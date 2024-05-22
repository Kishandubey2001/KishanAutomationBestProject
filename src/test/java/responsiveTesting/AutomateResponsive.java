package responsiveTesting;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import net.bytebuddy.utility.RandomString;

public class AutomateResponsive {
	WebDriver driver=null;
	@DataProvider
	public Object [][] mobileEmulations()
	{
		return new Object [][] {
			{"iPad Pro"},
			{"Nexus 5"},
			{"iPhone X"},
			{"Pixel 2"}
			
		};
	}
   @Test(dataProvider = "mobileEmulations")
   public void responsiveTesting(String emulation) throws InterruptedException, IOException
   {
	   System.setProperty("webdriver.chrome.driver", "Driver//chromedriver.exe");
	   Map<String, String> deviceMobEmu=new HashMap<>();
	   deviceMobEmu.put("deviceName", emulation);
	   ChromeOptions chromeOpt=new ChromeOptions();
	   chromeOpt.setExperimentalOption("mobileEmulation", deviceMobEmu);
	   driver=new ChromeDriver(chromeOpt);
	   driver.manage().window().maximize();
	   driver.get("https://automationexercise.com/");
//	   driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("codingbrains13@gmail.com");
//	   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@1234");
//	   driver.findElement(By.xpath("//button[@class='login-btn']")).click();
	   Thread.sleep(5000);
	   screenshot();
	   
   }
   public void screenshot() throws IOException
   {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	File source=  ts.getScreenshotAs(OutputType.FILE);
String ran=	new RandomString().make(4);
	Files.copy(source, new File("C:\\Users\\CBPC-09\\Pictures\\Responsive\\"+ran+".png"));
   }
   
}