/**
 * 
 */
package com.zuzu_hospitality.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class HomePage {

	WebDriver driver;
	
	public HomePage (WebDriver driver) { 
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
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
