package OrganizationTestScripts;

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
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

public class CheckEmailOptoutIsEnabledOrNotTest extends BaseClass {
		@Test//(groups = {"smokeTest"})
		public void emailOptoutEnabledTest() throws Throwable {
	
		//generate random number
		int randomNumber = jUtil.getrandomNumber();
		//get the data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData(IPathConstants.sheet_name, 3,2 );
		ExpectedorganizationName=ExpectedorganizationName+randomNumber;
	
		//create organization
		HomePage homepage = new HomePage(HomePage);
		homepage.clickOrganizationLink();
		
		OrganizationPage orgpage = new OrganizationPage(driver);
		orgpage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		createOrg.createOrganization(ExpectedorganizationName);
		createOrg.clickemailoptOutCheckBox();
		createOrg.clickOnSave();
	    
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualorgName = orgInfoPage.getOrgInformationText();
		
		//organization name verification
		if(actualorgName.contains(ExpectedorganizationName)) {
			System.out.println("Organization is created");
		}
		else {
			System.out.println("Organization is not created");		
		}

	}

}
