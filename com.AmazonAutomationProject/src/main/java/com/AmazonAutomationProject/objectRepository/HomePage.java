package com.AmazonAutomationProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomationProject.genericUtility.BaseClass;

public class HomePage extends BasePage{
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	 public SearchResultsPage searchForProduct(String productName) throws Exception {
	        util.waitForElementToBeClickable(driver, searchBox, 10);
	        searchBox.sendKeys(productName);
	        Thread.sleep(3000);
	        searchButton.click();
	        Thread.sleep(3000);
	        return new SearchResultsPage(driver);  // After search, return SearchResultsPage
	    }
	 
}
