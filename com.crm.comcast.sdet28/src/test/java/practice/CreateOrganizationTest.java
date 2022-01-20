package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrg() throws Throwable {
//	public static void main(String[] args) throws Throwable {
		
		//creating object for utilities
		//FileUtility fUtil = new FileUtility();
		ExcelUtility eUtil = new ExcelUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		// get the data from property file
		/*String browserName = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");*/
		/*
		 FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");*/
		
		//generate random number
		int randomNumber = jUtil.getrandomNumber();
		//String organizationName="Wipro"+randomNumber;
		
		//get the data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData("sheet1", 2,2 );
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;
		/*FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");*/
		
		
		//Launching the browser
	/*	WebDriver driver=null;
		if(browserName.equals("chrome")) {

			System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
			driver=new ChromeDriver();
			}
		else if(browserName.equals("firefox")) {
				
				System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);
			
				driver=new FirefoxDriver();
			}else {
				System.out.println("browser is not supported");
			}
		*/
		
	/*	driver.manage().window().maximize();
		wUtil.WaitForPageLoad(driver);
		driver.get(url);*/
		//Login to application
		
	/*	LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);*/
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		
		//Create Organization
		HomePage homepage = new HomePage(driver);
		homepage.clickOrganizationLink();
		/*driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationName1);
		driver.findElement(By.name("button")).click();*/
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(ExpectedorganizationName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();
		
		//Organization name verification
		Assert.assertEquals(actualOrgName, ExpectedorganizationName);
		//String OrganizationName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	/*	if(actualOrgName.contains(ExpectedorganizationName)) {
			System.out.println("Organization Is Created");
		}
		else {
			System.out.println("Organization Is Not Created");
		}*/
      		
		
		//logging out from the application
	//	homepage.logout();
		/*WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
      	Actions action = new Actions(driver);
      	action.moveToElement(profileImg).perform();
      	driver.findElement(By.linkText("Sign Out")).click();*/
		//quit the browser
     // 	driver.quit();
		}

}


