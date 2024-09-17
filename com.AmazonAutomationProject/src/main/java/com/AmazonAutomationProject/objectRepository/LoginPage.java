package com.AmazonAutomationProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomationProject.genericUtility.BaseClass;

public class LoginPage extends BasePage {

    // Locators for login page elements
    @FindBy(id = "ap_email")  // Email or phone number field
    WebElement emailField;

    @FindBy(id = "continue")  // Continue button
    WebElement continueButton;

    @FindBy(id = "ap_password")  // Password field
    WebElement passwordField;

    @FindBy(id = "signInSubmit")  // Sign-in button
    WebElement signInButton;

    // Constructor initializes the elements on the login page
    public LoginPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to login by providing email/phone and password
    public void login(String email, String password) {
        //TestUtil.waitForElementVisible(driver, emailField, 10);
        emailField.sendKeys(email);
        continueButton.click();
        //TestUtil.waitForElementVisible(driver, passwordField, 10);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}

