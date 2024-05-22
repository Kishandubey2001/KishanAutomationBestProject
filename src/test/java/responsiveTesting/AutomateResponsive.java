package responsiveTesting;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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
       
	   Thread.sleep(5000);
	   screenshot();
	   
   }
   public void screenshot() throws IOException
   {
	   TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    // Generate random string
	    String ran = new RandomString().make(4);

	    // Specify destination file path
	    String destFilePath = "D:\\javacoding\\KishanAutomationBestProject\\Responsive\\" + ran + ".png";
	    File destFile = new File(destFilePath);

	    // Create parent directories if they don't exist
	    destFile.getParentFile().mkdirs();

	    // Copy the file
	    FileUtils.copyFile(source, destFile);
   
}
}