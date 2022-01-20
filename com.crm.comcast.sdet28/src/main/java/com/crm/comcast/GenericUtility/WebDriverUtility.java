package com.crm.comcast.GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void WaitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method will wait till element is visible
	 * @param driver
	 * @param element
	 */
	public void WaitForVisibilityElement(WebDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
				
		
	}
	/**
	 * This method will wait till element is clickable
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeClick(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	/**
	 * this method will wait for element and do click operation
	 * @param element
	 * @throws Throwable 
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count=0;
		while(count<50) {
			try {
			
			element.click();
			}
		catch(Exception e ) {
				Thread.sleep(1000);
				count++;
			}
		}
		}
		/**
		 * This method will select the element based on Index
		 * @param ele
		 * @param index
		 */
		public void selectOption(WebElement ele, int index) {
			Select select = new Select(ele);
			select.selectByIndex(index);
			
		}
		/**
		 * This method will select the element based on value
		 * @param element1
		 * @param value
		 */
		public void selectOption(WebElement element,String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}
		/**
		 * This method will select the element based on the text
		 * @param text
		 * @param element
		 */
		public void selectOption(String text,WebElement element) {
			Select select = new Select(element);
			select.selectByValue(text);
				
		}
		/**
		 * this method will verify whether expected option is present in dropdown list or not
		 * @param element
		 * @param ExpectedOptions
		 * @return
		 */
		public WebElement VerifyTheDropDownList(WebElement element,String ExpectedOptions) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for(WebElement ele:options) {
				if(ele.equals(ExpectedOptions)) {
					System.out.println("value is present in dropdown");
					return ele;
				}else {
					System.out.println("value is not present in dropdown");
					return ele;
				}
				
			}
			return null;
			
		}
		/**
		 * This method will performs mouse hovering action
		 * @param driver
		 * @param element
		 */
		public void mouseOver(WebDriver driver,WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
		/**
		 * This method will perform right click action
		 * @param driver
		 * @param element
		 */
		
		public void rightClick(WebDriver driver,WebElement element) {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
			
		}
		/**
		 * Used to perform javascript click on webElement
		 * @param driver
		 * @param element
		 */
		public void jsClick(WebDriver driver,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0]", element);
			
		}
		/**
		 * method is used to send value using javascript Executor
		 * @param driver
		 * @param ValueToEnter
		 * @param element
		 */
		public void EnterDataUsingJs(WebDriver driver,String ValueToEnter,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='"+ValueToEnter+"'", element);
		}
		/**
		 * This method will switch to different window using partial title
		 * @param driver
		 * @param partialWindowTitle
		 */
		public void switchWindow(WebDriver driver,String partialWindowTitle) {
			Set<String> WinIds = driver.getWindowHandles();
			Iterator<String> it = WinIds.iterator();
			while(it.hasNext()) {
				String WinId = it.next();
				String title = driver.switchTo().window(WinId).getTitle();
				if(title.contains(partialWindowTitle)) {
					break;
				}
			}
		}
		/**
		 * method is used to take screenshot in case of failure
		 * @param driver
		 * @param testCasename
		 * @return
		 */
		public String screenShot(WebDriver driver,String testCasename) {
			JavaUtility jUtil = new JavaUtility();
			 String filePath = "./errorshot"+testCasename+jUtil.systemDateandTime();
			 TakesScreenshot ts=(TakesScreenshot) driver;
			 File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(filePath);
			source.renameTo(destination);
			return filePath;
		}
		/**
		 * method will switch the frames based on index passed
		 * @param driver
		 * @param index
		 */
		public void switchFrames(WebDriver driver,int index) {
			driver.switchTo().frame(index);
			}
		/**
		 * method will switch the frames based on name or ID passed
		 * @param driver
		 * @param nameOrId
		 */
		
		public void switchFrames(WebDriver driver,String nameOrId) {
			driver.switchTo().frame(nameOrId);
			}
		/**
		 * method will switch the frames based on Webelement passed
		 * @param driver
		 * @param element
		 */
		public void switchFrames(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
		}
		/**
		 * method will accept the alert
		 * @param driver
		 */
		public void aceeptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		/**
		 * this method will click on dissmiss button in alert popup
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
}
