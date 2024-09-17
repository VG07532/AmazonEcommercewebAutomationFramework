package com.AmazonAutomationProject.objectRepository;

import org.openqa.selenium.WebDriver;

import com.AmazonAutomationProject.genericUtility.SeleniumUtility;

public class BasePage {

    protected WebDriver driver;
    protected SeleniumUtility util; // Utility instance for reusing utility methods

    public BasePage(WebDriver driver) {
        this.driver = driver;
        util = new SeleniumUtility(); // Utility class is initialized once and available for all page objects
    }
    
}
