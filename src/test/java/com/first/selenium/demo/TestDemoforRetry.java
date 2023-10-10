package com.first.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemoforRetry

{
	WebDriver driver;

	@BeforeMethod
	public void setup()

	{
		// System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		// ChromeOptions chrome = new ChromeOptions();
		// chrome.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");
		/// driver = new ChromeDriver();

		// driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.get("https://captcha.com/demos/features/captcha-demo.aspx");
		// System.out.println("Title of the page: " + driver.getTitle());
		/// Use WebDriverManager to manage ChromeDriver

		// /// below is the automatic process for driver update
		WebDriverManager.chromedriver().setup();
		//
		// // Create a WebDriver instance for Chrome
		driver = new ChromeDriver();
		//
		// // Perform your Selenium tests
		driver.get("https://www.example.com");
		// System.out.println("Title of the page: " + driver.getTitle());

	}

	@Test(retryAnalyzer = Retry.class)
	public void test()

	{
		Assert.assertTrue(true);
	}

}
