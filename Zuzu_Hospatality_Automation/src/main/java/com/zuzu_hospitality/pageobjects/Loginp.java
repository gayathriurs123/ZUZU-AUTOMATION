package com.zuzu_hospitality.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.zuzu_hospitality.base.Baset;

public class Loginp extends Baset {
	
@FindBy(xpath = "//input[@placeholder='Username']")
WebElement logInUsername;

@FindBy(xpath = "//input[@placeholder='Password']")
WebElement logInPassword;

@FindBy(xpath = "//input[@value = 'Login']")
WebElement logInBtn;

public Loginp() {
	PageFactory.initElements(getDriver(), this);
}

private WebDriver getDriver() {
	// TODO Auto-generated method stub
	return null;
}




}



