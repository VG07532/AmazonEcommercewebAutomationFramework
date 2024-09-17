package com.AmazonAutomationProject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AmazonAutomationProject.genericUtility.BaseClass;
import com.AmazonAutomationProject.objectRepository.CartPage;
import com.AmazonAutomationProject.objectRepository.CheckoutPage;
import com.AmazonAutomationProject.objectRepository.HomePage;
import com.AmazonAutomationProject.objectRepository.ModifiedCartPage;
import com.AmazonAutomationProject.objectRepository.ProductDetailsPage;
import com.AmazonAutomationProject.objectRepository.SearchResultsPage;

public class AddProductToCartTest extends BaseClass {

    @Test
    public void verifyAddToCart() throws Exception {
        // Step 1: Search for a product
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForProduct("mobile");

        // Step 2: Click on the first search result
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResult();

        // Step 3: Add the product to the cart
        CartPage cartPage = productDetailsPage.addToCart();

        // Step 4: Verify the product is added to the cart
        String cartProductTitle = cartPage.getCartProductTitle();
        //ModifiedCartPage modifiedCartPage= cartPage.clickOnGoToCart();
        String productTitle = productDetailsPage.getProductTitle();
        //CheckoutPage checkoutPage= modifiedCartPage.clickOnProceedToCheckoutButton();
        Assert.assertEquals(cartProductTitle, productTitle, "The product should be added to the cart.");
    }
    
}
