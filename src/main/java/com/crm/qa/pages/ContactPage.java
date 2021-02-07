package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BasePage;

public class ContactPage extends BasePage{
	
	public ContactPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Salutation']/ancestor::span/following-sibling::div")
	private WebElement lblSalutaion;

	@FindBy(xpath="//a[@role='menuitemradio']")
	private List<WebElement> menuItems;
	
	@FindBy(xpath="//span[text()='First Name']/parent::label/following-sibling::input")
	private WebElement firstName;
	
	@FindBy(xpath ="//span[text()='Last Name']/parent::label/following-sibling::input")
	private WebElement lastName;
	
	@FindBy(xpath="//span[text()='Birthdate']/parent::label/following-sibling::div/input")
	private WebElement birthdate;
	
	@FindBy(xpath="//button[@title='Save']")
	private WebElement btnSave;
	
	@FindBy(xpath="//div[text()='Add to Campaign']/ancestor::li/preceding-sibling::li//div[text()='New']")
	private WebElement btnNew;
	
	/**
	 * method to select salution 
	 * @param salutaion
	 */
	public ContactPage enterSalution(String salutaion) {
		waitTillElementIsVisible(lblSalutaion);
		waitTillElementIsClickable(lblSalutaion);
		click(lblSalutaion);
		selectOption(menuItems,salutaion);
		return PageFactory.initElements(driver, ContactPage.class);
	}
	/**
	 * method to enter first name
	 */
	public ContactPage enterFirstName(String fName) {
		waitTillElementIsVisible(firstName);
		waitTillElementIsClickable(firstName);
		sendKeys(firstName, fName);
		return PageFactory.initElements(driver, ContactPage.class);
	}
	
	public ContactPage enterLastName(String lName) {
		waitTillElementIsVisible(lastName);
		waitTillElementIsClickable(lastName);
		sendKeys(lastName, lName);
		return PageFactory.initElements(driver, ContactPage.class);
	}
	
	public ContactPage enterBirthDate(String DOB) {
		waitTillElementIsVisible(birthdate);
		waitTillElementIsClickable(birthdate);
		sendKeys(birthdate, DOB);
		return PageFactory.initElements(driver, ContactPage.class);
	}
	
	/**
	 * click on save button 
	 */
	public ContactPage clickSave() {
		waitTillElementIsClickable(btnSave);
		click(btnSave);
		return PageFactory.initElements(driver, ContactPage.class);
	}
	
	/**
	 * method to click on new button
	 */
	public ContactPage clickBtnNew() {
		waitTillElementIsVisible(btnNew);
		waitTillElementIsClickable(btnNew);
		click(btnNew);
		return PageFactory.initElements(driver, ContactPage.class);
	}
	
}
