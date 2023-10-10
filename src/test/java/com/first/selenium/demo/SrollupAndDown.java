package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SrollupAndDown

{
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");

		/// Priviusly I have did above but now useing below as mismatch chrome vertion and driver vertion
		/// as per google they proviing one chromme vertion for testing purpose.
		/// below is the step
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		/// below chromeOption step we used incase of test chrome used for automation testing scritpt
		ChromeOptions option = new ChromeOptions();
		option.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(1000);
	}

	@Test

	public void srollupdown() throws Exception {
		WebElement web = driver.findElement(By.xpath("//div/img[@class='appSprite icQRCode']"));
		Thread.sleep(4000);
		JavascriptExecutor jvs = (JavascriptExecutor) driver;
		// jvs.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(1000);
		// jvs.executeScript("window.scrollBy(0,-500)");

		// buton of the application defult process
		// jvs.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);

		// View the webelement scrollBy
		jvs.executeScript("arguments[0].scrollIntoView()", web);

	}

}
