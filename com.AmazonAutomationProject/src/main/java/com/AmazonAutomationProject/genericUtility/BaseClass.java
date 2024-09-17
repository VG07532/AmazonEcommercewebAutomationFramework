package com.AmazonAutomationProject.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	public SeleniumUtility util;
	
	@BeforeMethod
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		util=new SeleniumUtility();
		util.maximizeWindow(driver);
		util.implicitWait(driver, 10);
		driver.get("https://www.amazon.in/");
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
