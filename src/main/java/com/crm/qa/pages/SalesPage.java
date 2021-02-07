package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class SalesPage extends BasePage{

	public 	SalesPage (WebDriver driver) { 
		 super(driver);
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@one-appnavbar_appnavbar]//one-app-nav-bar-item-root[@data-id='Account']")
	private WebElement lblAccount;
	
	/**
	 * method to select any options from sales page. i.e account,opportunities  
	 */
	
	public AccountPage clickOnSubMenu(String subMenu) {
		waitTillElementIsVisible(lblAccount);
		waitTillElementIsClickable(lblAccount);
		click(lblAccount);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
}
