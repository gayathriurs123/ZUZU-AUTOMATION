package com.zuzu_hospitality.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zuzu_hospitality.base.Baset;
import com.zuzu_hospitality.pageobjects.HomePage;
import com.zuzu_hospitality.pageobjects.LoginPage;
import com.zuzu_hospitality.pageobjects.Loginp;
import com.zuzu_hospitality.utility.DataUtil;
import com.zuzu_hospitality.utility.MyXLSReader;





public class Login extends Baset {
	
	WebDriver driver;
	MyXLSReader excelReader;
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {	
			driver.quit();
		}
		
	}
	
	@Test(dataProvider="dataSupplier")
public void testLogin(HashMap<String,String> hMap) throws IOException, InterruptedException {
		
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}
		
		driver = openBrowser(hMap.get("Browser"));
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserName(hMap.get("Username"));
        loginpage.enterPassword(hMap.get("Password"));
        loginpage.selectLoginOption();
        
		String expectedResult = hMap.get("ExpectedResult");
		
		boolean expectedConvertedResult = false;
		
		if(expectedResult.equalsIgnoreCase("Failure")) {
			
			expectedConvertedResult = false;
			
		}else if(expectedResult.equalsIgnoreCase("Success")){
			
			expectedConvertedResult = true;
		}
		driver.getTitle().contains("Hotels");
		Assert.assertEquals(loginpage.verifyLoginStatusOfUser(), expectedConvertedResult);
	
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\zuzutestdata.xlsx");
			obj = DataUtil.getTestData(excelReader, "LoginTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}
