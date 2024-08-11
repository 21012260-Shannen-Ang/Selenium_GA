package com.sddevops.selenium_GA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class NewTest {

	private WebDriver webDriver;

	@Test
	public void findById() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/Fresh-Mart-project/Contact.jsp");

		// Find WebElement by Id: contact
		WebElement we = webDriver.findElement(By.id("contact"));

		// Get attribute app-id of WebElement
		System.out.println("id we: " + we.getAttribute("id"));

		// AssertEquals that WebElement’s id attribute is Equals to contact
		Assert.assertEquals(we.getAttribute("id"), "contact");
	}

	@Test
	public void checkTitle() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/Fresh-Mart-project/");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Fresh Mart");

		System.out.println("title: " + webDriver.getTitle());

	}

	@Test
	public void checkNavigationForAcrossPages() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/Fresh-Mart-project/Product.jsp");

		WebElement products_menu_item = webDriver.findElement(By.linkText("Products"));

		products_menu_item.click();

		// Ask Webdriver to wait 5 second (use the code below)
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement promoElement = webDriver.findElement(By.id("promo"));

		// Get attribute id of WebElement
		System.out.println("id we: " + promoElement.getAttribute("id"));

		Assert.assertEquals(promoElement.getAttribute("id"), "promo");

	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Users\\Shannen\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.close();
	}
}
