package com.crm.qa.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.crm.qa.base.BasePage;

public class WebDriverUtils {
	
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(BasePage.class.getName());
	
	private static ThreadLocal <WebDriver> driver = new ThreadLocal();
	public static Properties prop;
	public final static int MAXWAITTIME = 30;
	public static long PAGE_LOAD_TIMEOUT = 120;
	/**
	 * get webdriver
	 * @return
	 */
	public WebDriver getDriver() {
			return driver.get();
	}
	
	/*
	 * Web driver initialization
	 */
	
	public void initialization() {
		prop = PropertyReader.propertyReader();
		log.debug("Initialization of driver started...");
		String browserName = prop.getProperty("browser");
		log.info("Browser is ====" + browserName);
		
		switch (browserName) {
		case "chrome":
			//Create a instance of ChromeOptions class
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			log.info("Creating chrome driver instance...");
			System.setProperty("webdriver.chrome.driver", "C:\\standalone\\chromedriver_win32 (4)\\chromedriver.exe");
			driver.set( new ChromeDriver(options));
			log.info("Chrome driver instance is created");
			break;
		default:
			log.info("No Browser found....");
			WebDriver driver = new ChromeDriver();
			
		}

		driver.get().manage().window().maximize();
		driver.get().manage().deleteAllCookies();
		driver.get().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		log.info("Opening URL === " + prop.getProperty("url"));
		driver.get().get(prop.getProperty("url"));
	}

}
