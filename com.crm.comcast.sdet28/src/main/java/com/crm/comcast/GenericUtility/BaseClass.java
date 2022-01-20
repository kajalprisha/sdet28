package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * This is the Base class which configuration annotations annotations
 * @author Admin
 *
 */

public class BaseClass {
	// Object creation statement
	public WebDriver driver;
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil=new JavaUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	@BeforeSuite
	public void configBs() {
		//connection to db
		System.out.println("=====Connect to DB=======");
	}
	@BeforeClass (groups={"smokeTest","regressionTest"})
	public void configBc() throws Throwable {
		//get the data from property file
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		//Launching the Browser
		if(browser.equals("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Browser not available");
		}
		
		driver.manage().window().maximize();
		wUtil.WaitForPageLoad(driver);
		driver.get(url);
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	
	public void configBm() throws Throwable {
		//get the data from property file
		String userName = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		//Login to application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
	}
	@AfterMethod
	
	public void configAm() {
		//logout from application
		HomePage homepage = new HomePage(driver);
		homepage.logout();
	}
	@AfterClass
	public void configAc() {
		//closing or quitting the browser
		driver.quit();
	}
	@AfterSuite
	public void configAs() {
		//closing the database connection
		System.out.println("====close database connection====");
	}
}
