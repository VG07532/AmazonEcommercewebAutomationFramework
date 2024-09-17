package com.AmazonAutomationProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifiedCartPage extends BasePage {

	public ModifiedCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteProductInCart;
	
	@FindBy(xpath="//input[@value='Save for later']")
	WebElement saveForLaterInCart;
	
	@FindBy(name = "proceedToRetailCheckout") // Proceed to checkout button
	WebElement proceedToCheckoutButton;
	
	public CheckoutPage clickOnProceedToCheckoutButton()
	{
		proceedToCheckoutButton.click();
		return new CheckoutPage(driver);
		
	}

}
