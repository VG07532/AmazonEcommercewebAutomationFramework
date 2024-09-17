package com.AmazonAutomationProject.genericUtility;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility {


	/**
	 * this is a generic method to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * this is generic method to use implicit wait
	 * 
	 * @param driver
	 * @param num
	 */
	public void implicitWait(WebDriver driver,int num)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
	}
	

    // Wait for element to be clickable
	
    public void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for visibility of element
    
    public void waitForElementVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOf(element));
    }
    
 // Wait until the element is present in the DOM
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    //WebElement dynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamic-element-id")));

    // Now you can interact with the element
    //dynamicElement.click();

	
	//select class methods
	/**
	 * this is generic method to handle drop down with index number
	 * 
	 * @param element
	 * @param indexNum
	 */
	public void dropDownHandleByIndex(WebElement element,int indexNum)
	{
		Select s=new Select(element);
		s.selectByIndex(indexNum);
	}
	/**
	 * this is generic method to handle drop down with visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void dropDownHandleByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this is generic method to handle drop down with value
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDownHandleByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	
	public void dropDownDeselectByIndex(WebElement element,int indexNum)
	{
		Select s=new Select(element);
		s.deselectByIndex(indexNum);
	}
	/**
	 * this is generic method to deselect drop down with visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void dropDownDeselectByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
	/**
	 * this is generic method to deselect drop down with value
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDownDeselectByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	
	//Actions class methods to perform mouse action
	
	public void performMouseAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.perform();
	}
	
	public void moveTowardsElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
	
	public void scrollTowardsAnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element);
	}
	
	public void scrollTowardsAnElement(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src,target);
	}
	
	public void scrollTowardsAnElement(WebDriver driver,WebElement src,int x,int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(src,x,y);
	}
	
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	
	//Alert popup generic methods
	/**
	 * this method will help to access the alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 *  this method will help to dismiss the alert
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will help to fetch alert msg
	 * @param driver
	 * @return
	 */
	public String handleAlert(WebDriver driver)
	{
		String alertMsg=driver.switchTo().alert().getText();
		return alertMsg;
	}
	
	//frame handling methods
	
	public void handleFrameIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void handleFrameWebElement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void parentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void captureScreenshot(WebDriver driver, String testCaseName) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenshotFolder\\" + testCaseName +".png");
		Files.copy(src, dest);
	}
	
	public void scrollToElement(WebDriver driver,int x,int y) {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        // Scroll to the element
	        jsExecutor.executeScript("window.scrollBy(arguments[0],arguments[1]);", x, y);
	    }

}
