package OrganizationTestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
import com.crm.comcast.objectRepository.OrganizationPage;

	public class CreateOrganizationwithRatingTest extends BaseClass {
		@Test(groups = {"smokeTest","regressionTest"})
		public void OrganizationWithRatingTest() throws Throwable {
		
	    //generate random number
	    int randomNumber = jUtil.getrandomNumber();
	    
	    //get data from excel sheet
	    String expectedOrganizationName = eUtil.getStringCellData(IPathConstants.sheet_name, 3, 2);
	    expectedOrganizationName=expectedOrganizationName+randomNumber;
	    
		//create organization
		HomePage homepage = new HomePage(driver);
		homepage.clickOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(expectedOrganizationName);
		wUtil.selectOption(createOrgPage.getRating(), 4);
		createOrgPage.clickOnSave();
	}
}
