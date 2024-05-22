package com.evs.vtiger.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.google.auto.common.BasicAnnotationProcessor.Step;
import com.google.common.io.Files;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KishanWebUtil {

	private WebDriver driver; // null
	public WebDriver getDriver()
	{
		return driver;
	}
	
//    This is singleton class singleton means we can create object Once only
	private KishanWebUtil() {

	}
	private static KishanWebUtil Ksw;

	public static KishanWebUtil getobject() {
		if (Ksw == null) {
			Ksw = new KishanWebUtil();
		}
		return Ksw;
	}
//	 this is Extent report configure
	public ExtentTest getExtentTestObject() {
		return this.extTest;
	}

	private ExtentTest extTest;

	public void setExtentTestObject(ExtentTest extTest) {
		this.extTest = extTest;
	}
	 
	public void launchbrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		} else if (browsername.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gicko.driver", "driver//chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.gicko.driver", "driver//chromedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
		

	}
	
	public void deleteAllcookies()
	{
		try
		{
		 driver.manage().deleteAllCookies();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static WebElement fluentWaitForElement(WebDriver driver, final By locator, int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver1 -> driver1.findElement(locator));
    }

    // Example method for creating a Fluent Wait with custom conditions
    public static WebElement fluentWaitForElementWithCustomCondition(WebDriver driver, int timeoutSeconds, int pollingIntervalMilliseconds, Function<WebDriver, WebElement> condition) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingIntervalMilliseconds))
                .ignoring(NoSuchElementException.class);

        return wait.until(condition);
    }
       
	public String getpagesource() {
		String getpagesource = driver.getPageSource();
		return getpagesource;
	}
     
//	  This is implicitlyWait it use with driver where need to time it will manage 
	// however element is not finding in the page then it will throw nosuch element 
	// it will work where ever need time
	public void myimplicitlyWait(int timeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));

	}
//     This is maximize window method by this we can maximize the window
	public void maximizeWindow() {
		driver.manage().window().maximize();
		extTest.log(Status.INFO, "Passed ! Maximize window successfully");

	}
//    This is get method by this we can hit the url of the application
	public void hitUrl(String hiturl) {
		driver.get(hiturl);
	}
//     This is send keys method by this way we can send the value in input box
	public void mySenkeys(WebElement we, String inputvalue) {
		String elementname = we.getAccessibleName();

		try {
		//	if(we.getText()!=" ")
			we.clear();
			we.sendKeys(inputvalue);
			extTest.log(Status.INFO,
					"Passed ! " + inputvalue + " is input successfully in " + elementname + " text box");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + inputvalue + "'", we);
			extTest.log(Status.INFO,
					"Passed !" + inputvalue + " is input successfully in " + elementname + " text box");

		} catch (StaleElementReferenceException e) {
			we.sendKeys(inputvalue);
			extTest.log(Status.INFO,
					"Passed ! " + inputvalue + " is input successfully in " + elementname + " text box");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"Failed ! " + inputvalue + " is not input successfully in " + elementname + " text box");

		}
	}
//       This is myclick method by this way we can click on the element
	public void myclick(WebElement we) {
		String elementname = we.getAccessibleName();
		try {
			we.click();
			extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " ");
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", we);
			extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " using java script");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", we);
			extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " using javascript");
		} catch (StaleElementReferenceException e) {
			we.click();
			extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " ");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed ! Click is not perform on " + elementname + " ");

			throw e;

		}
	}
//   This is listmyclick by this way we can click one time on the listed element	
	public void myclick(List<WebElement> list) {

		for (int i = 0; i < list.size(); i++) {
			WebElement welist = list.get(i);
			String elementname = welist.getAccessibleName();
			try {
				welist.click();
			}

			catch (ElementClickInterceptedException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", welist);
				extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " using java script");

			} catch (ElementNotInteractableException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", welist);
				extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " using javascript");

			} catch (StaleElementReferenceException e) {
				((WebElement) welist).click();
				extTest.log(Status.INFO, "Passed ! Click is perform on " + elementname + " ");

			} catch (Exception e) {
				e.printStackTrace();
				extTest.log(Status.INFO, "Failed ! Click is not perform on " + elementname + " ");

				throw e;

			}
		}

	}
//         This is verify string method by this method we can verify expected and actual value
	public void verifyString(String actualtext, String expected) {
		if (actualtext.contains(expected)) {
			extTest.log(Status.PASS, "Passed " + actualtext + " and " + expected + " are matched of ");

		} else {
			extTest.log(Status.FAIL, "Failed " + actualtext + " and " + expected + " are not matched of ");

		}
	}
//   This is mygetText method by this method we can get InnterText of the element
	public String mygetText(WebElement we) {
		String elementname = we.getAccessibleName();
		String gettext = null;
		try {
			gettext = we.getText();
			extTest.log(Status.INFO, "Passed ! Get text take successfully of " + elementname + "");

		} catch (StaleElementReferenceException e) {
			gettext = we.getText();
			extTest.log(Status.INFO, "Passed ! Get text take successfully of " + elementname + "");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! Get text is not take successfully of " + elementname + "");

			throw e;
		}
		return gettext;
	}
	
