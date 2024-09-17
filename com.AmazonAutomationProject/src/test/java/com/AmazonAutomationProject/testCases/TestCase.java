package com.AmazonAutomationProject.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.AmazonAutomationProject.genericUtility.BaseClass;
import com.AmazonAutomationProject.objectRepository.CartPage;
import com.AmazonAutomationProject.objectRepository.HomePage;
import com.AmazonAutomationProject.objectRepository.ProductDetailsPage;
import com.AmazonAutomationProject.objectRepository.SearchResultsPage;

public class TestCase extends BaseClass {

    @Test
    public void verifyTestAddToCart() throws Exception {
        // Step 1: Search for a product
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForProduct("trimmer");

        // Step 2: Click on the first search result
        ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResult();
        
        Thread.sleep(5000);
        //System.out.println(driver.getPageSource());
        //WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']/following-sibling::span[@id='submit.add-to-cart-announce']"));
        //System.out.println(addToCartButton.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        WebElement visibleButton = (WebElement) js.executeScript(
            "return document.querySelector('#add-to-cart-button:not([style*=\"display:none\"])')");
        visibleButton.click();

        // Step 3: Add the product to the cart
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Scroll to the element before clicking (helps with dynamic content)
//        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        // Wait until the element is clickable and then click
        //wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

        // Step 4: Wait for and click the 'Proceed to Checkout' button
        //WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proceed-to-checkout-button")));
        //wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }
}
