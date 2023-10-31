package com.zuzu_hospitality.base;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
    import java.util.concurrent.TimeUnit;

    import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Baset {
		
		WebDriver driver;
		
		public Properties prop;
		
		public WebDriver openBrowser(String browserName) throws IOException, InterruptedException {
			
			
			prop = new Properties();
			File file = new File ("src\\test\\resources\\data.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
	
			if(browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions opt =new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");	
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(opt);
				
			}else if(browserName.equalsIgnoreCase("firefox")) {	
				FirefoxOptions opt =new FirefoxOptions();
				opt.addArguments("--remote-allow-origins=*");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(opt);
				
			}else if(browserName.equalsIgnoreCase("edge")) {	
				
				EdgeOptions opt =new EdgeOptions();
				opt.addArguments("--remote-allow-origins=*");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(opt);				
			}
			
			driver.manage().window().maximize();
			Thread.sleep(5000);
			driver.get(prop.getProperty("url"));
			
			return driver;
			
		}

		


	}



