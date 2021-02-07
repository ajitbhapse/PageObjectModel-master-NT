package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class AccountPage extends BasePage{
	
	public AccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='New']")
	private WebElement btnNew;
	
	@FindBy(xpath="//span[text()='Account Name']/parent::label/following-sibling::input")
	private WebElement txtAccountName;
	
	@FindBy(xpath="//span[text()='Type']/parent::span/following-sibling::div")
	private WebElement dropDownType;
	
	@FindBy (xpath="//span[text()='Rating']/parent::span/following-sibling::div")
	private WebElement dropDownRating;
	
	@FindBy(xpath="//a[@role='menuitemradio']")
	private List<WebElement> menuItems;
	
	@FindBy(xpath="//button[@title='Save']")
	private WebElement btnSave;
	
	@FindBy(xpath="//a[@data-label='Related']")
	private WebElement btnRelated;
	
	@FindBy(xpath="//a[contains(@href,'related/Contacts/view')]")
	private WebElement btnContacts;
	
	/**
	 * method to click on new button
	 */
	public AccountPage clickBtnNew() {
		waitTillElementIsVisible(btnNew);
		waitTillElementIsClickable(btnNew);
		click(btnNew);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
	/**
	 * Method to enter account name 
	 */
	public AccountPage enterAccountName(String accountName) {
		waitTillElementIsVisible(txtAccountName);
		waitTillElementIsClickable(txtAccountName);
		sendKeys(txtAccountName, accountName);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
	/**
	 * method to select type
	 */
	public AccountPage selectType(String type) {
		waitTillElementIsVisible(dropDownType);
		waitTillElementIsClickable(dropDownType);
		click(dropDownType);
		selectOption(menuItems,type);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
	/**
	 * method to select rating
	 */
	public AccountPage selectRating(String rating) {
		waitTillElementIsVisible(dropDownRating);
		waitTillElementIsClickable(dropDownRating);
		click(dropDownRating);
		selectOption(menuItems,rating);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
	/**
	 * click on save button 
	 */
	public AccountPage clickSave() {
		waitTillElementIsClickable(btnSave);
		click(btnSave);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
	/**
	 * click on related Tab
	 */
	public AccountPage clickOnRelatedTab() {
		waitTillElementIsVisible(btnRelated);
		waitTillElementIsClickable(btnRelated);
		click(btnRelated);
		return PageFactory.initElements(driver, AccountPage.class);
	}
	
	/**
	 * method to click on contact tab
	 */
	public ContactPage clickOnContact() {
		waitTillElementIsVisible(btnContacts);
		waitTillElementIsClickable(btnContacts);
		jsClick(btnContacts);
		return PageFactory.initElements(driver, ContactPage.class);
	}
}