//  This is getTitle method by this method we can get GetTitle of the window 
	
	public String getTitle() {
		String gettitle = null;
		try {
			gettitle = driver.getTitle();
			extTest.log(Status.INFO, "Passed ! GetTitle got successfully of UI page");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed !GetTitle did not get successfully of UI page");
			System.err.println();
			throw e;
		}
		return gettitle;

	}
//     This is mouseover method by this method we can hower mouse on the element
	public void mymouseover(WebElement we) {
		String elementname = we.getAccessibleName();
		Actions acobj = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			acobj.moveToElement(we).build().perform();
			extTest.log(Status.INFO, "Passed !Mause over has been successfully of " + elementname + "");

		} catch (StaleElementReferenceException e) {
			acobj.moveToElement(we).build().perform();
			extTest.log(Status.INFO, "Passed ! Mause over has been successfully of " + elementname + "");

		} catch (ElementNotInteractableException e) {
			if (driver instanceof JavascriptExecutor) {
				String script = "var evObj = document.createEvent('MouseEvents');"
						+ "evObj.initMouseEvent('mouseover',true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
						+ "arguments[0].dispatchEvent(evObj);";
				js.executeScript(script, we);
				extTest.log(Status.INFO, "Passed ! JavaScript Executor is  supported.");

			} else {
				extTest.log(Status.FAIL, "Failed !JavaScript Executor is not supported.");

			}

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! Mause over has not worked successfully of " + elementname + "");

			throw e;
		}

	}

	//  This is actions click by this method we can click on the element if normal click is not working then

	public void actionsclick(WebElement we) {
		String elementName = we.getAccessibleName();
		Actions acobj = new Actions(driver);
		try {
			acobj.click(we).build().perform();
			extTest.log(Status.INFO,
					"Passed !click is performed on " + elementName + " using the actions click(webelement) method");

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", we);
			extTest.log(Status.INFO, "Passed ! click is performed on " + elementName + " using the javasript click()");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", we);
			extTest.log(Status.INFO, "Passed ! click is performed on " + elementName + " using the javasript click()");
		} catch (StaleElementReferenceException e) {
			acobj.click(we).build().perform();
			extTest.log(Status.INFO,
					"Passed !click is performed on " + elementName + " using the actions click(webelement) method");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !click is not performed on " + elementName + " using the actions click()");

			throw e;
		}

	}
//    This is double click method if we wanna double click then we will have to use double click of the Actions class
	public void acDoubleclick(WebElement we) {
		String elementname = we.getAccessibleName();
		Actions acobj = new Actions(driver);
		try {
			acobj.doubleClick(we).build().perform();
			extTest.log(Status.INFO, "Passed ! Double click performed on " + elementname
					+ " successfully using action doubleclick method");

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String jsDoubleClick = "var target = arguments[0];                                 "
					+ "var offsetX = arguments[1];                                "
					+ "var offsetY = arguments[2];                                "
					+ "var rect = target.getBoundingClientRect();                 "
					+ "var cx = rect.left + (offsetX || (rect.width / 2));        "
					+ "var cy = rect.top + (offsetY || (rect.height / 2));        "
					+ "                                                           "
					+ "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); "
					+ "emit('mouseup',   {clientX: cx, clientY: cy});             "
					+ "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); "
					+ "emit('mouseup',   {clientX: cx, clientY: cy});             "
					+ "emit('click',     {clientX: cx, clientY: cy, detail: 2});  "
					+ "                                                           "
					+ "function emit(name, init) {                                "
					+ "target.dispatchEvent(new MouseEvent(name, init));        "
					+ "}                                                          ";
			js.executeScript(jsDoubleClick, we);
			extTest.log(Status.INFO,
					"Passed ! doubleclick is performed on " + elementname + " using the javascript double click");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			String jsDoubleClick = "var target = arguments[0];                                 "
					+ "var offsetX = arguments[1];                                "
					+ "var offsetY = arguments[2];                                "
					+ "var rect = target.getBoundingClientRect();                 "
					+ "var cx = rect.left + (offsetX || (rect.width / 2));        "
					+ "var cy = rect.top + (offsetY || (rect.height / 2));        "
					+ "                                                           "
					+ "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); "
					+ "emit('mouseup',   {clientX: cx, clientY: cy});             "
					+ "emit('mousedown', {clientX: cx, clientY: cy, buttons: 1}); "
					+ "emit('mouseup',   {clientX: cx, clientY: cy});             "
					+ "emit('click',     {clientX: cx, clientY: cy, detail: 2});  "
					+ "                                                           "
					+ "function emit(name, init) {                                "
					+ "target.dispatchEvent(new MouseEvent(name, init));        "
					+ "}                                                          ";
			js.executeScript(jsDoubleClick, we);
			extTest.log(Status.INFO,
					"Passed ! doubleclick is performed on " + elementname + " using the javascript double click");

		} catch (StaleElementReferenceException e) {
			acobj.doubleClick(we);
			extTest.log(Status.INFO, "Passed ! doubleclick is performed on " + elementname + " double click method");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! doubleclick is not performed on " + elementname + " ");

		}

	}
