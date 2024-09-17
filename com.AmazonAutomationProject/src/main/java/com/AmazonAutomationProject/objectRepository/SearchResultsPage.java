package com.AmazonAutomationProject.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomationProject.genericUtility.BaseClass;

import java.util.List;

public class SearchResultsPage extends BasePage {

    // Locators for search result items
    //@FindBy(css = ".s-result-item")  // Search result item selector
	//@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']")
	
	//@FindBy(xpath="//div[contains(@class, 's-result-item') and @data-component-type='s-search-result']")
	@FindBy(xpath="//div[@data-cy='title-recipe']/h2/a")
    List<WebElement> searchResults;

    // Constructor initializes the elements on the search results page
    public SearchResultsPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    // Method to get the number of search results displayed
    public int getSearchResultsCount() throws Exception {
        //util.waitForElementToBeClickable(driver, searchResults.get(0), 10);
        Thread.sleep(3000);
        return searchResults.size();
    }

    // Method to click on the first search result
    public ProductDetailsPage clickFirstResult() throws Exception {
        Thread.sleep(3000);
        searchResults.get(0).click();
        return new ProductDetailsPage(driver);  // Navigate to the ProductDetailsPage
    }
}
