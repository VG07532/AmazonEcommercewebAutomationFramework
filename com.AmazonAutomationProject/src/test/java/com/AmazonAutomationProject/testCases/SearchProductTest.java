package com.AmazonAutomationProject.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AmazonAutomationProject.genericUtility.BaseClass;
import com.AmazonAutomationProject.objectRepository.HomePage;
import com.AmazonAutomationProject.objectRepository.SearchResultsPage;

public class SearchProductTest extends BaseClass {


    @Test
    public void verifySearchProduct() throws Exception {
    	
        // Step 1: Navigate to HomePage and search for a product
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForProduct("Mobile");

        // Step 2: Validate that search results are displayed
        int resultCount = searchResultsPage.getSearchResultsCount();
        Assert.assertTrue(resultCount > 0, "Search results should be displayed.");
        
    }
    
}
