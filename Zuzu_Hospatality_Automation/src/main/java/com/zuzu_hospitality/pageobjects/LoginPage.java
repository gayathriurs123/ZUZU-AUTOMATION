package com.zuzu_hospitality.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
	}

	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement usernameField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value = 'Login']")
	private WebElement loginButton;
	
	public void enterUserName(String usernameText) {
		
		usernameField.sendKeys(usernameText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
public LoginPage selectLoginOption() {
		
	loginButton.click();
		
		return new LoginPage(driver);
}


@FindBy(id="page-title")
private WebElement TitleHotel;

public boolean verifyLoginStatusOfUser() {
	
	boolean loginStatus;
	
	try {
		loginStatus = TitleHotel.isDisplayed();
	}catch(Throwable e) {
		loginStatus = false;
	}
	
	return loginStatus;
	
}


}


