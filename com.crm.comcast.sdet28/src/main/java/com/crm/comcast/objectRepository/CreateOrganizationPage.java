package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement organizationTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="emailoptout")
	private WebElement emailoptOutCheckBox;
	
	@FindBy(name="rating")
	private WebElement Rating;
	
	@FindBy(name="assigned_group_id")
	private WebElement group;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioButton;
	
	@FindBy(name="assigned_user_id")
	private WebElement user;
	//getters method
	
	public WebElement getUser() {
		return user;
	}

	public WebElement getUserRadioButton() {
		return userRadioButton;
	}

	public WebElement getGroup() {
		return group;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getRating() {
		return Rating;
	}

	public WebElement getEmailoptOutCheckBox() {
		return emailoptOutCheckBox;
	}
	
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	//Business logics
	/**
	 * This method will create an organization
	 * @param orgName
	 */
	public void createOrganization(String orgName) {
		organizationTextField.sendKeys(orgName);
	}
	
	/**
	 * This method will click on save button
	 */
	public void clickOnSave() {
		saveButton.click();
		
	}
	/**
	 * This method will click on email opt out check box
	 */
	public void clickemailoptOutCheckBox() {
		emailoptOutCheckBox.click();
	}
	
	/**
	 * This method will click on Rating drop down
	 */
	public void clickOnRating() {
		Rating.click();
	}
	/**
	 * This method will click on group 
	 */
	public void clickOnGroup() {
		group.click();
	}
	/**
	 * This method will click on group radio button
	 * 	 */
	public void clickGroupButton() {
		groupRadioButton.click();
	}
	/**
	 * this method will click on user radio button
	 */
	public void clickUserRadioButton() {
		userRadioButton.click();
	}
	/**
	 * this method will click on user
	 */
	public void clickUser() {
		user.click();
	}
}
