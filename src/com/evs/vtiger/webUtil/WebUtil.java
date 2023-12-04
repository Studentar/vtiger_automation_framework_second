package com.evs.vtiger.webUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class WebUtil {

	public static WebDriver driver;  ///  null 
	public static String mainWindowHandleValue;
	//===================================> launchBrowser <==============================>

	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		System.out.println("Chrome Browser launched successfully");
		mainWindowHandleValue=driver.getWindowHandle();

	}
	//===================================> launchBrowserAndOpenloginPage <==============================>
	
	public static void launchBrowserAndOpenloginPage() {
		WebUtil.launchBrowser();
		WebUtil.openUrl("http://localhost:8888");
		WebUtil.maximizeWindow();
		mainWindowHandleValue=driver.getWindowHandle();
	}
	//===================================> openUrl <====================================>

	public static void openUrl(String url) {
		driver.get(url);
	}

	//===================================> openUrl <====================================>

	public static String getUrl() {
		String url = null;
		try {
			url = driver.getCurrentUrl();
		} catch (NullPointerException e) {
			System.out.println("your driver value is locatorName so you can not get url");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	//===================================> openUrl <====================================>

	public static String getTitle() {

		String Title = null;
		try {
			Title = driver.getTitle();

		} catch (NullPointerException e) {
			System.out.println("your driver value is locatorName so you can not get title");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Title;

	}

	//===================================> mySendKeys <=================================>


	public static void inputData(WebElement we, String inputValue) {
	//	WebElement we = myFindElement(xpathValue, elementName);
		String elementName= we.getAccessibleName();

		try {
			we.sendKeys(inputValue);
			System.out.println(inputValue+" value entered in "+elementName+" TextBox..");

		}catch (StaleElementReferenceException e) {
			we.sendKeys(inputValue);
			System.out.println(inputValue+" value entered in "+elementName+" TextBox..");

		}catch (ElementNotInteractableException e) {
			 JavascriptExecutor jss=(JavascriptExecutor) driver;
			jss.executeScript("arguments[0].value='admin'", we);
			System.out.println(inputValue+" value entered in "+elementName+" TextBox..");

		}catch (Exception e) {
			System.out.println(inputValue+" value NOT entered in "+elementName+" TextBox..");
			e.printStackTrace();
		}
	}
	//=====================================> myFindElement <===============================>

//	private static WebElement myFindElement(String xpathValue , String elementName) {
//		WebElement we = null;
//		try {
//			we = driver.findElement(By.xpath(xpathValue));
//			System.out.println(elementName+" TextBox found successfully ");
//		}catch (NoSuchElementException e) {
//			WebDriverWait webDriWat=	new WebDriverWait(driver, Duration.ofSeconds(30));
//			webDriWat.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
//			we = driver.findElement(By.xpath(xpathValue));
//
//		}catch (InvalidArgumentException e) {
//			System.out.println("There is something mistake or invalid syntex of xpath ");
//			throw e;
//
//		}catch (Exception e) {
//			System.out.println(elementName+" TextBox NOT found successfully ");
//			e.printStackTrace();
//		}
//		return we;
//	}
	//=====================================> myFindElements <===============================>

//	private static List<WebElement> myFindElements(String xpathValue , String elementName) {
//		List<WebElement> we = null;
//		try {
//			we = driver.findElements(By.xpath(xpathValue));
//			System.out.println(elementName+" TextBox found successfully ");
//		}catch (NoSuchElementException e) {
//			WebDriverWait webDriWat=	new WebDriverWait(driver, Duration.ofSeconds(30));
//			webDriWat.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
//			we = driver.findElements(By.xpath(xpathValue));
//
//		}catch (InvalidArgumentException e) {
//			System.out.println("There is something mistake or invalid syntex of xpath ");
//			throw e;
//
//		}catch (Exception e) {
//			System.out.println(elementName+" TextBox NOT found successfully ");
//			e.printStackTrace();
//		}
//		return we;
//	}
	//=======================================> Click <===================================>

	public static void click(WebElement we) {
		
		String elementName= we.getAccessibleName();
		try {
			we.click();
			System.out.println("Clicked on "+elementName+" Button Succesfully");

		}catch (StaleElementReferenceException e) {
			we.click();
			System.out.println("Clicked on "+elementName+" Button Succesfully");

		}catch (ElementClickInterceptedException e) {
			JavascriptExecutor jss=(JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on "+elementName+" Button Succesfully");

		}catch (Exception e) {
			System.out.println("Unable to Click on "+elementName+" Button ");
			e.printStackTrace();
		}
	}
	//====================================> myGetText <====================================>

	public static String myGetText(WebElement we, String xpathValue) {
		String elementName= we.getAccessibleName();
		String innerText = null;
		try {
			innerText =we.getText();
			System.out.println("InnerText of the "+elementName +"Found successfully And InnerText is-->"+innerText);
		} catch (StaleElementReferenceException e) {

		}
		return innerText;
	}
	//====================================> mysearchAccount <====================================>


	//====================================> search <====================================>


	public static void search(WebElement we, String searchtext, String search_field) {
		try {
			we.sendKeys(searchtext);
			we.sendKeys(search_field);
			we.click();

			// driver.findElement(By.name("search_text")).sendKeys(searchtext);
			// driver.findElement(By.name("search_field")).sendKeys(search_field);
			// driver.findElement(By.name("search")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	//====================================> minimized <====================================>
	public static void minimized() {
		driver.manage().window().minimize();
		System.out.println("Maximize window successfully");
	}


	//====================================> maximizeWindow <====================================>
	public static void maximizeWindow() {
		driver.manage().window().maximize();
		System.out.println("Maximize window successfully");
	}

	//====================================> acceptPopUpAlert <====================================>

	public static void acceptPopUpAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("click perform on accept button of pop-up alert successfully ");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//====================================> acceptPopUpAlert <====================================>

	public static void dismissPopUpAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("click perform on dismiss button of pop-up alert successfully ");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//====================================> acceptPopUpAlert <====================================>

	public static String getTextPopUpAlert() {
		String popUpMassage = null;
		try {
			popUpMassage = driver.switchTo().alert().getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return popUpMassage;
	}

	//====================================> acceptPopUpAlert <====================================>

	public static void sendkeysPopUpAlert(String sendData) {

		try {
			driver.switchTo().alert().sendKeys(sendData);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//====================================>  myclose <=====================================>

	public static void myclose() throws Exception {
		try {
			driver.close();
			System.out.println("close worked successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("close didn't worked successfully");
			throw e;
		}

	}


	//====================================>  myquite <=====================================>

	public static void myquite() throws Exception {
		try {
			driver.quit();
			System.out.println("myquite worked successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("myquite didn't worked successfully");

			throw e;
		}

	}

	//===============================>  Actions Class Method <==============================>
	//=====================================> mouseOver <====================================>

	public static void mouseOver(WebElement we) {
		Actions actionsObj=new Actions(driver);
       String elementName= we.getAccessibleName();
		actionsObj.moveToElement(we).build().perform();
		System.out.println(elementName+"mouseOver method is succssefully");
	}
	//=====================================> mouseClick <====================================>

	public static void mouseClick(WebElement we) {
		Actions actionsObj=new Actions(driver);
		String elementName= we.getAccessibleName();
		actionsObj.click(we).build().perform();
		System.out.println(elementName+"mouseClick method is succssefully");
		
	}	

	// <==============================> mouseDoubleclick <=========================>

	public void mouseDoubleClick(WebElement we) throws Exception {
		Actions obj=new Actions(driver);
		String elementName =we.getAccessibleName();
		try {
			obj.doubleClick().build().perform();
			System.out.println(elementName+"doubleclick method is succssefully");
		}catch (Exception e) {

			throw e;
		}
	}



	// <================================> mouseDragAndDropByClickAndHold <======================================>

	public static void mouseDragAndDropByClickAndHold(WebElement source, WebElement target) {
		String sourceElementName= source.getAccessibleName();
		String targetElementName= target.getAccessibleName();
		Actions actionsObject = new Actions(driver);
		
		try {
			actionsObject.clickAndHold(source).moveToElement(target).release().build().perform();
			System.out.println(
					"Drag " + sourceElementName + " and Drop " + targetElementName + " is performed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <================================> mouseDragAndDrop <======================================>

	public static void mouseDragAndDrop(WebElement source, WebElement target) {

		Actions actionsObject = new Actions(driver);
		String sourceElementName= source.getAccessibleName();
		String targetElementName= target.getAccessibleName();
		try {
			actionsObject.dragAndDrop(source, target).build().perform();
			System.out.println(
					"Drag " + sourceElementName + " and Drop " + targetElementName + " is performed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <================================> mouseRightClick <======================================>

	public static void mouseRightClick(WebElement we) {
		String elementName= we.getAccessibleName();
		Actions acobj = new Actions(driver);
		try {
			acobj.contextClick().build().perform();
			System.out.println("Passed ! Right click is performed on " + elementName + " ");

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var event = new MouseEvent('contextmenu', {" + "  bubbles: true," + "  cancelable: false,"
					+ "  view: window" + "});" + "arguments[0].dispatchEvent(event);";
			js.executeScript(script, elementName);
			System.out.println("Passed ! Right click is performed on " + elementName + " using the javasript");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var event = new MouseEvent('contextmenu', {" + "  bubbles: true," + "  cancelable: false,"
					+ "  view: window" + "});" + "arguments[0].dispatchEvent(event);";
			js.executeScript(script, elementName);
			System.out.println("Passed ! Right click is performed on " + elementName + " using the javasript");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed ! Right click is not performed on " + elementName + " ");

		}

	}

	//=====================================> myimplicitlyWait <=====================================>

	public static void myimplicitlyWait(int timeouts) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
	}



	//=====================================> verifyText <=====================================>

	public static void verifyText(String actualText, String expectedText) {

		if(actualText.equalsIgnoreCase(expectedText)==true) {
			System.out.println(" Validation is Passed. Actual-"+actualText+", Expected-"+expectedText);
		}else {
			System.out.println(" Validation is Failed. Actual-"+actualText+", Expected-"+expectedText);

		}

	}

	public static void verifyNumber(int actualNumber, int expectedNumber) {

		if(actualNumber==expectedNumber) {
			System.out.println(" Passed.expected = "+expectedNumber+", Actual = "+actualNumber);
		}else {
			System.out.println(" Failed.expected = "+expectedNumber+", Actual = "+actualNumber);

		}
	}

	//========================================> Select Class <=================================>
	//======================================> mySelectByIndex <================================>

	public static Select mySelectByIndex (WebElement we,int index ) {
		String elementName=we.getAccessibleName();
		Select sel= new Select(we);
		if(we.isDisplayed() && we.isEnabled()) {
			System.out.println("vrify the isDisplayed and isEnabled successfully ");
			try {
				sel.selectByIndex(index);
				System.out.println(elementName+" is Selected Option and Passed");
			}catch (ArrayIndexOutOfBoundsException e) {
				sel.selectByIndex(index);
				System.out.println(elementName+" is Selected Option and Passed");
			}catch (Exception e) {
				e.printStackTrace();	
			}
		}else {
			System.out.println(" vrify the isDisplayed and isEnabled not successfully");

		}
		return sel;

	}
	//======================================> mySelectByValue <==================================>

	public static void mySelectByValue (WebElement we, String value ) {
		String elementName= we.getAccessibleName();;
		Select sel= new Select(we);
		if(we.isDisplayed() && we.isEnabled()) {
			System.out.println("vrify the isDisplayed and isEnabled successfully ");
			try {
				sel.selectByValue(value);
				System.out.println(elementName+"is Selected Option and Passed");
			}catch (InvalidArgumentException e) {
				sel.selectByValue(value);
				System.out.println(elementName+"is Selected Option and Passed");
			}catch (Exception e) {
				e.printStackTrace();	
			}
		}else {
			System.out.println(" vrify the isDisplayed and isEnabled not successfully");

		}


	}
	//=====================================> mySelectByVisibleText <==============================>

	public static void mySelectByVisibleText (WebElement we, String textValue ) {
		String elementName= we.getAccessibleName();;
		if(we.isDisplayed() && we.isEnabled()) {
			System.out.println("vrify the isDisplayed and isEnabled successfully ");
			try {
				Select sel= new Select(we);
				sel.selectByVisibleText(textValue);
				System.out.println(elementName+"is Dropdown Handle in Selected Option Passed");
			}catch (InvalidSelectorException e) {
				Select sel= new Select(we);
				sel.selectByValue(textValue);
				System.out.println(elementName+"is Dropdown Handle Selected Option Passed");
			}catch (StaleElementReferenceException e) {
				System.out.println(elementName+"is Dropdown Handle Selected Option Passed");
			}
		}else {
			System.out.println(" vrify the isDisplayed and isEnabled not successfully");

		}

	}

	public static void switchToMainWindow() {
		driver.switchTo().window(mainWindowHandleValue);
	}

	// <===================================> switchToWindowByTitle <=============================>
	

	public static void switchToWindowByTitle(String expTitle) {
		try {
			Set<String> handlesVale=driver.getWindowHandles();
			for(String myHandleValue :handlesVale) {
				driver.switchTo().window(myHandleValue);
				String title=driver.getTitle();
				if(title.equalsIgnoreCase(expTitle)) {
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	// <==================================> switchToWindowByUrl <==================================>

	public static void switchToWindowByUrl( String expUrl) {
		try {
			Set<String> handlesVale=driver.getWindowHandles();
			for(String myHandleValue :handlesVale) {
				driver.switchTo().window(myHandleValue);
				String url=driver.getCurrentUrl();
				if(url.contains(expUrl)) {
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <===================================> myTakeSnapshot <=======================================>

	public static void myTakeSnapshot(String screenshotPath) throws IOException {
		try {
			TakesScreenshot tss=(TakesScreenshot)driver;
			File from=tss.getScreenshotAs(OutputType.FILE);           // File png , bmp , jpeg
			File to=new File(screenshotPath);        // checked exception , compile time exception
			Files.copy((File) from, to);   // uncheked , run time exception
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <===================================> takesScreenshotofparticularElement <=======================================>

	public static void takesScreenshotofparticularElement(WebElement we , String folderlocation) throws Exception {
         String elementName=we.getAccessibleName();
		try {
			File soucrce = we.getScreenshotAs(OutputType.FILE);
			Files.copy(soucrce, new File(folderlocation));
			System.out.println("Screenshot has been taken of " + elementName + " successfully");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screenshot has been taken of " + elementName + " successfully");
			throw e;
		}

	}


	// <===================================> getHeight_Width <======================================>

	public static void getHeight_Width(WebElement we) {

		String  wee=we.getAccessibleName();
		int height=0;
		org.openqa.selenium.Dimension wt= we.getSize();

		System.out.println(wt.height+"  "+wt.width);
		System.out.println("UserName Heigth Width is Passed");

	}



	// <===================================> showDisplayedByValue <======================================>

	public static void showDisplayedByValue (WebElement we ) throws Exception {
		String elementName= we.getAccessibleName();;
		try {
			we.isDisplayed();
			System.out.println(elementName+" vrify the show UI page isDisplayed successfully");
		}catch (Exception e) {
			throw e;

		}
	}

	// <===================================> showEnabledByValue <======================================>

	public static void showEnabledByValue (WebElement we ) {
		String elementName= we.getAccessibleName();;
		try {
			we.isEnabled();
			System.out.println(elementName+" vrify the show UI page isEnabled successfully");
		}catch (Exception e) {

		}	
	}

	// <===================================> showSelectededByValue <======================================>

	public static void showSelectedByValue (WebElement we ) throws Exception {
		String elementName= we.getAccessibleName();;
		try {
			we.isSelected();
			System.out.println(elementName+" vrify the show UI page isSelected successfully");
		}catch (Exception e) {
			throw e;	
		}

	}

	// <=====================================>  Frame_Handel  <========================================>
	// <===================================> switchToFrameIndex <======================================>

	public static void switchToFrameIndex (WebElement weIndexValue ) {
		String elementName= weIndexValue.getAccessibleName();
		try {
			driver.switchTo().frame(weIndexValue);
			System.out.println(elementName+" vrify the show UI page isSelected successfully");
		}catch (NoSuchElementException e) {
			throw e;	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <===================================> switchToFrameString <======================================>

	public static void switchToFrameString (WebElement weFrameValue ) {
		String elementName= weFrameValue.getAccessibleName();
		try {
			driver.switchTo().frame(weFrameValue);
			System.out.println(elementName+" vrify the go for frameElement  successfully");
		}catch (NoSuchElementException e) {
			throw e;	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <===================================> switchToFrameElement <======================================>

	public static void switchToFrameElement (WebElement weFrame ) {
		String elementName= weFrame.getAccessibleName();
		try {
			driver.switchTo().frame(weFrame);
			System.out.println(elementName+" vrify the go for weFrameElement successfully");
		}catch (NoSuchFrameException e) {
			driver.switchTo().frame(weFrame);
			System.out.println(elementName+" vrify the go for weFrameElement successfully");
		}catch (StaleElementReferenceException e) {
			driver.switchTo().frame(weFrame);
			System.out.println(elementName+" vrify the go for weFrameElement successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// <===================================> switchToParentFrame <======================================>

	public static void switchToParentFrame (WebElement weParentFrame ) {
		String elementName= weParentFrame.getAccessibleName();
		try {
			driver.switchTo().parentFrame();
			System.out.println(elementName+" vrify the go for parentFrame successfully");
		}catch (NoSuchElementException e) {
			throw e;	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// <===================================> switchToDefaultContent <======================================>

	public static void switchToDefaultContent (WebElement we ) {
		String elementName= we.getAccessibleName();
		try {
			driver.switchTo().defaultContent();
			System.out.println(elementName+" vrify the go for DefaultContent successfully");
		}catch (NoSuchElementException e) {
			throw e;	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//=======================================> getOptionsCount <===================================>

	public static void getOptionsCount(WebElement we) {
		String elementName= we.getAccessibleName();
		Select seObj=new Select(we);
		List<WebElement> listSelectBox=seObj.getOptions();
		int countOption=listSelectBox.size();
		System.out.println("your select Box in"+elementName+"Options are "+countOption);

	}

	//======================================> getFirstSelectedOption <===============================>

	public static String getFirstSelectedOption(WebElement we) {  
        String elementName= we.getAccessibleName();
		Select seObj=new Select(we);
		WebElement weSelectOption=null;
		String selectAllOption=null;
		try {
			weSelectOption=seObj.getFirstSelectedOption();
			selectAllOption=weSelectOption.getText();
			System.out.println("your select Box is Select with"+elementName);
		}catch (StaleElementReferenceException e) {
			weSelectOption=seObj.getFirstSelectedOption();
			selectAllOption=weSelectOption.getText();
			System.out.println("your select Box is Select Frist Option with"+elementName);
		}
		return selectAllOption;
	}



	//======================================> getSelectOfAllOption <============================>

	public static ArrayList<String> getSelectOfAllOption(WebElement we) {
		String elementName= we.getAccessibleName();
		Select seObj=new Select(we);
		List<WebElement> listOfAllOption=seObj.getAllSelectedOptions();
		ArrayList<String> listOptionText=new ArrayList<String>();
		for(int i=0; i<listOfAllOption.size(); i++) {
			WebElement weOption=listOfAllOption.get(i);
			String optionText=weOption.getText();
			System.out.println(optionText);
		}
		return listOptionText;
	}


	// <===================================> mySelectByTextOptions <======================================>   ////

	public static void mySelectByTextOptions(WebElement weSlcOption) {
		String elementName= weSlcOption.getAccessibleName();
		Select select = new Select(weSlcOption);
		List<WebElement> listSelectBox = select.getOptions();
		for (int i = 0; i < listSelectBox.size(); i++) {
			WebElement weOption = listSelectBox.get(i);
			String optionText = weOption.getText();
			if (elementName.contains(optionText)) {
				select.selectByIndex(i);
				System.out.println(elementName + " space Option select successfully");
			}
		}
	}

	//======================================> getAllOptionMethod <===============================>

	// <===================================> checkAllCheckBoxes <======================================>  //////

//	public static void checkAllCheckBoxes(WebElement we) {
//		List<WebElement> listCheckBoxes = myFindElements(xpathValue, elementsName);
//		WebElement weCheckBox = null;
//		for (int i = 0; i < listCheckBoxes.size(); i++) {
//			try {
//				weCheckBox = listCheckBoxes.get(i);
//				weCheckBox.click();
//
//			} catch (StaleElementReferenceException e) {
//				listCheckBoxes = myFindElements(xpathValue, elementsName);
//				weCheckBox = listCheckBoxes.get(i);
//				weCheckBox.click();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//		System.out.println("your all check Boxes " + elementsName + " is successfully check");
//
//	}
//
//	// <===================================> unCheckAllCheckBoxes <======================================>  /////
//
//	public static void unCheckAllCheckBoxes(WebElement we) {
//		List<WebElement> listCheckBoxes = myFindElements(xpathValue, elementsName);
//		WebElement weCheckBox = null;
//		for (int i = 0; i < listCheckBoxes.size(); i++) {
//			try {
//				weCheckBox = listCheckBoxes.get(i);
//				weCheckBox.click();
//
//			} catch (StaleElementReferenceException e) {
//				listCheckBoxes = myFindElements(xpathValue, elementsName);
//				weCheckBox = listCheckBoxes.get(i);
//				weCheckBox.click();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//		System.out.println("your all check Boxes unCheck" + elementsName + " is successfully");
//
//	}
//
//	// <===================================> getTableDataRowCount <======================================> /////
//
//	public static int getTableDataRowCount(WebElement we) {
//		List<WebElement> listTableRow = myFindElements(xpathValue, elementsName);
//
//		int countTableRow = listTableRow.size();
//		System.out.println(elementsName + " found succssfully");
//		return countTableRow;
//	}
//
//
//	// <===================================> verifyAllCheckSelected <======================================>   ///
//
//	public static void verifyAllCheckSelected(WebElement we) {
//		List<WebElement> listCheckBox = myFindElements(xpathValue, elementName);
//		WebElement weCheckBox = null;
//		boolean statusCheckBox = false;
//		for (int i = 0; i < listCheckBox.size(); i++) {
//			weCheckBox = listCheckBox.get(i);
//			statusCheckBox = weCheckBox.isSelected();
//
//		}
//		if (statusCheckBox == true) {
//			System.out.println("verify " + elementName + " status of all check is selected");
//		} else {
//			System.out.println("verify " + elementName + " status of all check is not selected");
//		}
//
//	}
//
//	// <===================================> getTableColumnInList <======================================> /////
//
//	///  getTableColumnInList("//table[@class='lvt small']");
//	public static ArrayList<String> getTableColumnInList(String tableXpath, String elementName) {
//		List<WebElement> listColumn = myFindElements(tableXpath+"//tr[1]//td", elementName);
//		ArrayList<String> list = new ArrayList<String>();
//		int countColumn = listColumn.size();
//		for (int i = 0; i < countColumn; i++) {
//			WebElement weColumn = listColumn.get(i);
//			String column = weColumn.getText();
//			list.add(column);
//		}
//		return list;
//	}
//
//	// <===================================> getColumnNumberByColumnName <======================================> ///
//
//	public static int getColumnNumberByColumnName(String tableXpath, String elementName, String columnName) {
//		List<WebElement> listColumn = myFindElements(tableXpath+"//tr[1]//td", elementName);
//		int countColumn = listColumn.size();
//		int count = 0;
//		for (int i = 0; i < countColumn; i++) {
//			WebElement weColumn = listColumn.get(i);
//			String columnText = weColumn.getText();
//
//			if (columnText.equals(columnName)) {
//				count=i;
//				break;
//			}
//		}
//		return count;
//	}
//
//	// <===================================> getColumnDataByColumnName <======================================>
//
//	//		public static int getColumnNumberByColumnName(String tableXpath, String tableName, String columnName){
//	//			int columnNumber=-1;
//	//			List<WebElement> weListColumns=driver.findElements(By.xpath(tableXpath+"//tr[1]//td"));
//	//			for(int i=0; i<=weListColumns.size()-1;i++){
//	//				WebElement weCOlumn = weListColumns.get(i);
//	//				String columnText=weCOlumn.getText();
//	//				if(columnText.equalsIgnoreCase(columnName)){
//	//					return i+1;
//	//	
//	//				}
//	//			}
//	//			return columnNumber;
//	//	
//	//	}
//
//
//
//	// <===================================> getRowDataListByRowNumber <======================================>  /////
//	//   getRowDataListByRowNumber["//table[@class='lvt small']", "AccountTable", 5]
//	public static List<String> getRowDataListByRowNumber(WebElement we,int rowNumber) {
//		rowNumber=rowNumber+1;
//		List<WebElement> listRowData=myFindElements(xpathValue+"//tr["+rowNumber+"]//td//following-sibling::td", elementName);
//		List<String> rowText= new ArrayList<String>();
//		for(int i=0; i<listRowData.size(); i++) {
//			WebElement weRow=listRowData.get(i);
//			rowText.add(weRow.getText());
//		}
//		return rowText;
//
//	}
//
//	// <===================================> getColumnDataByColumnNumber <======================================>   ////
//
//
//	public static List<String> getColumnDataByColumnNumber(WebElement we,int columnNumber) {
//		List<WebElement> listColumnData=myFindElements(we+"//tr//td["+columnNumber+"]", elementName);
//		List<String> columnText= new ArrayList<String>();
//		for(int i=0; i<listColumnData.size(); i++) {
//			WebElement weColumn=listColumnData.get(i);
//			String columnData=weColumn.getText();
//			columnText.add(columnData);
//		}
//
//		return columnText;
//	}
//
//	// <===================================> getColumnDataByColumnName <======================================>  /////
//
//	public static List<String> getColumnDataByColumnName(WebElement we,String columnName) {
//		int number=  getColumnNumberByColumnName(xpathValue, elementName, columnName);
//		List<String> columnText=getColumnDataByColumnNumber(xpathValue, elementName, number);
//
//		return columnText;
//
//	}
//
//
//	//	<================================> getRowNumberbyRowID <===========================================> ////
//
//	public static int getRowNumberbyRowID(WebElement we,String leadNumber, String uniqueDataColumnName) {
//		String elementName= we.getAccessibleName();
//		int rowNumber=-1;
//		List<String> listCOlumnData=getColumnDataByColumnName(we, elementName, uniqueDataColumnName);
//		for(int i=0; i<=listCOlumnData.size()-1;i++) {
//			String columnValue=listCOlumnData.get(i);
//			if(columnValue.equalsIgnoreCase(leadNumber)) {
//				rowNumber=i;
//				break;
//			}
//		}
//		return rowNumber;
//	}

	public static void getRowDataListByRowID() {






	}






	//<===============================> JavaScript <===============================>

	public static void jsClick(WebElement we) {
		String wee= we.getAccessibleName();		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", wee);
	}

	public static void jsSendkeys(WebElement we, String inputValue) {
	String wee=we.getAccessibleName();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='" + inputValue + "'", wee);
	}

	public static void jsScrollVerticle(int verticleSize) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + verticleSize + ",0)");
	}

	public static void jsScrollHorizontal(int HorizontalSize) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + HorizontalSize + ")");
	}

	public static void jsScrollLength(int x , int y) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + x,y + ")");
	}

	public static void jsScrollElement(WebElement we) {
		String elementName= we.getAccessibleName();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView", we);
	}

	public static void jsScrollTopToBottom() {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public static void myclear(WebElement we) throws Exception {
		String elementName= we.getAccessibleName();
		try {
			
			// we.clear();
			// System.out.println(elementname+"'s element is clear successfully");
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value = '';", we);
			System.out.println(elementName + "'s element is cleared successfully");
		} catch (StaleElementReferenceException e) {
			we.clear();
			System.out.println(elementName + "'s element is cleared successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].value = '';", we);
			System.out.println(elementName + "'s element is cleared successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(elementName + "'s element is not cleared successfully");
			throw e;
		}

	}
	


}
