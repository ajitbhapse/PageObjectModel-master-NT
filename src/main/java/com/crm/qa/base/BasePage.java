package com.crm.qa.base;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public WebDriver driver;
	private WebDriverWait webDriverWait;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(xpath = "//div[@class='appLauncher slds-context-bar__icon-action']//child::button")
	public WebElement btnGlobalAppLauncher;

	@FindBy(xpath = "//one-app-launcher-menu//*[contains(@placeholder,'Search')]")
	public WebElement inputAppModalSearch;

	@FindBy(css="[class*='profileTrigger']")
	public WebElement UserImage;
	
	/**
	 * Wait till element is clickable.
	 * @param elem
	 */
	public void waitTillElementIsClickable(WebElement elem) {
		webDriverWait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(elem)));
	}
	
	
	/**
	 * wait till element is visible
	 */
	
	public void waitTillElementIsVisible(WebElement elem) {
		webDriverWait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(elem)));
	}
	
	/**
	 * click on webElement
	 */
	
	public void click(WebElement elem) {
		elem.click();
	}
	
	/**
	 * js click method 
	 * @param element
	 */
	public void jsClick(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	/**
	 * submit on webElement
	 */
	
	public void submit(WebElement elem) {
		elem.submit();
	}
	
	
	/**
	 * enter text in textbox
	 */
	
	public void sendKeys(WebElement elem,String value) {
		elem.clear();
		elem.sendKeys(value);
	}
	/**
	 * generate dynamic x-path
	 * @param xpath
	 * @param dynamicValues
	 * @return
	 */
	public String generateDynamicXPath(String xpath, String dynamicValues) {
		Integer count = 1;
		for (String value : dynamicValues.split(";")) {
			xpath = xpath.replace("{PARAM" + count.toString() + "}", value);
			count++;
		}
		return xpath;
	}
	
	
	 
	 /**
	  * method to select items from drop down
	  * @param menuItems
	  * @param value
	  */
	 public void selectOption(List<WebElement> menuItems,String value) {
			for (WebElement webElement : menuItems) {
				if(webElement.getAttribute("title").equals(value)) {
					click(webElement);
					break;
				}
			}
		}
	 
	 /**
	  * method to wait for home page till load
	  * @throws Exception
	  */
	 public void waitForUserHomePageToLoad(){
			waitTillElementIsVisible(UserImage);
			waitTillElementIsClickable(UserImage);
			
		}
}
