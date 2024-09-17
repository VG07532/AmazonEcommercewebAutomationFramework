package com.AmazonAutomationProject.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomationProject.genericUtility.BaseClass;

public class ProductDetailsPage extends BasePage {

    // Locators for product details elements
    @FindBy(id = "productTitle")  // Product title
    WebElement productTitle;

    @FindBy(id = "priceblock_ourprice")  // Product price
    WebElement productPrice;

    //@FindBy(id = "add-to-cart-button")  // Add to Cart button
    //@FindBy(xpath = "//div[@class='a-button-stack']/span[@id='atc-declarative']/span/span/input[@id='add-to-cart-button' and @type='submit']")
   //@FindBy(xpath="//input[@id='add-to-cart-button' and @type='submit']")
    @FindBy(xpath = "//div[@id='a-page']//input[@id='add-to-cart-button' and @type='submit']")
    WebElement addToCartButton;

    @FindBy(id = "buy-now-button")  // Buy Now button
    WebElement buyNowButton;

    // Constructor initializes the elements on the product details page
    public ProductDetailsPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to add the product to the cart
    public CartPage addToCart() throws Exception {
    	util.scrollToElement(driver, 0, 400);
        util.waitForElementToBeClickable(driver, addToCartButton, 5);
    	util.waitForElementVisibility(driver, addToCartButton, 5);
        Thread.sleep(5000);
        addToCartButton.click();
        Thread.sleep(5000);
        return new CartPage(driver);  // After adding to the cart, navigate to CartPage
    }
    
    public void checkAddToCartButton()
    {
    	boolean AddToCart=addToCartButton.isEnabled();
    	if(AddToCart==true)
    	{
    		System.out.println("button is enabled");
    	}
    }

	// Method to get the product title
    public String getProductTitle() {
        return productTitle.getText();
    }

    // Method to get the product price
    public String getProductPrice() {
        return productPrice.getText();
    }
}

