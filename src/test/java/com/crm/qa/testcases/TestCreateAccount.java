package com.crm.qa.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.AccountPage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SalesPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverUtils;


public class TestCreateAccount {
	WebDriver driver;
	SalesPage salePage;
	AccountPage accountPage;
	ContactPage contactPage;
	
	@BeforeMethod
	public void setUp() {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initialization();
		driver = utils.getDriver();
		LoginPage loginPage = new LoginPage(driver);
		salePage = loginPage.enterEmailAddress(WebDriverUtils.prop.getProperty("username"))
				 			.enterPassword(WebDriverUtils.prop.getProperty("password"))
				 			.clickBtnLogin()
				 			.navigateToGivenMenuItem("Sales");
	}
	
	@Test
	public void testCreateAccountContact() {
		
		//read test case data
		Map<String,String>testdata = TestUtil.getTestData("TestSerachProduct.json", "testCreateAccountContact");
		
		//navigate to account tab
		accountPage = salePage.clickOnSubMenu(testdata.get("accountsTab"));
		
		//create new account and save
		contactPage = accountPage.clickBtnNew()
			   					 .enterAccountName(testdata.get("accountName"))
			   					 .selectType(testdata.get("type"))
			   					 .selectRating(testdata.get("rating"))
			   					 .clickSave()
			   					 .clickOnRelatedTab()
			   					 .clickOnContact();
		
		//create new contact for newly created account and save
		contactPage.clickBtnNew()
				   .enterSalution(testdata.get("salution"))
				   .enterFirstName(testdata.get("firstName"))
				   .enterLastName(testdata.get("lastName"))
				   .enterBirthDate(testdata.get("dateOfBirth"))
				   .clickSave();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

