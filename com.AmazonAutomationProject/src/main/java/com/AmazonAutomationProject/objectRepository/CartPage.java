package com.AmazonAutomationProject.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AmazonAutomationProject.genericUtility.BaseClass;

public class CartPage extends BasePage {

	// Locators for cart elements
	@FindBy(xpath = "//input[@class='a-button-input']") // Product title in cart
	WebElement cartProductTitle;
	
	//input[@class='a-button-input']

	@FindBy(name = "proceedToRetailCheckout") // Proceed to checkout button
	WebElement proceedToCheckoutButton;

	@FindBy(css = ".sc-action-delete") // Delete/remove product from cart button
	WebElement deleteFromCartButton;
	
	@FindBy(linkText = "Go to Cart")
	WebElement goToCartButton;

	// Constructor initializes the elements on the cart page
	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ModifiedCartPage clickOnGoToCart()
	{
		goToCartButton.click();
		return new ModifiedCartPage(driver);
	}

	// Method to proceed to checkout
	public CheckoutPage proceedToCheckout() throws Exception {
		util.waitForElementToBeClickable(driver, proceedToCheckoutButton, 10);
		Thread.sleep(5000);
		proceedToCheckoutButton.click();
		Thread.sleep(3000);
		return new CheckoutPage(driver); // Navigate to the CheckoutPage
	}

	// Method to remove a product from the cart
	public void removeProductFromCart() throws Exception {
		util.waitForElementToBeClickable(driver, deleteFromCartButton, 10);
		Thread.sleep(3000);
		deleteFromCartButton.click();
	}

	// Method to get the product title in the cart
	public String getCartProductTitle() throws Exception {
		Thread.sleep(5000);
		//Wait until the product title in the cart becomes visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cartProductTitle));
		return cartProductTitle.getText();
	}
}
