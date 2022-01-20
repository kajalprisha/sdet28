package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	private WebDriver driver;

		//element initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		//declaration of elements
		@FindBy(linkText="Organizations")
		private WebElement organizationLink;
		
		@FindBy(linkText="Contacts")
		private WebElement contactLink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement logoutImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signOutLink;

		//getters method
		public WebElement getOrganizationLink() {
			return organizationLink;
		}

		public WebElement getContactLink() {
			return contactLink;
		}

		public WebElement getLogoutImg() {
			return logoutImg;
		}

		public WebElement getSignOutLink() {
			return signOutLink;
		}
		//Business logics
		/**
		 * This method will click on organization link
		 */
		
		public void clickOrganizationLink() {
			organizationLink.click();
		}
		/**
		 * This method will perform logout action
		 */
		public void logout() {
		mouseOver(driver,logoutImg);
		signOutLink.click();
		}
		/**
		 * This method will click on contact link
		 */
		
		public void clickContactLink() {
			contactLink.click();
			
		}
		/**
		 * This method will click on sign out link
		 */
	/*	public void clickSignOutLink() {
			signOutLink.click();
			
		}
		
		*/
}
