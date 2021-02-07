package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="username")
	private WebElement txtUserName;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy (id ="Login")
	private WebElement btnLogin;
	
	public String xpathAppLaunchMenuLink = "//one-app-launcher-menu//a[@data-label='{PARAM1}']";
	/**
	 * enter email address
	 * @param emailAddress
	 */
	public LoginPage enterEmailAddress(String emailAddress) {
		sendKeys(txtUserName, emailAddress);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	/**
	 * enter email address
	 * @param emailAddress
	 */
	public LoginPage enterPassword(String password) {
		sendKeys(txtPassword, password);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	/**
	 * Click on login button
	 */
	public LoginPage clickBtnLogin() {
		submit(btnLogin);
		waitForUserHomePageToLoad();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	/**
	 * method to navigate menu
	 * @param menuName
	 * @return
	 * @throws Exception
	 */
	 public SalesPage navigateToGivenMenuItem(String menuName){
	    	//Switch to default content to make sure test case don't fail
		 	driver.switchTo().defaultContent();    	
	    	waitTillElementIsVisible(btnGlobalAppLauncher);
	    	waitTillElementIsClickable(btnGlobalAppLauncher);
	        jsClick(btnGlobalAppLauncher);
	        waitTillElementIsVisible(inputAppModalSearch);
	        waitTillElementIsClickable(inputAppModalSearch);
	        sendKeys(inputAppModalSearch, menuName);
	        String appLaunchMenu = generateDynamicXPath(xpathAppLaunchMenuLink, menuName);
			WebElement elem = driver.findElement(By.xpath(appLaunchMenu));
		    waitTillElementIsVisible(elem);
		    waitTillElementIsClickable(elem);
		    jsClick(elem);
		    return PageFactory.initElements(driver, SalesPage.class);
	    }
}
