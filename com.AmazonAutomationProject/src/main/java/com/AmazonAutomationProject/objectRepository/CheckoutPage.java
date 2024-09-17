package com.AmazonAutomationProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomationProject.genericUtility.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    // Locators for checkout page elements
    @FindBy(css = ".a-button-input[name='placeYourOrder1']")  // Place order button
    WebElement placeOrderButton;

    @FindBy(css = ".payment-method-selector")  // Payment method section
    WebElement paymentMethodSection;

    // Constructor initializes the elements on the checkout page
    public CheckoutPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to place the order
    public void placeOrder() throws Exception {
        util.waitForElementToBeClickable(driver, placeOrderButton, 10);
        Thread.sleep(3000);
        placeOrderButton.click();
    }

    // Method to verify that the payment method section is displayed
    public boolean isPaymentMethodSectionDisplayed() {
        return paymentMethodSection.isDisplayed();
    }
}