//       This is context click method of the Actions class by this method we can right click on the element
	public void acRightClick(WebElement we) {
		String elementName = we.getAccessibleName();
		Actions acobj = new Actions(driver);
		try {
			acobj.contextClick(we).build().perform();

			extTest.log(Status.INFO, "Passed ! Right click is performed on " + elementName + " ");

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var event = new MouseEvent('contextmenu', {" + "  bubbles: true," + "  cancelable: false,"
					+ "  view: window" + "});" + "arguments[0].dispatchEvent(event);";
			js.executeScript(script, we);
			extTest.log(Status.INFO, "Passed ! Right click is performed on " + elementName + " using the javasript");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var event = new MouseEvent('contextmenu', {" + "  bubbles: true," + "  cancelable: false,"
					+ "  view: window" + "});" + "arguments[0].dispatchEvent(event);";
			js.executeScript(script, we);
			extTest.log(Status.INFO, "Passed ! Right click is performed on " + elementName + " using the javasript");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! Right click is not performed on " + elementName + " ");

		}

	}
//      This is drag and drop method of the Actions class by this way we can drag the element to drop the onther place
	public void acdragAnddrop(WebElement wedrag, WebElement wedrop) throws InterruptedException {
		String dragelement = wedrag.getAccessibleName();
		String DropElement = wedrop.getAccessibleName();

		Actions acobj = new Actions(driver);
		try {
			acobj.dragAndDrop(wedrag, wedrop).build().perform();
			extTest.log(Status.INFO, "Passed !" + dragelement + " is drag at the place " + DropElement + "");

		} catch (StaleElementReferenceException e) {
			acobj.dragAndDrop(wedrag, wedrop).build().perform();
		} catch (ElementNotInteractableException e) {
			String xto = Integer.toString(wedrag.getLocation().x);
			String yto = Integer.toString(wedrop.getLocation().y);
			((JavascriptExecutor) driver).executeScript(
					"function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
							+ "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
					wedrag, xto, yto);
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !drag and drog didn't work");

			throw e;
		}

	}
   // This is second way to drag and drop 
	
	public void dragdrop(By ByFrom, By ByTo) {
		WebElement LocatorFrom = driver.findElement(ByFrom);
		WebElement LocatorTo = driver.findElement(ByTo);
		String xto = Integer.toString(LocatorTo.getLocation().x);
		String yto = Integer.toString(LocatorTo.getLocation().y);
		((JavascriptExecutor) driver).executeScript(
				"function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; "
						+ "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
				LocatorFrom, xto, yto);
	}
//       This is dropdownindex by this method we can handle the dropdown with indexed based
	
	public void mydropdownindex(WebElement we, int indexnumber) {
		String elementname = we.getAccessibleName();

		Select dropdown = new Select(we);
		try {
			dropdown.selectByIndex(indexnumber);
			extTest.log(Status.INFO,
					"Passed ! Index number " + indexnumber + "th element is selected successfully " + elementname + "");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "arguments[0].selectedIndex = " + indexnumber + ";";
			jsExecutor.executeScript(script, we);
			extTest.log(Status.INFO,
					"Passed ! Index number " + indexnumber + "th element is selected successfully " + elementname + "");

		} catch (StaleElementReferenceException e) {
			Select dropdown1 = new Select(we);
			dropdown1.selectByIndex(indexnumber);
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed!Index number " + indexnumber + "th element is not selected successfully "
					+ elementname + "");
			throw e;
		}

	}
//    This is handledrop down with visible text by this method we can handle the drop drop down basis of the visible text
	public void mydropdownByVisibleText(WebElement we, String visibleTextToSelect) {
		String elementName = we.getAccessibleName();
		Select dropdown = new Select(we);
		try {
			dropdown.selectByVisibleText(visibleTextToSelect);
			extTest.log(Status.INFO,
					"Passed !" + visibleTextToSelect + " is selected in " + elementName + " successfully");

		} catch (ElementNotInteractableException e) {
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "var dropdown = arguments[0];" + "var visi" + "bleText = arguments[1];"
					+ "for (var i = 0; i < dropdown.options.length; i++) {"
					+ "  if (dropdown.options[i].textContent === visibleText) {" + "    dropdown.selectedIndex = i;"
					+ "    break;" + "  }" + "}";
			jsExecutor.executeScript(script, we, visibleTextToSelect);
			extTest.log(Status.INFO,
					"Passed !" + visibleTextToSelect + " is selected in " + elementName + " successfully");
		} catch (StaleElementReferenceException e) {
			Select dropdown1 = new Select(we);
			dropdown1.selectByVisibleText(visibleTextToSelect);
			extTest.log(Status.INFO,
					"Passed !" + visibleTextToSelect + " is selected in " + elementName + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO,
					"Failed !" + visibleTextToSelect + " is not selected in " + elementName + " successfully");

			throw e;
		}
	}
//    This is dropdownselected Byvalue by this we can handle the dropdown with Value 
	public void mydropdownSelectedValue(WebElement we, String selectedValue) {
		String elementname = we.getAccessibleName();
		Select dropdownSelectedValue = new Select(we);
		try {
			dropdownSelectedValue.selectByValue(selectedValue);
			extTest.log(Status.INFO,
					"Passed ! " + selectedValue + " is selected in " + selectedValue + " successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "var dropdown = arguments[0];" + "var value = arguments[1];"
					+ "for (var i = 0; i < dropdown.options.length; i++) {"
					+ "  if (dropdown.options[i].value === value) {" + "    dropdown.selectedIndex = i;" + "    break;"
					+ "  }" + "}";
			jsExecutor.executeScript(script, we, selectedValue);
			extTest.log(Status.INFO,
					"Passed ! " + selectedValue + " is selected in " + selectedValue + " successfully");

		} catch (StaleElementReferenceException e) {
			dropdownSelectedValue = new Select(we);
			dropdownSelectedValue.selectByValue(selectedValue);
			extTest.log(Status.INFO,
					"Passed ! " + selectedValue + " is selected in " + selectedValue + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO,
					"Failed ! " + selectedValue + " is not selected in " + selectedValue + " successfully");

			throw e;
		}

	}
//       This is get first selected option by this we can get which drop down is selected already 
	public String getFirstSelectedOptions(WebElement we, String insertvalue) {
		String elementName = we.getAccessibleName();
		Select obj = new Select(we);
		obj.selectByValue(insertvalue);
		WebElement weselectoption = obj.getFirstSelectedOption();
		String actualtext = weselectoption.getAttribute("value");
		return actualtext;

	}
//      This is getAll options method by this way we can all option of the drop down
	public List<String> getAlloption(WebElement we) {
		String elementName = we.getAccessibleName();

		List<String> getAlloptions = new ArrayList<String>();
		// WebElement wefind= myfindElements(xpath, elementName);
		Select objs = new Select(we);
		List<WebElement> getalloptions = objs.getOptions();
		int sizeofdropdown = getalloptions.size();
		for (int i = 0; i < sizeofdropdown; i++) {
			WebElement getall = getalloptions.get(i);
			String expectedAlloptions = getall.getText();
			getAlloptions.add(expectedAlloptions);

		}
		return getAlloptions;

	}
//    This is drop dwon size method by this method we can get how much options is presend in the drop down
	public int getsizeofdropdown(WebElement we, String elementName) {
		Select objS = new Select(we);
		List<WebElement> listofgetsize = objS.getOptions();
		int actual = listofgetsize.size();
		return actual;

	}
//  This is getCurrent URL by this way we can know that we url we are using right now
	public String getCurrentURl() {
		try {
			String getcurrenturl = driver.getCurrentUrl();
			return getcurrenturl;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
//   This is verify the int method by this method we can verify actual int value and expected int value
	public void verifyInt(int actualsize, int expectedsize) {
		if (actualsize == expectedsize) {
			extTest.log(Status.PASS, "Passed " + actualsize + " and " + expectedsize + " are matched");

		} else {
			extTest.log(Status.INFO, "Failed " + actualsize + " and " + expectedsize + " are mismatched");

		}
	}
//     This is myscroll method of the Actions class by this method we can scroll the page up to down
	public void myscroll(int x, int y) {
		try {
			Actions acobj = new Actions(driver);
			acobj.scrollByAmount(x, y).build().perform();
			extTest.log(Status.INFO, "Passed ! Scroll is done successfully using actions ");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
//   this scroll by javaScript by this method we can scroll the page up to down 
	public void scrollbyJavasript() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1000);");
			extTest.log(Status.INFO, "Passed ! Scroll is done successfully using javascript");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !Scroll is not done successfully using javascript");

			throw e;
		}
	}
//     This is scrolltoelement with help of the  javaScript method we can scroll the page till the element
	public void scrolltoElement(WebElement we) {
		String elementName = we.getAccessibleName();
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", we);
			System.out.println("Passed ! Scroll is done successfully using javascript");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !Scroll is not done successfully using javascript");

			throw e;
		}

	}
//   This is isdisplayed method of the webElemet by this method we can verify that element is displayed on the page or not
	public void isDisplayed(WebElement we) {

		try {
			boolean actual = we.isDisplayed();
			if (actual == true) {
				extTest.log(Status.INFO, "Passed ! this " + we + " is Visible on UI");

			} else {
				extTest.log(Status.INFO, "Failed ! this " + we + " is not Visible on UI ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed This " + we + " is not Visible on UI");
			throw e;
		}

	}
   
	public void isEnable(WebElement we, String elementname, String typeofPerform) {
		try {
			boolean actual = we.isEnabled();
			if (actual == true) {
				extTest.log(Status.INFO, "Pased ! this " + we + " is Enabled On UI");

			} else {
				extTest.log(Status.INFO, "Failed ! " + we + " is Disabled On UI");

			}

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! " + we + " is Disabled On UI");

			throw e;
		}
	}

	public void ActionsScroll(WebElement we) {
		Actions ac = new Actions(driver);
		ac.scrollToElement(we).build().perform();
		extTest.log(Status.INFO, "Actions scroll working here");

	}

	public void ActionsScroll2(int x, int y) {
		Actions ac = new Actions(driver);
		ac.scrollByAmount(x, y).build().perform();
		extTest.log(Status.INFO, "Actions scroll working here");

	}

	public void ActionsScroll3(ScrollOrigin we) {
		Actions ac = new Actions(driver);
		ac.scrollFromOrigin(we, 0, 0).build().perform();
		extTest.log(Status.INFO, "Actions scroll working here");

	}

	public boolean verifyboolean(boolean actual, String elementName, String typeofPreform) {
		if (actual == true) {
			extTest.log(Status.INFO, "Passed ! " + elementName + " is " + typeofPreform + " on UI");

		} else if (actual == false) {
			extTest.log(Status.INFO, "Passed ! " + elementName + " is " + typeofPreform + " on UI");

		}
		return actual;

	}

	public void verifyisSelected(WebElement we, String elementName) {
		try {
			boolean actualselected = we.isSelected();
			if (actualselected == false) {
				extTest.log(Status.INFO, "Failed !it is not selected");

			} else {
				extTest.log(Status.INFO, "Passed !It is selected");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void waitUntilElementIsvisible(By objB, int timeouts) {

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.visibilityOfElementLocated(objB));
		extTest.log(Status.INFO, "Passed ! waitUntilElementIsvisible worked properly");
	}

	public void waitUntilinVisibleElementOnUI(By objB, int timeouts) {

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.invisibilityOfElementLocated(objB));
		System.out.println("Passed ! waitUntilinVisibleElementOnUI worked properly");
	}

	public void waitUntilElementIsvisible(WebElement we, String elmentName, int timeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.visibilityOf(we));
		extTest.log(Status.INFO, "Passed ! waitUntilElementIsvisible worked properly");

	}

	public void waitUntilElementIsEnable(WebElement we, String elmentName, int timeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.elementToBeClickable(we));
		extTest.log(Status.INFO, "Passed ! waitUntilElementIsEnable worked properly");

	}

	public void waitUntilElementIsEnable(By objb, int timeouts) {

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.elementToBeClickable(objb));
		extTest.log(Status.INFO, "Passed !waitUntilElementIsEnable worked properly");
	}

	public void waitUntilElementIsDisable(By objb, int timeouts) {

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(objb)));
		extTest.log(Status.INFO, "Passed ! waitUntilElementIsDisable worked properly");

	}

	public void waitUntilElementIsDisable(WebElement we, String elementname, int timeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(we)));
		extTest.log(Status.INFO, "Passed ! waitUntilElementIsDisable worked properly");

	}

	public void waitUntilElementTextChanged(By objb, String text, int timeouts) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wt.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(objb, text)));
		extTest.log(Status.INFO, "Passed ! waitUntilElementTextChanged worked properly");

	}

	public void myclose() {
		try {
			driver.close();
			extTest.log(Status.INFO, "Passed !close worked successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! close didn't worked successfully");

			throw e;
		}

	}

	public void myquite() {
		try {
			driver.quit();
			extTest.log(Status.INFO, "Passed ! myquite worked successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed  myquite didn't worked successfully");
			throw e;
		}

	}

	public void myclear(WebElement we, String elementname) {
		try {
			we.clear();
			extTest.log(Status.INFO, "Passed ! " + elementname + "'s element is clear successfully");

		} catch (StaleElementReferenceException e) {
			we.clear();
			System.out.println("Passed ! " + elementname + "'s element is cleared successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value = '';", we);
			extTest.log(Status.INFO, "Passed ! " + elementname + "'s element is cleared successfully");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! " + elementname + "'s element is not cleared successfully");
			System.out.println();
			throw e;
		}

	}

	public void switchtowindowTitle(String expectedTitle) {
		try {
			Set<String> handlevalue = driver.getWindowHandles();
			for (String eachvalue : handlevalue) {
				driver.switchTo().window(eachvalue);
				String gettite = getTitle();
				if (gettite.equalsIgnoreCase(expectedTitle)) {
					break;
				}
			}
			extTest.log(Status.INFO, "Passed ! It has been switched on window successfully through the getTitle");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !It has not been switched on window successfully through the getTitle");
			throw e;
		}

	}

	public void switchtowindowContainsTitle(String expectedTitle) {
		try {
			Set<String> handlevalue = driver.getWindowHandles();
			for (String eachvalue : handlevalue) {
				driver.switchTo().window(eachvalue);
				String gettite = getTitle();
				if (gettite.contains(expectedTitle) == true) {
					break;
				}
			}
			extTest.log(Status.INFO,
					"Passed !It has been switched on window successfully through the getTitleContains");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO,
					"Failed ! It has not been switched on window successfully through the getTitleContains");

			throw e;
		}

	}

	public void switchtowidowUrl(String expectedurl) {
		try {
			Set<String> handlevalue = driver.getWindowHandles();
			for (String eachvalue : handlevalue) {
				driver.switchTo().window(eachvalue);
				String geturl = getCurrentURl();
				if (geturl.equalsIgnoreCase(expectedurl)) {
					break;
				}
			}
			extTest.log(Status.INFO, "Passed ! It has been switched on window successfully through the url");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! It has not been switched on window successfully through the url");
			throw e;
		}

	}

	public void switchtowidowContainsUrl(String expectedurl) {
		try {
			Set<String> handlevalue = driver.getWindowHandles();
			for (String eachvalue : handlevalue) {
				driver.switchTo().window(eachvalue);
				String geturl = getCurrentURl();
				if (geturl.contains(expectedurl)) {
					break;
				}
			}
			extTest.log(Status.INFO, "Passed !It has been switched on window successfully through the Containsurl");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !It has not been switched on window successfully through the Containsurl");
			throw e;
		}

	}

	public void switchtoframeIndex(int index) {
		try {
			driver.switchTo().frame(index);
			extTest.log(Status.INFO,
					"Passed ! it has been switched into frame through the indexing successfully from frame");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO,
					"Failed !it has not been switched into frame through the indexing successfully from frame");
			throw e;
		}
	}

	public void switchtoframeIdorName(String idorname) {
		try {
			driver.switchTo().frame((idorname));
			extTest.log(Status.INFO,
					"Passed ! it has been switched into frame through the webelement successfully from frame");

		} catch (Exception e) {
			e.printStackTrace();
			driver.switchTo().frame((idorname));
			extTest.log(Status.INFO,
					"Failed !it has not been switched into frame through IDorName successfully from frame");

			throw e;
		}
	}

	public void swicthtoframeWebElement(WebElement we, String elementName) {
		try {
			driver.switchTo().frame(we);
			extTest.log(Status.INFO,
					"Passed ! it has been switched into frame through the webelement successfully from frame");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO,
					"Failed it has not been switched into frame through the webelement successfully from frame");
			throw e;
		}
	}

	public void switchoutFromeFrame() {
		try {
			driver.switchTo().defaultContent();
			extTest.log(Status.INFO, "Passed ! it has been got out successfully from frame");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! it has been got out successfully from frame");
			throw e;
		}
	}

	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			extTest.log(Status.INFO, "Passed !parentFrame method has worked properly");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !parentFrame method has worked properly");
		}

	}

	public void takeScreenshotofFullpage(String folderlocation) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File soucrce = ts.getScreenshotAs(OutputType.FILE);
			Files.copy(soucrce, new File(folderlocation));
			extTest.log(Status.INFO, "Passed ! Screenshot has been taken of fullpage successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed !Screenshot has been taken of full page successfully");

			throw e;
		}

	}

	/**
	 * this method is used for TakeScreenshot of hole page
	 * 
	 * @param xpath
	 * @param elementName
	 * @param folderlocation
	 * @throws IOException
	 */
	public void takesScreenshotofparticularElement(WebElement we, String elementName, String folderlocation)
			throws IOException {
		try {
			File soucrce = we.getScreenshotAs(OutputType.FILE);
			Files.copy(soucrce, new File(folderlocation+".png"));
			extTest.log(Status.INFO, "Screenshot has been taken of " + elementName + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Screenshot has been taken of " + elementName + " successfully");
			throw e;
		}

	}

	public void popupaccept() {
		try {
			driver.switchTo().alert().accept();
			extTest.log(Status.INFO, "Passed !Popup has been accepted successfully");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! Popup has not been accepted successfully");
			System.err.println();
			throw e;
		}

	}

	public void popupdismissed() {
		try {

			driver.switchTo().alert().dismiss();
			extTest.log(Status.INFO, "Passed !Popup has been accepted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Failed ! Popup has not been accepted successfully");
			System.err.println();
			throw e;
		}

	}

	public String popupgetmessage() {
		try {
			String gettext = driver.switchTo().alert().getText();
			return gettext;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void verifypopupmessage(String expectedpopupmessage) {
		String actualpopupmessage = popupgetmessage();
		if (actualpopupmessage.equals(expectedpopupmessage)) {
			extTest.log(Status.INFO, "Passed! popup message is showing and right");
		} else {
			extTest.log(Status.INFO, "Failed! popup message is not showing and not right");

		}

	}

//	public  List<WebElement >  myfindElements(List<WebElement> listwe,String listname)
//	{
//		//List<WebElement > welist= driver.findElements(By.xpath(listexpath));	
//		System.out.println(listname+" all list found successfully");
//		return listwe;
//	}

	public void checkAllChecksboxes(List<WebElement> listwe, String collectioElementName) {
		// List<WebElement> checkallboxes= myfindElements(xpath,collectioElementName);
		for (int i = 0; i < listwe.size(); i++) {
			WebElement webcheck = listwe.get(i);
			if (webcheck.isSelected() == false) {
				try {
					webcheck.click();
				} catch (ElementNotInteractableException e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click()", webcheck);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}

			} else {
				extTest.log(Status.INFO, " it is already checked");
			}
		}
	}

	public void UncheckAllChecksboxes(List<WebElement> listwe, String collectioElementName) {
		// List<WebElement> checkallboxes= myfindElements(xpath,collectioElementName);
		for (int i = 0; i < listwe.size(); i++) {
			WebElement webcheck = listwe.get(i);
			if (webcheck.isSelected() == true) {
				try {
					webcheck.click();
				} catch (ElementNotInteractableException e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click()", webcheck);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}

			} else {
				extTest.log(Status.INFO, " it is already unchecked");
			}
		}
	}

	public int getTableColumnCount(List<WebElement> tablelistwe, String elementName) {
		int tablecolumnCount = tablelistwe.size();
		extTest.log(Status.INFO, "getTableColumnCount");
		return tablecolumnCount;

	}

	public int getTableRowCount(List<WebElement> tablelistwe, String elementName) {

		int rowCount = tablelistwe.size() - 1;
		extTest.log(Status.INFO, "getTableRowCount");
		return rowCount;
	}

	public int getTableColumnHeaderCount(List<WebElement> tablelistwe, String elementName) {
		int columnCount = tablelistwe.size();
		extTest.log(Status.INFO, "getTableColumnHeaderCount");
		return columnCount;
	}

	/* in this method we want all the column header names in a list<String> */
	public List<String> getTableColumnNamesList(List<WebElement> tablewelist, String elementName) {
		List<WebElement> weListColumns = driver.findElements(By.xpath(tablewelist + "//tr[1]//td"));
		List<String> listColumnNames = new ArrayList<String>();
		int columnCount = weListColumns.size();
		for (int i = 0; i <= columnCount - 1; i++) {
			WebElement weColumnHeader = weListColumns.get(i);
			String columnName = weColumnHeader.getText();
			listColumnNames.add(columnName);
		}
		extTest.log(Status.INFO, "getTableColumnNamesList");
		return listColumnNames;
	}

	/* this method returns column number on the basis of column name */
	public int getColumnNumberByColumnName(List<WebElement> tablelistwe, String tableName, String columnName) {
		int columnNumber = -1;
		int columnCount = tablelistwe.size();
		for (int i = 0; i <= columnCount - 1; i++) {
			WebElement weTableColumn = tablelistwe.get(i);
			String tablColumnName = weTableColumn.getText();
			if (tablColumnName.equalsIgnoreCase(columnName) == true) {
				columnNumber = i;
				break;
			}
		}
		extTest.log(Status.INFO, "getColumnNumberByColumnName");

		return columnNumber;

	}

	/* this method returns row data in list on the basis of row number */
	public List<String> getRowDataListByRowNumber(List<WebElement> tablelistwe, String tableName, int rowNumber) {
		List<String> rowDataList = new ArrayList<String>();
		for (int i = 0; i <= tablelistwe.size() - 1; i++) {
			WebElement weRowData = tablelistwe.get(i);
			String data = weRowData.getText();
			rowDataList.add(data);
		}
		extTest.log(Status.INFO, "getRowDataListByRowNumber");
		return rowDataList;
	}

	public List<String> getColumnDataListByColumnNumber(List<WebElement> tablelistwe, String tableName,
			int columnNumber) {
		List<String> columnNameList = new ArrayList<>();
		for (int i = 1; i < tablelistwe.size(); i++) {
			String columnName = tablelistwe.get(i).getText();
			columnNameList.add(columnName);
		}
		extTest.log(Status.INFO, "getColumnDataListByColumnNumber");
		return columnNameList;
	}

	public void verifyinnertext(WebElement we, String expectedValue) {
		String actualvalue = we.getText();
		
		System.out.println(actualvalue);
		if (actualvalue.equals(expectedValue)) {
			extTest.log(Status.PASS,
					"Passed! actual " + actualvalue + " && expectedvalue" + expectedValue + " are matched");
		} else {
			extTest.log(Status.FAIL,
					"Failed! actual " + actualvalue + " && expectedvalue" + expectedValue + " are not matched");
			System.out.println();
		}
		Assert.assertEquals(actualvalue, expectedValue);
	}

	public void verifyatrributevalue(WebElement we, String expectedValue, String acttributevalue) {
		String actualvalue = we.getAttribute(acttributevalue);
		if (actualvalue.equals(expectedValue)) {
			extTest.log(Status.PASS,
					"Passed! actual " + actualvalue + " && expectedvalue" + expectedValue + " are matched");
		} else {
			extTest.log(Status.INFO,
					"Failed! actual " + actualvalue + " && expectedvalue" + expectedValue + " are not matched");
		}
		Assert.assertEquals(actualvalue, expectedValue);

	}

	public void verifygetTitle(String expectedTitle) {
		String actualtitle = driver.getTitle();
		if (actualtitle.equals(expectedTitle)) {
			extTest.log(Status.PASS,
					"Passed! actual " + actualtitle + " expectedtitle" + expectedTitle + " are matched");
		} else {
			extTest.log(Status.FAIL,
					"Failed! actual " + actualtitle + " expectedtitle" + expectedTitle + " are not matched");
		}
		Assert.assertEquals(actualtitle, expectedTitle);

	}

	public void verifyIsDisplayed(WebElement we) {
		boolean actual = we.isDisplayed();
		if (actual == true) {
			extTest.log(Status.PASS, "Passed ! " + actual + " is displayed on UI");
		} else {
			extTest.log(Status.FAIL, "Failed ! " + actual + " is not displayed on UI");
		}
		Assert.assertEquals(actual, true);

	}

	public void verifyIsSelected(WebElement we) {
		boolean actual = we.isSelected();
		if (actual == true) {
			extTest.log(Status.PASS, "Passed ! " + actual + " is selected on UI");
		} else {
			extTest.log(Status.FAIL, "Failed ! " + actual + " is not selected on UI");
		}
		Assert.assertEquals(actual, true);

	}

	public void verifyIsEnabled(WebElement we) {
		boolean actual = we.isEnabled();
		if (actual == true) {
			extTest.log(Status.PASS, "Passed ! " + actual + " is selected on UI");
		} else {
			extTest.log(Status.FAIL, "Failed ! " + actual + " is not selected on UI");
		}
		Assert.assertEquals(actual, true);

	}

	public String takeSnapshot(String testcaseName) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File snapshotSourceFileobj = tss.getScreenshotAs(OutputType.FILE);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy hh_mm_ss a");
		String timeStamp = df.format(new Date());
		File SnapshotDestinationFileObj = new File("test-output" + testcaseName + timeStamp + ".png");
		try {
			Files.copy(snapshotSourceFileobj, SnapshotDestinationFileObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return snapshotSourceFileobj.getAbsolutePath();
	}
	
	
//	public  List<String> getColumnDataListByColumnName( List<WebElement> tablelistwe1,String tableName,String columnName) {
//		//		int columnNumber=-1;
//		//		List<WebElement> listColumnNames=driver.findElements(By.xpath(tableXpath+"//tr[1]//td"));
//		//		int columnCount=listColumnNames.size();
//		//		for(int i=0; i<=columnCount-1;i++) {
//		//			WebElement weTableColumn=listColumnNames.get(i);
//		//			String tablColumnName=weTableColumn.getText();
//		//			if(tablColumnName.equalsIgnoreCase(columnName)==true) {
//		//                 columnNumber=i;
//		//                 break;
//		//			}
//		//		}
//		//		
//		//		List<WebElement> columnsList=driver.findElements(By.xpath( tableXpath+"//tr//td["+columnNumber+"]"));
//		//		List<String> columnNameList =new ArrayList<>();
//		//		for (int i = 1; i < columnsList.size(); i++) {
//		//			String tableColumnName=columnsList.get(i ).getText();
//		//			columnNameList.add(columnName);
//		//		}
//		int columnNumber=getColumnNumberByColumnName(tablelistwe1, tableName, columnName);
//		//List<String>columnNameList=getColumnDataListByColumnNumber(tablelistwe, tableName, columnNumber);
//
//		return columnNameList;

}

//	public  int getRowNumberByUniqueColumnRowID(String tableXpath, String tableName, String uniqueData, String uniqueColumnName) {
//		int rowNumber=-1;
//		List<String> columnDataList=getColumnDataListByColumnName(tableXpath, tableName,uniqueColumnName);
//		for(int i=0; i<=columnDataList.size()-1;i++) {
//			String uniqueColumnData=columnDataList.get(i);
//			if(uniqueColumnData.equalsIgnoreCase(uniqueData)) {
//				rowNumber=i;
//				break;
//			}
//		}
//		return rowNumber;
//
//
//
//	}
//
//	public  List<String> getRowDataListByRowID(String tableXpath, String tableName, String uniqueData, String uniqueColumnName) {
//		int rowNumber=getRowNumberByUniqueColumnRowID(tableXpath, tableName, uniqueData, uniqueColumnName);
//		List<String>listRowData=getRowDataListByRowNumber(tableXpath, tableName, rowNumber);
//		return listRowData;
//	}
