package com.evs.vtiger.utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sceenshot {

	public static void main(String[] args) throws IOException{
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		Actions ac=  new Actions(driver);
		ac.sendKeys("admin", Keys.TAB).sendKeys("admin", Keys.ENTER).build().perform();
		List<WebElement> list1=  driver.findElements(By.xpath("//td[contains(@class, 'Selected')]"));
		for(int i=0; i<list1.size(); i++)
		{
			list1=  driver.findElements(By.xpath("//td[contains(@class, 'Selected')]"));
			WebElement get1= list1.get(i); 
			String text1= get1.getText();
			if(text1.equalsIgnoreCase("My home page")||text1.equalsIgnoreCase("Marketing")||text1.equalsIgnoreCase("Sales"))
			{
			System.out.println("true");	
			}else
			{
				System.out.println("false");
			}
			System.out.println(text1);
			get1.click();
			List<WebElement> list2= driver.findElements(By.xpath("//td[contains(@class,'SelTab')]"));
			for(int j=0; j<list2.size(); j++)
			{
				list2= driver.findElements(By.xpath("//td[contains(@class,'SelTab')]"));
				WebElement get2=  list2.get(j);	
				String text2=	get2.getText();
				System.out.println(text2);
				get2.click();
			}
		}
	}


}
