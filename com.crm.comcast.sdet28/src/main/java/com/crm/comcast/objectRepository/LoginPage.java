package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	//element initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	//element identification and declaration
	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passWordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//getters method
	public WebElement getUserTextField() {
		return usernameTextField;
	}

	public WebElement getPassWordTextField() {
		return passWordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * This method will perform application login action
	 * @param username
	 * @param password
	 */
	
	public void loginToApplication(String username,String password) {
		usernameTextField.sendKeys(username);
		passWordTextField.sendKeys(password);
		loginButton.click();
	}

}
